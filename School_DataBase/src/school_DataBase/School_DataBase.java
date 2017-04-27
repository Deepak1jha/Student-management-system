package school_DataBase;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.util.*;
import java.awt.event.*;
class DataBase extends JFrame
{
	JFrame jf;
	Container c;
	JTable table;
	JComboBox ev,er;
	Vector column, row, data; 
	Connection con  = null;
	Statement st =  null;
	ResultSet rs = null;
	String s ,mns;
	JTextField n, n1, n2, n3, n4, n5, n6;
	DataBase()
	{
		
		jf = new JFrame();
		jf.setSize(900,700);
		jf.setResizable(true);
		c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		
		JMenuBar men=new JMenuBar();
		setJMenuBar(men);
		JMenu home=new JMenu("Home");
		JMenu about=new JMenu("About");
		JMenu Help=new JMenu("Help");
		JMenu exit=new JMenu("Exit");
		
		
		Font hom=new Font("BankGothic Md BT",Font.BOLD,20);
		
		
		home.setFont(hom);
		about.setFont(hom);
		Help.setFont(hom);
		exit.setFont(hom);
	    
		
		men.add(home);
		men.add(about);
		men.add(Help);
		men.add(exit);
		
		
		JMenuItem lg=new JMenuItem("Login Page");
		JMenuItem su=new JMenuItem("SignUp Page"); 
		Font go=new Font("BankGothic Md BT",Font.BOLD,15);
		lg.setFont(go);
		su.setFont(go);
		home.add(lg);
		home.add(su);
		
		
		//---------------------Center Parts--------------------------------------------
		
		
		
		ImageIcon icon=new ImageIcon("pp.jpg");
		jf.setIconImage(icon.getImage());
		
		
		JDesktopPane jdp = new JDesktopPane();
		c.add(jdp);
		
		JLabel label2 = new JLabel("Student DataBase");
		c.add(label2,BorderLayout.PAGE_START);
		label2.setFont(new Font("VoxBox",Font.BOLD,120));
		c.setBackground(Color.YELLOW);
		//------------------------------------------------------Advance Search Box-----------------------------------------------
		
		
		
		
		JDesktopPane lt = new JDesktopPane();
		Dimension dleft = getPreferredSize();
		dleft.width = 300;
		lt.setPreferredSize(dleft);
		c.add(lt, BorderLayout.LINE_START);
		lt.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Zone"));
		
		
		
		JLabel hdd=new JLabel("Enrollment Number");
		hdd.setBounds(10,30,300,30);
		Font head=new Font("BankGothic Md BT",Font.BOLD,20);
		hdd.setFont(head);
		lt.add(hdd);
		
		
		final JTextField az=new JTextField();
		az.setBounds(10,70,250,30);
		lt.add(az);
		
		JButton tg=new JButton("Search");
		tg.setBounds(30,110,200,30);
		Font gb=new Font("BankGothic Md BT",Font.BOLD,20);
		tg.setFont(gb);
		lt.add(tg);
		tg.setBackground(Color.BLACK);
		tg.setForeground(Color.YELLOW);
		
		
		JLabel qx =new JLabel("::::::Advance Search::::::");
		qx.setBounds(10,150,300,30);
		Font qe=new Font("BankGothic Md BT",Font.BOLD,20);
		qx.setFont(qe);
		lt.add(qx);
		
		
		final JLabel we =new JLabel("Student Name :");
		we.setBounds(10,190,300,30);
		Font wd=new Font("BankGothic Md BT",Font.BOLD,20);
		we.setFont(wd);
		lt.add(we);
		
		
		final JTextField wc=new JTextField();
		lt.add(wc);
		wc.setBounds(10,230,250,30);
		
		
		JButton tgc=new JButton("Name");
		tgc.setBounds(30,270,200,30);
		Font gbc=new Font("BankGothic Md BT",Font.BOLD,20);
		tgc.setFont(gbc);
		lt.add(tgc);
		tgc.setBackground(Color.BLACK);
		tgc.setForeground(Color.YELLOW);
		
		
		
		JLabel ed =new JLabel(" Student Faculty :");
		ed.setBounds(10,310,250,30);
		Font dc=new Font("BankGothic Md BT",Font.BOLD,20);
		ed.setFont(dc);
		lt.add(ed);
		
		
		String[] arr={"FET","HIMSR","MBA","NURSING","PHARMACY","I dont know"};
		final JComboBox er =new JComboBox(arr);
		er.setBounds(10,350,250,30);
		Font ef=new Font("BankGothic Md BT",Font.BOLD,15);
		er.setFont(ef);
		lt.add(er);
		er.setBackground(Color.YELLOW);
		er.setForeground(Color.BLACK);
		
		JButton rff=new JButton("Faculty");
		rff.setBounds(30,390,200,30);
		Font fvv=new Font("BankGothic Md BT",Font.BOLD,20);
		rff.setFont(fvv);
		lt.add(rff);
		rff.setBackground(Color.BLACK);
		rff.setForeground(Color.YELLOW);
		
		
		JLabel ec =new JLabel(" Student Semester :");
		ec.setBounds(10,430,200,30);
		Font ce=new Font("BankGothic Md BT",Font.BOLD,20);
		ec.setFont(ce);
		lt.add(ec);
		
		String[] qrr={"1","2","3","4","5","6","7","8"};
		final JComboBox ev=new JComboBox(qrr);
		ev.setBounds(10,470,250,30);
		Font ee=new Font("BankGothic Md BT",Font.BOLD,20);
		ev.setFont(ee);
		lt.add(ev);
		ev.setBackground(Color.YELLOW);
		ev.setForeground(Color.BLACK);
		
		
		//lt.setBackground(Color.YELLOW);
		//ImageIcon od= new ImageIcon("img/cc.jpg");
		JButton rf=new JButton("Semester");
		rf.setBounds(30,510,200,30);
		Font fv=new Font("BankGothic Md BT",Font.BOLD,20);
		rf.setFont(fv);
		lt.add(rf);
		rf.setBackground(Color.BLACK);
		rf.setForeground(Color.YELLOW);
		lt.setBackground(Color.YELLOW);
		
		
		
		//-------------------------------------------------------------------------------------------
		tgc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					
					String q = "select * From dpk where Student_Name = '"+wc.getText()+"'";
					PreparedStatement pst = (PreparedStatement) con.prepareStatement(q);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
							
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		
		tg.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					String q = "select * From dpk where Enrollment_No="+az.getText();;
					PreparedStatement pst = (PreparedStatement) con.prepareStatement(q);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
							
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		
		
		
		
		rff.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					String item = (String)er.getSelectedItem();
					String q = "select * From dpk where Faculty='"+item+"'";
					PreparedStatement pst = (PreparedStatement) con.prepareStatement(q);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		
		
		
		
		rf.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					String item = (String)ev.getSelectedItem();
					String q = "select * From dpk where Semester='"+item+"'";
					PreparedStatement pst = (PreparedStatement) con.prepareStatement(q);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		
	
		
		
		
		//--------------------------------------------------Table Box-----------------------------------------------------------
		
		JDesktopPane center = new JDesktopPane();
		c.add(center, BorderLayout.CENTER);
		center.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Table Box"));
		center.setLayout(new BorderLayout());
		
		
		
		
		
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/signup","root","123");
		}
		catch(Exception e)
		{
			
		}
		table = new JTable();
		JTableHeader h = table.getTableHeader();
		center.add(h,BorderLayout.NORTH);
		center.add(new JScrollPane(table),BorderLayout.CENTER);
		table.setBackground(Color.BLACK);
		table.setForeground(Color.YELLOW);
		tabledis();
		//----------------------------------------modification Box----------------------------------------------
		
		JDesktopPane right = new JDesktopPane();
		Dimension dright = getPreferredSize();
		dright.width = 400;
		right.setPreferredSize(dright);
		c.add(right, BorderLayout.LINE_END);
		right.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Modification Box"));
		right.setBackground(Color.YELLOW);
		
		JLabel label52=new JLabel("Enrollment No. ");
		label52.setBounds(20,25,200,20);
		Font bv12=new Font("BankGothic Md BT",Font.BOLD,20);
		label52.setFont(bv12);
		right.add(label52);
		n=new JTextField();
		n.setBounds(170,20,200,30);
		right.add(n);
		
		
		
		JLabel label53=new JLabel("Name ");
		label53.setBounds(20,65,200,20);
		Font bv13=new Font("BankGothic Md BT",Font.BOLD,20);
		label53.setFont(bv13);
		right.add(label53);
		n1=new JTextField();
		n1.setBounds(170,65,200,30);
		right.add(n1);
		
		
		JLabel label54=new JLabel("Faculty ");
		label54.setBounds(20,105,200,20);
		Font bv14=new Font("BankGothic Md BT",Font.BOLD,20);
		label54.setFont(bv14);
		right.add(label54);
		n2=new JTextField();
		n2.setBounds(170,105,200,30);
		right.add(n2);
		
		
		
		JLabel label55=new JLabel("Course ");
		label55.setBounds(20,145,200,20);
		Font bv15=new Font("BankGothic Md BT",Font.BOLD,20);
		label55.setFont(bv15);
		right.add(label55);
		n3=new JTextField();
		n3.setBounds(170,145,200,30);
		right.add(n3);
		
		
		JLabel label56=new JLabel("Semester ");
		label56.setBounds(20,185,200,20);
		Font bv16=new Font("BankGothic Md BT",Font.BOLD,20);
		label56.setFont(bv16);
		right.add(label56);
		n4=new JTextField();
		n4.setBounds(170,185,200,30);
		right.add(n4);
		
		
		JLabel label57=new JLabel("Gender ");
		label57.setBounds(20,225,200,20);
		Font bv17=new Font("BankGothic Md BT",Font.BOLD,20);
		label57.setFont(bv17);
		right.add(label57);
		n5=new JTextField();
		n5.setBounds(170,225,200,30);
		right.add(n5);
		
		
		
		JLabel label58=new JLabel("Nationality ");
		label58.setBounds(20,265,200,20);
		Font bv18=new Font("BankGothic Md BT",Font.BOLD,20);
		label58.setFont(bv18);
		right.add(label58);
		n6=new JTextField();
		n6.setBounds(170,265,200,30);
		right.add(n6);
		
		
		JButton tg1=new JButton("Modify");
		tg1.setBounds(20,320,100,40);
		Font gb3=new Font("BankGothic Md BT",Font.BOLD,20);
		tg1.setFont(gb3);
		right.add(tg1);
		tg1.setBackground(Color.BLACK);
		tg1.setForeground(Color.YELLOW);
		
		
		JButton tg2=new JButton("Insert");
		tg2.setBounds(130,320,100,40);
		Font gb1=new Font("BankGothic Md BT",Font.BOLD,20);
		tg2.setFont(gb1);
		right.add(tg2);
		tg2.setBackground(Color.BLACK);
		tg2.setForeground(Color.YELLOW);
		
		
		JButton tg3=new JButton("Delete");
		tg3.setBounds(240,320,100,40);
		Font gb2=new Font("BankGothic Md BT",Font.BOLD,20);
		tg3.setFont(gb2);
		right.add(tg3);
		tg3.setBackground(Color.BLACK);
		tg3.setForeground(Color.YELLOW);
		
		
		
		JButton tg4=new JButton("Refresh");
		tg4.setBounds(30,390,150,80);
		Font gb33=new Font("BankGothic Md BT",Font.BOLD,20);
		tg4.setFont(gb33);
		right.add(tg4);
		tg4.setBackground(Color.BLACK);
		tg4.setForeground(Color.YELLOW);
		
		JButton tg5=new JButton("Exit");
		tg5.setBounds(200,390,150,80);
		Font gbg33=new Font("BankGothic Md BT",Font.BOLD,20);
		tg5.setFont(gbg33);
		right.add(tg5);
		tg5.setBackground(Color.BLACK);
		tg5.setForeground(Color.YELLOW);
		
		
		
		JLabel dk =new JLabel(" Deepak kumar jha");
		dk.setBounds(250,500,200,20);
		Font kd=new Font("BankGothic Md BT",Font.BOLD,15);
		dk.setFont(kd);
		right.add(dk);
		
		JLabel dkd =new JLabel(" Bobby kumar");
		dkd.setBounds(250,520,200,20);
		Font kdd=new Font("BankGothic Md BT",Font.BOLD,15);
		dkd.setFont(kdd);
		right.add(dkd);
		
		
		JLabel dkde =new JLabel(" Robin Alexander");
		dkde.setBounds(250,540,200,20);
		Font kdde=new Font("BankGothic Md BT",Font.BOLD,15);
		dkde.setFont(kdde);
		right.add(dkde);
		
		
		
		tg4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event)
			{
				tabledis();	
			
			}
		});
		
		
		
		tg5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			
			}
		});
		
		table.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseClicked(java.awt.event.MouseEvent evt) 
			{
				table2MouseClicked(evt);
			}
		});
		
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/signup","root","123");
			st = con.createStatement();
			
		}
		catch(Exception em)
		{
			javax.swing.JOptionPane.showMessageDialog(null,em);
		}
		
		tg2.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				PreparedStatement inval = con.prepareStatement("Insert into dpk values(?,?,?,?,?,?,?)");
				String text = n.getText();
				String text1 = n1.getText();
				String text3 = n2.getText();
				String text4 = n3.getText();
				String text2 = n4.getText();
				String text6 = n5.getText();
				String text5 = n6.getText();
				
				inval.setString(1, text);
				
				inval.setString(2, text1);
				inval.setString(3, text3);
				inval.setString(4, text4);
				inval.setString(5, text2);
				inval.setString(6, text6);
				inval.setString(7, text5);
				inval.executeUpdate();
				tabledis();
				n.setText("");
				n1.setText("");
				n2.setText("");
				n3.setText("");
				n4.setText("");
				n5.setText("");
				n6.setText("");
				javax.swing.JOptionPane.showMessageDialog(null, "Data inserted successfully");
			}
			catch(Exception e)
			{
				javax.swing.JOptionPane.showMessageDialog(null, e);
			}
		
		}
	});
		
		tg1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					st = con.createStatement();
					String str1="UPDATE dpk SET Enrollment_No='"+n.getText()+"',Student_Name='"+n1.getText()+"',Faculty='"+n2.getText()+"',	Course='"+n3.getText()+"',Semester='"+n4.getText()+"',Gender='"+n5.getText()+"',Nationality='"+n6.getText()+"' where Enrollment_No='"+n.getText()+"'";
			    	st.executeUpdate(str1);
					
					//inval.executeUpdate();
					javax.swing.JOptionPane.showMessageDialog(null, "Data is modified");
					tabledis();
					n.setText("");
					n1.setText("");
					n2.setText("");
					n3.setText("");
					n4.setText("");
					n5.setText("");
					n6.setText("");
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(null, e);
				}
			
			}
		});

		tg3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					String item = n.getText();
					//String q = "DELETE FROM `book_db` WHERE Serial_No ="+item;
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("DELETE FROM `dpk` WHERE Enrollment_No ="+item);
					pst.executeUpdate();
					//table3.setModel(DbUtils.resultSetToTableModel(rs));
					
					javax.swing.JOptionPane.showMessageDialog(null, "Student DataBase Is Deleted");
					tabledis();
					n.setText("");
					n1.setText("");
					n2.setText("");
					n3.setText("");
					n4.setText("");
					n5.setText("");
					n6.setText("");
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});


	
		
		
		//-------------------------------------------------------------------------------------------------------
		
	}
	
	private void table2MouseClicked(java.awt.event.MouseEvent evt) 
	{                                   
		
		int selectedRow = table.getSelectedRow();
		n.setText(table.getValueAt(selectedRow, 0).toString());
		n1.setText(table.getValueAt(selectedRow, 1).toString());
		n2.setText(table.getValueAt(selectedRow, 2).toString());
		n3.setText(table.getValueAt(selectedRow, 3).toString());
		n4.setText(table.getValueAt(selectedRow, 4).toString());
		n5.setText(table.getValueAt(selectedRow, 5).toString());
		n6.setText(table.getValueAt(selectedRow, 6).toString());
		
	}
	void tabledis()
	{
		try
		{
			String q = "select * From dpk";
			PreparedStatement pst = con.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			//JTable table;
			table.setModel(DbUtils.resultSetToTableModel(rs));
					
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	
	
	
	
				
	

	
	

	
	
	
	
}


class School_DataBase
{
	public static void main(String args[])
	{
		//------------------------------------------------------------
		DataBase ob = new DataBase();
		ob.setVisible(true);
		ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ob.setSize(1366,750);
		ob.setResizable(true);
		ob.setTitle("Student DataBase");
		ImageIcon icon=new ImageIcon("pp.jpg");
		ob.setIconImage(icon.getImage());
		
	}
}