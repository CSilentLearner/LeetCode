package 贪心算法._0455分发饼干;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 本题是一个很简单的贪心思想的题目，因为每个孩子最多只能分给一块饼干,
 * 所以拿最大的饼干先满足胃口最大的孩子，每一步局部最优肯定最后是一个全局最优！
 *
 * NB.详细解见OneNote笔记！！
 * */
public class _0455Solution {

    public static int findContentChildren(int[] g, int[] s) {
        //先将饼干数组和小孩数组排序
        Arrays.sort(g);
        Arrays.sort(s);

        int j = s.length - 1;//饼干数组的下表
        int reslut = 0;

        //从后向前遍历小孩数组，用大饼干优先满足胃口大的，并统计满足小孩数量
        for (int i = g.length - 1; i >= 0; i--) {
            if (j >= 0 && s[j] >= g[i]){ //j>=0要先保证饼干还有啊，没有的话就没必要分给孩子了
                j--;
                reslut++;
            }
        }

        return reslut;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g_len = sc.nextInt();//孩子胃口值数组长度
        int[] g = new int[g_len];
        for (int i = 0; i < g_len; i++) {
            g[i] = sc.nextInt();
        }
        int s_len = sc.nextInt();//饼干尺寸数组长度
        int[] s = new int[s_len];
        for (int j = 0; j < s_len; j++) {
            s[j] = sc.nextInt();
        }
        System.out.println(Arrays.toString(g));
        System.out.println(Arrays.toString(s));
        int result = findContentChildren(g, s);
        System.out.println(result);
    }
}
