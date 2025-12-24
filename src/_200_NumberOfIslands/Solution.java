package _200_NumberOfIslands;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        /*
        char[][] grid1 = new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

        if (numIslands(grid1) != 1) {
            System.out.println("numIslands(grid1) != 1");
        }
        */

        char[][] grid2 = new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        int res = numIslands(grid2);
        if (res != 3) {
            System.out.println(res);
            System.out.println("numIslands(grid2) != 3");
        }
    }

    public static int numIslands(char[][] grid) {
        HashSet<Point> visitedPoints = new HashSet<>();

        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Point currentpoint = new Point(i, j);
                if (grid[i][j] == '1' && !visitedPoints.contains(currentpoint)) {
                    dfs(visitedPoints, grid, currentpoint);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void dfs(HashSet<Point> visitedPoints, char[][] grid, Point currentpoint) {
        if (visitedPoints.contains(currentpoint)) {
            return;
        }
        visitedPoints.add(currentpoint);

        int[][] coordinators = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] coordinator : coordinators) {
            int nextI = currentpoint.x + coordinator[0];
            int nextJ = currentpoint.y + coordinator[1];

            if (nextI < 0 || nextJ < 0 || grid.length <= nextI || grid[0].length <= nextJ){
                continue;
            }

            if (grid[nextI][nextJ] == '1'){
                dfs(visitedPoints, grid, new Point(nextI, nextJ));
            }
        }
    }

    public static int numIslands2(char[][] grid) {
        Map<Point, Point> mapChildParent = new HashMap<>();
        Map<Point, Set<Point>> mapParentChildren = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    Point currentPoint = new Point(i, j);
                    mapChildParent.put(currentPoint, currentPoint);

                    Set<Point> set = new HashSet<>();
                    set.add(currentPoint);
                    mapParentChildren.put(currentPoint, set);

                    if (0 <= i - 1 && grid[i - 1][j] == '1') {
                        Point newParent = new Point(i - 1, j);
                        newParent = findParent(mapChildParent, newParent);
                        fusionSets(mapChildParent, mapParentChildren, currentPoint, newParent);
                    }
                    currentPoint = findParent(mapChildParent, currentPoint);
                    if (0 <= j - 1 && grid[i][j - 1] == '1') {
                        Point newParent = new Point(i, j - 1);
                        newParent = findParent(mapChildParent, newParent);
                        if (!currentPoint.equals(newParent)) {
                            fusionSets(mapChildParent, mapParentChildren, currentPoint, newParent);
                        }
                    }
                }
            }
        }
        return mapParentChildren.size();
    }

    private static Point findParent(Map<Point, Point> mapChildParent, Point newParent) {
        if (mapChildParent.get(newParent).equals(newParent)) {
            return newParent;
        }
        return findParent(mapChildParent, mapChildParent.get(newParent));
    }


    private static void fusionSets(Map<Point, Point> mapChildParent,
        Map<Point, Set<Point>> mapParentChildren, Point currentPoint, Point newParent) {
        mapChildParent.put(currentPoint, newParent);
        mapParentChildren.get(newParent).add(currentPoint);

        for (Point point : mapParentChildren.get(currentPoint)) {
            mapChildParent.put(point, newParent);
            mapParentChildren.get(newParent).add(point);
        }
        mapParentChildren.remove(currentPoint);
    }
}
