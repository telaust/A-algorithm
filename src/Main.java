public class Main {


    public static void main(String[] args)
    {

        Graph graph = new Graph(5);

        // Make vertices
        graph.addVertex(7); // id : 0

        graph.addVertex(2); // id : 1

        graph.addVertex(3); // id : 2

        graph.addVertex(4); // id : 3

        graph.addVertex(5); // id : 4

        // Make edges
        graph.makeEdge(0, 1, 2);

        graph.makeEdge(0, 2, 16);

        graph.makeEdge(1, 3, 4);

        graph.makeEdge(3, 2, 7);

        graph.makeEdge(4, 1, 3);

        graph.makeEdge(4, 2, 8);

        // Display matrices
        graph.showAdjacencyMatrix();

        graph.showPathMatrix();

    }
}
