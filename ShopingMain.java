package ProjectTest1;

import java.util.*;

public class ShopingMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		shopingService ss = new shopingService();
		ss.add1();
		boolean run = true;

		while (run) {
			System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
			System.out.println("1.ȸ������ 2.�α��� 3.���������� 4.��ǰ����Ʈ 5.��ǰ�ֹ� 6.����");
			System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
			System.out.print("��ȣ�� �����ϼ��� >");
			int selNum = scan.nextInt();
			if (selNum == 1) {
				ss.save();
			} else if (selNum == 2) {
				ss.login();
			} else if (selNum == 3) {
				ss.myPage();
			} else if (selNum == 4) {
				ss.shopList();
			} else if (selNum == 5) {
				ss.order();
			} else if (selNum == 6) {
				System.out.println("���α׷��� �����մϴ�.");
			}
		}

	}

}
