package pathcrossing;

import java.util.HashSet;
import java.util.Set;

/*
Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.

 */

class PathCrossing {

    public boolean isPathCrossing(String path) {
        Set<Integer> set = new HashSet<>();
        int cur = 0;
        set.add(cur);
        for (Character c : path.toCharArray()) {
            switch (c) {
                case 'N':
                    cur += 0x10000;
                    break;
                case 'S':
                    cur -= 0x10000;
                    break;
                case 'E':
                    cur -= 1;
                    break;
                case 'W':
                    cur += 1;
                    break;
                default:
                    continue;
            }
            if (!set.add(cur)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String[] testCases = {
                "NES",
                "NESWW",
        };
        PathCrossing pc = new PathCrossing();
        for (int i = 0; i < testCases.length; i++) {
            boolean result = pc.isPathCrossing(testCases[i]);
            System.out.printf("Case %d: %s %b\n", i, testCases[i], result);
        }
    }
}