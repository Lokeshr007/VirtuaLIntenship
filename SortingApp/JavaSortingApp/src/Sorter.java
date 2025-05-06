
import java.util.*;

public class Sorter {
    public List<Integer> parseInput(String input) {
        List<Integer> list = new ArrayList<>();
        for (String s : input.trim().split("\s+")) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }

    public void sortAscending(List<Integer> list) {
        Collections.sort(list);
    }

    public void sortDescending(List<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
    }
}
