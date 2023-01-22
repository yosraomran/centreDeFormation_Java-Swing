package Formation;
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

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Participant extends JFrame implements ItemListener,ActionListener,MouseListener{
private JButton jButton1;
private JButton jButton2;
private JButton jButton3;
private JButton jButton4;
private JComboBox<String> jComboBox1;
private JLabel jLabel1;
private JLabel jLabel2;
private JLabel jLabel3;
private JPanel jPanel1;
private JRadioButton jRadioButton1;
private JRadioButton jRadioButton2;
private JScrollPane jScrollPane1;
private JTable jTable1;
private JLabel jLabel4;
private JLabel jLabel5;
private JLabel jLabel6;
private JTextField jTextField1;
private JTextField jTextField2;
Connection con;
DefaultTableModel model;
String mailP;
int i;
Statement stm;
ResultSet res;
public Participant(String mailP) {
    super("Espace Participant");
    this.mailP=mailP;
    jPanel1 = new JPanel();
    jScrollPane1 = new JScrollPane();
    jTable1 = new JTable();
    jButton1 = new JButton();
    jButton2 = new JButton();
    jButton3 = new JButton();
    jButton4 = new JButton();
    jComboBox1 = new JComboBox<>();
    jLabel1 = new JLabel();
    jLabel2 = new JLabel();
    jRadioButton1 = new JRadioButton();
    jRadioButton2 = new JRadioButton();
    jLabel3 = new JLabel();
    jLabel4 = new JLabel();
    jLabel5 = new JLabel();
    jLabel6 = new JLabel();
    jTextField1 = new JTextField();
    jTextField2 = new JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    jPanel1.setLayout(null);
    
    model = new DefaultTableModel();
    jTable1 = new JTable(model);
    jScrollPane1 = new JScrollPane(jTable1);
    jTable1.setShowGrid(true);
    jTable1.setShowVerticalLines(true);
   
    model.addColumn("Formation");
    model.addColumn("Durée");
    model.addColumn("Date début");
    model.addColumn("Formateur");

    try 
    {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
         con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
      
        String query = "SELECT * FROM participant,formation where MailP='"+mailP+"' and participant.CodeFormation=formation.Id_Formation";
      
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery(query);
        Statement stm1=con.createStatement();
        ResultSet res1=stm1.executeQuery("select UserName from formateur,formation where formation.formateur=formateur.Id_Formateur");
        while (res.next() ) {
        	 res1.next();
        	model.addRow(new Object[] {res.getString("NomF"),res.getString("duree")
        			, res.getDate("dateDebut"),res1.getString("UserName")});
       
        
        
    
      } }catch(Exception e) {
        e.printStackTrace();
      }
    jTable1.setModel(model);
    jScrollPane1.setViewportView(jTable1);
    jPanel1.add(jScrollPane1);
    jScrollPane1.setBounds(430, 50, 452, 400);
    jTable1.addMouseListener(this);

    jButton1.setBackground(new java.awt.Color(28, 37, 52));
    jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jButton1.setForeground(new java.awt.Color(242, 242, 242));
    jButton1.setText("Retourner");
    jPanel1.add(jButton1);
    jButton1.setBounds(170, 460, 130, 26);
    jButton1.addActionListener(this);
    jButton3.setBackground(new java.awt.Color(28, 37, 52));
    jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jButton3.setForeground(new java.awt.Color(242, 242, 242));
    jButton3.setText("Modifier");
    jPanel1.add(jButton3);
    jButton3.setBounds(20, 460, 130, 26);
    jButton3.addActionListener(this);
    
    jButton4.setBackground(new java.awt.Color(17,78,99,255));
    jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jButton4.setForeground(new java.awt.Color(242, 242, 242));
    jButton4.setText("Se désabonner");
    jPanel1.add(jButton4);
    jButton4.setBounds(830, 460, 145, 26);
    jButton4.addActionListener(this);
    jButton2.setBackground(new java.awt.Color(28, 37, 52));
    jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jButton2.setForeground(new java.awt.Color(242, 242, 242));
    jButton2.setText("Nouvelle formation");
    jPanel1.add(jButton2);
    jButton2.setBounds(40, 210, 180, 26);
    jButton2.addActionListener(this);

    jPanel1.add(jComboBox1);
    jComboBox1.setBounds(30, 140, 230, 30);

    try 
    {  
    	 Class.forName("com.mysql.cj.jdbc.Driver");
         con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
      
        String query = "SELECT * FROM formation,participant where participant.CodeFormation=formation.Id_Formation ";
      
         stm = con.createStatement();
         res = stm.executeQuery(query);
         while (res.next()) {
        {
        	jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(

        			new String[] { res.getString("NomF") }
        		    		));
        }}
         
    }
        
    
       catch(Exception e1) {
        e1.printStackTrace();
      }

    
     jComboBox1.addItemListener(this);	

    jLabel1.setBackground(new java.awt.Color(28, 37, 52));
    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(242, 242, 242));
    jLabel1.setText("Anuuler formation");
    jPanel1.add(jLabel1);
    jLabel1.setBounds(30, 100, 180, 16);

    jLabel2.setBackground(new java.awt.Color(28, 37, 52));
    jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(242, 242, 242));
    jLabel2.setText("Obtenir certificat");
    jPanel1.add(jLabel2);
    jLabel2.setBounds(30, 380, 230, 20);
    
    jLabel4.setBackground(new java.awt.Color(28, 37, 52));
    jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(242, 242, 242));
    jLabel4.setText("Modifier");
    jPanel1.add(jLabel4);
    jLabel4.setBounds(20, 260, 80, 20);

    jLabel5.setBackground(new java.awt.Color(28, 37, 52));
    jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(242, 242, 242));
    jLabel5.setText("Téléphone");
    jPanel1.add(jLabel5);
    jLabel5.setBounds(60, 300, 70, 20);

    jLabel6.setBackground(new java.awt.Color(28, 37, 52));
    jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(242, 242, 242));
    jLabel6.setText("Mot de passe");
    jPanel1.add(jLabel6);
    jLabel6.setBounds(60, 350, 89, 20);
    jPanel1.add(jTextField1);
    jTextField1.setBounds(170, 300, 64, 22);
    jPanel1.add(jTextField2);
    jTextField2.setBounds(170, 350, 64, 22);

    jRadioButton1.setBackground(new java.awt.Color(28, 37, 52));
    jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jRadioButton1.setForeground(new java.awt.Color(242, 242, 242));
    jRadioButton1.setText("Non");
    jPanel1.add(jRadioButton1);
    jRadioButton1.setBounds(160, 420, 90, 30);

    jRadioButton2.setBackground(new java.awt.Color(28, 37, 52));
    jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jRadioButton2.setForeground(new java.awt.Color(242, 242, 242));
    jRadioButton2.setText("Oui");
    jPanel1.add(jRadioButton2);
    jRadioButton2.setBounds(60, 420, 90, 24);
    jRadioButton2.addItemListener(this);
    
    ButtonGroup G = new ButtonGroup();
    G.add(jRadioButton1);
    G.add(jRadioButton2);

    jLabel3.setIcon(new javax.swing.ImageIcon(".\\src\\Formation\\EspaceParticipant.jpeg")); // NOI18N
    jPanel1.add(jLabel3);
    jLabel3.setBounds(0, 0, 1000, 500);

    getContentPane().add(jPanel1);
    jPanel1.setBounds(0, 0, 1000, 500);

    pack();
}

@Override
public void itemStateChanged(ItemEvent e) {
	 if(e.getSource()==jComboBox1) {
		 
		  if(e.getStateChange() == ItemEvent.SELECTED) {
			      
			  
			    try {      
				 
			            Class.forName("com.mysql.cj.jdbc.Driver");
			             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
			             String query = "update participant set CodeFormation=NULL where Id='"+mailP+"'";
			             PreparedStatement preparedStmt = con.prepareStatement(query);
			             preparedStmt.setString(1,jComboBox1.getSelectedItem().toString());

			             preparedStmt.executeUpdate();
			             con.close();
			 }
				    	  catch(Exception e1) {
				        e1.printStackTrace();}
			 model.setRowCount(0);
			 try {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	         con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
	      
	        String query = "SELECT * FROM participant,formation where participant.MailP='"+mailP+"'";
	        Statement stm = con.createStatement();
	        ResultSet res = stm.executeQuery(query);
	       
	        while (res.next()) {
	        
	        	model.addRow(new Object[] {res.getString("NomF"),res.getString("duree")
	        			, res.getDate("dateDebut"),res.getString("formateur")});
	       
	        }
	        
	    
		  } catch(Exception e1) {
	        e1.printStackTrace();
	      }
			
		 }}
		  
		 if(e.getSource()==jRadioButton2) {
			 if(e.getStateChange() == 1) {
				 
				 try {
				   		
			              Class.forName("com.mysql.cj.jdbc.Driver");
			             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
			            
			             String sql2="select UserName from participant where MailP='"+mailP+"'";
			             Statement stm=con.createStatement();
			              ResultSet res = stm.executeQuery(sql2);
			              res.next();
			             
			           
				    
				 
			 JOptionPane.showMessageDialog(null, "Choisir la formation");
			 Certif c=new Certif(model.getValueAt(i, 0).toString(),model.getValueAt(i, 2).toString(),res.getString("UserName"));
			 c.setVisible(true);
			 c.setSize(1090,530);
			 c.setBounds(100,100,1000,515);
					}
				 
		    	  catch(Exception e1) {
		        e1.printStackTrace();}
		 }}
	 
	 }

@Override
public void actionPerformed(ActionEvent e) {
	JButton j=(JButton)e.getSource();
	if(j==jButton3) {
		try {
			
		    String vTel=jTextField1.getText();
            Class.forName("com.mysql.cj.jdbc.Driver");
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
            
             String query = "update participant set nTelP = ? where MailP = ?";
             PreparedStatement preparedStmt = con.prepareStatement(query);
             preparedStmt.setString   (1, vTel);
             preparedStmt.setString(2, mailP);
       
             preparedStmt.executeUpdate();
	    	}
	 
	    	  catch(Exception e1) {
	        e1.printStackTrace();}
	try {
			
		    String vTel=jTextField2.getText();
            Class.forName("com.mysql.cj.jdbc.Driver");
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
            
             String query = "update participant set PasswordP = ? where MailP = ?";
             PreparedStatement preparedStmt = con.prepareStatement(query);
             preparedStmt.setString   (1, vTel);
             preparedStmt.setString(2, mailP);
       
             preparedStmt.executeUpdate();
	    	}
	 
	    	  catch(Exception e1) {
	        e1.printStackTrace();}
	}
	if(j==jButton1) {
		setVisible(true);
	}
	if(j==jButton2) {
		PlanifierFormation p=new PlanifierFormation(mailP);
		 p.setSize(1000, 538);
		   p.setVisible(true);
	}
	else if(j==jButton4) {
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
            
             String query = "delete from participant where MailP='"+mailP+"'";
             PreparedStatement preparedStmt = con.prepareStatement(query);
             preparedStmt.executeUpdate();
	    	}
	 
	    	  catch(Exception e1) {
	        e1.printStackTrace();
	        }
		setVisible(false);
	}
	
}

@Override
public void mouseClicked(MouseEvent e) {
	try {
		 i=jTable1.getSelectedRow();
	    
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