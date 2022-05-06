package ProjectTest1;

import java.util.*;

import day0428.MemberDTO;

public class shopingService {
	ShopingRepository sr = new ShopingRepository();
	Scanner scan = new Scanner(System.in);
	Long memberpoint = 0L;

	public void save() {
		System.out.println("<< 회원가입을 시작합니다 >>");
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPw = scan.next();
		System.out.print("이메일: ");
		String memberEmail = scan.next();
		System.out.print("핸드폰번호: ");
		String memberMobile = scan.next();
		System.out.print("성별: ");
		String memberGender = scan.next();
		boolean idcheck = sr.idcheck(memberId);
		if (idcheck) {
			System.out.println("중복된 아이디가 존재합니다");
		} else {
			System.out.println("회원가입을 축하합니다!!!");
		}
		ShopingMemberDTO member = new ShopingMemberDTO(memberId, memberPw, memberEmail, memberMobile, memberGender,
				memberpoint);
		sr.save(member);

	}

	public void login() {
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPw = scan.next();
		boolean logincheck = sr.logincheck(memberId, memberPw);
		if (logincheck) {
			System.out.println("로그인이 성공하였습니다.");
		} else {
			System.out.println("아이디와 비밀번호를 확인해주세요");
		}
	}

	public void myPage() {
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------");
			System.out.println("1.회원정보 2.포인트충전 3.회원탈퇴 4.돌아가기");
			System.out.println("----------------------------------");
			System.out.print("번호를 선택하세요 >");
			int sel = scan.nextInt();
			if (sel == 1) {
				findById();
			} else if (sel == 2) {
				plusMoney();
			} else if (sel == 3) {
				delete();
			} else if (sel == 4) {
				System.out.println("이전화면으로 돌아갑니다");
				run = false;
			}
		}
	}

	private void plusMoney() {
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPw = scan.next();
		boolean logincheck = sr.logincheck(memberId, memberPw);
		if (logincheck) {
			System.out.println("<< 포인트 충전 금액을 입력해주세요 >>");
			int deposit = scan.nextInt();
			boolean moneyResult = sr.plusMoney(deposit, memberpoint, memberId);
			if (moneyResult) {
				System.out.println(deposit + "원 입금 확인되었습니다");

				System.out.println("포인트 충전이 완료되었습니다.");
			}
		}
	}

	private void delete() {
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPw = scan.next();
		boolean logincheck = sr.logincheck(memberId, memberPw);
		if (logincheck) {
			System.out.println("탈퇴하시면 100일동안 재가입 하실 수 없습니다");
			System.out.println("그래도 정말 탈퇴하시겠습니까?");
			System.out.println("1.예  2.아니오");
			int num3 = scan.nextInt();
			if (num3 == 1) {
				sr.remove(memberId, memberPw);
				System.out.println("정상적으로 탈퇴되었습니다");
			} else if (num3 == 2) {
				System.out.println("이전화면으로 돌아갑니다");
			}
		} else {
			System.out.println("아이디와 비밀번호를 확인하세요");
		}

	}

	public void findById() {
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPw = scan.next();
		boolean logincheck = sr.logincheck(memberId, memberPw);
		if (logincheck) {
			ShopingMemberDTO result = sr.findById(memberId, memberPw);
			System.out.println(result);
		} else if (!logincheck) {
			System.out.println("아이디와 비밀번호를 확인해주세요");
		}

	}

	public void shopList() {
		List<ShopingDTO> shoppingList = sr.findAll();
		for (int i = 0; i < shoppingList.size(); i++) {
			System.out.println(shoppingList.get(i));
		}

	}

	public void add1() {
		sr.add1();

	}

	public void order() {
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPw = scan.next();
		boolean logincheck = sr.logincheck(memberId, memberPw);
		int select = 0;
		boolean run = true;
		if (logincheck) {
			while (run) {
				Long cash = sr.bringcash(memberId, memberpoint);
				System.out.println("현재 포인트는 " + cash + "p 입니다");
				System.out.print("상품번호를 입력하세요: ");
				int shopId = scan.nextInt();
				ShopingDTO selectResult = sr.findByShop(shopId);
				System.out.println(selectResult);
				System.out.println("위 상품을 주문하시겠습니까?");
				System.out.println("1.주문하기 2.취소");
				int selectNumber = scan.nextInt();
				if (selectNumber == 1) {
					Long pay = sr.losemoney(memberId, cash, selectResult.shopPrice);
				} else if (selectNumber == 2) {
					
					run = false;
				}
			}
		} else {
			System.out.println("아이디 비밀번호를 확인하세요");
		}

	}
}