import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCounter
{
   private HashMap<String, Integer> wordCounter;
   // helper method to lower all upper case characters
   // and to set up the presentation of the output file
   private String outputPresentation(String word)
   {
       String str = "";
       for(int i = 0; i < word.length(); i++)
       {
           char c = word.charAt(i);
           if(Character.isAlphabetic(c))
           {
        	   str = str + c;
           }
       }
       return str.toLowerCase().trim();
   }
   // used to instantiate a wordCounter object
   public DuplicateCounter()
   {
       wordCounter = new HashMap<String, Integer>();
   }

   public void count(String dataFile)
   {
       wordCounter.clear();
       try
       {
           Scanner in = new Scanner(new File(dataFile));
           String word;
           
           while(in.hasNext())
           {
               word = in.next();
               word = outputPresentation(word);
               
               if(!word.equals("")) 
               {
                   if(wordCounter.get(word) == null)
                   {
                	   wordCounter.put(word, 1);
                   }
                   else
                   {
                	   wordCounter.put(word, wordCounter.get(word) + 1);
                   }
               }
           }
           in.close();
       }
       catch(Exception e)
       {
           System.out.println("Error while opening file: "+ dataFile);
       }
   }


   public void write(String outputFile)
   {
       try
       {
           PrintWriter output = new PrintWriter(new File(outputFile));
           for(String word : wordCounter.keySet())
           {
               output.println(word + " " + wordCounter.get(word));
           }
           output.close();
       }
       catch(Exception e)
       {
           System.out.println("Error while writing to file: "+ outputFile);
       }
   }
}


