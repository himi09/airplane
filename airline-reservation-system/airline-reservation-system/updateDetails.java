import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class updateDetails extends Frame implements ActionListener{
	private TextField nameT,userNT,emailT,contactT,passT,birthDateT,addressT,genderT;
    private Button updateDetailsB,backB;
    public userSignIn us;
    private Frame parent;

    public updateDetails(userSignIn u){
        us=u;

        Label register=new Label("U P D A T E  D E T A I L S");
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
        updateDetailsB=new Button("Update Details");
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
        this.add(updateDetailsB);
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
        this.add(updateDetailsB);
        this.add(backB);
        register.setBounds(130,50,130,30);
        name.setBounds(55,160,70,20);
        userName.setBounds(55,120,70,20);
        email.setBounds(55,200,70,20);
        contactNo.setBounds(55,240,70,20);
        password.setBounds(55,280,70,20);
        gender.setBounds(55,320,70,20);
        DOB.setBounds(55,360,70,20);
        address.setBounds(55,400,70,20);
        nameT.setBounds(140,160,130,20);
        userNT.setBounds(140,120,130,20);
        emailT.setBounds(140,200,130,20);
        contactT.setBounds(140,240,130,20);
        passT.setBounds(140,280,130,20);
        genderT.setBounds(140,320,130,20);
        birthDateT.setBounds(140,360,130,20);
        addressT.setBounds(140,400,130,60);
        updateDetailsB.setBounds(60,500,90,30);
        backB.setBounds(160,500,70,30);

        backB.addActionListener(this);
        updateDetailsB.addActionListener(this);
        setTitle("Update Details");
        setSize(400,650);
        setLocation(400,200);
        
        this.setLayout(null);
    }
    public void paint(Graphics g){
        g.setColor(new Color(6, 45, 60));
        g.fillRect(0,0,600,650);
    }

    public void actionPerformed(ActionEvent ae){
        System.out.println("Button Pressed");
        String s=ae.getActionCommand();
        System.out.println(s);
        if(s.equals("Update Details")){
            DataAccess da=new DataAccess();
            String q="";
            q="update `registration` set `name` ='" +nameT.getText() + "', `email` ='" +emailT.getText() + "',`pass` ='" +passT.getText() + "',`bdate` ='" +birthDateT.getText() + "',`address` ='"+addressT.getText() + "' where `uname`= '" +userNT.getText()+"'";
            System.out.println("Button pressed"); 
            System.out.println(q);
            int c=da.updateDB(q);
            JOptionPane.showMessageDialog(this,c+" row(s) updated");
        }
        else if(s.equals("Back")){
            us.setVisible(true);
            this.setVisible(false);
        }
        
    }




    public void setParent(userSignIn u){
        parent=u;
    }
       public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}