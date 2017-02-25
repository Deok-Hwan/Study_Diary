package com.saeyan.dao;

import  java.sql.Connection ;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import  javax.sql.DataSource  ;
import  javax.naming.InitialContext ; 
import  javax.naming.Context  ;
import  com.saeyan.dto.MemberVO;

/**
 * 
 * Dao : Data access object 는 데이터베이스의 데이터에 접근하기 위한 객체입니다.
 *
 */
public class MemberDao {	
	private MemberDao(){
		
	}
	
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance()
	{
		return instance;
	}
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initialContext = new InitialContext();
		Context envContext = (Context) initialContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}
	// 사용자 인증시 사용하는 메소드
	public int userCheck(String userid, String pwd){
		int result= -1;
		String sql = "select pwd from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery(); // 비밀번호의 값
			if(rs.next()) {
				if(rs.getString("pwd") != null && rs.getString("pwd").equals(pwd)){
					result = 1;
				}else{
					result = 0;
				}
			}else{
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null ) pstmt.close();
				if(conn != null ) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	// 아이디로 회원 정보 가져오는 메서드
	public MemberVO getMember(String userid){
		MemberVO mVo = null;
		String sql = "select * from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  userid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				mVo = new MemberVO();
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setPwd(rs.getString("pwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null ) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		}
		return mVo;
	}
	public int confirmID(String userid){
		int result = -1;
		String sql = "select userid from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result = 1;
			}else{
				result = -1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn!= null) conn.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		}
		return result;
	}
	public int insertMember(MemberVO mVo)
	{
		int result = -1;
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getUserid());
			pstmt.setString(3, mVo.getName());
			pstmt.setString(4, mVo.getUserid());
			pstmt.setString(5, mVo.getName());
			pstmt.setInt(6, mVo.getAdmin());
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	public int updateMember(MemberVO mVo){
		int result = -1;
		String sql = "update member set pwd=?, email=?,"
				+"phone=?, admin=? where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getPwd());
			pstmt.setString(2, mVo.getEmail());
			pstmt.setString(3, mVo.getPhone());
			pstmt.setInt(4, mVo.getAdmin());
			pstmt.setString(5, mVo.getUserid());
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
}
