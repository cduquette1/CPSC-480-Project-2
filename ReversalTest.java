/**
 * CPSC 480 Assignment 2: Reverse File Test Class
 * @author Courtney Duquette
 * @version 10/21/2014
 */


import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

public class ReversalTest {

    @Test(expected = FileNotFoundException.class)
    public void testException() throws FileNotFoundException {
        File input = new File("temp.txt");
        File output = new File("temp.txt");
        
        Reversal.reverseFile(input, output);
    }
    
    @Test
    public void testOneLine() throws IOException {
        File input = new File("Input.txt");
        File output = new File("Output.txt");
        
        String expected = "amet sit dolor ipsum Lorem";
        addTextToFile("Input.txt", "Lorem ipsum dolor sit amet");
        addTextToFile("Output.txt", expected);
        
        Reversal.reverseFile(input, output);
        String actual = covertFileToString("Output.txt");
        
        assertEquals("One line did not work", expected, actual);
    }
    
    
    
    private void addTextToFile(String fileName, String text) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(fileName);
        writer.println(text);
        writer.close();
    }
    
    private String covertFileToString(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String text = null;
        String allWords = "";
        
        while((text = reader.readLine()) != null) {
            allWords = allWords + text;
        }
        
        return allWords;
    }

}
