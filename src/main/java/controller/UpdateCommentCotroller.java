package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CommentDao;
import Model.Accounts;

/**
 * Servlet implementation class UpdateCommentCotroller
 */
@WebServlet("/UpdateCommentCotroller")
public class UpdateCommentCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommentCotroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String idImage = request.getParameter("Iid");
		String Uid = request.getParameter("Uid");
		String Cid = request.getParameter("Cid");
		String id_commennt = request.getParameter("id_commennt");
		CommentDao Udao = new CommentDao();
		System.out.println(id_commennt);
		String comment = request.getParameter("comment");
		System.out.println(id_commennt+"\t"+idImage+"\t"+Cid+"\t"+Uid+"\t"+comment);
		Udao.updateComment(id_commennt,comment);
		HttpSession session = request.getSession();
		Accounts ac = (Accounts) session.getAttribute("acc");
		String userID = ac.getUserID();
		response.sendRedirect("ImageDetail?Iid="+idImage+"&Uid="+Uid+"&Cid="+Cid);
	}

}
