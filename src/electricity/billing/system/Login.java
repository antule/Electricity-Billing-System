
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, cancle, signup;
    JTextField username;
    JPasswordField password;
    Choice logginin;
    Login() {
        setTitle("Login Page");
        getContentPane().setBackground(new Color(0,255,255));
        setLayout(null); 
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(300,20,100, 20);
        add(lblusername);
        
        username = new JTextField();
        username.setBounds(400, 20, 150, 20);
        add(username);
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(300,60,100, 20);
        add(lblpassword);
        
        password = new JPasswordField();
        password.setBounds(400, 60, 150, 20);
        add(password);
        
        JLabel loggininas = new JLabel("loggin in as");
        loggininas.setBounds(300,100,100, 20);
        add(loggininas);
        
        logginin = new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(400, 100, 150, 20);
        add(logginin);
        
        login = new JButton("Login");
        login.setBounds(330, 160, 100, 20);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        cancle = new JButton("Cancle");
        cancle.setBounds(450, 160, 100, 20);
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.WHITE);
        cancle.addActionListener(this);
        add(cancle);
        
        signup = new JButton("Signup");
        signup.setBounds(380, 200, 100, 20);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 250, 250);
        add(image);
                
        setSize(640, 300);
        setLocation(400, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login) {
                String susername = username.getText();
                String spassword = password.getText();
                String user = logginin.getSelectedItem();
                
                try {
                     Conn c = new Conn();
                     String query = "select * from login where username = '"+susername+"' and password = '"+spassword+"' and user = '"+user+"'" ; 
                     
                     
                     ResultSet rs = c.s.executeQuery(query);
                      
                     if(rs.next()) {
                         String meter = rs.getString("meter_no");
                         setVisible(false);
                         new Project(user, meter);
                     }
                     else {
                         JOptionPane.showMessageDialog(null, "Invalid Login");
                         username.setText("");
                         password.setText("");
                     }
                }
                catch(Exception e) {
                        e.printStackTrace();
                }
                
        }
        else if(ae.getSource() == cancle) {
               setVisible(false);
        }
        else if(ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        }
    }
    
    
    public static void main(String args[]) {
        new Login();
    }
}
