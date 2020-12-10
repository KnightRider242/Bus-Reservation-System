/**
 * 
 */
package userBasicJava;

import java.sql.SQLException;

/**
 *
 * @author Abhay
 */
public interface BasicUserFunctions {
           
	public void ViewDetails() throws SQLException;
	public void UpdateDetails() throws SQLException;
	public void CancelTicket() throws SQLException;
	public void BookTicket();
		
    
}