package com.impact;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import static org.junit.Assert.*;

public class NumberRangeSummarizerImplTest {

    /**
     * Test if String input is converted to List and equals testcase list.
     */
    @Test
    public void testCollectStringOutputCollectionList() {
        final NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(5);
        assertEquals(numberRangeSummarizer.collect("1,2,3,5"), testList);
    }

    /**
     * Test IllegalArgument Exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCollectIllegalArgumentException() {
        final NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();
        numberRangeSummarizer.collect("");
    }

    /**
     * Check that in converts to String and equals testCase list.
     */
    @Test
    public void testSummarizeCollectionConvertToString() {
        final NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(6);
        testList.add(7);
        testList.add(8);
        testList.add(12);
        testList.add(14);
        testList.add(15);
        testList.add(16);
        testList.add(17);
        assertEquals("1, 6-8, 12, 14-17", numberRangeSummarizer.summarizeCollection(testList));
    }

    /**
     * Test IllegalArgument Exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSummarizeCollectionIllegalArgumentException() {
        final NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();
        numberRangeSummarizer.summarizeCollection(null);
    }

    @Test
    public void tesRemovalOftTrailingComma() {
        final NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(6);
        testList.add(7);
        testList.add(8);
        assertEquals("1, 6-8", numberRangeSummarizer.summarizeCollection(testList));
    }
}
