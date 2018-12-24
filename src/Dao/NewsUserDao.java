package Dao;

import java.sql.SQLException;

import entity.Newsusers;

public class NewsUserDao extends BaseDao {

	public Newsusers findByName(String name) {
		Newsusers user = null;
		String sql = "SELECT * FROM `newsusers` WHERE uname = ? ";
		try {
			rs = super.selectDate(sql, name);
			while (rs.next()) {
				int uid = rs.getInt("uid");
				String uname = rs.getString("uname");
				String upwd = rs.getString("upwd");
				user = new Newsusers(uid, uname, upwd);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, prap, conn);
		}
		return user;
	}
}
