
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    String atype, meter;
    Project(String atype, String meter) {
        this.atype = atype;
        this.meter = meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/electtower.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
       
        JMenu master = new JMenu("Master");
        master.setForeground(Color.BLUE);
        
        
        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced", Font.PLAIN, 12));
        newcustomer.addActionListener(this);
        master.add(newcustomer);
        
        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        customerdetails.addActionListener(this);
        master.add(customerdetails);
        
        JMenuItem depositedetails = new JMenuItem("Deposite Details");
        depositedetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        depositedetails.addActionListener(this);
        master.add(depositedetails);
        
        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculatebill.addActionListener(this);
        master.add(calculatebill);
        
        setLayout(new FlowLayout());
        
        JMenu info = new JMenu("Information");
        info.setForeground(Color.RED);
        
        
        JMenuItem updateinformation = new JMenuItem("Update Information");
        updateinformation.addActionListener(this);
        updateinformation.setFont(new Font("monospaced", Font.PLAIN, 12));
        info.add(updateinformation);
        
        JMenuItem viewinformation = new JMenuItem("View Information");
        viewinformation.setFont(new Font("monospaced", Font.PLAIN, 12));
        viewinformation.addActionListener(this);
        info.add(viewinformation);
        
        JMenu user = new JMenu("User");
        user.setForeground(Color.BLUE);
      
        
        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced", Font.PLAIN, 12));
        paybill.addActionListener(this);
        user.add(paybill);
        
        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.addActionListener(this);
        billdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        user.add(billdetails);
        
        
        JMenu report = new JMenu("Report");
        report.setForeground(Color.RED);
        
        
        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("monospaced", Font.PLAIN, 12));
        generatebill.addActionListener(this);
        report.add(generatebill);
              
        JMenu mexit = new JMenu("Exit");
        mexit.setForeground(Color.RED);
       
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced", Font.PLAIN, 12));
        exit.addActionListener(this);
        mexit.add(exit);
        
        if(atype.equals("Admin")) {
            mb.add(master);
        }
        else {
             mb.add(info);
             mb.add(user);
             mb.add(report);
        }
  
       
        mb.add(mexit);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if(msg.equals("New Customer")) {
            new NewCustomer();
        }
        else if (msg.equals("Customer Details")) {
                new CustomerDetails();
        }
        else if(msg.equals("Deposite Details")) {
            new DepositDetails();
        }
        else if(msg.equals("Calculate Bill")) {
            new CalculateBill();
        }
        else if(msg.equals("View Information")) {
            new ViewInformation(meter);
        }
        else if(msg.equals("Update Information")) {
            new UpdateInformation(meter);
        }
        else if(msg.equals("Bill Details")) {
            new BillDetails(meter);
        }
        else if(msg.equals("Exit")) {
            setVisible(false);
            new Login();
        }
        else if(msg.equals("Pay Bill")) {
            new PayBill(meter);
        }
        else if(msg.equals("Generate Bill")) {
            new GenerateBill(meter);
        }
        
        
    }
    
    public static void main(String args[]) {
        new Project("", "");
    }
}
