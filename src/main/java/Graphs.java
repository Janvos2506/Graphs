public class Graphs {
    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addEdge("A","B",10);
        graph.addEdge("A","C",1);
        graph.addEdge("A","D",5);
        graph.addEdge("D","B",15);
        graph.addEdge("C","D",9);
        graph.addEdge("D","F",6);
        //graph.addEdge("X","Y",6);
        //graph.calcUnweighted("A");
        //graph.calcDijkstra("A");
        System.out.println(graph.isConnected());
    }
}
