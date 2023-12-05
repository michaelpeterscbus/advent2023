package advent2023;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    private final Day2 subject = new Day2();

    @Test
    void sampleInput() {
        var result = subject.getGameSum("sampleInput.txt");

        assertThat(result).isEqualTo(8);
    }

    @Test
    void answer() {
        var result = subject.getGameSum("input.txt");

        System.out.println(result);
    }

    @Test
    void getPower_sampleInput() {
        var result = subject.getPower("sampleInput.txt");

        assertThat(result).isEqualTo(2286);
    }

    @Test
    void getPower_answer() {
        var result = subject.getPower("input.txt");

        System.out.println(result);
    }
}