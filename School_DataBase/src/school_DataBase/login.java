package school_DataBase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblJamiaHamdardUniversity;
	private JLabel lblCentralLibrary;
	Connection con  = null;
	Statement st =  null;
	boolean status = false;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public login() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setSize(599, 395);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Log In");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBackground(Color.YELLOW);
		
		JLabel lblNewLabel = new JLabel("User Name :");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 18));
		lblNewLabel.setBounds(79, 151, 141, 33);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 18));
		lblNewLabel_1.setBounds(77, 203, 185, 54);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setBounds(260, 149, 275, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordField.setEchoChar('*');
		passwordField.setBounds(260, 211, 275, 36);
		panel.add(passwordField);
		
		lblJamiaHamdardUniversity = new JLabel("JAMIA HAMDARD UNIVERSITY");
		lblJamiaHamdardUniversity.setForeground(Color.BLACK);
		lblJamiaHamdardUniversity.setFont(new Font("BatmanForeverAlternate", Font.BOLD, 24));
		lblJamiaHamdardUniversity.setBounds(67, 23, 468, 47);
		panel.add(lblJamiaHamdardUniversity);
		
		lblCentralLibrary = new JLabel("STUDENT DATABASE");
		lblCentralLibrary.setForeground(Color.BLACK);
		lblCentralLibrary.setFont(new Font("BatmanForeverAlternate", Font.BOLD, 20));
		lblCentralLibrary.setBounds(161, 70, 301, 33);
		panel.add(lblCentralLibrary);
		
		try
		{
			con = (Connection) DriverManager.getConnection("jdbc:mysql://LocalHost:3306/signup","root","123");
		}
		catch(Exception ea)
		{
			JOptionPane.showMessageDialog(null, ea);
		}
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try{
				String name=textField.getText();
				String password=String.valueOf(passwordField.getPassword());
				
				PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from lib_login where user=? and pwd=?");
				ps.setString(1,name);
				ps.setString(2,password);
				ResultSet rs=ps.executeQuery();
				status=rs.next();
				
				
				if(status == true)
				{
					School_DataBase.main(new String[]{});
					frame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "check user name and password ");
				}
				}
				catch(Exception m)
				{
					JOptionPane.showMessageDialog(null, m);
				}
				
				
			}
		});
		btnNewButton.setBounds(297, 278, 89, 33);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setForeground(Color.YELLOW);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(426, 278, 89, 33);
		panel.add(btnNewButton_1);
		ImageIcon ic = new ImageIcon("img/jamia.jpg");
	}
}
