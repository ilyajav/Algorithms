import java.util.Comparator;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        // Данные для тестирования
        System.out.println("Collections class test");
        System.out.println(" ");
        System.out.println("First  task");
        List<Integer> intList = List.of(10, 20, 30, 40, 50);
        System.out.println("Index 30: " + binarySearch(intList, 30)); // 2
        System.out.println("Index 60: " + binarySearch(intList, 60)); // -1

        List<String> strList = List.of("apple", "banana", "cherry");
        System.out.println("Banana index: " + binarySearch(strList, "banana")); //1

        // Обработка пустого списка
        System.out.println("Index in empty: " + binarySearch(List.of(), 10)); // -1

        //Обработка null списка
        System.out.println("Index in null list: " + binarySearch(null, 10)); // -1

        System.out.println(" ");

        System.out.println("Second task");

        // Пример с Integer и стандартным компаратором
        List<Integer> intListComparator = List.of(10, 20, 30, 40, 50);
        System.out.println("Index 30: " + binarySearch(intListComparator, 30, Integer::compare)); // 2
        System.out.println("Index 60: " + binarySearch(intListComparator, 60, Integer::compare)); // -1

        // Пример с собственным компаратором для строк (по длине)
        List<String> strListComparator = List.of("apple", "banana", "kiwi", "pear");
        Comparator<String> stringLengthComparator = Comparator.comparingInt(String::length);
        System.out.println("Index 'kiwi': " + binarySearch(strListComparator,  "apple", stringLengthComparator)); // 0

        //Обработка null списка
        System.out.println("Index in null list: " + binarySearch(null, 10, Integer::compare)); // -1

        // Обработка пустого списка
        System.out.println("Index in empty list: " + binarySearch(List.of(), 10, Integer::compare)); // -1
    }

    // Задание 1
    public static <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T key) {
        if (list == null || list.isEmpty()) {
            return -1; // Обработка пустого или null списка
        }

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины

            // Используем compareTo для сравнения, так как T implements Comparable
            int cmp = list.get(mid).compareTo(key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Элемент найден
            }
        }
        return -1; // Элемент не найден
    }

    // Задание 2
    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
        if (list == null || list.isEmpty()) {
            return -1; // Обработка пустого или null списка
        }

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины

            // Используем компаратор для сравнения элементов
            int cmp = c.compare(list.get(mid), key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Элемент найден
            }
        }
        return -1; // Элемент не найден
    }
}
