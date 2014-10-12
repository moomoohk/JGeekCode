package com.moomoohk.jgeekcode.builders;

import com.moomoohk.jgeekcode.GeekCodeGrade;

/**
 *
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 10, 2014
 */
public class UnixGeekCodeCategoryBuilder extends GeekCodeCategoryBuilder
{
	private static enum UnixType
	{

		B, L, U, A, V, H, I, O, S, C, X, OTHER, NOT_SPECIFIED;

		@Override
		public String toString()
		{
			return this == OTHER ? "*" : this == NOT_SPECIFIED ? "U" : "U" + this.name();
		}
	}

	private UnixType type = UnixType.NOT_SPECIFIED;

	public UnixGeekCodeCategoryBuilder(String code, int minGrade, int maxGrade)
	{
		super(code, minGrade, maxGrade);
	}

	/**
	 * BSD (use this unless your BSDish system is mentioned below)
	 */
	public UnixGeekCodeCategoryBuilder B()
	{
		return type(UnixType.B);
	}

	/**
	 * Linux
	 */
	public UnixGeekCodeCategoryBuilder L()
	{
		return type(UnixType.L);
	}

	/**
	 * Ultrix
	 */
	public UnixGeekCodeCategoryBuilder U()
	{
		return type(UnixType.U);
	}

	/**
	 * AIX
	 */
	public UnixGeekCodeCategoryBuilder A()
	{
		return type(UnixType.A);
	}

	/**
	 * SysV
	 */
	public UnixGeekCodeCategoryBuilder V()
	{
		return type(UnixType.V);
	}

	/**
	 * HPUX
	 */
	public UnixGeekCodeCategoryBuilder H()
	{
		return type(UnixType.H);
	}

	/**
	 * IRIX
	 */
	public UnixGeekCodeCategoryBuilder I()
	{
		return type(UnixType.I);
	}

	/**
	 * OSF/1 (aka Digital Unix)
	 */
	public UnixGeekCodeCategoryBuilder O()
	{
		return type(UnixType.O);
	}

	/**
	 * Sun OS/Solaris
	 */
	public UnixGeekCodeCategoryBuilder S()
	{
		return type(UnixType.S);
	}

	/**
	 * SCO Unix
	 */
	public UnixGeekCodeCategoryBuilder C()
	{
		return type(UnixType.C);
	}

	/**
	 * NeXT
	 */
	public UnixGeekCodeCategoryBuilder X()
	{
		return type(UnixType.X);
	}

	/**
	 * Some other one not listed
	 */
	public UnixGeekCodeCategoryBuilder other()
	{
		return type(UnixType.OTHER);
	}

	private UnixGeekCodeCategoryBuilder type(UnixType type)
	{
		this.type = type;
		return this;
	}

	@Override
	protected GeekCodeCategory subValidate(GeekCodeGrade grade)
	{
		if (this.type == null)
			this.type = UnixType.NOT_SPECIFIED;
		return new UnixGeekCodeCategory(grade, this.type);
	}

	public class UnixGeekCodeCategory extends GeekCodeCategory
	{
		UnixType type;

		private UnixGeekCodeCategory(GeekCodeGrade grade, UnixType type)
		{
			super(grade);
			this.code = type.toString();
		}
	}
}
