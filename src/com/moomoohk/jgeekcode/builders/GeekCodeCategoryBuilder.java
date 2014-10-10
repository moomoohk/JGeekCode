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
public abstract class GeekCodeCategoryBuilder
{
	protected String code;
	protected boolean notRigid = false;
	protected boolean living = false;
	protected boolean noKnowledge = false;
	protected boolean refuse = false;
	protected Integer minGrade, maxGrade;

	public GeekCodeCategoryBuilder code(String code)
	{
		if (code.trim().length() == 0)
			throw new GeekCodeException("code length must be > 0!");
		this.code = code;
		return this;
	}

	public GeekCodeCategoryBuilder notRigid()
	{
		this.notRigid = true;
		return this;
	}

	public GeekCodeCategoryBuilder living()
	{
		this.living = true;
		return this;
	}

	public GeekCodeCategoryBuilder minGrade(int minGrade)
	{
		this.minGrade = minGrade;
		return this;
	}

	public GeekCodeCategoryBuilder maxGrade(int maxGrade)
	{
		this.maxGrade = maxGrade;
		return this;
	}

	public GeekCodeCategory noKnowledge()
	{
		if (this.notRigid || this.living)
			throw new GeekCodeException("Can't noKnowledge while (notRigid || living)!");
		this.noKnowledge = true;
		return validate(null);
	}

	public GeekCodeCategory refuse()
	{
		if (this.notRigid || this.living)
			throw new GeekCodeException("Can't refuse while (notRigid || living)!");
		this.refuse = true;
		return validate(null);
	}

	public GeekCodeCategory validate(GeekCodeGrade grade)
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

	public class GeekCodeCategory
	{
		protected String code;
		protected final GeekCodeGrade grade;

		protected GeekCodeCategory(GeekCodeGrade grade)
		{
			this.grade = grade;
			this.code = GeekCodeCategoryBuilder.this.code;
		}

		public String getCode()
		{
			return this.code;
		}

		public GeekCodeGrade getGrade()
		{
			return this.grade;
		}

		@Override
		public String toString()
		{
			return ((GeekCodeCategoryBuilder.this.refuse ? "!" : "") + this.code + (getGrade() != null ? getGrade() : "") + (GeekCodeCategoryBuilder.this.notRigid ? "@" : "") + (GeekCodeCategoryBuilder.this.living ? "$" : "") + (GeekCodeCategoryBuilder.this.noKnowledge ? "?" : ""));
		}
	}
}
