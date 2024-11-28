import java.util.Comparator;

public class Arrays {

    public static void main(String[] args) {
        // Данные для тестирования
        byte[] byteArray = {1, 2, 3, 4, 5};
        char[] charArray = {'a', 'b', 'c', 'd', 'e'};
        double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        float[] floatArray = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        int[] intArray = {1, 2, 3, 4, 5};
        long[] longArray = {1L, 2L, 3L, 4L, 5L};
        short[] shortArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"red", "car", "test", "house", "cat"};


        // Вызов методов
        int byteIndex = binarySearch(byteArray, (byte) 4);
        int charIndex = binarySearch(charArray, 'b');
        int doubleIndex = binarySearch(doubleArray, 3.3);
        int floatIndex =  binarySearch(floatArray, 3.3f);
        int intIndex = binarySearch(intArray, 2);
        int longIndex = binarySearch(longArray, 3L);
        int shortIndex = binarySearch(shortArray, (short) 3);


        // Вызов методов с индексами
        int byteIndexRange = binarySearch(byteArray, 1, 4, (byte) 3);
        int charIndexRange = binarySearch(charArray, 1, 4, 'd');
        int doubleIndexRange = binarySearch(doubleArray, 1, 4, 3.3);
        int floatIndexRange = binarySearch(floatArray, 1, 4, 3.3f);
        int intIndexRange = binarySearch(intArray, 1, 4, 3);
        int longIndexRange = binarySearch(longArray, 1, 4, 3L);
        int shortIndexRange = binarySearch(shortArray, 1, 4, (short) 3);


        // Вызов методов с компаратором
        int stringIndex = binarySearch(stringArray, "test", Comparator.naturalOrder());
        int stringIndexRange = binarySearch(stringArray, 1, 4, "test", Comparator.naturalOrder());


        // Вывод результатов
        System.out.println("Array class test");
        System.out.println(" ");
        System.out.println("Index results");
        System.out.println("Binary search byte Index: " + byteIndex); // 3
        System.out.println("Binary search char Index: " + charIndex); // 1
        System.out.println("Binary search double Index: " + doubleIndex); // 2
        System.out.println("Binary search float Index: " + floatIndex); // 2
        System.out.println("Binary search int Index: " + intIndex); // 1
        System.out.println("Binary search long Index: " + longIndex); // 2
        System.out.println("Binary search short Index: " + shortIndex); //2
        System.out.println(" ");
        System.out.println("Index range results");
        System.out.println("Binary search byte index range: " + byteIndexRange); //2
        System.out.println("Binary search char index range: " + charIndexRange); // 2
        System.out.println("Binary search double index range: " + doubleIndexRange); // 2
        System.out.println("Binary search float index range: " + floatIndexRange); // 2
        System.out.println("Binary search int index range: " + intIndexRange); // 2
        System.out.println("Binary search long index range: " + longIndexRange); // 2
        System.out.println("Binary search short index range: " + shortIndexRange); // 2
        System.out.println(" ");
        System.out.println("Index comparator result");
        System.out.println("Binary search string index: " + stringIndex); // 2
        System.out.println(" ");
        System.out.println("Index range comparator result");
        System.out.println("Binary search string index range: " + stringIndexRange); // 2
    }


    // Задание 1
    public static int binarySearch(byte[] a, byte key) {
        if (a == null || a.length == 0) {
            return -1; // Обработка пустого или null массива
        }

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Более устойчивый к переполнению вариант
            int cmp = Byte.compare(a[mid], key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Значение найдено
            }
        }
        return -1; // Значение не найдено
    }

    // Задание 2
    public static int binarySearch(byte[] a, int fromIndex, int toIndex, byte key) {
        // Проверка входных данных
        if (a == null || fromIndex < 0 || toIndex > a.length || fromIndex > toIndex) {
            throw new IllegalArgumentException("Неверные входные данные");
        }

        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины
            int cmp = Byte.compare(a[mid], key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Элемент найден
            }
        }
        return -(low + 1); // Элемент не найден (инвертированный индекс вставки)
    }

    // Задание 3
    public static int binarySearch(char[] a, char key) {
        if (a == null || a.length == 0) {
            return -1; // Обработка пустого или null массива
        }

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины
            int cmp = Character.compare(a[mid], key); // Используем Character.compare для сравнения char

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

    // Задание 4
    public static int binarySearch(char[] a, int fromIndex, int toIndex, char key) {
        // Проверка входных данных
        if (a == null || fromIndex < 0 || toIndex > a.length || fromIndex > toIndex) {
            throw new IllegalArgumentException("Неверные входные данные");
        }

        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины
            int cmp = Character.compare(a[mid], key); // Используем Character.compare для сравнения char

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Элемент найден
            }
        }
        return -(low + 1); // Элемент не найден (инвертированный индекс вставки)
    }

    // Задание 5
    public static int binarySearch(double[] a, double key) {
        if (a == null || a.length == 0) {
            return -1; // Обработка пустого или null массива
        }

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины

            // Используем Double.compare для корректного сравнения double
            int cmp = Double.compare(a[mid], key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Значение найдено
            }
        }
        return -1; // Значение не найдено
    }

    // Задание 6
    public static int binarySearch(double[] a, int fromIndex, int toIndex, double key) {
        // Проверка входных данных
        if (a == null || fromIndex < 0 || toIndex > a.length || fromIndex > toIndex) {
            throw new IllegalArgumentException("Неверные входные данные");
        }

        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины
            int cmp = Double.compare(a[mid], key); // Используем Double.compare для сравнения double

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Элемент найден
            }
        }
        return -(low + 1); // Элемент не найден (инвертированный индекс вставки)
    }

    // Задание 7
    public static int binarySearch(float[] a, float key) {
        if (a == null || a.length == 0) {
            return -1; // Обработка пустого или null массива
        }

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины

            // Используем Float.compare для корректного сравнения float
            int cmp = Float.compare(a[mid], key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Значение найдено
            }
        }
        return -1; // Значение не найдено
    }

    // Задание 8
    public static int binarySearch(float[] a, int fromIndex, int toIndex, float key) {
        // Проверка входных данных
        if (a == null || fromIndex < 0 || toIndex > a.length || fromIndex > toIndex) {
            throw new IllegalArgumentException("Неверные входные данные");
        }

        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины
            int cmp = Float.compare(a[mid], key); // Используем Float.compare для сравнения float

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Элемент найден
            }
        }
        return -(low + 1); // Элемент не найден (инвертированный индекс вставки)
    }

    // Задание 9
    public static int binarySearch(int[] a, int key) {
        if (a == null || a.length == 0) {
            return -1; // Обработка пустого или null массива
        }

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины

            if (a[mid] < key) {
                low = mid + 1;
            } else if (a[mid] > key) {
                high = mid - 1;
            } else {
                return mid; // Значение найдено
            }
        }
        return -1; // Значение не найдено
    }

    // Задание 10
    public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        // Проверка на корректность входных данных
        if (a == null || fromIndex < 0 || toIndex > a.length || fromIndex > toIndex) {
            throw new IllegalArgumentException("Некорректные входные данные");
        }

        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины

            if (a[mid] < key) {
                low = mid + 1;
            } else if (a[mid] > key) {
                high = mid - 1;
            } else {
                return mid; // Элемент найден
            }
        }
        return -(low + 1); // Элемент не найден (инвертированный индекс вставки)
    }

    // Задание 11
    public static int binarySearch(long[] a, long key) {
        if (a == null || a.length == 0) {
            return -1; // Обработка пустого или null массива
        }

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины

            if (a[mid] < key) {
                low = mid + 1;
            } else if (a[mid] > key) {
                high = mid - 1;
            } else {
                return mid; // Значение найдено
            }
        }
        return -1; // Значение не найдено
    }

    // Задание 12
    public static int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
        // Проверка входных данных
        if (a == null || fromIndex < 0 || toIndex > a.length || fromIndex > toIndex) {
            throw new IllegalArgumentException("Неверные входные данные");
        }

        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины

            if (a[mid] < key) {
                low = mid + 1;
            } else if (a[mid] > key) {
                high = mid - 1;
            } else {
                return mid; // Элемент найден
            }
        }
        return -(low + 1); // Элемент не найден (инвертированный индекс вставки)
    }

    // Задание 13
    public static int binarySearch(short[] a, short key) {
        if (a == null || a.length == 0) {
            return -1; // Обработка пустого или null массива
        }

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины

            if (a[mid] < key) {
                low = mid + 1;
            } else if (a[mid] > key) {
                high = mid - 1;
            } else {
                return mid; // Значение найдено
            }
        }
        return -1; // Значение не найдено
    }

    // Задание 14
    public static int binarySearch(short[] a, int fromIndex, int toIndex, short key) {
        // Проверка входных данных
        if (a == null || fromIndex < 0 || toIndex > a.length || fromIndex > toIndex) {
            throw new IllegalArgumentException("Неверные входные данные");
        }

        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины

            if (a[mid] < key) {
                low = mid + 1;
            } else if (a[mid] > key) {
                high = mid - 1;
            } else {
                return mid; // Элемент найден
            }
        }
        return -(low + 1); // Элемент не найден (инвертированный индекс вставки)
    }

    // Задание 15
    public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c) {
        if (a == null || a.length == 0) {
            return -1; // Обработка пустого или null массива
        }

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины

            // Используем компаратор для сравнения элементов
            int cmp = c.compare(a[mid], key);

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

    // Задание 16
    public static <T> int binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
        // Проверка входных данных
        if (a == null || fromIndex < 0 || toIndex > a.length || fromIndex > toIndex) {
            throw new IllegalArgumentException("Неверные входные данные: fromIndex=" + fromIndex + ", toIndex=" + toIndex + ", array length=" + (a == null ? 0 : a.length));
        }

        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1); // Устойчивое к переполнению вычисление середины

            // Используем компаратор для сравнения элементов
            int cmp = c.compare(a[mid], key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Элемент найден
            }
        }
        return -(low + 1); // Элемент не найден (инвертированный индекс вставки)
    }
}
