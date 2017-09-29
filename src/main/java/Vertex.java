import java.util.LinkedList;
import java.util.List;

public class Vertex {
    public String name;
    public List<Edge> adjacent;
    public double cost;
    public Vertex previous;

    public Vertex(String name) {
        this.name=name;
        adjacent = new LinkedList<Edge>();
        cost = -1;
        previous = null;
    }

    @Override
    public String toString() {
        return name;
    }
}
