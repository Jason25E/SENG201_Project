
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
