package co.mhlib.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.mhlib.dto.DTO;

public abstract class DAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "mh1";
	private String upw = "mh1";
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	public DAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public abstract DTO selectOne(DTO dto);
	public abstract int insert(DTO dto);
	public abstract int update(DTO dto);
	public abstract int delete(DTO dto);
	
//DB종료문
	public void close() {
		try {
			if(rs != null) {
			rs.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
