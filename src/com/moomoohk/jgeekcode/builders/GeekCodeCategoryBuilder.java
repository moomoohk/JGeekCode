package com.moomoohk.jgeekcode.builders;

import com.moomoohk.jgeekcode.GeekCodeException;
import com.moomoohk.jgeekcode.GeekCodeGrade;

/*
 * GED/J d-- s:++>: a-- C++(++++) ULU++ P+ L++ E---- W+(-) N+++ o+ K+++ w--- O- M+ V-- PS++>$ PE++>$ Y++ PGP++ t- 5+++ X++ R+++>$ tv+ b+ DI+++ D+++ G++++ e++ h r-- y++**
 *
 * @
 *	for this variable, said trait is not very rigid, may change with time or with individual interaction. For example, Geeks who happen to very much enjoy Star Trek: The Next Generation, but dislike the old 60's series might list themselves as t++@.
 * ()
 *	for indicating "cross-overs" or ranges. Geeks who go from C+ to C--- depending on the situation (i.e. mostly "C+") could use C+(---). @ is different from () in that () has finite limits within the category, while @ ranges all over.
 * >
 *	for 'wannabe' ratings. Indicating that while the geek is currently at one rating, they are striving to reach another. For example, C++>$ indicating a geek that is currently computer savvy, but wants to someday make money at it.
 * $
 *	Indicates that this particular category is done for a living. For example, UL+++$ indicates that the person utilizes Unix and gets paid for it. Quite a lucky geek, for sure.
 * ?
 *	Unless stated otherwise within the specific category, the ? is placed after the category identifier and indicates that the geek has no knowledge about that specific category. For example, a person that has never even heard of Babylon 5, would list their Babylon 5 category as 5?
 * !
 *	Placed BEFORE the category. Unless stated otherwise, indicates that the person refuses to participate in this category. This is unlike the ? variable as the ? indicates lack of knowledge, while the ! indicates stubborn refusal to participate. For example, !E would be a person that just plain refuses to have anything to do with Emacs, while E? would be a person that doesn't even know what Emacs is.
 */

/**
 *
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 10, 2014
 */
public abstract class GeekCodeCategoryBuilder extends BasicGeekCodeCategoryBuilder
{
	protected String code;
	protected Integer minGrade, maxGrade;
	protected boolean noKnowledge = false;
	protected boolean refuse = false;
	protected BasicGeekCodeCategory crossover, wannabe;

	public GeekCodeCategoryBuilder(String code, int minGrade, int maxGrade)
	{
		if (code.trim().length() == 0)
			throw new GeekCodeException("code length must be > 0!");
		this.code = code;
		this.minGrade = minGrade;
		this.maxGrade = maxGrade;
	}

	@Override
	public GeekCodeCategoryBuilder notRigid()
	{
		return (GeekCodeCategoryBuilder) super.notRigid();
	}

	@Override
	public GeekCodeCategoryBuilder living()
	{
		return (GeekCodeCategoryBuilder) super.living();
	}

	public GeekCodeCategoryBuilder crossover(BasicGeekCodeCategory crossover)
	{
		this.crossover = crossover;
		return this;
	}

	public GeekCodeCategoryBuilder wannabe(BasicGeekCodeCategory wannabe)
	{
		this.wannabe = wannabe;
		return this;
	}

	public GeekCodeCategory noKnowledge()
	{
		if (this.notRigid || this.living)
			throw new GeekCodeException("Can't noKnowledge while (notRigid || living)!");
		this.noKnowledge = true;
		return grade(null);
	}

	public GeekCodeCategory refuse()
	{
		if (this.notRigid || this.living)
			throw new GeekCodeException("Can't refuse while (notRigid || living)!");
		this.refuse = true;
		return grade(null);
	}

	@Override
	public GeekCodeCategory grade(GeekCodeGrade grade)
	{
		if (this.code == null)
			throw new GeekCodeException("code not set!");
		if (this.minGrade == null)
			throw new GeekCodeException("minGrade not set!");
		if (this.maxGrade == null)
			throw new GeekCodeException("maxGrade not set!");
		if (this.minGrade > this.maxGrade)
			throw new IllegalArgumentException("minGrade[" + this.minGrade + "] must be smaller than maxGrade[" + this.maxGrade + "]!");
		if (grade != null && (grade.getGrade() < this.minGrade || grade.getGrade() > this.maxGrade))
			throw new IllegalArgumentException("grade[" + grade.getGrade() + "] must fall within bounds: minGrade[" + this.minGrade + "], maxGrade[" + this.maxGrade + "]!");
		return subValidate(grade);
	}

	protected abstract GeekCodeCategory subValidate(GeekCodeGrade grade);

	public class GeekCodeCategory extends BasicGeekCodeCategory
	{
		protected String code;

		protected GeekCodeCategory(GeekCodeGrade grade)
		{
			super(grade);
			this.code = GeekCodeCategoryBuilder.this.code;
		}

		public String getCode()
		{
			return this.code;
		}

		@Override
		public GeekCodeGrade getGrade()
		{
			return this.grade;
		}

		@Override
		public String toString()
		{
			return (GeekCodeCategoryBuilder.this.refuse ? "!" : "") + this.code + super.toString() + (GeekCodeCategoryBuilder.this.crossover != null ? "(" + GeekCodeCategoryBuilder.this.crossover + ")" : "") + (GeekCodeCategoryBuilder.this.noKnowledge ? "?" : "")
					+ (GeekCodeCategoryBuilder.this.wannabe != null ? ">" + GeekCodeCategoryBuilder.this.wannabe : "");
		}
	}
}
