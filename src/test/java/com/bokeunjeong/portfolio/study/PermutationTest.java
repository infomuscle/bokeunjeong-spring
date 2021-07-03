package com.bokeunjeong.portfolio.study;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

@Slf4j
public class PermutationTest {


    @Test
    public void permutationTest() {

        Permutation perm1 = new Permutation(new int[]{5, 3, 2, 1, 4}, 2);

        log.info("size: {}", perm1.getPermuations().size());
        for (ArrayList<Integer> p : perm1.getPermuations()) {
            log.info(p.toString());
        }

    }

    class Permutation {
        private int n;
        private int r;
        private int[] now;
        private ArrayList<ArrayList<Integer>> permuations;


        public Permutation(int[] arr, int r) {
            this.n = arr.length;
            this.r = r;
            this.now = new int[r];
            this.permuations = new ArrayList<ArrayList<Integer>>();
            permutation(arr, 0);
        }

        private void permutation(int[] arr, int depth) {
            if (depth == r) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = 0; i < now.length; i++) {
                    temp.add(now[i]);
                }
                this.permuations.add(temp);
                return;
            }
            for (int i = depth; i < n; i++) {
                swap(arr, i, depth);
                now[depth] = arr[depth];
                permutation(arr, depth + 1);
                swap(arr, i, depth);
            }
        }

        public ArrayList<ArrayList<Integer>> getPermuations() {
            return this.permuations;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
