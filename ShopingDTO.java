package ProjectTest1;

import java.util.Objects;

// 장바구니 DTO
public class ShopingDTO {
	int shopId; // 상품넘버
	String shopName; // 상품이름
	String shopTitle; // 상품설명
	Long shopPrice; // 상품가격
	String shopStar; // 별점

	ShopingDTO() {

	}

	public ShopingDTO(int shopId, String shopName, String shopTitle, Long shopPrice, String shopStar) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.shopTitle = shopTitle;
		this.shopPrice = shopPrice;
		this.shopStar = shopStar;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopTitle() {
		return shopTitle;
	}

	public void setShopTitle(String shopTitle) {
		this.shopTitle = shopTitle;
	}

	public Long getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(Long shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getShopStar() {
		return shopStar;
	}

	public void setShopStar(String shopStar) {
		this.shopStar = shopStar;
	}

	@Override
	public String toString() {
		return "[상품번호= " + shopId + " 상품이름= " + shopName + " 상품설명= " + shopTitle + " 상품가격= "
				+ shopPrice + " 평균별점= " + shopStar + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(shopId, shopName, shopPrice, shopStar, shopTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopingDTO other = (ShopingDTO) obj;
		return shopId == other.shopId && Objects.equals(shopName, other.shopName)
				&& Objects.equals(shopPrice, other.shopPrice) && Objects.equals(shopStar, other.shopStar)
				&& Objects.equals(shopTitle, other.shopTitle);
	}

	
}