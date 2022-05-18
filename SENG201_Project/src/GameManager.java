import java.util.ArrayList;

public class GameManager {
	private Player player;
	private int dayRemain;
	private int currentDay;
	private String difficulty;
	private int startGold = 10;
	
	public int RandomFoodInShop = 1;
	public int RandomEquipmentInShop = 0 ;
	public int RandomEquipmentInShopTwo = 2;
	public int RandomMonsterInShop = 0;
	public int RandomMonsterInShopTwo = 2;
	public int RandomMonsterInShopThree = 4;
	
	
	public GameManager()
	{
		currentDay = 1;
	}
	
	public void Setup(Player player,  int dayRemain, String difficulty)
	{
		this.player = player;
		this.dayRemain = dayRemain;
		this.difficulty = difficulty;
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
	
	public String getDifficulty()
	{
		return difficulty;
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
	}
	
	public void sleep()
	{
		reduceDayRemain();
		generateRandomValueInShop();
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
	

	public void launchShopMonsterScreen()
	{
		ShopMonsterScreen shopMonsterScreen = new ShopMonsterScreen(this);
	}
	
	public void closeShopMonsterScreen(ShopMonsterScreen shopMonsterScreen)
	{
		shopMonsterScreen.closeWindow();
		launchMainScreen();
	}

	
	public void launchShopItemScreen()
	{
		ShopItemScreen shopItemScreen = new ShopItemScreen(this);
	}
	
	public void closeShopScreen(ShopItemScreen shopItemScreen)
	{
		shopItemScreen.closeWindow();
		launchMainScreen();
	}
	
	/*
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
	
	public void launchMonsterScreen()
	{
		MonsterScreen monsterScreen = new MonsterScreen(this);
	}
	
	public void closeMonsterScreen(MonsterScreen monsterScreen)
	{
		monsterScreen.closeWindow();
		launchMainScreen();
	}
	
	public void launchSelectBattleScreen()
	{
		SelectBattleScreen selectBattleScreen = new SelectBattleScreen(this);
	}
	
	public void closeSelectBattleScreen(SelectBattleScreen)
	{
		
	}
	
	public void launchBattleScreen()
	{
		
	}
	
	public void closeBattleScreen(BattleScreen)
	{
		
	}
	*/
	
	public static void main(String[] argv) {
		GameManager manager = new GameManager();
		manager.launchStartScreen();
	}
}
