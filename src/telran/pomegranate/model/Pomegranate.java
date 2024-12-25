package telran.pomegranate.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pomegranate implements Iterable<Seed> {
    private final List<Seed> seeds;
    private static final int MIN_SEEDS = 400;
    private static final int MAX_SEEDS = 700;

    public Pomegranate(List<Seed> seeds) {
        this.seeds = seeds;
    }

    public Pomegranate() {
        this.seeds = fillPomegranate();
    }

    public List<Seed> getSeeds() {
        return seeds;
    }

    @Override
    public String toString() {
        return "Pomegranate{" +
                "count of seeds =" + seeds.size() +
                '}';
    }

    @Override
    public Iterator iterator() {
        return seeds.iterator();
    }

    private List<Seed> fillPomegranate(){
        return new Random()
                .ints(1, MIN_SEEDS, MAX_SEEDS)
                .boxed()
                .map(Seed[]::new)
                .flatMap(Arrays::stream)
                .map(seed -> new Seed())
                .collect(Collectors.toList());
    }


}
