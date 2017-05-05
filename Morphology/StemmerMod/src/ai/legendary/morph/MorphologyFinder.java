package ai.legendary.morph;

import java.util.ArrayList;

public class MorphologyFinder {
	/**
	 * the orginal inputted word
	 */
	protected String originalWord = "";
	/**
	 * letters of the word that is to be broken apart.
	 */
	protected ArrayList<Character> letters = new ArrayList<Character>();
	/**
	 * ArrayList of suffixes
	 */
	protected ArrayList<String> suffs = new ArrayList<String>();
	/**
	 * ArrayList of prefixes
	 */
	protected ArrayList<String> prefs = new ArrayList<String>();

	/**
	 * Puts all letter of the word into the letters arraylist
	 * 
	 * @param w
	 *            word to be broken apart.
	 */

	public MorphologyFinder(String w) {
		originalWord = w;
		w = w.toLowerCase();
		for (int i = 0; i < w.length(); i++) {
			letters.add(w.charAt(i));
		}
	}

	/**
	 * Call's all steps to break apart the word.
	 * 
	 * @return root and all suffixes from the last to first;
	 */
	public String breakApart() {
		stepOne();
		stepTwo();
		stepThree();
		stepFour();
		String s = "Word:";
		for (int x = 0; x < letters.size(); x++) {
			s += letters.get(x);
		}
		for (int i = 0; i < suffs.size(); i++) {
			s += " Suffix " + (i + 1) + ": " + suffs.get(i);
		}
		for (int i = 0; i < prefs.size(); i++) {
			s += " Prefix " + (i + 1) + ": " + prefs.get(i);
		}
		return s;
	}

	/**
	 * Check if the letters array ends in indicated string
	 * 
	 * @param s
	 *            does letters end in this string
	 * @return if letters ends in String
	 */
	private boolean ends(String s) {
		if (s.length() < letters.size()) {
			for (int i = 1; i <= s.length(); i++) {
				if (letters.get(letters.size() - i) != s.charAt(s.length() - i)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Check if the word begins with indicated string
	 */
	private boolean begins(String s) {
		if (s.length() < letters.size()) {
			for (int i = 0; i < s.length(); i++) {
				if (letters.get(i) != s.charAt(i)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * remove i elements from the front of letters arraylist
	 * @param i
	 */
	private void removeF(int i) {
		if (i < letters.size()) {
			for (int x = 0; x < i; x++) {
				letters.remove(0);
			}
		}
	}

	/**
	 * Check if the given letter is a consonant
	 * 
	 * @param i
	 *            given index of arraylist
	 * @return if consonant or not
	 */
	private final boolean cons(int i) {
		switch (letters.get(i)) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			return false;
		case 'y':
			return (i == 0) ? true : !cons(i - 1);
		default:
			return true;
		}
	}

	/**
	 * finds the consonant vowel order
	 * 
	 * @param s
	 * @return
	 */
	private final int m(String s) {
		int n = 0;
		int i = 0;
		int j = letters.size() - s.length();
		while (true) {
			if (i > j)
				return n;
			if (!cons(i))
				break;
			i++;
		}
		i++;
		while (true) {
			while (true) {
				if (i > j)
					return n;
				if (cons(i))
					break;
				i++;
			}
			i++;
			n++;
			while (true) {
				if (i > j)
					return n;
				if (!cons(i))
					break;
				i++;
			}
			i++;
		}
	}

	/**
	 * check if vowel is in stem
	 * 
	 * @return
	 */
	private final boolean vowelinstem(String s) {
		int i;
		int j = letters.size() - s.length();
		for (i = 0; i <= j; i++)
			if (!cons(i))
				return true;
		return false;
	}

	/**
	 * check if ends in a double consonant
	 * 
	 * @param j
	 * @return
	 */
	private final boolean doubleletter() {
		int j = letters.size() - 1;
		if (j < 1)
			return false;
		return letters.get(j) == letters.get(j - 1);
	}

	/*
	 * check if the ending is consonant vowel consonant
	 */

	private final boolean cvc() {
		return cons(letters.size() - 1) && !cons(letters.size() - 2)
				&& cons(letters.size() - 3);
	}

	/**
	 * removes x elements from the arraylist
	 * 
	 * @param x
	 */
	private void removeX(int x) {
		for (int i = 1; i <= x; i++) {
			letters.remove(letters.size() - 1);
		}
	}

	/**
	 * check if suffix is at the end of the string
	 * 
	 * @param s
	 */
	private void checkSuff(String s) {
		if (ends(s)) {
			suffs.add(s);
			removeX(s.length());
		}
	}
	/**
	 * check if the prefix is there
	 * @param s
	 */
	private void checkPref(String s){
		if(begins(s)){
			prefs.add(s);
			removeF(s.length());
		}
	}
	/**
	 * find the last suffixes such as "es" or "eed"
	 */
	private void stepOne() {
		if (ends("s")) {
			if (ends("sses")) {
				suffs.add("es");
				removeX(2);
			} else if (ends("ies")) {
				suffs.add("es");
				removeX(3);
				letters.add('y');
			} else if ((letters.get(letters.size() - 2) != 's')
					&& !ends("itis") && !ends("ous")) {
				suffs.add("s");
				removeX(1);
			}
		}
		if (ends("eed")) {
			if (m("eed") > 0) {
				removeX(1);
				suffs.add("d");
			}
		}

	}

	/**
	 * find middle suffixes such as "ity" and "ly"
	 */
	private void stepTwo() {
		if (ends("ity") && !ends("ivity")) {
			suffs.add("ity");
			removeX(3);
			if (ends("abil")) {
				removeX(2);
				letters.add('l');
				letters.add('e');
			}
		}
		if (ends("ly") && !ends("ably")) {
			suffs.add("ly");
			removeX(2);
		}
		if (ends("ness")) {
			suffs.add("ness");
			removeX(4);
			if (ends("i")) {
				removeX(1);
				letters.add('y');
			}
		}
		if (ends("y") && ends("" + letters.get(letters.size() - 2))) {
			suffs.add("y");
			removeX(2);
		}
		checkSuff("dom");

	}

	/**
	 * finds whatever is left in the suffixes
	 */
	private void stepThree() {
		if ((ends("ed") && vowelinstem("ed") && !ends("eed"))
				|| (ends("ing") && vowelinstem("ing") && !ends("ling"))) {
			if (ends("ed")) {
				suffs.add("ed");
				removeX(2);
			}
			if (ends("ing")) {
				suffs.add("ing");
				removeX(3);
			}
			if (ends("at"))
				letters.add('e');
			else if (ends("bl"))
				letters.add('e');
			else if (ends("iz"))
				letters.add('e');
			/*
			 * else if (doublec(letters.size()-1)) { { Character ch =
			 * letters.get(letters.size()-1); if (!(ch == 'l' || ch == 's' || ch
			 * == 'z')) letters.remove(letters.size()-1); } } else if (m() == 1
			 * && cvc(k)) setto("e");
			 */
		}
		if (ends("ess")) {
			suffs.add("ess");
			removeX(3);
			if (ends("r")) {
				removeX(1);
				letters.add('e');
				letters.add('r');
			} else if (ends("nc")) {
				letters.add('e');
			}
		}
		if (ends("ette")) {
			removeX(4);
			suffs.add("ette");
			if (cvc()) {
				letters.add('e');
			}
			if (doubleletter()) {
				removeX(1);
			}
		}
		if (ends("ish") && letters.size() > 5) {
			removeX(3);
			suffs.add("ish");
		}
		checkSuff("ling");
		checkSuff("able");
		checkSuff("ably");
		checkSuff("ance");
		if (ends("ancy") && letters.size() > 6) {
			removeX(4);
			suffs.add("ancy");
		}
		checkSuff("ship");
		if (ends("ee") && letters.size() > 5) {
			suffs.add("ee");
			removeX(2);
			if (cvc()) // check if it goes VC at the end
			{
				letters.add('e');
			}
		}
		if (ends("ant") && (letters.size() - 3 > 1)) {
			suffs.add("ant");
			removeX(2);
		}
		checkSuff("ilation");
		if (ends("ization")) {
			suffs.add("ation");
			removeX(5);
			letters.add('e');
		}
		if (ends("ation")) {
			suffs.add("ation");
			removeX(3);
			letters.add('e');
			if (ends("" + letters.get(letters.size() - 2))) {
				removeX(1);
			}
		}
		if (ends("tion") && !ends("ction")) {
			suffs.add("tion");
			removeX(4);
		}
		checkSuff("ion");
		if (ends("al") && !ends("inal")) {
			suffs.add("al");
			removeX(2);
			if(cvc()){
				letters.add('e');
			}
		}
		checkSuff("ive");
		if (ends("ivity")) {
			removeX(3);
			suffs.add("ivity");
			letters.add('e');
		}
		checkSuff("or");
		if (ends("er")) {
			suffs.add("er");
			removeX(2);
			if (ends("" + letters.get(letters.size() - 2))) {
				removeX(1);
			}
		}
		if (ends("est")) {
			suffs.add("est");
			removeX(3);
			if (ends("" + letters.get(letters.size() - 2))) {
				removeX(1);
			}
		}
		checkSuff("ful");
		checkSuff("itis");
		checkSuff("less");
		checkSuff("like");
		checkSuff("ment");
		if (ends("ious") && letters.size() != 5 && !ends("erious")) {
			suffs.add("ious");
			removeX(4);
		}
		if (ends("ous") && !ends("ious")) {
			suffs.add("ous");
			removeX(3);
		}
		if (ends("en")) {
			suffs.add("en");
			removeX(1);
		}
		checkSuff("ism");
		if (ends("ar")) {
			suffs.add("ar");
			removeX(2);
			if (letters.get(letters.size() - 2) == letters
					.get(letters.size() - 1)) {
				removeX(1);
			} else if (ends("i")) {
				letters.add('e');
			}
		}
		if(ends("ic")){
			suffs.add("ic");
			removeX(2);
			if(cvc()){
				letters.add('e');
			}
		}
	}

	/**
	 * finds first prefixes
	 */
	private void stepFour() {
		if(begins("dis") && letters.size()>4){
			checkPref("dis");
		}
		if(begins("di") && letters.size()>4){
			prefs.add("di");
			removeF(2);
		}
		checkPref("trans");
		/*if(begins("a") ){
			prefs.add("a");
			removeF(1);
		}*/
		if(begins("acro")){
			prefs.add("acro");
			removeF(4);
		}
		checkPref("allo");
		checkPref("alter");
		checkPref("ante");
		checkPref("anti");
		if(begins("an")){
			prefs.add("an");
			removeF(2);
		}
		checkPref("auto");
		if(begins("bi") && letters.size()>4){
			prefs.add("bi");
			removeF(2);
		}
		checkPref("contra");
		checkPref("coutner");
		
		if(begins("co") && letters.size()>4){
			prefs.add("co");
			removeF(2);
		}
		
		if(begins("de") && !ends("e")){
			prefs.add("de");
			removeF(2);
		}
		if(begins("down") && !ends("down")){
			prefs.add("down");
			removeF(4);
		}
		checkPref("dys");
		checkPref("epi");
		if(begins("extra") && !ends("extra")){
			prefs.add("extra");
			removeF(5);
		}
		checkPref("hemi");
		checkPref("hexa");
		if(begins("hyper") && !ends("hyper")){
			prefs.add("hyper");
			removeF(5);
		}
		checkPref("hypo");
		checkPref("il");
		checkPref("im");
		checkPref("infra");
		checkPref("inter");
		checkPref("intra");
		checkPref("in");
		checkPref("ir");
		checkPref("macro");
		checkPref("mal");
		checkPref("maxi");
		checkPref("meso");
		checkPref("micro");
		if(begins("mid") && !ends("dle"))
		{
			prefs.add("mid");
			removeF(3);
		}
		if(begins("mini") && !ends("ature")){
			prefs.add("mini");
			removeF(4);
		}
		checkPref("mis");
		checkPref("mono");
		if(begins("multi") && !ends("ple")){
			prefs.add("multi");
			removeF(5);
		}
		checkPref("non");
		checkPref("octo");
		checkPref("over");
		checkPref("pan");
		checkPref("para");
		checkPref("penta");
		checkPref("peri");
		checkPref("per");
		checkPref("poly");
		checkPref("post");
		checkPref("pre");
		checkPref("pro");
		checkPref("proto");
		checkPref("pseudo");
		checkPref("quadri");
		checkPref("quasi");
		if(begins("re") && letters.get(letters.size()-1) != 'e')
		{
			prefs.add("re");
			removeF(1);
		}
		checkPref("self");
		checkPref("semi");
		checkPref("sub");
		checkPref("super");
		checkPref("supra");
		checkPref("tetra");
		checkPref("tri");
		checkPref("ultra");
		checkPref("under");
		checkPref("un");
		checkPref("up");
		checkPref("xeno");
		checkPref("cyber");
	}

}
