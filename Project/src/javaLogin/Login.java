/**
 * 
 */
package javaLogin;
import userBasicJava.BasicJFrame;
import userStaffJava.StaffJFrame;
import userAdminJava.AdminJFRame;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

/**
 * @author Adharsh S Mathew - AM.EN.U4CSE19302
 */
public class Login extends JFrame {

	private static final long serialVersionUID = 2618528501822257528L;
	private JPanel contentPane;
	private JTextField userInput;
	private JPasswordField passInput;
		/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel head = new JLabel("Login System");
		head.setFont(new Font("Arial", Font.BOLD, 33));
		head.setVerticalAlignment(SwingConstants.CENTER);
		head.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel user = new JLabel("Username : ");
		user.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		
		JLabel pass = new JLabel("Password : ");
		pass.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		
		userInput = new JTextField();
		userInput.setColumns(10);
		
		passInput = new JPasswordField();
		
		JCheckBox showPass = new JCheckBox("Show Password");
		showPass.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource() == showPass)
        		{
        			if(showPass.isSelected())
        			{
        				passInput.setEchoChar((char) 0);
        			}
        			else
        				passInput.setEchoChar('*');
        		}
        }
        });
		
		JButton submit = new JButton("Login");
		submit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userName = userInput.getText();
                @SuppressWarnings("deprecation")
				String password = passInput.getText();
                try {
                	try {
						Class.forName("org.postgresql.Driver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

                    Connection connection = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/B_R_S", "postgres","1379Adharsh");

                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select name from passenger where name=?");
                    PreparedStatement st1 = (PreparedStatement) connection.prepareStatement("Select name from staff where name=?");

                    st1.setString(1, userName);

                    st.setString(1, userName);
                    //st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    ResultSet rs1 = st1.executeQuery();
                    if (rs.next()) {
                        dispose();
                       
                        BasicJFrame ah = new  BasicJFrame(userName);
                       // ah.setTitle("Welcome");
                        ah.setVisible(true);
                        ah.setResizable(false);
                        JOptionPane.showMessageDialog(submit, "User Login Successful");
                    } 
                    else if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin") == true )
                    {
                    	dispose();
                        
                        AdminJFRame ah = new  AdminJFRame();
                        //ah.setTitle("Welcome");
                        ah.setVisible(true);
                        ah.setResizable(false);
                    	JOptionPane.showMessageDialog(submit, "Admin Login Successful");                	
                    }
                    else if (rs1.next()) {
                        dispose();
                       
                        StaffJFrame ah = new  StaffJFrame(userName);
                        //ah.setTitle("Welcome");
                        ah.setVisible(true);
                        ah.setResizable(false);
                        JOptionPane.showMessageDialog(submit, "Staff Login Successful");
                    }
                    else {
                        JOptionPane.showMessageDialog(submit, "Invalid Username or Password");
                    }
                    
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                
                	
            }
        });
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource() == reset)
        		{
        			userInput.setText("");
        			passInput.setText("");
        		}
        }
        });
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource() == exit)
        		{
        			dispose();
        			
        		}
        }
        });
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(211)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(user)
								.addComponent(pass))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userInput, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
								.addComponent(passInput, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(submit, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(137)
							.addComponent(showPass, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(reset, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(exit, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(306)
							.addComponent(head)))
					.addGap(141))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(head, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(user, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(userInput, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(pass, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(passInput, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
						.addComponent(submit, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(showPass, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(reset, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(exit, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
