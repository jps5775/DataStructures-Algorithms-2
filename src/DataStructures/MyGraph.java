package DataStructures;

import java.util.*;

public class MyGraph {
    Map<Integer, List<Integer>> graph;
    public MyGraph(){
        graph = new HashMap<>();
    }

    // edgeList => [[i, j], [], ...] where i -> j
    public MyGraph(int[][] edgeList, boolean isDirected){
        graph = new HashMap<>();

        // create nodes
        for(int[] edge : edgeList){
            graph.put(edge[0], new ArrayList<>()); // put i
            graph.put(edge[1], new ArrayList<>()); // put j
        }

        // add neighbors
        for(int[] edge : edgeList){
            graph.get(edge[0]).add(edge[1]);
            if(!isDirected){ graph.get(edge[1]).add(edge[0]); };
        }
    }

    public boolean containsCycle(){
        Set<Integer> visited = new HashSet<>();
        for(int node : graph.keySet()){
            if(checkCycleDFS(node, visited)){
                return true;
            }
        }

        return false;
    }

    private boolean checkCycleDFS(int curr, Set<Integer> visited){
        visited.add(curr);

        for(int neighbor : graph.get(curr)){
            if(!visited.contains(neighbor)){
                if(checkCycleDFS(neighbor, visited)) return true;
                visited.remove(neighbor);
            }else{
                return true;
            }
        }

        return false;
    }

    public List<List<Integer>> getAllPaths(int source, int target){
        List<List<Integer>> allPaths = new ArrayList<>();
        findAllPaths(source, target, allPaths, new HashSet<>(), new ArrayList<>());
        return allPaths;
    }

    private void findAllPaths(int source, int target, List<List<Integer>> allPaths, Set<Integer> visited, List<Integer> currPath){
        if(visited.contains(source)){ return; }
        if(source == target){
            // add the target since I arrived there
            currPath.add(target);
            allPaths.add(new ArrayList<>(currPath));
            currPath.removeLast();
            return;
        }

        visited.add(source);
        currPath.add(source);

        for(int neighbor : graph.get(source)){
            if(!visited.contains(neighbor)){
                findAllPaths(neighbor, target, allPaths, visited, currPath);
            }
        }

        visited.remove(source);
        currPath.removeLast();
    }

    public List<Integer> getShortestPath(int source, int target) {
        if (source == target) {
            return new ArrayList<>() {{ add(source); }};
        }

        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        parent.put(source, null); // Start node has no parent
        visited.add(source); // Mark as visited
        q.add(source);

        while (!q.isEmpty()) {
            int node = q.poll();

            if (node == target) {
                break;
            }

            System.out.println(node);
            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    parent.put(neighbor, node);
                    visited.add(neighbor); // Mark as visited when enqueued
                    q.add(neighbor);
                }
            }
        }

        // If the target node is not reached, return an empty list
        if (!parent.containsKey(target)) {
            return new ArrayList<>();
        }

        // Reconstruct the shortest path
        List<Integer> path = new ArrayList<>();
        Integer curr = target; // using Integer for checking != null
        while (curr != null) {
            path.add(curr);
            curr = parent.get(curr);
        }

        Collections.reverse(path); // Reverse to get path from source to target
        return path;
    }

    // NOTE: if you want to count components is just counting how many times you run dfs / bfs here
    public boolean containsNode(int target, boolean useDFS){
        // graph may be disconnected so call dfs / bfs on all nodes
        Set<Integer> visited = new HashSet<>();
        for(int node : graph.keySet()){
            if(!visited.contains(node)) {
                if (useDFS) {
                    if(dfs(node, target, visited)) return true;
                } else {
                    if(bfs(node, target, visited)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int curr, int target, Set<Integer> visited){
        if(visited.contains(curr)){ return false; }
        if(curr == target){ return true; }

        visited.add(curr);

        for(int neighbor : graph.get(curr)){
            if(dfs(neighbor, target, visited)){
                return true;
            }
        }

        return false;
    }

    private boolean bfs(int curr, int target, Set<Integer> visited){
        Queue<Integer> q = new LinkedList<>();

        q.offer(curr);
        while(!q.isEmpty()){
            int node = q.poll();

            if(node == target){ return true; }

            for(int neighbor : graph.get(node)){
                if(!visited.contains(neighbor)){
                    q.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[][] edgeList = {
                {1, 2},
                {1, 3},
                {2, 4},
                {3, 4},
                {3, 5},
                {4, 6},
                {5, 6},
                {7, 8}
        };

        MyGraph g = new MyGraph(edgeList, true);
//        List<List<Integer>> paths = g.getAllPaths(1, 6);
//        for(List<Integer> path : paths){
//            for(int i = 0; i < path.size(); i++){
//                System.out.print(path.get(i) + " -> ");
//            }
//            System.out.println();
//        }

        System.out.println(g.containsCycle());

    }
}
