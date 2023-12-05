package advent2023;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Day2 {

    @SneakyThrows
    public int getGameSum(String filename) {
        var reader = new BufferedReader(new FileReader("src/test/resources/day2/" + filename));
        String line;
        int total = 0;
        var blockCounts = Map.of("red", 12, "green", 13, "blue", 14);
        while ((line = reader.readLine()) != null) {
            int gameNumber = getGameNumber(line);
            var allTurns = line.split(":")[1];
            var turns = allTurns.split(";");
            boolean isPossible = true;
            for (var turn : turns) {
                var blocks = turn.split(",");
                for (var block : blocks) {
                    var pair = block.split(" ");
                    int blockCount = Integer.parseInt(pair[1]);
                    String color = pair[2];
                    if (blockCount > blockCounts.get(color)) {
                        isPossible = false;
                        break;
                    }
                }
            }
            if (isPossible) {
                total+= gameNumber;
            }
        }
        return total;
    }

    private int getGameNumber(String line) {
        var gameStr = line.split(":")[0];
        var numStr = gameStr.replace("Game ", "");
        return Integer.parseInt(numStr);
    }
}
