import java.util.ArrayList;
import java.util.List;

public class ID682_BaseballGame {
    public int calPoints(String[] ops) {
        List<Integer> record = new ArrayList<>();

        for (String s : ops) {
            switch (s) {
                case "+":
                    record.add(record.get(record.size() - 1) + record.get(record.size() - 2));
                    break;
                case "C":
                    record.remove(record.size() - 1);
                    break;
                case "D":
                    record.add(record.get(record.size() - 1) << 1);
                    break;
                default:
                    record.add(Integer.parseInt(s));
                    break;
            }
        }

        int result = 0;
        for (Integer recordedVal : record) result += recordedVal;
        return result;
    }
}