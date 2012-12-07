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
	public String response;
	public Map<String,Order> map = new HashMap<String,Order>();
		
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ordermgmt.IProcessOrder#retrieveOrder(String orderId)
	 */
	@Override
	@GET
	@Produces("application/json")
	@Path("/order/{orderId}")
	public Order retrieveOrder(@PathParam("orderId") String orderId) {
		
		order = map.get(orderId);

		return order;
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
	public String createOrder(Order order) {

		try{
			int i = map.size()+1;
			String orderId = Integer.toString(i);
			map.put(orderId, order);
			response = orderId;
		}
		catch(Exception e){
			response = "An exception was caught while creating your order";
		}
		
		return response;
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
	public String updateOrder(@PathParam("orderId") String orderId, Order order) {
		
		try{
			map.put(orderId, order);
			response = orderId;
		}
		catch(Exception e){
			response = "An exception was caught while updating your order";
		}
		
		return response;
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
	public String deleteOrder(@PathParam("orderId") String orderId) {

		try{
			map.remove(orderId);
			response = "Order Id number: " + orderId + " has been deleted";
		}
		catch(Exception e){
			response = "An exception was caught while deleting your order";
		}
		
		return response;
	}
}