/**
 * The class Item
 * Takes the information about item 
 * Store them to the correspond parameters
 * @author fye15, zde19
 *
 */
public class Item {
	private String ItemName;
	private String ItemEffect;
	private int quantity;
	private int purchasePrice;
	private int sellingPrice;
	
	/**
	 * The variable require four parameters 
	 * @param ItemName of the type String
	 * @param effectDescription of the type String
	 * @param purchasePrice of the type int 
	 * @param sellingPrice of the type int
	 */
	public Item(String ItemName, String effectDescription, int purchasePrice, int sellingPrice) {
		this.ItemName = ItemName;
		ItemEffect = effectDescription;
		quantity = 1;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
	}
	
	/**
	 * The variable return the parameter of ItemName
	 * @return
	 */
	public String getItemID() {
		return ItemName;
	}
	
	/**
	 * The variable return the parameter of ItemEffect
	 * @return
	 */
	public String getItemEffect() {
		return ItemEffect;
	}
	
	/**
	 * The variable return the parameter of quantity
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * The variable return the parameter of purchasePrice
	 * @return
	 */
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	/**
	 * The variable return the parameter of sellingPrice
	 * @return
	 */
	public int getSellingPrice() {
		return sellingPrice;
	}
	
	/**
	 * The variable require one parameter
	 * @param price of the type int
	 * set sellingPrice to price
	 */
	public void setSellingPrice(int price) {
		sellingPrice = price;
	}
	
	/**
	 * The variable 
	 * every time it runs
	 * add one to quantity 
	 */
	public void gainQuantity() {
		quantity += 1;
	}
	
	/**
	 * The variable
	 * check if the quantity if greater than 0
	 * yes, reduce one from quantity
	 */
	public void reduceQuantity() {
		if (quantity > 0) {
			quantity -= 1;
		}
	}
}
