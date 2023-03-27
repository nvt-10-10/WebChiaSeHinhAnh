package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.InfUser;
import context.DBContext;

public class CommentDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// lấy bình luận về
	public void insertComment(String comment, String userID, String idImage) {
		String query = "insert into Comments values (?,?,?,CURRENT_TIMESTAMP)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, comment);
			ps.setString(2, userID);
			ps.setString(3, idImage);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	// Xoá bình luận
	public void DeleteComment(String  CMid) {
		String query = "delete from Comments where idComment = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, CMid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// get comment của hình ảnh từ dtb
	public List<InfUser> getCommentByidImg(String idImage) {
		List<InfUser> list = new ArrayList<>();
		String query = "select * from Accounts join Comments on Accounts.userID = Comments.userID "
				+ "where idImage = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, idImage);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new InfUser(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}
	
	public void updateComment(String id,String comment) {
		String query = "update  Comments set [comment]= ?  ,[commentDay]= CURRENT_TIMESTAMP "+  " where [idComment] = ?" ;
	
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, comment);
			ps.setString(2, id);
			System.out.println(query);
			ps.executeUpdate();
		
		} catch (Exception e) {
		}
	}
}
