package entity;

import java.util.LinkedList;
import java.util.List;

public class Stopage {
    private final String name;
    private final List<String> buses = new LinkedList<>();

    public Stopage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
