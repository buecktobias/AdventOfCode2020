package aoc;


import aoc.aufgabe4.Aufgabe4Solver;
import aoc.aufgabe5.Aufgabe5Solver;
import aoc.aufgabe6.Aufgabe6Solver;
import aoc.helper.graph.DirectedWeightedGraph;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DirectedWeightedGraph<String> graph = new DirectedWeightedGraph<>();
        graph.addNode("lol");
        graph.addNode("lol");
        graph.addNode("haha");
        graph.addNode("xD");
        graph.addEdge("lol", "haha", 4);
        graph.addEdge("haha", "xD", 4);
        System.out.println(graph.getNode("haha").getParents());
        System.out.println(graph);
    }
}
