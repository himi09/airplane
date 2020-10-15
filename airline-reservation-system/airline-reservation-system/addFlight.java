import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class  addFlight extends Frame implements ActionListener{
	private TextField flightIDT, fromT,toT,classT,dateT,timeT,priceT;
    private Button addedB,backB;

    private adminLogged lg;
    private Frame parent;

    public addFlight(adminLogged ll){
        lg=ll;
        Label addflightt=new Label("A D D   F L I G H T");
        Label flightID=new Label("Flight ID"); 
        Label from=new Label("From");
        Label to=new Label("To");
        Label classs=new Label("Class");
        Label date=new Label("Date");
        Label time=new Label("Time");
        Label price=new Label("Price");  
        flightIDT=new TextField(20);
        fromT=new TextField(20);
        toT=new TextField(20);
        classT=new TextField(20);
        dateT=new TextField(20);
        timeT=new TextField(20);
        priceT=new TextField(20);
        addedB=new Button("Add Flight");
        backB=new Button("Back");
        this.add(addflightt);
        this.add(flightID);
        this.add(from);
        this.add(to);
        this.add(classs);
        this.add(date);
        this.add(time);
        this.add(price);


        this.add(flightIDT);
        this.add(fromT);
        this.add(toT);
        this.add(classT);
        this.add(dateT);
        this.add(timeT); 
        this.add(priceT);

        this.add(addedB);
        this.add(backB);
        addflightt.setBounds(130,50,130,30);
        flightID.setBounds(55,120,70,20);
        from.setBounds(55,160,70,20);
        to.setBounds(55,200,70,20);
        classs.setBounds(55,240,70,20);
        date.setBounds(55,280,70,20);
        time.setBounds(55,320,70,20);
        price.setBounds(55,360,70,20);

        flightIDT.setBounds(140,120,130,20);
        fromT.setBounds(140,160,130,20);
        toT.setBounds(140,200,130,20);
        classT.setBounds(140,240,130,20);
        dateT.setBounds(140,280,130,20);
        timeT.setBounds(140,320,130,20);
        priceT.setBounds(140,360,130,20);
        

        addedB.setBounds(60,500,70,30);
        backB.setBounds(160,500,70,30);

        addedB.addActionListener(this);
        backB.addActionListener(this);

        setSize(400,650);
        setLocation(400,200);
        setTitle("Add Flight");
        setLayout(null);
    }
    public void paint(Graphics g){
        g.setColor(new Color(6, 45, 60));
        g.fillRect(0,0,400,650);
    }
    public void actionPerformed(ActionEvent ae){
        System.out.println("Button Pressed");
        String s=ae.getActionCommand();
        System.out.println(s);
        if(s.equals("Add Flight")){
            DataAccess da=new DataAccess();
            String q="";
            q="insert into `flight` values('"+flightIDT.getText()+"','"+fromT.getText()+"','"+toT.getText()+"','"+classT.getText()+"','"+dateT.getText()+"','"+timeT.getText()+"','"+priceT.getText()+"')";
            System.out.println(q);
            int c=da.updateDB(q);
            JOptionPane.showMessageDialog(this,c+" row(s) updated");
        }
        else if(s.equals("Back")){
            lg.setVisible(true);
            this.setVisible(false);
            
        }
    }
    public void setParent(Frame ll){
        parent=ll;
    }
        public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}