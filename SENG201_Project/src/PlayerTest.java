import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PlayerTest {
	private Player testPlayer = new Player("Tester");
	
	@Test
	final Player testPlayer() {
		Player testPlayer = new Player("Ultimate Tester");
		return testPlayer;
	}

	@Test
	final String testGetPlayerID() {
		return testPlayer.getPlayerID();
	}

	@Test
	final int testGetGoldAmount() {
		return testPlayer.getGoldAmount();
	}

	@Test
	final int testGetGoldEarned() {
		testPlayer.setGoldAmount(10);
		testPlayer.gainGold(20);
		return testPlayer.getGoldEarned();
	}

	@Test
	final int testGetScore() {
		return testPlayer.getScore();
	}

	@Test
	final ArrayList<Monster> testGetMonsterList() {
		return testPlayer.getMonsterList();
	}

	@Test
	final ArrayList<Item> testGetFoodList() {
		return testPlayer.getFoodList();
	}

	@Test
	final ArrayList<Item> testGetEquipmentList() {
		return testPlayer.getEquipmentList();
	}

	@Test
	final int testGetMaxMonstersCanHave() {
		return testPlayer.getMaxMonstersCanHave();
	}

	@Test
	final void testSetPlayerID() {
		testPlayer.setPlayerID("New Player");
		assertTrue(testPlayer.getPlayerID().equals("New Player"));
	}

	@Test
	final void testGainScore() {
		testPlayer.gainScore(100);
		assertEquals(100, testPlayer.getScore());
	}

	@Test
	final void testSetGoldAmount() {
		testPlayer.setGoldAmount(27);
		assertEquals(27, testPlayer.getGoldAmount());
	}

	@Test
	final void testGainGold() {
		testPlayer.gainGold(58);
		assertEquals(58, testPlayer.getGoldAmount());
	}

	@Test
	final void testUseGold() {
		testPlayer.setGoldAmount(88);
		testPlayer.useGold(12);
		assertEquals(76, testPlayer.getGoldAmount());
	}

	@Test
	final void testAddMonster() {
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", 1, "Common", 7, 10, 200, 60, slimeSkill);
		testPlayer.addMonster(slime);
		assertTrue(testPlayer.getMonsterList().contains(slime));
	}

	@Test
	final void testRemoveMonster() {
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", 1, "Common", 7, 10, 200, 60, slimeSkill);
		Monster slimey = new Monster("Slime", "Slimey", 1, "Common", 7, 10, 200, 60, slimeSkill);
		testPlayer.addMonster(slime);
		testPlayer.addMonster(slimey);
		testPlayer.removeMonster(slime);
		assertEquals(1, testPlayer.getMonsterList().size());
	}

	@Test
	final void testBuyMonster() {
		testPlayer.setGoldAmount(88);
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", 1, "Common", 7, 10, 200, 60, slimeSkill);
		testPlayer.buyMonster(slime, 78);
		assertTrue(testPlayer.getMonsterList().contains(slime));
		assertEquals(10, testPlayer.getGoldAmount());
	}

	@Test
	final void testSoldMonster() {
		testPlayer.setGoldAmount(100);
		Equipment equipment = new Equipment("Sword", "Increase 20 Attack when equip",100, 50, 20, 0);
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", 1, "Common", 7, 10, 200, 60, slimeSkill);
		Monster slimey = new Monster("Slime", "Slimey", 1, "Common", 7, 10, 200, 60, slimeSkill);
		testPlayer.addEquipment(equipment);
		slime.setMonsterEquipment(equipment);
		testPlayer.addMonster(slime);
		testPlayer.addMonster(slimey);
		testPlayer.soldMonster(slime, 55, equipment);
		assertEquals(1, testPlayer.getMonsterList().size());
		assertEquals(155, testPlayer.getGoldAmount());
	}

	@Test
	final void testAddFood() {
		Food food = new Food("Watermelons", "Recover 20 HP", 20, 10, 20, 0, 0);
		testPlayer.addFood(food);
		assertEquals(1, testPlayer.getFoodList().size());
	}

	@Test
	final void testAddEquipment() {
		Equipment equipment = new Equipment("Sword", "Increase 20 Attack when equip",100, 50, 20, 0);
		testPlayer.addEquipment(equipment);
		assertEquals(1, testPlayer.getEquipmentList().size());
	}

	@Test
	final void testSoldItem() {
		testPlayer.setGoldAmount(23);
		Food food = new Food("Watermelons", "Recover 20 HP", 20, 10, 20, 0, 0);
		testPlayer.soldItem(food);
		assertEquals(0, testPlayer.getFoodList().size());
		assertEquals(33, testPlayer.getGoldAmount());
	}

	@Test
	final void testSoldEquipment() {
		testPlayer.setGoldAmount(53);
		Equipment equipment = new Equipment("Sword", "Increase 20 Attack when equip",100, 50, 20, 0);
		testPlayer.addEquipment(equipment);
		testPlayer.soldEquipment(equipment);
		assertEquals(0, equipment.getQuantity());
		assertEquals(103, testPlayer.getGoldAmount());
	}

	@Test
	final void testBuyFood() {
		testPlayer.setGoldAmount(50);
		Food food = new Food("Watermelons", "Recover 20 HP", 20, 10, 20, 0, 0);
		testPlayer.buyFood(food, food.getPurchasePrice());
		testPlayer.buyFood(food, food.getPurchasePrice());
		assertEquals(1, testPlayer.getFoodList().size());
		assertEquals(2, testPlayer.getFoodList().get(0).getQuantity());
		assertEquals(10, testPlayer.getGoldAmount());
	}

	@Test
	final void testBuyEquipment() {
		testPlayer.setGoldAmount(270);
		Equipment equipment = new Equipment("Sword", "Increase 20 Attack when equip",100, 50, 20, 0);
		testPlayer.buyEquipment(equipment, equipment.getPurchasePrice());
		testPlayer.buyEquipment(equipment, equipment.getPurchasePrice());
		assertEquals(1, testPlayer.getEquipmentList().size());
		assertEquals(2, testPlayer.getEquipmentList().get(0).getQuantity());
		assertEquals(70, testPlayer.getGoldAmount());
	}

	@Test
	final void testUseItem() {
		Food food = new Food("Watermelons", "Recover 20 HP", 20, 10, 20, 0, 0);
		testPlayer.addFood(food);
		testPlayer.useItem(food);
		assertEquals(0, testPlayer.getFoodList().size());
	}

	@Test
	final void testCanMonstersBattle() {
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", 1, "Common", 7, 10, 200, 60, slimeSkill);
		testPlayer.addMonster(slime);
		assertTrue(testPlayer.canMonstersBattle());
	}

	@Test
	final void testFirstMonsterCanBattle() {
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", 1, "Common", 7, 10, 200, 60, slimeSkill);
		testPlayer.addMonster(slime);
		assertTrue(testPlayer.firstMonsterCanBattle().equals(slime));
	}

	@Test
	final void testSameMonsterName() {
		Skill slimeSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster slime = new Monster("Slime", "Slime", 1, "Common", 7, 10, 200, 60, slimeSkill);
		testPlayer.addMonster(slime);
		assertTrue(testPlayer.sameMonsterName("Slime"));
	}
}
