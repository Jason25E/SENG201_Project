public class Item {
	private String ItemName;
	private String ItemEffect;
	private int quantity;
	private int purchasePrice;
	private int sellingPrice;
	
	public Item(String ItemName, String effectDescription, int purchasePrice, int sellingPrice) {
		this.ItemName = ItemName;
		ItemEffect = effectDescription;
		quantity = 1;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
	}
	
	public String getItemID() {
		return ItemName;
	}
	
	public String getItemEffect() {
		return ItemEffect;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	public int getSellingPrice() {
		return sellingPrice;
	}
	
	public void setSellingPrice(int price) {
		sellingPrice = price;
	}
	
	public void gainQuantity() {
		quantity += 1;
	}
	
	public void reduceQuantity() {
		if (quantity > 0) {
			quantity -= 1;
		}
	}
}
