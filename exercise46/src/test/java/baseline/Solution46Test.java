/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Seoyoung Kong
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Solution46Test
{
    Solution46 test = new Solution46();

    @Test
    void search()throws IOException
    {
        String actual = test.search().toString();
        String expected = "{snake=1, mushroom=2, badger=7}";

        assertEquals(expected, actual);
    }

    @Test
    void createHistogram()
    {
        Map<String, Integer> testSortedMap = new LinkedHashMap<>();
        testSortedMap.put("badger", 7);
        testSortedMap.put("mushroom", 2);
        testSortedMap.put("snake", 1);

        String actual = test.createHistogram(testSortedMap);
        String expected = "badger:     *******%nmushroom:   **%nsnake:      *%n";

        assertEquals(expected, actual);
    }

}
