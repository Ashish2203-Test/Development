package com.aziz.ws;

import javax.jws.WebService;

@WebService(endpointInterface="com.aziz.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getHelloWorldAsString(String name){
		return "Hello World JAX-WS "+name;
	}

}