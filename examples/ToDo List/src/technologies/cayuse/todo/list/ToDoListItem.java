package technologies.cayuse.todo.list;

import java.util.Calendar;

public class ToDoListItem 
{
	int index;
	String text;
	String date;
	String latitude;
	String longitude;
	
	public ToDoListItem(int index, String text, String date, String latitude,
			String longitude) {
		super();
		this.index = index;
		this.text = text;
		this.date = date;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public ToDoListItem(String text)
	{
		super();
		this.text = text;
		index = -1;
		Calendar timeG = Calendar.getInstance();
		date = Integer.toString(timeG.get(Calendar.MONTH) + 1)  + "/" + timeG.get(Calendar.DAY_OF_MONTH) + "/" 
		+ timeG.get(Calendar.YEAR);
		latitude = "0";
		longitude = "0";
	}

	@Override
	public String toString() {
		return "ToDoListItem [text=" + text + ", date=" + date + "]";
	}

	public ToDoListItem(String text, String latitude, String longitude)
	{
		super();
		index = -1;
		this.text = text;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
