package destcity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going
from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one
destination city.
 */

class DestCity {

    public String destCity(List<List<String>> paths) {

        HashSet<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(1));
        }
        for (List<String> path : paths) {
            set.remove(path.get(0));
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {

        ArrayList<List<List<String>>> testCases = new ArrayList<List<List<String>>>(
                List.of(
                        List.of(
                                List.of("London", "New York"),
                                List.of("New York", "Lima"),
                                List.of("Lima", "Sao Paulo")),
                        List.of(
                                List.of("B", "C"),
                                List.of("D", "B"),
                                List.of("C", "A")),
                        List.of(
                                List.of("A", "Z"))));

        DestCity dc = new DestCity();
        for (int i = 0; i < testCases.size(); i++) {
            String result = dc.destCity(testCases.get(i));
            System.out.printf("Case %d: %s dest city is %s\n", i, Arrays.toString(testCases.get(i).toArray()),
                    result);
        }
    }
}
