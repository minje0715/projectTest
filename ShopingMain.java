package ProjectTest1;

import java.util.*;

public class ShopingMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		shopingService ss = new shopingService();
		ss.add1();
		boolean run = true;

		while (run) {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("1.회원가입 2.로그인 3.내정보관리 4.상품리스트 5.상품주문 6.종료");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.print("번호를 선택하세요 >");
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
				System.out.println("프로그램을 종료합니다.");
			}
		}

	}

}
