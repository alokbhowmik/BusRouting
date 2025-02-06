package entity;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private final List<Stopage> path = new ArrayList<>();
    private double dist = Double.MAX_VALUE;

    public void addPath(Stopage stopage) {
        path.add(stopage);
    }

    public List<Stopage> getPath() {
        return path;
    }

    public double getDist() {
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    public void printPath() {
        for (Stopage stopage : path) {
            System.out.print(stopage.getName() + " => ");
        }
        System.out.println();
        System.out.println("Minimum Distance is : " + dist + " km");
    }
}
