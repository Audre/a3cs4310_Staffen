import java.util.LinkedList;

public class Graph {

    private int size;
    private LinkedList<Node> adjacencyList[];
    private int count;

    Graph(int size) {
        this.size = size;
        this.count = 0;

        adjacencyList = new LinkedList[size + 1];

        for (int i = 1; i <= this.size; i++) {
            adjacencyList[i] = new LinkedList<>();
            Node current = new Node(i);
            this.adjacencyList[i].add(current);
        }
    }

    public void addEdge(int source, int destination) {
        Node destPerson = new Node(destination);
        this.adjacencyList[source].add(destPerson);
    }

    public void countTables(int index){
        Node currentNode = this.adjacencyList[index].getFirst();
        int listSize = this.adjacencyList[index].size();
        if (!currentNode.getVisited() && listSize > 1){
            currentNode.setVisited(true);
            for (Node person : this.adjacencyList[index]) {
                if (!person.getVisited()) {
                    countTables(person.getPerson());
                }
            }

        } else if (!currentNode.getVisited()){
            currentNode.setVisited(true);
            this.count++;
            for (int i = currentNode.getPerson() + 1; i <= this.size; i++) {
                if (!this.adjacencyList[i].getFirst().getVisited()){
                    countTables(i);
                }
            }
        }

    }

    public int getCount() {
        return count;
    }
}
