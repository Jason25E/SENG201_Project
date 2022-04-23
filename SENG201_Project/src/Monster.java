
public class Monster {
	private String monsterID;
	private int level;
	private String rarity;
	private int attack;
	private int defence;
	private int healthPoint;
	private int healingAmount;
	private boolean faintedToday;
	private int battleAmountToday;
	private Equipment equipment;
	private Skill skill;
	
	public Monster(String monsterName, String raritys, int attacks, int defences, int healthPoints, int healingAmounts, Skill newSkill) 
	{
		monsterID = monsterName;
		rarity = raritys;
		attack = attacks;
		defence = defences;
		healthPoint = healthPoints;
		healingAmount = healingAmounts;
		skill = newSkill;
	}
	
	public String getMonsterID() 
	{
		return monsterID;
	}
	
	public int getMonsterLevel()
	{
		return level;
	}
	
	public String getMonsterRarity()
	{
		return rarity;
	}
	
	public int getMonsterAttack()
	{
		return attack;
	}
	
	public int getMonsterDefence()
	{
		return defence;
	}
	
	public int getMonsterHealthPoint()
	{
		return healthPoint;
	}
	
	public int getMonsterHealingAmount()
	{
		return healingAmount;
	}
	
	public boolean getMonsterFaintedToday()
	{
		return faintedToday;
	}
	
	public int getMonsterBattleAmountToday()
	{
		return battleAmountToday;
	}
	
	public Equipment getMonsterEquipment()
	{
		return equipment;
	}
	
	public Skill getMonsterSkill()
	{
		return skill;
	}
	
	public void setMonsterEquipment(Equipment newEquipment) 
	{
		equipment = newEquipment;
	}
	
}
