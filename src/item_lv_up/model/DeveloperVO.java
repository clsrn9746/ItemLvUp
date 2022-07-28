package item_lv_up.model;

public class DeveloperVO {
	private String devId;			// 아이디
	private String devName;			// 이름
	private String devPw;			// 비밀번호
	private String item1;			// 장비1~3
	private String item2;	
	private String item3;
	private int item1_Lv;			
	private int item2_Lv;
	private int item3_Lv;
	private int devMoney;			// 소지금
	
	public DeveloperVO() {}
	
	// 회원가입 때 쓸 생성자
	// 아이디, 이름, 비밀번호
	public DeveloperVO(String devId, String devName, String devPw) {
		this(devId, devName, devPw, null, null, null, 0, 0, 0, 10000);
	}
	
	
	// 로그인할때 DB에 저장된 developer 불러다 담을때 쓰는 생성자	
	public DeveloperVO(String devId, String devName, String devPw, String item1, String item2, String item3,
			int item1_Lv, int item2_Lv, int item3_Lv, int devMoney) {
		this.devId = devId;
		this.devName = devName;
		this.devPw = devPw;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item1_Lv = item1_Lv;
		this.item2_Lv = item2_Lv;
		this.item3_Lv = item3_Lv;
		this.devMoney = devMoney;
	}

	@Override
	public String toString() {
		String str = "";
		
		if((item1_Lv > item2_Lv) && (item1_Lv > item3_Lv)) {
			str = "이름: " + devName +  " | 장비: " + item1 + " " + "[" + item1_Lv + "강]"; 			
		}else if((item2_Lv > item1_Lv) && (item2_Lv > item3_Lv)) {
			str = "이름: " + devName +  " | 장비: " + item2 + " " + "[" + item2_Lv + "강]"; 	
		}else if((item3_Lv > item1_Lv) && (item3_Lv > item2_Lv)) {
			str = "이름: " + devName +  " | 장비: " + item3 + " " + "[" + item3_Lv + "강]"; 	
		}
				
		
		return str;
	}
	
	public int maxLevel() {
		int num = 0;
		
		if((item1_Lv > item2_Lv) && (item1_Lv > item3_Lv)) {
			num = getItem1_Lv();			
		}else if((item2_Lv > item1_Lv) && (item2_Lv > item3_Lv)) {
			num = getItem2_Lv();
		}else if((item3_Lv > item1_Lv) && (item3_Lv > item2_Lv)) {
			num = getItem3_Lv();
		}
		
		
		
		return num;
	}
	

	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getDevPw() {
		return devPw;
	}

	public void setDevPw(String devPw) {
		this.devPw = devPw;
	}

	public String getItem1() {
		return item1;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	public String getItem2() {
		return item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getItem3() {
		return item3;
	}

	public void setItem3(String item3) {
		this.item3 = item3;
	}

	public int getItem1_Lv() {
		return item1_Lv;
	}

	public void setItem1_Lv(int item1_Lv) {
		this.item1_Lv = item1_Lv;
	}

	public int getItem2_Lv() {
		return item2_Lv;
	}

	public void setItem2_Lv(int item2_Lv) {
		this.item2_Lv = item2_Lv;
	}

	public int getItem3_Lv() {
		return item3_Lv;
	}

	public void setItem3_Lv(int item3_Lv) {
		this.item3_Lv = item3_Lv;
	}

	public int getDevMoney() {
		return devMoney;
	}

	public void setDevMoney(int devMoney) {
		this.devMoney = devMoney;
	}
		
	
}
