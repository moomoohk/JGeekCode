package com.moomoohk.jgeekcode;

import java.util.HashMap;

import com.moomoohk.jgeekcode.builders.DressGeekCodeCategoryBuilder;
import com.moomoohk.jgeekcode.builders.ExtremeGenericGeekCodeCategoryBuilder;
import com.moomoohk.jgeekcode.builders.GeekCodeCategoryBuilder.GeekCodeCategory;
import com.moomoohk.jgeekcode.builders.GenericGeekCodeCategoryBuilder;
import com.moomoohk.jgeekcode.builders.SexGeekCodeCategoryBuilder;
import com.moomoohk.jgeekcode.builders.ShapeGeekCodeCategoryBuilder;
import com.moomoohk.jgeekcode.builders.UnixGeekCodeCategoryBuilder;

/**
 * Java implementation of "The Code of the Geeks" v3.12 originally authored by Robert A. Hayden (rhayden@geek.net) on March 5, 1996. <br>
 * http://www.geekcode.com/
 *
 * @author Meshulam Silk (moomoohk@ymail.com)
 * @since Oct 10, 2014
 */
public class GeekCode
{
	/**
	 * Geeks come in many flavors. The flavors relate to the vocation (or, if a student, what they are training in) of the particular geek. To start a code, a geek must declare himself or herself to be a geek. To do this, we start the code with a "G" to denote "GEEK", followed by one or two letters to denote the geek's occupation or field of study. Multi-talented geeks with more than one vocational training should denote their myriad of talents with a slash between each vocation (example: GCS/MU/TW).
	 */
	public static enum G
	{
		/**
		 * Geek of Business
		 */
		B,
		/**
		 * Geek of Classics
		 */
		C,
		/**
		 * Geek of Commercial Arts
		 */
		CA,
		/**
		 * Geek of Computer Management
		 */
		CM,
		/**
		 * Geek of Computer Science
		 */
		CS,
		/**
		 * Geek of Communications
		 */
		CC,
		/**
		 * Geek of Engineering
		 */
		E,
		/**
		 * Geek of Education
		 */
		ED,
		/**
		 * Geek of Fine Arts
		 */
		FA,
		/**
		 * Geek of Government
		 */
		G,
		/**
		 * Geek of Humanities
		 */
		H,
		/**
		 * Geek of Information Technology
		 */
		IT,
		/**
		 * Geek of Jurisprudence (Law)
		 */
		J,
		/**
		 * Geek of Library Science
		 */
		LS,
		/**
		 * Geek of Literature
		 */
		L,
		/**
		 * Geek of Mass Communications
		 */
		MC,
		/**
		 * Geek of Math
		 */
		M,
		/**
		 * Geek of Medicine
		 */
		MD,
		/**
		 * Geek of Music
		 */
		MU,
		/**
		 * Geek of Performing Arts
		 */
		PA,
		/**
		 * Geek of Philosophy
		 */
		P,
		/**
		 * Geek of Science (Physics, Chemistry, Biology, etc.)
		 */
		S,
		/**
		 * Geek of Social Science (Psychology, Sociology, etc.)
		 */
		SS,
		/**
		 * Geek of Technical Writing
		 */
		W,
		/**
		 * Geek of Other. Some types of geeks deviate from the normal geek activities. This is encouraged as true geeks come from all walks of life.
		 */
		O,
		/**
		 * Geek of 'Undecided'. This is a popular vocation with incoming freshmen.
		 */
		U,
		/**
		 * Geek of no qualifications. A rather miserable existence, you would think.
		 */
		NO_QUALIFICATIONS,
		/**
		 * Geek of All Trades. For those geeks that can do anything and everything. GAT usually precludes the use of other vocational descriptors.
		 */
		AT;

		@Override
		public String toString()
		{
			return this == NO_QUALIFICATIONS ? "G!" : "G" + this.name();
		}
	}

	/**
	 * <h1>Dress</h1>
	 * <p>
	 * It is said that "clothes make the man". Well, I understood that I was made by a mommy and a daddy (and there's even a category to describe the process below!). Maybe the people who made up that saying aren't being quite that literal...
	 * </p>
	 */
	public static final DressGeekCodeCategoryBuilder d = (DressGeekCodeCategoryBuilder) new DressGeekCodeCategoryBuilder().code("d").minGrade(-2).maxGrade(2);
	/**
	 * <h1>Shape</h1>
	 * <p>
	 * Geeks come in many shapes and sizes. Shape code is divided into two parts. The first indicates height, while the second indicates roundness. Mix each section to fit yourself. Examples include: s:++, s++:, s++:--.
	 * </p>
	 */
	public static final ShapeGeekCodeCategoryBuilder s = (ShapeGeekCodeCategoryBuilder) new ShapeGeekCodeCategoryBuilder().code("s").minGrade(-3).maxGrade(3);
	/**
	 * <h1>Age</h1>
	 * <p>
	 * The only way to become a true geek is through practice and experience. To this end, your age becomes an important part of your geekiness. Use the qualifiers below to show your age (in Terran years). Also, please use BASE 10 numbers.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder a = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("a").minGrade(-5).maxGrade(3);
	/**
	 * <h1>Computers</h1>
	 * <p>
	 * Most geeks identify themselves by their use of computers and computer networks. In order to quantify your geekiness level on computers, consult the following (consider the term 'computers' synonymous with 'computer network'). This category represents "general" computer aptitude. Categories below will get into specifics.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder C = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("C").minGrade(-3).maxGrade(4);
	/**
	 * <h1>Unix</h1>
	 * <p>
	 * It seems that a Unix-based operating system is the OS of choice among most geeks. In addition to telling us about your Unix abilities, you can also show which specific Unix OS you are using. To accomplish this, you include a letter showing the brand with your rating. For example: UL++++ would indicate a sysadmin running Linux.
	 * </p>
	 */
	public static final UnixGeekCodeCategoryBuilder U = (UnixGeekCodeCategoryBuilder) new UnixGeekCodeCategoryBuilder().code("U").minGrade(-3).maxGrade(4);
	/**
	 * <h1>Perl</h1>
	 * <p>
	 * If you enjoy at least U++ status you have to know about Perl, so you might as well rate yourself in this sub-category. Non-Unix geeks don't know what they're missing.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder P = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("P").minGrade(-3).maxGrade(5);
	/**
	 * <h1>Linux</h1>
	 * <p>
	 * Linux is a hacker-written operating system virtually identical to Unix. It was written for and continues to run on your standard 386/486/Pentium PC, but has also been ported to other systems. Because it is still a young OS, and because it is continually evolving from hacker changes and support, it is important that the geek list his Linux ability.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder L = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("L").minGrade(-3).maxGrade(5);
	/**
	 * <h1>Emacs</h1>
	 * <p>
	 * GNU Emacs is the do-all be-everything editor/operating system available for just about every computer architecture out there.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder E = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("E").minGrade(-4).maxGrade(3);
	/**
	 * <h1>World Wide Web</h1>
	 * <p>
	 * It's relatively new. It's little understood. Everybody's doing it. How much of a web-surfer are you?
	 * </P>
	 */
	public static final GenericGeekCodeCategoryBuilder W = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("W").minGrade(-2).maxGrade(3);
	/**
	 * <h1>USENET News</h1>
	 * <p>
	 * Usenet, a global collection of flaming opinions and senseless babble, was designed as a way to eat up precious spool space on a system's hard drive. It also is a way for people to distribute pornography.
	 * </P>
	 */
	public static final ExtremeGenericGeekCodeCategoryBuilder N = (ExtremeGenericGeekCodeCategoryBuilder) new ExtremeGenericGeekCodeCategoryBuilder().code("N").minGrade(-4).maxGrade(4);
	/**
	 * <h1>USENET Oracle</h1>
	 * <p>
	 * <em>(Info taken from the Usenet Oracle Help File)</em> <br>
	 * Throughout the history of mankind, there have been many Oracles who have been consulted by many mortals, and some immortals. The great Hercules was told by the Gelphic Oracle to serve Eurystheus, king of Mycenae, for twelve years to atone for the murder of his own children. It was the Oracle of Ammon who told King Cepheus to chain his daughter Andromeda to the rocks of jappa to appease the terrible sea monster that was ravaging the coasts. That solution was never tested, though, as Perseus saved the girl in the nick of time. <br>
	 * With the advent of the electronic age, and expecially high-speed e-mail communication, the spirit of the Oracles found a new outlet, and we now recognize another great Oracle, the Usenet Oracle. <br>
	 * For more information, check out the newsgroups rec.humor.oracle and rec.humor.oracle.d or the FTP archives at cs.indiana.edu:/pub/oracle. Additional information and instructions can be found by sending an e-mail message with the subject of 'help' to oracle@cs.indiana.edu.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder o = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("o").minGrade(-2).maxGrade(5);
	/**
	 * <h1>Kibo</h1>
	 * <p>
	 * Kibo is. That is all that can be said. If you don't understand, read alt.religion.kibology
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder K = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("K").minGrade(-4).maxGrade(6);
	/**
	 * <h1>Microsoft Windows</h1>
	 * <p>
	 * A good many geeks suffer through the use of various versions of Microsoft's Windows running on or as a replacement for DOS. Rate your Windows Geekiness.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder w = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("w").minGrade(-3).maxGrade(5);
	/**
	 * <h1>OS/2</h1>
	 * <p>
	 * The operating system that looks a lot like Windows, acts a lot like Windows, but is much better than Windows.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder O = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("O").minGrade(-4).maxGrade(3);
	/**
	 * <h1>Macintosh</h1>
	 * <p>
	 * Many geeks have abandoned the character-based computer altogether and moved over to the Macintosh. It in important to give notification of your Mac rating.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder M = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("M").minGrade(-2).maxGrade(2);
	/**
	 * <h1>VMS</h1>
	 * <p>
	 * Many geeks use the VMS operating system by DEC for all of their mainframe and network activity.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder V = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("V").minGrade(-2).maxGrade(3);
	/**
	 * <h1>Political and Social Issues</h1>
	 * <p>
	 * We live is a society where everyone not only has a right to, but is expected to, whine and complain about everyone else. Rate where, in general, your political views on different social issues fall.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder PS = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("PS").minGrade(-3).maxGrade(3);
	/**
	 * <h1>Politics and Economic Issues</h1>
	 * <p>
	 * Social and economic attitudes are seldom on the same side of the political fence. Of course, most geeks don't really care much about economics; having no money left after buying new computer toys.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder PE = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("PE").minGrade(-2).maxGrade(3);
	/**
	 * <h1>Cypherpunks</h1>
	 * <p>
	 * With the birth of the overused buzzword "The Information Superhighway", concerns over privacy from evil governmental bad-guys{tm} has led to the formation of of an unofficial, loosely organized band of civil libertarians who spend much of their time discussing how to ensure privacy in the information future. This group is known by some as "cypherpunks" (by others, as anarchistic subversives). To this end, tell us how punkish you are.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder Y = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("Y").minGrade(-3).maxGrade(3);
	/**
	 * <h1>PGP</h1>
	 * <p>
	 * Pretty Good Privacy (aka PGP) is a program available on many platforms that will encrypt files so that prying eyes (particularly governmental) can't look at them.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder PGP = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("PGP").minGrade(-4).maxGrade(4);
	/**
	 * <h1>Star Trek</h1>
	 * <p>
	 * Most geeks have an undeniable love for the Star Trek television show (in any of its different incarnations). Because GEEK is often synonymous with TREKKIE (real geeks aren't so anal as to label themselves TREKKER), it is important that all geeks list their Trek rating.
	 * </p>
	 */
	public static final ExtremeGenericGeekCodeCategoryBuilder t = (ExtremeGenericGeekCodeCategoryBuilder) new ExtremeGenericGeekCodeCategoryBuilder().code("t").minGrade(-3).maxGrade(3);
	/**
	 * <h1>Babylon 5</h1>
	 * <p>
	 * For many years, Sci-Fi geeks have wished for a television show that would overcome the limitations of Star Trek. For many, a show called Babylon 5 has met that demand, with a deep storyline, exciting characters and state-of-the-art computer generated effects.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder BABYLON5 = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("5").minGrade(-2).maxGrade(4);
	/**
	 * <h1>X-Files</h1>
	 * <p>
	 * The Fox Network's Friday evening show The X-Files has become the staple of Friday geekhood. Any show that has aliens, governmental conspiracies, aliens, psychic powers, aliens, and other weird stuff is, by definition, a geeky show.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder X = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("X").minGrade(-2).maxGrade(4);
	/**
	 * <h1>Role Playing</h1>
	 * <p>
	 * Role-playing games such as Dungeons & Dragons have long been a part of the traditional geek life. Because geeks often become so involved in their role-playing that they lose touch with reality, include one of the following role-playing codes.
	 * </p>
	 */
	public static final ExtremeGenericGeekCodeCategoryBuilder R = (ExtremeGenericGeekCodeCategoryBuilder) new ExtremeGenericGeekCodeCategoryBuilder().code("R").maxGrade(3).minGrade(-3);
	/**
	 * <h1>Role Playing</h1>
	 * <p>
	 * Role-playing games such as Dungeons & Dragons have long been a part of the traditional geek life. Because geeks often become so involved in their role-playing that they lose touch with reality, include one of the following role-playing codes.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder tv = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("tv").minGrade(-2).maxGrade(3);
	/**
	 * <h1>Books</h1>
	 * <p>
	 * In addition (or maybe on the other hand), many geeks have lives that revolve around books.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder b = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("b").minGrade(-2).maxGrade(4);
	/**
	 * <h1>Dilbert</h1>
	 * <p>
	 * Simply the geekiest comic strip in existence. http://www.unitedmedia.com/comics/dilbert/ for more information.
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder DI = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("DI").minGrade(-3).maxGrade(5);
	/**
	 * <h1>DOOM!</h1>
	 * <p>
	 * There is a game out for the PCs and other computers called DOOM. It's a 3D virtual reality simulation where you race around and blow things away with large-caliber weaponry. This has led to a series of similar games such as the Star Wars themed Dark Forces. Tell us about your abilities with these 3D games. (yes, some of them aren't actually Doom. Cope!)
	 * </p>
	 */
	public static final GenericGeekCodeCategoryBuilder D = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("D").minGrade(-4).maxGrade(4);
	/**
	 * <h1>The Geek Code</h1>
	 */
	public static final GenericGeekCodeCategoryBuilder GCode = (GenericGeekCodeCategoryBuilder) new GenericGeekCodeCategoryBuilder().code("G").minGrade(-2).maxGrade(5);
	/**
	 * <h1>Education</h1>
	 * <p>
	 * All geeks have a varying amount of education.
	 * </p>
	 */
	public static final ExtremeGenericGeekCodeCategoryBuilder e = (ExtremeGenericGeekCodeCategoryBuilder) new ExtremeGenericGeekCodeCategoryBuilder().code("e").minGrade(-2).maxGrade(5);
	/**
	 * <h1>Housing</h1>
	 * <p>
	 * Tell us about your geeky home.
	 * </p>
	 */
	public static final ExtremeGenericGeekCodeCategoryBuilder h = (ExtremeGenericGeekCodeCategoryBuilder) new ExtremeGenericGeekCodeCategoryBuilder().code("h").minGrade(-4).maxGrade(2);
	/**
	 * <h1>Relationships</h1>
	 * <p>
	 * While many geeks are highly successful at having relationships, a good many more are not. Give us the gritty details.
	 * </p>
	 */
	public static final ExtremeGenericGeekCodeCategoryBuilder r = (ExtremeGenericGeekCodeCategoryBuilder) new ExtremeGenericGeekCodeCategoryBuilder().code("r").minGrade(-3).maxGrade(3);
	/**
	 * <h1>Sex</h1>
	 * <p>
	 * Geeks have traditionally had problems with sex (ie, they never have any). Because geeks are so wrapped up in their sexuality (or lack of sexuality for that matter), it is important that the geek be willing to quantify their sexual experiences.<br>
	 * This code also is used to denote the gender of the geek. Females use 'x' in this category, while males use 'y'. Those that do not wish to disclose their gender can use 'z'. For example: <br>
	 * <ul>
	 * <li>
	 * x+ -- A female who has had sex</li>
	 * <li>
	 * y+ -- A male who has had sex.</li>
	 * <li>
	 * z+ -- A person (gender undisclosed) who has had sex.</li>
	 * </ul>
	 * <br>
	 * For those persons who do not wish to give out any details of their sex life, the use of z? (where z is the gender code) will allow you to do so.
	 */
	public static final SexGeekCodeCategoryBuilder z = (SexGeekCodeCategoryBuilder) new SexGeekCodeCategoryBuilder().code("z").minGrade(-3).maxGrade(5);

	private final G types[];
	private final HashMap<String, GeekCodeCategory> categories;

	public GeekCode(G... types)
	{
		this.types = types;
		this.categories = new HashMap<>();
	}

	public void addCategory(GeekCodeCategory category)
	{
		if (this.categories.keySet().contains(category.getCode()))
			throw new GeekCodeException("Geek Code already contains category[" + category.getCode() + "]!");
		this.categories.put(category.getCode(), category);
	}

	public String generate()
	{
		String st = "-----BEGIN GEEK CODE BLOCK-----\nVersion:3.12\nG";
		for (G type : this.types)
			st += type.name() + "/";
		st = st.substring(0, st.length() - 1) + " ";
		int categories = 0;
		for (GeekCodeCategory category : this.categories.values())
		{
			st += category + " ";
			categories++;
			if (categories == 8)
			{
				st += "\n";
				categories = 0;
			}
		}
		return st.trim() + "\n------END GEEK CODE BLOCK------";
	}

	@Override
	public String toString()
	{
		String st = "G";
		for (G type : this.types)
			st += type.name() + "/";
		st = st.substring(0, st.length() - 1) + " ";
		for (GeekCodeCategory category : this.categories.values())
			st += category + " ";
		return st.trim();
	}
}