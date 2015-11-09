package mct;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

import com.mongodb.client.FindIterable;

/**
 * Servlet implementation class server
 */
@WebServlet("/server")
public class server extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public server() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println("doing get");

		String name = null;
		String comment = null;

		
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);

	}
	//
	// @Override
	// public void include(ServletRequest arg0, ServletResponse arg1) throws
	// ServletException, IOException {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void forward(ServletRequest arg0, ServletResponse arg1) throws
	// ServletException, IOException {
	// // TODO Auto-generated method stub
	//
	// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		System.out.println("doing post");
		//System.out.println(request.toString());
		String name = (String) request.getParameter("name");
		String comment = (String) request.getParameter("comment");
		FindIterable<Document> docs = null;
		Document result = null;
		if (null != name && null != comment) {
			Document commentDoc = new Document (name, comment);
			System.out.println(commentDoc.toJson());
			docs = DAO.insert(commentDoc);
			result = docs.first();
		}

		request.setAttribute("document", result.toString());
		response.setHeader("document", result.toString());
		//response.sendRedirect("/mctmongo/index.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);

		//rd.forward(request, response);

	}

}
