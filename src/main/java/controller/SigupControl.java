package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Model.Accounts;

@WebServlet("/SigupControl")
public class SigupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SigupControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String gmail = request.getParameter("gmail");
		String password = request.getParameter("password");
		String re_pass = request.getParameter("repeatpassword");
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		if (!password.equals(re_pass)) {
			request.setAttribute("mess", "<div class=\"alert alert-warning\" role=\"alert\">\r\n"
					+ " Xác nhận mật khẩu không khớp\r\n"
					+ "</div>");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		} else {
			UserDao dao = new UserDao();
			Accounts a = dao.checkAccountsExit(gmail);
			if (a == null) {
				// đc dn
				dao.signup(gmail, password, firstname, lastname, gender);
				Accounts ac = dao.checkLogin(gmail, password);
				HttpSession session = request.getSession();
				session.setAttribute("acc", ac);
				session.setMaxInactiveInterval(1000000);
				response.sendRedirect("HomeControl");
			} else {
				request.setAttribute("mess", "<div class=\"alert alert-warning\" role=\"alert\">\r\n"
						+ "Email đã tồn tại trong hệ thống\r\n"
						+ "</div>");;
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
		}

	}

}
