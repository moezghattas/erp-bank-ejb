package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class CallOffers extends JFrame {

	private JPanel contentPane;
	  public static final String VOICENAME="kevin16";


	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CallOffers frame = new CallOffers();
					frame.setVisible(true);
					Voice v; 
					 System.setProperty("FreeTTSSynthEngineCentral", "com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
				        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
				        VoiceManager vm= VoiceManager.getInstance();
				        v=vm.getVoice(VOICENAME);
				v.allocate();
				v.speak("call offers");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CallOffers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Call Offers");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(345, 40, 104, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Call Offers :");
		lblNewLabel_1.setBounds(42, 117, 98, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new java.awt.event.ActionListener() {
			
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				}
			});
		btnNewButton_1.setBounds(645, 165, 89, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(645, 214, 89, 31);
		contentPane.add(btnNewButton_2);
		
		JButton btnAddStock = new JButton("Add call offer");
		btnAddStock.setBounds(645, 117, 89, 31);
		contentPane.add(btnAddStock);
		
		table = new JTable();
		table.setBackground(Color.BLACK);
		table.setBounds(54, 337, 243, -163);
		contentPane.add(table);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new java.awt.event.ActionListener() {
			
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				}
			});
		btnCancel.setBounds(22, 23, 89, 31);
		contentPane.add(btnCancel);
	}
}
