package com.moomoohk.jgeekcode.builders;

import com.moomoohk.jgeekcode.GeekCodeGrade;

public class BasicGeekCodeCategoryBuilder
{
	protected boolean notRigid = false;
	protected boolean living = false;

	public BasicGeekCodeCategoryBuilder notRigid()
	{
		this.notRigid = true;
		return this;
	}

	public BasicGeekCodeCategoryBuilder living()
	{
		this.living = true;
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
			return (getGrade() != null ? getGrade().toString() : "") + (BasicGeekCodeCategoryBuilder.this.living ? "$" : "") + (BasicGeekCodeCategoryBuilder.this.notRigid ? "@" : "");
		}
	}
}
