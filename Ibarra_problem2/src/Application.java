import java.io.File;
import java.io.IOException;
public class Application
{
   public static void main(String[] args)
   {   
	   try
	   {
		   File outFile = new File("unique_word_counts.txt");
		   if (outFile.createNewFile())
		   {
			   System.out.println("Created output file: " + outFile.getName());
		   }
		   else
		   {
			   System.out.println("File already exists.");
		   }
	   }
	   catch (IOException e)
	   {
		   System.out.println("File error occured.");
	   }
	   String input = "problem2.txt";
       String output = "unique_word_counts.txt";
      
       DuplicateCounter duplicateCounter = new DuplicateCounter();
       
       duplicateCounter.count(input);
       duplicateCounter.write(output);
       
       System.out.println("Succesfully written to output file " + output);
   }
}