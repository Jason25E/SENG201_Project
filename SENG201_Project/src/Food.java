/**
 * The class Food
 * extends the class Item
 * Set up the food information
 * @author fye15, zde19
 *
 */
public class Food extends Item
{
	private int healingAmount;
	private int attackGain;
	private int defenceGain;
	
	/**
	 * The variable Food require seven parameters
	 * @param foodName of the type String
	 * @param foodEffect of the type String
	 * @param purchasePrice of the type int
	 * @param sellingPrice of the type int
	 * @param heal of the type int
	 * @param attack of the type int 
	 * @param defence of the type int
	 */
	public Food(String foodName, String foodEffect, int purchasePrice, int sellingPrice, int heal, int attack, int defence)
	{
		super(foodName, foodEffect, purchasePrice, sellingPrice);
		healingAmount = heal;
		attackGain = attack;
		defenceGain = defence;
	}
	
	/**
	 * The variable return the parameter healingAmount
	 * @return
	 */
	public int getHealingAmount()
	{
		return healingAmount;
	}
	
	/**
	 * The variable return the parameter attackGain
	 * @return
	 */
	public int getAttackGain()
	{
		return attackGain;
	}
	
	/**
	 * The variable return the parameter defenceGain
	 * @return
	 */
	public int getDefenceGain()
	{
		return defenceGain;
	}
}
