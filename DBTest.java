import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class DBTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBTest frame = new DBTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DBTest() {
		setType(Type.POPUP);
		setBackground(Color.BLUE);
		setTitle("DB Connection App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(46, 74, 364, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(46, 153, 364, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(46, 234, 364, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnTestConnection = new JButton("Connect");
		btnTestConnection.setBounds(166, 293, 129, 32);
		btnTestConnection.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTestConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url = textField.getText();
				String userName = textField_1.getText();
				String password = textField_2.getText();
				
				Connection conn = null;  
			    try {    
			      Class.forName("oracle.jdbc.driver.OracleDriver");    
			      System.out.println("Connecting to database...");    
			      conn = DriverManager.getConnection(url,userName,password);    
			    } catch (Exception e) {  
			    	JOptionPane.showMessageDialog(btnTestConnection, "Invalid Connection");
			      e.printStackTrace();    
			    } finally {    
			      if (conn != null) {    
			        try {    
			          conn.close(); 
			          JOptionPane.showMessageDialog(btnTestConnection, "Connection Succesfull");
			        } catch (SQLException e) {    
			        	JOptionPane.showMessageDialog(btnTestConnection, "Invalid Connection");  
			        }    
			      }    
			    }            
			    
				
			}
		});
		contentPane.add(btnTestConnection);
		
		JLabel lblDatabaseJdbcUrl = new JLabel("Database JDBC URL");
		lblDatabaseJdbcUrl.setBounds(158, 36, 147, 27);
		lblDatabaseJdbcUrl.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblDatabaseJdbcUrl);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(189, 117, 83, 20);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblUserName);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(189, 201, 83, 20);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblPassword);
	}
}
