import java.util.ArrayList;

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
	
	public GameManager()
	{
		currentDay = 1;
	}
	
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
	
	public Player getPlayer() 
	{
		return player;
	}
	
	public int getDayRemain() 
	{
		return dayRemain;
	}
	
	public int getCurrentDay()
	{
		return currentDay;
	}
	
	public float getShop_info()
	{
		return shop_info;
	}
	
	public boolean getBattleEnemy()
	{
		return battleEnemy;
	}
	
	public boolean getBattleEnemyTwo()
	{
		return battleEnemyTwo;
	}
	
	public boolean getBattleEnemyThree()
	{
		return battleEnemyThree;
	}
	
	public int getMonster_selling_info()
	{
		return monster_selling_info;
	}
	
	public float getMonster_skill_rate()
	{
		return monster_skill_rate;
	}
	
	public float getStart_gold_info()
	{
		return start_gold_info;
	}
	
	public void reduceDayRemain()
	{
		if (dayRemain > 0) {
			dayRemain -= 1;
			currentDay += 1;
		}
	}
	
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
	
	public void generateRandomEnemy() {
		RandomEnemy = (int)((Math.random() * (6 - 0)) + 0);
		RandomEnemyTwo = (int)((Math.random() * (6 - 0)) + 0);
		RandomEnemyThree = (int)((Math.random() * (6 - 0)) + 0);
	}
	
	public void setBattleEnemyToFalse() {
		battleEnemy = false;
		battleEnemyTwo = false;
		battleEnemyThree = false;
	}
	
	public void changeBattleEnemy(boolean statue)
	{
		battleEnemy = statue;
	}
	
	public void changeBattleEnemyTwo(boolean statue)
	{
		battleEnemyTwo = statue;
	}
	
	public void changeBattleEnemyThree(boolean statue)
	{
		battleEnemyThree = statue;
	}
	
	public void resetMonsterActivity() {
		ArrayList<Monster> monsterList = player.getMonsterList();
		for (Monster i : monsterList) {
			i.setBattleAmountToday(0);
			i.setfaintedToday(false);
			i.heal(i.getMonsterHealingAmount());
		}
	}
	
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
		if (joinMonster != null) {
			player.addMonster(joinMonster);
		}
		if (leaveMonster != null) {
			player.getMonsterList().remove(leaveMonster);
		}
		
		return descriptionOfRandomEvent;
	}
	
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
	
	public void closeStartScreen(StartScreen startScreen)
	{
		startScreen.closeWindow();
		launchSetupScreen();
	}
	
	public void launchSetupScreen()
	{
		SetupScreen setupScreen = new SetupScreen(this);
	}
	
	public void closeSetupScreen(SetupScreen setupScreen)
	{
		setupScreen.closeWindow();
		launchChooseStarterScreen();
	}
	
	public void launchChooseStarterScreen()
	{
		ChooseStarterScreen chooseStarterScreen = new ChooseStarterScreen(this);
	}
	
	public void closeChooseStarterScreen(ChooseStarterScreen chooseStarterScreen)
	{
		chooseStarterScreen.closeWindow();
		launchMainScreen();
	}
	
	public void launchMainScreen()
	{
		MainScreen mainScreen = new MainScreen(this);
	}
	
	public void closeMainScreen(MainScreen mainScreen)
	{
		mainScreen.closeWindow();
	}
	
	
	public void launchShopDirectionScreen() {
		ShopDirection shopDirection = new ShopDirection(this);
	}
	
	public void closeShopDirectionScreen(ShopDirection shopDirection)
	{
		shopDirection.closeWindow();
	}

	public void launchShopMonsterScreen()
	{
		ShopMonsterScreen shopMonsterScreen = new ShopMonsterScreen(this);
	}
	
	public void closeShopMonsterScreen(ShopMonsterScreen shopMonsterScreen)
	{
		shopMonsterScreen.closeWindow();
		launchShopDirectionScreen();
	}

	
	public void launchShopItemScreen()
	{
		ShopItemScreen shopItemScreen = new ShopItemScreen(this);
	}
	
	public void closeShopItemScreen(ShopItemScreen shopItemScreen)
	{
		shopItemScreen.closeWindow();
		launchShopDirectionScreen();
	}
	
	public void launchMonsterScreen()
	{
		MonsterScreen monsterScreen = new MonsterScreen(this);
	}
	
	public void closeMonsterScreen(MonsterScreen monsterScreen)
	{
		monsterScreen.closeWindow();
		launchMainScreen();
	}
	
	
	public void launchItemScreen()
	{
		ItemScreen itemScreen = new ItemScreen(this);
	}
	
	public void closeItemScreen(ItemScreen itemScreen)
	{
		itemScreen.closeWindow();
		launchMainScreen();
	}
	
	
	public void launchEquipmentScreen()
	{
		EquipmentScreen equipmentScreen = new EquipmentScreen(this);
	}
	
	public void closeEquipmentScreen(EquipmentScreen equipmentScreen)
	{
		equipmentScreen.closeWindow();
		launchMainScreen();
	}

	public void launchSaleMonsterScreen()
	{
		SaleMonsterScreen saleMonsterScreen = new SaleMonsterScreen(this);
	}
	
	public void closeSaleMonsterScreen(SaleMonsterScreen saleMonsterScreen)
	{
		saleMonsterScreen.closeWindow();
		launchMainScreen();
	}
	
	public void launchSaleItemScreen()
	{
		SaleItemScreen SaleItemScreen = new SaleItemScreen(this);
	}
	
	public void closeSaleItemScreen(SaleItemScreen SaleItemScreen)
	{
		SaleItemScreen.closeWindow();
		launchMainScreen();
	}
	
	public void launchSaleEquipmentScreen()
	{
		SaleEquipmentScreen saleEquipmentScreen = new SaleEquipmentScreen(this);
	}
	
	public void closeSaleEquipmentScreen(SaleEquipmentScreen saleEquipmentScreen)
	{
		saleEquipmentScreen.closeWindow();
		launchMainScreen();
	}

	
	public void launchSelectBattleScreen()
	{
		SelectBattleScreen selectBattleScreen = new SelectBattleScreen(this);
	}
	
	public void closeSelectBattleScreen(SelectBattleScreen selectBattleScreen)
	{
		selectBattleScreen.closeWindow();
	}
	

	public void launchBattleScreen(Monster enemy)
	{
		BattleScreen battleScreen = new BattleScreen(this, enemy);
	}
	
	public void closeBattleScreen(BattleScreen battleScreen)
	{
		battleScreen.closeWindow();
	}
	
	public void launchBattleResultScreen(Monster enemy, BattleScreen battleScreen)
	{
		BattleResultScreen battleResultScreen = new BattleResultScreen(this, enemy);
		battleScreen.closeWindow();
	}
	
	public void closeBattleResultScreen(BattleResultScreen battleResultScreen)
	{
		battleResultScreen.closeWindow();
	}
	
	public void launchSummaryScreen()
	{
		SummaryScreen summaryScreen = new SummaryScreen(this);
	}
	
	public void closeSummaryScreen(SummaryScreen summaryScreen)
	{
		summaryScreen.closeWindow();
	}

	public static void main(String[] argv) {
		GameManager manager = new GameManager();
		manager.launchStartScreen();
	}
}
