package edu.cs401group3.crm.storage;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.cs401group3.crm.common.message.StorageMessage;
import edu.cs401group3.crm.fileio.FileOperation;
import edu.cs401group3.crm.server.storage.StorageManager;
import edu.cs401group3.crm.server.storage.StorageOperation;
import edu.cs401group3.crm.server.storage.StorageQueue;

public class StorageManagerTest {
	
	Path rootDir = Paths.get("TestFolder"); 
	StorageManager storageManager = new StorageManager();	
	private StorageQueue queue = StorageQueue.getInstance();


	@Before
	public void setupRootDir() {
		rootDir.toFile().mkdir();
	}


	@Test
	public void StorageManagerTestReadFromQueue() {
		Thread thread = new Thread(storageManager);
		thread.start();
		
		Path file = Paths.get(rootDir.toString() + "/TestFile");
		FileOperation fileio = new FileOperation();
		
		Map<String, Object> content = new HashMap<String, Object>();
		StorageMessage msg = new StorageMessage();
		content.put("data", "TEST STRING");
		content.put("target", file);
		msg.setContent(content);
		msg.setOperation(StorageOperation.WRITE);
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		queue.enqueue(msg);

		storageManager.setStop();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, fileio.findLineInFile(file, "TEST STRING"));
		
		fileio.deleteFolder(rootDir);
	}
}
