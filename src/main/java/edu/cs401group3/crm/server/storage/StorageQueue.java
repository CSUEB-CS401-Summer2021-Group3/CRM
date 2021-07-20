package edu.cs401group3.crm.server.storage;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

import edu.cs401group3.crm.common.message.StorageMessage;

public class StorageQueue {
	
	private PriorityBlockingQueue<StorageMessage> queue;
	protected static StorageQueue uniqueInstance = new StorageQueue();
	
	public StorageQueue() {
		queue = new PriorityBlockingQueue<StorageMessage>();
	}
	
	public static synchronized StorageQueue getInstance() {
		return uniqueInstance;
	}
	
	public void enqueue(StorageMessage message) {
		queue.add(message);
	}
	
	public StorageMessage dequeue() throws InterruptedException {
		return queue.take();
	}
}
