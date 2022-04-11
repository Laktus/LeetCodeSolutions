import java.util.ArrayList;
import java.util.List;

public class ID1260_Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = null;

        int n = grid.length, m = grid[0].length;
        int length = n * m;
        k %= length;
        for (int i = 0; i < length; i++) {
            if (i % m == 0) {
                current = new ArrayList<>();
                result.add(current);
            }
            int shifted = (i + length - k) % length;
            current.add(grid[shifted / m][shifted % m]);
        }

        return result;
    }
}
