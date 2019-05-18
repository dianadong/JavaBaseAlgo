package algo.search;

public class SelectTopN {
    public static final int ARRAY_SIZE = 5;

    public static void main(String[] args) {
        SelectTopN algo = new SelectTopN();
        int[] array = {20, 2, 5, 10, 15, 78, 98, 45, 8, 30, 25, 18};
//        初始化topN数组
        if (ARRAY_SIZE >= array.length) {
            System.out.println(arrayToString(array));
        } else {
            int[] targetArray = algo.initArrayN(array, ARRAY_SIZE);
            algo.arrayToHeap(targetArray);
            for (int i = ARRAY_SIZE; i < array.length; i++) {
                if (array[i] < targetArray[0]) {
                    continue;
                }
                targetArray[0] = array[i];
                algo.arrayToHeap(targetArray);
            }
            System.out.println(arrayToString(targetArray));
        }
    }

    int[] initArrayN(int[] array, int N) {
        int[] outputArray = new int[N];
        for (int i = 0; i < N; i++) {
            outputArray[i] = array[i];
        }
        return outputArray;
    }

    void arrayToHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapAdjust(array, i);
        }
    }

    void heapAdjust(int[] array, int parent) {
        int temp = array[parent];
        for (int child = 2 * parent + 1; child < array.length; child = 2 * child + 1) {
            if (child + 1 < array.length && array[child] > array[child + 1]) {
                child++;
            }
            if (temp > array[child]) {
                array[parent] = array[child];
                parent = child;
            }else {
                break;
            }
        }
        array[parent] = temp;
    }

    public static String arrayToString(int[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(",");
        }
        return sb.toString();
    }
}
