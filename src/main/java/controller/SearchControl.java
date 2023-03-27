package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Dao;
import Model.Images;
import Model.category;

@WebServlet("/SearchControl")
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String txtSearch = request.getParameter("search");
//		String idCate = request.getParameter("idCate");
		Dao dao = new Dao();
//		Images check = dao.checkSearch(txtSearch);
		List<category> listC = dao.getAllCategory();
		request.setAttribute("listC", listC);
		List<Images> list = dao.searchByTag(txtSearch);
		request.setAttribute("listI", list);
		request.setAttribute("txtSearch", txtSearch);
		if (list == null) {
			request.setAttribute("alert", " <div class=\"alert alert-primary text-center\" role=\"alert\">\r\n"
					+ "		Không có kết quả nào được tìm thấy!\r\n"
					+ "	  </div>");
		}
		request.getRequestDispatcher("Search.jsp").forward(request, response);
	}
}
