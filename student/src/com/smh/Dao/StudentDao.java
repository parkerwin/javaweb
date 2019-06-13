package com.smh.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smh.Model.Student;
import com.smh.Util.DBUtil;

public class StudentDao {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public List<Student> getAllStudent(){
		List<Student> list = new ArrayList<Student>();
		try {
			conn = DBUtil.getConnection();
			String sql = "select *from Student";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next())
			{
				/*
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String gender = rs.getString(4);
				String address = rs.getString(5);
				String education = rs.getString(6);
				String major = rs.getString(7);
				*/
				int id = rs.getInt("id");
				String name = rs.getString("s_name");
				int age = rs.getInt("s_age");
				String gender = rs.getString("s_gender");
				String address = rs.getString("s_address");
				String education = rs.getString("s_education");
				String major = rs.getString("s_major");
				list.add(new Student(id, name, age, gender, address, education, major));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pst, conn);
		}
		return list;
	}
	
	public int deleteStudent(int id){
		String sql = "delete from student where id=?";
		int i = 0;
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			i = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pst, conn);
		}
		return i;
		
	}
	
	public Student selectStudent(int studentId){
		Student student = new Student();
		String sql = "select *from student where id=?";
		try {
			conn = DBUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, studentId);
			rs = pst.executeQuery();
			while(rs.next()){
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setGender(rs.getString(4));
				student.setAddress(rs.getString(5));
				student.setEducation(rs.getString(6));
				student.setMajor(rs.getString(7));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return student;
	}
	
	public int updateStudent(Student student){
		String sql = "update student set s_name=?,s_age=?,s_gender=?,s_address=?,s_education=?,s_major=? where id=?";
		int i = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, student.getName());
			pst.setInt(2, student.getAge());
			pst.setString(3, student.getGender());
			pst.setString(4, student.getAddress());
			pst.setString(5, student.getEducation());
			pst.setString(6, student.getMajor());
			pst.setInt(7, student.getId());
			i = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pst, conn);
		}
		return i;
	}

	public int addStudent(Student student) {
		String sql = "insert student (s_name,s_age,s_gender,s_address,s_education,s_major) values(?,?,?,?,?,?)";
		int i = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, student.getName());
			pst.setInt(2, student.getAge());
			pst.setString(3, student.getGender());
			pst.setString(4, student.getAddress());
			pst.setString(5, student.getEducation());
			pst.setString(6, student.getMajor());
			i = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pst, conn);
		}
		return i;
	}
}
