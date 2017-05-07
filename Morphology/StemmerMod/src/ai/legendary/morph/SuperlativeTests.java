package ai.legendary.morph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SuperlativeTests {

	public static void main(String [] args) {
		File f = new File("UniMorph-English_ADJ_Only.csv");
		try {
			Scanner s = new Scanner(f);
			s.useDelimiter(",");
			int count = 0;
			while(s.hasNext()){
				String p = s.next();
				//System.out.println(p);
				
				if(!p.equals("ADJ") && !p.equals("SPRL") && !p.equals("COMPV") && !p.equals("\n") && !p.equals(""))
				{
					String c = s.next();
					String [] spl = c.split("");
					int i =0;
					c="";
					while(i<spl.length && !spl[i].equals("\n"))
					{
						c += spl[i];
						i++;
					}
					c=c.substring(0,c.length()-1);
					c=c.toLowerCase();
					p=p.toLowerCase();
					/*System.out.println("C: "+c);
					System.out.println("P: "+p);*/
					MorphologyFinder find = new MorphologyFinder(p);
					String [] b = find.breakApart().split(" ");
					String d = b[0].substring(5,b[0].length());
					if(!c.equals(d)){
						System.out.println(p +" = "+c);
						System.out.println("but was: " + d);
						count++;
					}
				}
				
			}
			System.out.println("Incorrect Words: "+count);
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
