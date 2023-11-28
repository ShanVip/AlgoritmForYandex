package com.Bricks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static List<List<Integer>> findCombination(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start, int target, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] <= target) {
                path.add(nums[i]);
                backtrack(nums, i + 1, target - nums[i], path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            int target = scanner.nextInt();
            int n = scanner.nextInt();
            int[] nums = new int[2 * n];

            for (int i = 0; i < n * 2; i += 2) {
                int x = scanner.nextInt();
                nums[i] = x;
                nums[i + 1] = x;
            }

            List<List<Integer>> result = findCombination(nums, target);

            if (!result.isEmpty()) {
                List<Integer> r = result.stream()
                        .min(Comparator.comparingInt(List::size))
                        .orElseThrow();

                r.sort(Collections.reverseOrder());

                System.out.println(r.size());
                System.out.println(String.join(" ", r.stream().map(String::valueOf).toArray(String[]::new)));
            } else {
                if (sum(nums) > target) {
                    System.out.println(0);
                } else {
                    System.out.println(-1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int sum(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total;
    }
}



