import java.util.*;

public class Main {
    private static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static Map<Character, Integer> frequencyMap(String text) {
        Map<Character, Integer> frequencyMeet = new HashMap<>();
        char ch;
        int frequency;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                ch = Character.toLowerCase(text.charAt(i));
            } else {
                continue;
            }
            if (frequencyMeet.containsKey(ch)) {
                frequency = frequencyMeet.get(ch) + 1;
                frequencyMeet.put(ch, frequency);
            } else {
                frequencyMeet.put(ch, 1);
            }
        }
        return frequencyMeet;
    }

    public static void frequencyMax(Map<Character, Integer> map) {
        int max = maxValue(map.values());
        System.out.print("Буква встречалась чаще всего: ");
        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            if (kv.getValue() == max) {
                System.out.print(kv.getKey() + " ");
            }
        }
    }

    public static void frequencyMin(Map<Character, Integer> map) {
        int min = minValue(map.values());
        System.out.print("Буква встречалась реже всего: ");
        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            if (kv.getValue() == min) {
                System.out.print(kv.getKey() + " ");
            }
        }
    }

    public static int maxValue(Collection<Integer> values) {
        Set<Integer> set = new HashSet<>(values);
        int max = -1;
        for (int value : set) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int minValue(Collection<Integer> values) {
        Set<Integer> set = new HashSet<>(values);
        int min = Integer.MAX_VALUE;
        for (int value : set) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Map<Character, Integer> frequencyMeet = frequencyMap(TEXT);
        frequencyMax(frequencyMeet);
        System.out.println();
        frequencyMin(frequencyMeet);
    }
}
