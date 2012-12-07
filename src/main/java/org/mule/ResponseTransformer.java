package org.mule;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.ordermgmt.Order;

import com.sun.jersey.spi.container.ContainerResponse;

public class ResponseTransformer extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		// TODO Auto-generated method stub
		ContainerResponse cr = (ContainerResponse) message.getInvocationProperty("jersey_response");
		Order messageString = (Order) cr.getResponse().getEntity();
		message.setPayload(messageString);
		return message;
	}

}
