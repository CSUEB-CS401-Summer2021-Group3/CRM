package edu.cs401group3.crm.common.message;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;

public class StorageMessage implements Message, Comparator<StorageMessage> {
	private final String type = "storage";
	private String status;
	private Date timestamp;
	private Map<String, String> payload;
	
	public StorageMessage() {
		status = "pending";
		timestamp = new Date();
	}
	
	public StorageMessage(Map<String, String> payload) {
		this.payload = payload;
		timestamp = new Date();
		status = "pending";
	}

	@Override
	public int compare(StorageMessage o1, StorageMessage o2) {		
        if (o1.getTimestamp().before(o2.getTimestamp())) {
            return -1;
        } else if (o1.getTimestamp().after(o2.getTimestamp())) {
            return 1;
        } else {
            return 0;
        }
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
	public void setContent(Map<String, String> content) {
		this.payload = content;
		
	}

	@Override
	public Map<String, String> getContent() {
		return payload;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

}
