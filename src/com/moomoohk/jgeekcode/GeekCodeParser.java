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
				if (line.trim().length() == 0 || line.equals("-----BEGIN GEEK CODE BLOCK-----") || line.equals("------END GEEK CODE BLOCK------"))
					continue;
				lineNum++;
				switch (lineNum)
				{
					case 1:
						if (!line.startsWith("Version: "))
							throw new GeekCodeParseException("No Geek Code version specified on line " + lineNum + "!");
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
						if (line.charAt(0) == 'G' && Character.isAlphabetic(line.charAt(1)))
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
						}
						else
							throw new GeekCodeParseException("No Geek type leading on line " + lineNum + "!");
						break;
					default:
						if (code == null)
							throw new GeekCodeParseException("Parsing failed for unknown reason!");
						try (Scanner s2 = new Scanner(line))
						{
							while (s2.hasNext())
								evalExpression(s2.next());
						}
						catch (Exception e)
						{
							e.printStackTrace();
							throw new GeekCodeParseException("Problem parsing expressions!");
						}
						break;
				}
			}
		}
		if (code == null)
			throw new GeekCodeParseException("Parsing failed for unknown reason!");
		return code;
	}

	private static GeekCodeCategory evalExpression(String expression)
	{
		boolean refuse = false, notRigid = false, noKnowledge = false;
		if (expression.charAt(0) == '!')
		{
			refuse = true;
			expression = expression.substring(1);
		}
		if (expression.charAt(expression.length() - 1) == '@')
		{
			expression = expression.substring(0, expression.length() - 1);
			notRigid = true;
		}
		else
			if (expression.charAt(expression.length() - 1) == '?')
			{
				expression = expression.substring(0, expression.length() - 1);
				noKnowledge = true;
			}
		GeekCodeCategoryBuilder builder = null;
		String grade = "";
		int i = 0;
		for (char c : expression.toCharArray())
		{
			if (!Character.isLetter(c))
			{
				if (i == 0)
					throw new GeekCodeParseException("Missing category code!");
				grade = expression.substring(i);
			}
			i++;
		}
		System.out.println(expression + " " + grade);
		switch (expression.charAt(0))
		{
			case 'd':
				builder = d;
				break;
			case 's':
				builder = s;
				if (!grade.contains(":"))
					throw new GeekCodeParseException("Shape category missing \':\'!");
				String[] grades = grade.split(":");
				grade = grades[0];
				((ShapeGeekCodeCategoryBuilder) builder).roundness(evalGrade(grades[1]));
				break;
			case 'a':
				builder = a;
				break;
			case 'C':
				builder = C;
				break;
			case 'U':
				builder = U;
				break;
			case 'P':
				if (expression.startsWith("PS"))
					builder = PS;
				else
					if (expression.startsWith("PE"))
						builder = PE;
					else
						if (expression.startsWith("PGP"))
							builder = PGP;
						else
							builder = P;
				break;
			case 'L':
				builder = L;
				break;
			case 'E':
				builder = E;
				break;
			case 'W':
				builder = W;
				break;
			case 'N':
				builder = N;
				break;
			case 'o':
				builder = o;
				break;
			case 'K':
				builder = K;
				break;
			case 'w':
				builder = w;
				break;
			case 'O':
				builder = O;
				break;
			case 'M':
				builder = M;
				break;
			case 'V':
				builder = V;
				break;
			case 'Y':
				builder = Y;
				break;
			case 't':
				if (expression.startsWith("tv"))
					builder = tv;
				else
					builder = t;
				break;
			case '5':
				builder = BABYLON5;
				break;
			case 'X':
				builder = X;
				break;
			case 'R':
				builder = R;
				break;
			case 'b':
				builder = b;
				break;
			case 'D':
				if (expression.startsWith("DI"))
					builder = DI;
				else
					builder = D;
				break;
			case 'G':
				//builder = G;
				break;
			case 'e':
				builder = e;
				break;
			case 'h':
				builder = h;
				break;
			case 'r':
				builder = r;
				break;
			case 'x':
			case 'y':
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
		return builder.validate(evalGrade(grade));
	}

	private static GeekCodeGrade evalGrade(String grade)
	{
		return null;
	}
}
