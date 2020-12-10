/**
 * 
 */
package userBasicJava;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javaLogin.Login;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
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

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Color;

/**
 * @author Adharsh S Mathew - AM.EN.U4CSE19302
 */

public class BasicJFrame extends JFrame implements BasicUserFunctions{

	private static final long serialVersionUID = -4039272103920681581L;
	private JPanel contentPane;
	private JTextField nameInput;
	private JTextField ageInput;
	private JTextField addressInput;
	private JTextField genderInput;
	Connection connect = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    public String user;
    JLabel userN = new JLabel("<dynamic>");
	
	JLabel userAddress = new JLabel("<dynamic>");
	
	JLabel userPassID = new JLabel("<dynamic>");
	JLabel userTno = new JLabel("<dynamic>");
	
	JLabel userType = new JLabel("<dynamic>");
	
	JLabel userbmode = new JLabel("<dynamic>");
	
	JLabel userPrice = new JLabel("<dynamic>");
	private JTextField addAddress = new JTextField();
	private JTextField addName = new JTextField();
	JLabel newAdd = new JLabel("New Address");
	JLabel Name = new JLabel("Name");
	JLabel Price = new JLabel("<dynamic>");



	/**
	 * Create the frame.
	 */
	public BasicJFrame(String s) {
		this.user = s;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1234, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSeparator separator = new JSeparator();
		
		JLabel header = new JLabel("Welcome: ");
		header.setFont(new Font("Tahoma", Font.PLAIN, 34));
		
		JLabel user = new JLabel("");
		user.setText(s);
		user.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
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
					.addContainerGap()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1157, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1163, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(284)
							.addComponent(header)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(user, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
							.addComponent(logout, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
					.addGap(20))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(header, GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE)
								.addComponent(user, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
							.addGap(30))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(logout, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
					.addGap(44))
		);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel tab1 = new JPanel();
		tabbedPane.addTab("Book Ticket", null, tab1, null);
		
		JLabel name = new JLabel("Name : ");
		name.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		nameInput = new JTextField();
		nameInput.setColumns(10);
		
		JLabel age = new JLabel("Age : ");
		age.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		ageInput = new JTextField();
		ageInput.setColumns(10);
		
		JLabel address = new JLabel("Address : ");
		address.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		addressInput = new JTextField();
		addressInput.setColumns(10);
		
		JLabel gender = new JLabel("Gender : ");
		gender.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		genderInput = new JTextField();
		genderInput.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.setFont(new Font("Tahoma", Font.PLAIN, 41));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == submit)
				{
					JOptionPane.showMessageDialog(submit, "Work In Progress");
				}
			}
		});
		
		JButton clr = new JButton("Clear");
		clr.setFont(new Font("Tahoma", Font.PLAIN, 41));
		clr.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource() == clr)
        		{
        			nameInput.setText("");
        			ageInput.setText("");
        			genderInput.setText("");
        			addressInput.setText("");
        		}
        }
        });
		
		
		GroupLayout gl_tab1 = new GroupLayout(tab1);
		gl_tab1.setHorizontalGroup(
			gl_tab1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tab1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab1.createSequentialGroup()
							.addGroup(gl_tab1.createParallelGroup(Alignment.TRAILING)
								.addComponent(name)
								.addComponent(age, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(address, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
								.addComponent(gender))
							.addGap(35)
							.addGroup(gl_tab1.createParallelGroup(Alignment.LEADING)
								.addComponent(addressInput, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
								.addComponent(ageInput, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
								.addComponent(nameInput, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
								.addComponent(genderInput, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(911, Short.MAX_VALUE))
						.addGroup(gl_tab1.createSequentialGroup()
							.addComponent(submit, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(clr, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_tab1.setVerticalGroup(
			gl_tab1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab1.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_tab1.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameInput, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(name, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_tab1.createParallelGroup(Alignment.LEADING)
						.addComponent(age, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(ageInput, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_tab1.createParallelGroup(Alignment.LEADING)
						.addComponent(address, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(addressInput, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_tab1.createParallelGroup(Alignment.BASELINE)
						.addComponent(genderInput, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(gender, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(106)
					.addGroup(gl_tab1.createParallelGroup(Alignment.LEADING)
						.addComponent(submit, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(clr, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(378, Short.MAX_VALUE))
		);
		tab1.setLayout(gl_tab1);
		
		JPanel tab4 = new JPanel();
		tabbedPane.addTab("Print Details", null, tab4, null);
		
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource() == Submit)
        		{
        			try {
						ViewDetails();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		}
        }
        });
		
		
		
		
		
		
	
		GroupLayout gl_tab4 = new GroupLayout(tab4);
		gl_tab4.setHorizontalGroup(
			gl_tab4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab4.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_tab4.createParallelGroup(Alignment.LEADING)
						.addComponent(userPrice, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
						.addComponent(userbmode, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
						.addComponent(userType, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_tab4.createSequentialGroup()
							.addGroup(gl_tab4.createParallelGroup(Alignment.LEADING)
								.addComponent(userN, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
								.addComponent(userPassID, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
								.addComponent(userTno, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
							.addGap(238)
							.addComponent(Submit, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
						.addComponent(userAddress, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1284, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_tab4.setVerticalGroup(
			gl_tab4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab4.createSequentialGroup()
					.addGroup(gl_tab4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab4.createSequentialGroup()
							.addGap(31)
							.addComponent(userN, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userPassID, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userTno, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userType, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userbmode, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_tab4.createSequentialGroup()
							.addContainerGap(51, Short.MAX_VALUE)
							.addComponent(Submit, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(158)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(userAddress, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(userPrice, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(780))
		);
		tab4.setLayout(gl_tab4);
		
		JPanel tab2 = new JPanel();
		tabbedPane.addTab("Cancel Ticket", null, tab2, null);
		
		JButton Confirm = new JButton("Confirm");
		Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Confirm)
				{
					JOptionPane.showMessageDialog(Confirm, "Work In Progress");
				}
			}
		});
		
		
		Price.setFont(new Font("Dialog", Font.BOLD, 13));
		Price.setEnabled(false);
		Price.setBackground(new Color(238, 238, 238));
		GroupLayout gl_tab2 = new GroupLayout(tab2);
		gl_tab2.setHorizontalGroup(
			gl_tab2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab2.createSequentialGroup()
					.addGap(34)
					.addComponent(Confirm, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(Price, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(889, Short.MAX_VALUE))
		);
		gl_tab2.setVerticalGroup(
			gl_tab2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab2.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_tab2.createParallelGroup(Alignment.BASELINE)
						.addComponent(Confirm, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(Price, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(1053, Short.MAX_VALUE))
		);
		tab2.setLayout(gl_tab2);
		
		JPanel tab3 = new JPanel();
		tabbedPane.addTab("Update Details", null, tab3, null);
		
		JLabel newAdd = new JLabel("New Address");
		
		
		addAddress.setColumns(10);
		
		addName = new JTextField();
		addName.setColumns(10);
		
		
		
		JButton Usubmit = new JButton("Submit");
		Usubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Usubmit)
				{
					try {
						UpdateDetails();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		GroupLayout gl_tab3 = new GroupLayout(tab3);
		gl_tab3.setHorizontalGroup(
			gl_tab3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab3.createSequentialGroup()
					.addGroup(gl_tab3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab3.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_tab3.createSequentialGroup()
								.addComponent(Name, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(addName, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_tab3.createSequentialGroup()
								.addComponent(newAdd)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(addAddress, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_tab3.createSequentialGroup()
							.addGap(12)
							.addComponent(Usubmit, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(992, Short.MAX_VALUE))
		);
		gl_tab3.setVerticalGroup(
			gl_tab3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tab3.createSequentialGroup()
					.addGap(69)
					.addGroup(gl_tab3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tab3.createSequentialGroup()
							.addGap(18)
							.addComponent(Name))
						.addComponent(addName, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(gl_tab3.createParallelGroup(Alignment.BASELINE)
						.addComponent(newAdd)
						.addComponent(addAddress, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(67)
					.addComponent(Usubmit, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(780, Short.MAX_VALUE))
		);
		tab3.setLayout(gl_tab3);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(287, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}


	@Override
	public void BookTicket() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void CancelTicket() throws SQLException {
		// TODO Auto-generated method stub
		try {
            Class.forName("org.postgresql.Driver");
            connect  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/B_R_S", "postgres","1379Adharsh");
            statement = connect.createStatement();
            }
        catch (ClassNotFoundException e) {
            }
    	String name = addName.getText();
    	String address = addAddress.getText();
		//PreparedStatement st1 = (PreparedStatement) connect.prepareStatement(" passenger set address=? where name=?");
		PreparedStatement st = (PreparedStatement) connect.prepareStatement("update passenger set address=? where name=?");
		st.setString(1,address);
		st.setString(2, name);
		st.executeQuery();
		
	}


	@Override
	public void UpdateDetails() throws SQLException {
		// TODO Auto-generated method stub
		try {
            Class.forName("org.postgresql.Driver");
            connect  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/B_R_S", "postgres","1379Adharsh");
            statement = connect.createStatement();
            }
        catch (ClassNotFoundException e) {
            }
    	String name = addName.getText();
    	String address = addAddress.getText();
		PreparedStatement st = (PreparedStatement) connect.prepareStatement("update passenger set address=? where name=?");
		st.setString(1,address);
		st.setString(2, name);
		st.executeQuery();
		
	}


	@Override
	public void ViewDetails() throws SQLException {
		try {
            Class.forName("org.postgresql.Driver");
            connect  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/B_R_S", "postgres","1379Adharsh");
            statement = connect.createStatement();
            }
        catch (ClassNotFoundException e) {
            }
    	
		// TODO Auto-generated method stub
		PreparedStatement st = (PreparedStatement) connect.prepareStatement("Select name,address,pass_id,ticket_no,type,booking_mode,price from passenger natural join ticket where name=?");
		st.setString(1, user);
		ResultSet rs = st.executeQuery();
    	
    	while (rs.next()) 
    	{
            String Name = rs.getString("name");
            String Pass_id = rs.getString("pass_id");
            String add = rs.getString("address");
            long Tno = rs.getLong("ticket_no");
            String Type = rs.getString("type");
            String bmode = rs.getString("booking_mode");
            double price = rs.getDouble("price");
            
            //String gen = rs.getString("gender");
            //int age =resultSet.getInt("ticket_no");      
           // String a = Integer.toString(age);
            //int Ticketno =resultSet.getInt("ticket_no");
            String t = Integer.toString((int) Tno);
            userN.setText("Name:  " + Name);
            userAddress.setText("Address:  " + add);
            userPassID.setText("Pass Id:   "+ Pass_id);
            userbmode.setText("Booking Mode:   "+ bmode);
            userType.setText( "Ticket Type:   "+ Type);
            String p = Integer.toString((int) price);
            userPrice.setText("Cost:    Rs. "+p);
            userTno.setText("Ticket Id:   "+t);
            
            
            
            
            
            
        }
    }
}

