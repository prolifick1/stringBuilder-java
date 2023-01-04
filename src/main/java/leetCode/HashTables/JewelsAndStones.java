package leetCode.HashTables;
/*771. Jewels and Stones*/
public class JewelsAndStones {
//    public static void main(String[] args) {
//        String stones = "aAAbbbb";
//        String jewels = "aA";
//        System.out.println(numJewelsInStones(jewels, stones));
//    }

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.contains(String.valueOf(stones.charAt(i)))){
                count++;
            }
        }

        return count;
    }
}
