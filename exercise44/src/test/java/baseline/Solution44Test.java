/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Seoyoung Kong
 */

package baseline;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class Solution44Test
{
    Solution44 test = new Solution44();

    @Test
    void readJson() throws IOException
    {
        Inventory testInventory = test.readJSON();

        String actual = testInventory.search("Thing").getName();
        String expected = "Thing";

        int actualQuantity = testInventory.search("Thing").getQuantity();
        int expectedQuantity = 5;

        assertEquals(expected, actual);
        assertEquals(expectedQuantity, actualQuantity);
    }

}
