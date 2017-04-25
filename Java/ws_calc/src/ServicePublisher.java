package calculator;

import javax.xml.ws.Endpoint;

public class ServicePublisher{

	public static void main(String[] args){

		final String url="http://localhost:8890/rs";
		System.out.println("publishing the service");
		Endpoint.publish(url, new CalculatorImpl());

	}
}