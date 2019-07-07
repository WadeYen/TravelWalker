package wade;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class ScheduleBean implements Serializable{
	private String jdbcUri = "jdbc:mysql://localhost/travellocations";
	private String name = "root";
	private String password = "123456";
	public ScheduleBean() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public List<Schedule> getSchedules(){
		try (Connection conn = DriverManager.getConnection(
				jdbcUri, name, password);
			Statement statement = conn.createStatement()){
			
			ResultSet result = statement.executeQuery(
					"SELECT * FROM travellocations.scene");
			List<Schedule> schedules = new ArrayList<>();
			while (result.next()) {
				Schedule schedule = new Schedule();
				schedule.setLocationName(result.getString(1));
				schedule.setCountry(result.getString(2));
				schedule.setCity(result.getString(3));
				schedule.setType(result.getString(4));
				schedule.setTime(result.getInt(5));
				schedules.add(schedule);
//				System.out.println(result.getString(1)+"HHHH");
				
			}
			return schedules;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Schedule> getPlaneSchedules(String t){
		try (Connection conn = DriverManager.getConnection(
				jdbcUri, name, password);
			Statement statement = conn.createStatement()){
			
			ResultSet result = statement.executeQuery(
					"SELECT LocationName, Country, City, Type, Time FROM travellocations.scene WHERE Type IN ("+ t+")");
			List<Schedule> schedules = new ArrayList<>();
			while (result.next()) {
				Schedule schedule = new Schedule();
				schedule.setLocationName(result.getString(1));
				schedule.setCountry(result.getString(2));
				schedule.setCity(result.getString(3));
				schedule.setType(result.getString(4));
				schedule.setTime(result.getInt(5));
				schedules.add(schedule);
			}
			return schedules;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Schedule> getUpdateSchedules(String condition){
		try (Connection conn = DriverManager.getConnection(
				jdbcUri, name, password);
			Statement statement = conn.createStatement()){
			
			ResultSet result = statement.executeQuery(
					"SELECT * FROM travellocations.scene WHERE LocationName = '"+condition+"'");
			List<Schedule> schedules = new ArrayList<>();
			while (result.next()) {
				Schedule schedule = new Schedule();
				schedule.setLocationName(result.getString(1));
				schedule.setCountry(result.getString(2));
				schedule.setCity(result.getString(3));
				schedule.setType(result.getString(4));
				schedule.setTime(result.getInt(5));
				schedules.add(schedule);
				
			}
			return schedules;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
