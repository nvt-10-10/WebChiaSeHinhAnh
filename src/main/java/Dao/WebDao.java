package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Web;
import context.DBContext;

public class WebDao {
	//lấy thông tin banner
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
		public Web getInfBanner() {
			String query = "select * from web";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
					return new Web(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7));
				}
			} catch (Exception e) {
			}
			return null;
		}
}
