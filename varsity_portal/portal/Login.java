import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener 
{
	
	private JLabel id,pass,imgLabel;
	private JTextField idTF;
	private JPasswordField passPF;
	private ImageIcon img;
	private JButton login,exit;
	private JPanel panel;
	private ButtonGroup bg;
	private JRadioButton Student, Faculty, Admin;
	int id1,id2,count;
	String pass1,pass2,s2;
	
	public Login()
	{
		this.setTitle("AIUB");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panel=new JPanel();
		panel.setLayout(null);
			
		panel.setBackground(Color.WHITE);
			
		img = new ImageIcon("AIUB.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(140,100,400,300);
		panel.add(imgLabel);
			
		id = new JLabel("ID");
		id.setBounds(220,380,100,30);
		id.setForeground(new Color(63,125,156));
		panel.add(id);
			
		idTF = new JTextField();
		idTF.setBounds(290,380,195,30);
		panel.add(idTF);
			
		pass = new JLabel("Password");
		pass.setBounds(220,430,100,30);
		pass.setForeground(new Color(63,125,156));
		panel.add(pass);
			
		passPF = new JPasswordField();
		passPF.setBounds(290,430,195,30);
		passPF.setEchoChar('@');
		panel.add(passPF);

		login = new JButton("Log in");
		login.setBounds(220,480,265,40);
		login.setForeground(Color.WHITE);
		login.setBackground(new Color(63,125,156));
		login.addActionListener(this);
		panel.add(login);

		Student = new JRadioButton("Student");
		Student.setBounds(225,540,80,20);
		//Student.setOpaque(false);
		panel.add(Student);
			
		Faculty = new JRadioButton("Teacher");
		Faculty.setBounds(315,540,80,20);
		//Faculty.setOpaque(false);
		panel.add(Faculty);
			
		Admin = new JRadioButton("Admin");
		Admin.setBounds(410,540,75,20);
		//Admin.setOpaque(false);
		panel.add(Admin);
		
		exit = new JButton("Exit");
		exit.setBounds(220,580,265,40);
		exit.setForeground(Color.WHITE);
		exit.setBackground(new Color(63,125,156));
		exit.addActionListener(this);
		panel.add(exit);
			
		bg = new ButtonGroup();
		bg.add(Student);
		bg.add(Faculty);
		bg.add(Admin);

		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal","root","");
			Statement stmt = con.createStatement();
			s2=idTF.getText();  
			id2=Integer.parseInt(s2);
			pass1=passPF.getText();
			
			if(ae.getSource()==login)
			{
				if(Admin.isSelected())
				{
					System.out.println("Connection");
					String sql= "select `id`,`password` from `admin` where `id`='"+id2+"' and `password`='"+pass1+"'";
					ResultSet rs   = stmt.executeQuery(sql);	
					rs.last();
					count = rs.getRow();
					rs.beforeFirst();
					
					while(rs.next())
					{
						id1=rs.getInt(1);
						pass2=rs.getString(2);
					}
					if(count==1)
					{
						AdminFrame f = new AdminFrame();
						f.setVisible(true);
						this.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid ID or Password");
					}
				}
				
				else if(Student.isSelected())
				{
					String sql= "select `id`,`password` from `student` where `id`='"+id2+"' and `password`='"+pass1+"' or `answer`='"+pass1+"'";
					ResultSet rs   = stmt.executeQuery(sql);	
					rs.last();
					count = rs.getRow();
					rs.beforeFirst();
					
					while(rs.next())
					{
						id1=rs.getInt(1);
						pass2=rs.getString(2);
					}
					if(count==1)
					{
						StudentFrame sf=new StudentFrame(id1);
						sf.setVisible(true);
						this.setVisible(false);
					}
					else
					{
							JOptionPane.showMessageDialog(null, "Invalid ID or Password");
					}
				}
				
				else if(Faculty.isSelected())
				{
					String sql= "select `id`,`password`,`answer` from `teacher` where `id`='"+id2+"' and `password`='"+pass1+"' or `answer`='"+pass1+"'";
					ResultSet rs   = stmt.executeQuery(sql);	
					rs.last();
					count = rs.getRow();
					rs.beforeFirst();
	
					while(rs.next())
					{
						id1=rs.getInt(1);
						pass2=rs.getString(2);
					}
					if(count==1)
					{
						TeacherFrame f=new TeacherFrame(id1);
						f.setVisible(true);
						this.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid ID or Password");
					}
				}														
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(ae.getSource()==exit)
		{
			System.exit(0);
		}
	}
}