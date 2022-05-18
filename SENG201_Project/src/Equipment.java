public class Equipment extends Item
{
	private int equipmentAttack;
	private int equipmentDefence;
	
	public Equipment(String equipmentName, String equipmentEffect, int purchasePrice, int sellingPrice, int attack, int defence)
	{
		super(equipmentName, equipmentEffect, purchasePrice, sellingPrice);
		equipmentAttack = attack;
		equipmentDefence = defence;
	}
	
	public int getEquipmentAttack()
	{
		return equipmentAttack;
	}
	
	public int getEquipmentDefence()
	{
		return equipmentDefence;
	}
}
