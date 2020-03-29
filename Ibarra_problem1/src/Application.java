import java.io.File;
import java.io.IOException;

public class Application 
{
	public static void main(String[] args)
	{
		try
		   {
			   File outFile = new File("unique_words.txt");
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
		
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		duplicateRemover.remove("problem1.txt");
		duplicateRemover.write("unique_words.txt");
	}
}