package com.moomoohk.jgeekcode.test;

import com.moomoohk.jgeekcode.GeekCode;
import com.moomoohk.jgeekcode.GeekCode.G;
import com.moomoohk.jgeekcode.GeekCodeGrade;
import com.moomoohk.jgeekcode.GeekCodeParser;
import com.moomoohk.jgeekcode.builders.BasicGeekCodeCategoryBuilder;

import static com.moomoohk.jgeekcode.GeekCode.*;

/**
 *
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 10, 2014
 */
public class ParseTest
{
	public static void main(String[] args)
	{
		GeekCode code = new GeekCode(G.CS, G.IT);

		code.addCategory(d.crossover(new GeekCodeGrade(0)).living().grade(new GeekCodeGrade(-1)));
		code.addCategory(s.roundness(new BasicGeekCodeCategoryBuilder().grade(new GeekCodeGrade(-1))).grade(new GeekCodeGrade(3)));
		code.addCategory(a.grade(new GeekCodeGrade(-3)));
		code.addCategory(C.grade(new GeekCodeGrade(2)));
		code.addCategory(U.noKnowledge());
		code.addCategory(P.noKnowledge());
		code.addCategory(E.grade(new GeekCodeGrade(-1)));
		code.addCategory(W.grade(new GeekCodeGrade(3)));
		code.addCategory(N.noKnowledge());
		code.addCategory(o.noKnowledge());
		code.addCategory(K.noKnowledge());
		code.addCategory(w.grade(new GeekCodeGrade(-3)));
		code.addCategory(O.noKnowledge());
		code.addCategory(M.grade(new GeekCodeGrade(2)));
		code.addCategory(V.noKnowledge());
		code.addCategory(PS.refuse());
		code.addCategory(PE.refuse());
		code.addCategory(Y.grade(new GeekCodeGrade(0)));
		code.addCategory(t.noKnowledge());
		code.addCategory(BABYLON5.noKnowledge());
		code.addCategory(X.noKnowledge());
		code.addCategory(R.refuse());
		code.addCategory(tv.grade(new GeekCodeGrade(1)));
		code.addCategory(b.grade(new GeekCodeGrade(1)));
		code.addCategory(DI.grade(new GeekCodeGrade(0)));
		code.addCategory(D.noKnowledge());
		code.addCategory(GCode.grade(new GeekCodeGrade(3)));
		code.addCategory(e.grade(new GeekCodeGrade(0)));
		code.addCategory(h.grade(new GeekCodeGrade(-2)));
		code.addCategory(r.refuse());
		code.addCategory(z.male().grade(new GeekCodeGrade(0)));

		System.out.println("INPUT:\n" + code.generate());
		System.out.println("DEBUG:");
		System.out.println("OUTPUT:\n" + GeekCodeParser.parse(code.generate()));

		//		String file = "";
		//		try (Scanner s = new Scanner(new File("src/com/moomoohk/jgeekcode/test/test.txt")))
		//		{
		//			while (s.hasNextLine())
		//				file += s.nextLine() + "\n";
		//		}
		//		catch (FileNotFoundException e1)
		//		{
		//			e1.printStackTrace();
		//		}
		//		System.out.println("INPUT:\n" + file);
		//		System.out.println("DEBUG:");
		//		System.out.println("OUTPUT:\n" + GeekCodeParser.parse(file).generate());
	}
}
