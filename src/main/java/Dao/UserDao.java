package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Accounts;
import context.DBContext;

public class UserDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

//user login
	public Accounts checkLogin(String gmail, String password) {
	
		String query = "select * from Accounts where gmail = ? and password = ?";
		try {

			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, gmail);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				Accounts a = new Accounts(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				return a;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	

	//kiểm tra tài khoản user đã tồn tại hay chưa 
		public Accounts checkAccountsExit(String gmail) {
			String query = "select * from Accounts where gmail = ?";
			try {

				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);// ném câu lênh query sang sql
				ps.setString(1, gmail);
				rs = ps.executeQuery();
				while (rs.next()) {
					Accounts a = new Accounts(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
					return a;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}

	// đăng ký
		public void signup(String gmail, String password, String lastname, String firstname, String gender) {
			String query = "INSERT INTO Accounts(gmail,[password],uImages,firstName,lastName,gender)VALUES"
					+ " (?,?,'blank-profile-picture-973460_1280.png',?,?,?)";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, gmail);
				ps.setString(2, password);
				ps.setString(3, firstname);
				ps.setString(4, lastname);
				ps.setString(5, gender);
				ps.executeUpdate();
			} catch (Exception e) {
			}
		}
		
		public void editInfUser(String email, String pass, String uImages, String firstName, String lastName,
				String facebook, String sodienthoai, String userID, String gender) {
			String query = "update Accounts\r\n" + "				set gmail = ?,\r\n" + "				[password] = ?,\r\n"
					+ "				uImages =?,\r\n" + "				faceBook = ?,\r\n"
					+ "				soDienThoai = ?,\r\n" + "				firstName = ?,\r\n"
					+ "				lastName = ?,\r\n" + "				gender = ?\r\n" + "				where userID =?";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, email);
				ps.setString(2, pass);
				ps.setString(3, uImages);
				ps.setString(4, facebook);
				ps.setString(5, sodienthoai);
				ps.setString(6, firstName);
				ps.setString(7, lastName);
				ps.setString(8, gender);
				ps.setString(9, userID);
				ps.executeUpdate();
			} catch (Exception e) {
			}
		}
		public Accounts getNameUser(String userID) {
			String query = "select * from Accounts where userID = ?";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, userID);
				rs = ps.executeQuery();
				while (rs.next()) {
					return new Accounts(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		public Accounts adminCheckSearch(String txtSearch) {
			String query = "Select * from Accounts where firstName like ?";
			try {

				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, "%" + txtSearch + "%");
				rs = ps.executeQuery();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		// lấy thông tin user
		public Accounts AccountsUser(String userID) {
			String query = "SELECT * from Accounts where userID = ?";
			try {
				conn = new DBContext().getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, userID);
				rs = ps.executeQuery();
				while (rs.next()) {
					return new Accounts(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;

		}

}
