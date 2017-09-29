public class Edge {
    public Vertex destination;
    public double weight;

    public Edge(Vertex v, double w) {
        this.destination = v;
        this.weight = w;
    }
}
