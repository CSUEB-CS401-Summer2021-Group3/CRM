package edu.cs401group3.crm.record;

import java.util.Date;

public class Record implements RecordInterface {
	private Date timestamp;
	private String id;
	private String comment;
	
	public Record() {
		//TODO - Generate some kind of random id for each Record
		this.id = "";
		this.timestamp = new Date();
		this.comment = "";
	}
	
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
