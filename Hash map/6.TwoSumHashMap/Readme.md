# Two Sum


Given an array of integers `nums` and an integer `target`, return *indices of the two numbers such that they add up to `target`* .

You may assume that each input would have ***exactly* one solution** , and you may not use the *same* element twice.

You can return the answer in any order.


~~~java

~~~

~~~java
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                res[0] = i;
                res[1] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
~~~
