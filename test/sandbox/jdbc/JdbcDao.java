package sandbox.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sample.domain.Member;

public class JdbcDao {
	private Connection getConn(){
		//get DB connection
		try{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		}catch(ClassNotFoundException cnfe){
			throw new RuntimeException(cnfe);
		}
		try {
			return DriverManager.getConnection("jdbc:hsqldb:memberdb", "SA", "");			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	private void closeConn(ResultSet rs, PreparedStatement ps, Connection conn){
		//close DB connection
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
		}
	}
	private void closeConn(PreparedStatement ps, Connection conn){
		//close DB connection
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
		}
	}
	
	public void add(Member member){
		Connection conn = null;
		PreparedStatement ps = null;

		try{
			conn = getConn();
			
			ps = conn.prepareStatement("insert into member(id, name, joined) values(?, ?, ?)");
			ps.setInt(1, member.getId());
			ps.setString(2, member.getName());
			ps.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}catch(RuntimeException e){
			throw e;
		}finally{
			try {
				closeConn(ps, conn);
			} catch (RuntimeException e) {
				// TODO: handle exception
				throw e;
			}
		}
	}
	
	public Member get(int id){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConn();
			
			ps = conn.prepareStatement("select * from member where id=?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			Member member = null;
			while(rs.next()){
				member = new Member();
				member.setId(id);
				member.setName(rs.getString("name"));
			}
			return member;
		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			try {
				closeConn(rs, ps, conn);
			} catch (RuntimeException e) {
				// TODO: handle exception
				throw e;
			}
		}
	}
}
