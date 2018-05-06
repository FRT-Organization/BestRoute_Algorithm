import java.util.ArrayList;
import java.util.List;

public class Places {
    String name;
    Boolean isOrigin = false;
    Boolean isDestination = false;
    Boolean visited;
    List<Places> neighbors = new ArrayList<>();

    public Places() {
    }

    public Places(String name, Boolean visited) {
        this.name = name;
        this.visited = visited;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Boolean isVisited() {

        return visited;
    }

    public void setVisited(Boolean visited) {

        this.visited = visited;
    }

    public List<Places> getNeighbors() {

        return neighbors;
    }

    public void setNeighbors(List<Places> neighbors) {

        this.neighbors = neighbors;
    }

    public void addNeighbor(Places neighbor){

        neighbors.add(neighbor);
    }

    public Boolean getOrigin() {
        return isOrigin;
    }

    public void setOrigin(Boolean origin) {
        isOrigin = origin;
    }

    public Boolean getDestination() {
        return isDestination;
    }

    public void setDestination(Boolean destination) {
        isDestination = destination;
    }

    public Boolean getVisited() {
        return visited;
    }

    public Boolean isOrigin(){
        return isOrigin;
    }
}
