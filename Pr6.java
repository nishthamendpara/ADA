import java.util.*;

public class Search {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int key = 8;

        int linear = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                linear = i;
                break;
            }
        }

        int low = 0, high = arr.length - 1, binary = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                binary = mid;
                break;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Linear Search Position: " + linear);
        System.out.println("Binary Search Position: " + binary);
    }
}
