package com.moomoohk.jgeekcode.builders;

import com.moomoohk.jgeekcode.GeekCodeException;
import com.moomoohk.jgeekcode.GeekCodeGrade;

/**
 *
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 10, 2014
 */
public class ShapeGeekCodeCategoryBuilder extends GeekCodeCategoryBuilder
{
	private BasicGeekCodeCategory roundness;

	public ShapeGeekCodeCategoryBuilder(String code, int minGrade, int maxGrade)
	{
		super(code, minGrade, maxGrade);
	}

	public ShapeGeekCodeCategoryBuilder roundness(BasicGeekCodeCategory roundness)
	{
		this.roundness = roundness;
		return this;
	}

	@Override
	public ShapeGeekCodeCategoryBuilder notRigid()
	{
		throw new GeekCodeException("Can't notRigid shape!");
	}

	@Override
	protected GeekCodeCategory subValidate(GeekCodeGrade grade)
	{
		if (grade == null)
			throw new GeekCodeException("grade (height) not set!");
		if (this.roundness == null)
			throw new GeekCodeException("roundness not set!");
		if (this.roundness.getGrade().getGrade() < this.minGrade || this.roundness.getGrade().getGrade() > this.maxGrade)
			throw new IllegalArgumentException("roundness[" + grade.getGrade() + "] must fall within bounds: minGrade[" + this.minGrade + "], maxGrade[" + this.maxGrade + "]!");
		return new ShapeGeekCodeCategory(grade, this.roundness);
	}

	public class ShapeGeekCodeCategory extends GeekCodeCategory
	{
		private final BasicGeekCodeCategory roundness;

		private ShapeGeekCodeCategory(GeekCodeGrade grade, BasicGeekCodeCategory roundness)
		{
			super(grade);
			this.roundness = roundness;
		}

		@Override
		public String toString()
		{
			return super.toString() + ":" + this.roundness;
		}
	}
}
