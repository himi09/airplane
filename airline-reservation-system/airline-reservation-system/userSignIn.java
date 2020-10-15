import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class userSignIn extends Frame implements ActionListener{
	
    private Button logoutB, updateDetailsB, bookFlightB, noticeB, viewBookingB;

    private Login log;
    private Frame parent;
    public updateDetails upd;
    public bookFlight book;
    public userSignIn(Login l){
        log=l;
        book=new bookFlight(this);
        upd =new updateDetails(this);

        Label name=new Label("user logged in");
        logoutB=new Button("Logout");
        updateDetailsB=new Button("Update Details");
        bookFlightB=new Button("Book Flight");
        noticeB=new Button("Notice");
        viewBookingB=new Button("View Booking");
        this.add(name);
        this.add(logoutB);
        this.add(updateDetailsB);
        this.add(bookFlightB);
        this.add(noticeB);
        this.add(viewBookingB);
        name.setBounds(20,60,100,20);
        logoutB.setBounds(500,60,60,30);
        updateDetailsB.setBounds(100,200,100,40);
        bookFlightB.setBounds(350,200,100,40);
        //noticeB.setBounds(100,300,100,40);
        //viewBookingB.setBounds(350,300,100,40);

        logoutB.addActionListener(this);
        updateDetailsB.addActionListener(this);
        bookFlightB.addActionListener(this);
        //addWindowListener(this);
        setLayout(null);
        setSize(600,650);
        setLocation(400,200);
        setTitle("Air Ticket Reservation System - Logged In");

    }
     public void paint(Graphics g){
        g.setColor(new Color(6, 45, 60));
        g.fillRect(0,0,600,650);
    }

    public void actionPerformed(ActionEvent ae){
        System.out.println("Button Pressed");
        String s=ae.getActionCommand();
        System.out.println(s);

        if(s.equals("Logout")){
            JOptionPane.showMessageDialog(this,"logout");
            log.setVisible(true);
            this.setVisible(false);
        }
        else if(s.equals("Update Details")){
            upd.setVisible(true);
            this.setVisible(false);

        }
        else if(s.equals("Book Flight")){
        	book.setVisible(true);
        	this.setVisible(false);
        }

    }
    public void setParent(Frame l){
        parent=l;
    }

    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}