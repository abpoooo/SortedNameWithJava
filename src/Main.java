
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        NameSortedWay sorter = new NameSorter.LastNameGivenNamesSortingStrategy();
        NameSorter nameSorter = new NameSorter(sorter);
        nameSorter.run("unsorted-names-list.txt", "sorted-names-list.txt");

    }

    public static class NameSorter {

        private final NameSortedWay sorting;

        public NameSorter(NameSortedWay sorting) {
            this.sorting = sorting;
        }

        public void run(String inputFileName, String outputFileName) throws IOException {
            List<String> unsortedNames = new ArrayList<>();
            Scanner scanner = new Scanner(new File(inputFileName));
            while (scanner.hasNextLine()) {
                unsortedNames.add(scanner.nextLine());
            }
            scanner.close();

            sorting.sort(unsortedNames);

            for (String name : unsortedNames) {
                System.out.println("before " + name);
            }

            PrintWriter writer = new PrintWriter(new FileWriter(outputFileName));
            for (String name : unsortedNames) writer.println(name);
            writer.flush();
            writer.close();
        }

        static class LastNameGivenNamesSortingStrategy implements NameSortedWay {
            public void sort(List<String> names) {
                Collections.sort(names, new NameComparator.LastNameComparator().thenComparing(new NameComparator.GivenNamesComparator()));
            }
        }


    }
}