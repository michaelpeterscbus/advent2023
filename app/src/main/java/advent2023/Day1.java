package advent2023;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

public class Day1 {

    @SneakyThrows
    public double getCallibrationSum(String filename) {
        var reader = new BufferedReader(new FileReader("src/test/resources/day1/" + filename));
        String line;
        double total = 0;
        while ((line = reader.readLine()) != null) {
            var characters = line.toCharArray();
            int left = 0;
            int right = characters.length - 1;
            var leftDigit = new StringBuilder();
            var rightDigit = new StringBuilder();
            while (leftDigit.isEmpty() || rightDigit.isEmpty()) {
                if (leftDigit.isEmpty() && Character.isDigit(characters[left])){
                    leftDigit.append(characters[left]);
                }

                if (rightDigit.isEmpty() && Character.isDigit(characters[right])) {
                    rightDigit.append(characters[right]);
                }
                left++;
                right--;
            }
            total += Double.parseDouble(leftDigit.append(rightDigit).toString());
        }
        return total;
    }

    @SneakyThrows
    public int pt2(String filename) {
        var reader = new BufferedReader(new FileReader("src/test/resources/day1/" + filename));
        String line;
        int total = 0;
        var numWords = Map.of(
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4,
                "five", 5,
                "six", 6,
                "seven", 7,
                "eight", 8,
                "nine", 9
        );
        while ((line = reader.readLine()) != null) {
            int left = 0;
            int right = line.length() - 1;
            int leftDigit = -1;
            int rightDigit = -1;
            while (leftDigit == -1 || rightDigit == -1) {
                leftDigit = getLeftDigit(line, numWords, left, leftDigit);
                rightDigit = getRightDigit(line, numWords, left, right, rightDigit);
                left++;
                right--;
            }
            total += leftDigit * 10 + rightDigit;
        }
        return total;
    }

    private int getLeftDigit(String line, Map<String, Integer> numWords, int index, int digit) {
        if (digit != -1) return digit;
        if (Character.isDigit(line.charAt(index))) {
            digit = Character.getNumericValue(line.charAt(index));
        } else {
            var currentString = line.substring(index);
            for (var num : numWords.keySet()) {
                if (currentString.startsWith(num)) {
                    digit = numWords.get(num);
                }
            }
        }
        return digit;
    }

    private int getRightDigit(String line, Map<String, Integer> numWords, int leftIndex, int rightIndex, int digit) {
        if (digit != -1) return digit;
        if (Character.isDigit(line.charAt(rightIndex))) {
            digit = Character.getNumericValue(line.charAt(rightIndex));
        } else {
            if (leftIndex < rightIndex) {
                var currentString = line.substring(leftIndex, rightIndex + 1);
                for (var num : numWords.keySet()) {
                    if (currentString.endsWith(num)) {
                        digit = numWords.get(num);
                    }
                }
            }
        }
        return digit;
    }
}
