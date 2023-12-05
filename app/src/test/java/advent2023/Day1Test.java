package advent2023;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

    private final Day1 subject = new Day1();

    @Test
    void sampleInput() {
        var result = subject.getCallibrationSum("sampleInput.txt");

        assertThat(result).isEqualTo(142);
    }

    @Test
    void answer() {
        var result = subject.getCallibrationSum("input.txt");

        System.out.println(result);
    }

    @Test
    void sampleInput_part2() {
        var result = subject.pt2("sampleInput2.txt");

        assertThat(result).isEqualTo(281);
    }

    @Test
    void oneight() {
        var result = subject.pt2("oneight.txt");

//        assertThat(result).isEqualTo(18 + 83 + 79);
    }

    @Test
    void part2_answer() {
        var result = subject.pt2("input.txt");

        System.out.println(result);
    }

}