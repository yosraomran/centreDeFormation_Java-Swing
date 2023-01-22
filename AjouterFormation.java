package Formation;
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
public class AjouterFormation extends JFrame implements ActionListener,ItemListener {

    // Variables declaration                      
    private JButton jButton1;
    private JButton jButton2;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JComboBox<String> jComboBox3;
    private JComboBox<String> jComboBox4;
    private JComboBox<String> jComboBox5;
    private JComboBox<String> jComboBox6;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JLabel jLabel10;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    
     Connection con;
	Statement stmt;
	String sql;
	ResultSet rs;
    
    public AjouterFormation() {
            super("Ajouter Formation");
            
            jPanel1 = new JPanel();
            jLabel1 = new JLabel();
            jLabel2 = new JLabel();
            jLabel3 = new JLabel();
            jLabel4 = new JLabel();
            jLabel5 = new JLabel();
            jLabel6 = new JLabel();
            jButton1 = new JButton();
            jButton2 = new JButton();
            jComboBox1 = new JComboBox<>();
            jComboBox2 = new JComboBox<>();
            jComboBox3 = new JComboBox<>();
            jTextField1 = new JTextField();
            jTextField2 = new JTextField();
            jComboBox4 = new JComboBox<>();
            jComboBox5 = new JComboBox<>();
            jComboBox6 = new JComboBox<>();
            jTextField3 = new JTextField();
            jLabel7 = new JLabel();
            jTextField4 = new JTextField();
            jTextField5 = new JTextField();
            jTextField6 = new JTextField();
            jTextField7 = new JTextField();
            jLabel8 = new JLabel();
            jLabel9 = new JLabel();
            jLabel10 = new JLabel();
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBackground(new java.awt.Color(28, 37, 52));
            getContentPane().setLayout(null);

            jPanel1.setBackground(new java.awt.Color(28, 37, 52));
            jPanel1.setForeground(new java.awt.Color(28, 37, 52));
            jPanel1.setLayout(null);

            jLabel1.setBackground(new java.awt.Color(28, 37, 52));
            jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
            jLabel1.setText("Code Formation:");
            jPanel1.add(jLabel1);
            jLabel1.setBounds(20, 80, 100, 40);

            jLabel2.setBackground(new java.awt.Color(28, 37, 52));
            jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(242, 242, 242));
            jLabel2.setText("Nom formation:");
            jPanel1.add(jLabel2);
            jLabel2.setBounds(20, 140, 110, 40);

            jLabel3.setBackground(new java.awt.Color(28, 37, 52));
            jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(242, 242, 242));
            jLabel3.setText("Formateur:");
            jPanel1.add(jLabel3);
            jLabel3.setBounds(20, 200, 70, 40);

            jLabel4.setBackground(new java.awt.Color(28, 37, 52));
            jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel4.setForeground(new java.awt.Color(242, 242, 242));
            jLabel4.setText("Durée:");
            jPanel1.add(jLabel4);
            jLabel4.setBounds(360, 80, 50, 40);

            jLabel5.setBackground(new java.awt.Color(28, 37, 52));
            jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel5.setForeground(new java.awt.Color(242, 242, 242));
            jLabel5.setText("Date debit:");
            jPanel1.add(jLabel5);
            jLabel5.setBounds(20, 270, 70, 20);

            jLabel6.setBackground(new java.awt.Color(28, 37, 52));
            jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel6.setForeground(new java.awt.Color(242, 242, 242));
            jLabel6.setText("NbParticipant:");
            jPanel1.add(jLabel6);
            jLabel6.setBounds(360, 130, 80, 16);
            
            jLabel10.setBackground(new java.awt.Color(28, 37, 52));
            jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel10.setForeground(new java.awt.Color(242, 242, 242));
            jLabel10.setText("Catégorie:");
            jPanel1.add(jLabel10);
            jLabel10.setBounds(360, 165, 80, 16);

            jButton1.setBackground(new java.awt.Color(28, 37, 52));
            jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jButton1.setForeground(new java.awt.Color(242, 242, 242));
            jButton1.setText("Ajouter");
            jPanel1.add(jButton1);
            jButton1.setBounds(430, 330, 110, 22);
            
            jButton1.addActionListener(this);

            jButton2.setBackground(new java.awt.Color(28, 37, 52));
            jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jButton2.setForeground(new java.awt.Color(242, 242, 242));
            jButton2.setText("Retourner");
            jPanel1.add(jButton2);
            jButton2.setBounds(20, 330, 110, 22);
            
            jButton2.addActionListener(this);

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
            jPanel1.add(jComboBox1);
            jComboBox1.setBounds(100, 210, 120, 22);

            jPanel1.add(jTextField1);
            jTextField1.setBounds(120, 150, 64, 22);
            jPanel1.add(jTextField2);
            jTextField2.setBounds(450, 90, 64, 22);

            jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023","2024","2025" }));
            jPanel1.add(jComboBox4);
            jComboBox4.setBounds(90, 270, 70, 22);

            jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "01","02","03", "04","05","06","07","08","09","10","11","12" }));
            
          
            jPanel1.add(jComboBox5);
            jComboBox5.setBounds(170, 270, 70, 22);

            jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04","05","06","07","08","09","10","11","12",
            		"13","14","15","16","17","18","19","20","21","22","23","24","25","26","27"
            		,"28","29","30","31"}));
            jPanel1.add(jComboBox6);
            jComboBox6.setBounds(250, 270, 70, 22);
            jPanel1.add(jTextField3);
            jTextField3.setBounds(450, 128, 40, 22);
            
            jPanel1.add(jTextField7);
            jTextField7.setBounds(450, 163, 70, 22);

            jLabel7.setBackground(new java.awt.Color(28, 37, 52));
            jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel7.setForeground(new java.awt.Color(242, 242, 242));
            jLabel7.setText("Prix:");
            jPanel1.add(jLabel7);
            jLabel7.setBounds(360, 210, 50, 20);
            
            jLabel9.setBackground(new java.awt.Color(28, 37, 52));
            jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel9.setForeground(new java.awt.Color(255, 255, 255));
            jLabel9.setText("Salaire formateur:");
            jPanel1.add(jLabel9);
            jLabel9.setBounds(360, 260, 125, 40);
            
            jPanel1.add(jTextField4);
            jTextField4.setBounds(450, 210, 64, 22);
            jPanel1.add(jTextField5);
            jTextField5.setBounds(120, 90, 64, 22);
            
            jPanel1.add(jTextField6);
            jTextField6.setBounds(480, 270, 50, 22);

            jLabel8.setBackground(new java.awt.Color(28, 37, 52));
            jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
            jLabel8.setForeground(new java.awt.Color(242, 242, 242));
            jLabel8.setText("Ajouter Formation");
            jPanel1.add(jLabel8);
            jLabel8.setBounds(180, 20, 210, 30);

            add(jPanel1);
            jPanel1.setBounds(0, 0, 550, 360);

            pack();
    }
    
  public static void main(String[]args) {
	  AjouterFormation a=new AjouterFormation();
	  a.setSize(565, 398);
	  a.setVisible(true);
	  a.setBounds(350, 220, 565, 398);
  }


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton j=(JButton)e.getSource();
		if(j==jButton2) {
			setVisible(false);
		}
		else if(j==jButton1) {
		
			if((jTextField1.getText().isEmpty()) & (jTextField2.getText().isEmpty()) & (jTextField3.getText().isEmpty())&(jTextField4.getText().isEmpty())&(jTextField5.getText().isEmpty())&(jTextField6.getText().isEmpty())) {
				JOptionPane.showMessageDialog(this, "Remplir tous les champs");
			}
			else {
		    	
		    	try {
		   		String date=jComboBox4.getSelectedItem().toString()+"-"+jComboBox5.getSelectedItem().toString()+"-"+jComboBox6.getSelectedItem().toString();
	              Class.forName("com.mysql.cj.jdbc.Driver");
	             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
	            
	             sql = "INSERT INTO formation(Id_formation, NomF, formateur, SalaireFormateur, duree, dateDebut,nParticipant, prix, Categorie) "+ "VALUES(?,?,?,?,?,?,?,?,?)";
	             String sql2="select Id_formateur from formateur where UserName='"+jComboBox1.getSelectedItem().toString()+"'";
	             Statement stm=con.createStatement();
	              ResultSet res = stm.executeQuery(sql2);
	              res.next();
	             PreparedStatement pstmt = con.prepareStatement(sql);
	             pstmt.setString(1, jTextField5.getText());
	             pstmt.setString(2, jTextField1.getText());
	             pstmt.setString(3,res.getInt("Id_formateur")+"");
	             pstmt.setString(4, jTextField6.getText());
	             pstmt.setString(5, jTextField2.getText());
	             pstmt.setString(6, date);
	             pstmt.setString(7, jTextField3.getText());
	             pstmt.setString(8, jTextField4.getText());
	             pstmt.setString(9, jTextField7.getText());
	            
	             pstmt.executeUpdate();
	             
	             jTextField1.setText("");
	             jTextField2.setText("");
	             jTextField3.setText("");
	             jTextField4.setText("");
	             jTextField5.setText("");
	             jTextField6.setText("");
	             jTextField7.setText("");
		    	}
		 
		    	  catch(Exception e1) {
		        e1.printStackTrace();}
            }
			}
		}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
		
	}

