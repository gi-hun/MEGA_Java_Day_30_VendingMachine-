//식권 자판기
package day_31;

import java.util.Scanner;

public class FileEx10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] money   = {50000, 10000, 5000, 1000, 500, 100};		//관리자가 들고 있는 돈 단위
		int[] charges = {    1,     1,    1,    1,   5,  10};		//관리자가 들고 있는 돈 갯수
		
		int tickets = 5;		// 식권 개수
		int price = 3200;		// 식권 가격
		
		int[] temp = money;
		
		int money_sum1 = 0;
		int money_sum2 = 0;
		for(int i=0;i<money.length;i++)
		{
			money_sum1 += money[i]*charges[i];
		}
		
		while(true) {
			
			System.out.println("[1]관리자");
			System.out.println("[2]사용자");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {		//관리자 모드
				while(true) {
					System.out.println("1)식권충전");
					System.out.println("2)잔돈충전");
					System.out.println("3)뒤로가기");
					
					System.out.print("메뉴 선택 : ");
					int choice = sc.nextInt();
					if(choice == 1) {
						System.out.println("충전할 식권수를 입력하세요");
						System.out.println("현재:" + tickets);
						System.out.print("추가할 식권 수:");
						int add_tickets = sc.nextInt();
						
						tickets += add_tickets;
						System.out.println("현재 티켓수 " + tickets);
						
					}
					else if(choice == 2) {
						
						money = temp;
						
						for(int i=0;i<money.length;i++)
						{
							System.out.print("["+i+"."+ money[i] + "원] ");
						}
						System.out.println();
					}
					else if(choice == 3) {
						System.out.println("뒤로 이동합니다.");
						break;
					}
				}
				
			}
			else if(sel == 2) {		//사용자 모드
				while(true) {
					if(tickets<=0)
					{
						System.out.println("식권을 충전한후 이용해주세요");
						break;
					}
					System.out.println("식권 가격:"+price+"원");
					System.out.println("식권 매수:"+tickets+"매");
					
					money_sum2 = money_sum1;
					System.out.println(money_sum2);		//남은돈
					for(int i=0;i<money.length;i++)
					{
						if(money[i]>money_sum2)
						{
							System.out.println("["+money[i]+"원]"+"0매");
						}
						else if(money[i]<money_sum2)
						{
							int num= money_sum2/money[i];
							money_sum2 = money_sum2-money[i]*num;
							System.out.println("["+money[i]+"원]"+num+"매");
						}
					}
					
					System.out.println("1)구입");
					System.out.println("2)뒤로가기");
					
					System.out.print("메뉴 선택 : ");
					int choice = sc.nextInt();
					if(choice == 1) {		//구입
						int total_money = 0;
						while(true)
						{
							
							System.out.println("입금할 금액을 입력하세요.");
							System.out.println("[0.오만원] [1.일만원] [2.오천원] [3.천원] [4.오백원] [5.백원] [6.종료]");
							int user_cash = sc.nextInt();
							if(user_cash == 6)
							{
								break;
							}
							else
							{
								total_money += money[user_cash];
								System.out.println("입금한 금액:" +total_money+"원");
							}
							
						}
						System.out.println("식권 매수를 입력하세요");
						int num_tickets = sc.nextInt();
						
						int sum_price = num_tickets*3200;
						int spare_money = total_money-sum_price;
						
						if(money_sum1 < total_money)
						{
							System.out.println("잔돈이 부족합니다.");
						}
						else
						{
							System.out.println("[입금:"+total_money+"] [총액:"+sum_price+"] [거스름돈:"+spare_money+"]");
							money_sum1 -= spare_money;		//남은돈
							tickets -= num_tickets;			//남은 티켓
						}
						
					}
					else if(choice == 2) {
						break;
					}
				}
			}
		}

	}
}
