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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String idImage = request.getParameter("Iid");
		String Uid = request.getParameter("Uid");
		String Cid = request.getParameter("Cid");
		CommentDao Udao = new CommentDao();
		String comment = request.getParameter("comment");
		HttpSession session = request.getSession();
		Accounts ac = (Accounts) session.getAttribute("acc");
		String userID = ac.getUserID();
		Udao.insertComment(comment,userID,idImage);
		response.sendRedirect("ImageDetail?Iid="+idImage+"&Uid="+Uid+"&Cid="+Cid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
