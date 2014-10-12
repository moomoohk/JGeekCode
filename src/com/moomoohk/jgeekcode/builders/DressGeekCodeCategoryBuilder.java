package com.moomoohk.jgeekcode.builders;

import com.moomoohk.jgeekcode.GeekCodeGrade;

/**
 *
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 12, 2014
 */
public class DressGeekCodeCategoryBuilder extends GeekCodeCategoryBuilder
{
	public DressGeekCodeCategoryBuilder(String code, int minGrade, int maxGrade)
	{
		super(code, minGrade, maxGrade);
	}

	boolean crossDresser, sameClothes;

	public DressGeekCodeCategoryBuilder crossDresser()
	{
		this.crossDresser = true;
		return this;
	}

	public DressGeekCodeCategoryBuilder sameClothes()
	{
		this.sameClothes = true;
		return this;
	}

	@Override
	protected DressGeekCodeCategory subValidate(GeekCodeGrade grade)
	{
		return new DressGeekCodeCategory(grade);
	}

	public class DressGeekCodeCategory extends GeekCodeCategory
	{
		private DressGeekCodeCategory(GeekCodeGrade grade)
		{
			super(grade);
			if (DressGeekCodeCategoryBuilder.this.crossDresser)
				this.code += "x";
			if (DressGeekCodeCategoryBuilder.this.sameClothes)
				this.code += "pu";
		}
	}
}