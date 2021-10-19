/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Seoyoung Kong
 */
package baseline;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Solution42Test
{
    Solution42 test = new Solution42();

    @Test
    void readInput() throws IOException
    {
        List<String> expected = List.of("Ling", "Mai","55900", "Johnson","Jim","56500", "Jones","Aaron","46000", "Jones","Chris","34500", "Swift", "Geoffrey", "14200","Xiong","Fong","65000","Zarnecki","Sabrina","51500");

        List<String> actual = test.readInput("data/exercise42_input.txt");

        assertEquals(expected, actual);
    }

}
