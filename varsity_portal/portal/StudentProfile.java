import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentProfile extends JPanel
{
	
	StudentFrame frame;
	JLabel id;
	JLabel password;
	JLabel security;
	JLabel answer;
	JLabel name;
	JLabel dept;
	JLabel title;
	JLabel idtf;
	JLabel passwordtf;
	JLabel answertf;
	JLabel nametf;
	JLabel depttf;
	int ida,idtf1;
	String passwordtf1,answertf1,nametf1,depttf1,course1tf1,course2tf1,course3tf1;
	
	public StudentProfile(StudentFrame frame,int idp)
	{
		this.ida=idp;
		this.frame = frame;
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		addComponentToPanel();
	}
	
	public void addComponentToPanel()
	{
		JButton logout=new JButton("Log Out");
		logout.setBounds(260,590,100,30);
		this.add(logout);
		logout.addActionListener
		(
			new ActionListener()
			{  
				public void actionPerformed(ActionEvent e)
				{  
					Login l=new Login();
					l.setVisible(true);
					frame.setVisible(false);
				}  
			}
		);
		
		JLabel title=new JLabel("Student Profile");
		title.setBounds(230,20,500,40);
		title.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 40));
		title.setForeground(Color.white);
		this.add(title);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `student` WHERE `id`='"+ida+"'");
		
			while(rs.next())
				{
					idtf1=rs.getInt(1);
					passwordtf1=rs.getString(2);
					answertf1=rs.getString(3);
					nametf1=rs.getString(4);
					depttf1=rs.getString(5);
					course1tf1=rs.getString(6);
					course2tf1=rs.getString(7);
					course3tf1=rs.getString(8);
				} 
			
			this.id=new JLabel("ID: ");
			id.setForeground(Color.white);
			id.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.id.setBounds(50,100,100,30);
			this.add(id);
			
			this.password=new JLabel("Password: ");
			password.setForeground(Color.white);
			password.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.password.setBounds(50,180,100,30);
			this.add(password);
			
			this.security=new JLabel("Security Question: Write something that you will remember?");
			security.setForeground(Color.white);
			security.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.security.setBounds(50,260,600,30);
			this.add(security);
			
			this.answer=new JLabel("Answer: ");
			answer.setForeground(Color.white);
			answer.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.answer.setBounds(50,340,100,30);
			this.add(answer);
			
			this.name=new JLabel("Name: ");
			name.setForeground(Color.white);
			name.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.name.setBounds(50,420,100,30);
			this.add(name);
			
			this.dept=new JLabel("Dept: ");
			dept.setForeground(Color.white);
			dept.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.dept.setBounds(50,500,100,30);
			this.add(dept);
			
			String idf = Integer.toString(idtf1);
			this.idtf=new JLabel(idf);
			idtf.setForeground(Color.white);
			this.idtf.setBounds(130,100,100,30);
			this.add(idtf);
			
			this.passwordtf=new JLabel(passwordtf1);
			passwordtf.setForeground(Color.white);
			this.passwordtf.setBounds(150,180,100,30);
			this.add(passwordtf);
			
			this.answertf=new JLabel(answertf1);
			answertf.setForeground(Color.white);
			this.answertf.setBounds(130,340,100,30);
			this.add(answertf);
			
			this.nametf=new JLabel(nametf1);
			nametf.setForeground(Color.white);
			this.nametf.setBounds(130,420,100,30);
			this.add(nametf);
			
			this.depttf=new JLabel(depttf1);
			depttf.setForeground(Color.white);
			this.depttf.setBounds(130,500,100,30);
			this.add(depttf);
			
			con.close();
		}
		catch(Exception exp)
		{
			System.out.println(exp);
			JOptionPane.showMessageDialog(null, "Action Could Not Be Performed! Check Carefully");
		}
	}			
}
		
		