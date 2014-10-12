package com.moomoohk.jgeekcode.builders;

import com.moomoohk.jgeekcode.GeekCodeGrade;

/**
 *
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 10, 2014
 */
public class ExtremeGenericGeekCodeCategoryBuilder extends GenericGeekCodeCategoryBuilder
{
	public ExtremeGenericGeekCodeCategoryBuilder(String code, int minGrade, int maxGrade)
	{
		super(code, minGrade, maxGrade);
	}

	private int extreme;

	public GeekCodeCategory extreme(int level)
	{
		this.extreme = level;
		return subValidate(null);
	}

	@Override
	protected GeekCodeCategory subValidate(GeekCodeGrade grade)
	{
		return new ExtremeGeekCodeCategory(grade, this.extreme);
	}

	public class ExtremeGeekCodeCategory extends GeekCodeCategory
	{
		private final int extreme;

		private ExtremeGeekCodeCategory(GeekCodeGrade grade, int extreme)
		{
			super(grade);
			this.extreme = extreme;
		}

		@Override
		public String toString()
		{
			String st = super.toString();
			if (this.extreme > 0)
				for (int i = 1; i <= this.extreme; i++)
					st += "*";
			return st;
		}
	}
}
