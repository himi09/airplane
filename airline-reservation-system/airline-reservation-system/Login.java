import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends Frame implements ActionListener, WindowListener{
    public Registration rg;
    public userSignIn sg;
    public adminLogged alg;
    

    public TextField uNameT,uPassT,aNameT,aPassT;
    public Button uSignIn,uRegister,aSignIn, aRegister;

    public Login(){

        sg=new userSignIn(this);
        rg=new Registration(this);
        alg=new adminLogged(this);

        Label forUser=new Label("FOR USER");
        Label loginS=new Label("L O G I N  S Y S T E M");
        Label uName=new Label("Username:");
        Label uPass=new Label("Password:");
        Label register=new Label("Not a member yet?");
        Label forAdmin=new Label("FOR ADMIN");
        Label aName=new Label("Username:");
        Label aPass=new Label("Password:");
        uNameT=new TextField(20);
        uPassT=new TextField(20);
        aNameT=new TextField(20);
        aPassT=new TextField(20);
        uPassT.setEchoChar('*');
        aPassT.setEchoChar('*');
        uSignIn=new Button("Sign In");
        uRegister=new Button("Registration");
        aSignIn=new Button("LogIn");
        this.add(loginS);
        this.add(forUser);
        this.add(uName);
        this.add(uNameT);
        this.add(uPass);
        this.add(uPassT);
        this.add(uSignIn);
        this.add(register);
        this.add(uRegister);
        this.add(forAdmin);
        this.add(aName);
        this.add(aPass);
        this.add(aNameT);
        this.add(aPassT);
        this.add(aSignIn);
        uSignIn.addActionListener(this);
        uRegister.addActionListener(this);
        aSignIn.addActionListener(this);
        addWindowListener(this);
        loginS.setBounds(140,50,120,30);
        forUser.setBounds(70,100,65,20);
        uName.setBounds(70,140,70,20);
        uPass.setBounds(70,170,70,20);
        uNameT.setBounds(150,140,130,20);
        uPassT.setBounds(150,170,130,20);
        uSignIn.setBounds(100,200,70,30);
        register.setBounds(70,240,110,20);
        uRegister.setBounds(190,240,70,20);
        forAdmin.setBounds(70,320,70,20);
        aName.setBounds(70,360,70,20);
        aPass.setBounds(70,390,70,20);
        aNameT.setBounds(150,360,130,20);
        aPassT.setBounds(150,390,130,20);
        aSignIn.setBounds(100,420,70,30);
        setLayout(null);
        setSize(400,650);
        setLocation(400,200);
        setTitle("Login System");
    }
    public void paint(Graphics g){
        g.setColor(new Color(6, 45, 60));
        g.fillRect(0,0,400,650);
    }
    public void actionPerformed(ActionEvent e){
        String s=e.getActionCommand();
        if(s.equals("Registration")){
            rg.setVisible(true);
            this.setVisible(false);
        }
        else if(s.equals("Sign In")){

            DataAccess da=new DataAccess();
            String typedName=uNameT.getText();
            String typedPass=uPassT.getText();
            String q="select uname,pass from registration";
            ResultSet rs=null;
            System.out.println("Button pressed");       
            try{
                rs=da.getData(q);
                System.out.println(q);
                while(rs.next()){
                    String n = rs.getString("uname");
                    String p= rs.getString("pass");
                    if(n.equals(typedName) && p.equals(typedPass)){
                        System.out.println("Login Successful");
                        //JOptionPane.showMessageDialog(this,"Login Successful");
                        this.setVisible(false);
                        sg.setVisible(true);
                        sg.setParent(this);
                        break;
                    }   
                } 

            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"DB Error");
            }

        }
        else if(s.equals("LogIn")){

            DataAccess da=new DataAccess();
            String typedName=aNameT.getText();
            String typedPass=aPassT.getText();
            String q="select uname,pass from admin";
            ResultSet rs=null;
            System.out.println("Button pressed");       
            try{
                rs=da.getData(q);
                System.out.println(q);
                while(rs.next()){
                    String n = rs.getString("uname");
                    String p= rs.getString("pass");
                    if(n.equals(typedName) && p.equals(typedPass)){
                        System.out.println("Login Successful");
                        JOptionPane.showMessageDialog(this,"Login Successful");
                        alg.setVisible(true);
                        this.setVisible(false);
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"Incorrect Password");
                    }
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"DB Error");
            }
        }
    }
    public void windowActivated(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowClosing(WindowEvent e){
        //this.setVisible(false);
        System.exit(0);
        //System.out.println("Window closing");
    }
    public void windowDeactivated(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowOpened(WindowEvent e){}
}