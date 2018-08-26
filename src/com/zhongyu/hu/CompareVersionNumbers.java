package com.zhongyu.hu;

/**
 *
 * 165.Compare Version Numbers
 *
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth
 * second-level revision of the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 *
 * 0.1 < 1.1 < 1.2 < 13.37
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");
        int len1 = parts1.length;
        int len2 = parts2.length;
        int i = 0;
        for(; i < len1 && i < len2; i ++){
            if(Integer.valueOf(parts1[i]) > Integer.valueOf(parts2[i])) return 1;
            if(Integer.valueOf(parts2[i]) > Integer.valueOf(parts1[i])) return -1;
        }
        if(len1 > len2){
            while(i < len1){
                if(Integer.valueOf(parts1[i++]) != 0) return 1;
            }
        }else if(len1 < len2){
            while(i < len2){
                if(Integer.valueOf(parts2[i++]) != 0) return -1;
            }
        }
        return 0;
    }
}
