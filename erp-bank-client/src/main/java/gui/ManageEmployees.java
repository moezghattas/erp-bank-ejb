package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import services.interfaces.Mail;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import delegator.GestionEmployeeDelegator;
import entities.Employee;

import java.security.Security;

import javax.swing.ImageIcon;

public class ManageEmployees extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	List<Employee> employees;
	Employee emp;
	private JButton btnUpdate;
	private JTextField adress;
	private JTextField cin;
	private JTextField phone;
	private JTextField name;
	private JTextField lastname;
	private JTextField pseudo;
	private JTextField password;
	private JTextField kids;
	private JTextField civil;
	private JTextField birth;
	private JTextField mail;
	private JLabel lblMail;
	private JButton btnUp;
	private JTable table;
	  public static final String VOICENAME="kevin16";
	  private JLabel label;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageEmployees frame = new ManageEmployees();
					frame.setVisible(true);
					Voice v; 
					 System.setProperty("FreeTTSSynthEngineCentral", "com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
				        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
				        VoiceManager vm= VoiceManager.getInstance();
				        v=vm.getVoice(VOICENAME);
				v.allocate();
				v.speak("Employees");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageEmployees() {
		employees= new ArrayList<Employee>();
		employees=GestionEmployeeDelegator.findAllEmployee();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.setBounds(662, 67, 105, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				emp=employees.get(table.getSelectedRow());
				GestionEmployeeDelegator.supprimerEmploye(emp);
				employees.remove(emp);
				
				initDataBindings();
			}
		});
		
		btnUp = new JButton("update");
		btnUp.setBounds(662, 128, 105, 23);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				emp=employees.get(table.getSelectedRow());
				emp.setAdress(adress.getText().toString());
				emp.setBirthDate(birth.getText().toString());
				emp.setCIN(cin.getText());
				emp.setCivilState(civil.getText().toString());
				emp.setEmail(mail.getText().toString());
				emp.setKidsNumber(Integer.parseInt(kids.getText()));
				emp.setLastName(lastname.getText().toString());
				emp.setFirstName(name.getText().toString());
				emp.setPassword(password.getText().toString());
				emp.setPhoneNumber(phone.getText());
				emp.setEmail(pseudo.getText().toString());
				GestionEmployeeDelegator.editemployee(emp);
				employees=GestionEmployeeDelegator.findAllEmployee();
				initDataBindings();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnUp);
		contentPane.add(btnDelete);
		
		adress = new JTextField();
		adress.setBounds(135, 352, 86, 20);
		contentPane.add(adress);
		adress.setColumns(10);
		
		cin = new JTextField();
		cin.setBounds(135, 402, 86, 20);
		contentPane.add(cin);
		cin.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(135, 455, 86, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		name = new JTextField();
		name.setBounds(135, 515, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		lastname = new JTextField();
		lastname.setBounds(348, 352, 86, 20);
		contentPane.add(lastname);
		lastname.setColumns(10);
		
		pseudo = new JTextField();
		pseudo.setBounds(348, 402, 86, 20);
		contentPane.add(pseudo);
		pseudo.setColumns(10);
		
		password = new JTextField();
		password.setBounds(348, 455, 86, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		kids = new JTextField();
		kids.setBounds(539, 402, 86, 20);
		contentPane.add(kids);
		kids.setColumns(10);
		
		civil = new JTextField();
		civil.setBounds(539, 352, 86, 20);
		contentPane.add(civil);
		civil.setColumns(10);
		
		birth = new JTextField();
		birth.setBounds(348, 515, 86, 20);
		contentPane.add(birth);
		birth.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("adress");
		lblNewLabel.setBounds(153, 327, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("cin");
		lblNewLabel_1.setBounds(135, 377, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setBounds(135, 430, 46, 14);
		contentPane.add(lblPhone);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(135, 490, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblLastName = new JLabel("last name");
		lblLastName.setBounds(368, 327, 71, 14);
		contentPane.add(lblLastName);
		
		JLabel lblNewLabel_2 = new JLabel("pseudo");
		lblNewLabel_2.setBounds(348, 383, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(348, 433, 112, 14);
		contentPane.add(lblPassword);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setBounds(348, 490, 73, 14);
		contentPane.add(lblBirthday);
		
		JLabel lblCivilState = new JLabel("civil state");
		lblCivilState.setBounds(559, 327, 59, 14);
		contentPane.add(lblCivilState);
		
		JLabel lblKidsNumber = new JLabel("Kids number");
		lblKidsNumber.setBounds(539, 383, 86, 14);
		contentPane.add(lblKidsNumber);
		mail = new JTextField();
		mail.setBounds(539, 455, 86, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		lblMail = new JLabel("Mail");
		lblMail.setBounds(539, 430, 46, 14);
		contentPane.add(lblMail);
		civil.setVisible(false);
		birth.setVisible(false);
		adress.setVisible(false);
		kids.setVisible(false);
		phone.setVisible(false);
		name.setVisible(false);
		lastname.setVisible(false);
		pseudo.setVisible(false);
		password.setVisible(false);
		cin.setVisible(false);
		mail.setVisible(false);
		lblBirthday.setVisible(false);
		lblCivilState.setVisible(false);
		lblKidsNumber.setVisible(false);
		lblLastName.setVisible(false);
		lblName.setVisible(false);
		lblPassword.setVisible(false);
		lblPhone.setVisible(false);
		lblNewLabel_1.setVisible(false);
		lblNewLabel_2.setVisible(false);
		lblMail.setVisible(false);
		lblNewLabel.setVisible(false);
		
		btnUpdate = new JButton("");
		btnUpdate.setBounds(412, 67, 105, 23);
		btnUpdate.setEnabled(false);
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				emp=employees.get(table.getSelectedRow());
				civil.setText(emp.getCivilState());
				birth.setText(emp.getBirthDate());
				adress.setText(emp.getAdress());
				kids.setText(""+emp.getKidsNumber());
				phone.setText(""+emp.getPhoneNumber());
				name.setText(emp.getFirstName());
				lastname.setText(emp.getLastName());
				pseudo.setText(emp.getEmail());
				password.setText(emp.getPassword());
				cin.setText(""+emp.getCIN());
				mail.setText(emp.getEmail());
				
				civil.setVisible(true);
				birth.setVisible(true);
				adress.setVisible(true);
				kids.setVisible(true);
				phone.setVisible(true);
				name.setVisible(true);
				lastname.setVisible(true);
				pseudo.setVisible(true);
				password.setVisible(true);
				cin.setVisible(true);
				mail.setVisible(true);
				lblBirthday.setVisible(true);
				lblCivilState.setVisible(true);
				lblKidsNumber.setVisible(true);
				lblLastName.setVisible(true);
				lblName.setVisible(true);
				lblPassword.setVisible(true);
				lblPhone.setVisible(true);
				lblNewLabel_1.setVisible(true);
				lblNewLabel_2.setVisible(true);
				lblMail.setVisible(true);
				lblNewLabel.setVisible(true);
			}
		});
		contentPane.add(btnUpdate);
		btnUpdate.setOpaque(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 32, 572, 280);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				HumanRessource c = new HumanRessource();
				c.setVisible(true);
			}
		});
		label.setBounds(0, 0, 50, 50);
		label.setIcon(new ImageIcon(ManageEmployees.class.getResource("/img/icone-home-page.png")));
		contentPane.add(label);
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
							}
		});
		initDataBindings();
		
	}
	protected void initDataBindings() {
		JTableBinding<Employee, List<Employee>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, employees, table);
		//
		BeanProperty<Employee, String> employeeBeanProperty = BeanProperty.create("firstName");
		jTableBinding.addColumnBinding(employeeBeanProperty).setColumnName("firstname");
		//
		BeanProperty<Employee, String> employeeBeanProperty_1 = BeanProperty.create("lastName");
		jTableBinding.addColumnBinding(employeeBeanProperty_1).setColumnName("LastName");
		//
		BeanProperty<Employee, Integer> employeeBeanProperty_2 = BeanProperty.create("phoneNumber");
		jTableBinding.addColumnBinding(employeeBeanProperty_2).setColumnName("Phone");
		//
		BeanProperty<Employee, String> employeeBeanProperty_3 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(employeeBeanProperty_3).setColumnName("Email");
		//
		BeanProperty<Employee, String> employeeBeanProperty_4 = BeanProperty.create("adress");
		jTableBinding.addColumnBinding(employeeBeanProperty_4).setColumnName("Adresse");
		//
		jTableBinding.bind();
	}
}

