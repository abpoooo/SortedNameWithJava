
import java.util.*;

public class NameComparator {

    static class LastNameComparator implements Comparator<String> {

        @Override
        public int compare(String name1, String name2) {
            String[] part1 = name1.split(" ");
            String[] part2 = name2.split(" ");
            return part1[part1.length - 1].compareTo(part2[part2.length - 1]);
        }


    }

    static class GivenNamesComparator implements Comparator<String> {
        @Override
        public int compare(String name1, String name2) {
            String[] givenName1 = GetGivenNames(name1);
            String[] givenName2 = GetGivenNames(name2);
            for (int i = 0; i < Math.min(givenName1.length, givenName2.length); i++) {
                int result = givenName1[i].compareTo(givenName2[i]);
                if (result != 0) return result;
            }
            return Integer.compare(givenName1.length, givenName2.length);
        }

        private String[] GetGivenNames(String name2) {
            String[] parts = name2.split(" ");
            return Arrays.copyOfRange(parts, 0, parts.length - 1);
        }
    }



}
