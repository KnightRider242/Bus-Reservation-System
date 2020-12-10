/**
 * 
 */
package userAdminJava;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javaLogin.Login;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

/**
 * @author Adharsh S Mathew - AM.EN.U4CSE19302
 */
public class AdminJFRame extends JFrame implements AdminUserFunctions {

	private static final long serialVersionUID = -7746920472540690228L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public AdminJFRame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1234, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSeparator separator = new JSeparator();
		
		JLabel header = new JLabel("Admin System");
		header.setFont(new Font("Sylfaen", Font.BOLD, 31));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		
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
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 1192, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(327)
					.addComponent(header, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
					.addComponent(logout, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1197, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(header, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
						.addComponent(logout, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 1181, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel tab1 = new JPanel();
		tabbedPane.addTab("Update Ticket", null, tab1, null);
		
		JPanel tab2 = new JPanel();
		tabbedPane.addTab("Update Passenger", null, tab2, null);
		
		JPanel tab3 = new JPanel();
		tabbedPane.addTab("Update Bus", null, tab3, null);
		
		JPanel tab4 = new JPanel();
		tabbedPane.addTab("View Bookings", null, tab4, null);
		
		JPanel tab5 = new JPanel();
		tabbedPane.addTab("Update Price", null, tab5, null);
		
		JPanel tab6 = new JPanel();
		tabbedPane.addTab("Update Staff", null, tab6, null);
		
		JPanel tab7 = new JPanel();
		tabbedPane.addTab("Delete Records", null, tab7, null);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}


	@Override
	public void UpdatePassengerTicket() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void UpdatePassengerDetails() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void UpdateBusInfo() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void UpdateStaff() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void UpdateTicketPrice() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void PrintBookings() {
		// TODO Auto-generated method stub
		
	}
}
