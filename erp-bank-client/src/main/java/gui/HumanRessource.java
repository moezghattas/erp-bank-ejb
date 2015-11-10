package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HumanRessource extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static HumanRessource frame = new HumanRessource();
	  public static final String VOICENAME="kevin16";


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voice v; 
					 System.setProperty("FreeTTSSynthEngineCentral", "com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
				        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
				        VoiceManager vm= VoiceManager.getInstance();
				        v=vm.getVoice(VOICENAME);
				v.allocate();
				v.speak("human ressource");
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
	public HumanRessource() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
		getContentPane().setBackground(Color.GRAY);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblHumanRessource = new JLabel("Human Ressource");
		lblHumanRessource.setBounds(235, 28, 299, 79);
		lblHumanRessource.setHorizontalAlignment(SwingConstants.CENTER);
		lblHumanRessource.setForeground(Color.BLUE);
		lblHumanRessource.setFont(new Font("Times New Roman", Font.BOLD, 21));
		getContentPane().add(lblHumanRessource);
		
		JButton button = new JButton("Training Session");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TrainingSessionM M = new TrainingSessionM();
				M.setVisible(true);
				setVisible(false);
				
			}
		});
		button.setBounds(235, 296, 277, 68);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Employees");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ManageEmployees frame1 = new ManageEmployees();

			setVisible(false);
				frame1.setVisible(true);
			}
		});
		
		button_1.setBounds(233, 163, 279, 68);
		getContentPane().add(button_1);
		
		JButton btnCandidaciesDemands = new JButton("Candidacies Demands\r\n");
		btnCandidaciesDemands.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CandidaciesDemandsManage a = new CandidaciesDemandsManage();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnCandidaciesDemands.setBounds(235, 431, 277, 68);
		contentPane.add(btnCandidaciesDemands);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 601);
	
	}
}
