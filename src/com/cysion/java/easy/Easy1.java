package com.cysion.java.easy;

/**
 * by cysion 2018.4.2
 * //1. A + B 问题
 * //2. 尾部的零
 * //6. 合并排序数组 II
 * //13.字符串查找
 * //14.二分查找
 */
public class Easy1 {

    //1. A + B 问题
    public int aplusb(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        int x = a ^ b;
        int y = (a & b) << 1;
        return aplusb(x, y);
    }

    public void testAPlusB() {
        System.out.println("19+24=" + aplusb(19, 24));
        System.out.println("129+524=" + aplusb(129, 524));
    }

    //2. 尾部的零
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long c = 0;
        while (n / 5 > 0) {
            c = c + n / 5;
            n = n / 5;
            ;
        }
        return c;
    }

    public void testEnd0() {
        System.out.println(trailingZeros(11));
        System.out.println(trailingZeros(131));
        System.out.println(trailingZeros(55));
    }

    //6. 合并排序数组 II
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int a = 0;
        int b = 0;
        int[] r = new int[A.length + B.length];
        while (a < A.length && b < B.length) {
            if (A[a] <= B[b]) {
                r[a + b] = A[a];
                a++;
            } else {
                r[a + b] = B[b];
                b++;
            }
        }
        if (a == A.length) {
            for (int i = b; i < B.length; i++) {
                r[a + i] = B[i];
            }
        } else if (b == B.length) {
            for (int i = a; i < A.length; i++) {
                r[b + i] = A[i];
            }
        }
        return r;
    }

    public void testMergeSorted() {
        int[] A = {1,5};
        int[] B = {2,3};
        for (int i : mergeSortedArray(A, B)) {
            System.out.println("" + i);
        }
    }

    //8. 旋转字符串,这种方式多占内存；还有循环一个个的旋转，
    public void rotateString(char[] str, int offset) {
        // write your code here
        int n = str.length;
        if(n==0){
            return;
        }
        offset = offset%n;
        char[] tmp = new char[offset];
        for(int i=n-offset;i<n;i++){
            tmp[i+offset-n] = str[i];
        }
        for(int i=n-offset-1;i>-1;i--){
            str[i+offset] = str[i];
        }
        for(int i = 0;i<offset;i++){
            str[i] = tmp[i];
        }
    }

    public void testRotate(){
        char[] t = {'d','p','o','g','e','w'};
        rotateString(t,2);
        for (char c : t) {
            System.out.print(c);
        }
        System.out.println();
        System.out.println("--");
        char[] t2 = {'d','p','o','g','e','w'};
        rotateString(t2,4);
        for (char c : t2) {
            System.out.print(c);
        }
    }

    //13. 字符串查找
    public int strStr(String source, String target) {
        // write your code here
        if(source==null||target==null){
            return -1;
        }
        int m = source.length();
        int n = target.length();
        if(m<n){
            return -1;
        }
        if(m==0&&n==0){
            return 0;
        }
        for(int i=0;i<m;i++){
            boolean found = true;
            int t = i;
            for(int j=0;j<n;j++){
                if(t<m&&source.charAt(t)==target.charAt(j)){
                    t++;
                }else{
                    found = false;
                    break;
                }
            }
            if(found){
                return i;
            }
        }
        return -1;
    }

    public void testStr(){
        System.out.println("a$$"+strStr("source","rced"));
        System.out.println("a$$"+strStr("tartarget","target"));
        System.out.println("a$$"+strStr("sdffsdessa","ssa"));
    }

    //14.二分查找
    public int binarySearch(int[] nums, int target) {
        // write your code here
        int n = nums.length-1;
        if(n==0){
            return -1;
        }
        int low = 0;
        int mid = (n-low)/2;
        if(nums[low]>target){
            return -1;
        }
        if(nums[n]<target){
            return -1;
        }
        while(mid!=low&&mid!=n){

            if(nums[mid] > target){
                n=mid;
                mid = (n+low)/2;
            }else if(nums[mid] < target){
                low = mid;
                mid = (n+low)/2;
            }else{
                int k=0;
                for(int i=mid;i>=1;i--){
                    if(nums[i-1]!=target){
                        return i++;
                    }
                    k = i;
                }
                mid = k;

            }
        }
        if(nums[mid] == target){
            return mid;
        }
        return -1;
    }

    public void testBineary(){
        int[] A = {1, 2, 3, 3, 4, 5,8,9, 10,13,16};
        System.out.println(binarySearch(A,10));
    }
}
