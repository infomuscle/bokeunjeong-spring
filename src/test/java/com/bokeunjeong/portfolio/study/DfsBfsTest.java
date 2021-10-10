package com.bokeunjeong.portfolio.study;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;
import java.util.stream.Collectors;

@ActiveProfiles("test")
public class DfsBfsTest {


    @Test
    public void dfsTest() throws Exception {

        Map<String, Set<String>> graph = new HashMap<>();
        graph.put("A", Set.of("B"));
        graph.put("B", Set.of("A", "C", "H"));
        graph.put("C", Set.of("B", "D"));
        graph.put("D", Set.of("C", "E", "G"));
        graph.put("E", Set.of("D", "F"));
        graph.put("F", Set.of("E"));
        graph.put("G", Set.of("D"));
        graph.put("H", Set.of("B", "I", "J", "M"));
        graph.put("I", Set.of("H"));
        graph.put("J", Set.of("H", "K"));
        graph.put("K", Set.of("J", "L"));
        graph.put("L", Set.of("K"));
        graph.put("M", Set.of("M"));

        List<String> dfsVisit = dfs(graph, "A");
        System.out.println(dfsVisit);

        List<String> bfsVisit = bfs(graph, "A");
        System.out.println(bfsVisit);
    }

    private List<String> dfs(Map<String, Set<String>> graph, String start) {

        List<String> visited = new ArrayList<>();
        Stack<String> stack = new Stack();
        stack.add(start);

        while (!stack.isEmpty()) {
            String node = stack.pop();
            System.out.println(node);
            if (!visited.contains(node)) {
                visited.add(node);
                stack.addAll(graph.get(node).stream().filter(n -> !visited.contains(n)).collect(Collectors.toList()));
            }
        }

        return visited;
    }

    private List<String> bfs(Map<String, Set<String>> graph, String start) {

        List<String> visited = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.println(node);
            if (!visited.contains(node)) {
                visited.add(node);
                queue.addAll(graph.get(node).stream().filter(n -> !visited.contains(n)).collect(Collectors.toList()));
            }
        }

        return visited;

    }

}
