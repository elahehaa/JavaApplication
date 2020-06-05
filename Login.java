import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
  Connection connection = null;
  private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection = mysqlConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CheeseUp");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Al Tarikh", Font.PLAIN, 30));
		lblNewLabel.setBounds(152, 29, 154, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(54, 92, 79, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(54, 120, 203, 29);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(54, 161, 68, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String query="Select * from Employee where username=? and passwords=? and JobType=? ";
					PreparedStatement pst= connection.prepareStatement(query) ;
					pst.setString(1, textArea.getText() );
					pst.setString(2, passwordField.getText() );
					pst.setString(3, "Manager");
					
					ResultSet rs=pst.executeQuery();
					int count = 0;
					while(rs.next()) {
						count=count+1;
						
					}
					if(count==1 ) {
						JOptionPane.showMessageDialog(null, "username and password is correct, Adminestrator mode is loading...");
						frame.dispose();
						//main page
						FirstPage empInfo = new FirstPage();
						empInfo.setVisible(true);
						
					}
					else if (count>1) {
						JOptionPane.showMessageDialog(null, "Duplicate username and password");
					}
					else {
						try {
							String query1="Select * from Employee where username=? and passwords=? and JobType=? ";
							PreparedStatement pst1= connection.prepareStatement(query1) ;
							pst1.setString(1, textArea.getText() );
							pst1.setString(2, passwordField.getText() );
							pst1.setString(3, "Staff");
							
							ResultSet rs1=pst1.executeQuery();
							int count1 = 0;
							while(rs1.next()) {
								count1=count1+1;
								
							}
							if(count1==1 ) {
								JOptionPane.showMessageDialog(null, "username and password is correct, Staff mode is loading...");
								frame.dispose();
								//main page
								FirstPageStaff empInfoStaff = new FirstPageStaff();
								empInfoStaff.setVisible(true);
								
							}
							else if (count1>1) {
								JOptionPane.showMessageDialog(null, "Duplicate username and password");
							}
							else {
								JOptionPane.showMessageDialog(null, "Username and password is not correct. Try again...");
							}
							rs1.close();
							pst1.close();
								
						}catch(Exception c)
						{
							JOptionPane.showMessageDialog(null, c);
							
						}
						//JOptionPane.showMessageDialog(null, "Username and password is not correct. Try again...");
					}
					rs.close();
					pst.close();
						
				}catch(Exception c)
				{
					JOptionPane.showMessageDialog(null, c);
					
				}
				
				
				
				
			}
		});
		btnNewButton.setBounds(276, 229, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(54, 189, 203, 34);
		frame.getContentPane().add(passwordField);
	}
}
