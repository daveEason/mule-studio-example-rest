package org.ordermgmt;

/**
 * Interface for order processing.
 * 
 * @author david.eason@mulesoft.com
 */

public interface IProcessOrder {

		
	/**
	 * Retrieve an Order.
	 * 
	 * @param orderId
	 * @return Order
	 */

	Order retrieveOrder(String orderId);

	/**
	 * Create an order.
	 * 
	 * @return String orderId
	 */

	String createOrder(Order order);

	/**
	 * Update an order.
	 * 
	 * @param order
	 * @return Order
	 */
	String updateOrder(String orderId, Order order);

	/**
	 * Delete an order.
	 * 
	 * @param orderId
	 * @return String
	 */
	String deleteOrder(String orderId);
}
