package Formation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class EspaceFormateur extends JFrame implements ActionListener,ItemListener,MouseListener {
		
		// les composants a utiliser
	    public int i;
		private JButton jButton2;
	    private JButton jButton3;
	    private JButton jButton5;
	    private JButton jButton6;
	    private JLabel jLabel6;
	    private JLabel jLabel3;
	    private JLabel jLabel4;
	    private JLabel jLabel5;
	    private JRadioButton jRadioButton1 ;
        private JRadioButton jRadioButton2;
	    private JLabel jLabel1;
	    private JLabel jLabel2;
	    private JScrollPane jScrollPane2;
	    private JTable jTable2;
	    private JTextField jTextField1;
	    private JTextField jTextField2;
	    private JComboBox<String> jComboBox1;
	    DefaultTableModel model;
		Connection con;
		Statement stmt;
		String sql;	
		ResultSet rs;
		String mailF;
	
	    EspaceFormateur(String mailF)
	    {
	    	super ("EspaceFormateur"); 
	    	setBounds(0,0,1000,500);
	    	// instances
	    	this.mailF=mailF;
	        
	        jComboBox1 = new JComboBox<>();
	        jLabel5 = new JLabel("Annuler Formation");
	        jButton5 = new JButton("Retourner");
	        jButton6 = new JButton("Obtenir certificat");
	        jButton3 = new JButton();
	        jButton2 = new JButton("Modifier");
	        jButton2.addActionListener(this);
	        jLabel2 = new JLabel();
	        jLabel6 = new JLabel();
	        jLabel3 = new JLabel("Vos Formations");
	        jLabel4 = new JLabel("Modifier n°Téléphone:");
	        jLabel6 = new JLabel("Modifier Mot de passe:");
	        jTextField1=new JTextField();
	        jTextField2=new JTextField();
	        jLabel2.add(jTextField1);
	        jTextField1.setBounds(145, 250, 70, 22);
	        jButton2.setBounds(220, 250, 80, 22);
	        jLabel3.setBounds(340, 10, 130, 22);
	        jLabel4.setBounds(10, 250, 200, 22);
	        jLabel6.setBounds(10, 290, 200, 22);
	        jLabel2.add(jLabel6);
	        jTextField2.setBounds(190, 290, 90, 22);
	        jLabel2.add(jTextField2);
	        jLabel1 = new JLabel("Vouler-vous avoir une certification ?");
	        jRadioButton1 = new JRadioButton("oui");
	         jRadioButton2 = new JRadioButton("Non");
	        
	        ButtonGroup G = new ButtonGroup();
	        G.add(jRadioButton1);
	        G.add(jRadioButton2);
	        jRadioButton1.addItemListener(this);
	        
	        jLabel2.add(jComboBox1);
	        jComboBox1.setBounds(30, 145, 160, 22);
	        
	     
	        try 
	        {  
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
	          
	            String query = "SELECT NomF FROM formation,formateur where formation.formateur=formateur.Id_formateur and formateur.Mail='"+mailF+"'";
	          
	            Statement stm = con.createStatement();
	            ResultSet res = stm.executeQuery(query);
	           
	            while (res.next()) {
	                String abc=res.getString("NomF");
	            	jComboBox1.addItem(abc);
                   
	            }
	            
		    
	          } catch(Exception e1) {
	            e1.printStackTrace();
	          }
	        jComboBox1.addItemListener(this);
	        model = new DefaultTableModel();
	        jTable2 = new JTable(model);
	        jScrollPane2 = new JScrollPane(jTable2);
	        jTable2.setShowGrid(true);
	        jTable2.setShowVerticalLines(true);
	        
	        model.addColumn("Nom Formation");
	        model.addColumn("Votre salaire");
	        model.addColumn("Durée");
	        model.addColumn("Date début");
	        model.addColumn("Nb participant");
	        model.addColumn("Categorie");

	        try 
	        {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
	          
	            String query = "SELECT * FROM formation,formateur where formation.formateur=formateur.Id_formateur and formateur.Mail='"+mailF+"'";
	          
	            Statement stm = con.createStatement();
	            ResultSet res = stm.executeQuery(query);
	           
	            while (res.next()) {
	            
	            	model.addRow(new Object[] {res.getString("NomF"),res.getInt("SalaireFormateur")+"",res.getString("duree")
	            			, res.getDate("dateDebut"),res.getInt("nParticipant")+"",res.getString("Categorie")});
	           
	            }
	            
		    
	          } catch(Exception e) {
	            e.printStackTrace();
	          }
	        jTable2.setModel(model);
	        jScrollPane2.setViewportView(jTable2);
	        jTable2.addMouseListener(this);

	        jLabel2.add(jScrollPane2);
	        jScrollPane2.setBounds(340, 60,630, 380);
	        jLabel2.setIcon(new ImageIcon(".\\src\\Formation\\EspaceFormateur.jpeg"));
	        // Position 
	        jLabel5.setBounds(30, 100, 200, 30);
	        jButton3.setBounds(30, 190, 200, 30);
	        jRadioButton1.setBounds(30,360,50,30);
	        jRadioButton2.setBounds(180,360,50,30);
	        jButton5.setBounds(10, 420, 100, 20);
	        jButton6.setBounds(160, 420, 160, 20);
	        jRadioButton1.setOpaque(true);
	        jRadioButton1.setContentAreaFilled(false);
	        jRadioButton1.setBorderPainted(false);
	        jButton5.setOpaque(true);
	        jButton5.setContentAreaFilled(false);
	        jButton5.setBorderPainted(true);
	        jButton5.setForeground(new java.awt.Color(240,255,240));
	        jButton2.setOpaque(true);
	        jButton2.setContentAreaFilled(false);
	        jButton2.setBorderPainted(true);
	        jButton2.setForeground(new java.awt.Color(240,255,240));
	        jButton6.setOpaque(true);
	        jButton6.setContentAreaFilled(false);
	        jButton6.setBorderPainted(true);
	        jButton6.setForeground(new java.awt.Color(240,255,240));
	        jRadioButton2.setOpaque(true);
	        jRadioButton2.setContentAreaFilled(false);
	        jRadioButton2.setBorderPainted(false);
	        jLabel1.setBounds(30, 320, 300, 60);  
	        
	       
	        jLabel2.add(jButton3);
	        jLabel2.add(jButton2);
	        jLabel2.add(jLabel1);
	        
	        jLabel2.add(jRadioButton1);
	        jLabel2.add(jRadioButton2);
	        jLabel2.add(jButton5);
	        jLabel2.add(jButton6);
            jLabel2.add(jLabel3);
            jLabel2.add(jLabel4);
            jLabel2.add(jLabel5);
	        
	      	// DES
	        jButton3.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
	        jButton3.setText("Contacter Administration");
	        jLabel1.setForeground(new java.awt.Color(240,255,240));
	        jLabel5.setForeground(new java.awt.Color(240,255,240));
	        jLabel4.setForeground(new java.awt.Color(240,255,240));
	        jLabel3.setForeground(new java.awt.Color(240,255,240));
	        jLabel6.setForeground(new java.awt.Color(240,255,240));
	        jRadioButton2.setForeground(new java.awt.Color(240,255,240));
	        jRadioButton1
	        .setForeground(new java.awt.Color(240,255,240));


	        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 12));
	        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 12));
	        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 1, 12));

	        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 1, 12));// NOI18N
	         
	    
	        
            
	        
	         add(jLabel2);
	         pack();
	         
	         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	     }
	
		@Override
		public void itemStateChanged(ItemEvent e) {
			 if(e.getSource()==jComboBox1) {
				  if(e.getStateChange() == ItemEvent.SELECTED) {
					 
					 try {
						        System.out.println("offff");
					            Class.forName("com.mysql.cj.jdbc.Driver");
					             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
					             String query = "delete from formation,formateur where NomF = ?  and  formateur.Mail='"+mailF+"'";
					             PreparedStatement preparedStmt = con.prepareStatement(query);
					             preparedStmt.setString(1,jComboBox1.getSelectedItem().toString());

					             preparedStmt.executeUpdate();
					             con.close();
					 }
						    	  catch(Exception e1) {
						        e1.printStackTrace();}
					 model.setRowCount(0);
					 try 
				        {
				        	 Class.forName("com.mysql.cj.jdbc.Driver");
				             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
				          
				            String query = "SELECT * FROM formation";
				          
				            Statement stm = con.createStatement();
				            ResultSet res = stm.executeQuery(query);
				           
				            while (res.next()) {
				            
				            	model.addRow(new Object[] {res.getString("NomF"),res.getInt("SalaireFormateur")+"",res.getString("duree")
				            			, res.getDate("dateDebut"),res.getInt("nParticipant")+"",res.getString("Categorie")});
				           
				            }
				            
					    
				          } catch(Exception e1) {
				            e1.printStackTrace();
				          }
					
				 }
				  }
			 else if(e.getSource()==jRadioButton1) {
				 if(e.getStateChange() == 1) {
					 try {
					   		
			              Class.forName("com.mysql.cj.jdbc.Driver");
			             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
			            
			             String sql2="select UserName from formateur where Mail='"+mailF+"'";
			             Statement stm=con.createStatement();
			              ResultSet res = stm.executeQuery(sql2);
			              res.next();
					 
					 JOptionPane.showMessageDialog(null, "Choisir la formation");
					 Certif c=new Certif(model.getValueAt(i, 0).toString(),model.getValueAt(i, 3).toString(),res.getString("UserName"));
					 c.setVisible(true);
					 c.setSize(1090,530);
					 c.setBounds(100,100,1000,515);
					 con.close();
					 }
					 
			    	  catch(Exception e1) {
			        e1.printStackTrace();}
				 }
			 }
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton j=(JButton)e.getSource();
			if(j==jButton2) {
				try {
				       System.out.println(mailF);
				    String vTel=jTextField1.getText();
		            Class.forName("com.mysql.cj.jdbc.Driver");
		             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
		            
		             String query = "update formateur set Tel = ? where Mail = ?";
		             PreparedStatement preparedStmt = con.prepareStatement(query);
		             preparedStmt.setString   (1, vTel);
		             preparedStmt.setString(2, mailF);
		       
		             preparedStmt.executeUpdate();
			    	}
			 
			    	  catch(Exception e1) {
			        e1.printStackTrace();}
			}
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				 i=jTable2.getSelectedRow();
			    
			}
					
				catch(Exception e1){
				 e1.printStackTrace();
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	 
}
