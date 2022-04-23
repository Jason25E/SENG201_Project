public class Item {
	private String ItemID;
	private String ItemEffect;
	private int quantity;
	
	public Item(String ItemName, String effectDescription) {
		ItemID = ItemName;
		ItemEffect = effectDescription;
		quantity = 0;
	}
	
	public String getItemID() {
		return ItemID;
	}
	
	public String getItemEffect() {
		return ItemEffect;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void gainQuantity(int amountGain) {
		quantity += amountGain;
	}
	
	public void reduceQuantity() {
		quantity -= 1;
	}
}
