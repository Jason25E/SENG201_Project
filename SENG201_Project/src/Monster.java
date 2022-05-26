import java.util.ArrayList;

/**
 * The class Monster
 * Collect information of every monsters
 * Store them with correspond parameters
 * @author fye15, zde19
 *
 */
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
	private Equipment equipment;
	private Skill skill;
	
	/**
	 * The variable require nine paramters
	 * @param monsterID of the type String
	 * @param monsterName of the type String
	 * @param level of the type int
	 * @param rarity of the type String
	 * @param attack of the type int 
	 * @param defence of the type int
	 * @param maxHealthPoint of the type int
	 * @param healingAmount of the type int
	 * @param newSkill of the type Skill
	 */
	public Monster(String monsterID, String monsterName, int level, String rarity, int attack, int defence, int maxHealthPoint, int healingAmount, Skill newSkill) 
	{
		this.monsterID = monsterID;
		this.monsterName = monsterName;
		this.level = level;
		this.rarity = rarity;
		this.attack = attack;
		this.defence = defence;
		this.maxHealthPoint = maxHealthPoint;
		currentHealthPoint = maxHealthPoint;
		this.healingAmount = healingAmount;
		faintedToday = false;
		battleAmountToday = 0;
		equipment = null;
		skill = newSkill;
		
	}
	
	/**
	 * The variable return the parameter of monsterID
	 * @return
	 */
	public String getMonsterID() 
	{
		return monsterID;
	}
	
	/**
	 * The variable return the parameter of monsterName
	 * @return
	 */
	public String getMonsterName()
	{
		return monsterName;
	}
	
	/**
	 * The variable return the parameter of level
	 * @return
	 */
	public int getMonsterLevel()
	{
		return level;
	}
	
	/**
	 * The variable return the parameter of rarity
	 * @return
	 */
	public String getMonsterRarity()
	{
		return rarity;
	}
	
	/**
	 * The variable return the parameter of attack
	 * @return
	 */
	public int getMonsterAttack()
	{
		return attack;
	}
	
	/**
	 * The variable return the parameter of defence
	 * @return
	 */
	public int getMonsterDefence()
	{
		return defence;
	}
	
	/**
	 * The variable return the parameter of currentHealthPoint
	 * @return
	 */
	public int getMonsterCurrentHealthPoint()
	{
		return currentHealthPoint;
	}
	
	/**
	 * The variable return the parameter of maxHealthPoint
	 * @return
	 */
	public int getMonsterMaxHealthPoint()
	{
		return maxHealthPoint;
	}
	
	/**
	 * The variable return the parameter of healingAmount
	 * @return
	 */
	public int getMonsterHealingAmount()
	{
		return healingAmount;
	}
	
	/**
	 * The variable return the parameter of faintedToday
	 * @return
	 */
	public boolean getMonsterFaintedToday()
	{
		return faintedToday;
	}
	
	/**
	 * The variable return the parameter of battleAmountToday
	 * @return
	 */
	public int getMonsterBattleAmountToday()
	{
		return battleAmountToday;
	}
	
	/**
	 * The variable return the parameter of equipment
	 * @return
	 */
	public Equipment getMonsterEquipment()
	{
		return equipment;
	}
	
	public Skill getMonsterSkill()
	{
		return skill;
	}
	
	/**
	 * The variable when run
	 * add one to level
	 * add five to attack
	 * add 5 to defence
	 */
	public void levelUp() {
		level += 1;
		attack += 5;
		defence += 5;
		maxHealthPoint += 5;
		currentHealthPoint += 5;
	}
	
	/**
	 * The variable require one parameter
	 * @param amountHeal of the type int
	 * add amountHeal to currentHealthPoint
	 * check if the currentHealthPoint is greater than maxHealthPoint
	 * yes, set currentHealthPoint to maxHealthPoint
	 */
	public void heal(int amountHeal) {
		currentHealthPoint += amountHeal;
		if (currentHealthPoint > maxHealthPoint) {
			currentHealthPoint = maxHealthPoint;
		}
	}
	
	/**
	 * The variable getFullMonsterInfo
	 * set the monsterInfo string with correspond
	 * monsterName
	 * currentHealthPoint
	 * maxHealthPoint
	 * attack
	 * defence
	 * healingAmount
	 * skill name
	 * rarity
	 * return monsterInfo
	 * @return
	 */
	public String getFullMonsterInfo() {
		String monsterInfo = monsterName + "  Lv:" + level + "  HP: " + currentHealthPoint + "/" + maxHealthPoint + "   Attack: " + attack + "   Defence: " + defence + "   Healing: " + healingAmount + "   Skill: " + skill.getSkillName() + "   Rarity: " + rarity;
		return monsterInfo;
	}
	
	/**
	 * The variable getMonsterInfo
	 * set the monsterInfo string with correspond
	 * monsterName
	 * currentHealthPoint
	 * maxHealthPoint
	 * attack
	 * defence
	 * healingAmount
	 * skill name
	 * rarity
	 * return monsterInfo
	 * @return
	 */
	public String getMonsterInfo() {
		String monsterInfo = "Lv:" + level + "  HP: " + currentHealthPoint + "/" + maxHealthPoint + "   Attack: " + attack + "   Defence: " + defence + "   Healing: " + healingAmount + "   Skill: " + skill.getSkillName() + "   Rarity: " + rarity;
		return monsterInfo;
	}
	
	/**
	 * The variable require one parameter
	 * @param newName of the type String
	 * set the monsterName to newName
	 */
	public void setMonsterName(String newName) {
		monsterName = newName;
	}
	
	/**
	 * The variable require one parameter
	 * @param newEquipment of the type Equipment
	 * if equipment if not null
	 * run the gainQuantity and set it to equipment
	 * run getEquipmentAttack of the equipment and reduce it from attack
	 * run getEquipmentDefence of the equipment and reduce it from defence
	 * 
	 * set equipment to newEquipment
	 * run getEquipmentAttack of the equipment and add it from attack
	 * run getEquipmentDefence of the equipment and add it from defence
	 * run reduceQuantity to reduce one from the coresponding equipment
	 */
	public void setMonsterEquipment(Equipment newEquipment) 
	{
		if (equipment != null) {
			equipment.gainQuantity();
			attack -= equipment.getEquipmentAttack();
			defence -= equipment.getEquipmentDefence();
		}
		equipment = newEquipment;
		attack += newEquipment.getEquipmentAttack();
		defence += newEquipment.getEquipmentDefence();
		newEquipment.reduceQuantity();
	}
	
	/**
	 * The variable require two parameters
	 * @param food of the type Food
	 * @param player of the type Player
	 * run getAttackGain of the food and add it from attack
	 * run getDefenceGain of the food and add it from defence
	 * run heal for food healing
	 * reduce one from the foodlist
	 */
	public void useFood(Food food, Player player) {
		attack += food.getAttackGain();
		defence += food.getDefenceGain();
		heal(food.getHealingAmount());
		food.reduceQuantity();
		
		ArrayList<Item> FoodList = player.getFoodList();
		if (food.getQuantity() == 0) {
			FoodList.remove(food); 
		}
	}
	
	/**
	 * The variable require one parameter
	 * @param damageReceive of the type int
	 * reduce damageReceive from currentHealthPoint
	 * check if currentHealthPoint is less than 0
	 * yes, set currentHealthPoint to 0
	 */
	public void reduceCurrentHealthPoint(int damageReceive)
	{
		currentHealthPoint -= damageReceive;
		if (currentHealthPoint < 0) {
			currentHealthPoint = 0;
		}
	}
	
	/**
	 * The variable require one parameter
	 * @param value of the type int
	 * set the value to battleAmountToday
	 */
	public void setBattleAmountToday(int value) {
		battleAmountToday = value;
	}
	
	/**
	 * The variable
	 * add one to battleAmountToday
	 */
	public void addBattleAmountToday() {
		battleAmountToday += 1;
	}
	
	/**
	 * The variable require one parameter
	 * @param statue of the type boolean
	 * set the faintedToday to statue
	 */
	public void setfaintedToday(boolean statue) {
		faintedToday = statue;
	}
}
