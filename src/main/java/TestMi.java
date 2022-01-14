import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author xzw
 * @create 2021/10/28 15:36
 */
public class TestMi {
    public static List<List<String>> result = new ArrayList<>();

    public static int countSubstrings(String s) {
        backtrack(s, 0, new ArrayList<>());
        HashSet<String> hash = new HashSet<>();
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                hash.add(result.get(i).get(j));
                System.out.println("");
                System.out.println("修改不同地方");
                System.out.println("");
            }
        }
        return hash.size();
    }

    public static void backtrack(String s, int k, List<String> path) {
        if (k == s.length()) {
            result.add(new ArrayList<>(path));
            return;

        }
        System.out.println("first commit");
        System.out.println("second commit");
        System.out.println("modify third result");
    }



}
