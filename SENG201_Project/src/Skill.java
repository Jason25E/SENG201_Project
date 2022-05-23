/**
 * The class Skill
 * Take the information of the skill from monster
 * Store in the coresponding parameters
 * @author fye15, zde19
 *
 */
public class Skill {
	private String skillName;
	private String skillEffect;
	private int skillDamage;
	
	public Skill(String skillNames, String skillEffects, int skillDamages)
	{
		skillName = skillNames;
		skillEffect = skillEffects;
		skillDamage = skillDamages;
	}
	
	public String getSkillName()
	{
		return skillName;
	}
	
	public String getSkillEffect()
	{
		return skillEffect;
	}
	
	public int getSkillDamage()
	{
		return skillDamage;
	}

}
