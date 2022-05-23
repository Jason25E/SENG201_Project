import java.util.ArrayList;

/**
 * The class Player
 * Store the information of the player 
 * Stroe information of the MonsterList
 * Stroe information of the FoodList
 * Stroe information of the EquipmentList
 * @author fye15, zde19
 *
 */
public class Player {
	private String PlayerID;
	private int goldAmount;
	private int score;
	private int goldEarned;
	private ArrayList<Monster> MonsterList = new ArrayList<Monster>();
	private ArrayList<Item> FoodList = new ArrayList<Item>();
	private ArrayList<Item> EquipmentList = new ArrayList<Item>();
	private int maxMonstersCanHave = 4;
	
	/**
	 * The variable require one parameter
	 * @param playerName of the type String
	 * set the PlayerID to playerNmae
	 * set the score to 0
	 */
	public Player(String playerName) {
		PlayerID = playerName;
		score = 0;
	}
	
	/**
	 * The variable return the parameter of PlayerID
	 * @return
	 */
	public String getPlayerID() {
		return PlayerID;
	}
	
	/**
	 * The variable return the parameter of goldAmount
	 * @return
	 */
	public int getGoldAmount() {
		return goldAmount;
	}
	
	/**
	 * The variable return the parameter of goldEarned
	 * @return
	 */
	public int getGoldEarned() {
		return goldEarned;
	}
	
	/**
	 * The variable return the parameter of score
	 * @return
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * The variable return the parameter of MonsterList
	 * @return
	 */
	public ArrayList<Monster> getMonsterList() {
		return MonsterList;
	}
	
	/**
	 * The variable return the parameter of FoodList
	 * @return
	 */
	public ArrayList<Item> getFoodList() {
		return FoodList;
	}
	
	/**
	 * The variable return the parameter of EquipmentList
	 * @return
	 */
	public ArrayList<Item> getEquipmentList() {
		return EquipmentList;
	}
	
	/**
	 * The variable return the parameter of maxMonstersCanHave
	 * @return
	 */
	public int getMaxMonstersCanHave() {
		return maxMonstersCanHave;
	}
	
	/**
	 * The variable require one parameter
	 * @param name of the type String
	 * set the PlayerID to name
	 */
	public void setPlayerID(String name) {
		PlayerID = name;
	}
	
	/**
	 * The variable require one parameter
	 * @param amountGain of the type int
	 * set the score to amountGain
	 */
	public void gainScore(int amountGain) {
		score += amountGain;
	}
	
	/**
	 * The variable require one parameter
	 * @param startGold of the type int
	 * set the goldAmount to startGold
	 */
	public void setGoldAmount(int startGold) {
		goldAmount = startGold;
	}
	
	/**
	 * The variable require one parameter
	 * @param amountGain of the type int
	 * set the goldAmount to amountGain
	 * set the goldEarned to amountGain
	 */
	public void gainGold(int amountGain) {
		goldAmount += amountGain;
		goldEarned += amountGain;
	}
	
	/**
	 * The variable require one parameter
	 * @param amountUsed of the type int
	 * check if goldAmount is greater or equal to amountUsed
	 * yes, set goldAmount to amountUsed
	 */
	public void useGold(int amountUsed) {
		if (goldAmount >= amountUsed) {
			goldAmount -= amountUsed;
		}
	}
	
	/**
	 * The variable require one parameter
	 * @param newMonster of the type Monster
	 * check if size of the monster list is less or equal to maxMonstersCanHave -1
	 * yes, add a new monster to the moster list
	 */
	public void addMonster(Monster newMonster) {
		if (MonsterList.size() <= maxMonstersCanHave - 1) {
			MonsterList.add(newMonster);
		}
	}
	
	/**
	 * The variable require one parameter
	 * @param monster of the type Monster
	 * check if the size of the monster list the greater than 1
	 * yes, remove monster from monster list and return true
	 * no, return false
	 * @return
	 */
	public boolean removeMonster(Monster monster) {
		if (MonsterList.size() > 1) {
			MonsterList.remove(monster);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * The variable require two parameters
	 * @param newMonster of the type Monster
	 * @param goldUsed of the type int
	 * run the add monster to add new monster
	 * run use gold to reduce gold from the total amount
	 */
	public void buyMonster(Monster newMonster, int goldUsed) {
		addMonster(newMonster);
		useGold(goldUsed);
	}
	
	/**
	 * The variable require three parameters
	 * @param monster of the type monster
	 * @param goldGain of the type int
	 * @param MonsterEquipment of the type Equipment
	 */
	public void soldMonster(Monster monster, int goldGain, Equipment MonsterEquipment) {
		/**
		 * check if the remove monster returns true
		 * yes, run gain gold to add gold to total amount
		 */
		if (removeMonster(monster) == true) {
			gainGold(goldGain);
		}
		
		/**
		 * check if monster have equip an equipment
		 * yes, take the equipment off and run the gain quantity to add one to the equipment list
		 */
		if (MonsterEquipment != null) {
			for (Item i: EquipmentList) {
				if (i.getItemID() == MonsterEquipment.getItemID()) {
					i.gainQuantity();

				}
			}
		}
	}
	
	/**
	 * The variable require one parameter
	 * @param newItem of the type Item
	 * run add to add item to food list
	 */
	public void addFood(Item newItem) {
		FoodList.add(newItem);
	}
	
	/**
	 * The variable require one parameter
	 * @param newItem of the type Item
	 * run add to add item to equipment list
	 */
	public void addEquipment(Item newItem) {
		EquipmentList.add(newItem);
	}
	
	/**
	 * The variable require one parameter
	 * @param item of the type Item
	 * run reduceQuantity to reduce its quantity
	 */
	public void soldItem(Item item) {
		item.reduceQuantity();
		gainGold(item.getSellingPrice());
		
		/**
		 * Check if the number of item is 0
		 * yes, remove the item from the food list
		 */
		if (item.getQuantity() == 0) {
			FoodList.remove(item); 
		}
	}
	
	/**
	 * The variable require one parameter
	 * @param item of the type Item
	 * run reduceQuantity to reduce item quantity
	 */
	public void soldEquipment(Item item) {
		item.reduceQuantity();
		gainGold(item.getSellingPrice());

	}
	
	/**
	 * The variable require two parameters
	 * @param item of the type Item
	 * @param goldUsed of the type int
	 */
	public void buyFood(Item item, int goldUsed) {
		/**
		 * set inlist to false
		 * run a foor loop
		 * check if food id equlas to item id
		 * yes, run gainQuantity reducce quantity, run getSellingPrice get the item price, set inlist to true
		 */
		boolean inList = false;
		for (Item i: FoodList) {
			if (i.getItemID() == item.getItemID()) {
				i.gainQuantity();
				i.setSellingPrice(item.getSellingPrice());
				inList = true;
			}
		}
		
		/**
		 * check if inlist 
		 * false, add a new food to food list 
		 * run useGold to reduce gold from total gold
		 */
		if (inList ==  false) {
			addFood(item);
		}
		useGold(goldUsed);
	}
	
	/**
	 * The variable require two parameters
	 * @param item of the type Item
	 * @param goldUsed of the type int
	 * 
	 */
	public void buyEquipment(Item item, int goldUsed) {
		/**
		 * set inlist to false
		 * run a for loop
		 * check if equipment id equals item id 
		 * yes, run gainQuantity, getSellingPrice, set inlist to true
		 */
		boolean inList = false;
		for (Item i: EquipmentList) {
			if (i.getItemID() == item.getItemID()) {
				i.gainQuantity();
				i.setSellingPrice(item.getSellingPrice());
				inList = true;
			}
		}
		
		/**
		 * check if inlist equals to false
		 * yes, add item to equipment list 
		 * run use gold to reduce gold from total amount
		 */
		if (inList ==  false) {
			addEquipment(item);
		}
		useGold(goldUsed);
	}
	
	/**
	 * The variable require one parameter
	 * @param item of the type Item
	 * 
	 */
	public void useItem(Item item) {
		/**
		 * run reduceQuantity to reduce the quantity from item
		 * check if item quantity is equals to 0
		 * yes, remove item from food list
		 */
		item.reduceQuantity();
		if (item.getQuantity() == 0) {
			FoodList.remove(item); 

		}
	}
	
	/**
	 * The variable 
	 * run a for loop 
	 * check if the current health of the monster is less than 0 and canBattle is false
	 * yes, set canBattle to true
	 * return canBattle 
	 * @return
	 */
	public boolean canMonstersBattle() {
		boolean canBattle = false;
		for (Monster i: MonsterList) {
			if (i.getMonsterCurrentHealthPoint() > 0 && canBattle == false) {
				canBattle = true;
			}
		}
		return canBattle;
	}
	
	/**
	 * The variable 
	 * run a for loop 
	 * check if the current health of the monster is less than 0 and canBattle is false
	 * yes, set canBattle to true, set monster to the corresponding monster
	 * return monster 
	 * @return
	 */
	public Monster firstMonsterCanBattle() {
		boolean canBattle = false;
		Monster monster = null;
		for (Monster i: MonsterList) {
			if (i.getMonsterCurrentHealthPoint() > 0 && canBattle == false) {
				monster = i;
				canBattle = true;
			}
		}
		return monster;
	}
	
	/**
	 * The variable require one parameter
	 * @param monsterName of the type String
	 * 
	 * @return
	 */
	public boolean sameMonsterName(String monsterName) {
		/**
		 * set the same to false
		 * run a for loop
		 * check if the name of the monster is equls to the corresponding monster name
		 * yes, set same to true
		 * retunr same
		 */
		boolean same = false;
		for (Monster i: MonsterList) {
			if (monsterName.equals(i.getMonsterName())) {
				same = true;
			}
		}
		return same;
	}
}
