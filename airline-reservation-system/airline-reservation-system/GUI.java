import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.*;
    public class GUI{
         public static void main(String args[]){
            Login g=new Login();
            g.setVisible(true);

    }
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}