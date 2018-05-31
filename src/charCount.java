import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class YangS_Project2_Java {	
	public static void main(String[] args) {
		Scanner inFile=null;
		PrintWriter outFile = null;
		char charIn;
		int index=0;
		int[] charCounts= new int[65536];
		int charCount=0;
		if (args.length<2) {
			System.out.println("Please specify input and output files.");
		}
		try {
			inFile = new Scanner (new FileReader(args[0]));
			outFile = new PrintWriter (args[1]);
		
		} catch(IOException e) {
			System.out.println(e);
		}
		System.out.println("Successfully openned input and output files.");
		
		inFile.useDelimiter("");
		while (inFile.hasNext()) {
			charIn=inFile.next().charAt(0);
			index = (int)charIn;
			//alphabets and special characters starts from 33 in unicode
			if (index>32) {
				charCounts[index]++;
			}
		}
		
		for (int i=0; i<65536; i++) {
			if (charCounts[i]>0) {
				outFile.println("Char"+(++charCount)+" "+(char)i+": # "+charCounts[i]+" ");
			}
		}
		inFile.close();
		outFile.close();
		System.out.println("Successfully output result to "+args[1]+".");
	}
}
