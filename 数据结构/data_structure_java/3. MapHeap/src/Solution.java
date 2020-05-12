

import java.util.*;
import java.util.PriorityQueue;
import java.util.Comparator;


class Solution {

    private class Freq implements Comparable<Freq>{
        int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another){
            if(this.freq < another.freq)
                return -1;
            else if (this.freq > another.freq)
                return 1;
            else
                return 0;
        }
    }

    //比较器
    private class FreqComparator implements Comparator<Freq>{

        @Override
        public int compare(Freq a, Freq b){
            return a.freq - b.freq;
        }
    }

    //匿名类
    PriorityQueue<Freq> pq = new PriorityQueue<>(new Comparator<Freq>() {
        @Override
        public int compare(Freq a, Freq b) {
            return a.freq - b.freq;
        }
    })

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<Freq>();
        for(int key: map.keySet()){
            if(pq.size() < k)
                pq.add(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.peek().freq){
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty())
            res.add(pq.remove().e);
        return res;
    }
}
