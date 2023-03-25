package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import Model.Accounts;
import Model.Accounts_Images;
import Model.Comments;
import Model.Images;
import Model.InfUser;
import Model.Web;
import Model.adminAccount;
import Model.category;

public class Dao {
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

	// edit thông tin cá nhân
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

//load tất cả hình ảnh theo view
	public List<Images> getImagesByView() {
		List<Images> listI = new ArrayList<>();
		String query = "select * from Images order by [view] desc";
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

	// Load ra tất cả hình ảnh theo id của user
	public List<Images> getAllImagesbyIdUser(String userID) {
		List<Images> listI = new ArrayList<>();
		String query = "SELECT * FROM Images where userID = ? ORDER BY idImage DESC";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, userID);
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

	// get id category
	public category getIdcategory(String Cid) {
		String query = "Select * from cImages where idCategory = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);// ném câu lênh query sang sql
			ps.setString(1, Cid);
			rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// load ra category hình ảnh
	public List<Images> getImagesByCid(String cid) {
		List<Images> listI = new ArrayList<>();
		String query = "select * from Images where idCategory = ? and ready = 1";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cid);
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

	public List<Images> getTop6ImagesByCid(String cid) {
		List<Images> listI = new ArrayList<>();
		String query = "select Top 6 * from Images where idCategory = ? order by idImage desc";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cid);
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

	public void DeleteImages(String Iid) {
		String query = "  delete Comments where idImage in (select idImage  from Images where idImage=? )\r\n"
				+ "  delete Images where idImage= ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, Iid);
			ps.setString(2, Iid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// upload hình ảnh
	public void insertImage(String images, String tieucu, String khaudo, String tocdomantrap, String iso,
			String tenmayanh, String loaihinh, String tag, String cate_id, String Uid) {
		String query = "INSERT INTO Images (images,idCategory,userID,tag,tieuCu,"
				+ "khauDo,tocDoManTrap,iSO,camera,loaiHinhAnh,date,[view],\r\n" + "ready)\r\n"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP,0,0);";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, images);
			ps.setString(2, cate_id);
			ps.setString(3, Uid);
			ps.setString(4, tag);
			ps.setString(5, tieucu);
			ps.setString(6, khaudo);
			ps.setString(7, tocdomantrap);
			ps.setString(8, iso);
			ps.setString(9, tenmayanh);
			ps.setString(10, loaihinh);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// edit hình ảnh
	public void editImage(String tieucu, String khaudo, String tocdomantrap, String iso, String tenmayanh,
			String loaihinh, String tag, String cate_id, String idImage) {
		String query = "update Images set idCategory = ?,tieuCu = ?,khauDo = ?,\r\n"
				+ "tocDoManTrap = ?,iSO =?,camera =?,loaiHinhAnh = ?,tag = ? where idImage = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cate_id);
			ps.setString(2, tieucu);
			ps.setString(3, khaudo);
			ps.setString(4, tocdomantrap);
			ps.setString(5, iso);
			ps.setString(6, tenmayanh);
			ps.setString(7, loaihinh);
			ps.setString(8, tag);
			ps.setString(9, idImage);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// search
	public List<Images> searchByTag(String txtSearch) {
		List<Images> list = new ArrayList<>();
		try {
			String query = "Select * from Images where tag like ? and ready = 1";
			/*
			 * if (idCate != null) { query += " and idCategory = " + idCate; }
			 */
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + txtSearch + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Images(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getFloat(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}

	// Check search tag
	public Images checkSearch(String txtSearch) {
		String query = "Select * from Images where tag like ?";
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

	public List<Images> CheckImagesbyIdUser(int id) {
		List<Images> listI = new ArrayList<>();
		String query = "SELECT * FROM Images where userID = ? ";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
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

// get hinh ảnh theo id
	public Images getImageByid(String idImage) {
		String query = "select * from Images where idImage = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, idImage);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Images(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getFloat(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
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

	public Images getImageByid() {
		String query = "select * from Images where id";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Images(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getFloat(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

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
	// Xoá bình luận
	public void DeleteComment(String CMid) {
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

	// sửa bl 
	// edit thông tin cá nhân
	public void editComment(String comment, String CMid) {
		String query = "update Comments set comment = ?" + "where  idComment = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, comment);
			ps.setString(2, CMid);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

//Update view bảng Images
	public void upDateView(String idImage) {
		String query = "UPDATE Images SET [view] = [view] + 1 where idImage =  ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, idImage);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

// get hình ảnh theo camera
	public List<Images> getImageByCamera(String txtcamera) {
		List<Images> listI = new ArrayList<>();
		String query = "select * from Images where camera like ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + txtcamera + "%");
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

	// get name camera
	public Images getNameCamera(String txtcamera) {

		String query = "select * from Images where camera like ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, txtcamera);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Images(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getFloat(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	// ADMIN

	// admin login
	public adminAccount adminLogin(String user, String pass) {
		String query = "select * from adminAccount where adUsername = ? and adPassword = ?";
		try {

			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				adminAccount a = new adminAccount(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				return a;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// admin Check search tag
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

	// admin search
	public List<Accounts> searchByName(String txtSearch) {
		List<Accounts> list = new ArrayList<>();
		String query = "Select * from Accounts where firstName like ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + txtSearch + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Accounts(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}

	// Load ra page 5 hình ảnh
	public List<Images> get5RsowImagesbyIdUser(String userID, int index) {
		List<Images> listI = new ArrayList<>();
		String query = "SELECT * FROM Images where userID = ? "
				+ "ORDER BY idImage offset ? rows fetch next 5 rows only";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, userID);
			ps.setInt(2, (index - 1) * 5);
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

	// lấy thông tin user
	public List<Accounts> get10RowAccountsUser(int index) {
		List<Accounts> listI = new ArrayList<>();
		String query = "select * from Accounts\r\n" + "order by userID\r\n" + "offset ? rows fetch next 10 rows only";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index - 1) * 10);
			rs = ps.executeQuery();
			while (rs.next()) {
				listI.add(new Accounts(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listI;

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

	// đếm account trong dtb
	public int getTotalAccount() {
		String query = "select count(*) from Accounts ";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	// đếm số hình của user
	public int getTotalImageByUser(String userID) {
		String query = "select count(*) from Images where userID = ? ";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, userID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	// đếmm số hình search của user

	// đếm số hình của user
	public int getTotalImageSearchByUser(String txtsearch, String userID) {
		String query = "Select count(*) from Images where tag like ? or userID = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, txtsearch);
			ps.setString(2, userID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	// đếm Đếm tất cả hình trong dtb
	public int getTotalImages() {
		String query = "select count(*) from Images";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	// Load ra 5 row hình ảnh trong database
	public List<Images> get5RsowImages(int index) {
		List<Images> listI = new ArrayList<>();
		String query = "select * from Images order by idImage offset ? rows fetch next 5 rows only";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index - 1) * 5);
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

	// lấy tất cả thông tin hình ảnh để admin duyệt
	public List<Accounts_Images> getAllImages_Account() {
		List<Accounts_Images> listI = new ArrayList<>();
		String query = "select * from Accounts join Images \r\n"
				+ "on Accounts.userID = Images.userID order by idImage desc";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listI.add(new Accounts_Images(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getFloat(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
						rs.getString(20), rs.getString(21), rs.getInt(22), rs.getInt(23)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listI;

	}

	// admin duyêt hình ảnh
	public void duyetImages(String Iid) {
		String query = "UPDATE Images\r\n" + "SET ready = 1 where idImage = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, Iid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// Check search tag
	public Images checkSearchByidUser(String txtSearch) {
		String query = "Select * from Images where tag like ?";
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

// tìm kiếm theo tag theo user id
	public List<Images> searchTagByUserID(String txtSearch, String userID, int index) {
		List<Images> list = new ArrayList<>();
		String query = "Select * from Images where tag like ? or userID = ? \r\n"
				+ "ORDER BY idImage offset ? rows fetch next 6 rows only";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + txtSearch + "%");
			ps.setString(2, userID);
			ps.setInt(3, (index - 1) * 6);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Images(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getFloat(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}

//lấy thông tin banner
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

//sửa giao diện web
	public void editWeb(String banner, String title1, String title2, String facebook, String instagram,
			String pinterest) {
		String query = "update web \r\n" + "set banner = ?,\r\n" + "title1 = ?,\r\n" + "title2 = ?,\r\n"
				+ "facebook = ?,\r\n" + "instagram = ?,\r\n" + "pinterest = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, banner);
			ps.setString(2, title1);
			ps.setString(3, title2);
			ps.setString(4, facebook);
			ps.setString(5, instagram);
			ps.setString(6, pinterest);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

//lấy tất cả danh sách tài khoảng admin member
	public List<adminAccount> getAllAccountMember() {
		List<adminAccount> list = new ArrayList<>();
		String query = "select * from adminAccount where member = 1 order by adminId desc";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new adminAccount(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

//insert tài khoảng admin member vào database
	public void insertAdminMember(String name, String username, String password) {
		String query = "insert into adminAccount values(?,?,1,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

//kiểm tra tài khoản adminMember đã tồn tại hay chưa
	public adminAccount checkAccountsMemBerExit(String username) {
		String query = "select * from adminAccount where adUsername = ? ";
		try {

			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);// ném câu lênh query sang sql
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				adminAccount a = new adminAccount(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				return a;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

//admin xoá tài khoản memeber 
	public void deleteAccountMember(String idMember) {
		String query = "delete from adminAccount where adminId = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, idMember);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

//get thông tin từng member
	public adminAccount getInfMember(String idAdmin) {
		String query = "select * from adminAccount where adminId = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, idAdmin);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new adminAccount(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

//sửa mật khẩu adminMember
	public void editPassMember(String editPassword, String adminId) {
		String query = "update adminAccount\r\n" + "set adPassword = ? \r\n" + "where adminId = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, editPassword);
			ps.setString(2, adminId);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
//		// search + lọc
//		public List<Images> searchByfilter(String txtSearch,String filter) {
//			List<Images> list = new ArrayList<>();
//			String query = "Select * from Images where ? like ? order by [view] desc";
//			try {
//				conn = new DBContext().getConnection();
//				ps = conn.prepareStatement(query);
//				ps.setString(1,filter);
//				ps.setString(2, "%" + txtSearch + "%");
//				rs = ps.executeQuery();
//				while (rs.next()) {
//					list.add(new Images(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
//							rs.getFloat(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
//							rs.getString(11), rs.getString(12), rs.getInt(13)));
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			return list;
//
//		}

//test
//	public static void main(String[] args) {
//		Dao dao = new Dao();
//		List<Images> list = dao.searchByTag("Việt nam", null);
//		for (Images o : list) {
//			System.out.println(o);
//
//		}
//	}

	public List<Comments> getDatabaseComments() {
		List<Comments> listI = new ArrayList<>();
		String query = "SELECT * from Comments";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listI.add(new Comments(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listI;

	}

	public List<category> getDatabaseCategory() {
		List<category> listI = new ArrayList<>();
		String query = "SELECT * from cImages";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listI.add(new category(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listI;

	}
}
