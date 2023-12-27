package com.zhc.week1;

import controller.Active;
import model.config.ValidatorConfig;
import model.range.Range;
import model.sample.Argument;
import model.util.type.IntegerPlus;

import java.util.Arrays;

public class LeetCode283移动零 {
    public IntegerPlus[] validator_moveZeroes(IntegerPlus[] nums) {
        int l = -1, r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[r].value == 0) {
                r++;
            } else {
                // 交换 l + 1 和 r 位置
                IntegerPlus t = nums[l + 1];
                nums[l + 1] = nums[r];
                nums[r] = t;
                l++;
                r++;
            }
        }
        return nums;
    }

    public IntegerPlus[] compare_moveZeros(IntegerPlus[] nums) {

        IntegerPlus[] arr = new IntegerPlus[nums.length];
        Arrays.fill(arr, new IntegerPlus(0));
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].value != 0) {
                arr[cur++] = nums[i];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ValidatorConfig config = new ValidatorConfig(
                1_00,
                LeetCode283移动零.class,
                "validator_moveZeroes",
                "compare_moveZeros"
        );

        Argument argument = new Argument(
                new Range[]{
                        new Range(1, 10_0000),
                        new Range(-1, -1)
                },

                // 调小数值范围,便于较多的出现0
                new Range[]{
                        new Range(-1, -1),
                        new Range(-10, 10)
                }
        );

        new Active().active(config, argument);
    }


}
