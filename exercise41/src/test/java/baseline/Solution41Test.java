/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Seoyoung Kong
 */
package baseline;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Solution41Test {
    Solution41 test = new Solution41();

    @Test
    void readNames() throws IOException {
        List<String> names = test.readNames("data/exercise41_input.txt");

        String expected = names.toString();

        String actual = "[Ling, Mai\r" + ", Johnson, Jim\r" + ", Zarnecki, Sabrina\r" + ", Jones, Chris\r" + ", Jones, Aaron\r" + ", Swift, Geoffrey\r" + ", Xiong, Fong\r" + "]";

        assertEquals(expected, actual);
    }
}