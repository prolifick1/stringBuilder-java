package TinkoffTasks;

import java.util.*;

public class TinkoffTask5 {
    public class Main {
//        public static void main(String[] args) {
//            Scanner scanner = new Scanner(System.in);
//            String[] strTokens = scanner.nextLine().split(" ");
//            int wordsCount = Integer.parseInt(strTokens[0]);
//            int queriesCount = Integer.parseInt(strTokens[1]);
//
//            List<StrWithInd> sortedStorage = toSorted(scanner, wordsCount);
//
//            BohrNode bohrHead = buildBohr(sortedStorage, wordsCount);
//
//            handleQueries(scanner, queriesCount, bohrHead, sortedStorage);
//
//        }

        public static List<StrWithInd> toSorted(Scanner scanner, int strCount) {
            List<StrWithInd> lst = new ArrayList<>();
            for (int i = 0; i < strCount; i++) {
                String userName = scanner.nextLine();
                lst.add(new StrWithInd(userName, i));
            }
            lst.sort(Comparator.comparing(a -> a.str));

            return lst;
        }

        private static void handleQueries(Scanner scanner, int strCount, BohrNode bohrHead, List<StrWithInd> sortedStorage) {
            for (int i = 0; i < strCount; i++) {
                String[] queryTokens = scanner.nextLine().split(" ");
                int k = Integer.parseInt(queryTokens[0]);
                String startsWith = queryTokens[1];

                int ksId = findKsUserId(bohrHead, startsWith, k);

                if (ksId == -1) {
                    System.out.println(-1);
                }

                System.out.println(sortedStorage.get(ksId).originalInd + 1);
            }
        }

        private static int findKsUserId(BohrNode bohrHead, String startsWith, int k) {
            BohrNode current = bohrHead;
            for (int i = 0; i < startsWith.length(); i++) {
                char ch = startsWith.charAt(i);
                current = current.transitions.get(ch);
            }
            if (current == null) {
                return -1;
            }
            int res = current.suitableUserIdFrom + k - 1;
            if (res > current.suitableUserIdTo) {
                return -1;
            }
            return res;
        }

        // returns head of bohr
        public static BohrNode buildBohr(List<StrWithInd> users, int strCount) {
            BohrNode head = new BohrNode();
            for (int i = 0; i < users.size(); i++) {
                addToBohr(users.get(i).str, head, i);
            }
            return head;
        }

        public static void addToBohr(String userName, BohrNode head, int userId) {
            BohrNode current = head;
            for (int i = 0; i < userName.length(); i++) {
                Character ch = userName.charAt(i);
                current = current.buildGoThrough(ch, userId);
            }
        }
    }

    static class BohrNode {
        // may not storage whole because it in lexicographic order
        public int suitableUserIdFrom; // including
        public int suitableUserIdTo; // including
        public Map<Character, BohrNode> transitions = new HashMap<>();

        public BohrNode buildGoThrough(char ch, int userId) {
            BohrNode next = this;
            if (!transitions.containsKey(ch)) {
                next = new BohrNode();
                next.suitableUserIdFrom = userId;
                next.suitableUserIdTo = userId;
                transitions.put(ch, next);
                return next;
            }
            next = transitions.get(ch);
            next.addSuitableUserId(userId);
            return next;
        }

        public void addSuitableUserId(int ind) {
            if (ind < suitableUserIdFrom) {
                suitableUserIdFrom = ind;
                return;
            }
            if (ind > suitableUserIdTo) {
                suitableUserIdTo = ind;
                return;
            }
        }
    }

    static class StrWithInd {
        public String str;
        public int originalInd;

        public StrWithInd(String str, int originalInd) {
            this.str = str;
            this.originalInd = originalInd;
        }
    }



}
