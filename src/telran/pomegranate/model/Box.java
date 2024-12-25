package telran.pomegranate.model;

import java.util.*;
import java.util.stream.Collectors;

public class Box implements Iterable<Pomegranate> {
    private final String name;
    private final List<Pomegranate> granates;
    private static final int MIN_QUANTITY = 10;
    private static final int MAX_QUANTITY = 20;

    public Box(String name, List<Pomegranate> granates) {
        this.name = name;
        this.granates = granates;
    }

    public Box(String name) {
        this(name, fillBox());
    }

    public Box() {
        this(createName(), fillBox());
    }

    public String getName() {
        return name;
    }

    public int quantity(){
        return granates.size();
    }

    private static List<Pomegranate> fillBox(){
        return new Random()
                .ints(1, MIN_QUANTITY, MAX_QUANTITY)
                .boxed()
                .map(Pomegranate[]::new)
                .flatMap(Arrays::stream)
                .map(granat -> new Pomegranate())
                .collect(Collectors.toList());
    }

    private static String createName(){
        return "Box #" + Math.round(Math.random() * 100);
    }

    @Override
    public String toString() {
        return "Box{" +
                "name='" + name + '\'' +
                ", count of pomegranates = " + granates.size() +
                '}';
    }

    @Override
    public Iterator<Pomegranate> iterator() {
        return granates.iterator();
    }

    public int getSumOfSeeds() {
        return granates.stream()
                .mapToInt(Pomegranate::quantity)
                .sum();
    }

    public int getMaxOfSeeds(){
        return granates.stream()
                .mapToInt(Pomegranate::quantity)
                .max()
                .orElse(0);
    }

}
