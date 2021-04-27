import javax.swing.*;
import java.awt.*;
import java.awt.event.*;;
import java.sql.*;

public class TeacherProfile extends JPanel
{
	TeacherFrame frame;
	JLabel course1,course2,course3;
	JLabel id;
	JLabel password;
	JLabel security;
	JLabel answer;
	JLabel name;
	JLabel dept;
	JLabel title;
	JLabel sal;
	JLabel idtf;
	JLabel passwordtf;
	JLabel answertf;
	JLabel nametf;
	JLabel depttf;
	JLabel saltf;
	JLabel course1tf,course2tf,course3tf;
	int ida,idtf1;
	String passwordtf1,answertf1,nametf1,depttf1,saltf1,course1tf1,course2tf1,course3tf1;
	
	public TeacherProfile()
	{
		
	}
	public TeacherProfile(TeacherFrame frame,int ida)
	{
     	this.ida=ida;
		this.frame = frame;
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		addComponentToPanel();
	}
	public void addComponentToPanel()
	{
		JButton logout=new JButton("Log Out");
		logout.setBounds(260,605,100,30);
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
		
		JLabel title=new JLabel("Teacher Profile");
		title.setBounds(230,20,500,40);
		title.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 40));
		title.setForeground(Color.white);
		this.add(title);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `teacher` WHERE `id`='"+ida+"'");
		
			while(rs.next())
			{
				idtf1=rs.getInt(1);
				passwordtf1=rs.getString(2);
				answertf1=rs.getString(3);
				nametf1=rs.getString(4);
				depttf1=rs.getString(5);
				saltf1=rs.getString(6);
				course1tf1=rs.getString(7);
				course2tf1=rs.getString(8);
				course3tf1=rs.getString(9);
			} 
			
			this.id=new JLabel("ID: ");
			id.setForeground(Color.white);
			id.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.id.setBounds(50,100,100,30);
			this.add(id);
			
			this.password=new JLabel("Password: ");
			password.setForeground(Color.white);
			password.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.password.setBounds(50,160,100,30);
			this.add(password);
			
			this.security=new JLabel("Security Question: Write something that you will remember?");
			security.setForeground(Color.white);
			security.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.security.setBounds(50,220,600,30);
			this.add(security);
			
			this.answer=new JLabel("Answer: ");
			answer.setForeground(Color.white);
			answer.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.answer.setBounds(50,280,100,30);
			this.add(answer);
			
			this.name=new JLabel("Name: ");
			name.setForeground(Color.white);
			name.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.name.setBounds(50,340,100,30);
			this.add(name);
			
			this.dept=new JLabel("Dept: ");
			dept.setForeground(Color.white);
			dept.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.dept.setBounds(50,400,100,30);
			this.add(dept);
			
			this.sal=new JLabel("Salary: ");
			sal.setForeground(Color.white);
			sal.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.sal.setBounds(50,460,100,30);
			this.add(sal);
			
			this.course1=new JLabel("Course 1: ");
			course1.setForeground(Color.white);
			course1.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.course1.setBounds(50,500,100,30);
			this.add(course1);
			
			this.course2=new JLabel("Course 2: ");
			course2.setForeground(Color.white);
			course2.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.course2.setBounds(50,540,100,30);
			this.add(course2);
			
			this.course3=new JLabel("Course 3: ");
			course3.setForeground(Color.white);
			course3.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
			this.course3.setBounds(50,580,100,30);
			this.add(course3);
			
			String idf = Integer.toString(idtf1);
			this.idtf=new JLabel(idf);
			idtf.setForeground(Color.white);
			this.idtf.setBounds(130,100,100,30);
			this.add(idtf);
			
			this.passwordtf=new JLabel(passwordtf1);
			passwordtf.setForeground(Color.white);
			this.passwordtf.setBounds(150,160,100,30);
			this.add(passwordtf);
			
			this.answertf=new JLabel(answertf1);
			answertf.setForeground(Color.white);
			this.answertf.setBounds(130,280,100,30);
			this.add(answertf);
			
			this.nametf=new JLabel(nametf1);
			nametf.setForeground(Color.white);
			this.nametf.setBounds(130,340,100,30);
			this.add(nametf);
			
			this.depttf=new JLabel(depttf1);
			depttf.setForeground(Color.white);
			this.depttf.setBounds(130,400,100,30);
			this.add(depttf);
			
			this.saltf=new JLabel(saltf1);
			saltf.setForeground(Color.white);
			this.saltf.setBounds(130,460,100,30);
			this.add(saltf);
			
			this.course1tf=new JLabel(course1tf1);
			course1tf.setForeground(Color.white);
			this.course1tf.setBounds(150,500,300,30);
			this.add(course1tf);
			
			this.course2tf=new JLabel(course2tf1);
			course2tf.setForeground(Color.white);
			this.course2tf.setBounds(150,540,300,30);
			this.add(course2tf);
			
			this.course3tf=new JLabel(course3tf1);
			course3tf.setForeground(Color.white);
			this.course3tf.setBounds(150,580,300,30);
			this.add(course3tf);		
			
			con.close();
		}
		catch(Exception exp)
		{
			System.out.println(exp);
			JOptionPane.showMessageDialog(null, "Action Could Not Be Performed! Check Carefully");
		}
	}			
}
