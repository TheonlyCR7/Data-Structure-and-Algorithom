import java.util.Random;

public class Main {

    private static double testUF(UF uf, int m){

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for(int i = 0; i < m; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String [] args){

        int size = 10000000;
        int m = 10000000;

//        UnionFind1 uf1 = new UnionFind1(size);
//        System.out.println("unionFind1: " + testUF(uf1, m) + " s");
//
//        UnionFind2 uf2 = new UnionFind2(size);
//        System.out.println("unionFind2: " + testUF(uf2, m) + " s");
//
//        UnionFind4 uf4 = new UnionFind4(size);
//        System.out.println("unionFind4: " + testUF(uf4, m) + " s 自己写的,来解决深度问题");
//
//        UnionFind3 uf3 = new UnionFind3(size);
//        System.out.println("unionFind3: " + testUF(uf3, m) + " s");

        // rank 优化
        UnionFind5 uf5 = new UnionFind5(size);
        System.out.println("unionFind5: " + testUF(uf5, m) + " s");

        // 路径压缩
        UnionFind6 uf6 = new UnionFind6(size);
        System.out.println("unionFind6: " + testUF(uf6, m) + " s");

        // 每个节点都挂接上根节点 递归
        UnionFind7 uf7 = new UnionFind7(size);
        System.out.println("unionFind7: " + testUF(uf7, m) + " s");

    }
}

// 有树构成的并查集效率较高
// 结果为
// unionFind1: 0.0870877 s
// unionFind2: 0.0031136 s
// 当 n  较小时，会出现  前者效率高于后者

//实现路径压缩后
// rank 路径压缩两者比较
// unionFind5: 2.111199 s
// unionFind6: 2.1017299 s
