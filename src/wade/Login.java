package wade;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet(
		urlPatterns = {"/login"},
		initParams = {
				@WebInitParam(name = "SUCCESS_PATH", value = "Index.html"),
				@WebInitParam(name = "ERROR_PATH", value = "error.html")
		}
)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String SUCCESS_PATH = "Index.html";
	private final String ERROR_PATH = "error.html";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
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
		response.setContentType("text/html;charset=UTF-8");
		String userName = request.getParameter("username");
		String password = request.getParameter("pwd");
		
		String result = "";
		if (userName.equals("test") && password.equals("123")) {
			if (request.getSession(false) != null) {
				request.changeSessionId();
			}
			request.getSession().setAttribute("login", userName);;
			result = SUCCESS_PATH;
		} else {
			result = ERROR_PATH;
		}
		response.sendRedirect(result);
		

	}

}
