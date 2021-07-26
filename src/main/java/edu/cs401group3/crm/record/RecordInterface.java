package edu.cs401group3.crm.record;

import java.util.Date;

/** Record Interface.
 * A Record represents a data object.<br>
 * 
 * A Client for example can have a list of Records which keep track of different bits of data. Each Record is unique with an ID.
 * 
 * @author Nicholas Krone
*/
public interface RecordInterface {

	/** Get Timestamp.<br>
	 * Each created Record has a timestamp set at instantiation.
	 * @return
	 */
	public Date getTimeStamp();

	/** Get Comment.<br>
	 * 
	 * @return A String representing a Record comment.
	 */
	public String getComment();
	
	/** Set Comment.<br>
	 * 
	 * @param comment A String representing a comment.
	 */
	public void setComment(String comment);
	
	/** Get ID.
	 * 
	 * @return A String representing the ID of the Record.
	 */
	public String getId();
	
}
