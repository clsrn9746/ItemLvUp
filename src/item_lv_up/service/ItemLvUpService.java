package item_lv_up.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import item_lv_up.dao.ItemLvUpDao;
import item_lv_up.jdbc.ConnectionPool;
import item_lv_up.model.DeveloperVO;

public class ItemLvUpService {
	private static ItemLvUpService instance = new ItemLvUpService();
	private ItemLvUpDao dao = ItemLvUpDao.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	private ItemLvUpService() {}
	
	public static ItemLvUpService getInstance() {
		if(instance == null) {
			instance = new ItemLvUpService();
		}
		return instance;
	}
	
	// 회원가입
		public int registDev(String id, String name, String pw) {
			Connection conn = cp.getConnection();
			
			try {
				return dao.registDev(conn, id, name, pw);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(conn != null) cp.releaseConnection(conn);
			}
			
			return 0;
		}
		
		// 회원정보 업데이트
		public int saveDev(DeveloperVO dev) {
			Connection conn = cp.getConnection();
			
			try {
				return dao.saveDev(conn, dev);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(conn != null) cp.releaseConnection(conn);
			}
			
			return 0;
		}
		// 돈 정보 업데이트
		public int saveMoney(DeveloperVO dev) {
			Connection conn = cp.getConnection();
			
			try {
				return dao.saveMoney(conn, dev);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(conn != null) cp.releaseConnection(conn);
			}
			
			return 0;
		}
		
		// 파라미터 id에 대한 Developer 데이터 리턴
		public DeveloperVO getDev(String id) {
			Connection conn = cp.getConnection();
			
			try {
				return dao.getDev(conn, id);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(conn != null) cp.releaseConnection(conn);
			}
			
			return new DeveloperVO();
		}
		
		//장비생성
		public int registItem(DeveloperVO dev, String name, int num) {
			Connection conn = cp.getConnection();
			
			try {
				if(num == 1) {
				return dao.registItem1(conn, dev, name);
				}else if(num == 2) {
					return dao.registItem2(conn, dev, name);	
				}else if(num == 3) {
					return dao.registItem3(conn, dev, name);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(conn != null) cp.releaseConnection(conn);
			}
			
			return 0;
		}
		
		// 회원목록 리턴(레벨 높은순)
		public ArrayList<DeveloperVO> devList(){
			Connection conn = cp.getConnection();
			
			try {
				return dao.devList(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(conn != null) cp.releaseConnection(conn);
			}
			
			return new ArrayList<DeveloperVO>();
		}
		
		


		
		
	
	
}//class
