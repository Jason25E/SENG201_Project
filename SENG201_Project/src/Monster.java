public class Monster {
	private String monsterID;
	private String monsterName;
	private int level;
	private String rarity;
	private int attack;
	private int defence;
	private int maxHealthPoint;
	private int currentHealthPoint;
	private int healingAmount;
	private boolean faintedToday;
	private int battleAmountToday;
	private Equipment equipment = null;
	private Skill skill;
	
	public Monster(String monsterID, String monsterName, String rarity, int attack, int defence, int maxHealthPoint, int healingAmount, Skill newSkill) 
	{
		this.monsterID = monsterID;
		this.monsterName = monsterName;
		this.rarity = rarity;
		this.attack = attack;
		this.defence = defence;
		this.maxHealthPoint = maxHealthPoint;
		currentHealthPoint = maxHealthPoint;
		this.healingAmount = healingAmount;
		skill = newSkill;
	}
	
	public String getMonsterID() 
	{
		return monsterID;
	}
	
	public String getMonsterName()
	{
		return monsterName;
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
		return maxHealthPoint;
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
	
	public String getMonsterInfo() {
		String monsterInfo = "HP: " + currentHealthPoint + "/" + maxHealthPoint + "   Attack: " + attack + "   Defence: " + defence + "   Healing: " + healingAmount + "   Skill: " + skill.getSkillName() + "   Rarity: " + rarity;
		return monsterInfo;
	}
	
	public void setMonsterName(String newName) {
		monsterName = newName;
	}
	
	public void setMonsterEquipment(Equipment newEquipment) 
	{
		if (equipment != null) {
			attack -= equipment.getEquipmentAttack();
			defence -= equipment.getEquipmentDefence();
		}
		equipment = newEquipment;
		attack += newEquipment.getEquipmentAttack();
		defence += newEquipment.getEquipmentDefence();
	}
	
	public void useFood(Food food) {
		attack += food.getAttackGain();
		defence += food.getDefenceGain();
		currentHealthPoint += food.getHealingAmount();
		if (currentHealthPoint > maxHealthPoint) {
			currentHealthPoint = maxHealthPoint;
		}
	}
}
