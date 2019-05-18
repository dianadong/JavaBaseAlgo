package algo.sort;

//快速排序，找基准点，每次确定基准值得最终位置，再依次遍历两侧的数组，时间复杂度O(NlogN)
public class QuickSort {

    public static void sort1(int[] array, int low, int high) {
        int start = low;
        int end = high;
        int key = array[low];
        while (start < end) {
            while (start < end && array[end] >= key) {
                end--;
            }
            if (array[end] < key) {
                array[start] = array[end];
            }
            while (start < end && array[start] <= key) {
                start++;
            }
            if (array[start] > key) {
                array[end] = array[start];
            }
        }
        array[start] = key;
        if (low < start - 1) {
            sort1(array, low, start - 1);
        }
        if (start + 1 < high) {
            sort1(array, start + 1, high);
        }
    }

    public static void sort2(int[] array, int low, int high) {
        if (low < high) {
            int mid = getMiddle(array, low, high);
            sort2(array, low, mid - 1);
            sort2(array, mid + 1, high);
        }
    }

    public static int getMiddle(int[] array, int low, int high) {
        int key = array[low];
        while (low < high) {
            while (low < high && array[high] >= key) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= key) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = key;
        return low;
    }


    public static void main(String[] args) {
        int[] array1 = {12, 2, 3, 4, 4, 8, 90, 57};
        sort1(array1, 0, array1.length - 1);
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < array1.length; i++) {
            sb1.append(String.valueOf(array1[i]) + " ");
        }
        System.out.println(sb1.toString());

        int[] array2 = {12, 2, 3, 4, 4, 8, 90, 57};
        sort2(array2, 0, array2.length - 1);
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < array2.length; i++) {
            sb2.append(String.valueOf(array1[i]) + " ");
        }
        System.out.println(sb2.toString());
    }

}
