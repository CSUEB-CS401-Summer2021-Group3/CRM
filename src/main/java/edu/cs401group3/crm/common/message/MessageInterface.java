package edu.cs401group3.crm.common.message;

import java.util.Map;

/** Message Interface.
 * Messages are passed between Client and Server using ObjectStream.<br>
 * 
 * Each Message serves a specific purpose and this interface establishes a contract for what a Message should implement.
 * @author Nicholas Krone
*/
public interface MessageInterface {
	
	/** 
	 * Get Message type.<br>
	 * 
	 * Operations on Server operate based on the Message type. A type can never be overridden.
	 * @return A String for the Message type.
	 */
	String getType();

	/** 
	 * Set Message status.<br>
	 * 
	 * Message status can be used for validation of operations. All Client Messages will receive a reply from the Server. 
	 * The Client can use the Status to determine the success or failure of an operation.<br>
	 *  
	 * @return A String for the Message type.
	 */
	void setStatus(String status);

	/** 
	 * Get Message status.<br>
	 * 
	 * Message status can be used for validation of operations. All Client Messages will receive a reply from the Server.<br> 
	 * The Client can use the Status to determine the success or failure of an operation.
	 * 
	 */
	String getStatus();
	
	/** 
	 * Set Message content.<br>
	 * 
	 * Each Message contains a payload that is used for operations. Such operations will require that content for the operation to work. 
	 */
	void setContent(Map<String, Object> content);
	
	/** 
	 * Get Message content.<br>
	 * 
	 * Each Message contains a payload that is used for operations. Such operations will require that content for the operation to work. 
	 *  
	 * @return A Map containing content.
	 */
	Map<String, Object> getContent();
}
