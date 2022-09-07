package leetCode.HashTables;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*771. Jewels and Stones*/
public class JewelsAndStones {
//    public static void main(String[] args) {
//        String stones = "aAAbbbb";
//        String jewels = "aA";
//        System.out.println(numJewelsInStones(jewels, stones));
//    }

    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.contains(String.valueOf(stones.charAt(i)))){
                count++;
            }
        }

        return count;
    }
}
