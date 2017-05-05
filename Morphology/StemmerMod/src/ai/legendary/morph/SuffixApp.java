package ai.legendary.morph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SuffixApp {

	public static void main(String[] args) {
		File file = new File("MorphInput.txt");
		Scanner scan;
		try {
			scan = new Scanner(file);
			while (scan.hasNext()) {
				MorphologyFinder suff = new MorphologyFinder(scan.nextLine());
				System.out.println(suff.breakApart());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}