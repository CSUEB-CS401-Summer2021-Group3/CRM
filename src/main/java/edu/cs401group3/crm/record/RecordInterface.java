package edu.cs401group3.crm.record;

import java.util.Date;

public interface RecordInterface {

	public Date getTimeStamp();
	
	public String getComment();
	public void setComment(String comment);
	
	public String getId();
	
}
