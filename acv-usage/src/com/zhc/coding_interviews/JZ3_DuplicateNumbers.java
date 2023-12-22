package com.zhc.coding_interviews;


import controller.Active;
import model.config.ValidatorConfig;
import model.range.Range;
import model.sample.Argument;
import model.util.type.IntegerPlus;

import java.util.HashMap;
import java.util.Map;

public class JZ3_DuplicateNumbers {

    /**
     * O(n) 时间复杂度 成功AC
     *
     * @param numbers
     * @return
     */
    public IntegerPlus validator_duplicate(IntegerPlus[] numbers) {
        // 1. 维护一张哈希表
        // <number,times>
        Map<IntegerPlus, Integer> map = new HashMap<>();
        for (IntegerPlus n : numbers) {
            // 如果n以经在哈希表中存在,表明n是第二次出现,直接返回,返回第一个重复的元素(稳定性)
            if (map.containsKey(n)) {
                return n;
            } else {
                map.put(n, 1);
            }
        }
        return new IntegerPlus(-1);
    }

    /**
     * 暴力O(n^2) 无法AC 但是正确
     *
     * @param numbers
     * @return
     */
    public IntegerPlus compare_duplicate(IntegerPlus[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j && numbers[i] == numbers[j]) {
                    return numbers[j];
                }
            }
        }
        return new IntegerPlus(-1);
    }

    /**
     * acv
     *
     * @param args
     */
    public static void main(String[] args) {
        ValidatorConfig config = new ValidatorConfig(
                1000,
                JZ3_DuplicateNumbers.class,
                "validator_duplicate",
                "compare_duplicate"
        );

        Argument argument = new Argument(
                new Range[]{
                        new Range(0, 10000),// 数组大小 [0,10000]
                        new Range(-1, -1) // 叶子结点 size = 1
                },
                new Range[]{
                        new Range(-1, -1),// 数组不需要数值范围
                        new Range(0, 9999)
                }
        );

        new Active().active(config, argument);
    }
}
