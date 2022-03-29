/*************************************************************************
 * Compilation: javac RunLengthEncoding.java Execution: java RunLengthEncoding
 *
 * @author:
 *
 *************************************************************************/

public class RunLengthEncoding {

    /*
     * Encode the original string by finding sequences in the string where the same
     * character repeats. Replace each such sequence by a token consisting of: the
     * number of characters in the sequence followed by the repeating character.
     * Return the encoded string.
     */
    public static String encode (String original)  {
        String encoded = "";
        int count = 1;
        int i = 0;
        while(i < original.length() - 1){
            if(original.charAt(i) == original.charAt(i+1)){
                count++;
                i++;
            }else if (i == 0 && count == 1){
                encoded+= original.charAt(i);
                i++;
            }else if (count == 1){
                encoded += original.charAt(i);
                i++;
            }else{
                encoded += count;
                count = 1;
                encoded += original.charAt(i);
                i++;
            }
        }
        if (count > 1){
            encoded += count;
        }
        encoded += original.charAt(i);
        return encoded;
    }

    /*
     * Decodes the original string encoded with the encode method. Returns the
     * decoded string.
     *
     * YOUR decode METHOD MUST BE RECURSIVE, do not use while, do/while, or for
     * loops
     */
    public static String decode (String original){
        if (original.length() <= 1){
            return original;
        }
        if (Character.isLetter(original.charAt(0))){
            String begin = original.substring(0, 1);
            String end = original.substring(1);
            return begin + decode(end);
        }else{
            char digit = original.charAt(0);
            String repeat = "" + original.charAt(1);
            String end = original.substring(1);
            return new String(new char[(digit-'0') -1]).replace("\0", repeat);
        }
    }

    

    public static void main(String[] args) {

        System.out.println(decode(encode("qwwwwwwwwweeeeerrtyyyyyqqqqwEErTTT")));
        System.out.println(decode(encode("qqqqqqqqqqq")));
    }
}
