package Formation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class NosFormateurs extends JFrame implements ActionListener {

private JLabel jLabel2;
private JPanel jPanel2;
private JButton j;
NosFormateurs()
   {
   super("nos formateurs ");
   jLabel2=new JLabel();
   jPanel2=new JPanel();
   j=new JButton("Retourner");
   j.setBackground(new java.awt.Color(28,37,52,255));
   j.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
   j.setForeground(new java.awt.Color(242, 242, 242));
   j.setBorderPainted(false);
   jLabel2.add(j);
   
   
   j.setBounds(850, 15, 150, 50);
   j.addActionListener(this);
   setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
   jLabel2.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Bureau\\SoumaDidiYoyo\\src\\Formation\\nosformateurs.jpg"));
   jPanel2.add(jLabel2);
   add(jPanel2);
pack();

   }
   public static void main(String args[])
   {
	   NosFormateurs b=new NosFormateurs();
    b.setSize(1000,540);
   b.setVisible(true);
   }
@Override
public void actionPerformed(ActionEvent e) {
	setVisible(false);
	
}

}


