package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ImageDao;
import Dao.UserDao;
import Dao.WebDao;
import Dao.categoryDao;
import Model .Accounts;
import Model .Images;
import Model.Web;
import Model .category;
@WebServlet("/HomeControl")
public class HomeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HomeControl() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ImageDao imageDao = new ImageDao();
		List<Images> listI = imageDao.getImages();
		request.setAttribute("listI", listI);
		categoryDao categoryDao = new categoryDao();
		List<category> listC = categoryDao.getAllCategory();
		request.setAttribute("listC", listC);
		HttpSession session = request.getSession();
		Accounts a = (Accounts) session.getAttribute("acc");
		if(a!=null)
			request.setAttribute("user", a);
		WebDao webDao = new WebDao();
		Web web = webDao.getInfBanner();
		request.setAttribute("web", web);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	
		// TODO Auto-generated method stubs
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	 
}
