package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import vn.iostar.configs.DBConnectSQLServer;
import vn.iostar.dao.ICategoryDao;
import vn.iostar.models.CategoryModel;
import vn.iostar.models.UserModel;

public class CategoryDaoimpl implements ICategoryDao{

	public Connection conn=null;
	public PreparedStatement ps = null;
	public ResultSet rs=null;
	
	@Override
	public List<CategoryModel> findAll() {
		
		String sql="select * from categories";
		List<CategoryModel> list=new ArrayList<>();
		try {
			conn=new DBConnectSQLServer().getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setActive(rs.getBoolean("active"));
				list.add(category);			
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public CategoryModel findById(int id) {
		String sql = "SELECT * FROM categories WHERE categoryid = ? ";
		try {
			conn = new DBConnectSQLServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));	
				category.setActive(rs.getBoolean("active"));
				return category;
			}
			
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(CategoryModel category) {
		String sql = "INSERT INTO [categories](categoryname,images,active) VALUES (?,?,?)";
		try {
			conn = new DBConnectSQLServer().getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setBoolean(3, category.isActive());
			
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void update(CategoryModel category) {
		String query = "UPDATE categories SET categoryname=?, images=?, active=? where categoryid=?";
		try {
			conn = new DBConnectSQLServer().getConnection();
			ps = conn.prepareStatement(query);
			
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setBoolean(3, category.isActive());
			ps.setInt(4, category.getCategoryid());
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM categories WHERE categoryid = ? ";
		try {
			conn = new DBConnectSQLServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<CategoryModel> findByCategoryname(String keyword) {
		String sql = "SELECT * FROM categories WHERE categoryname like ? ";
		List<CategoryModel> list=new ArrayList<>();
		try {
			conn = new DBConnectSQLServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%" + keyword+"%");
			rs = ps.executeQuery();

			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setActive(rs.getBoolean("active"));
				list.add(category);
			}	
			conn.close();
			ps.close();
			rs.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
	
