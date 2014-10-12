package com.moomoohk.jgeekcode.builders;

import com.moomoohk.jgeekcode.GeekCodeGrade;

/**
 *
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 10, 2014
 */
public class StarTrekGeekCodeCategoryBuilder extends ExtremeGenericGeekCodeCategoryBuilder
{
	private boolean barclay;

	public StarTrekGeekCodeCategoryBuilder(String code, int minGrade, int maxGrade)
	{
		super(code, minGrade, maxGrade);
	}

	public GeekCodeCategory extreme()
	{
		this.barclay = true;
		return subValidate(null);
	}

	@Override
	protected GeekCodeCategory subValidate(GeekCodeGrade grade)
	{
		return new StarTrekGeekCodeCategory(grade, this.barclay);
	}

	public class StarTrekGeekCodeCategory extends GeekCodeCategory
	{
		private final boolean barclay;

		private StarTrekGeekCodeCategory(GeekCodeGrade grade, boolean barclay)
		{
			super(grade);
			this.barclay = barclay;
		}

		@Override
		public String toString()
		{
			return (this.barclay ? this.code + "*" : super.toString());
		}
	}
}
