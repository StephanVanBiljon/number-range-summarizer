package numberrangesummarizer;

import java.util.Collection;
import numberrangesummarizer.NumberRangeSummarizerImpl;

public class MainClass {
    public static void main(String[] args) {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> numbers = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");

        String result = summarizer.summarizeCollection(numbers);

        System.out.println(result);
    }
}
