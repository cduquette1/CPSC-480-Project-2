/**
 * CPSC 480 Assignment 2: Reverse File
 * @author Courtney Duquette
 * @version 10/21/2014
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Reversal {

    /**
     * This method reverses lines of text received from a text file 
     * and out prints it to a second output file.
     * 
     * @param input a text file with lines of text
     * @param output the lines in the input file in reverse order
     */
    public static void reverseFile(File input,  File output) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(input));
        PrintWriter writer = new PrintWriter(output);
        String text = null;
        ArrayList<String> allWords = new ArrayList<String>();
        
        try {
            while((text = reader.readLine()) != null) {
                allWords.add(" ");
                String[] words = text.split(" ");
                for(int i = 0; i < words.length; i++) {
                    allWords.add(words[i]);
                }
            }
            
            for(int i = (allWords.size() - 1); i > 1 ; i--) {
                if (!(allWords.get(i).equals(" "))) 
                    writer.print(allWords.get(i) + " ");
                else
                    writer.println();
            }
            writer.print(allWords.get(1));
            
            writer.close();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
