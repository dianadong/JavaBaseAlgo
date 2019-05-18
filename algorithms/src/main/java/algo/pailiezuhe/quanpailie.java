package algo.pailiezuhe;

import java.util.ArrayList;
import java.util.List;

public class quanpailie {
    public static ArrayList<String> resultList = new ArrayList<>();
    /**
     * 思路：
     * 递归，第一层把循环把n个数中的第i个装入结果的第一个位置
     *       把剩下的n-2个数循环装入第二个位置
     *       把剩下的n-3个数循环装入第三个位置
     *       .....
     *       直到最后一个数，返回
     * 注意：下到下一层的时候注意new新的list不然，原来的list也会被改变
     *       其次：
     *       在递归返回的时候应该把记录的data最后一个去掉，否则前面的结果会
     *       影响循环过程。
     * @param arrayList
     * @param data
     * @param arrayListData
     */
    private static void getData(ArrayList<Integer> arrayList , StringBuilder data){
        for (int i = 0; i < arrayList.size(); i++) {
            data.append(arrayList.get(i));
            ArrayList<Integer> newArrayList = new ArrayList<>(arrayList);
            newArrayList.remove(i);
            getData(newArrayList,data);
        }
        if (arrayList.size()==0)
        {
            resultList.add(data.toString());
        }
        if (data.length()!=0){
            data.deleteCharAt(data.length()-1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        StringBuilder data = new StringBuilder();
        getData(arrayList,data);
        System.out.println(resultList.size());

    }
}
