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
	private GeekCodeGrade crossover, wannabe;

	public GeekCodeGrade(int grade)
	{
		this.grade = grade;
	}

	public GeekCodeGrade crossover(GeekCodeGrade crossover)
	{
		this.crossover = crossover;
		return this;
	}

	public GeekCodeGrade wannabe(GeekCodeGrade wannabe)
	{
		this.wannabe = wannabe;
		return this;
	}

	public Integer getGrade()
	{
		return this.grade;
	}

	public GeekCodeGrade getCrossover()
	{
		return this.crossover;
	}

	public GeekCodeGrade getWannabe()
	{
		return this.wannabe;
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
		if (this.crossover != null)
			st += "(" + this.crossover + ")";
		if (this.wannabe != null)
			st += ">" + this.wannabe;
		return st;
	}
}
