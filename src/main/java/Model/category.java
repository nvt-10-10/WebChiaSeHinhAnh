package Model;

public class category {
	private int idCategory;
	private String cname;
	public category() {
		// TODO Auto-generated constructor stub
	}
	
	public category(int idCategory, String cname) {
		super();
		this.idCategory = idCategory;
		this.cname = cname;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return idCategory + " " + cname ;
	}
}
