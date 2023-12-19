import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login5 extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2;
    JPanel p1,p2,p3,p4;
    Connection cn;
	Statement st;
	ResultSet rs;
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    Login5(){
        super("Login Page");
        
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        tf1 = new JTextField(15);
        pf2 = new JPasswordField(15);


        tf1.setToolTipText("Enter the Username");
        pf2.setToolTipText("Enter the Password");
        b1 = new JButton("Login");
        
        b2 = new JButton("Cancel");
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        
        setLayout(new BorderLayout());
        
                
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        
        p1.add(l1);
        p1.add(tf1);
        p2.add(l2);
        p2.add(pf2);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        
        p4.add(b1);
        p4.add(b2);
        p4.add(resetButton);
        p4.add(showPassword);
        add(p4,BorderLayout.SOUTH);

        p1.setBackground(Color.WHITE);
        p2.setBackground(Color.WHITE);
        p4.setBackground(Color.WHITE);
        
       
        setSize(440,250);
        setLocation(600,400);
        setVisible(true);
        

        
    }
    public void actionPerformed(ActionEvent ae){
        
        try{ 
           try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn=DriverManager.getConnection("jdbc:odbc:tyco");
			st=cn.createStatement();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,""+e);
		}    
           
            String a  = tf1.getText();
            String b  = pf2.getText();
            String q  = "select * from login where username = '"+a+"' and password = '"+b+"'";
            ResultSet rs = st.executeQuery(q);
            if(ae.getSource()==b1)
            {
            if(rs.next()){
            	//System.out.println("here");
            	//setVisible(true);
                JOptionPane.showMessageDialog(null, "Login Sucessfull...");
                new ButtonDemo().setVisible(true);
                this.setVisible(true);
                
                
            }else{
                //JOptionPane.showMessageDialog(null, "Invalid login");
                JOptionPane.showMessageDialog(null,"Invalid Login...!","Dialog",JOptionPane.ERROR_MESSAGE);
                setVisible(true);
            }
        	}
        	if(ae.getSource()==b2){

        		this.setVisible(false);	
        	   }
            if (ae.getSource() == resetButton) {
                tf1.setText("");
                pf2.setText("");
                }
            if (ae.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                pf2.setEchoChar((char) 0);
            } else {
                pf2.setEchoChar('*');
            }


        }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error: "+e);
        }
    }
    
    public static void main(String[] args){
        new Login5().setVisible(true);
    }

    
}



