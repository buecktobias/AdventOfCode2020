package aoc.tasks.task14;

import java.util.Arrays;

public class Binary {

    public static long binaryToDecimal(char[] binary){
        return Long.valueOf(new String(binary), 2);
    }

    public static char[] decimalToBinary(int number){
        return Integer.toBinaryString(number).toCharArray();
    }

    public static char[] to36Bit(int number){
        char[] binary36Bit = new char[36];
        char[] binary = decimalToBinary(number);
        int zeroUntil = 36 - binary.length;
        for(int i = 0; i < zeroUntil; i++){
            binary36Bit[i] = '0';
        }
        for(int i = 0; i < binary.length; i++){
            binary36Bit[zeroUntil + i] = binary[i];
        }
        return binary36Bit;
    }

}