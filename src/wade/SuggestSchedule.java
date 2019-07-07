package wade;

public class SuggestSchedule {
	private int day;
	private String locationName;
	private int time;
	
	
	
	public SuggestSchedule(String locationName, int time) {
		super();
		this.locationName = locationName;
		this.time = time;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	public String getLocationName() {
		return locationName;
	}
	
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	
}
