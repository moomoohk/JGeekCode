package com.moomoohk.jgeekcode.builders;

import com.moomoohk.jgeekcode.GeekCodeGrade;

/**
 *
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 10, 2014
 */
public class SexGeekCodeCategoryBuilder extends ExtremeGenericGeekCodeCategoryBuilder
{
	public SexGeekCodeCategoryBuilder(String code, int minGrade, int maxGrade)
	{
		super(code, minGrade, maxGrade);
	}

	private static enum Gender
	{
		x, y, z;
	}

	private Gender gender = Gender.z;

	public GeekCodeCategory male(GeekCodeGrade grade)
	{
		this.gender = Gender.y;
		return subValidate(grade);
	}

	public GeekCodeCategory female(GeekCodeGrade grade)
	{
		this.gender = Gender.x;
		return subValidate(grade);
	}

	@Override
	protected GeekCodeCategory subValidate(GeekCodeGrade grade)
	{
		return new SexGeekCodeCategory(grade, this.gender);
	}

	private class SexGeekCodeCategory extends GeekCodeCategory
	{
		protected SexGeekCodeCategory(GeekCodeGrade grade, Gender gender)
		{
			super(grade);
			this.code = gender.toString().toLowerCase();
		}
	}
}
