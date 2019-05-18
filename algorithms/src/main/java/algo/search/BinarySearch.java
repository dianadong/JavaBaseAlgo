package algo.search;

//前提是必须排好序的数组,时间复杂度最好O(1),最差O(logN)



public class BinarySearch {
    //    不使用递归
    public static boolean search1(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        if (array.length == 0 || key < array[0] || key > array[high] || low > high) {
            return false;
        }

        int mid = (high + low) / 2;

        while (high >= low) {
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                return true;
            }
            mid = (high + low) / 2;
        }
        return false;
    }

    //    使用递归
    public static boolean search2(int[] array, int key, int low, int high) {
        if (low > high || array[low] > key || array[high] < key) {
            return false;
        }
        int mid = (high + low) / 2;
        if (key < array[mid]) {
            return search2(array, key, low, mid - 1);
        } else if (key > array[mid]) {
            return search2(array, key, mid + 1, high);
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int key = 0;
        System.out.println(search2(array, key,0,array.length-1));
    }
}
