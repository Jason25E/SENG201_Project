import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GameManagerTest {
	
	private Player player = new Player("Tester");
	private GameManager testManager = new GameManager();
	
	@Test
	final GameManager testGameManager() {
		GameManager testManager = new GameManager();
		return testManager;
	}

	@Test
	final void testSetup() {
		testManager.Setup(player, 15, 10, 1, 10, 180);
	}

	@Test
	final void testReduceDayRemain() {
		testManager.Setup(player, 15, 10, 1, 10, 180);
		testManager.reduceDayRemain();
		assertEquals(14, testManager.getDayRemain());
	}

	@Test
	final void testRandomEvent() {
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", 1, "Common", 7, 10, 200, 60, slimeSkill);
		Monster slimey = new Monster("Slime", "Slimey", 1, "Common", 7, 10, 200, 60, slimeSkill);
		player.addMonster(slime);
		player.addMonster(slimey);
		testManager.Setup(player, 15, 10, 1, 10, 180);
		testManager.randomEvent();
	}
	
	@Test
	final void testSetBattleEnemyToFalse() {
		testManager.Setup(player, 15, 10, 1, 10, 180);
		testManager.setBattleEnemyToFalse();
		assertTrue(testManager.getBattleEnemy() == false);
		assertTrue(testManager.getBattleEnemyTwo() == false);
		assertTrue(testManager.getBattleEnemyThree() == false);
	}

	@Test
	final void testChangeBattleEnemy() {
		testManager.Setup(player, 15, 10, 1, 10, 180);
		testManager.changeBattleEnemy(true);
		assertTrue(testManager.getBattleEnemy());
	}

	@Test
	final void testChangeBattleEnemyTwo() {
		testManager.Setup(player, 15, 10, 1, 10, 180);
		testManager.changeBattleEnemyTwo(true);
		assertTrue(testManager.getBattleEnemyTwo());
	}

	@Test
	final void testChangeBattleEnemyThree() {
		testManager.Setup(player, 15, 10, 1, 10, 180);
		testManager.changeBattleEnemyThree(true);
		assertTrue(testManager.getBattleEnemyThree());
	}

	@Test
	final void testResetMonsterActivity() {
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", 1, "Common", 7, 10, 200, 60, slimeSkill);
		Monster slimey = new Monster("Slime", "Slimey", 1, "Common", 7, 10, 200, 60, slimeSkill);
		player.addMonster(slime);
		player.addMonster(slimey);
		testManager.Setup(player, 15, 10, 1, 10, 180);
		testManager.resetMonsterActivity();
		ArrayList<Monster> monsterList = player.getMonsterList();
		for (Monster i : monsterList) {
			assertEquals(0, i.getMonsterBattleAmountToday());
			assertTrue(i.getMonsterFaintedToday() == false);
		}
	}

	@Test
	final void testSleep() {
		testManager.Setup(player, 15, 10, 1, 10, 180);
		testManager.sleep();
		assertEquals(14, testManager.getDayRemain());
	}
	
	@Test
	final void testLaunchStartScreen()
	{
		StartScreen startScreen = new StartScreen(testManager);
	}
	
	@Test
	final void testLaunchSetupScreen()
	{
		SetupScreen setupScreen = new SetupScreen(testManager);
	}
	
	@Test
	final void testLaunchChooseStarterScreen()
	{
		testManager.Setup(player, 15, 10, 1, 10, 180);
		ChooseStarterScreen chooseStarterScreen = new ChooseStarterScreen(testManager);
	}
	
	@Test
	final void testLaunchMainScreen()
	{
		testManager.Setup(player, 15, 10, 1, 10, 180);
		MainScreen mainScreen = new MainScreen(testManager);
	}
	
	@Test
	final void testLaunchShopDirectionScreen() {
		testManager.Setup(player, 15, 10, 1, 10, 180);
		ShopDirection shopDirection = new ShopDirection(testManager);
	}
	
	@Test
	final void testLaunchShopMonsterScreen()
	{
		testManager.Setup(player, 15, 10, 1, 10, 180);
		ShopMonsterScreen shopMonsterScreen = new ShopMonsterScreen(testManager);
	}
	
	@Test
	final void testLaunchShopItemScreen()
	{
		testManager.Setup(player, 15, 10, 1, 10, 180);
		ShopItemScreen shopItemScreen = new ShopItemScreen(testManager);
	}
	
	@Test
	final void testLaunchMonsterScreen()
	{
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", 1, "Common", 7, 10, 200, 60, slimeSkill);
		Monster slimey = new Monster("Slime", "Slimey", 1, "Common", 7, 10, 200, 60, slimeSkill);
		player.addMonster(slime);
		player.addMonster(slimey);
		testManager.Setup(player, 15, 10, 1, 10, 180);
		MonsterScreen monsterScreen = new MonsterScreen(testManager);
	}
	
	@Test
	final void testLaunchItemScreen()
	{
		testManager.Setup(player, 15, 10, 1, 10, 180);
		ItemScreen itemScreen = new ItemScreen(testManager);
	}
	
	@Test
	final void testLaunchEquipmentScreen()
	{
		testManager.Setup(player, 15, 10, 1, 10, 180);
		EquipmentScreen equipmentScreen = new EquipmentScreen(testManager);
	}

	@Test
	final void testLaunchSaleMonsterScreen()
	{
		testManager.Setup(player, 15, 10, 1, 10, 180);
		SaleMonsterScreen saleMonsterScreen = new SaleMonsterScreen(testManager);
	}
	
	@Test
	final void testLaunchSaleItemScreen()
	{
		testManager.Setup(player, 15, 10, 1, 10, 180);
		SaleItemScreen SaleItemScreen = new SaleItemScreen(testManager);
	}
	
	@Test
	final void testLaunchaleEquipmentScreen()
	{
		testManager.Setup(player, 15, 10, 1, 10, 180);
		SaleEquipmentScreen saleEquipmentScreen = new SaleEquipmentScreen(testManager);
	}
	
	@Test
	final void testLaunchSelectBattleScreen()
	{
		testManager.Setup(player, 15, 10, 1, 10, 180);
		SelectBattleScreen selectBattleScreen = new SelectBattleScreen(testManager);
	}
	
	@Test
	final void testLaunchBattleScreen()
	{
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", 1, "Common", 7, 10, 200, 60, slimeSkill);
		Monster slimey = new Monster("Slime", "Slimey", 1, "Common", 7, 10, 200, 60, slimeSkill);
		player.addMonster(slime);
		player.addMonster(slimey);
		testManager.Setup(player, 15, 10, 1, 10, 180);
		BattleScreen battleScreen = new BattleScreen(testManager, slimey);
	}
	
	@Test
	final void testLaunchBattleResultScreen()
	{
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", 1, "Common", 7, 10, 200, 60, slimeSkill);
		Monster slimey = new Monster("Slime", "Slimey", 1, "Common", 7, 10, 200, 60, slimeSkill);
		player.addMonster(slime);
		player.addMonster(slimey);
		testManager.Setup(player, 15, 10, 1, 10, 180);
		BattleResultScreen battleResultScreen = new BattleResultScreen(testManager, slimey);
	}

	@Test
	final void testLaunchSummaryScreen()
	{
		testManager.Setup(player, 15, 10, 1, 10, 180);
		SummaryScreen summaryScreen = new SummaryScreen(testManager);
	}
}
