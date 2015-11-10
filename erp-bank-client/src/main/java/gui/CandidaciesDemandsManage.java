package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import delegator.CandidaciesDelegator;
import delegator.CashierDelegate;
import delegator.GestionEmployeeDelegator;
import delegator.InventoryManagerDelegate;
import delegator.humanressourceDelegate;
import entities.CandidaciesDemands;
import entities.Cashier;
import entities.Employee;
import entities.HumanRessourceManager;
import entities.InventoryManager;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.BeanProperty;

import services.interfaces.Mail;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CandidaciesDemandsManage extends JFrame {

	private JPanel contentPane;
	List<CandidaciesDemands> candidacies;
	CandidaciesDemands cand;
	  public static final String VOICENAME="kevin16";

	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CandidaciesDemandsManage frame = new CandidaciesDemandsManage();
					frame.setVisible(true);
					Voice v; 
					 System.setProperty("FreeTTSSynthEngineCentral", "com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
				        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
				        VoiceManager vm= VoiceManager.getInstance();
				        v=vm.getVoice(VOICENAME);
				v.allocate();
				v.speak("Candidacies");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CandidaciesDemandsManage() {
		candidacies= new ArrayList<CandidaciesDemands>();
		candidacies=CandidaciesDelegator.findallCandidacies();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 160, 576, 352);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JLabel lblCandidacies = new JLabel("Candidacies");
		lblCandidacies.setForeground(Color.BLUE);
		lblCandidacies.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCandidacies.setBounds(349, 0, 135, 38);
		contentPane.add(lblCandidacies);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setIcon(new ImageIcon(CandidaciesDemandsManage.class.getResource("/img/256.png")));
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cand=candidacies.get(table.getSelectedRow());
				if (cand.getPoste().equals("InventoryManager"))
				{
					InventoryManager emp= new InventoryManager();
					emp.setAdress(cand.getAdress());
					emp.setBirthDate(cand.getBirthDate());
					emp.setCIN(cand.getCIN());
					emp.setKidsNumber(cand.getKidsNumber());
					emp.setCivilState(cand.getCivilState());
					emp.setFirstName(cand.getFirstname());
					emp.setLastName(cand.getLastname());
					emp.setSexe(cand.getSexe());
					emp.setEmail(cand.getEmail());
					Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

				    try {
						new Mail().sendSSLMessage(cand.getEmail(), "DreamBank","Congratulations ! your application has been accepted . Please drop by our offices as soon as you can.  ",
								"dreamteam2pidev@gmail.com");
					} catch (MessagingException a) {
						// TODO Auto-generated catch block
						a.printStackTrace();
					}
				    System.out.println("Sucessfully Sent mail to User");
					
					emp.setPhoneNumber(cand.getPhone());
					InventoryManagerDelegate.ajouterEmploye(emp);
					CandidaciesDelegator.decline(cand);
					candidacies.remove(cand);
					
					initDataBindings();
				}
				
				
				else if (cand.getPoste().equals("HumanRessourceManager"))
				{
					HumanRessourceManager emp= new HumanRessourceManager();
					emp.setAdress(cand.getAdress());
					emp.setBirthDate(cand.getBirthDate());
					emp.setCIN(cand.getCIN());
					emp.setKidsNumber(cand.getKidsNumber());
					emp.setCivilState(cand.getCivilState());
					emp.setFirstName(cand.getFirstname());
					emp.setLastName(cand.getLastname());
					emp.setSexe(cand.getSexe());
					emp.setEmail(cand.getEmail());
					Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

				    try {
						new Mail().sendSSLMessage(cand.getEmail(), "DreamBank","Congratulations ! your application has been accepted . Please drop by our offices as soon as you can.   ",
								"dreamteam2pidev@gmail.com");
					} catch (MessagingException a) {
						// TODO Auto-generated catch block
						a.printStackTrace();
					}
				    System.out.println("Sucessfully Sent mail");
					
					emp.setPhoneNumber(cand.getPhone());
					humanressourceDelegate.ajouterEmploye(emp);
					CandidaciesDelegator.decline(cand);
					candidacies.remove(cand);
					
					initDataBindings();

					
				}
				else if (cand.getPoste().equals("Provider"))
				{
					Cashier emp= new Cashier();
					emp.setAdress(cand.getAdress());
					emp.setBirthDate(cand.getBirthDate());
					emp.setCIN(cand.getCIN());
					emp.setKidsNumber(cand.getKidsNumber());
					emp.setCivilState(cand.getCivilState());
					emp.setFirstName(cand.getFirstname());
					emp.setLastName(cand.getLastname());
					emp.setSexe(cand.getSexe());
					emp.setEmail(cand.getEmail());
					Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

				    try {
						new Mail().sendSSLMessage(cand.getEmail(), "DreamBank","Congratulations ! your application has been accepted . Please drop by our offices as soon as you can.   ",
								"dreamteam2pidev@gmail.com");
					} catch (MessagingException a) {
						// TODO Auto-generated catch block
						a.printStackTrace();
					}
				    System.out.println("Sucessfully Sent mail ");
					
					emp.setPhoneNumber(cand.getPhone());
					CashierDelegate.ajoutercaissier(emp);
					CandidaciesDelegator.decline(cand);
					candidacies.remove(cand);
					
					initDataBindings();
					
				}
				
				

					
			
				}
				
			
		});
		btnAccept.setBounds(162, 91, 202, 58);
		contentPane.add(btnAccept);
		
		JButton btnDecline = new JButton("Decline");
		btnDecline.setIcon(new ImageIcon(CandidaciesDemandsManage.class.getResource("/img/Delete.png")));
		btnDecline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cand=candidacies.get(table.getSelectedRow());
				Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

			    try {
					new Mail().sendSSLMessage(cand.getEmail(), "DreamBank","Your request has been processed, we will notify you shortly. ",
							"dreamteam2pidev@gmail.com");
				} catch (MessagingException a) {
					// TODO Auto-generated catch block
					a.printStackTrace();
				}
			    System.out.println("Sucessfully Sent mail ");
				CandidaciesDelegator.decline(cand);
				
				candidacies.remove(cand);
				
				initDataBindings();
			}
		});
		btnDecline.setBounds(427, 89, 186, 58);
		contentPane.add(btnDecline);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				HumanRessource c = new HumanRessource();
				c.setVisible(true);
			}
		});
		label.setIcon(new ImageIcon(CandidaciesDemandsManage.class.getResource("/img/icone-home-page.png")));
		label.setBounds(32, 48, 50, 50);
		contentPane.add(label);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<CandidaciesDemands, List<CandidaciesDemands>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, candidacies, table, "Email");
		//
		BeanProperty<CandidaciesDemands, String> candidaciesDemandsBeanProperty = BeanProperty.create("email");
		jTableBinding.addColumnBinding(candidaciesDemandsBeanProperty).setColumnName("Phone");
		//
		BeanProperty<CandidaciesDemands, String> candidaciesDemandsBeanProperty_1 = BeanProperty.create("sexe");
		jTableBinding.addColumnBinding(candidaciesDemandsBeanProperty_1).setColumnName("Sexe");
		//
		BeanProperty<CandidaciesDemands, String> candidaciesDemandsBeanProperty_2 = BeanProperty.create("lastname");
		jTableBinding.addColumnBinding(candidaciesDemandsBeanProperty_2).setColumnName("LastName");
		//
		BeanProperty<CandidaciesDemands, String> candidaciesDemandsBeanProperty_3 = BeanProperty.create("firstname");
		jTableBinding.addColumnBinding(candidaciesDemandsBeanProperty_3).setColumnName("FirstName");
		//
		BeanProperty<CandidaciesDemands, String> candidaciesDemandsBeanProperty_4 = BeanProperty.create("CIN");
		jTableBinding.addColumnBinding(candidaciesDemandsBeanProperty_4).setColumnName("CIN");
		//
		jTableBinding.bind();
	}
}
