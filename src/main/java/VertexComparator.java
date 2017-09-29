public class VertexComparator<T extends Vertex> implements java.util.Comparator<T> {
    public int compare(T o1, T o2) {
        Vertex a =  o1;
        Vertex b =  o2;
        if(a.cost < b.cost) return -1;
        if(a.cost == b.cost) return 0;
        return 1;
    }
}
