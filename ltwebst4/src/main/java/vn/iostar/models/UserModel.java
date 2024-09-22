package vn.iostar.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 6632144043145049098L;
	private int id;
	private String email;
	private String username;
	private String fullname;
	private String password;
	private String images;
	private String phone;
	private Date createdate;
	private int roleid;

	public UserModel(int id, String email, String username, String fullname, String password, String images,
			String phone, Date createdate, int roleid) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.images = images;
		this.phone = phone;
		this.createdate = createdate;
		this.roleid = roleid;
	}

	public UserModel() {
		// TODO Auto-generated constructor stub
	}

	public UserModel(String email, String username, String fullname, String password, String images, String phone,
			Date createdate, int roleid) {
		super();
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.images = images;
		this.phone = phone;
		this.createdate = createdate;
		this.roleid = roleid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}
