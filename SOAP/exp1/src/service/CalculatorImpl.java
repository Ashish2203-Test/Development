package service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name="Calculator", targetNamespace="http://calculator/")
//@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public class CalculatorImpl implements Calculator {
	
	@Override
	//@WebMethod(operationName="plus", action="http://calculator/plus")
	//@WebResult(name="plusResponse", targetNamespace="http://calculator/", partName="parameters")
	public int plus(int a, int b){ return a+b;}
	
	@Override
	//@WebMethod(operationName="minus", action="http://calculator/minus")
	//@WebResult(name="minusResponse", targetNamespace="http://calculator/", partName="parameters")
	public int minus(int a, int b){ return a-b;}
	
	@Override
	//@WebMethod(operationName="multiply", action="http://calculator/multiply")
	//@WebResult(name="multiplyResponse", targetNamespace="http://calculator/", partName="parameters")
	public int multiply(int a, int b){ return a*b;}
	
	@Override
	//@WebMethod(operationName="divide", action="http://calculator/divide")
	//@WebResult(name="divideResponse", targetNamespace="http://calculator/", partName="parameters")
	public int divide(int a, int b){ return a/b;}

}