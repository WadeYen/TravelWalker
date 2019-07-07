package wade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateLocation
 */
@SuppressWarnings("serial")
@WebServlet("/UpdateLocation")
public class UpdateLocation extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addLocation(request, response);
	}
	
	protected void addLocation(HttpServletRequest request , HttpServletResponse response) 
			throws ServletException, IOException{
		List<SuggestSchedule> locationList=(List<SuggestSchedule>)request.getAttribute("locationList");
		String isNotText="";
		for (int i = 0; i < locationList.size(); i++) {
			if (i==locationList.size()-1) {
				isNotText += ("'"+locationList.get(i).getLocationName()+"'"+",");
			} else {
				isNotText += ("'"+locationList.get(i).getLocationName()+"'");
			}
		}
		
		List<Schedule> add =new ScheduleBean().getUpdateSchedules(isNotText);
		List<SuggestSchedule> newsch = new ArrayList<>();
		for (int i = 0; i < add.size(); i++) {
			newsch.add(new SuggestSchedule(add.get(i).getLocationName(),add.get(i).getTime()));
		}
		
		request.setAttribute("newsch", newsch);
		response.sendRedirect("Test1.jsp");
//		request.getRequestDispatcher("Test1.jsp").forward(request, response);
	}
}
