package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import delegator.TrainingSessionDelegator;
import entities.TrainingSession;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TrainingSessionADD extends JFrame {

	private JPanel contentPane;
	private JTextField nameT;
	private JTextField DateT;
	private JTextField goalT;
	private JTextField coachT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingSessionADD frame = new TrainingSessionADD();
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
	public TrainingSessionADD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddTrainingSession = new JLabel("Add Training Session");
		lblAddTrainingSession.setForeground(Color.BLUE);
		lblAddTrainingSession.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddTrainingSession.setBounds(281, 27, 208, 49);
		contentPane.add(lblAddTrainingSession);
		
		nameT = new JTextField();
		nameT.setBounds(267, 161, 208, 42);
		contentPane.add(nameT);
		nameT.setColumns(10);
		
		DateT = new JTextField();
		DateT.setColumns(10);
		DateT.setBounds(267, 242, 208, 42);
		contentPane.add(DateT);
		
		goalT = new JTextField();
		goalT.setColumns(10);
		goalT.setBounds(267, 326, 208, 42);
		contentPane.add(goalT);
		
		coachT = new JTextField();
		coachT.setColumns(10);
		coachT.setBounds(267, 414, 208, 42);
		contentPane.add(coachT);
		
		JLabel lblSessonName = new JLabel("Sesson Name");
		lblSessonName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSessonName.setBounds(43, 175, 115, 32);
		contentPane.add(lblSessonName);
		
		JLabel lblTrainingDate = new JLabel("Training Date");
		lblTrainingDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTrainingDate.setBounds(43, 256, 115, 32);
		contentPane.add(lblTrainingDate);
		
		JLabel lblGoal = new JLabel("Training Goal");
		lblGoal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGoal.setBounds(43, 340, 115, 32);
		contentPane.add(lblGoal);
		
		JLabel lblCoachName = new JLabel("Coach Name\r\n");
		lblCoachName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCoachName.setBounds(43, 428, 115, 32);
		contentPane.add(lblCoachName);
		
		JButton btnAdd = new JButton("OK");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TrainingSession m =new TrainingSession();
				m.setSessionName(nameT.getText().toString());
				m.setGoal(goalT.getText().toString());
				m.setCoachName(coachT.getText().toString());
				m.setTrainingDate(DateT.getText().toString());
				TrainingSessionDelegator.ajoutersession(m);
			}
		});
		btnAdd.setBounds(634, 489, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				HumanRessource c = new HumanRessource();
				c.setVisible(true);
			}
		});
		label.setIcon(new ImageIcon(TrainingSessionADD.class.getResource("/img/icone-home-page.png")));
		label.setBounds(46, 26, 50, 50);
		contentPane.add(label);
	}
}
