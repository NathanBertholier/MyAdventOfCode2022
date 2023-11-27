package Day2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RockPaperScissors {

    public static List<List<String>> readFile(URI uri) throws IOException {
        return Files.readAllLines(Paths.get(uri)).stream().map(s -> {
            return Arrays.stream(s.split(" ")).toList();
        }).toList();
    }

    public static int partOne(List<List<String>> rounds) {
        return rounds.stream().map(strings -> List.of(Shape.createShape(strings.get(0)), Shape.createShape(strings.get(1)))).map(shapes -> {
            Shape shape = shapes.get(1);
            return shape.against(shapes.get(0)) + shape.getValue();
        }).reduce(Integer::sum).orElseThrow();
    }

    public static int partTwo(List<List<String>> rounds) {
        return rounds.stream().map(strings -> {
            Shape shape = Shape.createShape(strings.get(0));
            return List.of(shape, shape.findShape(strings.get(1)));
        }).map(shapes -> {
            Shape shape = shapes.get(1);
            return shape.against(shapes.get(0)) + shape.getValue();
        }).reduce(Integer::sum).orElseThrow();
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<List<String>> rounds = readFile(Objects.requireNonNull(ClassLoader.getSystemResource("Day2/input.txt").toURI()));
        System.out.println(partOne(rounds));
        System.out.println(partTwo(rounds));
    }


}

