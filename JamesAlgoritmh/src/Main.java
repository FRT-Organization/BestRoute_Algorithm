import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();

//        Lorry lorry = new Lorry();
//
        //Villages
        Places serres = new Places("Serres", false);
        Places provatas = new Places("Provatas", false);
        Places mitrousi = new Places("Mitrousi", false);
        Places skoutari = new Places("Skoutari", false);
        Places a_kamila = new Places("A.Kamila", false);
        Places k_kamila = new Places("K.Kamila", false );
        Places koumaria = new Places("Koumaria", false);
        Places adelfiko = new Places("Adelfiko", false);
        Places peponia = new Places("Peponia", false);
        Places eleni = new Places("Ag.Eleni", false);

        serres.setOrigin(true);
        adelfiko.setDestination(true);

        serres.addNeighbor(provatas);
        serres.addNeighbor(mitrousi);
        serres.addNeighbor(skoutari);

        provatas.addNeighbor(a_kamila);
        provatas.addNeighbor(serres);

        mitrousi.addNeighbor(serres);
        mitrousi.addNeighbor(a_kamila);
        mitrousi.addNeighbor(k_kamila);
        mitrousi.addNeighbor(koumaria);

        skoutari.addNeighbor(peponia);
        skoutari.addNeighbor(eleni);

        a_kamila.addNeighbor(provatas);
        a_kamila.addNeighbor(mitrousi);
        a_kamila.addNeighbor(koumaria);

        k_kamila.addNeighbor(mitrousi);
        k_kamila.addNeighbor(skoutari);
        k_kamila.addNeighbor(koumaria);


        koumaria.addNeighbor(mitrousi);
        koumaria.addNeighbor(a_kamila);
        koumaria.addNeighbor(k_kamila);
        koumaria.addNeighbor(adelfiko);

        adelfiko.addNeighbor(koumaria);
        adelfiko.addNeighbor(peponia);

        peponia.addNeighbor(adelfiko);
        peponia.addNeighbor(skoutari);
        peponia.addNeighbor(eleni);

        eleni.addNeighbor(skoutari);
        eleni.addNeighbor(peponia);

        List<Places> places = new ArrayList<>();
        places.add(serres);
        places.add(provatas);
        places.add(mitrousi);
        places.add(skoutari);
        places.add(a_kamila);
        places.add(k_kamila);
        places.add(koumaria);
        places.add(adelfiko);
        places.add(peponia);
        places.add(eleni);



        List<Places> visitedPlaces = service.calculateRoute(places);

        for (int i = 0; i< visitedPlaces.size(); i++){
            System.out.println(visitedPlaces.get(i).getName());
        }
    }
}
