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
	private GeekCodeGrade roundness;

	public ShapeGeekCodeCategoryBuilder roundness(GeekCodeGrade roundness)
	{
		this.roundness = roundness;
		return this;
	}

	@Override
	protected GeekCodeCategory subValidate(GeekCodeGrade grade)
	{
		if (grade == null)
			throw new GeekCodeException("grade (height) not set!");
		if (this.roundness == null)
			throw new GeekCodeException("roundness not set!");
		if (this.roundness.getGrade() < this.minGrade || this.roundness.getGrade() > this.maxGrade)
			throw new IllegalArgumentException("roundness[" + grade.getGrade() + "] must fall within bounds: minGrade[" + this.minGrade + "], maxGrade[" + this.maxGrade + "]!");
		GeekCodeGradeAlt alt = new GeekCodeGradeAlt(grade, this.roundness);
		return new ShapeGeekCodeCategory(alt);
	}

	public class ShapeGeekCodeCategory extends GeekCodeCategory
	{
		private ShapeGeekCodeCategory(GeekCodeGrade grade)
		{
			super(grade);
		}
	}

	private static class GeekCodeGradeAlt extends GeekCodeGrade
	{
		private final GeekCodeGrade alt;

		public GeekCodeGradeAlt(GeekCodeGrade grade, GeekCodeGrade alt)
		{
			super(grade.getGrade());
			crossover(grade.getCrossover());
			wannabe(grade.getWannabe());
			this.alt = alt;
		}

		@Override
		public String toString()
		{
			return super.toString() + ":" + this.alt.toString();
		}
	}
}
