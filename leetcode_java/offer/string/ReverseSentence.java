package offer.string;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字啊的顺序不变。
 * @link http://wiki.jikexueyuan.com/project/for-offer/question-forty-two.html
 */
public class ReverseSentence {

    /**
     * 第一步翻转句子中所有的字符。
     * 第二步再翻转每个单词中字符的顺序.
     */

    public void  recert(char [] data,int start,int end){
        if (start>end){
            return;
        }

        while (start<end){
            char tmp = data[start];
            data[start]=data[end];
            data[end]=tmp;
            start++;
            end--;
        }
    }

    public void  reverseSentence(char [] data){
        if (data==null||data.length<1){
            return;
        }

        recert(data,0,data.length-1);

        int start=0;
        int end =0 ;
        while (start<data.length){
            if (data[start]==' '){
                start++;
                end++;
            }else if(end==data.length||data[end]==' '){
                //翻转单个单词
                recert(data,start,end);
                start=end;
                end++;
            }else {
                end++;
            }
        }

    }
}
