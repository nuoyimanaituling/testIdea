import javax.crypto.spec.PSource;
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
                System.out.println("11111111111111");
                
            }
        }
        return hash.size();
    }
    
    public static void aaaaa(String a) {
        System.out.println(a);
    }
    public static void bbaa(String b) {
        System.out.println(b);
    }

    public static void backtrack(String s, int k, List<String> path) {
        if (k == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        System.out.println("first commit");
        System.out.println("second commit");
        System.out.println("modify third result");
        System.out.println("modify fourth result");
        System.out.println("local user update result");
        System.out.println("local user test");
        System.out.println("11111");
        System.out.println("修改接口之前");
        System.out.println("修改接口");
        System.out.println("xiugaijiekouzhihou");
        System.out.println("修改接口之后");
        System.out.println("修改接口2");
        System.out.println("修改接口3");
        System.out.println("修改接口之后");
        System.out.println("jdfkalsjf");
        System.out.println("修改接口4");
        System.out.println("qqqqqqq");
        System.out.println("修改接口555");
        System.out.println("修改接口4");
        System.out.println("修改接口666");
        System.out.println("修改接口411111");
        System.out.println("git update");
        Sssssssssssssssss
        sout(aaaaaaaaaaa)
        nbbbbbbbbbbbbbbbbbkb
    }

    static final String XZWXZWXZW = "aaa";
    static final String getXzwxzwxzw = "aaaaaaa";
    static final String XZWXZWXZW = "aaa";
    11111111111111111111111111111111111111


}
