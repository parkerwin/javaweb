package com.smh.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.smh.Model.User;
import com.smh.Util.DBUtil;
import com.sun.org.apache.commons.collections.BagUtils;

public class UserDao {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public boolean login(String username,String pwd){
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select *from user where username=? and password=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, pwd);
			rs = pst.executeQuery();
			while(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pst, conn);
		}
		return false;
	}
}
