package ProjectTest1;

import java.util.*;

import day0428.MemberDTO;

public class ShopingRepository {
	static List<ShopingMemberDTO> memberList = new ArrayList<>();
	static List<ShopingDTO> shoppingList = new ArrayList<>();

	public void save(ShopingMemberDTO member) {
		memberList.add(member);
	}

	public boolean idcheck(String memberId) {
		boolean idcheck = false;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())) {
				idcheck = true;
			}
		}
		return idcheck;
	}

	public boolean logincheck(String memberId, String memberPw) {
		boolean login = false;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId()) && memberPw.equals(memberList.get(i).getMemberPw())) {
				return login = true;
			}
		}
		return login;
	}

	public boolean myPage(String memberId, String memberPw) {
		boolean login1 = false;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId()) && memberPw.equals(memberList.get(i).getMemberPw())) {
				return login1 = true;
			}
		}
		return login1;
	}

	public ShopingMemberDTO findById(String memberId, String memberPw) {
		ShopingMemberDTO result = null;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId()) && memberPw.equals(memberList.get(i).getMemberPw())) {
				result = memberList.get(i);
			}
		}
		return result;

	}

	public void remove(String memberId, String memberPw) {
		ShopingMemberDTO member = findById(memberId, memberPw);
		if (member != null) {
			memberList.remove(member);
		}
	}

	public boolean plusMoney(int deposit, Long memberpoint, String memberId) {
		boolean plusResult = false;
		if (deposit >= 5000 && deposit <= 1000000) {
			for (int i = 0; i < memberList.size(); i++) {
				if (memberId.equals(memberList.get(i).getMemberId())) {
					memberList.get(i).setMemberpoint(memberList.get(i).getMemberpoint() + deposit);

					plusResult = true;
				}
			}
		} else {
			System.out.println("�ּ��Աݾ��� 5000��, ");
			System.out.println("�ִ��Աݾ��� 1,000,000�� �Դϴ�");
		}
		return plusResult;

	}

	void add1() {
		ShopingDTO shop1 = new ShopingDTO(1, "û����", "���� ���� �����Դϴ�", 25000L, "�ڡڡڡڡ�");

		shoppingList.add(shop1);

		ShopingDTO shop2 = new ShopingDTO();
		shop2.setShopId(2);
		shop2.setShopName("�ݹ���");
		shop2.setShopTitle("�ÿ��� �ݹ����Դϴ�");
		shop2.setShopPrice(18500L);
		shop2.setShopStar("�ڡڡڡ١�");
		shoppingList.add(shop2);

		ShopingDTO shop3 = new ShopingDTO();
		shop3.setShopId(3);
		shop3.setShopName("������ ����Ƽ");
		shop3.setShopTitle("Ŀ�ǽ��� �������Դϴ�");
		shop3.setShopPrice(14000L);
		shop3.setShopStar("�ڡڡڡ١�");
		shoppingList.add(shop3);

		ShopingDTO shop4 = new ShopingDTO();
		shop4.setShopId(4);
		shop4.setShopName("������ ����Ƽ");
		shop4.setShopTitle("������ ���̰��̿���");
		shop4.setShopPrice(21000L);
		shop4.setShopStar("�ڡڡڡڡ�");
		shoppingList.add(shop4);

		ShopingDTO shop5 = new ShopingDTO();
		shop5.setShopId(5);
		shop5.setShopName("������ �ȭ");
		shop5.setShopTitle("������ �շ��־� �ÿ��ؿ�");
		shop5.setShopPrice(33000L);
		shop5.setShopStar("�ڡڡڡڡ�");
		shoppingList.add(shop5);
		
		ShopingDTO shop6 = new ShopingDTO();
		shop6.setShopId(6);
		shop6.setShopName("������");
		shop6.setShopTitle("�Ϳ��� ������");
		shop6.setShopPrice(7000L);
		shop6.setShopStar("�ڡڡڡڡ�");
		shoppingList.add(shop6);
		
		
	}

	public List<ShopingDTO> findAll() {

		return shoppingList;
	}

	public ShopingDTO findByShop(int shopId) {
		ShopingDTO result2 = null;
		for (int i = 0; i < shoppingList.size(); i++) {
			if (shopId == (shoppingList.get(i).getShopId())) {
				result2 = shoppingList.get(i);
			}
		}
		return result2;
	}

	public Long bringcash(String memberId, Long memberpoint) {
		Long result3 = 0L;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())) {
				result3 = memberList.get(i).getMemberpoint();
			}
		}
		return result3;
	}

	public Long losemoney(String memberId, Long cash, Long shopPrice) {
		Long pay = null;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())) {
				if (cash >= shopPrice) {
					pay = cash - shopPrice;
					memberList.get(i).setMemberpoint(memberList.get(i).getMemberpoint() - shopPrice);
					System.out.println("�ֹ��� �Ϸ�Ǿ����ϴ�");
				}else if(cash < shopPrice) {
					System.out.println("���� ����Ʈ�� �����մϴ�!");
				}
			}
		}
		return pay;
	}

}
