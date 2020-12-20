package aoc.tasks.task14;

import java.util.List;

public class BitMask {
    private char[] mask;

    public BitMask(char[] mask) {
        this.mask = mask;
    }
    public BitMask(String mask) {
        this.mask = mask.toCharArray();
    }

    public long apply(char[] binary) throws Exception{
        assert binary.length == 36;
        assert this.mask.length == 36;
        char[] masked_binary = new char[36];
        for(int i= 0; i < 36; i++){
            char c = this.mask[i];
            if(c== 'X'){
                masked_binary[i] = binary[i];
            }else if(c == '0'){
                masked_binary[i] = '0';
            }else if(c == '1'){
                masked_binary[i] = '1';
            }else{
                throw new Exception("Wrong bitmask character: " + c + " Not Allowed !");
            }
        }
        return Binary.binaryToDecimal(masked_binary);
    }

}
