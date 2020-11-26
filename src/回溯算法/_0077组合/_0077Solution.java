package 回溯算法._0077组合;

import java.util.*;

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
public class _0077Solution {

    // result存放符合条件结果的集合,也就是总的结果，比如输入n=4，k=2，输出为[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
    static List<List<Integer>> result = new ArrayList<>();
    // path用来存放符合条件结果，即path相当于树按照路径(path)去搜索符合的结果
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public static void backtracking(int n, int k, int startIndex){
        if (path.size() == k){ // 终止条件
            result.add(new ArrayList<>(path)); //这里要注意，一定要new一个，否则会出现引用的问题得不到想要的结果
//            System.out.println(Arrays.toString(result.toArray()));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i); // 处理节点
//            System.out.println("递归之前 => " + path);
            backtracking(n, k, i+1); // 递归
            path.remove(path.size() - 1);  // 回溯，撤销处理的节点,比如得到结果[1,2]，只有将2弹出，才能遍历到3，得到结果[1,3]
//            System.out.println("递归之后 => " + path);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<List<Integer>> res = combine(n, k);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
