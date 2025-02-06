import entity.Path;
import entity.Stopage;

import java.util.*;

public class Routing {
    private final Map<Stopage, List<Node>> graph = new HashMap<>();

    void buildGraph(Stopage from, Stopage to, double distance) {
        if (!graph.containsKey(from)) graph.put(from, new ArrayList<>());
        if (!graph.containsKey(to)) graph.put(to, new ArrayList<>());
        graph.get(from).add(new Node(to, distance));
        graph.get(to).add(new Node(from, distance));
    }

    public Path shortestPath(Stopage src, Stopage dest) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Double.compare(o1.dist, o2.dist);
            }
        });
        Map<String, Double> seen = new HashMap<>();
        Path path = new Path();
        pq.offer(new Node(src, 0.0));

        seen.put(src + "=>" + src, 0.0);
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
//            System.out.println(curr.stopage.getName() + " :" );
            path.addPath(curr.stopage);
            if (curr.stopage == dest) {
                path.setDist(curr.dist);
                return path;
            }
            for (Node node : graph.get(curr.stopage)) {
                if (seen.containsKey(node.stopage + "=>" + curr.stopage)) continue;
                double distance = seen.getOrDefault(curr.stopage + "=>" + node.stopage, Double.MAX_VALUE);
                if (distance > curr.dist + node.dist) {
                    pq.offer(new Node(node.stopage, curr.dist + node.dist));
                    seen.put(curr.stopage + "=>" + node.stopage, curr.dist + node.dist);
                }
            }
        }
        return path;
    }



    private class Node {
        private final Stopage stopage;
        private final double dist;

        public Node(Stopage stopage, double dist) {
            this.stopage = stopage;
            this.dist = dist;
        }

        public Stopage getStopage() {
            return stopage;
        }

        public double getDist() {
            return dist;
        }

    }
}
