package Formation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Rendement extends JFrame implements ActionListener,ItemListener{
	   private JButton jButton1;
	    private JComboBox<String> jComboBox1;
	    private JLabel jLabel1;
	    private JLabel jLabel2;
	    private JLabel jLabel3;
	    private JPanel jPanel1;
	    private JScrollPane jScrollPane1;
	    private JTable jTable1;
	    private JTextField jTextField1;
	    Connection con;
	    DefaultTableModel model;
	    int depences ;
	    int total;
	    int rendement;
	    String date;
	    public Rendement() {
	    	super("Rendement");
	        jPanel1 = new JPanel();
	        jScrollPane1 = new JScrollPane();
	        jTable1 = new JTable();
	        jLabel1 = new JLabel();
	        jComboBox1 = new JComboBox<>();
	        jLabel2 = new JLabel();
	        jTextField1 = new JTextField();
	        jButton1 = new JButton();
	        jLabel3 = new JLabel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        getContentPane().setLayout(null);
	        
	        jPanel1.setLayout(null);

	        model = new DefaultTableModel();
	        jTable1 = new JTable(model);
	        jScrollPane1 = new JScrollPane(jTable1);
	        jTable1.setShowGrid(true);
	        jTable1.setShowVerticalLines(true);
	       
	        model.addColumn("Code formation");
	        model.addColumn("Formation");
	        model.addColumn("Prix");
	        model.addColumn("NbParticipant");
	        model.addColumn("Salaire formateur");
	        model.addColumn("Depences");
	        model.addColumn("Total");
	        model.addColumn("Rendement");

	        try 
	        {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
	          
	            String query = "SELECT * FROM formation ";
	          
	            Statement stm = con.createStatement();
	            ResultSet res = stm.executeQuery(query);
	            Statement stm1=con.createStatement();
	            ResultSet res1=stm1.executeQuery("select UserName from formateur,formation where formation.formateur=formateur.Id_Formateur");
	            while (res.next() ) {
	            	 res1.next();
	            	 total=res.getInt("prix")*res.getInt("nParticipant");
	            	 depences=(total*20)/100;
	            	 date=res.getString("dateDebut");
	            	 System.out.println(date);
	            	 rendement=total-(depences+res.getInt("SalaireFormateur"));
	            	 model.addRow(new Object[] {res.getInt("Id_Formation")+"",res.getString("NomF"),res.getInt("prix")+"",res.getInt("nParticipant")+""
	            			,res.getInt("SalaireFormateur")+"",depences,total,rendement});
	           
	            
	            
	        
	          } }catch(Exception e) {
	            e.printStackTrace();
	          }
	        jTable1.setModel(model);
	        jScrollPane1.setViewportView(jTable1);

	        jPanel1.add(jScrollPane1);
	        jScrollPane1.setBounds(220, 110, 740, 320);

	        jLabel1.setBackground(new java.awt.Color(17, 78, 99));
	        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
	        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
	        jLabel1.setText("Statistique de l'année :");
	        jPanel1.add(jLabel1);
	        jLabel1.setBounds(10, 150, 180, 20);

	        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023", "2024", "2025" }));
	        jPanel1.add(jComboBox1);
	        jComboBox1.setBounds(50, 190, 140, 22);
	        jComboBox1.addItemListener(this);
	        jLabel2.setBackground(new java.awt.Color(17, 78, 99));
	        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
	        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
	        jLabel2.setText("Rendement totale par année :");
	        jPanel1.add(jLabel2);
	        jLabel2.setBounds(10, 290, 200, 30);
	        jPanel1.add(jTextField1);
	        jTextField1.setBounds(40, 340, 130, 30);

	        jButton1.setBackground(new java.awt.Color(17, 78, 99));
	        jButton1.setForeground(new java.awt.Color(242, 242, 242));
	        jButton1.setText("Retourner");
	        jPanel1.add(jButton1);
	        jButton1.setBounds(30, 460, 130, 22);
	        jButton1.addActionListener(this);

	        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\OneDrive\\Bureau\\SoumaDidiYoyo\\src\\Formation\\rondement.jpg")); // NOI18N
	        jPanel1.add(jLabel3);
	        jLabel3.setBounds(0, 0, 1000, 500);

	        getContentPane().add(jPanel1);
	        jPanel1.setBounds(0, 0, 1000, 500);

	        pack();

	    }
	    public static void main(String args[]) {
	    	Rendement p=new Rendement();
	    	p.setVisible(true);
	    	p.setSize(1000, 530);
	    }
		@Override
		public void itemStateChanged(ItemEvent e) {
			 if(e.getSource()==jComboBox1) {
				 if(e.getStateChange() == ItemEvent.SELECTED) {
					 String year=date.substring(0, 4);
					 int c=jTable1.getRowCount();
					 int somme=0;
					 for (int j = 0; j < c; j++) {
			        	 if(year.equals(jComboBox1.getSelectedItem().toString())){
			        		 somme=somme+Integer.parseInt(jTable1.getValueAt(j, 7).toString());
			        		 
			        	 }
			         }
					 jTextField1.setText(String.valueOf(somme));
				 }
			 }
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton j=(JButton)e.getSource();
			if(j==jButton1) {
				setVisible(false);
			}
			
		}
}
