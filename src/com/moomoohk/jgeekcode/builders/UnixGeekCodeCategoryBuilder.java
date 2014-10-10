package com.moomoohk.jgeekcode.builders;

import com.moomoohk.jgeekcode.GeekCodeGrade;

/**
 *
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 10, 2014
 */
public class UnixGeekCodeCategoryBuilder extends GeekCodeCategoryBuilder
{
	public static enum UnixType
	{
		/**
		 * BSD (use this unless your BSDish system is mentioned below)
		 */
		B,
		/**
		 * Linux
		 */
		L,
		/**
		 * Ultrix
		 */
		U,
		/**
		 * AIX
		 */
		A,
		/**
		 * SysV
		 */
		V,
		/**
		 * HPUX
		 */
		H,
		/**
		 * IRIX
		 */
		I,
		/**
		 * OSF/1 (aka Digital Unix)
		 */
		O,
		/**
		 * Sun OS/Solaris
		 */
		S,
		/**
		 * SCO Unix
		 */
		C,
		/**
		 * NeXT
		 */
		X,
		/**
		 * Some other one not listed
		 */
		OTHER, NOT_SPECIFIED;

		@Override
		public String toString()
		{
			return this == OTHER ? "*" : this == NOT_SPECIFIED ? "U" : "U" + this.name();
		}
	}

	private UnixType type;

	public UnixGeekCodeCategoryBuilder type(UnixType type)
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
