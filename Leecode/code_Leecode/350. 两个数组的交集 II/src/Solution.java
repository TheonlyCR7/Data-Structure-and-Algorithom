import java.util.ArrayList;
import java.util.TreeMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        //在数组中的元素， 出现的频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums1){
            //containKey 是否包含键
            if(!map.containsKey(num))
                //添加元素
                map.put(num, 1);
            else
                //增加频次
                map.put(num, map.get(num) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)) {
                //存在即存储在list中
                list.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0)
                    map.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i ++)
            res[i] = list.get(i);
        return res;
    }
}
