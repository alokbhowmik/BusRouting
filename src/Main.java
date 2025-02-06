import entity.Path;
import entity.Stopage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Stopage sectorV       = new Stopage("Sector V");
        Stopage karunamoyee   = new Stopage("Karunamoyee");
        Stopage no_8_island   = new Stopage("8 No Island");
        Stopage bus_stand_206 = new Stopage("206 Bus stand");
        Stopage baishaki      = new Stopage("Baishaki");
        Stopage bidhannagrra  = new Stopage("Bidhan Nagaar");

        // Routing
        Routing routing = new Routing();
        routing.buildGraph(sectorV, karunamoyee, 4);
        routing.buildGraph(karunamoyee, no_8_island, 1);
        routing.buildGraph(no_8_island, bus_stand_206, 0.5);
        routing.buildGraph(bus_stand_206, baishaki, 0.5);
        routing.buildGraph(baishaki, bidhannagrra, 5);
        routing.buildGraph(karunamoyee, bidhannagrra, 15);

        Path path = routing.shortestPath(sectorV, bidhannagrra);
        path.printPath();

    }
}