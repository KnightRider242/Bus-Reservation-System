/**
 * 
 */
package userStaffJava;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javaLogin.Login;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author Adharsh S Mathew - AM.EN.U4CSE19302
 */
public class StaffJFrame extends JFrame implements StaffUserFunctions {

	private static final long serialVersionUID = 1631346801595911580L;
	private JPanel contentPane;
	private JTextField inputName;
	private JTextField inputT;
	Connection connect = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String user = null;
    JLabel userBno = new JLabel("<dynamic>");
	
	JLabel userType = new JLabel("<dynamic>");
	
	JLabel userAdd = new JLabel("<dynamic>");
	
	JLabel userStafID = new JLabel("<dynamic>");
	
	JLabel userN = new JLabel("<dynamic>");
	private JTextField nameI = new JTextField();
	private JTextField addI = new JTextField();

		/**
	 * Create the frame.
	 */
	public StaffJFrame(String s) {
    	this.user = s;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1234, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel header = new JLabel("Welcome : ");
		header.setFont(new Font("Tahoma", Font.PLAIN, 39));
		
		JLabel user = new JLabel("");
		user.setFont(new Font("Tahoma", Font.PLAIN, 26));
		user.setText(s);
		
		JSeparator separator = new JSeparator();
		
		JButton logout = new JButton("Logout");
		logout.setFont(new Font("Dialog", Font.PLAIN, 31));
		logout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource() == logout)
        		{
        			dispose();
        			Login ah = new  Login();                 
                    ah.setVisible(true);
                    JOptionPane.showMessageDialog(logout, "Logout Successful");
        		}
        }
        });
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(441)
							.addComponent(header)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(user, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
							.addComponent(logout, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1194, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(logout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(header, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(user, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))))
					.addGap(30)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 1165, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		JPanel tab1 = new JPanel();
		tabbedPane.addTab("Update Ticket", null, tab1, null);
		
		JLabel addName = new JLabel("Name");
		
		inputName = new JTextField();
		inputName.setColumns(10);
		
		JLabel ticket_no = new JLabel("Ticket No");
		
		inputT = new JTextField();
		inputT.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnConfirm)
				{
					JOptionPane.showMessageDialog(btnConfirm, "Work In Progress");
				}
			}
		});
		GroupLayout gl_tab1 = new GroupLayout(tab1);
		gl_tab1.setHorizontalGroup(
			gl_tab1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tab1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_tab1.createSequentialGroup()
								.addComponent(ticket_no, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(inputT, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_tab1.createSequentialGroup()
								.addComponent(addName)
								.addGap(45)
								.addComponent(inputName, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnConfirm))
					.addContainerGap(767, Short.MAX_VALUE))
		);
		gl_tab1.setVerticalGroup(
			gl_tab1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab1.createSequentialGroup()
					.addGroup(gl_tab1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab1.createSequentialGroup()
							.addGap(38)
							.addComponent(addName))
						.addGroup(gl_tab1.createSequentialGroup()
							.addGap(23)
							.addComponent(inputName, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_tab1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab1.createSequentialGroup()
							.addGap(98)
							.addComponent(inputT, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tab1.createSequentialGroup()
							.addGap(113)
							.addComponent(ticket_no)))
					.addGap(47)
					.addComponent(btnConfirm)
					.addContainerGap(230, Short.MAX_VALUE))
		);
		tab1.setLayout(gl_tab1);
		
		JPanel tab2 = new JPanel();
		tabbedPane.addTab("Update Bus", null, tab2, null);
		
		JLabel lblNewLabel = new JLabel("WORK IN PROGRESS");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_tab2 = new GroupLayout(tab2);
		gl_tab2.setHorizontalGroup(
			gl_tab2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab2.createSequentialGroup()
					.addGap(105)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 988, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		gl_tab2.setVerticalGroup(
			gl_tab2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab2.createSequentialGroup()
					.addGap(46)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(72, Short.MAX_VALUE))
		);
		tab2.setLayout(gl_tab2);
		
		JPanel tab3 = new JPanel();
		tabbedPane.addTab("View Details", null, tab3, null);
		
		
		
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource() == Submit)
        		{
        			try {
        				PrintDetails();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		}
        }
        });
		GroupLayout gl_tab3 = new GroupLayout(tab3);
		gl_tab3.setHorizontalGroup(
			gl_tab3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_tab3.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_tab3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab3.createSequentialGroup()
							.addGroup(gl_tab3.createParallelGroup(Alignment.LEADING)
								.addComponent(userN, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
								.addComponent(userStafID, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
							.addGap(238)
							.addComponent(Submit, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
						.addComponent(userAdd, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
						.addComponent(userType, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
						.addComponent(userBno, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
					.addGap(416))
		);
		gl_tab3.setVerticalGroup(
			gl_tab3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab3.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_tab3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab3.createSequentialGroup()
							.addComponent(userN, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(userStafID, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tab3.createSequentialGroup()
							.addGap(20)
							.addComponent(Submit, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addComponent(userAdd, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(userType, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(userBno, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(229, Short.MAX_VALUE))
		);
		tab3.setLayout(gl_tab3);
		
		JPanel tab4 = new JPanel();
		tabbedPane.addTab("Update Staff", null, tab4, null);
		
		JLabel Name = new JLabel("Name");
		
		
		nameI.setColumns(10);
		
		JLabel newAdd = new JLabel("New Address");
		
		addI = new JTextField();
		addI.setColumns(10);
		
		JButton Usubmit = new JButton("Submit");
		GroupLayout gl_tab4 = new GroupLayout(tab4);
		gl_tab4.setHorizontalGroup(
			gl_tab4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab4.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_tab4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab4.createSequentialGroup()
							.addComponent(Name, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(nameI, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tab4.createSequentialGroup()
							.addComponent(newAdd, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(addI, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tab4.createSequentialGroup()
							.addGap(12)
							.addComponent(Usubmit, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(810, Short.MAX_VALUE))
		);
		gl_tab4.setVerticalGroup(
			gl_tab4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab4.createSequentialGroup()
					.addGap(61)
					.addGap(38)
					.addGroup(gl_tab4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab4.createSequentialGroup()
							.addGap(18)
							.addComponent(Name))
						.addComponent(nameI, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(gl_tab4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab4.createSequentialGroup()
							.addGap(18)
							.addComponent(newAdd))
						.addComponent(addI, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(67)
					.addComponent(Usubmit, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(168, Short.MAX_VALUE))
		);
		tab4.setLayout(gl_tab4);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

		@Override
		public void UpdatePassengerTicket() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void UpdateStaff()throws SQLException {
			// TODO Auto-generated method stub
			try {
	            Class.forName("org.postgresql.Driver");
	            connect  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/B_R_S", "postgres","1379Adharsh");
	            statement = connect.createStatement();
	            }
	        catch (ClassNotFoundException e) {
	            }
	    	String name = nameI.getText();
	    	String address = addI.getText();
			PreparedStatement st = (PreparedStatement) connect.prepareStatement("update staff set address=? where name=?");
			st.setString(1,address);
			st.setString(2, name);
			st.executeQuery();
		}

		@Override
		public void UpdateBusInfo() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void PrintDetails() throws SQLException{
			// TODO Auto-generated method stub
			try {
	            Class.forName("org.postgresql.Driver");
	            connect  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/B_R_S", "postgres","1379Adharsh");
	            statement = connect.createStatement();
	            }
	        catch (ClassNotFoundException e) {
	            }
	    	
			// TODO Auto-generated method stub
			PreparedStatement st = (PreparedStatement) connect.prepareStatement("Select name,address,staff_id,type,bus_no from staff where name=?");
			st.setString(1, user);
			ResultSet rs = st.executeQuery();
	    	
	    	while (rs.next()) 
	    	{
	            String Name = rs.getString("name");
	            String staff_id = rs.getString("staff_id");
	            String add = rs.getString("address");
	            
	            String Type = rs.getString("type");
	            int bus = rs.getInt("bus_no");
	            String busNO = Integer.toString(bus);
	            userN.setText("Name:  " + Name);
	            userAdd.setText("Address:  " + add);
	            userBno.setText("Bus No :   "+busNO);
	            userStafID.setText("Staff Id:   "+ staff_id);
	            userType.setText("Staff Type:   "+ Type);	           
			
		}
		}
}
