package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import delegator.GestionEmployeeDelegator;
import delegator.TrainingSessionDelegator;
import entities.Employee;
import entities.TrainingSession;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.BeanProperty;

import java.util.Date;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class TrainingSessionM extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List<TrainingSession> trainingsessions;
	TrainingSession t;
	  public static final String VOICENAME="kevin16";



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingSessionM frame = new TrainingSessionM();
					frame.setVisible(true);
					Voice v; 
					 System.setProperty("FreeTTSSynthEngineCentral", "com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
				        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
				        VoiceManager vm= VoiceManager.getInstance();
				        v=vm.getVoice(VOICENAME);
				v.allocate();
				v.speak("Training Session");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TrainingSessionM() {
		trainingsessions= new ArrayList<TrainingSession>();
		trainingsessions=TrainingSessionDelegator.findAllTrainingsession();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 66, 530, 381);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TrainingSessionADD c = new TrainingSessionADD();
				c.setVisible(true);
				setVisible(false);
				
			}
		});
		btnAdd.setBounds(635, 95, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t=trainingsessions.get(table.getSelectedRow());
	
				TrainingSessionDelegator.updatesession(t);
				trainingsessions=TrainingSessionDelegator.findAllTrainingsession();
				initDataBindings();
				
			}
		});
		btnUpdate.setBounds(635, 189, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t=trainingsessions.get(table.getSelectedRow());
				TrainingSessionDelegator.deletesession(t);
				trainingsessions.remove(t);
				
				initDataBindings();
			}
		});
		btnDelete.setBounds(635, 283, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				HumanRessource c = new HumanRessource();
				c.setVisible(true);
			}
		});
		label.setIcon(new ImageIcon(TrainingSessionM.class.getResource("/img/icone-home-page.png")));
		label.setBounds(10, 5, 50, 50);
		contentPane.add(label);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<TrainingSession, List<TrainingSession>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, trainingsessions, table);
		//
		BeanProperty<TrainingSession, String> trainingSessionBeanProperty = BeanProperty.create("coachName");
		jTableBinding.addColumnBinding(trainingSessionBeanProperty).setColumnName("CoachName");
		//
		BeanProperty<TrainingSession, String> trainingSessionBeanProperty_1 = BeanProperty.create("trainingDate");
		jTableBinding.addColumnBinding(trainingSessionBeanProperty_1).setColumnName("Date");
		//
		BeanProperty<TrainingSession, String> trainingSessionBeanProperty_2 = BeanProperty.create("sessionName");
		jTableBinding.addColumnBinding(trainingSessionBeanProperty_2).setColumnName("SessionName");
		//
		BeanProperty<TrainingSession, String> trainingSessionBeanProperty_3 = BeanProperty.create("goal");
		jTableBinding.addColumnBinding(trainingSessionBeanProperty_3).setColumnName("Goal");
		//
		jTableBinding.bind();
	}
}
