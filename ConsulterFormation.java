package Formation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsulterFormation extends JFrame implements ActionListener,ItemListener{
	
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JLabel jLabel10;
    private JPanel jPanel1;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton4;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    // End of variables declaration              
    AjouterFormation a;
    DefaultTableModel model;
	Connection con;
	
	Statement stmt;
	Statement stmt1;
	
	String sql;
	String sql2;
	
	ResultSet rs;
	ResultSet rs1;
    ConsulterFormation()
           {
    	super ("Consultation Formation"); 
    	setBounds(0, 0, 1000, 500);
    	// instances
        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jComboBox1 = new JComboBox<>();
        jTextField1 = new JTextField();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        jRadioButton4 = new JRadioButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jLabel1 = new JLabel("");
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel2 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
       

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(28, 37, 52));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(137, 138, 140));
        jButton1.setText("Ajouter Formation");
        jPanel1.add(jButton1);
        jButton1.setBounds(60, 70, 150, 30);
        
        jButton1.addActionListener(this);

      
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(140, 130, 160, 22);
        jComboBox1.setEditable(false);
        try 
        {  
        	 Class.forName("com.mysql.cj.jdbc.Driver");
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
          
            String query = "SELECT NomF FROM formation";
          
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
        
        jPanel1.add(jTextField1);
        jTextField1.setBounds(160, 185, 130, 22);

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(137, 138, 140));
        jRadioButton1.setText("Prix");
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(60, 220, 98, 20);

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(137, 138, 140));
        jRadioButton2.setText("Date");
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(180, 220, 98, 20);
        
        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(137, 138, 140));
        jRadioButton3.setText("SalaireFormateur");
        jPanel1.add(jRadioButton3);
        jRadioButton3.setBounds(45, 260, 122, 20);
        
        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(137, 138, 140));
        jRadioButton4.setText("nbParticipant");
        jPanel1.add(jRadioButton4);
        jRadioButton4.setBounds(184, 260, 100, 20);
        
        ButtonGroup G = new ButtonGroup();
        G.add(jRadioButton1);
        G.add(jRadioButton2);
        G.add(jRadioButton3);
        G.add(jRadioButton4);
        
        jRadioButton1.addItemListener(this);
        jRadioButton2.addItemListener(this);
        jRadioButton3.addItemListener(this);
        jRadioButton4.addItemListener(this);
        
        jPanel1.add(jTextField2);
        jTextField2.setBounds(90, 350, 60, 22);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(90, 400, 60, 22);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(230, 350, 60, 22);
        jPanel1.add(jTextField5);
        jTextField5.setBounds(230, 400, 60, 22);

        
        model = new DefaultTableModel();
        jTable1 = new JTable(model);
        jScrollPane1 = new JScrollPane(jTable1);
        jTable1.setShowGrid(true);
        jTable1.setShowVerticalLines(true);
        
        model.addColumn("Code");
        model.addColumn("Nom");
        model.addColumn("Formateur");
        model.addColumn("Salaire");
        model.addColumn("durée");
        model.addColumn("DateDébut");
        model.addColumn("nombre");
        model.addColumn("Prix");
        model.addColumn("Catégorie");

        try 
        {
        	 Class.forName("com.mysql.cj.jdbc.Driver");
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
          
            String query = "SELECT * FROM formation";
          
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
           
            while (res.next()) {
            	
            	model.addRow(new Object[] {res.getInt("Id_formation")+"",res.getString("NomF"),res.getString("formateur")
            			,res.getInt("SalaireFormateur")+"",res.getString("duree"),res.getDate("dateDebut"),res.getInt("nParticipant")+"",res.getInt("prix")+"",res.getString("Categorie")});
           
            }
            
	    
          } catch(Exception e) {
            e.printStackTrace();
          }
        jTable1.setModel(model);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
       
        jScrollPane1.setBounds(380, 60, 600, 380);

        jButton2.setBackground(new java.awt.Color(28, 37, 52));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(137, 138, 140));
        jButton2.setText("Modifier");
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

        jLabel1.setBackground(new java.awt.Color(28, 37, 52));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 290, 250, 40);

        jLabel3.setBackground(new java.awt.Color(28, 37, 52));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Supprimer:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 130, 70, 20);

        jLabel4.setBackground(new java.awt.Color(28, 37, 52));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Modifier:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 160, 60, 20);

        jLabel5.setBackground(new java.awt.Color(28, 37, 52));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Code Formation:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 180, 100, 30);

        jLabel2.setBackground(new java.awt.Color(28, 37, 52));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText(" Date:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 400, 37, 16);

        jLabel7.setBackground(new java.awt.Color(28, 37, 52));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText(" prix:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 350, 37, 16);
        
        jLabel9.setBackground(new java.awt.Color(28, 37, 52));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(242, 242, 242));
        jLabel9.setText("Salaire:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(170, 350, 50, 16);
        
        jLabel10.setBackground(new java.awt.Color(28, 37, 52));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(242, 242, 242));
        jLabel10.setText("Nombre:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(170, 400, 50, 16);

        jLabel8.setIcon(new ImageIcon(".\\src\\Formation\\consulterformation.jpeg")); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 0, 1000, 500);

        
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 500);

        pack();
        setVisible(true);
        setSize(1013,532);
        
         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     }
    	
     public static void main(String args[]) {
    	 ConsulterFormation F1=new ConsulterFormation();
         
         }

	
	public void actionPerformed(ActionEvent e) {
		JButton j=(JButton)e.getSource();
		if(j==jButton1) {
			 a=new AjouterFormation();
			 a.setVisible(true);
			 a.setBounds(350, 100, 565, 398);
		}
		else if(j==jButton3) {
			setVisible(false);
		}
		else if(j==jButton2) {
			if(jRadioButton1.isSelected()) {
				
				try {
					String vPrix=jTextField2.getText();
				    String vCode=jTextField1.getText();
		            Class.forName("com.mysql.cj.jdbc.Driver");
		             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
		            
		             String query = "update formation set prix = ? where Id_formation = ?";
		             PreparedStatement preparedStmt = con.prepareStatement(query);
		             preparedStmt.setString   (1, vPrix);
		             preparedStmt.setString(2, vCode);
		       
		             preparedStmt.executeUpdate();
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
			            	
			            	model.addRow(new Object[] {res.getInt("Id_formation")+"",res.getString("NomF"),res.getString("formateur")
			            			,res.getInt("SalaireFormateur")+"",res.getString("duree"),res.getDate("dateDebut"),res.getInt("nParticipant")+"",res.getInt("prix")+"",res.getString("Categorie")});
			           
			            }
			            
				    
			          } catch(Exception e1) {
			            e1.printStackTrace();
			          }
               }
			else if(jRadioButton2.isSelected()) {
				try {
					String vDate=jTextField3.getText();
				    String vCode=jTextField1.getText();
		            Class.forName("com.mysql.cj.jdbc.Driver");
		             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
		            
		             String query = "update formation set dateDebut = ? where Id_Formation = ?";
		             PreparedStatement preparedStmt = con.prepareStatement(query);
		             preparedStmt.setString   (1, vDate);
		             preparedStmt.setString(2, vCode);
		       
		             preparedStmt.executeUpdate();
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
			            	
			            	model.addRow(new Object[] {res.getInt("Id_formation")+"",res.getString("NomF"),res.getString("formateur")
			            			,res.getInt("SalaireFormateur")+"",res.getString("duree"),res.getDate("dateDebut"),res.getInt("nParticipant")+"",res.getInt("prix")+"",res.getString("Categorie")});
			           
			            }
			            
				    
			          } catch(Exception e1) {
			            e1.printStackTrace();
			          }
			}
			else if(jRadioButton3.isSelected()) {
				try {
					String vSal=jTextField4.getText();
				    String vCode=jTextField1.getText();
		            Class.forName("com.mysql.cj.jdbc.Driver");
		             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
		            
		             String query = "update formation set SalaireFormateur = ? where Id_formation = ?";
		             PreparedStatement preparedStmt = con.prepareStatement(query);
		             preparedStmt.setString   (1, vSal);
		             preparedStmt.setString(2, vCode);
		       
		             preparedStmt.executeUpdate();
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
			            	
			            	model.addRow(new Object[] {res.getInt("Id_formation")+"",res.getString("NomF"),res.getString("formateur")
			            			,res.getInt("SalaireFormateur")+"",res.getString("duree"),res.getDate("dateDebut"),res.getInt("nParticipant")+"",res.getInt("prix")+"",res.getString("Categorie")});
			           
			            }
			            
				    
			          } catch(Exception e1) {
			            e1.printStackTrace();
			          }
			}
			else if(jRadioButton4.isSelected()) {
				try {
					String vNb=jTextField5.getText();
				    String vCode=jTextField1.getText();
		            Class.forName("com.mysql.cj.jdbc.Driver");
		             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
		            
		             String query = "update formation set nParticipant = ? where Id_formation = ?";
		             PreparedStatement preparedStmt = con.prepareStatement(query);
		             preparedStmt.setString   (1, vNb);
		             preparedStmt.setString(2, vCode);
		       
		             preparedStmt.executeUpdate();
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
			            	
			            	model.addRow(new Object[] {res.getInt("Id_formation")+"",res.getString("NomF"),res.getString("formateur")
			            			,res.getInt("SalaireFormateur")+"",res.getString("duree"),res.getDate("dateDebut"),res.getInt("nParticipant")+"",res.getInt("prix")+"",res.getString("Categorie")});
			           
			            }
			            
				    
			          } catch(Exception e1) {
			            e1.printStackTrace();
			          }
			}
		}
		
	}

	public void itemStateChanged(ItemEvent e) {
		 if (e.getSource() == jRadioButton1) {
			 
	         if (e.getStateChange() == 1) {
	        	 
	             jLabel1.setText("Donnez le nouveau prix");}
		 }
			 else if(e.getSource()==jRadioButton2) { 
				 if (e.getStateChange() == 1) {
		            jLabel1.setText("Donnez la nouvelle date");
				 }}
			 else if(e.getSource()==jRadioButton3) { 
				 if (e.getStateChange() == 1) {
		            jLabel1.setText("Donnez le nouveau salaire");
				 }}
			 else if(e.getSource()==jRadioButton4) { 
				 if (e.getStateChange() == 1) {
		            jLabel1.setText("Donnez le nouveau nombre participants");
				 }}
				 else if(e.getSource()==jComboBox1) {
				  if(e.getStateChange() == ItemEvent.SELECTED) {
					
					 try {
						 
					            Class.forName("com.mysql.cj.jdbc.Driver");
					             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
					             String query = "delete from formation where NomF = ?";
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
				          
				            String query = "SELECT * FROM formation";
				          
				            Statement stm = con.createStatement();
				            ResultSet res = stm.executeQuery(query);
				           
				            while (res.next()) {
				            	
				            	model.addRow(new Object[] {res.getInt("Id_formation")+"",res.getString("NomF"),res.getString("formateur")
				            			,res.getInt("SalaireFormateur")+"",res.getString("duree"),res.getDate("dateDebut"),res.getInt("nParticipant")+"",res.getInt("prix")+"",res.getString("Categorie")});
				           
				            }
				            
					    
				          } catch(Exception e1) {
				            e1.printStackTrace();
				          }
				 } }
						 
					 
					 
	}}
	



