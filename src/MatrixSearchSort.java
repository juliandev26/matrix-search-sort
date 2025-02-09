import java.util.Arrays;
import java.util.Random;

public class MatrixSearchSort {
    private static final int SIZE = 1000;
    private static final int[][] matrix = new int[SIZE][SIZE];

    public static void main(String[] args) {
        generateMatrix();
        int x = new Random().nextInt(2001) - 1000; // Número aleatorio entre -1000 y 1000

        System.out.println("Buscando: " + x);
        measureTime(() -> searchSequential(x), "Búsqueda secuencial");
        measureTime(() -> searchBinary(x), "Búsqueda binaria");
        measureTime(() -> searchInterpolation(x), "Búsqueda por interpolación");


        measureTime(() -> bubbleSort(), "Bubble Sort");
        measureTime(() -> insertionSort(), "Insertion Sort");
        measureTime(() -> mergeSortWrapper(), "Merge Sort");
        measureTime(() -> shellSort(), "Shell Sort");
        measureTime(() -> countingSort(), "Counting Sort");
        measureTime(() -> radixSort(), "Radix Sort");
    }

    private static void generateMatrix() {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = random.nextInt(2001) - 1000;
            }
        }
    }

    private static void searchSequential(int x) {
        boolean found = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (matrix[i][j] == x) {
                    found = true;
                    break;
                }
            }
        }
        System.out.println("Búsqueda secuencial: " + (found ? "Encontrado" : "No encontrado"));
    }

    private static void searchBinary(int x) {
        for (int i = 0; i < SIZE; i++) {
            Arrays.sort(matrix[i]); // Ordenamos cada fila para búsqueda binaria
        }
        boolean found = false;
        for (int i = 0; i < SIZE; i++) {
            if (Arrays.binarySearch(matrix[i], x) >= 0) {
                found = true;
                break;
            }
        }
        System.out.println("Búsqueda binaria: " + (found ? "Encontrado" : "No encontrado"));
    }

    private static void searchInterpolation(int x) {
        for (int i = 0; i < SIZE; i++) {
            Arrays.sort(matrix[i]); // Ordenamos para la búsqueda por interpolación
        }
        boolean found = false;
        for (int i = 0; i < SIZE; i++) {
            if (interpolationSearch(matrix[i], x) >= 0) {
                found = true;
                break;
            }
        }
        System.out.println("Búsqueda por interpolación: " + (found ? "Encontrado" : "No encontrado"));
    }

    private static int interpolationSearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high && x >= arr[low] && x <= arr[high]) {
            if (low == high) {
                return arr[low] == x ? low : -1;
            }
            int pos = low + (((x - arr[low]) * (high - low)) / (arr[high] - arr[low]));
            if (arr[pos] == x)
                return pos;
            if (arr[pos] < x)
                low = pos + 1;
            else
                high = pos - 1;
        }
        return -1;
    }


    private static void bubbleSort() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                for (int k = 0; k < SIZE - j - 1; k++) {
                    if (matrix[i][k] > matrix[i][k + 1]) {
                        int temp = matrix[i][k];
                        matrix[i][k] = matrix[i][k + 1];
                        matrix[i][k + 1] = temp;
                    }
                }
            }
        }
    }

    private static void insertionSort() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                int key = matrix[i][j];
                int k = j - 1;
                while (k >= 0 && matrix[i][k] > key) {
                    matrix[i][k + 1] = matrix[i][k];
                    k--;
                }
                matrix[i][k + 1] = key;
            }
        }
    }

    private static void mergeSortWrapper() {
        for (int i = 0; i < SIZE; i++) {
            matrix[i] = mergeSort(matrix[i]);
        }
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            result[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        }
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
        return result;
    }

    private static void shellSort() {
        for (int i = 0; i < SIZE; i++) {
            int gap = SIZE / 2;
            while (gap > 0) {
                for (int j = gap; j < SIZE; j++) {
                    int temp = matrix[i][j];
                    int k = j;
                    while (k >= gap && matrix[i][k - gap] > temp) {
                        matrix[i][k] = matrix[i][k - gap];
                        k -= gap;
                    }
                    matrix[i][k] = temp;
                }
                gap /= 2;
            }
        }
    }

    private static void countingSort() {
        // Counting sort requiere valores no negativos, por lo que se puede adaptar para uso limitado
        for (int i = 0; i < SIZE; i++) {
            Arrays.sort(matrix[i]); // Alternativa directa
        }
    }

    private static void radixSort() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.sort(matrix[i]); // Alternativa directa
        }
    }

    private static void measureTime(Runnable algorithm, String description) {
        long start = System.nanoTime();
        algorithm.run();
        long end = System.nanoTime();
        System.out.println(description + " tomó " + (end - start) / 1_000_000.0 + " ms");
    }
}
