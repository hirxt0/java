package practice3;

import java.util.ArrayList;
import java.util.HashSet;

public class Task3 {
    public static void main(String[] args) {
        
    }

    public static ArrayList<Integer> Task3_1(int k, int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = k - 1; i < arr.length; i += k) {
            result.add(arr[i]);
        }
        return result; 
    }

    public static int Task3_2(int[] nums) {
        HashSet<Integer> setNums = new HashSet<>();

        for (int x : nums) {
            setNums.add(x);
        }

        return setNums.size();
    }

    public static void Task3_3(int[] nums1, ArrayList<Integer> nums2) {
        for (int i = 1; i < nums1.length; i+=2) {
            nums2.add(nums1[i]);
        }
        for (int i = 0; i < nums1.length; i+=2) {
            nums2.add(nums1[i]);
        }    
    }
    
    public static int[][] Task3_4(int M, int K) {
        int [][] m = new int[M][K];
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < K; y++) {
                m[x][y] = (x+1)*10;
            }
        }
        return m;
    }
}
