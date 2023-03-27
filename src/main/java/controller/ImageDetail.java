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
import Dao.Dao;
import Dao.ImageDao;
import Dao.UserDao;
import Dao.WebDao;
import Model .Accounts;
import Model.Comments;
import Model .Images;
import Model.InfUser;

@WebServlet("/ImageDetail")
public class ImageDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ImageDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String idImage = request.getParameter("Iid");
		String Uid = request.getParameter("Uid");
		String Cid = request.getParameter("Cid");
		
		UserDao Udao = new UserDao();
		CommentDao CDao=new CommentDao();
//      Lấy thông tin hình ảnh
		ImageDao Idao= new ImageDao();
		Images I = Idao.getImageByid(idImage);
//		lấy thông tin người dăng ảnh
		Accounts A = Udao.getNameUser(Uid);
		request.setAttribute("Ac", A);
		request.setAttribute("detail", I);
//		Lấy 6 hình ảnh mới nhất của người đăng trong danh muc
		List<Images> list = Idao.getTop6ImagesByCid(Cid);
		request.setAttribute("listImg_Cid", list);
//		Lấy comment của ảnh
		List<InfUser> listCM = CDao.getCommentByidImg(idImage);
		request.setAttribute("listCM", listCM);
		request.getRequestDispatcher("imageDetail.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
