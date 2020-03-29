import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover 
{
    Set<String> uniqueWords;
    void remove(String dataFile)
    {
        Scanner input = null;
        try 
        {
            uniqueWords = new HashSet<>();
            input = new Scanner(new File(dataFile));
            
            // reads file line by line while splitting words
            // and placing them into an array of Strings
            while(input.hasNextLine())
            {
                String line = input.nextLine();
                String[] words = line.split(" ");
                
                // converting to lower case to apply to all capitalizations
                // and adding the unique words into the uniqueWords set
                for(int i = 0; i < words.length; i++) 
                {
                    String str = words[i].toLowerCase(); //converting into lower case
                    uniqueWords.add(str); //addin into set
                }
            }

        }
        // exception handling while opening file
        catch(Exception e)
        {
            System.out.println("Error while opening file: "+ dataFile);
        }
        if(input != null)
        {
        	input.close();
        }
    }
    void write(String outputFile)
    {
        // opening and writing words to the ouput file
    	FileWriter output = null;
        try 
        {
            output = new FileWriter(outputFile); 
            // iterating through set of uniqueWords
            for(String s:uniqueWords)
            {
            	output.write(s+"\n");
            }
            output.close(); //closing output file
        }
        // exception handling
        catch(Exception e)
        {
            System.out.println("Error while writing to file: "+ outputFile);
        }

    }

}