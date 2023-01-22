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
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
public class ConsulterFormateur extends JFrame implements ActionListener,ItemListener  {
	 
	    private JButton jButton2;
	    private JButton jButton3;
	    private JComboBox<String> jComboBox1;
	    private JLabel jLabel1;
	    private JLabel jLabel2;
	    private JLabel jLabel3;
	    private JLabel jLabel4;
	    private JLabel jLabel5;
	  
	    private JLabel jLabel8;
	    private JPanel jPanel1;
	    DefaultTableModel model;
	    private JScrollPane jScrollPane1;
	    private JTable jTable1;
	    private JTextField jTextField1;
        private JTextField jTextField2;
	    private JTextField jTextField3;
	 
		Connection con;
		
		Statement stmt;
		Statement stmt1;
		
		String sql;
		String sql2;
		
		ResultSet rs;
		ResultSet rs1;
		
	   	String vUser;
	   	int vTel;
	    String vMail;
	    String myPass;
	    int vCin;
	    String vSpecialite;
	    
		
	    ConsulterFormateur() 
	           {
	    	super ("Consultation Formateur"); 
	    	setBounds(0, 0, 1000, 537);
	    	// instances
	        jPanel1 = new JPanel();
	        
	        jComboBox1 = new JComboBox<>();
	        jTextField1 = new JTextField();
	        jTextField2 = new JTextField();
	        jTextField3 = new JTextField();
	        jButton2 = new JButton();
	        jButton3 = new JButton();	        
	        jLabel3 = new JLabel();
	        jLabel4 = new JLabel();
	        jLabel5 = new JLabel();
	        jLabel2 = new JLabel();
	        jLabel1 = new JLabel();
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
	          
	            String query = "SELECT UserName FROM formateur";
	          
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
	        jTextField1.setBounds(120, 240, 130, 22);
	        jPanel1.add(jTextField2);
	        jTextField2.setBounds(120, 300, 130, 22);
	        jPanel1.add(jTextField3);
	        jTextField3.setBounds(120, 360, 130, 22);
	        
	        model = new DefaultTableModel();
	        jTable1 = new JTable(model);
	        jScrollPane1 = new JScrollPane(jTable1);
	        jTable1.setShowGrid(true);
	        jTable1.setShowVerticalLines(true);
	        
	        model.addColumn("Nom d'utilisateur");
	        model.addColumn("Mail");
	        model.addColumn("Cin");
	        model.addColumn("Tel");
	        model.addColumn("Password");
	        model.addColumn("specialite");

	        try 
	        {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
	          
	            String query = "SELECT * FROM formateur";
	          
	            Statement stm = con.createStatement();
	            ResultSet res = stm.executeQuery(query);
	           
	            while (res.next()) {
	            	vUser=res.getString("UserName");
	        	   	 vTel=res.getInt("Tel");
	        	     vMail=res.getString("Mail");
	        	     myPass=res.getString("Password");
	        	     vCin=res.getInt("Cin");
	        	     vSpecialite=res.getString("specialite");
	            	model.addRow(new Object[] {vUser,vMail,vCin + "", vTel + "",myPass,vSpecialite});
	           
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
	        jLabel4.setText("Rechercher Formateur par:");
	        jPanel1.add(jLabel4);
	        jLabel4.setBounds(20, 190,200, 20);

	        jLabel5.setBackground(new java.awt.Color(28, 37, 52));
	        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
	        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
	        jLabel5.setText("N° Cin:");
	        jPanel1.add(jLabel5);
	        jLabel5.setBounds(50, 235, 100, 30);

	        jLabel2.setBackground(new java.awt.Color(28, 37, 52));
	        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
	        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
	        jLabel2.setText("Spécialité:");
	        jPanel1.add(jLabel2);
	        jLabel2.setBounds(50, 300, 90, 20);
	        
	        jLabel1.setBackground(new java.awt.Color(28, 37, 52));
	        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
	        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
	        jLabel1.setText("Formation:");
	        jPanel1.add(jLabel1);
	        jLabel1.setBounds(50, 360, 90, 16);


	        jLabel8.setIcon(new ImageIcon(".\\src\\Formation\\ConsulterFormateur.jpeg")); // NOI18N
	        jPanel1.add(jLabel8);
	        jLabel8.setBounds(0, 0, 1000, 500);

	        
	        getContentPane().add(jPanel1);
	        jPanel1.setBounds(0, 0, 1000, 500);

	        pack();
	        setVisible(true);
	        setSize(1013,532);
	        
	         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	     }
	    public static void main(String args[])
	    {
	    	ConsulterFormateur  f=new ConsulterFormateur();
	    f.setVisible(true);
	        f.setSize(1000,537);
	    }
		@Override
		public void itemStateChanged(ItemEvent e ) {
                if(e.getSource()==jComboBox1) {
					  if(e.getStateChange() == ItemEvent.SELECTED) {
						 
						 try {
							 
						            Class.forName("com.mysql.cj.jdbc.Driver");
						             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
						             String query = "delete from formateur where UserName = ?";
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
					          
					            String query = "SELECT * FROM formateur";
					          
					            Statement stm = con.createStatement();
					            ResultSet res = stm.executeQuery(query);
					           
					            while (res.next()) {
					            	vUser=res.getString("UserName");
					        	   	 vTel=res.getInt("Tel");
					        	     vMail=res.getString("Mail");
					        	     myPass=res.getString("Password");
					        	     vCin=res.getInt("Cin");
					        	     vSpecialite=res.getString("specialite");
					            	model.addRow(new Object[] {vUser,vMail,vCin + "", vTel + "",myPass,vSpecialite});
					           
					            }
					            
						    
					          } catch(Exception e1) {
					            e1.printStackTrace();
					          }
					  } }
							 
						
			
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
			          
			            String query = "SELECT * FROM formateur where Cin='"+cin+"'";
			          
			            Statement stm = con.createStatement();
			            ResultSet res = stm.executeQuery(query);
			           
			            while (res.next()) {
			            	vUser=res.getString("UserName");
			        	   	 vTel=res.getInt("Tel");
			        	     vMail=res.getString("Mail");
			        	     myPass=res.getString("Password");
			        	     vCin=res.getInt("Cin");
			        	     vSpecialite=res.getString("specialite");
			            	model.addRow(new Object[] {vUser,vMail,vCin + "", vTel + "",myPass,vSpecialite});
			            
			            }}
			           catch(Exception e1) {
			            e1.printStackTrace();
			          }
	               
			        try 
			        {    String vSpecialite=jTextField2 .getText();
			        	 Class.forName("com.mysql.cj.jdbc.Driver");
			             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
			          
			            String query = "SELECT * FROM formateur where Specialite='"+vSpecialite+"' ";
			          
			            Statement stm = con.createStatement();
			            ResultSet res = stm.executeQuery(query);
			           
			            while (res.next()) {
			            	vUser=res.getString("UserName");
			        	   	 vTel=res.getInt("Tel");
			        	     vMail=res.getString("Mail");
			        	     myPass=res.getString("Password");
			        	     vCin=res.getInt("Cin");
			        	     vSpecialite=res.getString("specialite");
			            	model.addRow(new Object[] {vUser,vMail,vCin + "", vTel + "",myPass,vSpecialite});
			            }
			            }
				 
				    	  catch(Exception e1) {
				        e1.printStackTrace();}
				
		
			        try 
			        {    String vFormation=jTextField3 .getText();
			        	 Class.forName("com.mysql.cj.jdbc.Driver");
			             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
			          
			            String query = "SELECT * FROM formateur,formation where formation.NomF='"+vFormation+"' and formation.formateur=formateur.UserName";
			          
			            Statement stm = con.createStatement();
			            ResultSet res = stm.executeQuery(query);
			           
			            while (res.next()) {
			            	vUser=res.getString("UserName");
			        	   	 vTel=res.getInt("Tel");
			        	     vMail=res.getString("Mail");
			        	     myPass=res.getString("Password");
			        	     vCin=res.getInt("Cin");
			        	     vSpecialite=res.getString("specialite");
			            	model.addRow(new Object[] {vUser,vMail,vCin + "", vTel + "",myPass,vSpecialite});
			           
			            }}
	 
	    	  catch(Exception e1) {
	        e1.printStackTrace();}
				}
			}
			
		}
		
	
	
	
	


