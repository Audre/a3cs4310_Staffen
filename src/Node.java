public class Node {
    protected int person;
    protected Boolean visited;

    public Node(int person) {
        this.person = person;
        this.visited = false;
    }

    public int getPerson() {
        return person;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }
}
