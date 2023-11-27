package Day1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class MaxCalories {

    public static List<List<Integer>> readFile(URI uri) throws IOException {
        String string = Files.readString(Paths.get(uri));
        return Arrays.stream(Pattern.compile("\n\n").split(string)).map(s -> Arrays.stream(s.split("\n")).map(Integer::valueOf).toList()).toList();
    }

    public static int partOne(List<List<Integer>> elfs) {
        List<Integer> max = elfs.stream().max(Comparator.comparingInt(o -> o.stream().reduce(Integer::sum).orElseThrow())).orElseThrow();
        return max.stream().reduce(Integer::sum).orElseThrow();
    }

    public static int partTwo(List<List<Integer>> elfs) {
        return elfs.stream().map(integers -> integers.stream().reduce(Integer::sum).orElseThrow()).sorted(Comparator.reverseOrder()).limit(3).reduce(Integer::sum).orElseThrow();
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<List<Integer>> elfs = readFile(Objects.requireNonNull(ClassLoader.getSystemResource("Day1/input.txt").toURI()));
        System.out.println(partOne(elfs));
        System.out.println(partTwo(elfs));
    }
}
