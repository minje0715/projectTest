package ProjectTest1;

import java.util.Objects;

// ȸ������ DTO
public class ShopingMemberDTO {
	String memberId; // ȸ�����̵�
	String memberPw; // ��й�ȣ
	String memberEmail; // �̸���
	String memberMobile; // ��ȣ
	String memberGender; // ����
	Long memberpoint; // ���� ����Ʈ

	ShopingMemberDTO() {

	}

	public ShopingMemberDTO(String memberId, String memberPw, String memberEmail, String memberMobile,
			String memberGender, Long memberpoint) {

		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberEmail = memberEmail;
		this.memberMobile = memberMobile;
		this.memberGender = memberGender;
		this.memberpoint = memberpoint;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberMobile() {
		return memberMobile;
	}

	public void setMemberMobile(String memberMobile) {
		this.memberMobile = memberMobile;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public Long getMemberpoint() {
		return memberpoint;
	}

	public void setMemberpoint(Long memberpoint) {
		this.memberpoint = memberpoint;
	}

	@Override
	public String toString() {
		return "[���̵�= " + memberId + ", ��й�ȣ= " + memberPw + ", �̸���= "
				+ memberEmail + ", �ڵ��� ��ȣ=" + memberMobile + ", ����=" + memberGender + ", ��������Ʈ="
				+ memberpoint + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(memberEmail, memberGender, memberId, memberMobile, memberPw, memberpoint);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopingMemberDTO other = (ShopingMemberDTO) obj;
		return Objects.equals(memberEmail, other.memberEmail)
				&& Objects.equals(memberGender, other.memberGender) && Objects.equals(memberId, other.memberId)
				&& Objects.equals(memberMobile, other.memberMobile) && Objects.equals(memberPw, other.memberPw)
				&& Objects.equals(memberpoint, other.memberpoint);
	}

}
