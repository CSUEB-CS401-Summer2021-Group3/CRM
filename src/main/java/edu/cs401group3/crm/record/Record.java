package edu.cs401group3.crm.record;

import java.util.Date;

/** Record Class.
 * A Record represents a data object.<br>
 * 
 * A Client for example can have a list of Records which keep track of different bits of data. Each Record is unique with an ID.
 * 
 * @author Nicholas Krone
*/
public class Record implements RecordInterface {
	private Date timestamp;
	private String id;
	private String comment;
	
	/** Create a new Record.
	 * 
	 */
	public Record() {
		//TODO - Generate some kind of random id for each Record
		this.id = "";
		this.timestamp = new Date();
		this.comment = "";
	}
	
	/** Create a new Record with id, timestamp, comment
	 * 
	 * @param id A String representing a Record ID.
	 * @param timestamp A Date representing the timestamp of the Record.
	 * @param comment A String representing the Record comment.
	 */
	public Record(String id, Date timestamp, String comment) {
		this.id = id;
		this.timestamp = timestamp;
		this.comment = comment;
	}

	@Override
	public Date getTimeStamp() {
		return timestamp;
	}

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String getId() {
		return id;
	}

}
