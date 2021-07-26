package edu.cs401group3.crm.common.message;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import edu.cs401group3.crm.server.storage.StorageOperation;

/** StorageMessage Class.
 * Messages are passed between Client and Server using ObjectStream.<br>
 * 
 * A StorageMessage contains a payload of data to be saved to persistent storage.
 * @author Nicholas Krone
*/
public class StorageMessage extends Message implements MessageInterface, Comparator<StorageMessage>, Comparable<StorageMessage>, Serializable {
	private final String type = "storage";
	private String status;
	private Date timestamp;
	private StorageOperation operation;
	private Map<String, Object> payload;
	
	/** Create empty StorageMessage for future processing.
	 * 
	 */
	public StorageMessage() {
		status = "pending";
		timestamp = new Date();
		payload = new HashMap<String, Object>();
		this.setOperation(StorageOperation.WRITE);
	}
	
	/** Create new StorageMessage with payload.
	 * 
	 */
	public StorageMessage(StorageOperation operation, Map<String, Object> payload) {
		this.setOperation(operation);
		this.payload = payload;
		timestamp = new Date();
		status = "pending";
	}
		
	/** 
	 * 
	 * @param o2 Another StorageMessage to compare this StorageMessage to.<br>
	 * @return An int representing the comparison between both StorageMessages.
	 */
	public int compare(StorageMessage o2) {
		if (this.getTimestamp().before(o2.getTimestamp())) {
			return -1;
		} else if (this.getTimestamp().after(o2.getTimestamp())) {
			return 1;
		} else {
			return 0;
		}    
	}

	/** Get the StorageOperation
	 * @return the operation
	 */
	public StorageOperation getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(StorageOperation operation) {
		this.operation = operation;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public void setContent(Map<String, Object> content) {
		this.payload = content;
		
	}

	@Override
	public Map<String, Object> getContent() {
		return payload;
	}
	
	/** Get the TimeStamp for the Message.<br>
	 * 
	 * StorageMessages use a Date timestamp for how they are ordered in the StorageQueue.
	 * 
	 * @return A Date representing when the StorageMessage was created.
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public int compareTo(StorageMessage o) {

		return this.getTimestamp().compareTo(o.getTimestamp());
	}

	@Override
	public int compare(StorageMessage o1, StorageMessage o2) {
		if (this.getTimestamp().before(o2.getTimestamp())) {
			return -1;
		} else if (this.getTimestamp().after(o2.getTimestamp())) {
			return 1;
		} else {
			return 0;
		}
	}
}
