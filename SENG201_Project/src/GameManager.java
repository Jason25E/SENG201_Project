import java.util.ArrayList;

public class GameManager {
	private Player player;
	private int backgroundVolume;
	private int dayRemain;
	private int currentDay;
	private int difficulty;
	
	public GameManager(Player players,  int dayRemains, int difficultys)
	{
		player = players;
		dayRemain = dayRemains;
		difficulty = difficultys;
	}
	
	public void setBackgroundVolume(int volume)
	{
		backgroundVolume = volume;
	}
	
	public void reduceDayRemain()
	{
		if (dayRemain > 0) {
			dayRemain -= 1;
			currentDay += 1;
		}
	}
	
	public void sleep(ArrayList MonsterList)
	{

	}
	
	public void launchStartScreen()
	{
		
	}
	
	public void closeStartScreen(StartScreen)
	{
		
	}
	
	public void launchSetupScreen()
	{
		
	}
	
	public void closeSetupScreen(SetupScreen)
	{
		
	}
	
	public void launchChooseStarterScreen()
	{
		
	}
	
	public void closeChooseStarterScreen(ChooseStarterScreen)
	{
		
	}
	
	public void launchSettingScreen()
	{
		
	}
	
	public void closeSettingScreen(SettingScreen)
	{
		
	}
	
	public void launchMainScreen()
	{
		
	}
	
	public void closeMainScreen(MainScreen)
	{
		
	}
	
	public void launchShopScreen()
	{
		
	}
	
	public void closeShopScreen(ShopScreen)
	{
		
	}
	
	public void launchInventoryScreen()
	{
		
	}
	
	public void closeInventoryScreen(InventoryScreen)
	{
		
	}
	
	public void launchMonsterScreen()
	{
		
	}
	
	public void closeMonsterScreen(MonsterScreen)
	{
		
	}
	
	public void launchSelectBattleScreen()
	{
		
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
}
