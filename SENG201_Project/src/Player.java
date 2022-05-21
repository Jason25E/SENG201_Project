import java.util.ArrayList;

public class Player {
	private String PlayerID;
	private int goldAmount;
	private int score;
	private ArrayList<Monster> MonsterList = new ArrayList<Monster>();
	private ArrayList<Item> FoodList = new ArrayList<Item>();
	private ArrayList<Item> EquipmentList = new ArrayList<Item>();
	private int maxMonstersCanHave = 4;
	
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
	
	public ArrayList<Item> getFoodList() {
		return FoodList;
	}
	
	public ArrayList<Item> getEquipmentList() {
		return EquipmentList;
	}
	
	public int getMaxMonstersCanHave() {
		return maxMonstersCanHave;
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
		if (goldAmount >= amountUsed) {
			goldAmount -= amountUsed;
		}
	}
	
	public void addMonster(Monster newMonster) {
		if (MonsterList.size() <= maxMonstersCanHave - 1) {
			MonsterList.add(newMonster);
		}
	}
	
	public boolean removeMonster(Monster monster) {
		if (MonsterList.size() > 1) {
			MonsterList.remove(monster);
			return true;
		} else {
			return false;
		}
	}
	
	public void buyMonster(Monster newMonster, int goldUsed) {
		addMonster(newMonster);
		useGold(goldUsed);
	}
	
	public void soldMonster(Monster monster, int goldGain) {
		if (removeMonster(monster) == true) {
			gainGold(goldGain);
		}
		
	}
	
	public void addFood(Item newItem) {
		FoodList.add(newItem);
	}
	
	public void addEquipment(Item newItem) {
		EquipmentList.add(newItem);
	}
	
	public void soldItem(Item item) {
		item.reduceQuantity();
		gainGold(item.getSellingPrice());
		if (item.getQuantity() == 0) {
			FoodList.remove(item); 
		}
	}
	
	public void soldEquipment(Item item) {
		item.reduceQuantity();
		gainGold(item.getSellingPrice());
		if (item.getQuantity() == 0) {
			EquipmentList.remove(item); 
		}
	}
	
	public void buyFood(Item item, int goldUsed) {
		boolean inList = false;
		for (Item i: FoodList) {
			if (i.getItemID() == item.getItemID()) {
				i.gainQuantity();
				i.setSellingPrice(item.getSellingPrice());
				inList = true;
			}
		}
		if (inList ==  false) {
			addFood(item);
		}
		useGold(goldUsed);
	}
	
	public void buyEquipment(Item item, int goldUsed) {
		boolean inList = false;
		for (Item i: EquipmentList) {
			if (i.getItemID() == item.getItemID()) {
				i.gainQuantity();
				i.setSellingPrice(item.getSellingPrice());
				inList = true;
			}
		}
		if (inList ==  false) {
			addEquipment(item);
		}
		useGold(goldUsed);
	}
	
	public void useItem(Item item) {
		item.reduceQuantity();
		if (item.getQuantity() == 0) {
			FoodList.remove(item); 

		}
	}
	
}
