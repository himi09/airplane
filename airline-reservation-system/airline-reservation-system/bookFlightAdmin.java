import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;  
import java.sql.ResultSet;
import java.sql.SQLException;
public class bookFlightAdmin extends Frame implements ActionListener{
	private TextField cardNoT, flightidT,uunameT,ticketsT;
    private Button showflightB,completeB, backB, showPriceB;
    private TextArea flightBox,ticketPriceT;
    public adminLogged adm;
    private Frame parent;

	public bookFlightAdmin(adminLogged a){

        this.setLayout(null);
        adm=a;
        showflightB=new Button("Show Flight");
        Label flightId=new Label("Flight ID");
        Label fromFlight=new Label("From");
        Label toFlight=new Label("To");

        Label todate=new Label("Date");
        Label toprice=new Label("price");

        Label timeFlight=new Label("Time");
        Label classs=new Label("Class");
        flightBox=new TextArea(100,100);
        Label fflightid=new Label("Flight id");
        Label uuname=new Label("UserName");
        flightidT=new TextField(20);
        uunameT=new TextField(20);
        Label noOfTickets=new Label("No. of Tickets");
        ticketsT=new TextField(20);
        Label ticketPrice=new Label("Ticket Price");
        ticketPriceT=new TextArea(20,20);
        Label payment=new Label("Payment Methods");
        Choice paymentC=new Choice();
        Label cardNo=new Label("Card Number");
        cardNoT=new TextField(20);
        Label type=new Label("Type");
        Choice card=new Choice();
        completeB=new Button("Complete Transaction");
        backB=new Button("Back");
        paymentC.add("---Select Method---");
        paymentC.add("Card");
        card.add("---Choice Card---");
        card.add("Visa Card");
        card.add("Mastercard");
        card.add("American Express");
        showPriceB=new Button("Show Price");
        this.add(showflightB);
        this.add(flightId);
        this.add(fromFlight);
        this.add(toFlight);
        this.add(timeFlight);
        this.add(classs);
        this.add(flightBox);
        this.add(fflightid);
        this.add(flightidT);
        this.add(uuname);
        this.add(uunameT);
        this.add(noOfTickets);
        this.add(ticketsT);
        this.add(ticketPrice);
        this.add(ticketPriceT);
        this.add(payment);
        this.add(paymentC);
        this.add(cardNo);
        this.add(cardNoT);
        this.add(type);
        this.add(card);
        this.add(completeB);
        this.add(backB);   
        this.add(todate);   
        this.add(toprice);
        this.add(showPriceB);    
        showflightB.setBounds(300,40,80,30);
        flightId.setBounds(40,80,50,20);
        fromFlight.setBounds(150,80,40,20);
        toFlight.setBounds(250,80,20,20);
        classs.setBounds(350,80,40,20);
        todate.setBounds(450,80,40,20);

        timeFlight.setBounds(550,80,35,20);
        toprice.setBounds(650,80,35,20);
        flightBox.setBounds(40,110,650,90);

        noOfTickets.setBounds(40,260,80,20);
        ticketsT.setBounds(130,260,60,20);
        ticketPrice.setBounds(220,260,80,20);
        ticketPriceT.setBounds(330,260,90,20);

        showPriceB.setBounds(440,260,80,20);

        fflightid.setBounds(40,220,80,20);
        flightidT.setBounds(140,220,50,20);
        uuname.setBounds(210,220,70,20);
        uunameT.setBounds(300,220,70,20);
        
        payment.setBounds(40,310,100,20);
        paymentC.setBounds(150,310,130,20);
        type.setBounds(40,370,40,20);
        card.setBounds(90,370,130,20);
        cardNo.setBounds(250,370,100,20);
        cardNoT.setBounds(360,370,120,20);
        backB.setBounds(370,450,130,40);
        completeB.setBounds(550,370,130,20);
        
        backB.addActionListener(this);
        showflightB.addActionListener(this);
        showPriceB.addActionListener(this);
        completeB.addActionListener(this);
        setSize(800,650);
        setLocation(400,200);
        setTitle("Book Flight Admin");
        
	}

    public void paint(Graphics g){
        g.setColor(new Color(6, 45, 60));
        g.fillRect(0,0,800,650);
    }
    public void actionPerformed(ActionEvent ae){
        System.out.println("Button Pressed");
        String s=ae.getActionCommand();
        flightBox.setText("");
        //System.out.println(s);

        if(s.equals("Show Flight")){
            DataAccess da=new DataAccess();
            String q="select * from flight";
            ResultSet rs=null;
            System.out.println("Button pressed");  
            try{
                rs=da.getData(q);
                System.out.println(q);
                while(rs.next()){
                            String str=rs.getString("flightID")+"                     "+rs.getString("fromf")+"                    "+rs.getString("tof")+"     "+rs.getString("class")+"       "+rs.getDate("date")+"     "+rs.getTime("time")+"     "+rs.getInt("price");
                            //
                           flightBox.append(str+"\n");
                       }
                         
                        System.out.println("Login Successful");
                        JOptionPane.showMessageDialog(this,"Showed Flight");
                        //break;
                    }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"DB Error");
            }
        }

        else if(s.equals("Show Price")){
            DataAccess da=new DataAccess();
            String typenotickets=ticketsT.getText();
            String typedflightid=flightidT.getText();
            String typeduname=uunameT.getText();
            int i=Integer.parseInt(typenotickets);
            int result=0;
            String q="select flightID,price from flight";
            ResultSet rs=null;
            System.out.println("Button pressed");
            try{
                rs=da.getData(q);
                System.out.println(q);
                while(rs.next()){
                    String n = rs.getString("flightID");
                    String p=rs.getString("price");
                    int j=Integer.parseInt(p);
                    if(n.equals(typedflightid)){
                        result=j*i;
                        String str1 = Integer.toString(result);
                        ticketPriceT.append(str1);
                        System.out.println("Login Successful");
                        JOptionPane.showMessageDialog(this,"Showed Price");
                        break;
                    }   
                } 

            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"DB Error");
            }
        }

        else if(s.equals("Complete Transaction")){
            DataAccess da=new DataAccess();
            String typenotickets=ticketsT.getText();
            String typedflightid=flightidT.getText();
            String typeduname=uunameT.getText();
            String typecard=cardNoT.getText();
            int i=Integer.parseInt(typenotickets);
            int result=0;
            String q="";
            q="insert into `bookflight` values('"+flightidT.getText()+"','"+uunameT.getText()+"')";
            System.out.println(q);
            int c=da.updateDB(q);
            JOptionPane.showMessageDialog(this,c+" Complete Transaction");
        }

        else if(s.equals("Back")){
            adm.setVisible(true);
            this.setVisible(false);
        }
    }
    
    public void setParent(adminLogged a){
        parent=a;
    }
}