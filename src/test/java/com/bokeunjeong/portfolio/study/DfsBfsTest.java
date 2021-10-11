package com.bokeunjeong.portfolio.study;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;
import java.util.stream.Collectors;

@ActiveProfiles("test")
public class DfsBfsTest {


    @Test
    public void testDfsBfsOfSet() throws Exception {

        Map<String, Set<String>> setGraph = new HashMap<>();
        setGraph.put("A", Set.of("B"));
        setGraph.put("B", Set.of("A", "C", "H"));
        setGraph.put("C", Set.of("B", "D"));
        setGraph.put("D", Set.of("C", "E", "G"));
        setGraph.put("E", Set.of("D", "F"));
        setGraph.put("F", Set.of("E"));
        setGraph.put("G", Set.of("D"));
        setGraph.put("H", Set.of("B", "I", "J", "M"));
        setGraph.put("I", Set.of("H"));
        setGraph.put("J", Set.of("H", "K"));
        setGraph.put("K", Set.of("J", "L"));
        setGraph.put("L", Set.of("K"));
        setGraph.put("M", Set.of("H"));

        List<String> dfsVisit = setDfs(setGraph, "A");
        System.out.println(dfsVisit);

        List<String> bfsVisit = setBfs(setGraph, "A");
        System.out.println(bfsVisit);
    }


    @Test
    public void testDfsBfsOfList() throws Exception {

        Map<String, List<String>> listGraph = new HashMap<>();
        listGraph.put("A", List.of("B"));
        listGraph.put("B", List.of("A", "C", "H"));
        listGraph.put("C", List.of("B", "D"));
        listGraph.put("D", List.of("C", "E", "G"));
        listGraph.put("E", List.of("D", "F"));
        listGraph.put("F", List.of("E"));
        listGraph.put("G", List.of("D"));
        listGraph.put("H", List.of("B", "I", "J", "M"));
        listGraph.put("I", List.of("H"));
        listGraph.put("J", List.of("H", "K"));
        listGraph.put("K", List.of("J", "L"));
        listGraph.put("L", List.of("K"));
        listGraph.put("M", List.of("H"));

        List<String> dfsVisit = listDfs(listGraph, "A");
        System.out.println(dfsVisit);

        List<String> bfsVisit = listBfs(listGraph, "A");
        System.out.println(bfsVisit);
    }

    private List<String> setDfs(Map<String, Set<String>> graph, String start) {

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

    private List<String> setBfs(Map<String, Set<String>> graph, String start) {

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

    private List<String> listDfs(Map<String, List<String>> graph, String start) {

        List<String> visited = new ArrayList<>();
        Stack<String> stack = new Stack();
        stack.add(start);

        while (!stack.isEmpty()) {
            String node = stack.pop();
            System.out.println(node);
            if (!visited.contains(node)) {
                visited.add(node);
                stack.addAll(graph.get(node).stream().filter(n -> !visited.contains(n)).sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
            }
        }

        return visited;
    }

    private List<String> listBfs(Map<String, List<String>> graph, String start) {

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
