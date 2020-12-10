/**
 * 
 */
package userStaffJava;

import java.sql.SQLException;

/**
 * @author Adharsh S Mathew - AM.EN.U4CSE19302
 */
public interface StaffUserFunctions {
	public void UpdatePassengerTicket();
	public void UpdateStaff() throws SQLException;
	public void UpdateBusInfo();
	public void PrintDetails() throws SQLException;

}
