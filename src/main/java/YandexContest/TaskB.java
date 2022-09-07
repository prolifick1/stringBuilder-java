package YandexContest;

import java.util.*;

public class TaskB {
    public static void main(String[] args) {
        for (String item: solve()){
            System.out.println(item);
        }
    }

    public static Set<String> solve() {
        Scanner sc = new Scanner(System.in);
        Map<String, Competition> map = new HashMap<>();

        int countCompetitions = sc.nextInt();
        sc.nextLine();
        while (countCompetitions > 0) {
            String[] compInfo = sc.nextLine().trim().split(",");  // ear_flying[0],1[1]
            Competition comp = new Competition(compInfo[0], Integer.parseInt(compInfo[1]));
            map.put(compInfo[0], comp);
            countCompetitions--;
        }

        int countCompetitors = sc.nextInt();
        sc.nextLine();
        while (countCompetitors > 0) {
            String[] compInfo = sc.nextLine().trim().split(","); // cheburashka[0],ear_flying[1],11[2],100[3]
            Competitor comp = new Competitor(compInfo[0], Integer.parseInt(compInfo[2]), Integer.parseInt(compInfo[3]));
            map.get(compInfo[1]).competitors.add(comp);
            countCompetitors--;
        }

        Set<String> set = new TreeSet<>();
        for (String key : map.keySet()) {
            Competition temp = map.get(key);
            int min = Math.min(temp.topSize, temp.competitors.size());
            Collections.sort(temp.competitors);
            for (int i = 0; i < min; i++) {
                set.add(temp.competitors.get(i).name);
            }
        }


        return set;
    }

    static class Competition {
        public ArrayList<Competitor> competitors = new ArrayList<>();
        public int topSize;

        public String name;

        public Competition(String name, int topSize) {
            this.name = name;
            this.topSize = topSize;
        }


    }

    static class Competitor implements Comparable<Competitor> {
        public String name;
        public int score;
        public int penalty;

        public Competitor(String name, int score, int penalty) {
            this.name = name;
            this.score = score;
            this.penalty = penalty;
        }


        @Override
        public int compareTo(Competitor o) {
            if (this.score == o.score) {
                return this.penalty - o.penalty;
            } else {
                return o.score - this.score;
            }
        }
    }

}
