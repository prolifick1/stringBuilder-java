package TinkoffTasks;// остался случай где не Numeric, и уже есть константа.
import java.util.*;

public class TinkoffTask4 {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Stack<StackFrame>> varStrings = new HashMap<>();

//    public static void main(String[] args) {
//        completionFrames();
//    }

    public static void completionFrames() {
        Map<Integer, HashSet<String>> changedPerStack = new HashMap<>();
        int curId = 0;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if (line.equals("{")) {
                curId++;
            } else if (line.equals("}")) {
                for (String varName: changedPerStack.get(curId)){
                    varStrings.get(varName).pop();
                }
                curId--;
            } else {
                String[] parts = line.split("=");
                if (isNumeric(parts[1])) {

                    if (!varStrings.containsKey(parts[0])) {
                        varStrings.put(parts[0], new Stack<StackFrame>());
                    }

                    Stack<StackFrame> frames = varStrings.get(parts[0]);
                    if (!frames.isEmpty() && frames.peek().id == curId) {
                        frames.pop();
                    }
                    frames.push(new StackFrame(curId, Integer.parseInt(parts[1])));

                    if (!changedPerStack.containsKey(curId)) {
                        changedPerStack.put(curId, new HashSet<>());
                    }
                    changedPerStack.get(curId).add(parts[0]);

                } else {

                }
            }

        }
    }

    public static boolean isNumeric(String line) {
        try {
            int n = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

class StackFrame {

    public StackFrame(int id, int val) {
        this.id = id;
        this.val = val;
    }

    public int id;
    public int val;
}
