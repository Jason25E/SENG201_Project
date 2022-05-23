/**
 * This class is implementing the Equipment 
 * extends for the class Item
 * Collect the information of every equipment
 * @author fye15, zde19
 *
 */
public class Equipment extends Item

{
	private int equipmentAttack;
	private int equipmentDefence;
	
	/**
	 * The variavle require six parameters
	 * @param equipmentName of the type String
	 * @param equipmentEffect of the type String
	 * @param purchasePrice of the type int
	 * @param sellingPrice of the type int
	 * @param attack of the type int
	 * @param defence of the type int
	 */
	public Equipment(String equipmentName, String equipmentEffect, int purchasePrice, int sellingPrice, int attack, int defence)
	{
		super(equipmentName, equipmentEffect, purchasePrice, sellingPrice);
		equipmentAttack = attack;
		equipmentDefence = defence;
	}
	
	/**
	 * The variable return the parameter equipmentAttack
	 * @return
	 */
	public int getEquipmentAttack()
	{
		return equipmentAttack;
	}
	
	/**
	 * The variable retunr the parameter equipmentDefence
	 * @return
	 */
	public int getEquipmentDefence()
	{
		return equipmentDefence;
	}
}
