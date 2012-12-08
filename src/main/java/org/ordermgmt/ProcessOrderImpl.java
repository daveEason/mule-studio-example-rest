package org.ordermgmt;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * REST Web service implementation.
 * 
 * @author david.eason@mulesoft.com
 */

@Path("/ordermgmt")
public class ProcessOrderImpl implements IProcessOrder {

	public Order order;
	public OrderConfirmation orderConfirmation = new OrderConfirmation();
	public String response;
	public static Map<String,Order> map = new HashMap<String,Order>();
		
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ordermgmt.IProcessOrder#retrieveOrder(String orderId)
	 */
	@Override
	@GET
	@Produces("application/json")
	@Path("/order/{orderId}")
	public OrderConfirmation retrieveOrder(@PathParam("orderId") String orderId) {
		
		try{
			
			orderConfirmation.setOrder(ProcessOrderImpl.map.get(orderId));
			orderConfirmation.setOrderId(orderId);
			orderConfirmation.setStatus("Success");
		
		}catch(Exception e){
			
			orderConfirmation.setStatus("Failed - An exception was encountered while retrieving your order");
		}
		
		return orderConfirmation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ordermgmt.IProcessOrder#createOrder()
	 */

	@Override
	@PUT
	@Produces("application/json")
	@Path("/order")
	public OrderConfirmation createOrder(Order order) {

		try{
			int i = ProcessOrderImpl.map.size()+1;
			String orderId = Integer.toString(i);
			ProcessOrderImpl.map.put(orderId, order);
			orderConfirmation.setOrder(ProcessOrderImpl.map.get(orderId));
			orderConfirmation.setOrderId(orderId);
			orderConfirmation.setStatus("Success");
		}
		catch(Exception e){
			orderConfirmation.setStatus("An exception was caught while creating your order");
		}
		
		return orderConfirmation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ordermgmt.IProcessOrder#updateOrder(org.ordermgmt.Order)
	 */

	@Override
	@POST
	@Produces("application/json")
	@Path("/order/{orderId}")
	public OrderConfirmation updateOrder(@PathParam("orderId") String orderId, Order order) {
		
		try{
			ProcessOrderImpl.map.put(orderId, order);
			orderConfirmation.setOrder(ProcessOrderImpl.map.get(orderId));			
			orderConfirmation.setOrderId(orderId);
			orderConfirmation.setStatus("Success");
		}
		catch(Exception e){
			orderConfirmation.setStatus("An exception was caught while updating your order");
		}
		
		return orderConfirmation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ordermgmt.IProcessOrder#deleteOrder(String OrderId)
	 */

	@Override
	@DELETE
	@Produces("application/json")
	@Path("/order/{orderId}")
	public OrderConfirmation deleteOrder(@PathParam("orderId") String orderId) {

		try{
			ProcessOrderImpl.map.remove(orderId);
			orderConfirmation.setOrder(ProcessOrderImpl.map.get(orderId));			
			orderConfirmation.setOrderId(orderId);
			orderConfirmation.setStatus("Success");
		}
		catch(Exception e){
			orderConfirmation.setStatus("An exception was caught while updating your order");
		}
		
		return orderConfirmation;
	}
}