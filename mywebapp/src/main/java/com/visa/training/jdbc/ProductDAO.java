package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO class has CRUD + Query methods
public class ProductDAO {
	public int save(Product toBeSaved) // Product toBeSaved
	{
		int generatedId = 0;
		// insert
		try (Connection con = JdbcUtil.getConnection()) {
			// String sql = "Insert into product
			// values("+toBeSaved.getId()+",'"+toBeSaved.getName()+
			// "',"+toBeSaved.getPrice()+","+toBeSaved.getQoh()+")";
			String psql = "insert into product(product_name,product_price,product_qoh) values(?,?,?)";

			// Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(psql, Statement.RETURN_GENERATED_KEYS);
			// s.setInt(1,toBeSaved.getId());
			st.setString(1, toBeSaved.getName());
			st.setFloat(2, toBeSaved.getPrice());
			st.setInt(3, toBeSaved.getQoh());
			st.executeUpdate();
			ResultSet keys = st.getGeneratedKeys();
			keys.next();
			generatedId = keys.getInt(1);
			// int m = st.executeUpdate(psql);
			// if (m == 1)
			// System.out.println("Inserted successfully : " + psql);
			// else
			// System.out.println("Insertion failed");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return generatedId;
	}

	public Product findById(int id) {
		// read based on id
		Product p = null;
		try (Connection c = JdbcUtil.getConnection()) {
			PreparedStatement s = c.prepareStatement("select * from product where product_id=?");
			s.setInt(1, id);
			ResultSet rs = s.executeQuery(); // 0 or 1 row as primary key is compared here
			if (rs.next()) {// rs.next() : moves cursor to first row
				p = mapRow(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	private Product mapRow(ResultSet rs) throws SQLException {
		Product p;
		p = new Product();
		p.setId(rs.getInt(1));
		p.setName(rs.getString(2));
		p.setPrice(rs.getFloat(3));
		p.setQoh(rs.getInt(4));
		return p;
	}

	public List<Product> findAll() {
		// read all
		List<Product> all = new ArrayList<>();
		try (Connection c = JdbcUtil.getConnection()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from product");
			while (rs.next()) {
				Product p=mapRow(rs);
				all.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;
	}

	public void remove(int id) {
		// delete
		Product p = null;
		try (Connection c = JdbcUtil.getConnection()) {
			PreparedStatement s = c.prepareStatement("delete from product where product_id=?");
			s.setInt(1, id);
			int m = s.executeUpdate(); // 0 or 1 row as primary key is compared here
			if(m==1) {
				System.out.println("One item deleted");
			}
			else
				System.out.println("Error occured");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Product updated) {
		// update
		try(Connection c = JdbcUtil.getConnection()){
			PreparedStatement s = c.prepareStatement("update * from product	where product_id = ?");
			s.setInt(1, updated.getId());
			ResultSet rs = s.executeQuery();
			mapRow(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}