package edu.cs401group3.crm.record;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.Test;

public class RecordTest {

	@Test
	public void RecordTestCreateRecord() {
		Record record = new Record();
		assertEquals("", record.getComment());
		assertEquals("", record.getId());
		
	}

	@Test
	public void RecordTestCreateRecordFunction() {
		Date date = new Date();
		String id = "1234";
		String comment = "test comment";
		Record record = new Record(id, date, comment);
		assertEquals(comment, record.getComment());
		assertEquals(id, record.getId());
		assertEquals(date, record.getTimeStamp());
	}

	@Test
	public void RecordTestGetTimeStamp() {
		Date date = new Date();
		String id = "1234";
		String comment = "test comment";
		Record record = new Record(id, date, comment);
		assertEquals(date, record.getTimeStamp());
	}

	@Test
	public void RecordTestGetComment() {
		Date date = new Date();
		String id = "1234";
		String comment = "test comment";
		Record record = new Record(id, date, comment);
		assertEquals(comment, record.getComment());

	}

	@Test
	public void RecordTestSetComment() {
		Date date = new Date();
		String id = "1234";
		String comment = "test comment";
		Record record = new Record(id, date, comment);
		assertEquals(comment, record.getComment());
		record.setComment("This is a new comment");
		assertEquals("This is a new comment", record.getComment());
	}

	@Test
	public void RecordTestGetId() {
		Date date = new Date();
		String id = "1234";
		String comment = "test comment";
		Record record = new Record(id, date, comment);
		assertEquals(id, record.getId());
	}
}
