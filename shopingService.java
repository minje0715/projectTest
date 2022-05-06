package ProjectTest1;

import java.util.*;

import day0428.MemberDTO;

public class shopingService {
	ShopingRepository sr = new ShopingRepository();
	Scanner scan = new Scanner(System.in);
	Long memberpoint = 0L;

	public void save() {
		System.out.println("<< ȸ�������� �����մϴ� >>");
		System.out.print("���̵�: ");
		String memberId = scan.next();
		System.out.print("��й�ȣ: ");
		String memberPw = scan.next();
		System.out.print("�̸���: ");
		String memberEmail = scan.next();
		System.out.print("�ڵ�����ȣ: ");
		String memberMobile = scan.next();
		System.out.print("����: ");
		String memberGender = scan.next();
		boolean idcheck = sr.idcheck(memberId);
		if (idcheck) {
			System.out.println("�ߺ��� ���̵� �����մϴ�");
		} else {
			System.out.println("ȸ�������� �����մϴ�!!!");
		}
		ShopingMemberDTO member = new ShopingMemberDTO(memberId, memberPw, memberEmail, memberMobile, memberGender,
				memberpoint);
		sr.save(member);

	}

	public void login() {
		System.out.print("���̵�: ");
		String memberId = scan.next();
		System.out.print("��й�ȣ: ");
		String memberPw = scan.next();
		boolean logincheck = sr.logincheck(memberId, memberPw);
		if (logincheck) {
			System.out.println("�α����� �����Ͽ����ϴ�.");
		} else {
			System.out.println("���̵�� ��й�ȣ�� Ȯ�����ּ���");
		}
	}

	public void myPage() {
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------");
			System.out.println("1.ȸ������ 2.����Ʈ���� 3.ȸ��Ż�� 4.���ư���");
			System.out.println("----------------------------------");
			System.out.print("��ȣ�� �����ϼ��� >");
			int sel = scan.nextInt();
			if (sel == 1) {
				findById();
			} else if (sel == 2) {
				plusMoney();
			} else if (sel == 3) {
				delete();
			} else if (sel == 4) {
				System.out.println("����ȭ������ ���ư��ϴ�");
				run = false;
			}
		}
	}

	private void plusMoney() {
		System.out.print("���̵�: ");
		String memberId = scan.next();
		System.out.print("��й�ȣ: ");
		String memberPw = scan.next();
		boolean logincheck = sr.logincheck(memberId, memberPw);
		if (logincheck) {
			System.out.println("<< ����Ʈ ���� �ݾ��� �Է����ּ��� >>");
			int deposit = scan.nextInt();
			boolean moneyResult = sr.plusMoney(deposit, memberpoint, memberId);
			if (moneyResult) {
				System.out.println(deposit + "�� �Ա� Ȯ�εǾ����ϴ�");

				System.out.println("����Ʈ ������ �Ϸ�Ǿ����ϴ�.");
			}
		}
	}

	private void delete() {
		System.out.print("���̵�: ");
		String memberId = scan.next();
		System.out.print("��й�ȣ: ");
		String memberPw = scan.next();
		boolean logincheck = sr.logincheck(memberId, memberPw);
		if (logincheck) {
			System.out.println("Ż���Ͻø� 100�ϵ��� �簡�� �Ͻ� �� �����ϴ�");
			System.out.println("�׷��� ���� Ż���Ͻðڽ��ϱ�?");
			System.out.println("1.��  2.�ƴϿ�");
			int num3 = scan.nextInt();
			if (num3 == 1) {
				sr.remove(memberId, memberPw);
				System.out.println("���������� Ż��Ǿ����ϴ�");
			} else if (num3 == 2) {
				System.out.println("����ȭ������ ���ư��ϴ�");
			}
		} else {
			System.out.println("���̵�� ��й�ȣ�� Ȯ���ϼ���");
		}

	}

	public void findById() {
		System.out.print("���̵�: ");
		String memberId = scan.next();
		System.out.print("��й�ȣ: ");
		String memberPw = scan.next();
		boolean logincheck = sr.logincheck(memberId, memberPw);
		if (logincheck) {
			ShopingMemberDTO result = sr.findById(memberId, memberPw);
			System.out.println(result);
		} else if (!logincheck) {
			System.out.println("���̵�� ��й�ȣ�� Ȯ�����ּ���");
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
		System.out.print("���̵�: ");
		String memberId = scan.next();
		System.out.print("��й�ȣ: ");
		String memberPw = scan.next();
		boolean logincheck = sr.logincheck(memberId, memberPw);
		int select = 0;
		boolean run = true;
		if (logincheck) {
			while (run) {
				Long cash = sr.bringcash(memberId, memberpoint);
				System.out.println("���� ����Ʈ�� " + cash + "p �Դϴ�");
				System.out.print("��ǰ��ȣ�� �Է��ϼ���: ");
				int shopId = scan.nextInt();
				ShopingDTO selectResult = sr.findByShop(shopId);
				System.out.println(selectResult);
				System.out.println("�� ��ǰ�� �ֹ��Ͻðڽ��ϱ�?");
				System.out.println("1.�ֹ��ϱ� 2.���");
				int selectNumber = scan.nextInt();
				if (selectNumber == 1) {
					Long pay = sr.losemoney(memberId, cash, selectResult.shopPrice);
				} else if (selectNumber == 2) {
					
					run = false;
				}
			}
		} else {
			System.out.println("���̵� ��й�ȣ�� Ȯ���ϼ���");
		}

	}
}