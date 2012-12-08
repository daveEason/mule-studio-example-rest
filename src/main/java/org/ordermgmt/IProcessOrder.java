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

	OrderConfirmation retrieveOrder(String orderId);

	/**
	 * Create an order.
	 * 
	 * @return String orderId
	 */

	OrderConfirmation createOrder(Order order);

	/**
	 * Update an order.
	 * 
	 * @param order
	 * @return Order
	 */
	OrderConfirmation updateOrder(String orderId, Order order);

	/**
	 * Delete an order.
	 * 
	 * @param orderId
	 * @return String
	 */
	OrderConfirmation deleteOrder(String orderId);
}
