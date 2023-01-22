package Formation;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Formation extends JFrame implements ActionListener,MenuListener {
	 public JButton jButton1;
	    public JLabel jLabel1;
	    public JMenu jMenu1;
	    public JMenu jMenu2;
	    public JMenu jMenu3;
	    public JMenuBar jMenuBar1;
	    public JMenuItem jMenuItem1;
	    
	    public JMenuItem jMenuItem3;
	    public JMenuItem jMenuItem4;
	    public JMenuItem jMenuItem5;
	    public JMenuItem jMenuItem6;
	    public JPanel jPanel1;
	    
	    public Formation(){
	    	setBounds(0, 0, 1000, 500);
	        jPanel1 = new JPanel();
	        
	        jButton1 = new JButton();
	        jLabel1 = new JLabel();
	        jMenuBar1 = new JMenuBar();
	        jMenu1 = new JMenu();
	        jMenuItem1 = new JMenuItem();
	        
	        jMenuItem3 = new JMenuItem();
	        jMenu2 = new JMenu();
	        jMenuItem4 = new JMenuItem();
	        jMenuItem5 = new JMenuItem();
	        jMenuItem6 = new JMenuItem();
	        jMenu3 = new JMenu();
	        jPanel1.setBackground(new java.awt.Color(27, 37, 51));

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        
	        jMenuBar1.setBackground(new java.awt.Color(27, 37, 51));
	        jMenuBar1.setSize(500,300);
	        jButton1.setBackground(new java.awt.Color(27, 37, 51));
	        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
	        jButton1.setForeground(new java.awt.Color(242, 242, 242));
	        jButton1.setText("Connecter");
	        jButton1.setBorderPainted(false);
	        
	        
	        
	        jButton1.setBounds(750, 130, 150, 50);
	        jButton1.addActionListener(this);
	        
	        jLabel1.setIcon(new javax.swing.ImageIcon(".\\src\\Formation\\Artboard 1@11x.png")); 
	        
	        jLabel1.add(jButton1);
	        jPanel1.add(jLabel1);

	        getContentPane().add(jPanel1);

	        jMenuBar1.setBorder(null);

	        jMenu1.setText("Formation");
	        jMenu1.setForeground(new java.awt.Color(242, 242, 242));
	        

	        jMenuItem1.setText("Catalogue");
	        jMenuItem1.setBackground(new java.awt.Color(27, 37, 51));

	        jMenuItem1.setForeground(new java.awt.Color(242, 242, 242));
	        jMenu1.add(jMenuItem1);
	        jMenuItem1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ev) {
	                Catalogue c=new Catalogue();
	                c.setVisible(true);
	                c.setSize(1000,500	);
	                c.setBounds(10, 60, 1000, 500);
	        }
	    });
	        jMenuItem3.setText("Offres speciales");
	        jMenuItem3.setBackground(new java.awt.Color(27, 37, 51));
	        jMenuItem3.setForeground(new java.awt.Color(242, 242, 242));
	        jMenuItem3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ev) {
	                Offres c=new Offres();
	                c.setVisible(true);
	                c.setSize(1000,500	);
	                c.setBounds(10, 60, 1000, 500);
	        }
	    });
	        jMenu1.add(jMenuItem3);

	        jMenuBar1.add(jMenu1);

	        jMenu2.setText("Notre groupe");
	        jMenu2.setForeground(new java.awt.Color(242, 242, 242));

	        jMenuItem4.setText("Qui somme nous?");
	        jMenuItem4.setBackground(new java.awt.Color(27, 37, 51));
	        jMenuItem4.setForeground(new java.awt.Color(242, 242, 242));
	        jMenu2.add(jMenuItem4);
	        jMenuItem4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ev) {
	                QuiSommeNous c=new QuiSommeNous();
	                c.setVisible(true);
	                c.setSize(1000,500	);
	                c.setBounds(10, 60, 1000, 500);
	        }
	    });

	        jMenuItem5.setText("Nos formateurs");
	        jMenuItem5.setBackground(new java.awt.Color(27, 37, 51));
	        jMenuItem5.setForeground(new java.awt.Color(242, 242, 242));
	        jMenu2.add(jMenuItem5);
	        jMenuItem5.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ev) {
	                NosFormateurs c=new NosFormateurs();
	                c.setVisible(true);
	                c.setSize(1000,500	);
	                c.setBounds(10, 60, 1000, 500);
	        }
	    });

	        jMenuItem6.setText("Nos centres");
	        jMenuItem6.setBackground(new java.awt.Color(27, 37, 51));
	        jMenuItem6.setForeground(new java.awt.Color(242, 242, 242));
	        jMenu2.add(jMenuItem6);
	        jMenuItem6.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ev) {
	                NosCentres c=new NosCentres();
	                c.setVisible(true);
	                c.setSize(1000,500	);
	                c.setBounds(10, 60, 1000, 500);
	        }
	    });

	        jMenuBar1.add(jMenu2);

	        jMenu3.setText("Nos contacts");
	        jMenu3.setForeground(new java.awt.Color(242, 242, 242));
	        jMenu3.addMenuListener(this);
	     
	        jMenuBar1.add(jMenu3);
	        

	        setJMenuBar(jMenuBar1);
            
	        setSize(1000,500);
	        setVisible(true);
	        pack();
	    }
	    
	    public static void main(String args[])
	    {
	    	new Formation();
	    }

		@Override
		public void actionPerformed(ActionEvent e ) {
			JButton j=(JButton)e.getSource();
			if(j==jButton1) {
				Login n=new Login();
				n.setVisible(true);
				n.setSize(1000,500);
			}
			
		}

		@Override
		public void menuCanceled(MenuEvent arg0) {
		    NosContacts c=new NosContacts();
            c.setVisible(true);
            c.setSize(1000,500	);
            c.setBounds(10, 60, 1000, 500);
			
		}

		@Override
		public void menuDeselected(MenuEvent arg0) {
		    NosContacts c=new NosContacts();
            c.setVisible(true);
            c.setSize(1000,500	);
            c.setBounds(10, 60, 1000, 500);
			
		}

		@Override
		public void menuSelected(MenuEvent arg0) {
		    NosContacts c=new NosContacts();
            c.setVisible(true);
            c.setSize(1000,500	);
            c.setBounds(10, 60, 1000, 500);
			
		}

}
