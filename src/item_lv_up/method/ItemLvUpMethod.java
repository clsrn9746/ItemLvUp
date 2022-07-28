package item_lv_up.method;

import item_lv_up.model.DeveloperVO;
import item_lv_up.service.ItemLvUpService;

public class ItemLvUpMethod {
	private static ItemLvUpMethod instance = new ItemLvUpMethod();
	ItemLvUpService service = ItemLvUpService.getInstance();

	private ItemLvUpMethod() {
	}

	public static ItemLvUpMethod getInstance() {
		if (instance == null) {
			instance = new ItemLvUpMethod();
		}
		return instance;
	}
	
	public static void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 장비강화
	public void levelUp1(DeveloperVO dev) {

		if (dev.getItem1_Lv() < 5) {
			int rand = (int) (Math.random() * 100);
			dev.setDevMoney(dev.getDevMoney() - 300);
			if (rand >= 10) {
				dev.setItem1_Lv(dev.getItem1_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
			}
		} else if (dev.getItem1_Lv() >= 5 && dev.getItem1_Lv() < 10) {
			int rand = (int) (Math.random() * 100);
			dev.setDevMoney(dev.getDevMoney() - 300);
			if (rand >= 30) {
				dev.setItem1_Lv(dev.getItem1_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
			}

		} else if (dev.getItem1_Lv() >= 10 && dev.getItem1_Lv() < 15) {
			int rand = (int) (Math.random() * 100);
			double bombRand = (int) (Math.random() * 1000);
			dev.setDevMoney(dev.getDevMoney() - 500);
			int bombNum = 5;
			if (dev.getItem1_Lv() == 11) {
				bombNum = 10;
			} else if (dev.getItem1_Lv() == 12) {
				bombNum = 15;
			} else if (dev.getItem1_Lv() == 13) {
				bombNum = 20;
			} else if (dev.getItem1_Lv() == 14) {
				bombNum = 25;
			}
			if (rand >= 50) {
				dev.setItem1_Lv(dev.getItem1_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
				if (bombRand <= bombNum) {
					System.err.println("장비가 터져버렸습니다!!");
					dev.setItem1(null);
					dev.setItem1_Lv(0);
				}
			}
		} else if (dev.getItem1_Lv() >= 15 && dev.getItem1_Lv() < 20) {
			int rand = (int) (Math.random() * 100);
			double bombRand = (int) (Math.random() * 1000);
			dev.setDevMoney(dev.getDevMoney() - 1000);
			int bombNum = 30;
			if (dev.getItem1_Lv() == 16) {
				bombNum = 35;
			} else if (dev.getItem1_Lv() == 17) {
				bombNum = 40;
			} else if (dev.getItem1_Lv() == 18) {
				bombNum = 45;
			} else if (dev.getItem1_Lv() == 19) {
				bombNum = 50;
			}
			if (rand >= 60) {
				dev.setItem1_Lv(dev.getItem1_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
				if (bombRand <= bombNum) {
					System.err.println("장비가 터져버렸습니다!!");
					dev.setItem1(null);
					dev.setItem1_Lv(0);
				}
			}
		} else if (dev.getItem1_Lv() >= 20) {
			int rand = (int) (Math.random() * 100);
			double bombRand = (int) (Math.random() * 1000);
			dev.setDevMoney(dev.getDevMoney() - 5000);
			int bombNum = 100;
			if (rand >= 70) {
				dev.setItem1_Lv(dev.getItem1_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
				if (bombRand <= bombNum) {
					System.err.println("장비가 터져버렸습니다!!");
					dev.setItem1(null);
					dev.setItem1_Lv(0);
				}
			}
		}
		int saveResult = service.saveDev(dev);
	}// levelup1

	public void levelUp2(DeveloperVO dev) {

		if (dev.getItem2_Lv() < 5) {
			int rand = (int) (Math.random() * 100);
			dev.setDevMoney(dev.getDevMoney() - 300);
			if (rand >= 10) {
				dev.setItem2_Lv(dev.getItem2_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
			}
		} else if (dev.getItem2_Lv() >= 5 && dev.getItem2_Lv() < 10) {
			int rand = (int) (Math.random() * 100);
			dev.setDevMoney(dev.getDevMoney() - 300);
			if (rand >= 30) {
				dev.setItem2_Lv(dev.getItem2_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
			}

		} else if (dev.getItem2_Lv() >= 10 && dev.getItem2_Lv() < 15) {
			int rand = (int) (Math.random() * 100);
			double bombRand = (int) (Math.random() * 1000);
			dev.setDevMoney(dev.getDevMoney() - 500);
			int bombNum = 5;
			if (dev.getItem2_Lv() == 11) {
				bombNum = 10;
			} else if (dev.getItem2_Lv() == 12) {
				bombNum = 15;
			} else if (dev.getItem2_Lv() == 13) {
				bombNum = 20;
			} else if (dev.getItem2_Lv() == 14) {
				bombNum = 25;
			}
			if (rand >= 50) {
				dev.setItem2_Lv(dev.getItem2_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
				if (bombRand <= bombNum) {
					System.err.println("장비가 터져버렸습니다!!");
					dev.setItem2(null);
					dev.setItem2_Lv(0);
				}
			}
		} else if (dev.getItem2_Lv() >= 15 && dev.getItem2_Lv() < 20) {
			int rand = (int) (Math.random() * 100);
			double bombRand = (int) (Math.random() * 1000);
			dev.setDevMoney(dev.getDevMoney() - 1000);
			int bombNum = 30;
			if (dev.getItem2_Lv() == 16) {
				bombNum = 35;
			} else if (dev.getItem2_Lv() == 17) {
				bombNum = 40;
			} else if (dev.getItem2_Lv() == 18) {
				bombNum = 45;
			} else if (dev.getItem2_Lv() == 19) {
				bombNum = 50;
			}
			if (rand >= 60) {
				dev.setItem2_Lv(dev.getItem2_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
				if (bombRand <= bombNum) {
					System.err.println("장비가 터져버렸습니다!!");
					dev.setItem2(null);
					dev.setItem2_Lv(0);
					int saveResult = service.saveDev(dev);
				}
			}
		} else if (dev.getItem2_Lv() >= 20) {
			int rand = (int) (Math.random() * 100);
			double bombRand = (int) (Math.random() * 1000);
			dev.setDevMoney(dev.getDevMoney() - 5000);
			int bombNum = 100;
			if (rand >= 70) {
				dev.setItem2_Lv(dev.getItem2_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
				if (bombRand <= bombNum) {
					System.err.println("장비가 터져버렸습니다!!");
					dev.setItem2(null);
					dev.setItem2_Lv(0);
				}
			}
		}
		int saveResult = service.saveDev(dev);
	}// item2

	public void levelUp3(DeveloperVO dev) {

		if (dev.getItem3_Lv() < 5) {
			int rand = (int) (Math.random() * 100);
			dev.setDevMoney(dev.getDevMoney() - 300);
			if (rand >= 10) {
				dev.setItem3_Lv(dev.getItem3_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
			}
		} else if (dev.getItem3_Lv() >= 5 && dev.getItem3_Lv() < 10) {
			int rand = (int) (Math.random() * 100);
			dev.setDevMoney(dev.getDevMoney() - 300);
			if (rand >= 30) {
				dev.setItem3_Lv(dev.getItem3_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
			}

		} else if (dev.getItem3_Lv() >= 10 && dev.getItem3_Lv() < 15) {
			int rand = (int) (Math.random() * 100);
			double bombRand = (int) (Math.random() * 1000);
			dev.setDevMoney(dev.getDevMoney() - 500);
			int bombNum = 5;
			if (dev.getItem3_Lv() == 11) {
				bombNum = 10;
			} else if (dev.getItem3_Lv() == 12) {
				bombNum = 15;
			} else if (dev.getItem3_Lv() == 13) {
				bombNum = 20;
			} else if (dev.getItem3_Lv() == 14) {
				bombNum = 25;
			}
			if (rand >= 50) {
				dev.setItem3_Lv(dev.getItem3_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
				if (bombRand <= bombNum) {
					System.err.println("장비가 터져버렸습니다!!");
					dev.setItem3(null);
					dev.setItem3_Lv(0);
				}
			}
		} else if (dev.getItem3_Lv() >= 15 && dev.getItem3_Lv() < 20) {
			int rand = (int) (Math.random() * 100);
			double bombRand = (int) (Math.random() * 1000);
			dev.setDevMoney(dev.getDevMoney() - 1000);
			int bombNum = 30;
			if (dev.getItem3_Lv() == 16) {
				bombNum = 35;
			} else if (dev.getItem3_Lv() == 17) {
				bombNum = 40;
			} else if (dev.getItem3_Lv() == 18) {
				bombNum = 45;
			} else if (dev.getItem3_Lv() == 19) {
				bombNum = 50;
			}
			if (rand >= 60) {
				dev.setItem3_Lv(dev.getItem3_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
				if (bombRand <= bombNum) {
					System.err.println("장비가 터져버렸습니다!!");
					dev.setItem3(null);
					dev.setItem3_Lv(0);
				}
			}
		} else if (dev.getItem3_Lv() >= 20) {
			int rand = (int) (Math.random() * 100);
			double bombRand = (int) (Math.random() * 1000);
			dev.setDevMoney(dev.getDevMoney() - 5000);
			int bombNum = 100;
			if (rand >= 70) {
				dev.setItem3_Lv(dev.getItem3_Lv() + 1);
				System.out.println("강화 성공!");
			} else {
				System.err.println("강화 실패!");
				if (bombRand <= bombNum) {
					System.err.println("장비가 터져버렸습니다!!");
					dev.setItem3(null);
					dev.setItem3_Lv(0);
				}
			}
		}
		int saveResult = service.saveDev(dev);
	}// item 3
		// 장비강화 끝
	
	public void prob1(DeveloperVO dev) {

		if (dev.getItem1_Lv() < 5) {
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[90%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [300]원 입니다!");
			System.out.println();
			
		} else if (dev.getItem1_Lv() >= 5 && dev.getItem1_Lv() < 10) {
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[70%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [300]원 입니다!");
			System.out.println();
		} else if (dev.getItem1_Lv() >= 10 && dev.getItem1_Lv() < 15) {
			double bombNum = 0.5;
			
			if (dev.getItem1_Lv() == 11) {
				bombNum = 1;
			} else if (dev.getItem1_Lv() == 12) {
				bombNum = 1.5;
			} else if (dev.getItem1_Lv() == 13) {
				bombNum = 2;
			} else if (dev.getItem1_Lv() == 14) {
				bombNum = 2.5;
			}
			
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[50%]");
			sleep();
			System.out.print(" 입니다!");
			System.out.print(" ,터질확률은 ");
			sleep();
			System.err.print("[" + bombNum + "%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [500]원 입니다!");
			System.out.println();

		} else if (dev.getItem1_Lv() >= 15 && dev.getItem1_Lv() < 20) {
			double bombNum = 3;
			
			if (dev.getItem1_Lv() == 16) {
				bombNum = 3.5;
			} else if (dev.getItem1_Lv() == 17) {
				bombNum = 4;
			} else if (dev.getItem1_Lv() == 18) {
				bombNum = 4.5;
			} else if (dev.getItem1_Lv() == 19) {
				bombNum = 5;
			}
			
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[40%]");
			sleep();
			System.out.print(" 입니다!");
			System.out.print(", 터질확률은 ");
			sleep();
			System.err.print("[" + bombNum + "%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [1000]원 입니다!");
			System.out.println();
			
		} else if (dev.getItem1_Lv() >= 20) {
		
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[30%]");
			sleep();
			System.out.print(" 입니다!");
			sleep();
			System.out.print(", 터질확률은 ");
			sleep();
			System.err.print("[10%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [5000]원 입니다!");
			System.out.println();
		}
	}
	
	public void prob2(DeveloperVO dev) {

		if (dev.getItem2_Lv() < 5) {
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[90%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [300]원 입니다!");
			System.out.println();
			
		} else if (dev.getItem2_Lv() >= 5 && dev.getItem2_Lv() < 10) {
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[70%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [300]원 입니다!");
			System.out.println();
		} else if (dev.getItem2_Lv() >= 10 && dev.getItem2_Lv() < 15) {
			double bombNum = 0.5;
			
			if (dev.getItem2_Lv() == 11) {
				bombNum = 1;
			} else if (dev.getItem2_Lv() == 12) {
				bombNum = 1.5;
			} else if (dev.getItem2_Lv() == 13) {
				bombNum = 2;
			} else if (dev.getItem2_Lv() == 14) {
				bombNum = 2.5;
			}
			
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[50%]");
			sleep();
			System.out.print(" 입니다!");
			System.out.print(", 터질확률은 ");
			sleep();
			System.err.print("[" + bombNum + "%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [500]원 입니다!");
			System.out.println();
			
		} else if (dev.getItem2_Lv() >= 15 && dev.getItem2_Lv() < 20) {
			double bombNum = 3;
			
			if (dev.getItem2_Lv() == 16) {
				bombNum = 3.5;
			} else if (dev.getItem2_Lv() == 17) {
				bombNum = 4;
			} else if (dev.getItem2_Lv() == 18) {
				bombNum = 4.5;
			} else if (dev.getItem2_Lv() == 19) {
				bombNum = 5;
			}
			
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[40%]");
			sleep();
			System.out.print(" 입니다!");
			System.out.print(", 터질확률은 ");
			sleep();
			System.err.print("[" + bombNum + "%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [1000]원 입니다!");
			System.out.println();
			
		} else if (dev.getItem2_Lv() >= 20) {
		
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[30%]");
			sleep();
			System.out.print(" 입니다!");
			sleep();
			System.out.print(", 터질확률은 ");
			sleep();
			System.err.print("[10%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [5000]원 입니다!");
			System.out.println();
		}
	}
	
	public void prob3(DeveloperVO dev) {

		if (dev.getItem3_Lv() < 5) {
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[90%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [300]원 입니다!");
			System.out.println();
			
		} else if (dev.getItem3_Lv() >= 5 && dev.getItem3_Lv() < 10) {
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[70%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [300]원 입니다!");
			System.out.println();
		} else if (dev.getItem3_Lv() >= 10 && dev.getItem3_Lv() < 15) {
			double bombNum = 0.5;
			
			if (dev.getItem3_Lv() == 11) {
				bombNum = 1;
			} else if (dev.getItem3_Lv() == 12) {
				bombNum = 1.5;
			} else if (dev.getItem3_Lv() == 13) {
				bombNum = 2;
			} else if (dev.getItem3_Lv() == 14) {
				bombNum = 2.5;
			}
			
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[50%]");
			sleep();
			System.out.print(" 입니다!");
			System.out.print(", 터질확률은 ");
			sleep();
			System.err.print("[" + bombNum + "%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [500]원 입니다!");
			System.out.println();

		} else if (dev.getItem3_Lv() >= 15 && dev.getItem3_Lv() < 20) {
			double bombNum = 3;
			
			if (dev.getItem3_Lv() == 16) {
				bombNum = 3.5;
			} else if (dev.getItem3_Lv() == 17) {
				bombNum = 4;
			} else if (dev.getItem3_Lv() == 18) {
				bombNum = 4.5;
			} else if (dev.getItem3_Lv() == 19) {
				bombNum = 5;
			}
			
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[40%]");
			sleep();
			System.out.print(" 입니다!");
			System.out.print(", 터질확률은 ");
			sleep();
			System.err.print("[" + bombNum + "%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [1000]원 입니다!");
			System.out.println();
			
		} else if (dev.getItem3_Lv() >= 20) {
		
			System.out.print("강화확률은 ");
			sleep();
			System.err.print("[30%]");
			sleep();
			System.out.print(" 입니다!");
			sleep();
			System.out.print(", 터질확률은 ");
			sleep();
			System.err.print("[10%]");
			sleep();
			System.out.println(" 입니다!");
			System.out.println("강화비용은 [5000]원 입니다!");
			System.out.println();
		}
	}

	public String randAbcd() {
		int rand = (int) (Math.random() * 25);
		String random = "";
		switch (rand) {
		case 0:
			random = "a";
			break;
		case 1:
			random = "b";
			break;
		case 2:
			random = "c";
			break;
		case 3:
			random = "d";
			break;
		case 4:
			random = "e";
			break;
		case 5:
			random = "f";
			break;
		case 6:
			random = "g";
			break;
		case 7:
			random = "h";
			break;
		case 8:
			random = "i";
			break;
		case 9:
			random = "j";
			break;
		case 10:
			random = "k";
			break;
		case 11:
			random = "l";
			break;
		case 12:
			random = "m";
			break;
		case 13:
			random = "n";
			break;
		case 14:
			random = "o";
			break;
		case 15:
			random = "p";
			break;
		case 16:
			random = "q";
			break;
		case 17:
			random = "r";
			break;
		case 18:
			random = "s";
			break;
		case 19:
			random = "t";
			break;
		case 20:
			random = "u";
			break;
		case 21:
			random = "v";
			break;
		case 22:
			random = "w";
			break;
		case 23:
			random = "x";
			break;
		case 24:
			random = "y";
			break;
		case 25:
			random = "z";
			break;
		}

		return random;
	}

}
