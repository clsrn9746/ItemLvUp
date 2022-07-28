package item_lv_up;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import item_lv_up.service.ItemLvUpService;
import item_lv_up.method.ItemLvUpMethod;
import item_lv_up.model.DeveloperVO;

public class lvupMain {
	public static void main(String[] args) {
		ItemLvUpService service = ItemLvUpService.getInstance();
		ItemLvUpMethod method = ItemLvUpMethod.getInstance();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("            $$$");
			System.out.println("           $~:$");
			System.out.println("          $~:~$");
			System.out.println("         $~:~$ ");
			System.out.println("        $~:~$  ");
			System.out.println("       ;~:~$   ");
			System.out.println("  @#. ,!::=    ");
			System.out.println("  ;$$;!:!:     ");
			System.out.println("   @*@:!.      ");
			System.out.println("    @*@:       ");
			System.out.println("   ;*@*$       ");
			System.out.println("  ;*= @=#      ");
			System.out.println("@@==   ;@      ");
			System.out.println("@*@            ");
			System.out.println("@@@            ");
			System.out.println("＊장비강화게임에 오신 것을 환영합니다＊");
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 종료");
			System.out.print(">>> ");

			int select = 0;

			try {
				select = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("숫자만 입력해주세요.");
				continue;
			}
			// 로그인
			if (select == 1) {
				System.out.println("아이디를 입력해주세요.");
				System.out.print(">>> ");
				String id = sc.nextLine();
				System.out.println("비밀번호를 입력해주세요.");
				System.out.print(">>> ");
				String pw = sc.nextLine();

				DeveloperVO dev = service.getDev(id);

				if (dev.getDevPw().equals(pw)) {
					System.out.println(dev.getDevId() + "님 안녕하세요!");

					while (true) {
						System.out.println(dev.getDevName() + "님의 소지금 : " + dev.getDevMoney() + "원");
						System.out.println("1. 장비생성 | 2. 장비목록 | 3. 장비강화 | 4. 허수아비 잡기 | 5. 명예의 전당 | 6. 로그아웃");
						System.out.print(">>> ");

						select = 0;

						try {
							select = Integer.parseInt(sc.nextLine());
						} catch (Exception e) {
							System.out.println("숫자만 입력해주세요.");
							continue;
						}

						// 장비생성
						if (select == 1) {
							if (dev.getDevMoney() < 2000) {
								System.err.println("돈이 모자랍니다!");
								continue;
							}
							System.out.println("장비의 이름을 정하세요. \n이름은 변경 불가 |'Q'입력시 뒤로 | 생성시 2000원 차감됩니다!");
							System.out.print(">>> ");
							String name = sc.nextLine();
							if (name.equals("Q")) {
								int saveResult = service.saveDev(dev);
								continue;
							}
							int num = 0;
							if (dev.getItem1() == null) {
								dev.setItem1(name);
								num = 1;
								int registItem = service.registItem(dev, dev.getItem1(), num);
								if (registItem > 0) {
									System.out.println("장비 1번 등록 완료!");
									dev.setDevMoney(dev.getDevMoney() - 2000);
									int saveResult = service.saveMoney(dev);
									continue;
								}
							} else if (dev.getItem2() == null) {
								dev.setItem2(name);
								num = 2;
								int registItem = service.registItem(dev, dev.getItem2(), num);
								if (registItem > 0) {
									System.out.println("장비 2번 등록 완료!");
									dev.setDevMoney(dev.getDevMoney() - 2000);
									int saveResult = service.saveMoney(dev);
									continue;
								}
							} else if (dev.getItem3() == null) {
								dev.setItem3(name);
								num = 3;
								int registItem = service.registItem(dev, dev.getItem3(), num);
								if (registItem > 0) {
									System.out.println("장비 3번 등록 완료!");
									dev.setDevMoney(dev.getDevMoney() - 2000);
									int saveMoney = service.saveMoney(dev);
									continue;
								}
							} else if (!(dev.getItem2().equals(null)) && !(dev.getItem2().equals(null))
									&& !(dev.getItem3().equals(null))) {
								System.err.println("장비창이 가득 찼습니다!");

								continue;
							}
							// 장비목록
						} else if (select == 2) {
							System.out.println("==================================");
							System.out.println("1. " + "+" + dev.getItem1_Lv() + " " + dev.getItem1());
							System.out.println("2. " + "+" + dev.getItem2_Lv() + " " + dev.getItem2());
							System.out.println("3. " + "+" + dev.getItem3_Lv() + " " + dev.getItem3());
							System.out.println("==================================");
							continue;
							// 장비강화
						} else if (select == 3) {
							while (true) {
								System.out.println("강화할 장비의 이름을 입력해주세요! ※'Q'입력시 뒤로가기");
								System.out.print(">>> ");
								String item_name = sc.nextLine();
								if (item_name.equals("Q")) {
									int saveResult = service.saveDev(dev);
									break;
								} else if (!item_name.equals(dev.getItem1()) && !item_name.equals(dev.getItem2())
										&& !item_name.equals(dev.getItem3())) {
									System.err.println("그런 장비는 없습니다!");
									continue;
								}
								if (item_name.equals(dev.getItem1())) {
									System.out.println(dev.getItem1() + "을 선택하셨습니다!");
									System.out.println("=================================");
									System.out.println(dev.getItem1_Lv() + "+ " + dev.getItem1() + " | 보유금액 : "
											+ dev.getDevMoney() + "원");
									System.out.println("=================================");
									method.prob1(dev);
									while (true) {
										System.out.println("●강화하려면 [강화]를 입력하세요. ※'Q'입력시 뒤로가기●");
										System.out.print(">>> ");
										String input = sc.nextLine();
										if (input.equals("Q")) {
											int saveResult = service.saveDev(dev);
											break;
										}
										if (input.equals("강화")) {
											if (dev.getItem1() == null) {
												System.err.println("장비가 없어서 강화할 수 없습니다!");
												continue;
											}
											if (dev.getItem1_Lv() < 10 && dev.getDevMoney() < 300) {
												System.err.println("강화할 돈이 모자랍니다!");
												continue;
											} else if (dev.getItem1_Lv() < 15 && dev.getItem1_Lv() >= 10 && dev.getDevMoney() < 500) {
												System.err.println("강화할 돈이 모자랍니다!");
												continue;
											} else if (dev.getItem1_Lv() < 20 && dev.getItem1_Lv() >= 15 && dev.getDevMoney() < 1000) {
												System.err.println("강화할 돈이 모자랍니다!");
												continue;
											} else if (dev.getItem1_Lv() >= 20 && dev.getDevMoney() < 5000) {
												System.err.println("강화할 돈이 모자랍니다!");
												continue;
											} else {
												for (int i = 0; i < 10; i++) {
													sleep();
													System.out.print("> ");
												}
												method.levelUp1(dev);
												int saveResult = service.saveDev(dev);
												sleep();
												System.out.println("=================================");
												System.out.println(dev.getItem1_Lv() + "+ " + dev.getItem1()
														+ " | 보유금액 : " + dev.getDevMoney() + "원");
												System.out.println("=================================");
												method.prob1(dev);
											}
										}

									} // 강화 실행 while
								} else if (item_name.equals(dev.getItem2())) {
									System.out.println(dev.getItem2() + "을 선택하셨습니다!");
									System.out.println("=================================");
									System.out.println(dev.getItem2_Lv() + "+ " + dev.getItem2() + " | 보유금액 : "
											+ dev.getDevMoney() + "원");
									System.out.println("=================================");
									method.prob2(dev);
									while (true) {
										System.out.println("강화하려면 [강화]를 입력하세요. ※'Q'입력시 뒤로가기");
										System.out.print(">>> ");
										String input = sc.nextLine();
										if (input.equals("Q")) {
											int saveResult = service.saveDev(dev);
											break;
										}
										if (input.equals("강화")) {
											if (dev.getItem2() == null) {
												System.err.println("장비가 없어서 강화할 수 없습니다!");
												continue;
											}
											if (dev.getItem2_Lv() < 10 && dev.getDevMoney() < 300) {
												System.err.println("강화할 돈이 모자랍니다!");
												continue;
											} else if (dev.getItem2_Lv() < 15 && dev.getItem2_Lv() >= 10 && dev.getDevMoney() < 500) {
												System.err.println("강화할 돈이 모자랍니다!");
												continue;
											} else if (dev.getItem2_Lv() < 20 && dev.getItem2_Lv() >= 15 && dev.getDevMoney() < 1000) {
												System.err.println("강화할 돈이 모자랍니다!");
												continue;
											} else if (dev.getItem2_Lv() >= 20 && dev.getDevMoney() < 5000) {
												System.err.println("강화할 돈이 모자랍니다!");
												continue;
											} else {
												for (int i = 0; i < 10; i++) {
													sleep();
													System.out.print("> ");
												}
												method.levelUp2(dev);
												int saveResult = service.saveDev(dev);
												sleep();
												System.out.println("=================================");
												System.out.println(dev.getItem2_Lv() + "+ " + dev.getItem2()
														+ " | 보유금액 : " + dev.getDevMoney() + "원");
												System.out.println("=================================");
												method.prob2(dev);
											}
										}

									} // 강화 실행 while
								}else if (item_name.equals(dev.getItem3())) {
									System.out.println(dev.getItem3() + "을 선택하셨습니다!");
									System.out.println("=================================");
									System.out.println(dev.getItem3_Lv() + "+ " + dev.getItem3() + " | 보유금액 : "
											+ dev.getDevMoney() + "원");
									System.out.println("=================================");
									method.prob3(dev);
									while (true) {
										System.out.println("강화하려면 [강화]를 입력하세요. ※'Q'입력시 뒤로가기");
										System.out.print(">>> ");
										String input = sc.nextLine();
										if (input.equals("Q")) {
											int saveResult = service.saveDev(dev);
											break;
										}
										if (input.equals("강화")) {
											if (dev.getItem3() == null) {
												System.err.println("장비가 없어서 강화할 수 없습니다!");
												continue;
											}
											if (dev.getItem3_Lv() < 10 && dev.getDevMoney() < 300) {
												System.err.println("강화할 돈이 모자랍니다!");
												continue;
											} else if (dev.getItem3_Lv() < 15 && dev.getItem3_Lv() >= 10 && dev.getDevMoney() < 500) {
												System.err.println("강화할 돈이 모자랍니다!");
												continue;
											} else if (dev.getItem3_Lv() < 20 && dev.getItem3_Lv() >= 15 && dev.getDevMoney() < 1000) {
												System.err.println("강화할 돈이 모자랍니다!");
												continue;
											} else if (dev.getItem3_Lv() >= 20 && dev.getDevMoney() < 5000) {
												System.err.println("강화할 돈이 모자랍니다!");
												continue;
											} else {
												for (int i = 0; i < 10; i++) {
													sleep();
													System.out.print("> ");
												}
												method.levelUp3(dev);
												int saveResult = service.saveDev(dev);
												sleep();
												System.out.println("=================================");
												System.out.println(dev.getItem3_Lv() + "+ " + dev.getItem3()
														+ " | 보유금액 : " + dev.getDevMoney() + "원");
												System.out.println("=================================");
												method.prob3(dev);
											}
										}

									} // 강화 실행 while
								}
							} // 강화 while
						
						//허수아비 잡기
						} else if (select == 4) {
							int hp = 10;
							int count = 0;
							while(true) {
								String randAbcd = method.randAbcd();
								System.out.println("허수아비 잡기    ※'Q'입력시 퇴장");
								System.out.println(" ● " );
								System.out.println("─┼─" + "     HP : " + hp);
								System.out.println();
								System.out.print(randAbcd + " >>> ");
								String input = sc.nextLine();
								if(input.equals(randAbcd)) {
									int rand = (int)(Math.random()* 3 + 1);
									hp -= rand;
									System.err.println(rand + "만큼 때렸다!");
									sleep();
									if(hp <= 0) {
										hp = 10;
										dev.setDevMoney(dev.getDevMoney() + 2000);
										sleep();
										System.out.println("2000원 획득! | 현재 가진 돈 : " + dev.getDevMoney() + "원");
										sleep();
										
									}
								}else if(input.equals("Q")) {
									int saveResult = service.saveDev(dev);
									break;
								}		
								
							}
						//명예의 전당
						} else if (select == 5) {
							ArrayList<DeveloperVO> devList = service.devList();
							ArrayList<Integer> levelList = new ArrayList<Integer>();
							int num = 1;
							System.out.println("★==================명예의전당==================★\n");
							
							for(int i = 0; i < devList.size(); i++) {
								levelList.add(devList.get(i).maxLevel());
							}
							levelList.sort(Comparator.reverseOrder());
						
							for(int i = 0; i < devList.size(); i++) {
								for(int j = 0; j < devList.size(); j++) {
									if(devList.get(j).maxLevel() == levelList.get(i)) {
										System.out.println(num  + "등 : " 
												+ devList.get(j).toString());
										num++;
									}
								}							
							}
							System.out.println("\n================================================");
							
						} else if (select == 6) {
							int saveResult = service.saveDev(dev);

							if (saveResult > 0) {
								System.out.println("로그아웃 되었습니다.");
								break;
							} else {
								System.out.println("로그아웃 실패");
							}
						}

					} // while 2
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}

			} // 로그인
				// 회원가입
			else if (select == 2) {
				System.out.println("아이디를 입력해주세요.");
				System.out.print(">>> ");
				String id = sc.nextLine();
				System.out.println("이름을 입력해주세요.");
				System.out.print(">>> ");
				String name = sc.nextLine();
				System.out.println("비밀번호를 입력해주세요.");
				System.out.print(">>> ");
				String pw = sc.nextLine();

				DeveloperVO dev = service.getDev(id);

				if (dev.getDevId() != null) {
					System.out.println("중복된 아이디 입니다.");
				} else {
					int resultCnt = service.registDev(id, name, pw);

					if (resultCnt > 0) {
						System.out.println("회원가입 완료");
					} else {
						System.out.println("오류가 발생했습니다.");
					}
				}
			} else if (select == 3) {
				System.out.println("종료합니다.");
				break;
			}

		} // while 1

	}// main

	public static void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}// class