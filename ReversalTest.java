/**
 * CPSC 480 Assignment 2: Reverse File Test Class
 * @author Courtney Duquette
 * @version 10/21/2014
 */


import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class ReversalTest {

    @Test(expected = FileNotFoundException.class)
    public void test() throws FileNotFoundException {
        File input = new File("temp.txt");
        File output = new File("temp.txt");
        
        Reversal.reverseFile(input, output);
    }

}
