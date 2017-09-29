import java.util.*;

public class Graph {

    private Map<String,Vertex> vertexMap = new HashMap<String,Vertex>();

    public void addEdge(String srcName, String destName, double weight){
        Vertex src = getVertex(srcName);
        Vertex dest = getVertex(destName);
        src.adjacent.add(new Edge(dest,weight));
    }

    private Vertex getVertex(String srcName) {
        Vertex v = vertexMap.get(srcName);
        if(v==null) {
            v = new Vertex(srcName);
            vertexMap.put(srcName,v);
        }
        return v;
    }

    public void calcDijkstra(String srcName) {
        Vertex source = getVertex(srcName);
        source.cost = 0;
        Queue<Vertex> q = new PriorityQueue<Vertex>(1, new VertexComparator());
        q.add(source);
        while(!q.isEmpty()) {
            Vertex v = q.remove();
            for (Edge e: v.adjacent) {
                if(e.destination.cost > v.cost + e.weight || e.destination.cost < 0) e.destination.cost = v.cost+e.weight;
                q.add(e.destination);
            }
        }
    }

    public boolean isConnected(){
        calcUnweighted(vertexMap.entrySet().iterator().next().getValue().name);
        boolean connected = true;
        for (Map.Entry<String, Vertex> v: vertexMap.entrySet()) {
            Vertex vertex = v.getValue();
            if(vertex.cost < 0) connected = false;
        }
        return connected;
    }

    public void calcUnweighted(String srcName) {
        Vertex source = getVertex(srcName);
        source.cost = 0;
        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(source);

        while(!q.isEmpty()) {
            Vertex v = q.poll();
            for (Edge e: v.adjacent) {
                if(e.destination.cost > v.cost+1 || e.destination.cost < 0) e.destination.cost = v.cost+1;
                q.add(e.destination);
            }
        }
    }

    @Override
    public String toString() {
        String map = "";
        for(Map.Entry<String, Vertex> vertex : vertexMap.entrySet()) {
            Vertex v = vertex.getValue();
            map += "("+ v.cost +") " + v.name + " -> ";
            for (Edge e: v.adjacent) {
                map += e.destination +"("+ e.weight +")" + ", ";
            }
            map += "\n";
        }
        return map;
    }
}
