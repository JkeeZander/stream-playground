package brickset;

import repository.Repository;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    /**
     * Count the number of legoSets based on theme
     * 
     * @author Altan Dzhumaev
     * @param theme string containing theme to search for
     * @return integer count of legoSets with the given theme
     */
    public long countLegoWithTheme(String theme) {
        return getAll().stream().filter(legoSet -> legoSet.getTheme().equals(theme)).count();
    }

    /**
     * print Names of Legos oin upper case that have more pieces than the given
     * integer
     * 
     * @author Altan Dzhumaev
     * @param threshold integer that is used for thresholding pieces numbers
     */
    public void printUpperLegoWithPieces(int threshold) {
        getAll().stream().filter(legoSet -> legoSet.getPieces() >= threshold)
                .map(legoSet -> legoSet.getName().toUpperCase()).forEach(System.out::print);
    }

    /**
     * @author Altan Dzhumaev
     * @param s string containing name to search for
     */
    public void printLegoWithName(String s){
        System.out.println(getAll().stream().filter(legoSet->legoSet.getName().equals(s)).findFirst());
    }

    /**
     * Prints the years of the first twenty results by the given theme
     * @author Altan Dzhumaev
     * @param theme theme to filter the stream search
     */
    public void printYearFirstTwentyWithTheme(String theme){
        getAll().stream().filter(legoSet -> legoSet.getTheme().equals(theme)).limit(20).forEach(s->System.out.print(s.getYear()));
    }

    /**
     * prints the sum of all pieces
     * @author Altan Dzhumaev
     */
    public void printSumOfPieces(){
        System.out.println(getAll().stream().map(a->a.getPieces()).reduce(0,Integer::sum));
    }


    public static void main(String[] args) {
        var repository = new LegoSetRepository();
        System.out.println(repository.countLegoWithTheme("Duplo"));
        repository.printUpperLegoWithPieces(400);
        System.out.println("");
        repository.printLegoWithName("Heart");
        repository.printYearFirstTwentyWithTheme("Duplo");
        System.out.println();
        repository.printSumOfPieces();
    }

}
