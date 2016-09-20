package com.xebia;

/**
 * Created by mthakur on 20/09/16.
 */
public class BarCodeHelper {
    public static String scanBarCode(String barcode) {
        char[] chars = barcode.toCharArray();
        int sum =0;
        for(char c :chars){
            sum += Integer.parseInt(String.valueOf(c));
        }
        return String.valueOf(sum);
    }
}
