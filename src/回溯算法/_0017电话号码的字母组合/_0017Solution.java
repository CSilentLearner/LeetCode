package 回溯算法._0017电话号码的字母组合;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 回溯三部曲：
 * 1.确定 递归函数 的 参数 和 返回值
 * NB.一般来说参数能设为全局的就设置为全局，仅仅是为了代码的阅读性；无特殊需求，一般返回值为void
 *
 * 2.确定终止条件
 * NB.一般把回溯问题抽象成一个n叉树问题，那么终止条件就是到达叶子节点的情况
 *
 * 3.单层递归逻辑
 * NB.一般就是在for里面做一些操作
 * */
public class _0017Solution {

    //存放：数字与字母的映射关系,用一个一维数组存放即可
    static String[] letterMap = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    static List<String> result = new ArrayList<>();//存放所有结果
    static StringBuilder sb = new StringBuilder();//存放叶子节点的每一种结果

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return result; // 这种情况下不能返回null，因为尽管返回result，那result也是个空，所以返回null是不合适的
        }
        backtracking(digits, 0); //index=0表示从digits的第1个数字所对应的字符串进行遍历
        return result;
    }

    public static void backtracking(String digits, int index){ //digits为输入，index表示访问到digits的第几个字母
        if (sb.length() == digits.length()){ // 写成 index == digits.length() 也是可以的，其实也是一个意思
            result.add(sb.toString());
            return;
        }

        int digit = digits.charAt(index) - '0'; // 将index指向的数字转为int
        String letters = letterMap[digit];      // 取数字对应的字符集

        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i)); // 处理
            backtracking(digits, index + 1); // 递归，注意index+1，一下层要处理下一个数字了
            sb.deleteCharAt(sb.length() - 1); // 回溯
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine(); // 给定的输入，如23 233

        List<String> res = letterCombinations(digits);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
