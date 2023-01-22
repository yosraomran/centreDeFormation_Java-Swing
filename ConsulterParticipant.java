package Formation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
public class ConsulterParticipant extends JFrame implements ActionListener,ItemListener  {
	
	    private JButton jButton2;
	    private JButton jButton3;
	    private JComboBox<String> jComboBox1;

	    private JLabel jLabel3;
	    private JLabel jLabel4;
	    private JLabel jLabel5;
	    private JLabel jLabel7;
	    private JLabel jLabel8;
	    private JPanel jPanel1;
	    private JScrollPane jScrollPane1;
	    private JTable jTable1;
	    private JTextField jTextField1;

	    private JTextField jTextField3;
	    DefaultTableModel model;
	  	String vUser;
	   	int vTel;
	    String vMail;
	    String myPass;
	    int vCin;
	    String vFormation;
	      
		Connection con;
		
		Statement stmt;
		Statement stmt1;
		
		String sql;
		String sql2;
		
		ResultSet rs;
		ResultSet rs1;
		// End of variables declaration 
	    ConsulterParticipant()
	           {
	    	super ("Consultation Participant"); 
	    	setBounds(0, 0, 1000, 537);
	    	// instances
	        jPanel1 = new JPanel();
	      
	        jComboBox1 = new JComboBox<>();
	        jTextField1 = new JTextField();
	        jScrollPane1 = new JScrollPane();
	        jTable1 = new JTable();
	        jTextField3 = new JTextField();
	        jButton2 = new JButton();
	        jButton3 = new JButton();
	      
	        jLabel3 = new JLabel();
	        jLabel4 = new JLabel();
	        jLabel5 = new JLabel();
	        jLabel7 = new JLabel();
	        jLabel8 = new JLabel();
	       

	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        getContentPane().setLayout(null);

	        jPanel1.setLayout(null);

	        jPanel1.add(jComboBox1);
	        jComboBox1.setBounds(140, 110, 160, 22);
	        jComboBox1.setEditable(false);
	        try 
	        {  
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
	          
	            String query = "SELECT UserName FROM participant";
	          
	            Statement stm = con.createStatement();
	            ResultSet res = stm.executeQuery(query);
	           
	            while (res.next()) {
	                String abc=res.getString("UserName");
	            	jComboBox1.addItem(abc);
                   
	            }
	            
		    
	          } catch(Exception e1) {
	            e1.printStackTrace();
	          }
	      
	        jComboBox1.addItemListener(this);
	        
	        jPanel1.add(jTextField1);
	        jTextField1.setBounds(120, 250, 130, 22);
	        jPanel1.add(jTextField3);
	        jTextField3.setBounds(120, 340, 130, 22);
	        model = new DefaultTableModel();
	        jTable1 = new JTable(model);
	        jScrollPane1 = new JScrollPane(jTable1);
	        jTable1.setShowGrid(true);
	        jTable1.setShowVerticalLines(true);
	        
	        model.addColumn("Nom d'utilisateur");
	        model.addColumn("Mail");
	        model.addColumn("Cin");
	        model.addColumn("Tel");
	        model.addColumn("Formation");

	        try 
	        {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
	          
	            String query = "SELECT * FROM participant";
	          
	            Statement stm = con.createStatement();
	            ResultSet res = stm.executeQuery(query);
	           
	            while (res.next()) {
	            	vUser=res.getString("UserName");
	        	   	 vTel=res.getInt("nTelP");
	        	     vMail=res.getString("MailP");
	        	     
	        	     vCin=res.getInt("nCinP");
	        	     vFormation=res.getString("CodeFormation");
	            	model.addRow(new Object[] {vUser,vMail,vCin + "", vTel + "",vFormation});
	           
	            }
	            
		    
	          } catch(Exception e) {
	            e.printStackTrace();
	          }
	        jTable1.setModel(model);
	        jScrollPane1.setViewportView(jTable1);

	        jPanel1.add(jScrollPane1);
	        jScrollPane1.setBounds(340, 60,630, 380);
	   
	        jButton2.setBackground(new java.awt.Color(28, 37, 52));
	        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
	        jButton2.setForeground(new java.awt.Color(137, 138, 140));
	        jButton2.setText("Rechercher");
	        jPanel1.add(jButton2);
	        jButton2.setBounds(180, 440, 120, 30);
	        
	        jButton2.addActionListener(this);
	        
	        jButton3.setBackground(new java.awt.Color(28, 37, 52));
	        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
	        jButton3.setForeground(new java.awt.Color(137, 138, 140));
	        jButton3.setText("Retourner");
	        jPanel1.add(jButton3);
	        jButton3.setBounds(30, 440, 120, 30);
	        
	        jButton3.addActionListener(this);


	        jLabel3.setBackground(new java.awt.Color(28, 37, 52));
	        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
	        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
	        jLabel3.setText("Supprimer:");
	        jPanel1.add(jLabel3);
	        jLabel3.setBounds(20, 110, 70, 20);

	        jLabel4.setBackground(new java.awt.Color(28, 37, 52));
	        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
	        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
	        jLabel4.setText("Rechercher participant par:");
	        jPanel1.add(jLabel4);
	        jLabel4.setBounds(20, 190,200, 20);

	        jLabel5.setBackground(new java.awt.Color(28, 37, 52));
	        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
	        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
	        jLabel5.setText("N° Cin:");
	        jPanel1.add(jLabel5);
	        jLabel5.setBounds(50, 250, 100, 30);


	        jLabel7.setBackground(new java.awt.Color(28, 37, 52));
	        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
	        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
	        jLabel7.setText("Formation:");
	        jPanel1.add(jLabel7);
	        jLabel7.setBounds(50, 340, 90, 16);

	        jLabel8.setIcon(new ImageIcon(".\\src\\Formation\\ConsulterParticipant.jpeg")); // NOI18N
	        jPanel1.add(jLabel8);
	        jLabel8.setBounds(0, 0, 1000, 500);

	        
	        getContentPane().add(jPanel1);
	        jPanel1.setBounds(0, 0, 1000, 500);

	        pack();
	        setVisible(true);
	        setSize(1013,532);
	        
	         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	           }
		
		  @Override
		public void itemStateChanged(ItemEvent e ) {
			 if(e.getSource()==jComboBox1) {
					  if(e.getStateChange() == ItemEvent.SELECTED) {
						 
						 try {
							 
						            Class.forName("com.mysql.cj.jdbc.Driver");
						             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
						             String query = "delete from participant where UserName = ?";
						             PreparedStatement preparedStmt = con.prepareStatement(query);
						             preparedStmt.setString(1,jComboBox1.getSelectedItem().toString());

						             preparedStmt.execute();
						             con.close();
						 }
							    	  catch(Exception e1) {
							        e1.printStackTrace();}
						 model.setRowCount(0);
					        try 
					        {
					        	 Class.forName("com.mysql.cj.jdbc.Driver");
					             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
					          
					            String query = "SELECT * FROM participant";
					          
					            Statement stm = con.createStatement();
					            ResultSet res = stm.executeQuery(query);
					           
					            while (res.next()) {
					            	vUser=res.getString("UserName");
					        	   	 vTel=res.getInt("nTelP");
					        	     vMail=res.getString("MailP");
					        	   
					        	     vCin=res.getInt("nCinP");
					        	     vFormation=res.getString("CodeFormation");
					            	model.addRow(new Object[] {vUser,vMail,vCin + "", vTel + "",vFormation});
					           
					            }
					            
					            
						    
					          } catch(Exception e1) {
					            e1.printStackTrace();
					          }

						 
					 }
					  }
							 
						
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton j=(JButton)e.getSource();
			
			 if(j==jButton3) {
				setVisible(false);
			}
			else if(j==jButton2) {
				
			      model.setRowCount(0);
			        try 
			        {    String cin=jTextField1 .getText();
			        	 Class.forName("com.mysql.cj.jdbc.Driver");
			             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
			          
			            String query = "SELECT * FROM participant where nCinP='"+cin+"'";
			          
			            Statement stm = con.createStatement();
			            ResultSet res = stm.executeQuery(query);
			           
			            while (res.next()) {
			            	
			            	vUser=res.getString("UserName");
			        	   	 vTel=res.getInt("nTelP");
			        	     vMail=res.getString("MailP");
			        	     myPass=res.getString("PasswordP");
			        	     vCin=res.getInt("nCinP");
			        	     vFormation=res.getString("CodeFormation");
			            	model.addRow(new Object[] {vUser,vMail,vCin + "", vTel + "",myPass,vFormation});
			            
			            }}
			           catch(Exception e1) {
			            e1.printStackTrace();
			          }
	               
		
			        try 
			        {    String vFormation=jTextField3 .getText();
			        	 Class.forName("com.mysql.cj.jdbc.Driver");
			             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
			          
			            String query = "SELECT * FROM participant where Id_formation='"+vFormation+"'";
			          
			            Statement stm = con.createStatement();
			            ResultSet res = stm.executeQuery(query);
			           
			            while (res.next()) {

			            	vUser=res.getString("UserName");
			        	   	 vTel=res.getInt("nTelP");
			        	     vMail=res.getString("MailP");
			        	     myPass=res.getString("PasswordP");
			        	     vCin=res.getInt("nCinP");
			        	     vFormation=res.getString("CodeFormation");
			            	model.addRow(new Object[] {vUser,vMail,vCin + "", vTel + "",myPass,vFormation});
			           
			            }}
	 
	    	  catch(Exception e1) {
	        e1.printStackTrace();}
	}
	
			}	
				
		}
	
	
	


