package org.example.basicGraph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    public HashMap<Integer, Node> nodes; // why it is hashmap??
    public ArrayList<Edge> edges;
    public Graph() {
        nodes = new HashMap<>();
        edges = new ArrayList<>();
    }
}
