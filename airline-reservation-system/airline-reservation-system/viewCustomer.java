import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class viewCustomer extends Frame implements ActionListener{
	private TextField searchT;
    private TextArea bookBox;
	private Button searchB,cancelTicketB,backB;
    private adminLogged addl;
    private Frame parent;

	public viewCustomer(adminLogged ll){
        addl=ll;
		setLayout(new FlowLayout());
        this.setLayout(null);
        Label search=new Label("Search");
        searchT=new TextField(20);
        Label unamee=new Label("Username");
        searchB=new Button("Show Customer");

        Label name=new Label("Flight ID");
        Label uName=new Label("Username");
        bookBox=new TextArea(20,100);
        backB=new Button("Back");
        this.add(searchB);
        this.add(name);
        this.add(uName);
        this.add(bookBox);
        this.add(backB);

        searchB.setBounds(330,65,100,30);
        name.setBounds(20,100,70,30);
        uName.setBounds(100,100,70,30);
        bookBox.setBounds(20,130,710,190);
        backB.setBounds(330,350,100,50);
        backB.addActionListener(this);
        searchB.addActionListener(this);

        setSize(750,650);
        setLocation(400,200);
        setTitle("View Customer");

	}
    public void paint(Graphics g){
        g.setColor(new Color(6, 45, 60));
        g.fillRect(0,0,750,650);
    }

        public void actionPerformed(ActionEvent ae){
        System.out.println("Button Pressed");
        String s=ae.getActionCommand();
        System.out.println(s);
        if(s.equals("Back")){
            addl.setVisible(true);
            this.setVisible(false);
        }
        else if(s.equals("Show Customer")){
            DataAccess da=new DataAccess();
            String q="select flightID,uname from bookflight";
            ResultSet rs=null;
            System.out.println("Button pressed");  
            try{
                rs=da.getData(q);
                System.out.println(q);
                while(rs.next()){
                            String str=rs.getString("flightID")+"                     "+rs.getString("uname");
                            //
                           bookBox.append(str+"\n");
                       }
                         
                        System.out.println("Login Successful");
                        JOptionPane.showMessageDialog(this,"All Customer ");
                        //break;
                    }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"DB Error");
            }         
        }
    }
    public void setParent(Frame ll){
        parent=ll;
    }
}