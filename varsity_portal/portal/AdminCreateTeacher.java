import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminCreateTeacher extends JPanel implements ActionListener
{
	AdminFrame frame;
	JButton crstd,ucrstd,dbut;
	JLabel dname,did;
	JTextField dnametf,didtf;
	JLabel title1,title2;
	JLabel course1,course2,course3;
	JLabel ucourse1,ucourse2,ucourse3;
	JLabel id,uid;
	JLabel password,upassword;
	JLabel security,usecurity;
	JLabel answer,uanswer;
	JLabel name,uname;
	JLabel dept,udept,sal,usal;
	JTextField idtf,uidtf;
	JTextField passwordtf,upasswordtf;
	JTextField answertf,uanswertf;
	JTextField nametf,unametf;
	JTextField depttf,udepttf;
	JTextField course1tf,course2tf,course3tf;
	JTextField ucourse1tf,ucourse2tf,ucourse3tf,saltf,usaltf;
	
	public AdminCreateTeacher(AdminFrame frame)
	{
		this.frame=frame;
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		addComponentToPanel();
		crstd.addActionListener(this);
		ucrstd.addActionListener(this);
		dbut.addActionListener(this);
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
		
		this.title1=new JLabel("Create Account");
		this.title1.setBounds(70,20,200,20);
		title1.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
		title1.setForeground(Color.white);
		this.add(title1);
		
		this.title2=new JLabel("Update Account");
		this.title2.setBounds(470,20,200,20);
		title2.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 20));
		title2.setForeground(Color.white);
		this.add(title2);
		
		this.crstd = new JButton("Create Account");
		this.crstd.setBounds(50,430,180,30);
		this.add(crstd);
		
		this.id=new JLabel("ID: ");
		id.setForeground(Color.white);
		this.id.setBounds(50,50,100,30);
		this.add(id);
		
		this.password=new JLabel("Password: ");
		password.setForeground(Color.white);
		this.password.setBounds(50,90,100,30);
		this.add(password);
		
		this.security=new JLabel("Security Question: Any word that you will remember?");
		security.setForeground(Color.white);
		this.security.setBounds(50,125,300,20);
		this.add(security);
		
		this.answer=new JLabel("Answer: ");
		answer.setForeground(Color.white);
		this.answer.setBounds(50,155,100,30);
		this.add(answer);
		
		this.name=new JLabel("Name: ");
		name.setForeground(Color.white);
		this.name.setBounds(50,195,100,30);
		this.add(name);
		
		this.dept=new JLabel("Dept: ");
		dept.setForeground(Color.white);
		this.dept.setBounds(50,235,100,30);
		this.add(dept);
		
		this.course1=new JLabel("Course 1: ");
		course1.setForeground(Color.white);
		this.course1.setBounds(50,275,100,30);
		this.add(course1);
		
		this.course2=new JLabel("Course 2: ");
		course2.setForeground(Color.white);
		this.course2.setBounds(50,315,100,30);
		this.add(course2);
		
		this.course3=new JLabel("Course 3: ");
		course3.setForeground(Color.white);
		this.course3.setBounds(50,355,100,30);
		this.add(course3);
		
		this.dname=new JLabel("Name: ");
		dname.setForeground(Color.white);		
		this.dname.setBounds(50,470,100,30);
		this.add(dname);
		
		this.did=new JLabel("ID: ");
		did.setForeground(Color.white);
		this.did.setBounds(50,510,100,30);
		this.add(did);
		
		this.sal=new JLabel("Salary: ");
		sal.setForeground(Color.white);
		this.sal.setBounds(50,395,100,30);
		this.add(sal);
		
		this.idtf=new JTextField();
		this.idtf.setBounds(130,50,100,30);
		this.add(idtf);
		
		this.passwordtf=new JTextField();
		this.passwordtf.setBounds(130,90,100,30);
		this.add(passwordtf);
		
		this.answertf=new JTextField();
		this.answertf.setBounds(130,155,100,30);
		this.add(answertf);
		
		this.nametf=new JTextField();
		this.nametf.setBounds(130,195,100,30);
		this.add(nametf);
		
		this.depttf=new JTextField();
		this.depttf.setBounds(130,235,100,30);
		this.add(depttf);
		
		this.course1tf=new JTextField();
		this.course1tf.setBounds(130,275,100,30);
		this.add(course1tf);
		
		this.course2tf=new JTextField();
		this.course2tf.setBounds(130,315,100,30);
		this.add(course2tf);
		
		this.course3tf=new JTextField();
		this.course3tf.setBounds(130,355,100,30);
		this.add(course3tf);
		
		this.dnametf=new JTextField();
		this.dnametf.setBounds(130,470,100,30);
		this.add(dnametf);
		
		this.didtf=new JTextField();
		this.didtf.setBounds(130,510,100,30);
		this.add(didtf);
		
		this.saltf=new JTextField();
		this.saltf.setBounds(130,395,100,30);
		this.add(saltf);
		
		this.dbut = new JButton("Delete Account");
		this.dbut.setBounds(50,550,180,30);
		this.add(dbut);
		
		this.ucrstd = new JButton("Update Account");
		this.ucrstd.setBounds(400,430,200,30);
		this.add(ucrstd);
		
		this.uid=new JLabel("ID: ");
		uid.setForeground(Color.white);
		this.uid.setBounds(400,50,100,30);
		this.add(uid);
		
		this.upassword=new JLabel("Password: ");
		upassword.setForeground(Color.white);
		this.upassword.setBounds(400,90,100,30);
		this.add(upassword);
		
		this.usecurity=new JLabel("Security Question: Any word that you will remember?");
		usecurity.setForeground(Color.white);
		this.usecurity.setBounds(370,125,300,20);
		this.add(usecurity);
		
		this.uanswer=new JLabel("Answer: ");
		uanswer.setForeground(Color.white);
		this.uanswer.setBounds(400,155,100,30);
		this.add(uanswer);
		
		this.uname=new JLabel("Name: ");
		uname.setForeground(Color.white);
		this.uname.setBounds(400,195,100,30);
		this.add(uname);
		
		this.udept=new JLabel("Dept: ");
		udept.setForeground(Color.white);
		this.udept.setBounds(400,235,100,30);
		this.add(udept);
		
		this.ucourse1=new JLabel("Course 1: ");
		ucourse1.setForeground(Color.white);
		this.ucourse1.setBounds(400,275,100,30);
		this.add(ucourse1);
		
		this.ucourse2=new JLabel("Course 2: ");
		ucourse2.setForeground(Color.white);
		this.ucourse2.setBounds(400,315,100,30);
		this.add(ucourse2);
		
		this.ucourse3=new JLabel("Course 3: ");
		ucourse3.setForeground(Color.white);
		this.ucourse3.setBounds(400,355,100,30);
		this.add(ucourse3);
		
		this.usal=new JLabel("Salary: ");
		usal.setForeground(Color.white);
		this.usal.setBounds(400,395,100,30);
		this.add(usal);
		
		this.uidtf=new JTextField();
		this.uidtf.setBounds(500,50,100,30);
		this.add(uidtf);
		
		this.upasswordtf=new JTextField();
		this.upasswordtf.setBounds(500,90,100,30);
		this.add(upasswordtf);
		
		this.uanswertf=new JTextField();
		this.uanswertf.setBounds(500,155,100,30);
		this.add(uanswertf);
		
		this.unametf=new JTextField();
		this.unametf.setBounds(500,195,100,30);
		this.add(unametf);
		
		this.udepttf=new JTextField();
		this.udepttf.setBounds(500,235,100,30);
		this.add(udepttf);
		
		this.ucourse1tf=new JTextField();
		this.ucourse1tf.setBounds(500,275,100,30);		
		this.add(ucourse1tf);
		
		this.ucourse2tf=new JTextField();
		this.ucourse2tf.setBounds(500,315,100,30);
		this.add(ucourse2tf);
		
		this.ucourse3tf=new JTextField();
		this.ucourse3tf.setBounds(500,355,100,30);	
		this.add(ucourse3tf);
		
		this.usaltf=new JTextField();
		this.usaltf.setBounds(500,395,100,30);
		this.add(usaltf);
		
	}
	
	public void actionPerformed(ActionEvent e)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal","root","");
				Statement stmt = con.createStatement();
				
				if(e.getSource()==crstd)
				{	
					String s1=idtf.getText();  
					int id1=Integer.parseInt(s1);
					String s2=passwordtf.getText();
					String s3=answertf.getText();
					String s4=nametf.getText();
					String s5=depttf.getText();
					String s6=course1tf.getText();
					String s7=course2tf.getText();
					String s8=course3tf.getText();
					String s9=saltf.getText();
					
					String chck="SELECT `name` FROM `course` WHERE `name`='"+s6+"' or `name`='"+s7+"' or `name`='"+s8+"'";	
					ResultSet rs = stmt.executeQuery(chck);		
					rs.last();
					int count = rs.getRow();
					rs.beforeFirst();
					
					if(count==3) 
					{
						String sql = "INSERT INTO `teacher`( `id`,`password`,`answer`,`name`,`dept`,`salary`,`course1`,`course2`,`course3`) VALUES ('"+id1+"',"+"'"+s2+"',"+"'"+s3+"',"+"'"+s4+"',"+"'"+s5+"',"+"'"+s9+"',"+"'"+s6+"',"+"'"+s7+"',"+"'"+s8+"')";
						int a = stmt.executeUpdate(sql);
						if (a==1)
						{
							JOptionPane.showMessageDialog(null, "Account Created Successfully!");	
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Course Not Available!");
					}
				}
				else if(e.getSource()==ucrstd)
				{
					String s1=uidtf.getText();  
					int uid1=Integer.parseInt(s1);
					String s2=upasswordtf.getText();
					String s3=uanswertf.getText();
					String s4=unametf.getText();
					String s5=udepttf.getText();
					String s9=usaltf.getText();
					String s6=ucourse1tf.getText();
					String s7=ucourse2tf.getText();
					String s8=ucourse3tf.getText();
					
					String sql1="UPDATE `teacher` SET `id`='"+uid1+"',`password`='"+s2+"',`answer`='"+s3+"',`name`='"+s4+"',`dept`='"+s5+"',`salary`='"+s9+"',`course1`='"+s6+"',`course2`='"+s7+"',`course3`='"+s8+"' WHERE `id`='"+uid1+"'";
					int a = stmt.executeUpdate(sql1);
					
					if (a==1)
					{
						JOptionPane.showMessageDialog(null, "Account Updated Successfully!");	
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Account Could Not Be Updated! Check");
					}
				
				}
				else if(e.getSource()==dbut)
				{
					String s1=dnametf.getText();
					String s2=didtf.getText();  
					int didtf=Integer.parseInt(s2);
					
					String sql1="DELETE FROM `teacher` WHERE `id`='"+didtf+"'";
					int a = stmt.executeUpdate(sql1);
					
					if (a==1)
					{
						JOptionPane.showMessageDialog(null, "Account Deleted Successfully!");	
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Account Could Not Be Deleted! Check");
					}
				}
				AdminFrame frame1=new AdminFrame();
				frame1.tab.setSelectedIndex(3);
				frame1.setVisible(true);
				frame.setVisible(false);
				con.close();
				
			}
			catch(Exception exp)
			{
				System.out.println(exp);
				JOptionPane.showMessageDialog(null, "Action Could Not Be Performed! Check Carefully");
			}
		}
}		
	