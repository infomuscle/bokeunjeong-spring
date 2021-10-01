package com.bokeunjeong.portfolio.study;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

@Slf4j
@ActiveProfiles("test")
public class CombinationTest {

    @Test
    public void combinationTest() {

        Combination comb1 = new Combination(new int[]{1, 2, 3, 4, 5}, 2);
        log.info("size: {}", comb1.getCombinations().size());
        for (ArrayList<Integer> c : comb1.getCombinations()) {
            log.info(c.toString());
        }

    }

    class Combination {

        private int n;
        private int r;
        private int[] now;
        private ArrayList<ArrayList<Integer>> combinations;

        public ArrayList<ArrayList<Integer>> getCombinations() {
            return combinations;
        }

        public Combination(int[] arr, int r) {
            this.n = arr.length;
            this.r = r;
            this.now = new int[r];
            this.combinations = new ArrayList<ArrayList<Integer>>();
            combination(arr, 0, 0, 0);
        }

        public void combination(int[] arr, int depth, int index, int target) {
            if (depth == r) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = 0; i < now.length; i++) {
                    temp.add(arr[now[i]]);
                }
                combinations.add(temp);
                return;
            }
            if (target == n) return;
            now[index] = target;
            combination(arr, depth + 1, index + 1, target + 1);
            combination(arr, depth, index, target + 1);
        }
    }

}
