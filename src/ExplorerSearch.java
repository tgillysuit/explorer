import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following numbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too
        if (island == null || island.length == 0 || island[0].length == 0) {
            throw new IllegalArgumentException("Island grid is empty.");
        } 
        
        int[] start = explorer(island);
        int rows = island.length;
        int cols = island[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Stack<int[]> stack = new Stack<>();
        stack.push(start);

        int count = 0;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int r = current[0];
            int c = current[1];

            if (visited[r][c]) continue;

            visited[r][c] = true;
            count++;

            for (int[] move : possibleMoves(island, current)) {
                if (!visited[move[0]][move[1]]) {
                    stack.push(move);
                }
            }
        }
        return count;
    }

    // Helper method for moves
    public static List<int[]> possibleMoves(int[][] island, int[] current) {
        int[][] directions = {
            {-1, 0}, // UP
            { 1, 0}, // DOWN
            { 0,-1}, // LEFT
            { 0, 1}  // RIGHT
        };

        int curR = current[0];
        int curC = current[1];
        List<int[]> moves = new ArrayList<>();

        for (int[] direction : directions) {
            int newR = curR + direction[0];
            int newC = curC + direction[1];

            if (newR >= 0 && newR < island.length &&
                newC >= 0 && newC < island[0].length &&
                (island[newR][newC] == 1 || island[newR][newC] == 0)) {
                    moves.add(new int[]{newR, newC});
                }

        }
        return moves;

    }


    // Helper method
    public static int[] explorer(int[][] island) {
        for (int r = 0; r < island.length; r++) {
            for (int c = 0; c < island[0].length; c++) {
                if (island[r][c] == 0) { 
                    return new int[]{r, c};
                }
            }
        }
        throw new IllegalArgumentException("No explorer found.");
    }
}
