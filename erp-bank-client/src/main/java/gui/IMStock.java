package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class IMStock extends JFrame {


	private JPanel contentPane;
	private JTable table;
	  public static final String VOICENAME="kevin16";


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IMStock frame = new IMStock();
					frame.setVisible(true);
					Voice v; 
					 System.setProperty("FreeTTSSynthEngineCentral", "com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
				        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
				        VoiceManager vm= VoiceManager.getInstance();
				        v=vm.getVoice(VOICENAME);
				v.allocate();
				v.speak("Stocks");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IMStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stocks");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(345, 40, 59, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Stocks :");
		lblNewLabel_1.setBounds(42, 117, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Delete stock");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(632, 165, 121, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update stock");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				IMStockUpdate frame1 = new IMStockUpdate();
				frame1.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(632, 214, 121, 31);
		contentPane.add(btnNewButton_2);
		
		JButton btnAddStock = new JButton("Add stock");
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				IMStockAdd frame1 = new IMStockAdd();
				frame1.setVisible(true);
				
			}
		});
		btnAddStock.setBounds(632, 117, 121, 31);
		contentPane.add(btnAddStock);
		
		table = new JTable();
		table.setBackground(Color.BLACK);
		table.setBounds(54, 337, 243, -163);
		contentPane.add(table);
		
		JButton btnCancel = new JButton("<-");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				IMHome frame1 = new IMHome();
				frame1.setVisible(true);
			}
		});
		btnCancel.setBounds(22, 23, 89, 31);
		contentPane.add(btnCancel);
	}
}
