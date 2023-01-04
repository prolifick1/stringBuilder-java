package YaCup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TaskA {

    static HashMap<Integer, DcState> dcIdStates = new HashMap<>();
    static TreeMap<Long, TreeSet<Integer>> mulToDcIds = new TreeMap<>();

//    public static void main(String[] args) throws FileNotFoundException {
//        solve();
//    }

    private static void solve() throws FileNotFoundException {
        input();
    }

    private static void getMax() {
        System.out.println(mulToDcIds.get(mulToDcIds.lastKey()).first());
    }

    private static void getMin() {
        System.out.println(mulToDcIds.get(mulToDcIds.firstKey()).first());
    }

    private static void input() throws FileNotFoundException {
        File textFile = new File("input1.txt");
        Scanner sc = new Scanner(textFile);
        int nDc = sc.nextInt();
        int totalServers = sc.nextInt();
        int nActions = sc.nextInt();
        sc.nextLine();
        mulToDcIds.put(0L, new TreeSet<>());

        for (int i = 1; i <= nDc; i++) {
            DcState ds = new DcState(totalServers);
            dcIdStates.put(i, ds);
            mulToDcIds.get(0L).add(i);
        }

        for (int i = 0; i < nActions; i++) {
            String[] str = sc.nextLine().trim().split(" ");
            if (str[0].equals("RESET")) {
                Integer id = parse(str[1]);
                long m = dcIdStates.get(id).multi();
                var ts = mulToDcIds.get(m);
                ts.remove(id);
                if (ts.isEmpty()) {
                    mulToDcIds.remove(m);
                }
                dcIdStates.get(id).resetDisSrv();
                update(id);
            } else if (str[0].equals("DISABLE")) {
                Integer id = parse(str[1]);
                long m = dcIdStates.get(id).multi();
                var ts = mulToDcIds.get(m);
                ts.remove(id);
                if (ts.isEmpty()) {
                    mulToDcIds.remove(m);
                }
                dcIdStates.get(id).addDisSrv(parse(str[2]));
                update(id);
            } else if (str[0].equals("GETMAX")) {
                getMax();
            } else if (str[0].equals("GETMIN")) {
                getMin();
            }
        }

    }

    static void update(Integer id) {
        long m = dcIdStates.get(id).multi();
        if (mulToDcIds.containsKey(m)) {
            mulToDcIds.get(m).add(id);
        } else {
            TreeSet<Integer> ts = new TreeSet<>();
            ts.add(id);
            mulToDcIds.put(m, ts);
        }
    }

    static Integer parse(String str) {
        return Integer.parseInt(str);
    }
}

class DcState {
    public long multi() {
        return ((long) totalServers - deadServerIds.size()) * numResets;
    }

    public void addDisSrv(Integer srvId) {
        deadServerIds.add(srvId);
    }

    public void resetDisSrv() {
        deadServerIds.clear();
        numResets++;
    }

    public DcState(int totalServers) {
        this.totalServers = totalServers;
        this.deadServerIds = new HashSet<>();
        this.numResets = 0;
    }

    private int totalServers;
    private int numResets;
    private HashSet<Integer> deadServerIds;

}
