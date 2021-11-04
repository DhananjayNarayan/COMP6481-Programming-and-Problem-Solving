import java.io.*;
import java.util.*;


 class FileInvalidException extends Exception{
	
	public FileInvalidException()
	{
		super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.) ");
	}
	
	public FileInvalidException(String message)
	{
		super(message);
	}
	
	public String getMessage()
	{
		return super.getMessage();
	}
}

public class BibCreator {
	
	public static int validCounter=0; 
	public static int invalidCounter=0; 

	
	public static void main(String[] args){
		
		Scanner sc = null;
		Scanner kb = new Scanner(System.in);
		
		PrintWriter ieee = null; //for the PrintWriter to write the files
		PrintWriter acm = null;
		PrintWriter nj = null;
	
		BufferedReader br = null; //for the BufferedReader to read the files created
		String readFile =""; //name of the file being read by BufferedReader
		

		System.out.println("Welcome to BibCreator!\n");
		
		//TASK 3 - Attempt to Open All the Files
		for (int i = 1; i <= 10; i++) 
		{
			try
			{   
				String fName = "Latex" + i + ".bib";
				sc = new Scanner(new FileInputStream(fName));			
			}
			catch (FileNotFoundException e) 
			{
				System.out.println("Could not open input file Latex" + i + ".bib for reading.\n\nPlease check if file exists! Program will terminate after closing any opened files.");
				sc.close();
				System.exit(0);
			}
		}
		
//Task 4 - Creating 30 Output Files. If Unsuccessful, will delete all the created output files.
		for (int i = 1; i <= 10; i++) {
			try {
				String fName = "Latex" + i + ".bib";
				sc = new Scanner(new FileInputStream(fName));
				
				ieee = new PrintWriter(new FileOutputStream("IEEE" + i + ".json"));
				acm = new PrintWriter(new FileOutputStream("ACM" + i + ".json"));
				nj = new PrintWriter(new FileOutputStream("NJ" + i + ".json"));
				
				try {				
					processFilesForValidation(i,sc, ieee, acm, nj);					
				} 
				catch (FileInvalidException e) {					
					ieee.close();
					acm.close();
					nj.close();
					deleteFile(i);
				} 

			} catch (FileNotFoundException e) {				
				sc.close(); 
				System.out.println("Could not open or create input file Latex" + i + ".bib.\n\nPlease check if file exists! Program will terminate after closing any opened files.");
				deleteFile(i);
				System.exit(0);
			}		
		}
		System.out.println("\n\nA total of " + invalidCounter + " files were invalid, and could not be processed. All other " + validCounter + " Valid files have been created.\n");
		
		//TASK 7 - User Attempt to read the created files		
			System.out.println("Please enter the name of the file that you need to review:");
			readFile = kb.next();
			
			try {
				br = new BufferedReader(new FileReader(readFile));
				System.out.println("Here are the contents of the successfully created JSON File: " + readFile);
				displayCreatedFiles(br);
				}
			
			catch (FileNotFoundException e) {					
					System.out.println("Could not open input file! Either file does not exist or could not be created.");
					System.out.println("\nHowever, you will be allowed another chance to enter another file name.\n");
					
					try {						
						System.out.println("Please enter the name of the file that you need to review:");
						readFile = kb.next();
						br = new BufferedReader(new FileReader(readFile));
						System.out.println("Here are the contents of the successfully created JSON File: " + readFile);
						displayCreatedFiles(br);
					}
					
					catch (FileNotFoundException e1) {
						System.out.println("Sorry! Cannot display your desired file! Program will exit!");
						System.exit(0);
					}
					
					catch(IOException e1) {
						System.out.println("Error occured while reading the file: " + readFile);
						System.out.println("Program will terminate");
						System.exit(0);
					}
			}
			
			catch(IOException e) {
				System.out.println("Error occured while reading the file: " + readFile);
				System.out.println("Program will terminate");
				System.exit(0);
			}
		
			System.out.println("\n\nGoodbye! Hope you have enjoyed creating the needed files using BibCreator.");
		
		
	}
		
	private static void displayCreatedFiles(BufferedReader br) throws IOException {
		int x;
		x = br.read();
		while (x != -1) {
			System.out.print((char)x);
			x = br.read();
		}	
		br.close();
	}

	public static void deleteFile(int i){
		
		File file = null;
		file = new File("IEEE"+ i +".json");
		file.delete();
		file = new File("ACM" + i + ".json");
		file.delete();
		file = new File("NJ" + i + ".json");
		file.delete();
	}	
	
	private static void processFilesForValidation(int i, Scanner sc, PrintWriter ieee, PrintWriter acm, PrintWriter nj) throws FileInvalidException{

		String str="";
		int numArticle =0;
		
		StringTokenizer stkn = null; 
		String[] token;
		
		String IEEE=""; //the final variable that will be output into the ieee.json file
		String ACM=""; //the final variable that will be output into the acm.json file
		String NJ=""; //the final variable that will be output into the nj.json file
		
		String Author =""; 
		String IEEEauthor="";
		String ACMauthor="";
		String NJauthor="";
		
		String Title="";			
		String Journal="";	
		String Volume ="";		
		String Number="";				
		String Page="";			
		String Month="";		
		String Year="";	
		String DOI ="";
		
		while (sc.hasNextLine()) { 
			
			str= sc.nextLine();
			
			if (str.contains("={}")){ 
				invalidCounter++; 
				System.out.println("Error : Detected Emply Field!");
				System.out.println("=============================");
				System.out.println("Problem detected with input file :"+"Latex" + i + ".bib");
				System.out.println("File Invalid. Field \"" + str.substring(0, str.indexOf("=")) + "\" is Empty. Processing stopped at this point. Other empty fields may be present as well!\n");
				throw new FileInvalidException();
			}
			
			else {
				
			if (str.contains("@ARTICLE{")) { 
				numArticle++;
			}
			
			if (str.contains("author={")) { 
				Author = str.substring(str.indexOf("{")+1, str.indexOf("}"));	
	
				IEEEauthor = Author.replaceAll(" and", ",");	
				NJauthor = Author.replaceAll("and", "&");
				
				stkn = new StringTokenizer(Author, " "); //Tokenize the lengthy authors
				token = new String[stkn.countTokens()];
				for(int j=0; j<stkn.countTokens(); j++){
					token[j] = stkn.nextToken(); //Assign the separated words into token[]
				}				
				ACMauthor = token[0] + " " + token[1] + " et al";		
			}
			
			if (str.contains("title={")) { //when it reaches the field title, it copies the content of it and assign the its respected variables
				Title = str.substring(str.indexOf("{")+1, str.indexOf("}"));	
			}
			
			if (str.contains("journal={")) { //when it reaches the field journal, it copies the content of it and assign the its respected variables
				Journal = str.substring(str.indexOf("{")+1, str.indexOf("}")); 
			}
			
			if (str.contains("volume={")){ //when it reaches the field volume, it copies the content of it and assign the its respected variables
				Volume = str.substring(str.indexOf("{")+1, str.indexOf("}")); 
			
			}
			
			if (str.contains("number={")) { //when it reaches the field number, it copies the content of it and assign the its respected variables
				Number = str.substring(str.indexOf("{")+1, str.indexOf("}")); 
			}
			
			if (str.contains("pages={")) { //when it reaches the field pages, it copies the content of it and assign the its respected variables
				Page = str.substring(str.indexOf("{")+1, str.indexOf("}")); 
			}
			
			if (str.contains("month={")){ //when it reaches the field month, it copies the content of it and assign the its respected variables
				Month = str.substring(str.indexOf("{")+1, str.indexOf("}")); 
			}
			
			if (str.contains("year={")){ //when it reaches the field year, it copies the content of it and assign the its respected variables
				Year = str.substring(str.indexOf("{")+1, str.indexOf("}")); 
			}			
			
			if (str.contains("doi={")){ //when it reaches the field doi, it copies the content of it and assign the its respected variables
				DOI = "DOI:https://doi.org/" + str.substring(str.indexOf("{")+1, str.indexOf("}"));
			}
			
			
			if (str.equals("}")){ //once it reaches the end of the article, it combines each field into one single output so that it can be written properly into the respective file and format
				IEEE = IEEEauthor +". " + "\""+Title+"\"" +", " + Journal +", " + "vol. " + Volume +", " + "no. " +Number +", " + "p. " + Page +", " + Month + " " + Year +".";
				ieee.println(IEEE);
				ieee.println();
				
				ACM = "["+numArticle+"] "+ ACMauthor + ". " + Year +". " + Title + ". " + Journal + ". " + Volume + ", " + Number + " (" + Year + "), " + Page +". " + DOI +".";
				acm.println(ACM);
				acm.println();
				
				NJ = NJauthor + ". " + Title + ". " + Journal + ". " + Volume + ", " + Page + " (" + Year + ").";
				nj.println(NJ);
				nj.println();
			}
			
			}
			
			if (sc.hasNextLine() == false) {
				validCounter++; 
			}
			
		}
		ieee.close();
		acm.close();
		nj.close();
		sc.close();		
	}
	
}