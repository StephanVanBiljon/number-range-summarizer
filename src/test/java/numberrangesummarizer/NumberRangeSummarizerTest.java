package numberrangesummarizer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class NumberRangeSummarizerTest {
    @Test
    public void returnListForAscendingIntegers() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        String input = "1,2,3,4,7,8,9,11,15,20";

        ArrayList<Integer> actualCollection = (ArrayList<Integer>) summarizer.collect(input);
        ArrayList<Integer> expectedCollection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,7,8,9,11,15,20));

        assertEquals(expectedCollection, actualCollection);
    }

    @Test
    public void returnListForNegativeIntegers() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        String input = "-4,-3,-1,0,1,2,5,7";

        ArrayList<Integer> actualCollection = (ArrayList<Integer>) summarizer.collect(input);
        ArrayList<Integer> expectedCollection = new ArrayList<Integer>(Arrays.asList(-4,-3,-1,0,1,2,5,7));

        assertEquals(expectedCollection, actualCollection);
    }

    @Test
    public void returnListForUnorderedIntegers() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        String input = "3,5,1,99,21,19,18,300,2,4,17,14";

        ArrayList<Integer> actualCollection = (ArrayList<Integer>) summarizer.collect(input);
        ArrayList<Integer> expectedCollection = new ArrayList<Integer>(Arrays.asList(3,5,1,99,21,19,18,300,2,4,17,14));

        assertEquals(expectedCollection, actualCollection);
    }

    @Test
    public void returnListForSingularInteger() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        String input = "6";

        ArrayList<Integer> actualCollection = (ArrayList<Integer>) summarizer.collect(input);
        ArrayList<Integer> expectedCollection = new ArrayList<Integer>(Arrays.asList(6));

        assertEquals(expectedCollection, actualCollection);
    }

    @Test
    public void failForDuplicateIntegers() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        String input = "2,3,5,7,8,9,9,10";

        try {
            ArrayList<Integer> actualCollection = (ArrayList<Integer>) summarizer.collect(input);
        } catch (IllegalArgumentException e) {
            String expectedMessage = "Invalid input: \"9\" is a duplicate number.";
            String actualMessage = e.getMessage();

            assertEquals(expectedMessage, actualMessage);
        }
    }

    @Test
    public void failForEmptyInput() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        String input = " ";

        try {
            ArrayList<Integer> actualCollection = (ArrayList<Integer>) summarizer.collect(input);
        } catch (IllegalArgumentException e) {
            String expectedMessage = "Input is empty.";
            String actualMessage = e.getMessage();

            assertEquals(expectedMessage, actualMessage);
        }
    }

    @Test
    public void failForOnlyDelimiters() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        String input = ",,,";

        try {
            ArrayList<Integer> actualCollection = (ArrayList<Integer>) summarizer.collect(input);
        } catch (IllegalArgumentException e) {
            String expectedMessage = "Input contains only commas. The input should both contain digits and commas.";
            String actualMessage = e.getMessage();

            assertEquals(expectedMessage, actualMessage);
        }
    }

    @Test
    public void failForNonIntegerInput() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        String input = "1,2,3,4,five,6";

        try {
            ArrayList<Integer> actualCollection = (ArrayList<Integer>) summarizer.collect(input);
        } catch (IllegalArgumentException e) {
            String expectedMessage = "Invalid input: \"five\" is not a valid number. The input should only contain digits and commas.";
            String actualMessage = e.getMessage();

            assertEquals(expectedMessage, actualMessage);
        }
    }

    @Test
    public void returnStringRangesForOrderedCollection() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> numbers = summarizer.collect("1,2,3,4,7,8,9,11,15,20");

        String actualString = summarizer.summarizeCollection(numbers);
        String expectedString = "1-4,7-9,11,15,20";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void returnStringForNegativeIntegers() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> numbers = summarizer.collect("-4,-3,-1,0,1,2,5,7");

        String actualString = summarizer.summarizeCollection(numbers);
        String expectedString = "-4,-3,-1-2,5,7";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void returnStringRangesForUnorderedCollection() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> numbers = summarizer.collect("3,5,1,99,21,19,18,300,2,4,17,14");

        String actualString = summarizer.summarizeCollection(numbers);
        String expectedString = "1-5,14,17-19,21,99,300";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void returnStringForCollectionWithoutRanges() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> numbers = summarizer.collect("1,2,4,7,9,11,15,20");

        String actualString = summarizer.summarizeCollection(numbers);
        String expectedString = "1,2,4,7,9,11,15,20";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void returnStringForSingularInteger() {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> numbers = summarizer.collect("6");

        String actualString = summarizer.summarizeCollection(numbers);
        String expectedString = "6";

        assertEquals(expectedString, actualString);
    }
}