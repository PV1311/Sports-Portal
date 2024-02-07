package sportsportal.beans;

public class Plan_Bean 
{
	private String name , services ;
	private int charges;
	
			
	public Plan_Bean() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Plan_Bean(String name, String services, int charges) 
	{
		super();
		this.name = name;
		this.services = services;
		this.charges = charges;
	}
	
	
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getServices() 
	{
		return services;
	}
	public void setServices(String services) 
	{
		this.services = services;
	}
	public int getCharges()
	{
		return charges;
	}
	public void setCharges(int charges) 
	{
		this.charges = charges;
	}
	
	
}
