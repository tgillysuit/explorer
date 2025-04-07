import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!
    // Come up with varied cases
    
    // Test where everywhere is walkable
    @Test
    public void testReachableArea_allAreasAreWalkable() {
        int[][] island = {
            {0,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(30, actual);
    }

    // Test where there is nowhere to go
    @Test
    public void testReachableArea_nowhereToGo() {
        int[][] island = {
            {3,3,3,3,3,3},
            {3,2,3,3,3,3},
            {3,2,2,3,3,3},
            {3,2,2,2,2,2},
            {3,2,2,0,2,3}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    // Test for No Starting point
    @Test
    public void testReachableArea_noStartingPoint() {
        int[][] island = {
            {1,2,3,2,3,3},
            {1,2,3,2,3,3},
            {1,2,3,2,3,3},
            {1,2,3,2,3,3},
            {1,2,3,2,3,3}
        };
        
        assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.reachableArea(island);
        });
    }

    // Test for double starting points
    // This test is valid because of two starting point unless there were additional instructions that there should only be one starting point.
    @Test
    public void testReachableArea_withTwoStartingPoints() {
        int[][] island = {
            {0,1,1,2,3,3},
            {1,1,1,2,3,2},
            {2,2,1,1,2,3},
            {3,2,2,1,2,3},
            {3,2,2,1,1,0}
        };

        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(12, actual);
    }

    // Test for empty 2d array
    @Test
    public void testReachableArea_empty2dArray() {
        int[][] island = {};
        assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.reachableArea(island);
        });
    }

    // Testing if the explorer can search just horizontal
    @Test
    public void testReachableArea_onePathHorizontal() {
        int[][] island = {
            {0,1,1,1,1,1},
            {3,3,3,3,3,3},
            {3,3,3,3,3,3}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(6, actual);
    }

    // Testing if the explorer can search just vertical
    @Test
    public void testReachableArea_onePathVertical() {
        int[][] island = {
            {0,3,3,3,3,3},
            {1,3,3,3,3,3},
            {1,3,3,3,3,3},
            {1,3,3,3,3,3},
            {1,3,3,3,3,3}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(5, actual);
    }

    // Testing if the explorer can climb that mountain
    @Test
    public void testReachableArea_spiralMountain() {
        int[][] island = {
            {0,1,1,1,1,1},
            {3,3,3,3,3,1},
            {3,1,1,1,3,1},
            {3,1,3,3,3,1},
            {3,1,1,1,1,1},
            {3,3,3,3,3,3}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(18, actual);
    }

    // Testing if the explorer comes across a washed up trail
    @Test
    public void testReachableArea_washedUpTrail() {
        int[][] island = {
            {0,1,3,3,3,2},
            {1,1,2,3,3,2},
            {2,2,2,2,2,2},
            {2,2,2,2,1,2},
            {2,2,2,2,1,1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(4, actual);
    }
}
