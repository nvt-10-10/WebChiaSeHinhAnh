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

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {

			String user = request.getParameter("email");
			String pass = request.getParameter("password");
			UserDao  dao = new UserDao();
			Accounts a = dao.checkLogin(user, pass);
			if (a == null) {
				request.setAttribute("mess", "<div class=\"alert alert-warning\" role=\"alert\">\r\n"
						+ "Sai tên đăng nhập hoặc mật khẩu\r\n" + "</div>");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("acc", a);
				session.setMaxInactiveInterval(1000000);
				response.sendRedirect("HomeControl");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
