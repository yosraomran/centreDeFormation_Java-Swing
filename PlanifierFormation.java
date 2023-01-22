package Formation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class PlanifierFormation extends JFrame implements ActionListener,MouseListener {
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel2;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton4;
    private JScrollPane jScrollPane2;
    private JTable jTable1;
    DefaultTableModel model;
	Connection con;
	Statement stmt;
	String sql;	
	ResultSet rs;
	String mailP;
	int i;
	public static int nb=0;
    public PlanifierFormation(String mailP) {
    	super("Planifier formation");
    	this.mailP=mailP;
    	setBounds(0,0,1000,700);
    	setSize(1000,700);
    	jPanel2 = new JPanel();
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        jLabel1 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jRadioButton3 = new JRadioButton();
        jRadioButton4 = new JRadioButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jLabel8 = new JLabel();
        
        ButtonGroup G = new ButtonGroup();
        G.add(jRadioButton3);
        G.add(jRadioButton4);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);
        
        model = new DefaultTableModel();
        jTable1 = new JTable(model);
        jScrollPane2 = new JScrollPane(jTable1);
        jTable1.setShowGrid(true);
        jTable1.setShowVerticalLines(true);
        model.addColumn("Code Foramtion");
        model.addColumn("Nom Formation");
        model.addColumn("Catégorie");
        model.addColumn("Formateur");
        model.addColumn("Durée");
        model.addColumn("Date début");
        model.addColumn("Nbparticipant");
        model.addColumn("prix");

        try 
        {   
        	 Class.forName("com.mysql.cj.jdbc.Driver");
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
          
            String query = "SELECT * FROM formation";
          
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
           
            while (res.next()) {
            	int code=res.getInt("Id_Formation");
            	String nom=res.getString("NomF");
        	   	String cat=res.getString("Categorie");
        	   	String formateur=res.getString("formateur");
        	   	String duree=res.getString("duree");
        	     String date=res.getString("dateDebut");
        	     String nb=res.getString("nParticipant");
        	     int prix=res.getInt("prix");
            	model.addRow(new Object[] {code +"",nom,cat,formateur, duree ,date,nb+"",prix+""});
           
            }
            
	    
          } catch(Exception e) {
            e.printStackTrace();
          }
        jTable1.setModel(model);
        jScrollPane2.setViewportView(jTable1);
        jTable1.addMouseListener(this);
        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(40, 180, 720, 250);

        jLabel1.setBackground(new java.awt.Color(28, 37, 52));
        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Demandeur d'emploi ? Formez-vous à distance à un métier d'avenir. Votre formation");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(190, 20, 780, 30);

        jLabel6.setBackground(new java.awt.Color(28, 37, 52));
        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("sera financée par Pôle emploi ! ");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(190, 60, 287, 20);

        jLabel7.setBackground(new java.awt.Color(28, 37, 52));
        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("vous devez choisir  votre formation :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(50, 135, 270, 26);

        jRadioButton3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(242, 242, 242));
        jRadioButton3.setText("En ligne");
        jRadioButton3.setBackground(new java.awt.Color(22, 78, 99));
        jPanel2.add(jRadioButton3);
        jRadioButton3.setBounds(820, 310, 90, 21);

        jRadioButton4.setBackground(new java.awt.Color(22, 78, 99));
        jRadioButton4.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(242, 242, 242));
        jRadioButton4.setText("Présentielle");
        jPanel2.add(jRadioButton4);
        jRadioButton4.setBounds(820, 240, 120, 21);

        jButton3.setBackground(new java.awt.Color(22, 78, 99));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(242, 242, 242));
        jButton3.setText("Confirmer");
        jPanel2.add(jButton3);
        jButton3.setBounds(730, 460, 110, 22);
        jButton3.addActionListener(this);

        jButton4.setBackground(new java.awt.Color(22, 78, 99));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(242, 242, 242));
        jButton4.setText("Retourner");
        jPanel2.add(jButton4);
        jButton4.setBounds(880, 460, 100, 22);
        jButton4.addActionListener(this);
        
        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\OneDrive\\Bureau\\SoumaDidiYoyo\\src\\Formation\\PlanifierFormation.png")); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 0, 1000, 500);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1000, 500);

        pack();
    }

  
@Override
public void actionPerformed(ActionEvent e) {
	JButton j=(JButton)e.getSource();
	if (j==jButton3) {
		try {
			
            Class.forName("com.mysql.cj.jdbc.Driver");
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
            
             String query = "update participant set CodeFormation = ? where MailP = ?";
             PreparedStatement preparedStmt = con.prepareStatement(query);
             preparedStmt.setString(1, model.getValueAt(i, 0).toString());
             preparedStmt.setString(2, mailP);
       
             preparedStmt.executeUpdate();
	    	}
	 
	    	  catch(Exception e1) {
	        e1.printStackTrace();}
		nb++;
	}
	if (j==jButton4) {
		setVisible(false);
	}
	
}
@Override
public void mouseClicked(MouseEvent e) {
	try {
		 i=jTable1.getSelectedRow();
		if(nb!=Integer.parseInt(model.getValueAt(i, 6).toString())) {
		
		Paiement p=new Paiement(model.getValueAt(i, 1).toString());
		p.setVisible(true);
		p.setSize(500, 535);
	}
		else {
			JOptionPane.showMessageDialog(null, "Désolé Nombre de place complé");
		}	
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
