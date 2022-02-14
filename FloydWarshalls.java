/*ALL PAIR SHORTEST PATH ALGORITHM USING DYNAMIC PROGRAMMING APPROACH
Floyd-Warshall Algorithm is an algorithm for finding the shortest path
between all the pairs of vertices in a weighted graph. This algorithm works
 for both the directed and undirected weighted graphs. But,
it does not work for the graphs with negative cycles
 (where the sum of the edges in a cycle is negative)..
 */

class FloydWarshallAlgorithm
{

    int Verticessize;
    int Distance[][];
    FloydWarshallAlgorithm(int x, int OriginalDistance[][])
    {
        this.Verticessize=x;
        Distance= new int[this.Verticessize][this.Verticessize];   //create a new matrix of the vertices size dimenions

        //copying the elemets of original matrix to the newly created matrix
        for (int i = 0; i < this.Verticessize; i++)
            for (int j = 0; j < this.Verticessize; j++)
                Distance[i][j] = OriginalDistance[i][j];
    }
    boolean floydWarshall() {        //implementing floyd warshalls algorithm
        int i,j,k;
        // Adding vertices individually
        for (k = 0; k < this.Verticessize; k++) {      //for k intermediate nodes
            for (i = 0; i < this.Verticessize; i++) {      //for rows
                for (j = 0; j < this.Verticessize; j++) {     //for cols

                    //updating the distance here k is an intermediate node
                    //d[source][destination]= Min(d[source][destination], d[source][k]+d[k][destination]
                    if (Distance[i][k] + Distance[k][j] < Distance[i][j])
                        Distance[i][j] = Distance[i][k] + Distance[k][j];

                }
            }
        }

        // If distance of any vertex from itself
        // becomes negative, then there is a negative
        // weight cycle.
        for (int p = 0; p < this.Verticessize ;p++)
            if (Distance[p][p] < 0)
                return true;
        return false;

    }

    //print the shortest path's
    void printMatrix(boolean isNegative)
    {
        if(isNegative!=true) {
            System.out.println(" The following matrix shows the shortest distances between every pair of vertices");
            for (int i = 0; i < this.Verticessize; ++i) {
                for (int j = 0; j < this.Verticessize; ++j) {
                    if (Distance[i][j] == 9999)
                        System.out.print("INF ");
                    else
                        System.out.print(Distance[i][j] + "  ");
                }
                System.out.println();
            }
        }
        else
            System.out.println("OOPS YES, The graph contains a negative cycle.");
    }

}
public class FloydWarshalls
{

    public static void main(String[] args) {
        int INF=9999;           //as infinite cost between two vertices
        int OriginalDistance[][] = {
                //infinity as integer.maxvalue
//                {0, 5, INF, INF},      //check on weighted graph without a negative cycle
//                {50, 0, 15, 5},
//                {30, INF, 0, 15},
//                {15, INF, 5, 0}


                //checking on weighted graph with a negative cycle
                {0   , 1   , INF , INF},
                {INF , 0   , -1  , INF},
                {INF , INF , 0   ,  -1},
                {-1  , INF , INF ,   0}
        };
        int NumberOfVertices=4;
        FloydWarshallAlgorithm obj = new FloydWarshallAlgorithm(NumberOfVertices,OriginalDistance);
        //vertices size and Original distance of all the pairs of the graph

        //invoke the floydwarshals algo
       boolean isNegative= obj.floydWarshall();

        //print the calculated distances of all pairs
        obj.printMatrix(isNegative);
    }
}
// Time Complexity
// There are three loops. Each loop has constant complexities. So, the time complexity of the Floyd-Warshall algorithm is O(n3).

// Space Complexity
// The space complexity of the Floyd-Warshall algorithm is O(n2).



/*
Follow the steps below to find the shortest path between all the pairs of vertices.

Create a matrix A0 of dimension n*n where n is the number of vertices. The row and the column are indexed as i and j respectively.
i and j are the vertices of the graph.
Each cell A[i][j] is filled with the distance from the ith vertex to the jth vertex.
If there is no path from ith vertex to jth vertex, the cell is left as infinity.

2. Now, create a matrix A1 using matrix A0. The elements in the first column and the first row are left as they are.
 The remaining cells are filled in the following way.
Let k be the freezing vertex in the shortest path from source to destination.
 In this step, k is the first vertex.A[i][j] is filled with (A[i][k] + A[k][j]) if (A[i][j] > A[i][k] + A[k][j]).
That is, if the direct distance from the source to the destination is greater than the path through the vertex k,
then the cell is filled with A[i][k] + A[k][j].
In this step, k is vertex 1. We calculate the distance from the source vertex to destination vertex through this vertex k.


3. In a similar way, A2 is created using A3. The elements in the second column and the second row are left as they are.
In this step, k is the second vertex (i.e. vertex 2). The remaining steps are the same as in step 2.

4. Similarly, A3 and A4 is also created.


5. A4 gives the shortest path between each pair of vertices.
 */
