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
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IMHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IMHome frame = new IMHome();
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
	public IMHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogOut = new JLabel("Log out");
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Identification frame1 = new Identification();
				frame1.setVisible(true);
			}
		});
		lblLogOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLogOut.setForeground(Color.BLUE);
		lblLogOut.setBounds(751, 11, 46, 14);
		contentPane.add(lblLogOut);
		
		JLabel lblNewLabel = new JLabel("Hello");
		lblNewLabel.setBounds(630, 12, 32, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Foulen Fouleni");
		lblNewLabel_1.setBounds(665, 12, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton button = new JButton("Statistics");
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(283, 266, 249, 128);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Stock");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				IMStock frame1 = new IMStock();
				frame1.setVisible(true);
			}
		});
		button_1.setBounds(134, 105, 249, 128);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Call Offers");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(433, 105, 249, 128);
		contentPane.add(button_2);
		
		JLabel lblNewLabel_2 = new JLabel("Please choose your action :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(149, 55, 396, 14);
		contentPane.add(lblNewLabel_2);
	}

}
