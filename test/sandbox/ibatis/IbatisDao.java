package sandbox.ibatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import sample.domain.Member;

public class IbatisDao {
	public void add(Member member){
		SqlMapClient client = null;
		
		try{
			Reader reader = Resources.getResourceAsReader("/sandbox/ibatis/SqlMapConfig.xml");
			client = SqlMapClientBuilder.buildSqlMapClient(reader);
			client.insert("add", member);
		}catch(IOException e){
			throw new RuntimeException(e);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	public Member get(int id){
		SqlMapClient client = null;
		
		try {
			Reader reader = Resources.getResourceAsReader("/sandbox/ibatis/SqlMapConfig.xml");
			client = SqlMapClientBuilder.buildSqlMapClient(reader);
			Member member = (Member) client.queryForObject("get");
			return member;
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
