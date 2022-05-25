import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonsterTest {
	
	Skill testMonsterSkill = new Skill("Absorb", "Has a base power of 12", 12);
	Monster testMonster = new Monster("Slime", "Slime", 1, "Common", 7, 8, 200 , 60, testMonsterSkill);
	
	@Test
	final Monster testMonster() {
		Skill testMonsterSkill = new Skill("Absorb", "Has a base power of 12", 12);
		Monster testMonster = new Monster("Slime", "Slime", 1, "Common", 7, 8, 200 , 60, testMonsterSkill);
		return testMonster;
	}

	@Test
	final void testLevelUp() {
		testMonster.levelUp();
		assertEquals(2, testMonster.getMonsterLevel());
		assertEquals(12, testMonster.getMonsterAttack());
		assertEquals(13, testMonster.getMonsterDefence());
	}

	@Test
	final void testHeal() {
		testMonster.heal(100);
		assertEquals(200, testMonster.getMonsterCurrentHealthPoint());
	}

	@Test
	final void testGetFullMonsterInfo() {
		assertTrue(testMonster.getFullMonsterInfo().length() > 10);
	}

	@Test
	final void testGetMonsterInfo() {
		assertTrue(testMonster.getMonsterInfo().length() > 10);
	}

	@Test
	final void testSetMonsterName() {
		testMonster.setMonsterName("King Slime");
		assertTrue(testMonster.getMonsterName().equals("King Slime"));
		assertTrue(testMonster.getMonsterID().equals("Slime"));
	}

	@Test
	final void testSetMonsterEquipment() {
		Equipment equipment = new Equipment("Sword", "Increase 20 Attack when equip",100, 50, 20, 0);
		Equipment equipmentTwo = new Equipment("Axe", "Increase 40 Attack when equip",200, 100, 40, 0);
		testMonster.setMonsterEquipment(equipment);
		testMonster.setMonsterEquipment(equipmentTwo);
		assertTrue(testMonster.getMonsterEquipment().equals(equipmentTwo));
	}

	@Test
	final void testUseFood() {
		Player player = new Player("Tester");
		Food food = new Food("Watermelons", "Increase 20 Attack", 20, 10, 0, 20, 0);
		player.addFood(food);
		testMonster.useFood(food, player);
		assertEquals(27, testMonster.getMonsterAttack());
	}

	@Test
	final void testReduceCurrentHealthPoint() {
		testMonster.reduceCurrentHealthPoint(50);
		assertEquals(150, testMonster.getMonsterCurrentHealthPoint());
	}

	@Test
	final void testSetBattleAmountToday() {
		testMonster.setBattleAmountToday(3);
		assertEquals(3, testMonster.getMonsterBattleAmountToday());
	}

	@Test
	final void testAddBattleAmountToday() {
		testMonster.addBattleAmountToday();
		assertEquals(1, testMonster.getMonsterBattleAmountToday());
	}

	@Test
	final void testSetfaintedToday() {
		testMonster.setfaintedToday(true);
		assertTrue(testMonster.getMonsterFaintedToday());
	}

}
