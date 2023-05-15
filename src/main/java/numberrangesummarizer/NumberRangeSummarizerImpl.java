package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer{

    @Override
    public Collection<Integer> collect(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is empty.");
        }

        String[] elements = input.split(",");
        ArrayList<Integer> numbers = new ArrayList<>();
        HashSet<Integer> seenNumbers = new HashSet<>();

        if (elements.length == 0) {
            throw new IllegalArgumentException("Input contains only commas. The input should both contain digits and commas.");
        }

        for(String element: elements) {
            try {
                int num = Integer.parseInt(element.trim());

                if(seenNumbers.contains(num))
                    throw new IllegalArgumentException("Invalid input: \"" + element + "\" is a duplicate number.");

                numbers.add(num);
                seenNumbers.add(num);
            } catch(NumberFormatException e) {
                throw new NumberFormatException("Invalid input: \"" + element + "\" is not a valid number. The input should only contain digits and commas.");
            }
        }

        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        ArrayList<Integer> inputList = new ArrayList<>(input);
        Collections.sort(inputList);

        StringBuilder numbers = new StringBuilder();
        int i = 0;

        while (i < inputList.size()) {
            int begin = inputList.get(i);

            while (i < inputList.size() - 1 && inputList.get(i + 1) == (inputList.get(i) + 1)) {
                i++;
            }

            int end = inputList.get(i);

            if (numbers.length() > 0) {
                numbers.append(',');
            }

            if (begin == end) {
                numbers.append(begin);
            } else if (end - begin == 1) {
                numbers.append(begin).append(',').append(end);
            } else {
                numbers.append(begin).append('-').append(end);
            }

            i++;
        }

        return numbers.toString();
    }
}
