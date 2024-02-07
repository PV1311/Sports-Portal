package sportsportal.beans;


public class EventBean 
{
	private int id;
	private String eventName , venue , description , organizer ;
	private String date;
	
	
	public EventBean() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
		
	
	public EventBean(String eventName, String venue, String description, String organizer, String date) 
	{
		super();
		this.eventName = eventName;
		this.venue = venue;
		this.description = description;
		this.organizer = organizer;
		this.date = date;
	}
	

	public int getId() 
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getEventName()
	{
		return eventName;
	}
	public void setEventName(String eventName)
	{
		this.eventName = eventName;
	}
	public String getVenue() 
	{
		return venue;
	}
	public void setVenue(String venue)
	{
		this.venue = venue;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public String getDate() 
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	
}
