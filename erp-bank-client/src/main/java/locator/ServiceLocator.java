package locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ServiceLocator {
	private Map<String, Object> cache;
	private Context ctx;
	private static ServiceLocator serviceLocator;
	
	private ServiceLocator()
	{
		try {
			ctx= new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cache= new HashMap<String, Object>();
	}
	public static ServiceLocator getInstance()
	{
		if(serviceLocator==null)
		{
			serviceLocator=new ServiceLocator();
		}
		return serviceLocator;
	}
	public Object getRemoteProxy(String jndiName)
	{
		Object obj=null;
		obj=cache.get(jndiName);
		if(obj==null)
		{
			try {
				obj=ctx.lookup(jndiName);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cache.put(jndiName, obj);
		}
		return obj;
	}

}
