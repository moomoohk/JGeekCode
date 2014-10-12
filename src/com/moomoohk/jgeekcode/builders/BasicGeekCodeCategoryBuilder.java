package com.moomoohk.jgeekcode.builders;

import com.moomoohk.jgeekcode.GeekCodeException;
import com.moomoohk.jgeekcode.GeekCodeGrade;

/**
 *
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 12, 2014
 */
public class BasicGeekCodeCategoryBuilder
{
	protected boolean notRigid = false;
	protected boolean living = false;
	protected GeekCodeGrade crossover;

	public BasicGeekCodeCategoryBuilder notRigid()
	{
		if (this.notRigid)
			throw new GeekCodeException("notRigid already set!");
		this.notRigid = true;
		return this;
	}

	public BasicGeekCodeCategoryBuilder living()
	{
		if (this.living)
			throw new GeekCodeException("living already set!");
		this.living = true;
		return this;
	}

	public BasicGeekCodeCategoryBuilder crossover(GeekCodeGrade crossover)
	{
		this.crossover = crossover;
		return this;
	}

	public BasicGeekCodeCategory grade(GeekCodeGrade grade)
	{
		return new BasicGeekCodeCategory(grade);
	}

	public class BasicGeekCodeCategory
	{
		protected final GeekCodeGrade grade;

		protected BasicGeekCodeCategory(GeekCodeGrade grade)
		{
			this.grade = grade;
		}

		public GeekCodeGrade getGrade()
		{
			return this.grade;
		}

		@Override
		public String toString()
		{
			return (getGrade() != null ? getGrade().toString() : "") + (BasicGeekCodeCategoryBuilder.this.crossover != null ? "(" + BasicGeekCodeCategoryBuilder.this.crossover + ")" : "") + (BasicGeekCodeCategoryBuilder.this.living ? "$" : "")
					+ (BasicGeekCodeCategoryBuilder.this.notRigid ? "@" : "");
		}
	}
}
