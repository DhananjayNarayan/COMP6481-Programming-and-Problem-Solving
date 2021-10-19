package Assignment2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;

class FileInvalidException extends Exception{
	FileInvalidException(){
		super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)");
	}
	
	FileInvalidException(FileInvalidException e){
		super(e);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}


public class BibCreator {

	public static void main(String[] args) throws FileInvalidException, FileNotFoundException{
		System.out.println("Welcome to BibCreator!");
		
		Scanner kb = new Scanner(System.in); 
		
		Scanner scn;
		
		//Opening all the 10 files for reading
		int i = 1;
		while(i<= 10)
		{
			String fNameRead = "Latex" + i + ".bib";
			
			try {
				scn = new Scanner(new FileInputStream(fNameRead));
				
				if(fNameRead != scn.toString()) {
					throw new FileInvalidException();
				}
			}
			catch(FileInvalidException e) {
				System.out.println("Could not open input file " + fNameRead + "for reading. \n"
						+ "Please check if file exists! "
						+ "Program will terminate after closing any opened files.");
			}
			i++;
		}
		
		//Opening all the files to Write
		PrintWriter pw;
		int j = 1; 
		while(j <=10) {
			String fNameWrite = "Latex" + i + ".bib";
			try {
				pw = new PrintWriter(new FileOutputStream(fNameWrite));
				if(fNameWrite != pw.toString()) {
					throw new FileInvalidException();
				}
			}
			catch(FileInvalidException e) {
				
			}
		}
		
		
	}

}
