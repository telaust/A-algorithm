import java.util.HashMap;

public class Graph {

    private boolean[][]                 adjacencyMatrix ;
    private int                         verts;                  // amount of vertices
    private HashMap<Integer, Integer>   map;                    // Map of ID & Entity
    private static int                  numberOfVertices = 0;   // PermGen section in Heap
    private int[][]                     pathMatrix;
//    private boolean[][]                 directions;             // For directed graph

    Graph(int verts)
    {
        if (verts <= 3) return; // illegal format exception

        this.verts = verts;
        this.adjacencyMatrix  =         new boolean[verts][verts];
        this.pathMatrix       =         new int[verts][verts];
        this.map              =         new HashMap<>();

        for (int i = 0; i < verts; i++)
            for (int ii = 0; ii < verts; ii++)
                adjacencyMatrix[i][ii] = false; // 0 everywhere

        for (int i = 0; i < verts; i++)
            for (int ii = 0; ii < verts; ii++)
                pathMatrix[i][ii] = 0; // 0 everywhere
    }

    public void addVertex(int entity)
    {
        map.put(getOrdinal(), entity); // Adding to map entity
    }

    public void showAdjacencyMatrix()
    {
        System.out.println("\nAdjacency matrix : \n");

        for (int i = 0; i < verts; i++) {
            for (int ii = 0; ii < verts; ii++) {
                System.out.print(adjacencyMatrix[i][ii] + "  ");
            }
            System.out.println();
        }

    }


    public void showPathMatrix()
    {
        System.out.println("\nPath matrix : \n");

        for (int i = 0; i < verts; i++) {
            for (int ii = 0; ii < verts; ii++) {
                System.out.print(pathMatrix[i][ii] + "  ");
            }
            System.out.println();
        }
    }

    public void makeEdge(int id_from, int id_to, int heuristic)
    {
        for (int row = 0; row < verts; row++)
        {
            for (int col = 0; col < verts; col++)
            {
                if (row == id_from && col == id_to)
                {
                    adjacencyMatrix[row][col] = true;
                    adjacencyMatrix[col][row] = true;

                    pathMatrix[row][col] = heuristic;
                    pathMatrix[col][row] = heuristic;

                    break;
                }
            }
        }
    }


    public int getOrdinal() // я буду присваивать каждому vertex свой id для удобного добавления edges
    {
        return numberOfVertices++;
    }

    public HashMap<Integer, Integer> getMap()
    {
        return this.map;
    }

    public int getVerts()
    {
        return this.verts;
    }

}
