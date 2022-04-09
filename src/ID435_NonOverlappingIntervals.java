import java.util.Arrays;
import java.util.Comparator;

public class ID435_NonOverlappingIntervals {
    public static void main(String... args) {
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        eraseOverlapIntervals(intervals);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int result = 0;
        int i = 0;
        while (i < intervals.length) {
            int prevEnd = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && prevEnd > intervals[j][0]) {
                prevEnd = Math.min(prevEnd, intervals[j][1]);
                j++;
                result++;
            }
            i = j;
        }

        return result;
    }
}
