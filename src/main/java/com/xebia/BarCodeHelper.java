package com.xebia;

class BarCodeHelper {
     static String scanBarCode(String barcode) {
        char[] chars = barcode.toCharArray();
        int sum =0;
        for(char c :chars){
            sum += Integer.parseInt(String.valueOf(c));
        }
        return String.valueOf(sum);
    }
}
