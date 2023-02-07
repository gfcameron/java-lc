import java.util.*;

class CountEdgesToReverse {


    // This is the tree traversal
    // adjGraph is the 2D arraylist of adjacency graphs for each node
    // counts is the array holding the count of edges to reverse for each node
    // visited is the array of visited nodes
    // startNode is the node we are starting from
    // curNode is the node we are currently at
    private void traverseTree(ArrayList<ArrayList<Integer>> adjGraph, int[] counts, boolean[] visited, int startNode, int curNode) {
        // Need to correct for zero index, curNode is 1 based
        if (visited[curNode-1] == false) {
            counts[startNode]--;
            visited[curNode-1] = true;
            // Iterate over the inner arraylist
            for (int entry:adjGraph.get(curNode-1)) {
                curNode = entry;
                if (curNode != 0) {
                    traverseTree(adjGraph, counts, visited, startNode, curNode);
                }
            }
        }
    }

    // isCountEdgesToReverse counts number of edges to reverse for node to reach all other nodes.
    public int[] countEdgesToReverse(int g_nodes, int g_edges, int[] g_from, int[] g_to) {
        int[] counts = new int[g_nodes];

        // Create adjacency graph, entry 0 is node 1.
        ArrayList<ArrayList<Integer>> adjGraph = new ArrayList<ArrayList<Integer>>(g_nodes);

        for (int i = 0; i < g_nodes; i++) {
            ArrayList<Integer> al = new ArrayList<Integer>(g_edges);
            adjGraph.add(al);
        }

        // Initialize the list
        for (int i = 0; i < g_edges; i++)  {
            /*
             * Initialize the count of all nodes found in an edge.
             * Every node should exist in a to or from.  Convert from 1 based to 0
             * based node reference.
             */
            counts[g_from[i]-1] = g_nodes;
            counts[g_to[i]-1] = g_nodes;
            adjGraph.get(g_from[i]-1).add(g_to[i]);
        }

        // Traverse the graph from each start point until cannot proceed.
        for (int start=0; start < g_nodes; start++) 
        {
            /* 
             * If uninitialized, it does not exist a to or from on any edge and is unreachable.
             * Ergo the problem is impossible, since it is impossible to visit the node from either
             * direction.
             */
            if (counts[start] == 0) {
                return new int[]{-1};
            }
            boolean[] visited = new boolean[g_nodes];
            // Change from 0 to 1 based.
            int current = start+1;
            traverseTree(adjGraph, counts, visited, start, current);
        }
        return counts;
    }

    // main
    public static void main(String[] args) {

        class TestCase {
            int g_nodes;
            int g_edges;
            int[] g_from;
            int[] g_to;

            TestCase(int g_nodes, int g_edges, int[] g_from, int[] g_to) {
                this.g_nodes = g_nodes;
                this.g_edges = g_edges;
                this.g_from = g_from;
                this.g_to = g_to;
            }
        };

        TestCase testCases[] = 
        {
            new TestCase(3, 2, new int[]{2, 2}, new int[]{1,3}),
            new TestCase(3, 2, new int[]{2, 2}, new int[]{1,1}),
            new TestCase(
                4,
                3,
                new int[]{1, 2, 3},
                new int[]{ 4, 4, 4}
            )
        };

        CountEdgesToReverse edgesToRev = new CountEdgesToReverse();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: ", i);
            System.out.println(Arrays.toString(edgesToRev.countEdgesToReverse(testCases[i].g_nodes, testCases[i].g_edges, testCases[i].g_from, testCases[i].g_to)));
        }
    }
}