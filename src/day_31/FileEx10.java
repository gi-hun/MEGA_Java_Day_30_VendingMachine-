//�ı� ���Ǳ�
package day_31;

import java.util.Scanner;

public class FileEx10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] money   = {50000, 10000, 5000, 1000, 500, 100};		//�����ڰ� ��� �ִ� �� ����
		int[] charges = {    1,     1,    1,    1,   5,  10};		//�����ڰ� ��� �ִ� �� ����
		
		int tickets = 5;		// �ı� ����
		int price = 3200;		// �ı� ����
		
		int[] temp = money;
		
		int money_sum1 = 0;
		int money_sum2 = 0;
		for(int i=0;i<money.length;i++)
		{
			money_sum1 += money[i]*charges[i];
		}
		
		while(true) {
			
			System.out.println("[1]������");
			System.out.println("[2]�����");
			
			System.out.print("�޴� ���� : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {		//������ ���
				while(true) {
					System.out.println("1)�ı�����");
					System.out.println("2)�ܵ�����");
					System.out.println("3)�ڷΰ���");
					
					System.out.print("�޴� ���� : ");
					int choice = sc.nextInt();
					if(choice == 1) {
						System.out.println("������ �ıǼ��� �Է��ϼ���");
						System.out.println("����:" + tickets);
						System.out.print("�߰��� �ı� ��:");
						int add_tickets = sc.nextInt();
						
						tickets += add_tickets;
						System.out.println("���� Ƽ�ϼ� " + tickets);
						
					}
					else if(choice == 2) {
						
						money = temp;
						
						for(int i=0;i<money.length;i++)
						{
							System.out.print("["+i+"."+ money[i] + "��] ");
						}
						System.out.println();
					}
					else if(choice == 3) {
						System.out.println("�ڷ� �̵��մϴ�.");
						break;
					}
				}
				
			}
			else if(sel == 2) {		//����� ���
				while(true) {
					if(tickets<=0)
					{
						System.out.println("�ı��� �������� �̿����ּ���");
						break;
					}
					System.out.println("�ı� ����:"+price+"��");
					System.out.println("�ı� �ż�:"+tickets+"��");
					
					money_sum2 = money_sum1;
					System.out.println(money_sum2);		//������
					for(int i=0;i<money.length;i++)
					{
						if(money[i]>money_sum2)
						{
							System.out.println("["+money[i]+"��]"+"0��");
						}
						else if(money[i]<money_sum2)
						{
							int num= money_sum2/money[i];
							money_sum2 = money_sum2-money[i]*num;
							System.out.println("["+money[i]+"��]"+num+"��");
						}
					}
					
					System.out.println("1)����");
					System.out.println("2)�ڷΰ���");
					
					System.out.print("�޴� ���� : ");
					int choice = sc.nextInt();
					if(choice == 1) {		//����
						int total_money = 0;
						while(true)
						{
							
							System.out.println("�Ա��� �ݾ��� �Է��ϼ���.");
							System.out.println("[0.������] [1.�ϸ���] [2.��õ��] [3.õ��] [4.�����] [5.���] [6.����]");
							int user_cash = sc.nextInt();
							if(user_cash == 6)
							{
								break;
							}
							else
							{
								total_money += money[user_cash];
								System.out.println("�Ա��� �ݾ�:" +total_money+"��");
							}
							
						}
						System.out.println("�ı� �ż��� �Է��ϼ���");
						int num_tickets = sc.nextInt();
						
						int sum_price = num_tickets*3200;
						int spare_money = total_money-sum_price;
						
						if(money_sum1 < total_money)
						{
							System.out.println("�ܵ��� �����մϴ�.");
						}
						else
						{
							System.out.println("[�Ա�:"+total_money+"] [�Ѿ�:"+sum_price+"] [�Ž�����:"+spare_money+"]");
							money_sum1 -= spare_money;		//������
							tickets -= num_tickets;			//���� Ƽ��
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
