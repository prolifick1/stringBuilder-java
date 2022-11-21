package YandexContextFast;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) throws FileNotFoundException {
        solve();
    }

    public static void solve() throws FileNotFoundException {
        Comparator<ArrayList<Integer>> arrComparator = new ArrLengthSort();
        ArrayList<ArrayList<Integer>> sequence = input();
        sequence.sort(arrComparator);
        sequence = lookingForShortestSq(sequence);
        output(sequence);
    }

    private static void output(ArrayList<ArrayList<Integer>> sequence) {

    }

    public static ArrayList<ArrayList<Integer>> input() throws FileNotFoundException {

        ArrayList<ArrayList<Integer>> sequence = new ArrayList<>();
        File textFile = new File("input.txt");
        Scanner sc = new Scanner(textFile);

        var n = 3;
        while (n > 0) {
            var k = sc.nextInt();
            ArrayList<Integer> arrList = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                arrList.add(sc.nextInt());
            }
            sequence.add(arrList);
            n--;
        }
        return sequence;
    }

    public static ArrayList<ArrayList<Integer>> lookingForShortestSq(ArrayList<ArrayList<Integer>> inputSq) {
        ArrayList<ArrayList<Integer>> sequence = new ArrayList<>();
        for (int i = 0; i < inputSq.size(); i++) {
            boolean remove = false;
            for (int k = i + 1; k < inputSq.size(); k++) {
                String big = sqToString(inputSq.get(k));
                String small = sqToString(inputSq.get(i));
                if (big.contains(small)) {
                    remove = true;
                    break;
                }
            }
            if (!remove) {
                sequence.add(inputSq.get(i));
            }
        }

        int[] indices = new int[sequence.size()];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        var indexPermutations = new ArrayList<int[]>();
        allIndexPermutations(indices, new int[]{}, indexPermutations);


        return sequence;
    }




    private static void allIndexPermutations(int[] indices, int[] result, ArrayList<int[]> pool) {
        if (indices.length == 0) {
            pool.add(result);
            return;
        }

        for (int i = 0; i < indices.length; i++) {
            int[] newIndices = new int[indices.length - 1];
            int nextId = 0;
            for (int j = 0; j < indices.length; j++) {
                if (i == j) {
                    continue;
                }
                newIndices[nextId++] = indices[j];
            }

            int[] newResult = new int[result.length + 1];
            for (int j = 0; j < result.length; j++) {
                newResult[j] = result[j];
            }
            newResult[newResult.length - 1] = indices[i];

            allIndexPermutations(newIndices, newResult, pool);
        }
    }

    private static String sqToString(ArrayList<Integer> sq) {
        String str = sq.toString();
        str = str.substring(1, str.length() - 1);
        return str;
    }


}

class ArrLengthSort implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        if (o1.size() > o2.size()) {
            return 1;
        } else {
            if (o1.size() < o2.size()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}