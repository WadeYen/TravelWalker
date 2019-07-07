package wade;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScheduleList
 */
@SuppressWarnings("serial")
@WebServlet("/changeschedulelist")
public class ChangeScheduleList extends HttpServlet {
	
	String contentType;

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		contentType = context.getInitParameter("contentType");
	}
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		processRequest(request, response);
		
		
		
		
//		doGet(request, response);
	}
	
	protected void processRequest(HttpServletRequest request , HttpServletResponse response) 
			throws ServletException, IOException{
		String text = request.getParameter("optradio");
		String changeLoc = request.getParameter("locaName");
		String [] schedule =(String[])request.getSession().getAttribute("schedule");
		String type="";
		for (int i = 0; i < schedule.length; i++) {
			if (i==schedule.length-1 ) {
				type += ("'"+schedule[i]+"'");
			} else {
				type += ("'"+schedule[i]+"'"+",");
			}
			
		}
		
		List<Schedule> sch =new ScheduleBean().getPlaneSchedules(type);
		List<Schedule> sch1 =new ScheduleBean().getUpdateSchedules(text);
		List<SuggestSchedule> locationList = new ArrayList<>();
		
		for (int i = 0; i < sch.size(); i++) {
			locationList.add(new SuggestSchedule(sch.get(i).getLocationName(),sch.get(i).getTime()));
			if (changeLoc.equals(locationList.get(i).getLocationName())) {
				locationList.set(i,new SuggestSchedule(sch1.get(0).getLocationName(),sch1.get(0).getTime()));
			}
		}
		for (int i = 0; i < locationList.size(); i++) {
			System.out.println(locationList.get(i).getLocationName()+"Arthur");
		}
		System.out.println(locationList.size());
		System.out.println("================");
		request.setAttribute("locationList", locationList);
		request.getRequestDispatcher("Test1.jsp").forward(request, response);
		
	}

}
