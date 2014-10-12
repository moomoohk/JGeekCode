/**
 *
 */
package com.moomoohk.jgeekcode;

/**
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 10, 2014
 */
public class GeekCodeGrade
{
	private final Integer grade;
	protected int minGrade, maxGrade;

	public GeekCodeGrade(int grade)
	{
		this.grade = grade;
	}

	public Integer getGrade()
	{
		return this.grade;
	}

	@Override
	public String toString()
	{
		String st = "";
		if (this.grade != null)
		{
			if (this.grade > 0)
				for (int i = 1; i <= this.grade; i++)
					st += "+";
			if (this.grade < 0)
				for (int i = -1; i >= this.grade; i--)
					st += "-";
		}
		return st;
	}
}
