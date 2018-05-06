import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Service {
    Places origin = new Places();
    Places neighbor = new Places();
    Places currentNode = new Places();
    List<Places> neighbors = new ArrayList<>();
    List<Places> visitedPlaces = new ArrayList<>();
    List<Places> remainingPlaces = new ArrayList<>();
    Random rand = new Random();

    List<Places> calculateRoute(List<Places> places){
        //Copy remaining places
        remainingPlaces.addAll(places);

        //Search for origin village
        for (Places locations : places){
            if(locations.isOrigin){
                origin = locations;
            }
        }

        //Add origin to the path and remove it from the remainingPlaces
        visitedPlaces.add(origin);
        remainingPlaces.remove(origin);

        while(!remainingPlaces.isEmpty()){
            //Find possible neighbors of the current node
            currentNode = visitedPlaces.get(visitedPlaces.size()-1);
            neighbors = currentNode.getNeighbors();

            //Validate that the current node has neighbors
            //TODO: Add distance measurement to find the best route
            if (!neighbors.isEmpty()){

                //Choose a neighbor that has not been visited
                for (Places locations : neighbors){
                    if (remainingPlaces.contains(locations)){
                        neighbor = locations;

                        //Add the current neighbor to the path and remove it from the remainingPlaces
                        visitedPlaces.add(neighbor);
                        remainingPlaces.remove(neighbor);
                        break;
                    }else{
                        neighbors = neighbor.getNeighbors();
                        //What happens if there are no unvisited neighbors.
                        for (int i = 0; i<neighbors.size(); i++){
                            List<Places> extendedNeighbors = neighbors.get(i).getNeighbors();
                            for (int j = 0; j<extendedNeighbors.size(); j++){
                                if(remainingPlaces.contains(extendedNeighbors.get(j))){
                                    visitedPlaces.add(neighbors.get(i));
                                    neighbor = extendedNeighbors.get(j);
                                    visitedPlaces.add(neighbor);
                                    remainingPlaces.remove(neighbor);
                                }
                            }
                        }
                    }
                }
            }else{
                //TODO: What do I do when there is no neighbors available
                break;
            }


            //Did every village get rid of their rubbish?
            if (remainingPlaces.isEmpty()){
                Places lastNode = visitedPlaces.get(visitedPlaces.size()-1);
                List<Places> villagesNearFinishes = lastNode.getNeighbors();
                for (int i = 0; i< places.size(); i++){
                    if (places.get(i).isDestination){
                        visitedPlaces.add(places.get(i));
                        break;
                    }
                }
            }
        }
        return visitedPlaces;
    }
}
