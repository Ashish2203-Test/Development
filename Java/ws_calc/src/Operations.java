package calculator;

import javax.jws.WebService;
import javax.jws.WebMethod;


@WebService
public interface Operations{

	@WebMethod
	public int add(int a, int b);

	@WebMethod
	public int subtract(int a, int b);

	@WebMethod
	public int multiply(int a, int b);

	@WebMethod 
	public int divide(int a,  int b) throws ArithmeticException;

}