package edu.cs401group3.crm.server.storage;

import java.util.concurrent.PriorityBlockingQueue;

import edu.cs401group3.crm.common.message.StorageMessage;

/** StorageQueue Class.
 * StorageMessages are pushed into a Queue which is handled by the StorageManager.<br>
 * 
 * The StorageQueue itself is a Singleton object which means only exactly 1 StorageQueue should be available at a time.
 * 
 * @author Nicholas Krone
*/
public class StorageQueue {
	
	private PriorityBlockingQueue<StorageMessage> queue;
	protected static StorageQueue uniqueInstance = new StorageQueue();

	
	/** Create a new PriorityBlockingQueue StorageQueue.
	 * 
	*/
	public StorageQueue() {
		queue = new PriorityBlockingQueue<StorageMessage>();
	}
	
	/** Return instance of the Queue
	 * 
	 * @return The Instance of the Queue.
	 */
	
	public static synchronized StorageQueue getInstance() {
		return uniqueInstance;
	}
	
	/** Add StorageMessage to Queue
	 * 
	 * @param message A StorageMessage which is inserted into the Queue.
	 */
	public void enqueue(StorageMessage message) {
		queue.add(message);
	}
	
	/** Get a StorageMessage from Queue. <br>
	 * 
	 * Note that this calls the take function which is blocking.
	 * 
	 * @return A StorageMessage at the top of the Queue.
	 * @throws InterruptedException
	 */
	public StorageMessage dequeue() throws InterruptedException {
		return queue.take();
	}
}
