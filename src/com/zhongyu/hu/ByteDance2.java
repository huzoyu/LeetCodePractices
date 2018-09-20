package com.zhongyu.hu;

import java.util.Scanner;

public class ByteDance2 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int MAX = scanner.nextInt();
        String[] strs = new String[MAX];
        String[] result = new String[MAX];
        for (int i = 0; i < MAX; i++) {
            strs[i] = scanner.nextLine();
        }


        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (j == i) continue;
                for (int k = 0; k < strs[i].length(); k++) {

                }
            }
        }
    }
}
