//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

//import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FirstPageStaff extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPageStaff frame = new FirstPageStaff();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection connection = null;
	/**
	 * Create the frame.
	 */
	public FirstPageStaff() {
		connection=mysqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 418);
		JPanel contentPane = new JPanel();
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Employee");
		btnLoadTable.setEnabled(false);	
	btnLoadTable.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyPressed(KeyEvent e) {
				
			
			}
		});
		btnLoadTable.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnLoadTable.setForeground(Color.BLUE);
		btnLoadTable.setBackground(Color.BLUE);
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmployeesInfo().setVisible(true);
				/*try {
					String query = "select Fname,Lname,Working_hour, Phone_number from Employee ";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}*/
			}
		});
		btnLoadTable.setBounds(151, 101, 171, 48);
		contentPane.add(btnLoadTable);
		
		JButton btnDisplayTimesheet = new JButton("Timesheet");
		btnDisplayTimesheet.setForeground(Color.BLUE);
		btnDisplayTimesheet.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnDisplayTimesheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TimesheetInfo().setVisible(true);
				
			}
		});
		btnDisplayTimesheet.setBounds(151, 269, 171, 48);
		contentPane.add(btnDisplayTimesheet);
		
	
		
		JButton btnDisplayPaymentMethod = new JButton("Payment");
		btnDisplayPaymentMethod.setForeground(Color.BLUE);
		btnDisplayPaymentMethod.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnDisplayPaymentMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PaymentInfo().setVisible(true);
			}
		});
		btnDisplayPaymentMethod.setBounds(458, 269, 171, 48);
		contentPane.add(btnDisplayPaymentMethod);
		
		JButton btnSupplier = new JButton("Supplier");
		btnSupplier.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnSupplier.setForeground(Color.BLUE);
		btnSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SupplierInfo().setVisible(true);
			}
		});
		btnSupplier.setBounds(458, 101, 171, 48);
		contentPane.add(btnSupplier);
		
		JLabel label = new JLabel("CheeseUp");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Al Tarikh", Font.BOLD, 30));
		label.setBounds(314, 41, 154, 48);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(330, 340, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnOrders = new JButton("Orders");
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrdersInfo().setVisible(true);
			}
			
		});
		btnOrders.setForeground(Color.BLUE);
		btnOrders.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnOrders.setBounds(151, 185, 171, 48);
		contentPane.add(btnOrders);
		
		JButton btnClients = new JButton("Clients");
		btnClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClientInfo().setVisible(true);
			}
		});
		btnClients.setForeground(Color.BLUE);
		btnClients.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnClients.setBounds(458, 185, 171, 48);
		contentPane.add(btnClients);
	}
}
