package com.tpete.client.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tpete.client.data.Data;
import com.tpete.client.model.Adresse;
import com.tpete.client.model.Client;
import com.tpete.client.model.Commande;
import com.tpete.client.model.Facture;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.util.List;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrderNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setTitle("TPEte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 894, 515);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtOrderNo = new JTextField();
		txtOrderNo.setFont(new Font("Georgia", Font.BOLD, 15));
		txtOrderNo.setBounds(536, 409, 149, 34);
		contentPane.add(txtOrderNo);
		txtOrderNo.setColumns(10);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int orderId = Integer.parseInt(txtOrderNo.getText());
				
				Client client = getClientsOrder(orderId);
				
				JOptionPane diglog = new JOptionPane();	
				//diglog.setBounds(725, 407, 539, 135);
				diglog.setFont(new Font("Cambria", Font.BOLD, 17));
				
				String orders = "Client : ";
				
				if(client != null)
				{
					orders += client.getNom() +" "+client.getPrenom()+"\n";
					
					for(Facture facture : client.getFactures())
					{
						if(facture != null)
						{
							orders += "	Facture : "+facture.getNumero()+"\n";
									
							for(Commande commande : facture.getCommandes())
							{
								orders += "		Id : "+commande.getNumero()+", Amount : "+commande.getMontant()+"\n";
							}
						}
					}
				}				
				diglog.showMessageDialog(null, orders);
			}
		});
		btnShow.setFont(new Font("Cambria", Font.BOLD, 17));
		btnShow.setBounds(725, 407, 139, 35);
		contentPane.add(btnShow);
		
		JLabel lblOrderNo = new JLabel("Enter Order No :");
		lblOrderNo.setFont(new Font("Cambria", Font.BOLD, 17));
		lblOrderNo.setBounds(362, 404, 162, 41);
		contentPane.add(lblOrderNo);
		
		JLabel lblClients = new JLabel("Select any client from the dropdown list: ");
		lblClients.setFont(new Font("Cambria", Font.BOLD, 17));
		lblClients.setBounds(27, 13, 323, 41);
		contentPane.add(lblClients);
		
		JComboBox comboClients = new JComboBox();
		
		JTextArea textAreaAddress = new JTextArea();
		textAreaAddress.setBounds(362, 52, 502, 135);
		textAreaAddress.setFont(new Font("Cambria", Font.BOLD, 15));
		contentPane.add(textAreaAddress);
		
		JTextArea textAreaInvoice = new JTextArea();
		textAreaInvoice.setBounds(362, 239, 502, 127);
		textAreaInvoice.setFont(new Font("Cambria", Font.BOLD, 15));
		contentPane.add(textAreaInvoice);
		
		comboClients.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				if(arg0.getStateChange() == ItemEvent.SELECTED)
				{
					if(!comboClients.getSelectedItem().toString().equals("Select Client"))
					{
						String selectedName = comboClients.getSelectedItem().toString();
						
						selectedName = (selectedName.split(" ")[0]).trim();
						Client client = getClientAddressesAndInvoices(selectedName);
						String address = "";
								
						for(Adresse adresse : client.getAdresses())
						{
							address += adresse.getRue()+", "+adresse.getNPA()+"\n";
						}
						textAreaAddress.setText(address);					

						String invoice = "";
						
						for(Facture facture : client.getFactures())
						{
							invoice += facture.getNumero()+"\n";
						}
						textAreaInvoice.setText(invoice);					
					}
				}
			}
		});
		
		comboClients.setFont(new Font("Cambria", Font.BOLD, 17));
		comboClients.setBounds(27, 74, 297, 32);
		
		comboClients.addItem("Select Client");		
		List<Client> clients = getClients();		
		for (Client client : clients) 
		{
			comboClients.addItem(client.getNom() +" "+ client.getPrenom());
		}
		
		contentPane.add(comboClients);		
		
		JLabel lblClientAddress = new JLabel("Client Address :");
		lblClientAddress.setBackground(new Color(255, 255, 204));
		lblClientAddress.setVerticalAlignment(SwingConstants.TOP);
		lblClientAddress.setFont(new Font("Cambria", Font.BOLD, 15));
		lblClientAddress.setBounds(362, 25, 116, 32);
		contentPane.add(lblClientAddress);
		
		JLabel lblNewLabel = new JLabel("Client Invoice : ");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel.setBounds(362, 200, 124, 26);
		contentPane.add(lblNewLabel);		
	}
	
	private List<Client> getClients()
	{
		Data data = new Data();
		return data.getClients();
	}
	
	private Client getClientAddressesAndInvoices(String nom)
	{		
		Data data = new Data();
		return data.getClient(nom);
	}
	
	private Client getClientsOrder(int numero)
	{
		Data data = new Data();
		return data.getClient(numero);
	}
	
	/*private List<Client> getClients()
	{
		RestFulClient restFulClient = new RestFulClient();
		return restFulClient.getAllClients().getListClients();
	}
	
	private Client getClientAddressesAndInvoices(String nom)
	{
		RestFulClient restFulClient = new RestFulClient();
		return restFulClient.findByClientName(nom);
	}
	
	private Client getClientsOrder(int numero)
	{
		RestFulClient restFulClient = new RestFulClient();    
		return restFulClient.findByOrderId(numero);
	}*/
}
