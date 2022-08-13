package TinkoffTasks;

import java.util.*;

public class TinkoffTask2 {
    static Scanner sc = new Scanner(System.in);
    static int mostSumWins = 1;
    static Map <String, Integer> listOfTeams = new HashMap<String,Integer>();

//    public static void main(String[] args) {
//        declaring();
//        search();
//        System.out.println(mostSumWins);
//
//    }

    public static void declaring(){
        int sumAges = Integer.parseInt(sc.nextLine());
        while (sumAges>0){
            String[] line = sc.nextLine().split(" ");
            Arrays.sort(line);
            listOfTeams.merge( String.join(" ", line), 1, Integer::sum);
            sumAges--;
        }
    }

    public static void search(){
        for (Integer value: listOfTeams.values()){
            mostSumWins = value > mostSumWins? value: mostSumWins;
        }
    }
}
