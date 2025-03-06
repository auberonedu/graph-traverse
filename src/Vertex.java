import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
  T data;
  List<Vertex<T>> neighbors;
  // List<Vertex<T>> neighbors = new ArrayList<>();

  public Vertex(T data) {
    // "this" calls "Vertex(data, new ArrayList<>)"
    this(data, new ArrayList<>());
  }

  public Vertex(T data, List<Vertex<T>> neighbors) {
    this.data = data;
    this.neighbors = neighbors;
  }
}