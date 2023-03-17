package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Images;
import context.DBContext;

public class ImageDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// Load ra tất cả hình ảnh
	public List<Images> getImages() {
		List<Images> listI = new ArrayList<>();
		String query = "SELECT * from Images ORDER BY idImage desc;";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				listI.add(new Images(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getFloat(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listI;

	}
	
}
