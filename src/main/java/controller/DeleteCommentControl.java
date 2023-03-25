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
import Model.Accounts;
import Model.Images;
import Model.InfUser;

/**
 * Servlet implementation class DeleteCommentControl
 */
@WebServlet("/DeleteCommentControl")
public class DeleteCommentControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String idImage = request.getParameter("Iid");
		String Uid = request.getParameter("Uid");
		String Cid = request.getParameter("CMid");
		CommentDao dao = new CommentDao();
//		dao.upDateView(idImage);
		
	
		ImageDao Idao= new ImageDao();
		Images I = Idao.getImageByid(idImage);
		dao.DeleteComment(Cid);
		request.setAttribute("detail", I);
		List<Images> list = Idao.getTop6ImagesByCid(Cid);
		request.setAttribute("listImg_Cid", list);
		List<InfUser> listCM = dao.getCommentByidImg(idImage);
		request.setAttribute("listCM", listCM);
		request.getRequestDispatcher("imageDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
