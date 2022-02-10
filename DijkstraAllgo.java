import java.util.LinkedList;

 class Dijkstra {
    static class Edge { // creating a Node that will hold source , destination vertex and weight between them
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    int vertices;       // to hold number of vertices in a graph
    LinkedList<Edge>[] adjacencylist;       // creating Array of linked list of type Edge (Node)
     int distance[]; //distance array : will hold distance between two edges
     int parant[];   //predecessor array
     Boolean visit[];      //visiting array will show that a vertex is visited or not
    Dijkstra(int vertices) {  // Creating a Constructor of our Main class(Outer Class)
        this.vertices = vertices; // storing vertices
        adjacencylist = new LinkedList[vertices];  // allocating memory to the linkedList
        distance=new int[vertices];    // allocating memory to the distance array
        parant=new int[vertices];         // allocating memory to the parent array
        visit=new Boolean[vertices];         // allocating memory to the visiting array
        //initialize adjacency lists for all the vertices and also basic initialisations of above mentioned  arrays
        for (int i = 0; i < vertices; i++) {
            adjacencylist[i] = new LinkedList<>();    // At every index of i a linked list will ve created
            distance[i]=Integer.MAX_VALUE;      // at first distance array values will be maximum
            parant[i]=Integer.MAX_VALUE;// same for parent array
            visit[i]=false;    // and in visiting all vertexes will be false

        }
    }
    public void addEgde(int source, int destination, int weight) {    // insertion of a graph to the adjacency list
        Edge edge = new Edge(source, destination, weight); // creating object of static class
        adjacencylist[source].add(edge);       // storing the reference of node in adjacency list
    }

    public int GetminDistance(int distance[], Boolean Visit[]) // Minimum method  will return minimum value
     {
         // Initialize min value
         int min = Integer.MAX_VALUE, min_index = -1;

         for (int i = 0; i < this.vertices; i++)
             if (Visit[i] == false && distance[i] <= min) {
                 min = distance[i];
                 min_index = i;
             }

         return min_index;
     }
     public void DijkstraAlgorithm(int src) {     // this is the main dijkstara Algorithm

          distance[src] = 0;           //At first we have to assign our src vertex 0 distance
         for (int c = 0; c < this.vertices; c++)    // then we have run a loop for vertices times
         {
             int min = GetminDistance(distance, visit); // get the minimum value from the distance array which should not
             // be visited yet
             visit[min]=true;    // make it visited first

              LinkedList<Edge> a=adjacencylist[min];    //now point to the min index which is referring to a linked list
              int i=0;
              while (i<a.size())  // now run a loop for size times (i.e number of elements in that particular linked
                  {             // list referred by min index)
                  if (visit[a.get(i).destination] != true) {    // now check that the vertex is visited or not if it is not then go ahead
                      int cost = distance[min] + a.get(i).weight;    // calculate the cost (which is distance of u vertex plus
                                                                    // weight between u and v vertex)
                      if (cost < distance[a.get(i).destination]) { // if cost is less then the distance of v vertex(destination)
                                                                    // then update its distance with the cost
                          distance[a.get(i).destination] = cost;    // updating
                          parant[a.get(i).destination] = min;      // and store its parent vertex in parent array
                      }
                  }
                      i++;    // increment the i to loop over rest of the elements in the linked list

              }
         }
     }
     public void printGraph(int src) {

        System.out.println( "The shortest path from source :[" +src + "]  to all the other vertices is: ");
            for (int i = 1; i < this.vertices; i++)
            {
                if (i != src)
                {
                    System.out.println( "source:" + src + "\t destination:" + i + "\t MinCost is:" + distance[i] );
                    System.out.println( "parant of " + i + "--->" +parant[i] );
                }
            }
    }

}
public class DijkstraAllgo {
    public static void main(String[] args) {
        int vertices = 5;
        Dijkstra graph = new Dijkstra(vertices);
        graph.addEgde(0, 1, 10);
        graph.addEgde(0, 2, 3);
        graph.addEgde(1, 2, 1);
        graph.addEgde(1, 3, 2);
        graph.addEgde(2, 1, 4);
        graph.addEgde(2, 3, 8);
        graph.addEgde(2, 4, 2);
        graph.addEgde(3, 4, 7);
        graph.addEgde(4, 3, 9);
        graph.DijkstraAlgorithm(0);
        graph.printGraph(0);
    }
}











































































































//import java.util.LinkedList;
//import java.util.List;
//
////DIJKSTRA ALGORITHM (GREEDY METHOD)
//class Edge
//{
//    int vertex, weight;
//    public Edge(int v, int w)
//    {
//        this.vertex=v;
//        this.weight=w;
//    }
//}
//class DAA
//{
//    List<Edge> arr[];
//    public DAA(int v)
//    {
//               arr=new LinkedList[v];
//               for (int i=0;i<v;i++)
//                   arr[i]=new LinkedList<>();
//    }
//    public void Insertion(int u, int v,int weight)
//    {
//        arr[u].add(new Edge(v,weight));
//    }
//    public void display()
//    {
//        for (int i=0;i<arr.length;i++)
//            System.out.println(arr[0].get(0));
//
//    }
//}
//public class DijkstraAllgo {
//    public static void main(String[] args) {
//
//      DAA g= new DAA(5);
//        g.Insertion(0, 1, 10);
//        g.Insertion(0, 2, 3);
//        g.Insertion(1, 2, 1);
//        g.Insertion(1, 3, 2);
//        g.Insertion(2, 1, 4);
//        g.Insertion(2, 3, 8);
//        g.Insertion(2, 4, 2);
//        g.Insertion(3, 4, 7);
//        g.Insertion(4, 3, 9);
//        g.display();
//    }
//}































//class Dalgo
//{
//    int distance[];
//    boolean visit[];
//    int parent[];
//    int size;
//    Dalgo(int size) // constructor for initialization of arrays and other variables
//    {
//        distance=new int[size];
//        visit= new boolean[size];
//        parent= new  int[size];
//        this.size=size;
//        for(int i=0;i<size;i++) // Initializing the arrays
//        {
//            distance[i]=Integer.MAX_VALUE;
//            visit[i]=false;
//            parent[i]=-1;
//        }
//    }
//    // Finding the minimum distance
//    public int findMinDistance(int[] distance, boolean[] visitedVertex) {
//        int minDistance = Integer.MAX_VALUE;
//        int minDistanceVertex = -1;
//        for (int i = 0; i < distance.length; i++) {
//            if (!visitedVertex[i] && distance[i] < minDistance) {
//                minDistance = distance[i];
//                minDistanceVertex = i;
//            }
//        }
//        return minDistanceVertex;
//    }
//    public void Dijkstra(int source)
//    {
//        distance[source] = 0;
//        for (int i = 0; i < this.size; i++) {
//
//            // Update the distance between neighbouring vertex and source vertex
//            int u = findMinDistance(distance, visit);
//            visit[u] = true;
//
//            // Update all the neighbouring vertex distances
//            for (int v = 0; v < this.size; v++) {
//                if (!visit[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
//                    distance[v] = distance[u] + graph[u][v];
//                }
//            }
//        }
//    }
//}
//public class DijkstraAllgo {
//    public static void main(String[] args) {
//
//    }
//}
