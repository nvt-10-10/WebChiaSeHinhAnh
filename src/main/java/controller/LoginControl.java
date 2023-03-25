package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CommentDao;
import Dao.ImageDao;
import Dao.UserDao;
import Model.Accounts;
import Model.Images;
import Model.InfUser;

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
				session.setMaxInactiveInterval(60*60*2);
				String idImage = request.getParameter("Iid");
				String Uid = request.getParameter("Uid");
				String Cid = request.getParameter("Cid");
				if(idImage==null)
					response.sendRedirect("HomeControl");
				else {
					Login_de_BL(idImage, Uid, Cid, request, response);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void Login_de_BL(String idImage,String Uid, String Cid  ,HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		UserDao Udao = new UserDao();
		CommentDao CDao=new CommentDao();
//      Lấy thông tin hình ảnh
		ImageDao Idao= new ImageDao();
		Images I = Idao.getImageByid(idImage);
//		lấy thông tin người dăng ảnh
		Accounts A = Udao.getNameUser(Uid);
		request.setAttribute("Ac", A);
		request.setAttribute("detail", I);
//		Lấy 6 hình ảnh mới nhất của người đăng
		List<Images> list = Idao.getTop6ImagesByCid(Cid);
		request.setAttribute("listImg_Cid", list);
//		Lấy comment của ảnh
		List<InfUser> listCM = CDao.getCommentByidImg(idImage);
		request.setAttribute("listCM", listCM);
		request.getRequestDispatcher("imageDetail.jsp").forward(request, response);
	}

}
