package edu.cs401group3.crm.messages;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import edu.cs401group3.crm.common.message.StorageMessage;
import edu.cs401group3.crm.server.storage.StorageOperation;

class StorageMessageTest {

	@Test
	void StorageMessageValidateType() {
		StorageMessage msg = new StorageMessage();
		assertEquals(msg.getType(), "storage");	
	}

	@Test
	void StorageMessageValidateSetGetStatus() {
		StorageMessage msg = new StorageMessage();
		assertEquals(msg.getStatus(), "pending");
		
		msg.setStatus("accepted");
		assertEquals(msg.getStatus(),"accepted"); 	
	}
	
	@Test
	void CommandMessageValidateGetContent() {
		Map<String, Object> content = new HashMap<String, Object>();
		content.put("key", "value");
		
		StorageMessage msg = new StorageMessage(StorageOperation.WRITE, content);
		
		Map<String, Object> cntns = msg.getContent();

		for (Map.Entry<String, Object> entry: cntns.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			assertEquals(key, "key");
		    assertEquals(value.toString(), "value");
		}
	}

	@Test
	void StorageMessageValidateSetContent() {
		Map<String, Object> content = new HashMap<String, Object>();
		content.put("key", "value");
		
		StorageMessage msg = new StorageMessage();
		
		msg.setContent(content);
		
		for (Map.Entry<String, Object> entry: msg.getContent().entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			assertEquals(key, "key");
		    assertEquals(value.toString(), "value");
		}
	}
	
	@Test
	void StorageMessageValidateCompare() {
		StorageMessage o1 = new StorageMessage();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		StorageMessage o2 = new StorageMessage();
		assertEquals(-1, o1.compare(o2));
	}

	@Test
	void StorageMessageGetTimeStamp() {
		StorageMessage msg = new StorageMessage();
		Date ts = msg.getTimestamp();
		assert(ts instanceof Date);
	}
	
	@Test
	void StorageMessageGetOperation() {
		StorageMessage msg = new StorageMessage(StorageOperation.WRITE, null);
		assertEquals(StorageOperation.WRITE, msg.getOperation());
	}
	
	@Test
	void StorageMessageSetOperation() {
		StorageMessage msg = new StorageMessage(StorageOperation.WRITE, null);
		assertEquals(StorageOperation.WRITE, msg.getOperation());
		msg.setOperation(StorageOperation.READ);
		assertEquals(StorageOperation.READ, msg.getOperation());
	}
}
