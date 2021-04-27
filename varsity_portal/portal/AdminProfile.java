import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminProfile extends JPanel implements ActionListener
{
	JButton info;
	AdminFrame frame;
	JLabel name1,id1,pass1;
	JLabel name2,id2,pass2;
	JTextField nametf,idtf,passtf;
	int a;
	String b,c,a1;

	public AdminProfile(AdminFrame frame)
	{
		this.frame = frame;
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		addComponentToPanel();
		info.addActionListener(this);
	}
	public void addComponentToPanel()
	{
		JLabel title=new JLabel("Admin Profile");
		title.setBounds(250,20,500,40);
		title.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 40));
		title.setForeground(Color.white);
		this.add(title);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from admin");
			 while(rs.next())
				{
					a=rs.getInt(1);
					b=rs.getString(2);
					c=rs.getString(3);
				} 
			a1=String.valueOf(a);
			
			con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, "Check Error");
		}
		
		name1=new JLabel("Name: "+b);
		name1.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
		name1.setForeground(Color.white);
		name1.setBounds(50,70,300,30);
		this.add(name1);
		
		id1=new JLabel("ID: "+a1);
		id1.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
		id1.setForeground(Color.white);
		id1.setBounds(50,110,300,30);
		this.add(id1);
		
		pass1=new JLabel("Password: "+c);
		pass1.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
		pass1.setForeground(Color.white);
		pass1.setBounds(50,150,300,30);
		this.add(pass1);
		
		this.name2=new JLabel("Name: ");
		name2.setForeground(Color.white);
		this.name2.setBounds(50,220,100,30);
		this.add(name2);
		
		this.id2=new JLabel("ID: ");
		id2.setForeground(Color.white);
		this.id2.setBounds(50,280,100,30);
		this.add(id2);
		
		this.pass2=new JLabel("Password: ");
		pass2.setForeground(Color.white);
		this.pass2.setBounds(50,330,100,30);
		this.add(pass2);
		
		this.nametf=new JTextField();
		this.nametf.setBounds(130,220,100,30);
		this.add(nametf);
		
		this.idtf=new JTextField();
		this.idtf.setBounds(130,280,100,30);
		this.add(idtf);
		
		this.passtf=new JTextField();
		this.passtf.setBounds(130,330,100,30);
		this.add(passtf);
		
		this.info = new JButton("Change Info");
		this.info.setBounds(50,400,200,30);
		this.add(info);
		
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
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal","root","");
			Statement stmt = con.createStatement();	
			String s1=idtf.getText();  
			int id1=Integer.parseInt(s1);
			String s2=passtf.getText();
			String s3=nametf.getText();
					
			String sql1="UPDATE `admin` SET `id`='"+id1+"',`name`='"+s3+"',`password`='"+s2+"'";
			int a = stmt.executeUpdate(sql1);
			if (a==1)
			{
				JOptionPane.showMessageDialog(null, "Admin Info Updated Successfully!");	
				AdminFrame frame1=new AdminFrame();
				frame1.tab.setSelectedIndex(0);
				frame1.setVisible(true);
				frame.setVisible(false);
			}
			con.close();
		}
		catch(Exception exp)
		{
			JOptionPane.showMessageDialog(null, "Course Action Could Not Be Performed! Check Carefully");
		}
	}
}
		
		


		