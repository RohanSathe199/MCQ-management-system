import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ButtonDemo extends JFrame
{
     JButton yes,no,close;
     JLabel lbl;
     ButtonDemo()
     {
          yes = new JButton("JAVA");
          no = new JButton ("STE");
          close = new JButton ("OSY");
          lbl = new JLabel ("");
          setLayout (new GridLayout(4,1));
          setSize (400,200);
          add(yes);
          add(no);
          add(close);
          add(lbl);
          setVisible(true);

          //setDefaultCloseOperation(JFrame.EXIT_NO_CLOSE);
          ButtonHandler bh = new ButtonHandler();
          yes.addActionListener(bh);
          yes.addActionListener(bh);
          no.addActionListener(bh);
          close.addActionListener(bh);
     }
     class ButtonHandler implements ActionListener
     {
          public void actionPerformed(ActionEvent ae)
          {
               if (ae.getSource()==yes)
               {
                   
             setVisible(true);
             new OnlineTest1().setVisible(true);
             //this.setVisible(false);
            
               }
               if (ae.getSource()==no)
               {
            
              setVisible(true);
              new Test1().setVisible(true);
             
               }
               if (ae.getSource()==close)
               {
               setVisible(true);
               new Test2().setVisible(true);
             
               }
          }
     }
     public static void main(String args[])
     {
          ButtonDemo bdemo=new ButtonDemo();
          bdemo.setResizable(true);

     }
}