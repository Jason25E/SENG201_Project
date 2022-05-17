import java.util.ArrayList;

public class Player {
	private String PlayerID;
	private int goldAmount;
	private int score;
	private ArrayList<Monster> MonsterList = new ArrayList<Monster>();
	private ArrayList<Item> ItemList = new ArrayList<Item>();
	
	public Player(String playerName) {
		PlayerID = playerName;
		score = 0;
	}
	
	public String getPlayerID() {
		return PlayerID;
	}
	
	public int getGoldAmount() {
		return goldAmount;
	}
	
	public int getScore() {
		return score;
	}
	
	public ArrayList<Monster> getMonsterList() {
		return MonsterList;
	}
	
	public ArrayList<Item> getItemList() {
		return ItemList;
	}
	
	public void setPlayerID(String name) {
		PlayerID = name;
	}
	
	public void setGoldAmount(int startGold) {
		goldAmount = startGold;
	}
	
	public void gainGold(int amountGain) {
		goldAmount += amountGain;
	}
	
	public void useGold(int amountUsed) {
		goldAmount -= amountUsed;
	}
	
	public void addMonster(Monster newMonster) {
		MonsterList.add(newMonster);
	}
	
	public void removeMonster(Monster monster) {
		MonsterList.remove(monster);
	}
	
	public void buyMonster(Monster newMonster, int goldUsed) {
		addMonster(newMonster);
		useGold(goldUsed);
	}
	
	public void soldMonster(Monster monster, int goldGain) {
		removeMonster(monster);
		gainGold(goldGain);
	}
	
	public void addItem(Item newItem) {
		ItemList.add(newItem);
	}
	
	public void soldItem(Item item, int goldGain) {
		item.reduceQuantity();
		gainGold(goldGain);
	}
	
	public void buyItem(Item item, int goldUsed) {
		item.gainQuantity();
		useGold(goldUsed);
	}
	
	public void useItem(Item item, Monster monster) {
		item.reduceQuantity();

	}
}
