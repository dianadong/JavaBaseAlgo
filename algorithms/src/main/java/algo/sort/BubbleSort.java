package algo.sort;

//冒泡排序，每次遍历最大的泡排在最后，最差时间复杂度O(N*N),最好时间复杂度O(1),空间复杂度O(1)
public class BubbleSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {10, 2, 4, 4, 6, 89, 56};
        sort(array);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
