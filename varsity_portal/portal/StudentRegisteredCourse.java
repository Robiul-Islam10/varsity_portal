import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentRegisteredCourse extends JPanel
{
	int ida;
	StudentFrame frame;
	JLabel course1,course2,course3;
	JLabel course1t,course2t,course3t;
	String course1a,course2b,course3c;
	
	public StudentRegisteredCourse(StudentFrame frame,int idp)
	{
		this.ida=idp;
		this.frame=frame;
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
		
		JLabel title=new JLabel("Registered Course");
		title.setBounds(210,20,500,50);
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
				course1a=rs.getString(6);
				course2b=rs.getString(7);
				course3c=rs.getString(8);
			}
			
			this.course1=new JLabel("Course 1: ");
			course1.setForeground(Color.white);
			course1.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.course1.setBounds(50,150,100,30);
			this.add(course1);	
			
			this.course2=new JLabel("Course 2: ");
			course2.setForeground(Color.white);
			course2.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.course2.setBounds(50,230,100,30);
			this.add(course2);
			
			this.course3=new JLabel("Course 3: ");
			course3.setForeground(Color.white);
			course3.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.course3.setBounds(50,310,100,30);
			this.add(course3);
			
			
			this.course1t=new JLabel(course1a);
			course1t.setForeground(Color.white);
			course1t.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.course1t.setBounds(150,150,200,30);
			this.add(course1t);	
			
			this.course2t=new JLabel(course2b);
			course2t.setForeground(Color.white);
			course2t.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.course2t.setBounds(150,230,200,30);
			this.add(course2t);
			
			this.course3t=new JLabel(course3c);
			course3t.setForeground(Color.white);
			course3t.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.course3t.setBounds(150,310,200,30);		
			this.add(course3t);
			
			con.close();
		}
		catch(Exception exp)
		{
			System.out.println(exp);
			JOptionPane.showMessageDialog(null, "Action Could Not Be Performed! Check Carefully");
		}
	}
}
