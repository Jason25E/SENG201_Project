
public class Equipment extends Item
{
	private int equipmentDefence;
	
	public Equipment(String equipmentName, String equipmentEffect)
	{
		super(equipmentName, equipmentEffect);
	}
	
	public int getEquipmentDefence()
	{
		return equipmentDefence;
	}
}
