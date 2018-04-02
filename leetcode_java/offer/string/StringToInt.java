package offer.string;

/**
 * 字符串转int 的代码
 */
public class StringToInt {


    public int stringToInt(String str){

        if (str==null||str.trim().length()==0||str.equals("")){
            return 0;
        }

        char frist =str.charAt(0);
        if (frist=='+'){
            return stringToIntCase(str.toCharArray(),1,true);
        }else if (frist=='-'){
            return stringToIntCase(str.toCharArray(),1,false);
        }else if (frist>='0'&& frist<='9'){
            return stringToIntCase(str.toCharArray(),0,true);
        }else {
            throw new RuntimeException("str not invail !");
        }


    }

    public int stringToIntCase(char [] chars,int index,boolean positive){
        if (index>=chars.length){
            throw new RuntimeException("str not invail !");
        }

        int result;
        long  tmp=0;
        while (index < chars.length && chars[index]>='0'&&chars[index]<='9') {
            tmp = tmp * 10 + chars[index]- '0';
            // 保证求的得的值不超出整数的最大绝对值
            if (tmp > Integer.MAX_VALUE) {
                throw new NumberFormatException(new String(chars));
            }
            index++;
        }
        if (positive) {
            if (tmp > Integer.MAX_VALUE) {
                throw new NumberFormatException(new String(chars));
            } else {
                result = (int) tmp;
            }
        } else {
            if (tmp > Integer.MAX_VALUE) {
                result = Integer.MIN_VALUE;
            } else {
                result = (int) -tmp;
            }
        }
        return result;
    }

}
