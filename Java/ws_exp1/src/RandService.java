package rand;

import javax.jws.WebService;
import javax.jws.WebMethod;


@WebService
public interface RandService{
	@WebMethod
	public int next1();
	@WebMethod
	public int[] nextN(final int n);
}
