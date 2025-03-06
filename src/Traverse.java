import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Traverse {
  public static void main(String[] args) {
    // See below site for visualization of this graph
    // https://auberonedu.github.io/graph-explore/graph_site/viz.html
    Vertex<Integer> v3  = new Vertex<>(3);
    Vertex<Integer> v7  = new Vertex<>(7);
    Vertex<Integer> v12 = new Vertex<>(12);
    Vertex<Integer> v34 = new Vertex<>(34);
    Vertex<Integer> v56 = new Vertex<>(56);
    Vertex<Integer> v78 = new Vertex<>(78);
    Vertex<Integer> v91 = new Vertex<>(91);
    Vertex<Integer> v45 = new Vertex<>(45);
    Vertex<Integer> v23 = new Vertex<>(23);
    Vertex<Integer> v67 = new Vertex<>(67);

    v3.neighbors  = new ArrayList<>(List.of(v7, v34));
    v7.neighbors  = new ArrayList<>(List.of(v12, v45, v34, v56));
    v12.neighbors = new ArrayList<>(List.of(v7, v56, v78));
    v34.neighbors = new ArrayList<>(List.of(v34, v91)); 
    v56.neighbors = new ArrayList<>(List.of(v78));
    v78.neighbors = new ArrayList<>(List.of(v91));
    v91.neighbors = new ArrayList<>(List.of(v56));
    v45.neighbors = new ArrayList<>(List.of(v23));
    v23.neighbors = new ArrayList<>(List.of());
    v67.neighbors = new ArrayList<>(List.of(v91));
    // "List of" is immutable, but ArrayList is mutable - this is important!

    // Vertex<Integer> v1 = new Vertex<>(1);
    // System.out.println(v1.neighbors);

    dfs(v7);
    System.out.println();
    dfs(v34);

    Vertex<String> hello = new Vertex<>("Hello");
    Vertex<String> world = new Vertex<>("world");
    Vertex<String> exclaim = new Vertex<>("!");
    Vertex<String> comma = new Vertex<>(",");
    Vertex<String> how = new Vertex<>("how");
    Vertex<String> are = new Vertex<>("are");
    Vertex<String> you = new Vertex<>("you");
    Vertex<String> the = new Vertex<>("the");
    Vertex<String> cats = new Vertex<>("cats");
    Vertex<String> question = new Vertex<>("?");

    hello.neighbors = new ArrayList<>(List.of(comma, world, how));
    world.neighbors = new ArrayList<>(List.of(exclaim));
    exclaim.neighbors = new ArrayList<>(List.of(hello));
    comma.neighbors = new ArrayList<>(List.of(world, how));
    how.neighbors = new ArrayList<>(List.of(are));
    are.neighbors = new ArrayList<>(List.of(you, the));
    you.neighbors = new ArrayList<>(List.of(question));
    the.neighbors = new ArrayList<>(List.of(cats));
    cats.neighbors = new ArrayList<>(List.of(question));
    question.neighbors = new ArrayList<>(List.of(question));

    // dfs(comma);
    
  }

  // node = vertex = node - they are the same thing!
  public static <T> void dfs(Vertex<T> vertex) {
    dfs(vertex, new HashSet<Vertex<T>>());
  }

  private static <T> void dfs(Vertex<T> vertex, Set<Vertex<T>> visited) {
    if (vertex == null) return;
    if (visited.contains(vertex)) return;
    
    visited.add(vertex);
    System.out.println(vertex.data);
    
    if (vertex.neighbors == null) return;

    for (var neighbor: vertex.neighbors) {
      dfs(neighbor, visited);
    }

  }

}
