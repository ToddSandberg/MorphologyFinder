package ai.legendary.morph;

import static org.junit.Assert.*;

import org.junit.Test;

public class MorphologyFinderTest {

	@Test
	public void acceptTest() {
		String expected = "Word:accept";
		MorphologyFinder s = new MorphologyFinder("accept");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void acceptabilitiesTest() {
		String expected = "Word:accept Suffix 1: es Suffix 2: ity Suffix 3: able";
		MorphologyFinder s = new MorphologyFinder("acceptabilities");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void wantedTest() {
		String expected = "Word:want Suffix 1: ed";
		MorphologyFinder s = new MorphologyFinder("wanted");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void tendonitisTest() {
		String expected = "Word:tendon Suffix 1: itis";
		MorphologyFinder s = new MorphologyFinder("tendonitis");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void wonderfulTest() {
		String expected = "Word:wonder Suffix 1: ful";
		MorphologyFinder s = new MorphologyFinder("wonderful");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void boysTest() {
		String expected = "Word:boy Suffix 1: s";
		MorphologyFinder s = new MorphologyFinder("boys");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void playingTest() {
		String expected = "Word:play Suffix 1: ing";
		MorphologyFinder s = new MorphologyFinder("playing");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void friendlyTest() {
		String expected = "Word:friend Suffix 1: ly";
		MorphologyFinder s = new MorphologyFinder("friendly");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void teacherTest() {
		String expected = "Word:teach Suffix 1: er";
		MorphologyFinder s = new MorphologyFinder("teacher");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void actionTest() {
		String expected = "Word:act Suffix 1: ion";
		MorphologyFinder s = new MorphologyFinder("action");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void finalTest() {
		String expected = "Word:final";
		MorphologyFinder s = new MorphologyFinder("final");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void acceptingnessesTest() {
		String expected = "Word:accept Suffix 1: es Suffix 2: ness Suffix 3: ing";
		MorphologyFinder s = new MorphologyFinder("acceptingnesses");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void enjoymentTest() {
		String expected = "Word:enjoy Suffix 1: ment";
		MorphologyFinder s = new MorphologyFinder("enjoyment");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void seriousTest() {
		String expected = "Word:serious";
		MorphologyFinder s = new MorphologyFinder("serious");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void livenTest() {
		String expected = "Word:live Suffix 1: en";
		MorphologyFinder s = new MorphologyFinder("liven");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void biggerTest() {
		String expected = "Word:big Suffix 1: er";
		MorphologyFinder s = new MorphologyFinder("bigger");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void biggestTest() {
		String expected = "Word:big Suffix 1: est";
		MorphologyFinder s = new MorphologyFinder("biggest");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void attentiveTest() {
		String expected = "Word:attent Suffix 1: ive";
		MorphologyFinder s = new MorphologyFinder("attentive");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void acceptilationsTest() {
		String expected = "Word:accept Suffix 1: s Suffix 2: ilation";
		MorphologyFinder s = new MorphologyFinder("acceptilations");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void agreedTest() {
		String expected = "Word:agree Suffix 1: d";
		MorphologyFinder s = new MorphologyFinder("agreed");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void meetingsTest() {
		String expected = "Word:meet Suffix 1: s Suffix 2: ing";
		MorphologyFinder s = new MorphologyFinder("meetings");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void poniesTest() {
		String expected = "Word:pony Suffix 1: es";
		MorphologyFinder s = new MorphologyFinder("ponies");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void feedTest() {
		String expected = "Word:feed";
		MorphologyFinder s = new MorphologyFinder("feed");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void organizationTest() {
		String expected = "Word:organize Suffix 1: ation";
		MorphologyFinder s = new MorphologyFinder("organization");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void weaklingdomTest() {
		String expected = "Word:weak Suffix 1: dom Suffix 2: ling";
		MorphologyFinder s = new MorphologyFinder("weaklingdom");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void terrorismTest() {
		String expected = "Word:terror Suffix 1: ism";
		MorphologyFinder s = new MorphologyFinder("terrorism");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void ducklingishTest() {
		String expected = "Word:duck Suffix 1: ish Suffix 2: ling";
		MorphologyFinder s = new MorphologyFinder("ducklingish");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void relationshipTest() {
		String expected = "Word:relate Suffix 1: ship Suffix 2: ation";
		MorphologyFinder s = new MorphologyFinder("relationship");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void judgementTest() {
		String expected = "Word:judge Suffix 1: ment";
		MorphologyFinder s = new MorphologyFinder("judgement");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void piousTest() {
		String expected = "Word:pious";
		MorphologyFinder s = new MorphologyFinder("pious");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void piouslikeTest() {
		String expected = "Word:pious Suffix 1: like";
		MorphologyFinder s = new MorphologyFinder("piouslike");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void intervieweeTest() {
		String expected = "Word:view Suffix 1: ee Prefix 1: inter";
		MorphologyFinder s = new MorphologyFinder("interviewee");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void retireeTest() {
		String expected = "Word:retire Suffix 1: ee";
		MorphologyFinder s = new MorphologyFinder("retiree");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void beggarTest() {
		String expected = "Word:beg Suffix 1: ar";
		MorphologyFinder s = new MorphologyFinder("beggar");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void liarTest() {
		String expected = "Word:lie Suffix 1: ar";
		MorphologyFinder s = new MorphologyFinder("liar");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void waitressTest() {
		String expected = "Word:wait Suffix 1: ess Suffix 2: er";
		MorphologyFinder s = new MorphologyFinder("waitress");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void princessTest() {
		String expected = "Word:prince Suffix 1: ess";
		MorphologyFinder s = new MorphologyFinder("princess");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void disketteTest() {
		String expected = "Word:disk Suffix 1: ette";
		MorphologyFinder s = new MorphologyFinder("diskette");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void pipetteTest() {
		String expected = "Word:pipe Suffix 1: ette";
		MorphologyFinder s = new MorphologyFinder("pipette");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void fishTest() {
		String expected = "Word:fish";
		MorphologyFinder s = new MorphologyFinder("fish");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void fancyTest() {
		String expected = "Word:fancy";
		MorphologyFinder s = new MorphologyFinder("fancy");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void festivityTest() {
		String expected = "Word:festive Suffix 1: ivity";
		MorphologyFinder s = new MorphologyFinder("festivity");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void transdimensionalTest() {
		String expected = "Word:dimension Suffix 1: al Prefix 1: trans";
		MorphologyFinder s = new MorphologyFinder("transdimensional");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void allomorphicTest() {
		String expected = "Word:morph Suffix 1: ic Prefix 1: allo";
		MorphologyFinder s = new MorphologyFinder("allomorphic");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void alternatingTest() {
		String expected = "Word:nate Suffix 1: ing Prefix 1: alter";
		MorphologyFinder s = new MorphologyFinder("alternating");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void automaticTest() {
		String expected = "Word:mate Suffix 1: ic Prefix 1: auto";
		MorphologyFinder s = new MorphologyFinder("automatic");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void middleTest() {
		String expected = "Word:middle";
		MorphologyFinder s = new MorphologyFinder("middle");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void multiculturalTest() {
		String expected = "Word:culture Suffix 1: al Prefix 1: multi";
		MorphologyFinder s = new MorphologyFinder("multicultural");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void supermarketTest() {
		String expected = "Word:market Prefix 1: super";
		MorphologyFinder s = new MorphologyFinder("supermarket");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void cyberspaceTest() {
		String expected = "Word:space Prefix 1: cyber";
		MorphologyFinder s = new MorphologyFinder("cyberspace");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
	@Test
	public void decluttererTest() {
		String expected = "Word:clutter Suffix 1: er Prefix 1: de";
		MorphologyFinder s = new MorphologyFinder("declutterer");
		String actual = s.breakApart();
		assertEquals(expected,actual);
	}
}
