import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class adminLogged extends Frame implements ActionListener{

	private Button logout, bookFlight, viewCustomer, addFlight;
        private Login logoutt;
        private Frame parent;
        private bookFlightAdmin booA;
        private addFlight addF;
        private viewCustomer vw;
	public adminLogged(Login lg){
        logoutt=lg;
        
        booA=new bookFlightAdmin(this);
        addF=new addFlight(this);
        vw=new viewCustomer(this);

        Label name=new Label("Admin logged in");
        logout=new Button("Logout");
        bookFlight=new Button("Book Flight");
        viewCustomer=new Button("View Customer");
        addFlight=new Button("Add Flight");

        this.add(name);
        this.add(logout);
        this.add(bookFlight);
        this.add(viewCustomer);
        this.add(addFlight);

        name.setBounds(40,60,100,30);
        logout.setBounds(600,60,60,30);
        bookFlight.setBounds(130,250,100,60);
        viewCustomer.setBounds(280,250,100,60);
        addFlight.setBounds(430,250,100,60);

        logout.addActionListener(this);
        bookFlight.addActionListener(this);
        addFlight.addActionListener(this);
        viewCustomer.addActionListener(this);

        setLayout(null);
        setSize(700,650);
        setLocation(400,200);
        setTitle("Admin logged in");
	}
    public void paint(Graphics g){
        g.setColor(new Color(6, 45, 60));
        g.fillRect(0,0,700,650);
    }

    public void actionPerformed(ActionEvent ae){
        System.out.println("Button Pressed");
        String s=ae.getActionCommand();
        System.out.println(s);
        if(s.equals("Logout")){
            logoutt.setVisible(true);
            this.setVisible(false);
        }
        else if(s.equals("Book Flight")){
            booA.setVisible(true);
            this.setVisible(false);
        }
        else if(s.equals("Add Flight")){
            addF.setVisible(true);
            this.setVisible(false);

        }
        else if(s.equals("View Customer")){
            vw.setVisible(true);
            this.setVisible(false);
        }
    }
    public void setParent(Frame lg){
        parent=lg;
    }

        public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}