import java.util.Arrays;

public class ID435_NonOverlappingIntervals {
    public static void main(String... args) {
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        eraseOverlapIntervals(intervals);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

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
