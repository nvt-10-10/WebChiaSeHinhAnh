package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.category;
import context.DBContext;

public class categoryDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// Load ra tất cả danh mục
	public List<category> getAllCategory() {
		List<category> listC = new ArrayList<>();
		String query = "select * from cImages";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				listC.add(new category(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listC;
	}
}
