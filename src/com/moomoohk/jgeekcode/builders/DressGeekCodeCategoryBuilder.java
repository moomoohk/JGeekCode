package com.moomoohk.jgeekcode.builders;

import com.moomoohk.jgeekcode.GeekCodeGrade;

public class DressGeekCodeCategoryBuilder extends GeekCodeCategoryBuilder
{
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
		}

		@Override
		public String toString()
		{
			return (DressGeekCodeCategoryBuilder.this.crossDresser ? DressGeekCodeCategoryBuilder.this.code + "x" : (DressGeekCodeCategoryBuilder.this.sameClothes ? "pu" : super.toString()));
		}
	}
}