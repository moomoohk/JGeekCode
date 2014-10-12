package com.moomoohk.jgeekcode.builders;

import com.moomoohk.jgeekcode.GeekCodeGrade;

/**
 *
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 10, 2014
 */
public class GenericGeekCodeCategoryBuilder extends GeekCodeCategoryBuilder
{
	public GenericGeekCodeCategoryBuilder(String code, int minGrade, int maxGrade)
	{
		super(code, minGrade, maxGrade);
	}

	@Override
	protected GeekCodeCategory subValidate(GeekCodeGrade grade)
	{
		return new GenericGeekCodeCategory(grade);
	}

	public class GenericGeekCodeCategory extends GeekCodeCategory
	{
		private GenericGeekCodeCategory(GeekCodeGrade grade)
		{
			super(grade);
		}
	}
}
