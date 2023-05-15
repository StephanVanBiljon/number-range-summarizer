package numberrangesummarizer;

import java.util.Collection;

public class MainClass {
    public static void main(String[] args) {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> numbers = summarizer.collect(input);

        String result = summarizer.summarizeCollection(numbers);

        System.out.println("Input String: " + input);
        System.out.println("Output String: " + result);
    }
}
