package telran.pomegranate;

import telran.pomegranate.model.Box;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PomegranateAppl {
    public static void main(String[] args) {
        List<Box> boxes = getBoxes();
        int summary = boxes.stream()
                .mapToInt(Box::getSumOfSeeds)
                .sum();

        int maxSeeds = boxes.stream()
                .mapToInt(Box::getMaxOfSeeds)
                .max()
                .orElse(0);

        System.out.println("Total seeds in " + boxes.size() + " boxes = " + summary);
        System.out.println("Maximum seeds in box = " + maxSeeds);

        System.out.println("=== Boxes with maximum quantity of seeds ===");
        boxes.stream()
                .filter(box -> box.getMaxOfSeeds() == maxSeeds)
                .map(Box::getName)
                .forEach(System.out::println);
    }

    private static List<Box> getBoxes(){
        return new Random()
                .ints(1, 100, 200)
                .boxed()
                .map(Box[]::new)
                .flatMap(Arrays::stream)
                .map(box -> new Box())
                .collect(Collectors.toList());
    }
}
