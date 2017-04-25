import javax.xml.ws.Endpoint;
import service.CalculatorImpl;

public class CalculatorServicePublish{

	public static void main(String[] args){
		Endpoint.publish("http://localhost:8093/WebServices/calculator", new CalculatorImpl());
	}

}