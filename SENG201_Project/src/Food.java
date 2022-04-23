
public class Food extends Item
{
	private int healingAmount;
	private int attackGain;
	private int defenceGain;
	
	public Food(String foodName, String foodEffect)
	{
		super(foodName, foodEffect);
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
