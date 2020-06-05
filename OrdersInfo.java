//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

//import java.sql.*;
import javax.swing.*;
import java.awt.Color;
public class OrdersInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdersInfo frame = new OrdersInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTable table;
	private JScrollPane scrollPane;
	
	public void refreshTable() {
		try {
			String query = "select  Food_Name,Drink_Name,Bill_Number,Bill_Amount from Orders";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public OrdersInfo() {
		connection=mysqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 346);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLoadTable = new JButton("Load Orders Table");
		btnLoadTable.setBounds(6, 21, 188, 29);
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select Food_Name,Drink_Name,Bill_Number,Bill_Amount from Orders ";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnLoadTable);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(233, 37, 357, 239);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Food Name");
		lblNewLabel.setBounds(16, 53, 72, 16);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(98, 53, 106, 23);
		contentPane.add(textArea);
		
		JLabel lblLastName = new JLabel("Drink Name");
		lblLastName.setBounds(16, 83, 87, 16);
		contentPane.add(lblLastName);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(98, 83, 106, 23);
		contentPane.add(textArea_1);
		
		JLabel lblSsn = new JLabel("Bill Number");
		lblSsn.setBounds(16, 111, 87, 16);
		contentPane.add(lblSsn);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(122, 111, 72, 23);
		contentPane.add(textArea_2);
		
		
		JLabel lblWorkingHour = new JLabel("Total Price");
		lblWorkingHour.setBounds(16, 139, 106, 16);
		contentPane.add(lblWorkingHour);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(122, 139, 72, 23);
		contentPane.add(textArea_3);
		
		
		JButton btnNewButton = new JButton("Add Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into Orders(Food_Name,Drink_Name,Bill_Number,Bill_Amount) values (? , ? , ? ,? )";
					PreparedStatement pst = connection.prepareStatement (query);
					pst.setString(1, textArea.getText());
					pst.setString(2, textArea_1.getText());
					pst.setString(3, textArea_2.getText());
					pst.setString(4, textArea_3.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved!");
					
					pst.close();
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshTable();
			}
		});
		btnNewButton.setBounds(6, 196, 188, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Update Orders set Food_Name = '"+textArea.getText()+ "' , Drink_Name = '" +textArea_1.getText()+"' , Bill_Number='" +textArea_2.getText()+"' , Bill_Amount = '" +textArea_3.getText()+"' where Bill_Number='"+textArea_2.getText()+ "' ";
					PreparedStatement pst = connection.prepareStatement (query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated!");
					
					pst.close();
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshTable();	
			}
		});
		btnNewButton_1.setBounds(6, 222, 188, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnRemoveEmployee = new JButton("Delete Order");
		btnRemoveEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from Orders where Bill_Number= '"+textArea_2.getText()+ "' ";
					PreparedStatement pst = connection.prepareStatement (query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted!");
					
					pst.close();
					
					
				} catch (Exception e1x) {
					e1x.printStackTrace();
				}
				refreshTable();	
			}
			
		});
		btnRemoveEmployee.setBounds(6, 249, 188, 29);
		contentPane.add(btnRemoveEmployee);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(473, 288, 117, 29);
		contentPane.add(btnNewButton_2);
		
		
		
		
	}
}
