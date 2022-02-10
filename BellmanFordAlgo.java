//BELL MAN -FORD ALGORITHM
/* Bellman Ford algorithm helps us find the shortest path from a vertex to all other vertices of a weighted graph.
It is similar to Dijkstra's algorithm but it can work with graphs in which edges can have negative weights.
it can not work with undirected graph containing negative edge weights also if a directed graph contains negative edge
weight cycle then Bell aman bhaie sahab can not calculate shortest paths but cam detect that negative edge weight cycle
 time complexity :
        Best Case Complexity	O(E)
        Average Case Complexity	O(VE)
        Worst Case Complexity	O(VE) */
import java.util.LinkedList;

class BellMan {
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
    boolean Updated;
    int vertices;       // to hold number of vertices in a graph
    LinkedList<Edge>[] adjacencylist;       // creating Array of linked list of type Edge (Node)
    int distance[]; //distance array : will hold distance between two edges
    int parant[];   //predecessor array
//    Boolean visit[];      //visiting array will show that a vertex is visited or not
    BellMan(int vertices) {  // Creating a Constructor of our Main class(Outer Class)
        this.vertices = vertices; // storing vertices
        adjacencylist = new LinkedList[vertices];  // allocating memory to the linkedList
        distance=new int[vertices];    // allocating memory to the distance array
        parant=new int[vertices];         // allocating memory to the parent array
//        visit=new Boolean[vertices];         // allocating memory to the visiting array
        //initialize adjacency lists for all the vertices and also basic initialisations of above mentioned  arrays
        for (int i = 0; i < vertices; i++) {
            adjacencylist[i] = new LinkedList<>();    // At every index of i a linked list will ve created
            distance[i]=Integer.MAX_VALUE;      // at first distance array values will be maximum
            parant[i]=Integer.MAX_VALUE;// same for parent array
//            visit[i]=false;    // and in visiting all vertexes will be false

        }
    }
    public void addEgde(int source, int destination, int weight) {    // insertion of a graph to the adjacency list
        Edge edge = new Edge(source, destination, weight); // creating object of static class
        adjacencylist[source].add(edge);       // storing the reference of node in adjacency list
    }


    public void BellManFordAlgo(int src) {     // this is the main Bell-Man Ford Algorithm
        parant[src]=-1;     //at first initialize source of parent as negative one
        distance[src]=0;     // and distance of src will be zero

        // we have to loop for vertices -1 times
        for (int p = 0; p < this.vertices-1; p++)
        {
            Updated=false;
            for (int c = 0; c < this.vertices; c++)    // this is for each vertex to get updated
            {
                LinkedList<BellMan.Edge> a=adjacencylist[c];    //now point to the starting  index which is referring to a linked list
                int i=0;
                while (i<a.size())
                    // now run a loop for size times (i.e number of elements in that particular linked
                {             // list referred by min index)

                        int cost = distance[c] + a.get(i).weight;    // calculate the cost (which is distance of u vertex plus
                        // weight between u and v vertex)
                        if (cost < distance[a.get(i).destination]) { // if cost is less then the distance of v vertex(destination)
                            // then update its distance with the cost
                            distance[a.get(i).destination] = cost;    // updating
                            parant[a.get(i).destination] = c;      // and store its parent vertex in parent array

                            if(p>0) // checking if distance array will remain same or not at each index time of p
                            Updated=true;

                        }

                    i++;    // increment the i to loop over rest of the elements in the linked list

                }
            }
            // when all vertices distance will be updated at first time then
            // after second or third upto vertices times  if  no updation
            // takes place at any vertices time i.e if we find the distance array is not getting updated now i.e getting the
            // same value of each vertex then we don't need to go for other vertic's timees in a loop we can break and reduce
            // time complexity
            if(p>0&&Updated==false)
                break;

        }
        //now after checking the graph vertices -1 time in a loop if we got same distance array that means  updated variable will be false
        // at that time then we don't need to calculate again the distance array values if we did't got the same array
        // then we have to check it one more time using below mention code
        if(Updated==true)
        {
            for (int c = 0; c < this.vertices; c++)    // then we have run a loop for vertices times
            {
                LinkedList<BellMan.Edge> a = adjacencylist[c];    //now point to the min index which is referring to a linked list
                int i = 0;
                while (i < a.size())  // now run a loop for size times (i.e number of elements in that particular linked
                {             // list referred by min index)

                    int cost = distance[c] + a.get(i).weight;    // calculate the cost (which is distance of u vertex plus
                    // weight between u and v vertex)
                    if (cost < distance[a.get(i).destination]) { // if cost is less then the distance of v vertex(destination)

                        System.out.println("OOPS THE GRAPH HAS A NEGATIVE EDGE WEIGHT CYCLE AND BELL MAN BHAIE SAAHAB DETECTED IT :)");
                        return;
                    }

                    i++;    // increment the i to loop over rest of the elements in the linked list

                }
            }
        }


    }
    public void printGraph(int src) {

        if(Updated!=true) {
            System.out.println("The shortest path from source :[" + src + "]  to all the other vertice's is: ");
            for (int i = 1; i < this.vertices; i++) {
                if (i != src) {
                    System.out.println("source:" + src + "\t destination:" + i + "\t MinCost is:" + distance[i]);
                    System.out.println("parant of " + i + "--->" + parant[i]);
                }
            }
        }
    }

}
public class BellmanFordAlgo {
    public static void main(String[] args) {
        int vertices = 3;
        BellMan graph = new BellMan(vertices);
        // checking with graph containing  no negative edge weight cycle below
//        graph.addEgde(0, 1, 6);
//        graph.addEgde(0, 2, 7);
//        graph.addEgde(1, 2, 8);
//        graph.addEgde(1, 3, -4);
//        graph.addEgde(1, 4, 5);
//        graph.addEgde(2, 3, 9);
//        graph.addEgde(2, 4, -3);
//        graph.addEgde(3, 4, 7);
//        graph.addEgde(3, 0, 2);
//        graph.addEgde(4, 1, -2);

        // checking with a graph having a  Negative edge weight cycle graph below
//        graph.addEgde(0, 1, 2);
//        graph.addEgde(1, 2, 3);
//        graph.addEgde(2, 0, -6);

        graph.BellManFordAlgo(0);
        graph.printGraph(0);
    }
}


