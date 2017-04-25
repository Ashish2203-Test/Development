package calculator;

import javax.jws.WebService;

@WebService(endpointInterface="calculator.Operations")
public class CalculatorImpl implements Operations{

	@Override
	public int add(int a,  int b){
		return a+b;
	}

	@Override
	public int subtract(int a,  int b){
		return a-b;
	}

	@Override
	public int multiply(int a, int b){
		return a*b;
	}

	@Override
	public int divide(int a,  int b){
		return a/b;
	}

}