package com.moomoohk.jgeekcode.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.moomoohk.jgeekcode.GeekCodeParser;

/**
 *
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 10, 2014
 */
public class ParseTest
{
	public static void main(String[] args)
	{
		//		GeekCode code = new GeekCode(G.CS, G.IT);
		//
		//		code.addCategory(d.validate(new GeekCodeGrade(-1)));
		//		code.addCategory(s.roundness(new GeekCodeGrade(-1)).validate(new GeekCodeGrade(3)));
		//		code.addCategory(a.validate(new GeekCodeGrade(-3)));
		//		code.addCategory(C.validate(new GeekCodeGrade(2)));
		//		code.addCategory(U.noKnowledge());
		//		code.addCategory(P.noKnowledge());
		//		code.addCategory(E.validate(new GeekCodeGrade(-1)));
		//		code.addCategory(W.validate(new GeekCodeGrade(3)));
		//		code.addCategory(N.noKnowledge());
		//		code.addCategory(o.noKnowledge());
		//		code.addCategory(K.noKnowledge());
		//		code.addCategory(w.validate(new GeekCodeGrade(-3)));
		//		code.addCategory(O.noKnowledge());
		//		code.addCategory(M.validate(new GeekCodeGrade(2)));
		//		code.addCategory(V.noKnowledge());
		//		code.addCategory(PS.validate(new GeekCodeGrade(0)));
		//		code.addCategory(PE.refuse());
		//		code.addCategory(Y.validate(new GeekCodeGrade(0)));
		//		code.addCategory(t.noKnowledge());
		//		code.addCategory(BABYLON5.noKnowledge());
		//		code.addCategory(X.noKnowledge());
		//		code.addCategory(R.refuse());
		//		code.addCategory(tv.validate(new GeekCodeGrade(1)));
		//		code.addCategory(b.validate(new GeekCodeGrade(1)));
		//		code.addCategory(DI.validate(new GeekCodeGrade(0)));
		//		code.addCategory(D.noKnowledge());
		//		code.addCategory(GCode.validate(new GeekCodeGrade(2)));
		//		code.addCategory(e.validate(new GeekCodeGrade(0)));
		//		code.addCategory(h.validate(new GeekCodeGrade(-2)));
		//		code.addCategory(r.refuse());
		//		code.addCategory(z.male(new GeekCodeGrade(0)));
		//
		//		System.out.println(GeekCodeParser.parse(code.generate()));

		String file = "";
		try (Scanner s = new Scanner(new File("src/com/moomoohk/jgeekcode/test/test.txt")))
		{
			while (s.hasNextLine())
				file += s.nextLine() + "\n";
		}
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		System.out.println(GeekCodeParser.parse(file));
	}
}
