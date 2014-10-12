/**
 *
 */
package com.moomoohk.jgeekcode;

import java.util.ArrayList;
import java.util.Scanner;

import com.moomoohk.jgeekcode.GeekCode.G;
import com.moomoohk.jgeekcode.builders.GeekCodeCategoryBuilder;
import com.moomoohk.jgeekcode.builders.GeekCodeCategoryBuilder.GeekCodeCategory;
import com.moomoohk.jgeekcode.builders.ShapeGeekCodeCategoryBuilder;

import static com.moomoohk.jgeekcode.GeekCode.*;

/**
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 10, 2014
 */
public class GeekCodeParser
{
	private static enum Gender
	{
		MALE, FEMALE, UNSPECIFIED;
	}

	private static String categoryCode = null;

	public static GeekCode parse(String geekCode)
	{
		GeekCode code = null;
		String version = null;
		ArrayList<G> geekTypes = new ArrayList<>();
		int lineNum = 0;
		try (Scanner s = new Scanner(geekCode))
		{
			while (s.hasNextLine())
			{
				String line = s.nextLine().trim();
				switch (lineNum)
				{
					case 0:
						if (!line.equals("-----BEGIN GEEK CODE BLOCK-----"))
							throw new GeekCodeParseException("Missing BEGIN GEEK CODE BLOCK on line 0!");
						break;
					case 1:
						if (!line.startsWith("Version: "))
							throw new GeekCodeParseException("No Geek Code version specified on line 1!");
						else
							try (Scanner s2 = new Scanner(line))
							{
								s2.next();
								version = s2.next();
								if (!version.equals("3.12"))
									throw new GeekCodeParseException("Only v3.12 can be parsed, not version[" + version + "]!");
							}
						break;
					case 2:
						if (line.length() > 0 && line.charAt(0) == 'G' && Character.isAlphabetic(line.charAt(1)))
						{
							String types = line.substring(1, line.indexOf(" "));
							try (Scanner s2 = new Scanner(types))
							{
								s2.useDelimiter("/");
								while (s2.hasNext())
									switch (s2.next())
									{
										case "B":
											geekTypes.add(G.B);
											break;
										case "C":
											geekTypes.add(G.C);
											break;
										case "CA":
											geekTypes.add(G.CA);
											break;
										case "CM":
											geekTypes.add(G.CM);
											break;
										case "CS":
											geekTypes.add(G.CS);
											break;
										case "CC":
											geekTypes.add(G.CC);
											break;
										case "E":
											geekTypes.add(G.E);
											break;
										case "ED":
											geekTypes.add(G.ED);
											break;
										case "FA":
											geekTypes.add(G.FA);
											break;
										case "G":
											geekTypes.add(G.G);
											break;
										case "H":
											geekTypes.add(G.H);
											break;
										case "IT":
											geekTypes.add(G.IT);
											break;
										case "J":
											geekTypes.add(G.J);
											break;
										case "LS":
											geekTypes.add(G.LS);
											break;
										case "L":
											geekTypes.add(G.L);
											break;
										case "MC":
											geekTypes.add(G.MC);
											break;
										case "M":
											geekTypes.add(G.M);
											break;
										case "MD":
											geekTypes.add(G.MD);
											break;
										case "MU":
											geekTypes.add(G.MU);
											break;
										case "PA":
											geekTypes.add(G.PA);
											break;
										case "P":
											geekTypes.add(G.P);
											break;
										case "S":
											geekTypes.add(G.S);
											break;
										case "SS":
											geekTypes.add(G.SS);
											break;
										case "W":
											geekTypes.add(G.W);
											break;
										case "O":
											geekTypes.add(G.O);
											break;
										case "U":
											geekTypes.add(G.U);
											break;
										case "*":
											geekTypes.add(G.NO_QUALIFICATIONS);
											break;
										case "AT":
											geekTypes.add(G.AT);
											break;
										default:
											throw new GeekCodeParseException("Unknown geek type[" + line.substring(1, line.indexOf(" ")) + "]!");
									}
								code = new GeekCode(geekTypes.toArray(new G[0]));
							}
							line = line.substring(line.indexOf(" ") + 1);
						}
						else
							throw new GeekCodeParseException("No Geek type leading on line 2!");
					default:
						if (line.equals("------END GEEK CODE BLOCK------"))
							break;
						if (code == null)
							throw new GeekCodeParseException("Parsing failed for unknown reason!");
						String[] tokens = line.split(" ");
						for (String token : tokens)
							code.addCategory(evalExpression(token));
						break;
				}
				lineNum++;
			}
		}
		if (code == null)
			throw new GeekCodeParseException("Parsing failed for unknown reason!");
		System.out.println();
		return code;
	}

	private static class Expression
	{
		private GeekCodeGrade grade;
		private String modifiers;
		private boolean refuse, notRigid, living, noKnowledge;

		public Expression(String expression)
		{

		}

		public GeekCodeGrade getGrade()
		{
			return this.grade;
		}

		public String getModifiers()
		{
			return this.modifiers;
		}

		public boolean refuse()
		{
			return this.refuse;
		}

		public boolean notRigid()
		{
			return this.notRigid;
		}

		public boolean living()
		{
			return this.living;
		}

		public boolean noKnowledge()
		{
			return this.noKnowledge;
		}
	}

	private static GeekCodeCategory evalExpression(String expression)
	{
		System.out.println("Expression: " + expression);
		boolean refuse = false, notRigid = false, living = false, noKnowledge = false;
		if (expression.charAt(0) == '!')
		{
			refuse = true;
			expression = expression.substring(1);
		}
		GeekCodeCategoryBuilder builder = null;
		String code = "", grade = "";
		for (int i = 0; i < expression.length(); i++)
		{
			char c = expression.charAt(i);
			if (Character.isLetter(c))
				code += c;
			else
				if (i == 0)
					throw new GeekCodeParseException("No category code found!");
				else
				{
					grade = expression.substring(i);
					break;
				}
		}
		System.out.println("code " + code);
		String modifiers = "";
		for (int i = 0; i < grade.length(); i++)
		{
			char c = grade.charAt(i);
			if (c != '+' && c != '-' && c != ':')
			{
				modifiers = grade.substring(i);
				grade = grade.substring(0, i);
			}
		}
		GeekCodeGrade gradeObj = evalGrade(grade);
		String wannabe = "";
		if (modifiers.contains(">"))
		{
			String[] wannabeSplit = modifiers.split(">");
			modifiers = wannabeSplit[0];
			wannabe = wannabeSplit[1];
			if (wannabe.length() > 0)
			{

			}
		}
		String crossoverGrade = null;
		if (modifiers.contains("("))
		{
			if (!modifiers.contains(")") || (modifiers.contains(")") && modifiers.indexOf("(") > modifiers.indexOf(")")))
				throw new GeekCodeParseException("Unmatched parens for " + code + "!");
			crossoverGrade = modifiers.substring(modifiers.indexOf("(") + 1, modifiers.indexOf(")"));
			modifiers = modifiers.substring(0, modifiers.indexOf("(")) + modifiers.substring(modifiers.indexOf(")") + 1);
			for (int i = 0; i < crossoverGrade.length(); i++)
			{
				char c = crossoverGrade.charAt(i);
				if (c != '+' && c != '-')
					throw new GeekCodeParseException("Bad crossover grade[" + crossoverGrade + "] for code " + code + "!");
			}
		}
		notRigid = evalModifier(modifiers, '@');
		living = evalModifier(modifiers, '$');
		noKnowledge = evalModifier(modifiers, '?');

		System.out.println("grade: " + gradeObj + " (" + gradeObj.getGrade() + ")");
		System.out.println("modifiers: " + modifiers);
		System.out.println(" refuse: " + refuse);
		System.out.println(" living: " + living);
		System.out.println(" notRigid: " + notRigid);
		System.out.println(" noKnowledge: " + noKnowledge);
		System.out.println("crossoverGrade: " + crossoverGrade);
		System.out.println("wannabe: " + wannabe);
		Gender gender = null;
		switch (code)
		{
			case "d":
				builder = d;
				break;
			case "s":
				builder = s;
				if (!grade.contains(":"))
					throw new GeekCodeParseException("Shape category missing \':\'!");
				String[] grades = grade.split(":");
				grade = grades[0];
				((ShapeGeekCodeCategoryBuilder) builder).roundness(evalExpression(grades[1]));
				break;
			case "a":
				builder = a;
				break;
			case "C":
				builder = C;
				break;
			case "U":
				builder = U;
				break;
			case "P":
				builder = P;
				break;
			case "PS":
				builder = PS;
				break;
			case "PE":
				builder = PE;
				break;
			case "PGP":
				builder = PGP;
				break;
			case "L":
				builder = L;
				break;
			case "E":
				builder = E;
				break;
			case "W":
				builder = W;
				break;
			case "N":
				builder = N;
				break;
			case "o":
				builder = o;
				break;
			case "K":
				builder = K;
				break;
			case "w":
				builder = w;
				break;
			case "O":
				builder = O;
				break;
			case "M":
				builder = M;
				break;
			case "V":
				builder = V;
				break;
			case "Y":
				builder = Y;
				break;
			case "t":
				builder = t;
				break;
			case "tv":
				builder = tv;
				break;
			case "5":
				builder = BABYLON5;
				break;
			case "X":
				builder = X;
				break;
			case "R":
				builder = R;
				break;
			case "b":
				builder = b;
				break;
			case "D":
				builder = D;
				break;
			case "DI":
				builder = DI;
				break;
			case "G":
				builder = GCode;
				break;
			case "e":
				builder = e;
				break;
			case "h":
				builder = h;
				break;
			case "r":
				builder = r;
				break;
			case "x":
				gender = Gender.FEMALE;
				builder = z;
				break;
			case "y":
				gender = Gender.MALE;
				builder = z;
				break;
			case "z":
				gender = Gender.UNSPECIFIED;
				builder = z;
				break;
			default:
				throw new GeekCodeParseException("Unrecognized expression[" + expression + "]!");
		}
		if (refuse)
			return builder.refuse();
		if (noKnowledge)
			return builder.noKnowledge();
		if (notRigid)
			builder.notRigid();
		if (living)
			builder.living();
		if (crossoverGrade != null)
			builder.crossover(evalGrade(crossoverGrade));
		System.out.println();
		categoryCode = null;
		return builder.grade(gradeObj);
	}

	private static GeekCodeGrade evalGrade(String grade)
	{
		Character gradeType = null;
		int count = 0;
		for (char c : grade.toCharArray())
		{
			if (gradeType != null)
			{
				if (c != gradeType)
					throw new GeekCodeParseException("Bad grade[" + grade + "] for code " + categoryCode + "!");
			}
			else
				gradeType = c;
			if (c == '+')
				count++;
			if (c == '-')
				count--;
		}
		return new GeekCodeGrade(count);
	}

	private static boolean evalModifier(String modifiers, char c)
	{
		if (modifiers.indexOf(c) != -1)
		{
			if ((!modifiers.contains(">") && modifiers.substring(modifiers.indexOf(c) + 1).indexOf(c) != -1) || (modifiers.contains(">") && !modifiers.substring(modifiers.indexOf(c) + 1).contains(">")))
				throw new GeekCodeParseException(c + " defined more than once for " + categoryCode + "!");
			return true;
		}
		return false;
	}
}
