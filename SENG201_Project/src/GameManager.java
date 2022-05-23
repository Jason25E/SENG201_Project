import java.util.ArrayList;

/**
 * The class GameManager
 * Control all settings and windows of the game
 * @author fye15, zde19
 *
 */
public class GameManager {
	private Player player;
	private int dayRemain;
	private int currentDay;
	private float shop_info;
	private float start_gold_info;
	private int monster_selling_info;
	private float monster_skill_rate;


	private int startGold;
	
	public int RandomFoodInShop = 1;
	public int RandomEquipmentInShop = 0 ;
	public int RandomEquipmentInShopTwo = 2;
	public int RandomMonsterInShop = 0;
	public int RandomMonsterInShopTwo = 2;
	public int RandomMonsterInShopThree = 4;
	
	public int RandomMonsterLevelInShop = 1;
    public int RandomMonsterLevelInShopTwo = 1;
	
	public int RandomEnemy = 1;
	public int RandomEnemyTwo = 2;
	public int RandomEnemyThree = 0;
	
	private boolean battleEnemy = false;
	private boolean battleEnemyTwo = false;
	private boolean battleEnemyThree = false;
	
	/**
	 * The variable set the parameter currentDay to the start day 1
	 */
	public GameManager()
	{
		currentDay = 1;
	}
	
	/**
	 * The variable require six parameters 
	 * @param player of the type Player
	 * @param dayRemain of the type int
	 * @param shop_info of the type float
	 * @param start_gold_info of the type float
	 * @param monster_selling_info of the type int
	 * @param monster_skill_rate of the type float
	 */
	public void Setup(Player player,  int dayRemain, float shop_info, float start_gold_info, int monster_selling_info, float monster_skill_rate)
	{
		this.player = player;
		this.dayRemain = dayRemain;
		this.shop_info = shop_info;
		this.monster_skill_rate = monster_skill_rate;
		this.start_gold_info = start_gold_info;
		this.monster_selling_info = monster_selling_info;
		this.startGold = Math.round(180 * start_gold_info);
		this.player.setGoldAmount(startGold);
	}
	
	/**
	 * The variable return the parameter player
	 * @return
	 */
	public Player getPlayer() 
	{
		return player;
	}
	
	/**
	 * The variable return the parameter dayRemain
	 * @return
	 */
	public int getDayRemain() 
	{
		return dayRemain;
	}
	
	/**
	 * The variable return the parameter currentDay
	 * @return
	 */
	public int getCurrentDay()
	{
		return currentDay;
	}
	
	/**
	 * The variable return the parameter shop_info
	 * @return
	 */
	public float getShop_info()
	{
		return shop_info;
	}
	
	/**
	 * The variable return the parameter battleEnemy
	 * @return
	 */
	public boolean getBattleEnemy()
	{
		return battleEnemy;
	}
	
	
	/**
	 * The variable return the parameter battleEnemyTwo
	 * @return
	 */
	public boolean getBattleEnemyTwo()
	{
		return battleEnemyTwo;
	}
	
	/**
	 * The variable return the parameter battleEnemyThree
	 * @return
	 */
	public boolean getBattleEnemyThree()
	{
		return battleEnemyThree;
	}
	
	/**
	 * The variable return the parameter monster_selling_info
	 * @return
	 */
	public int getMonster_selling_info()
	{
		return monster_selling_info;
	}
	
	/**
	 * The variable return the parameter monster_skill_rate
	 * @return
	 */
	public float getMonster_skill_rate()
	{
		return monster_skill_rate;
	}
	
	/**
	 * The variable return the parameter start_gold_info
	 * @return
	 */
	public float getStart_gold_info()
	{
		return start_gold_info;
	}
	
	/**
	 * The variable check 
	 * if the dayRemain is greater than 0
	 * yes, dayRemain - 1, currentDay + 1
	 * @return
	 */
	public void reduceDayRemain()
	{
		if (dayRemain > 0) {
			dayRemain -= 1;
			currentDay += 1;
		}
	}
	
	/**
	 * The variable claculate the parameters int random
	 * RandomFoodInShop
	 * RandomEquipmentInShop
	 * RandomEquipmentInShopTwo
	 * RandomMonsterInShop
	 * RandomMonsterInShopTwo
	 * RandomMonsterInShopThree
	 * RandomMonsterLevelInShop
	 * RandomMonsterLevelInShopTwos
	 * @return
	 */
	public void generateRandomValueInShop() {
        RandomFoodInShop = (int)((Math.random() * (4 - 1)) + 1);
        RandomEquipmentInShop = (int)((Math.random() * (4 - 0)) + 0);
        RandomEquipmentInShopTwo = (int)((Math.random() * (4 - 0)) + 0);
        RandomMonsterInShop = (int)((Math.random() * (6 - 0)) + 0);
        RandomMonsterInShopTwo = (int)((Math.random() * (6 - 0)) + 0);
        RandomMonsterInShopThree = (int)((Math.random() * (6 - 0)) + 0);
       
        RandomMonsterLevelInShop = (int)((Math.random() * (currentDay)) + 1);
        RandomMonsterLevelInShopTwo = (int)((Math.random() * (currentDay)) + 1);;
    }
	
	/**
	 * The variable claculate the parameters int random
	 * RandomEnemy
	 * RandomEnemyTwo
	 * RandomEnemyThree
	 * @return
	 */
	public void generateRandomEnemy() {
		RandomEnemy = (int)((Math.random() * (6 - 0)) + 0);
		RandomEnemyTwo = (int)((Math.random() * (6 - 0)) + 0);
		RandomEnemyThree = (int)((Math.random() * (6 - 0)) + 0);
	}
	
	/**
	 * The variable setBattleEnemyToFalse set the parameters of 
	 * battleEnemy
	 * battleEnemyTwo
	 * battleEnemyThree
	 * to flase
	 */
	public void setBattleEnemyToFalse() {
		battleEnemy = false;
		battleEnemyTwo = false;
		battleEnemyThree = false;
	}
	
	/**
	 * The variable require one parameter
	 * @param statue of the type boolean
	 * set the battleEnemy to statue
	 */
	public void changeBattleEnemy(boolean statue)
	{
		battleEnemy = statue;
	}
	
	/**
	 * The variable require one parameter
	 * @param statue of the type boolean
	 * set battleEnemyTwo = statue
	 */
	public void changeBattleEnemyTwo(boolean statue)
	{
		battleEnemyTwo = statue;
	}
	
	/**
	 * The variable require one parameter
	 * @param statue of the type boolean
	 * set battleEnemyThree = statue
	 */
	public void changeBattleEnemyThree(boolean statue)
	{
		battleEnemyThree = statue;
	}
	
	/**
	 * The variable reset the monster activity
	 * reset battle
	 * reset fainted
	 * reset heal
	 */
	public void resetMonsterActivity() {
		ArrayList<Monster> monsterList = player.getMonsterList();
		for (Monster i : monsterList) {
			i.setBattleAmountToday(0);
			i.setfaintedToday(false);
			i.heal(i.getMonsterHealingAmount());
		}
	}
	
	/**
	 * The variable return descriptionOfRandomEvent
	 * @return
	 */
	public String randomEvent() {
		int random;
		String descriptionOfRandomEvent = "";
		Monster leaveMonster = null;
		Monster joinMonster = null;
		ArrayList<Monster> monsterList = player.getMonsterList();
		for (Monster i : monsterList) {
			/**
			 * Chance a monster level up overnight depends on amount of battle participate today
			 */
			if (i.getMonsterBattleAmountToday() >= 2) {
				random = 1;
			} else if (i.getMonsterBattleAmountToday() == 1) {
				random = (int)((Math.random() * (2)) + 1);
			} else {
				random = (int)((Math.random() * (10)) + 1);
			}
			if (random <= 1) {
				i.levelUp();
				descriptionOfRandomEvent += i.getMonsterName() + " has level up. ";
			}
			
			/**
			 * Chance to a monster leave overnight depends on fainted or not today
			 */
			random = (int)((Math.random() * (100)) + 1);
			if (i.getMonsterFaintedToday() == true) {
				random = (int)((Math.random() * (70)) + 1);
			}
			if (random <= 5) {
				if (player.getMonsterList().size() > 1) {
					leaveMonster = i;
					descriptionOfRandomEvent += i.getMonsterName() + " has leave. ";
				}
			}
			
			/**
			 * Chance a new monster join overnight depends on how many free slot in party
			 */
			random = 6;
			if (player.getMonsterList().size() == 3) {
				random = (int)((Math.random() * (100)) + 1);
			} else if (player.getMonsterList().size() == 2) {
				random = (int)((Math.random() * (50)) + 1);
			} else if (player.getMonsterList().size() == 1) {
				random = (int)((Math.random() * (20)) + 1);
			}
			if (random <= 5) {
				String monsterName = "Slimey_" + (int)((Math.random() * (999)) + 1);
				Skill slimeSkill = new Skill("Grip", "Has a base power of 14", 14);
				Monster slime = new Monster("Slime", monsterName, 5, "Rare", 50, 50, 100, 80, slimeSkill);
				joinMonster = slime;
				descriptionOfRandomEvent += slime.getMonsterName() + " has join. ";
			}
		}
		
		/**
		 * Check if joinMonster is empty or not
		 */
		if (joinMonster != null) {
			player.addMonster(joinMonster);
		}
		
		/**
		 * Check if leaveMonster is empty or not
		 */
		if (leaveMonster != null) {
			player.getMonsterList().remove(leaveMonster);
		}
		
		return descriptionOfRandomEvent;
	}
	
	/**
	 * The variable run the following variables
	 * reduceDayRemain()
	 * generateRandomValueInShop()
	 * generateRandomEnemy()
	 * setBattleEnemyToFalse()
	 * resetMonsterActivity()
	 * randomEvent()
	 * 
	 * Set the descriptionOfRandomEvent the randomEvent()
	 * 
	 * Return descriptionOfRandomEvent
	 * @return
	 */
	public String sleep()
	{
		reduceDayRemain();
		generateRandomValueInShop();
		generateRandomEnemy();
		setBattleEnemyToFalse();
		String descriptionOfRandomEvent = randomEvent();
		resetMonsterActivity();
		
		return descriptionOfRandomEvent;
	}
	
	/**
	 * Control the launch and close of all screens
	 */
	public void launchStartScreen()
	{
		StartScreen startScreen = new StartScreen(this);
	}
	
	/**
	 * The variable require one parametr
	 * @param startScreen of the type StartScreen
	 * close the startScreen window
	 * launch SetupScreen 
	 */
	public void closeStartScreen(StartScreen startScreen)
	{
		startScreen.closeWindow();
		launchSetupScreen();
	}
	
	/**
	 * control the launch and clos of SetupScreen 
	 */
	public void launchSetupScreen()
	{
		SetupScreen setupScreen = new SetupScreen(this);
	}
	
	/**
	 * The variable require one parameter
	 * @param setupScreen of the type SetupScreen
	 * close the setupScreen window
	 * launch ChooseStarterScreen
	 */
	public void closeSetupScreen(SetupScreen setupScreen)
	{
		setupScreen.closeWindow();
		launchChooseStarterScreen();
	}
	
	/**
	 * Control the launch and close of ChooseStarterScreen
	 */
	public void launchChooseStarterScreen()
	{
		ChooseStarterScreen chooseStarterScreen = new ChooseStarterScreen(this);
	}
	
	/**
	 * The variable require one parameter
	 * @param chooseStarterScreen of the type ChooseStarterScreen
	 * close the chooseStarterScreen window
	 * launch MainScreen
	 */
	public void closeChooseStarterScreen(ChooseStarterScreen chooseStarterScreen)
	{
		chooseStarterScreen.closeWindow();
		launchMainScreen();
	}
	
	/**
	 * Control the close of MainScreen
	 */
	public void launchMainScreen()
	{
		MainScreen mainScreen = new MainScreen(this);
	}
	
	/**
	 * The variable require one parameter 
	 * @param mainScreen of the type MainScreen
	 * close the mainScreen window
	 */
	public void closeMainScreen(MainScreen mainScreen)
	{
		mainScreen.closeWindow();
	}
	
	/**
	 * Control the close of ShopDirection
	 */
	public void launchShopDirectionScreen() {
		ShopDirection shopDirection = new ShopDirection(this);
	}
	
	/**
	 * The variable require one parameter 
	 * @param shopDirection of the type ShopDirection
	 * close the shopDirection window
	 */
	public void closeShopDirectionScreen(ShopDirection shopDirection)
	{
		shopDirection.closeWindow();
	}
	
	/**
	 * Control the launch and close of ShopMonsterScreen
	 */
	public void launchShopMonsterScreen()
	{
		ShopMonsterScreen shopMonsterScreen = new ShopMonsterScreen(this);
	}
	
	/**
	 * The variable require one parameter 
	 * @param shopMonsterScreen of the type ShopMonsterScreen
	 * close shopMonsterScreen
	 * launch ShopDirectionScreen
	 */
	public void closeShopMonsterScreen(ShopMonsterScreen shopMonsterScreen)
	{
		shopMonsterScreen.closeWindow();
		launchShopDirectionScreen();
	}

	/**
	 * Control the launch and close of ShopItemScreen
	 */
	public void launchShopItemScreen()
	{
		ShopItemScreen shopItemScreen = new ShopItemScreen(this);
	}
	
	/**
	 * The variable require one parameter 
	 * @param shopItemScreen of the type ShopItemScreen
	 * close shopItemScreen
	 * launch ShopDirectionScreen
	 */
	public void closeShopItemScreen(ShopItemScreen shopItemScreen)
	{
		shopItemScreen.closeWindow();
		launchShopDirectionScreen();
	}
	
	/**
	 * Control the launch and close of MonsterScreen
	 */
	public void launchMonsterScreen()
	{
		MonsterScreen monsterScreen = new MonsterScreen(this);
	}
	
	/**
	 * The variable require one parameter 
	 * @param monsterScreen of the type MonsterScreen
	 * close MonsterScreen
	 * launch MainScreen
	 */
	public void closeMonsterScreen(MonsterScreen monsterScreen)
	{
		monsterScreen.closeWindow();
		launchMainScreen();
	}
	
	/**
	 * Control the launch and close of ItemScreen
	 */
	public void launchItemScreen()
	{
		ItemScreen itemScreen = new ItemScreen(this);
	}
	
	/**
	 * The variable require one parameter 
	 * @param itemScreen of the type ItemScreen
	 * close itemScreen
	 * launch MainScreen
	 */
	public void closeItemScreen(ItemScreen itemScreen)
	{
		itemScreen.closeWindow();
		launchMainScreen();
	}
	
	/**
	 * Control the launch and close of EquipmentScreen
	 */
	public void launchEquipmentScreen()
	{
		EquipmentScreen equipmentScreen = new EquipmentScreen(this);
	}
	
	/**
	 * The variable require one parameter 
	 * @param equipmentScreen of the type EquipmentScreen
	 * close equipmentScreen
	 * launch MainScreen
	 */
	public void closeEquipmentScreen(EquipmentScreen equipmentScreen)
	{
		equipmentScreen.closeWindow();
		launchMainScreen();
	}

	/**
	 * Control the launch and close of SaleMonsterScreen
	 */
	public void launchSaleMonsterScreen()
	{
		SaleMonsterScreen saleMonsterScreen = new SaleMonsterScreen(this);
	}
	
	/**
	 * The variable require one parameter 
	 * @param saleMonsterScreen of the type SaleMonsterScreen
	 * close saleMonsterScreen
	 * launch MainScreen
	 */
	public void closeSaleMonsterScreen(SaleMonsterScreen saleMonsterScreen)
	{
		saleMonsterScreen.closeWindow();
		launchMainScreen();
	}
	
	/**
	 * Control the launch and close of SaleItemScreen
	 */
	public void launchSaleItemScreen()
	{
		SaleItemScreen SaleItemScreen = new SaleItemScreen(this);
	}
	
	/**
	 * The variable require one parameter 
	 * @param SaleItemScreen of the type SaleItemScreen
	 * close SaleItemScreen
	 * launch MainScreen
	 */
	public void closeSaleItemScreen(SaleItemScreen SaleItemScreen)
	{
		SaleItemScreen.closeWindow();
		launchMainScreen();
	}
	
	/**
	 * Control the launch and close of SaleEquipmentScreen
	 */
	public void launchSaleEquipmentScreen()
	{
		SaleEquipmentScreen saleEquipmentScreen = new SaleEquipmentScreen(this);
	}
	
	/**
	 * The variable require one parameter 
	 * @param saleEquipmentScreen of the type SaleEquipmentScreen
	 * close saleEquipmentScreen
	 * launch MainScreen
	 */
	public void closeSaleEquipmentScreen(SaleEquipmentScreen saleEquipmentScreen)
	{
		saleEquipmentScreen.closeWindow();
		launchMainScreen();
	}

	/**
	 * Control the close of SelectBattleScreen
	 */
	public void launchSelectBattleScreen()
	{
		SelectBattleScreen selectBattleScreen = new SelectBattleScreen(this);
	}
	
	/**
	 * The variable require one parameter 
	 * @param selectBattleScreen of the type SelectBattleScreen
	 * close selectBattleScreen
	 */
	public void closeSelectBattleScreen(SelectBattleScreen selectBattleScreen)
	{
		selectBattleScreen.closeWindow();
	}
	
	/**
	 * Control the launch and close of BattleScreen
	 * variable require one parameter
	 * @param enemy of the type Monster
	 */
	public void launchBattleScreen(Monster enemy)
	{
		BattleScreen battleScreen = new BattleScreen(this, enemy);
	}
	
	/**
	 * The variable require one parameter 
	 * @param battleScreen of the type BattleScreen
	 * close battleScreen
	 */
	public void closeBattleScreen(BattleScreen battleScreen)
	{
		battleScreen.closeWindow();
	}
	
	/**
	 * Control the launch and close of BattleResultScreen
	 * variable require two parameter
	 * @param enemy of the type Monster
	 * @param battleScreen of the type BattleScreen
	 */
	public void launchBattleResultScreen(Monster enemy, BattleScreen battleScreen)
	{
		BattleResultScreen battleResultScreen = new BattleResultScreen(this, enemy);
		battleScreen.closeWindow();
	}
	
	/**
	 * The variable require one parameter 
	 * @param battleResultScreen of the type BattleResultScreen
	 * close battleResultScreen
	 */
	public void closeBattleResultScreen(BattleResultScreen battleResultScreen)
	{
		battleResultScreen.closeWindow();
	}
	
	/**
	 * Control the launch and close of SummaryScreen
	 */
	public void launchSummaryScreen()
	{
		SummaryScreen summaryScreen = new SummaryScreen(this);
	}
	
	/**
	 * The variable require one parameter 
	 * @param summaryScreen of the type SummaryScreen
	 * close summaryScreen
	 */
	public void closeSummaryScreen(SummaryScreen summaryScreen)
	{
		summaryScreen.closeWindow();
	}
	
	/**
	 * The variable require one parameter 
	 * @param argv of the type String[]
	 * create a new game 
	 * launch StartScreen
	 */
	public static void main(String[] argv) {
		GameManager manager = new GameManager();
		manager.launchStartScreen();
	}
}
