package item_lv_up.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import item_lv_up.model.DeveloperVO;

public class ItemLvUpDao {
	private static ItemLvUpDao instance = new ItemLvUpDao();
	
	private ItemLvUpDao() {};
	
	public static ItemLvUpDao getInstance() {
		if(instance == null) {
			instance = new ItemLvUpDao();
		}
		return instance;
	}
	
	// 회원가입
		public int registDev(Connection conn, String id
				, String name, String pw) throws SQLException {
			
			StringBuffer query = new StringBuffer();
			
			query.append("INSERT INTO				");
			query.append("			developers		");
			query.append("VALUES (					");
			query.append("		  ?					");
			query.append("		, ?					");
			query.append("		, ?					");
			query.append("		, ?					");
			query.append("		, ?					");
			query.append("		, ?					");
			query.append("		, ?					");
			query.append("		, ?					");
			query.append("		, ?					");
			query.append("		, ?					");
			query.append("		)					");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			
			DeveloperVO temp = new DeveloperVO(id, name, pw);
			
			int idx = 1;
			ps.setString(idx++, temp.getDevId());
			ps.setString(idx++, temp.getDevName());
			ps.setString(idx++, temp.getDevPw());
			ps.setString(idx++, temp.getItem1());
			ps.setString(idx++, temp.getItem2());
			ps.setString(idx++, temp.getItem3());
			ps.setInt(idx++, temp.getItem1_Lv());
			ps.setInt(idx++, temp.getItem2_Lv());
			ps.setInt(idx++, temp.getItem3_Lv());
			ps.setInt(idx++, temp.getDevMoney());
			
			int cnt = ps.executeUpdate();
			
			if(ps!=null)ps.close();
			
			return cnt;
		}
		
		// 회원가입할때, 입력한 아이디에 대한 중복체크
		// 로그인시, 입력한 아이디에 대한 패스워드 검사
		// 로그인 성공, 입력한 아이디에 대한 developer 데이터 가져옴
		public DeveloperVO getDev(Connection conn, String id) throws SQLException {
			StringBuffer query = new StringBuffer();
			
			query.append("SELECT					");
			query.append("		dev_id				");
			query.append("	  , dev_name 			");
			query.append("	  , dev_pw 				");
			query.append("	  , item1	 			");
			query.append("	  , item2	 			");
			query.append("	  , item3	 			");
			query.append("	  , item1_lv 			");
			query.append("	  , item2_lv 			");
			query.append("	  , item3_lv 			");
			query.append("	  , dev_money 			");
			query.append("FROM						");
			query.append("		developers			");
			query.append("WHERE 1=1					");
			query.append("	AND	dev_id = ?			");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			DeveloperVO temp = new DeveloperVO();
			
			while(rs.next()) {
				temp.setDevId(rs.getString("dev_id"));
				temp.setDevName(rs.getString("dev_name"));
				temp.setDevPw(rs.getString("dev_pw"));
				temp.setItem1(rs.getString("item1"));
				temp.setItem2(rs.getString("item2"));
				temp.setItem3(rs.getString("item3"));
				temp.setItem1_Lv(rs.getInt("item1_lv"));
				temp.setItem2_Lv(rs.getInt("item2_lv"));
				temp.setItem3_Lv(rs.getInt("item3_lv"));
				temp.setDevMoney(rs.getInt("dev_money"));
			}
			
			if(ps!=null)ps.close();
			if(rs!=null)rs.close();
			
			return temp;
		}
		
		// 회원 정보 업데이트
		public int saveDev(Connection conn, DeveloperVO dev) throws SQLException {
			StringBuffer query = new StringBuffer();
			
			query.append("UPDATE					");
			query.append("		developers			");
			query.append("SET 						");
			query.append("    item1 = ?			    ");
			query.append("   , item2 = ?			");
			query.append("   , item3 = ?			");
			query.append("   , item1_lv = ?			");
			query.append("   , item2_lv = ?			");
			query.append("   , item3_lv = ?			");
			query.append("   , dev_money = ?		");
			query.append("WHERE 	1=1				");
			query.append("  AND dev_id = ?			");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			
			int idx = 1;
			
			ps.setString(idx++, dev.getItem1());
			ps.setString(idx++, dev.getItem2());
			ps.setString(idx++, dev.getItem3());
			ps.setInt(idx++, dev.getItem1_Lv());
			ps.setInt(idx++, dev.getItem2_Lv());
			ps.setInt(idx++, dev.getItem3_Lv());
			ps.setInt(idx++, dev.getDevMoney());
			ps.setString(idx++, dev.getDevId());
			
			int cnt = ps.executeUpdate();
			
			if(ps != null) ps.close();
			
			return cnt;
		}
		
		//장비 생성(1)
		public int registItem1(Connection conn, DeveloperVO dev, String name) throws SQLException {	
			StringBuffer query = new StringBuffer();
			
			query.append("UPDATE					");
			query.append("		developers			");
			query.append("SET 						");
			query.append("    	item1 = ?			");
			query.append("WHERE 	1=1				");
			query.append("  AND dev_id = ?			");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			
			int idx = 1;
			
			ps.setString(idx++, name);
			ps.setString(idx++, dev.getDevId());
			
			int cnt = ps.executeUpdate();
			
			if(ps != null) ps.close();
			
			return cnt;
		}
		
		public int registItem2(Connection conn, DeveloperVO dev, String name) throws SQLException {	
			StringBuffer query = new StringBuffer();
			
			query.append("UPDATE					");
			query.append("		developers			");
			query.append("SET 						");
			query.append("    	item2 = ?			");
			query.append("WHERE 	1=1				");
			query.append("  AND dev_id = ?			");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			
			int idx = 1;
			
			ps.setString(idx++, name);
			ps.setString(idx++, dev.getDevId());
			
			int cnt = ps.executeUpdate();
			
			if(ps != null) ps.close();
			
			return cnt;
		}
		
		public int registItem3(Connection conn, DeveloperVO dev, String name) throws SQLException {	
			StringBuffer query = new StringBuffer();
			
			query.append("UPDATE					");
			query.append("		developers			");
			query.append("SET 						");
			query.append("    	item3 = ?			");
			query.append("WHERE 	1=1				");
			query.append("  AND dev_id = ?			");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			
			int idx = 1;
			
			ps.setString(idx++, name);
			ps.setString(idx++, dev.getDevId());
			
			int cnt = ps.executeUpdate();
			
			if(ps != null) ps.close();
			
			return cnt;
		}
		
		
		public int saveMoney(Connection conn, DeveloperVO dev) throws SQLException {
			StringBuffer query = new StringBuffer();
			
			query.append("UPDATE					");
			query.append("		developers			");
			query.append("SET 						");
			query.append("   	 dev_money = ?		");
			query.append("WHERE 	1=1				");
			query.append("  AND dev_id = ?			");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			
			int idx = 1;
			
			ps.setInt(idx++, dev.getDevMoney());
			ps.setString(idx++, dev.getDevId());
			
			int cnt = ps.executeUpdate();
			
			if(ps != null) ps.close();
			
			return cnt;
		}
		
		public ArrayList<DeveloperVO> devList(Connection conn) throws SQLException{
			StringBuffer query = new StringBuffer();
			
			query.append("SELECT					");
			query.append("		dev_id				");
			query.append("	  , dev_name 			");
			query.append("	  , dev_pw 				");
			query.append("	  , item1	 			");
			query.append("	  , item2	 			");
			query.append("	  , item3	 			");
			query.append("	  , item1_lv 			");
			query.append("	  , item2_lv 			");
			query.append("	  , item3_lv 			");
			query.append("	  , dev_money 			");
			query.append("FROM						");
			query.append("		developers			");
			query.append("ORDER BY					");
			query.append("		item1_lv DESC		");
			query.append("	  , item2_lv			");
			query.append("	  , item3_lv			");
			
			PreparedStatement ps = conn.prepareStatement(query.toString());
			ResultSet rs = ps.executeQuery();
			
			ArrayList<DeveloperVO> result = new ArrayList<DeveloperVO>();
			
			while(rs.next()) {
				DeveloperVO temp = new DeveloperVO();
				
				temp.setDevId(rs.getString("dev_id"));
				temp.setDevName(rs.getString("dev_name"));
				temp.setDevPw(rs.getString("dev_pw"));
				temp.setItem1(rs.getString("item1"));
				temp.setItem2(rs.getString("item2"));
				temp.setItem3(rs.getString("item3"));
				temp.setItem1_Lv(rs.getInt("item1_lv"));
				temp.setItem2_Lv(rs.getInt("item2_lv"));
				temp.setItem3_Lv(rs.getInt("item3_lv"));
				temp.setDevMoney(rs.getInt("dev_money"));
				
				result.add(temp);
			}
			
			if(ps!=null)ps.close();
			if(rs!=null)rs.close();
			
			return result;
		}
		
		
		
	
	
	
	
	
	
	
	
	
	
	
}
