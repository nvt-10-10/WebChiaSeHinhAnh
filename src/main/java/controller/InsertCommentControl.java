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
import Model.Accounts;
import Model.Comments;
import Model.Images;
import Model.InfUser;

@WebServlet("/InsertCommentControl")
public class InsertCommentControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public InsertCommentControl() {
        super();
        // TODO Auto-generated constructor stub
    }


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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
