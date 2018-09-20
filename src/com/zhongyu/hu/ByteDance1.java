package com.zhongyu.hu;

import java.util.Scanner;

public class ByteDance1 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(path);
        int index = stringBuffer.lastIndexOf("/");
        if (index == (stringBuffer.length() - 1)){
            stringBuffer.setLength(stringBuffer.length()-1);
            index = stringBuffer.lastIndexOf("/");
        }
        System.out.println(stringBuffer.substring(index));
    }

}
