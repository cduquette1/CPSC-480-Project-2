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

    @Test
    public void testConstructor() {
        Reversal temp = new Reversal();
        assertTrue(temp != null);
    }
    
    @Test(expected = FileNotFoundException.class)
    public void testException() throws FileNotFoundException {
        File input = new File("temp.txt");
        File output = new File("temp.txt");
        
        Reversal.reverseFile(input, output);
    }
    
    @Test(expected = IOException.class)
    public void testIOException() throws FileNotFoundException {
        File input = new File("temp.txt");
        File output = new File("temp.txt");
        
        Reversal.reverseFile(input, output);
    }
    
    @Test
    public void testEmptyFile() throws IOException {
        File input = new File("Input.txt");
        File output = new File("Output.txt");
        
        String expected = "";
        addTextToFile("Input.txt", "");
        addTextToFile("Output.txt", expected);
        
        Reversal.reverseFile(input, output);
        String actual = covertFileToString("Output.txt");
        
        assertEquals("Empty File did not work", expected, actual);
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
    
    @Test
    public void testTwoLines() throws IOException {
        File input = new File("Input.txt");
        File output = new File("Output.txt");
        
        String expected = "elit. adipiscing consectetur" + System.lineSeparator() +
                          "amet sit dolor ipsum Lorem";
        addTextToFile("Input.txt", "Lorem ipsum dolor sit amet" + System.lineSeparator() +
                                   "consectetur adipiscing elit.");
        addTextToFile("Output.txt", expected);

        Reversal.reverseFile(input, output);
        String actual = covertFileToString("Output.txt");
        
        assertEquals("Two lines did not work", expected, actual);
    }
    
    
    @Test
    public void testThreeLines() throws IOException {
        File input = new File("Input.txt");
        File output = new File("Output.txt");
        
        String expected = "elit. adipiscing consectetur" + System.lineSeparator() +
                          System.lineSeparator() + "amet sit dolor ipsum Lorem";
        addTextToFile("Input.txt", "Lorem ipsum dolor sit amet" + System.lineSeparator() +
                                   System.lineSeparator() + "consectetur adipiscing elit.");
        addTextToFile("Output.txt", expected);

        Reversal.reverseFile(input, output);
        String actual = covertFileToString("Output.txt");
        
        assertEquals("Three lines did not work", expected, actual);
    }
    
    @Test
    public void testSixLines() throws IOException {
        File input = new File("Input.txt");
        File output = new File("Output.txt");
        
        String expected = "elit. adipiscing consectetur" + System.lineSeparator() +
                          System.lineSeparator() + "amet sit dolor ipsum Lorem" +
                          System.lineSeparator() + System.lineSeparator() +
                          "elit. adipiscing consectetur" + System.lineSeparator() +
                          System.lineSeparator() + "amet sit dolor ipsum Lorem";
        addTextToFile("Input.txt", "Lorem ipsum dolor sit amet" + System.lineSeparator() +
                                   System.lineSeparator() + "consectetur adipiscing elit." + 
                                   System.lineSeparator() + System.lineSeparator() + 
                                   "Lorem ipsum dolor sit amet" + System.lineSeparator() +
                                   System.lineSeparator() + "consectetur adipiscing elit.");
        addTextToFile("Output.txt", expected);

        Reversal.reverseFile(input, output);
        String actual = covertFileToString("Output.txt");
        
        assertEquals("Six lines did not work", expected, actual);
    }
    
    @Test
    public void testLargeData() throws IOException {
        File input = new File("Input.txt");
        File output = new File("Output.txt");
        
        String inputText = "a a c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() + System.lineSeparator() + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z"
                + System.lineSeparator() +
                "a b c d e f g h i j k l m n o p q r s t u v w x z z";
        
        String expected = "z z x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() + 
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() + 
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() + System.lineSeparator() + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() + 
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() + 
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c b a"
                + System.lineSeparator() + System.lineSeparator() +
                "z y x w v u t s r q p o n m l k j i h g f e d c a a";
        
        addTextToFile("Input.txt", inputText);
        addTextToFile("Output.txt", expected);

        Reversal.reverseFile(input, output);
        String actual = covertFileToString("Output.txt");
        
        assertEquals("Large data did not work", expected, actual);
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
        boolean firstLine = true;
        
        while((text = reader.readLine()) != null) {
            if(firstLine) {
                allWords = allWords + text;
                firstLine = false;
            }
            else {
                allWords = allWords + System.lineSeparator() + text;
            }    
        }
        return allWords;
    }

}
