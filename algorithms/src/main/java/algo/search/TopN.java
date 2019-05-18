package algo.search;

import java.util.Random;

public class TopN {


    public static void main(String[] args) {
        int [] array ={20, 2, 5, 10, 15, 78, 98, 45, 8, 30, 25, 18};
//        Random r = new Random();
//        for (int i = 0; i < array.length; i++) {
//            array[i] = r.nextInt(100);
//        }
        System.out.println(arrayToString(array));
        int [] result = new int [4];
        for (int i = 0; i < 4; i++) {
            result[i]=array[i];
        }
        arrayToHeap(result);
        System.out.println(result[0]);
        for (int i = 4; i <array.length ; i++) {
            if(array[i]>result[0]){
                result[0]=array[i];
                arrayToHeap(result);
            }
        }
        System.out.println(arrayToString(result)); ;

    }


    public static String arrayToString(int [] array){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(",");
        }
        return sb.toString();
    }

    public static void arrayToHeap(int [] result){
        for (int i = result.length / 2-1; i >= 0; i--) {
            heapAdjust(result, i, result.length);
        }

    }

    /**
     * 设当前元素在数组中以R[i]表示，那么，
     * <p>
     * (1) 它的左孩子结点是：R[2*i+1];
     * <p>
     * (2) 它的右孩子结点是：R[2*i+2];
     * <p>
     * (3) 它的父结点是：R[(i-1)/2];

     */
    public static void heapAdjust(int[] data, int parent, int length) {
        int temp = data[parent];
        int child ;
        for(child=2*parent+1;child<length;child=2*child+1){
            if(child+1<length&&data[child]>data[child+1]){
                child++;
            }

            if(temp<=data[child]){
                break;
            }else{
                data[parent]=data[child];
                parent = child;
            }
        }
        data[parent]=temp;
    }
}
