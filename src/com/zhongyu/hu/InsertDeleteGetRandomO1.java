package com.zhongyu.hu;

import java.util.HashMap;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)
 *
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must
 * have the same probability of being returned.
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */

public class InsertDeleteGetRandomO1 {

    HashMap<Integer, Integer> map1;
    HashMap<Integer, Integer> map2;
    Random rand;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        map1  = new HashMap<Integer, Integer>();
        map2  = new HashMap<Integer, Integer>();
        rand = new Random(System.currentTimeMillis());
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map1.containsKey(val)){
            return false;
        }else{
            map1.put(val, map1.size());
            map2.put(map2.size(), val);
        }
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map1.containsKey(val)){
            int index = map1.get(val);

            //remove the entry from both maps
            map1.remove(val);
            map2.remove(index);

            if(map1.size()==0){
                return true;
            }

            //if last is deleted, do nothing
            if(index==map1.size()){
                return true;
            }

            //update the last element's index
            int key1 = map2.get(map2.size());

            map1.put(key1, index);
            map2.remove(map2.size());
            map2.put(index, key1);

        }else{
            return false;
        }

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(map1.size()==0){
            return -1;
        }

        if(map1.size()==1){
            return map2.get(0);
        }

        return map2.get(new Random().nextInt(map1.size()));
        //return 0;
    }


}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
