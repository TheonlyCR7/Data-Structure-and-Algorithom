import java.util.Random;

public class text {
    public static void main(String [] args){
        int[][] twonums = new int[3][4];
        twonums = randomnums(twonums);
        twonums = Rorate_nums(twonums);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("before: \n");
        for (x:twonums){
            System.out.print("[");
            System.out.print();
        }


    }

    public static int[][] randomnums(int[][] nums){
        Random random = new Random();
        for (int i = 0; i < 3; i ++)
            for(int j = 0; j < 4; j ++)
                nums[i][j] = random.nextInt(1);
        return nums;
    }

    private static int[][] Rorate_nums(int[][] nums){
        int[][] roratenums = new int[4][3];
        for(int i = 0; i < 4; i ++)
            for(int j = 0; j < 3; j ++)
                roratenums[i][j] = nums[j][i];
        return roratenums;
    }
}
