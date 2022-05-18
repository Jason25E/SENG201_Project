
public class Food extends Item
{
	private int healingAmount;
	private int attackGain;
	private int defenceGain;
	
	public Food(String foodName, String foodEffect, int purchasePrice, int sellingPrice, int heal, int attack, int defence)
	{
		super(foodName, foodEffect, purchasePrice, sellingPrice);
		healingAmount = heal;
		attackGain = attack;
		defenceGain = defence;
	}
	
	public int getHealingAmount()
	{
		return healingAmount;
	}
	
	public int getAttackGain()
	{
		return attackGain;
	}
	
	public int getDefenceGain()
	{
		return defenceGain;
	}
}
