/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechosenone;

/**
 *
 * @author Butalo
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 1) {
            System.out.println(in.nextLong()+1);
        } else {
            long[] a = new long[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextLong();
            }
            // your code goes here

            for (int i = 0; i < a.length; i++) {
                long gcd_presuf = 1;
                if (i == 0) {
                    gcd_presuf = suf(i + 1, a);
                } else if (i == a.length - 1) {
                    gcd_presuf = pre(i - 1, a);
                } else {
                    gcd_presuf = gcd(pre(i - 1, a),(suf(i + 1, a)));

                }
                if ((a[i] % (gcd_presuf)) != 0) {
                    System.out.println(gcd_presuf);
                    break;
                }
            }
        }
    }

    public static long gcd(long a, long b) {
        if (a < b) {
            long t = b;
            b = a;
            a = t;
        }
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static long pre(int i, long[] arr) {
//        if (i == 0) {
//            return arr[0];
//        } else {
        long rs = arr[0];
        for (int j = 1; j <= i; j++) {
            rs = gcd(rs, arr[j]);
        }
        return rs;
//        }
    }

    public static long suf(int i, long[] arr) {
//        if (i == arr.length - 1) {
//            return arr[i];
//        } else {
        long rs = arr[i];
        for (int j = i + 1; j <= arr.length - 1; j++) {
            rs = gcd(rs, arr[j]);
        }
        return rs;
//        }
    }
}
