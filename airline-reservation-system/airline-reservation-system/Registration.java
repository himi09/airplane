import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class  Registration extends Frame implements ActionListener{
	private TextField nameT,userNT,emailT,contactT,passT,birthDateT,addressT,genderT;
    private Button registerB,backB;
    private Login logg;
    private Frame parent;

    public Registration(Login ll){
        logg=ll;
        Label register=new Label("R E G I S T R A T I O N");
        Label name=new Label("Full Name"); 
        Label userName=new Label("Username");
        Label email=new Label("Email");
        Label contactNo=new Label("Contact No.");
        Label password=new Label("Password:");
        Label gender=new Label("Gender");
        Label DOB=new Label("Birth Date");
        Label address=new Label("Address");  
        nameT=new TextField(20);
        userNT=new TextField(20);
        emailT=new TextField(20);
        contactT=new TextField(20);
        passT=new TextField(20);
        passT.setEchoChar('*');

        genderT=new TextField(20);
        birthDateT=new TextField(20);
        addressT=new TextField(20);
        registerB=new Button("Register");
        backB=new Button("Back");
        this.add(register);
        this.add(name);
        this.add(userName);
        this.add(email);
        this.add(contactNo);
        this.add(password);
        this.add(gender);
        this.add(DOB);
        this.add(address);
        this.add(nameT);
        this.add(userNT);
        this.add(emailT);
        this.add(contactT);
        this.add(passT);
        this.add(genderT); 
        this.add(birthDateT);
        this.add(addressT);
        this.add(registerB);
        this.add(backB);
        this.add(register);
        this.add(name);
        this.add(userName);
        this.add(email);
        this.add(contactNo);
        this.add(password);
        this.add(gender);
        this.add(DOB);
        this.add(address);
        this.add(nameT);
        this.add(userNT);
        this.add(emailT);
        this.add(contactT);
        this.add(passT);
        this.add(genderT); 
        this.add(birthDateT);
        this.add(addressT);
        this.add(registerB);
        this.add(backB);
        register.setBounds(130,50,130,30);
        name.setBounds(55,120,70,20);
        userName.setBounds(55,160,70,20);
        email.setBounds(55,200,70,20);
        contactNo.setBounds(55,240,70,20);
        password.setBounds(55,280,70,20);
        gender.setBounds(55,320,70,20);
        DOB.setBounds(55,360,70,20);
        address.setBounds(55,400,70,20);
        nameT.setBounds(140,120,130,20);
        userNT.setBounds(140,160,130,20);
        emailT.setBounds(140,200,130,20);
        contactT.setBounds(140,240,130,20);
        passT.setBounds(140,280,130,20);
        genderT.setBounds(140,320,130,20);
        birthDateT.setBounds(140,360,130,20);
        addressT.setBounds(140,400,130,60);
        registerB.setBounds(60,500,70,30);
        backB.setBounds(160,500,70,30);
        registerB.addActionListener(this);
        backB.addActionListener(this);
        setSize(400,650);
        setLocation(400,200);
        setTitle("Registration");
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
        if(s.equals("Register")){
            DataAccess da=new DataAccess();
            String q="";
            q="insert into `registration` values(null,'"+nameT.getText()+"','"+userNT.getText()+"','"+emailT.getText()+"','"+contactT.getText()+"','"+passT.getText()+"','"+genderT.getText()+"','"+birthDateT.getText()+"','"+addressT.getText()+"')";
            System.out.println(q);
            int c=da.updateDB(q);
            JOptionPane.showMessageDialog(this,c+" row(s) updated");
        }
        else if(s.equals("Back")){
            logg.setVisible(true);
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