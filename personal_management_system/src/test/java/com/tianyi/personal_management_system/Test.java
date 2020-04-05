package com.tianyi.personal_management_system;

/**
 * @author chengang
 * @version 1.0
 * @date 2020/4/3 9:32
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.twoSum(new int[]{2, 7, 11, 15},9);
    }
    public int[] twoSum(int[] nums, int target) {
        int i,j=0;
        //思路类似冒泡排序
        for( i=0;i<nums.length-1;i++){
            for( j=i+1;i<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    break;
                }
            }
        }
        int[] result=new int[]{i,j};
        return  result;
    }
}
