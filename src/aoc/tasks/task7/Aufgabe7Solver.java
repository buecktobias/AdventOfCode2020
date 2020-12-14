package aoc.tasks.task7;

import aoc.helper.Input;
import aoc.helper.graph.DirectedWeightedGraph;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aufgabe7Solver {
    public static DirectedWeightedGraph<String> getInput(String filename){
        DirectedWeightedGraph<String> graph = new DirectedWeightedGraph<>();
        String input= "";
        try {
            input = Input.readFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern pattern = Pattern.compile("([\\w ]*) bags contain (\\d[\\w, ]*)");
        Pattern pattern2 = Pattern.compile("(\\d) ([\\w* ]*) bag");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            String parent = matcher.group(1);
            graph.addNode(parent);
            String children = matcher.group(2);
            Matcher matcher2 = pattern2.matcher(children);
            System.out.println(parent);
            while(matcher2.find()){
                String child = matcher2.group(2);
                int weight = Integer.parseInt(matcher2.group(1));
                graph.addNode(child);
                graph.addEdge(parent, child, weight);
            }
        }
        return graph;
    }
    public static int solvePart1(String filename){
        DirectedWeightedGraph<String> graph = getInput(filename);
        System.out.println(graph.getNode("vibrant plum").getParents());
        System.out.println(graph.getNode("shiny gold").getUniqueIndirectParents());
        return graph.getNode("shiny gold").getUniqueIndirectParents().size();
    }
}
