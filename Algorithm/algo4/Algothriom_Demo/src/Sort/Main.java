package Sort;


import java.io.*;

public class Main {
    public static void main(String[] args) {

        // 这里使用相对路径时，要注意，根目录(起始目录)为 Algothriom_Demo(项目文件夹)，并非java文件本身
        String filePath =
                "src\\algs4-data\\32kints.txt";
        // 通过文件路径获取文件
        File file = new File(filePath);

        if (file.exists()) {
            try {
                // 创建文件读取对象
                FileReader fileReader = new FileReader(file);
                // 创建一个使用默认大小的输入缓冲区的缓冲字符输入流
                BufferedReader br = new BufferedReader(fileReader);
                String lineContent = null;
                // algs4-data\\1Kints.txt 有1000行数据
                String[] testArray = new String[32000];
                int i = 0;
                while ((lineContent = br.readLine()) != null) {
                    testArray[i] = lineContent;
                    i ++;
                }

                // System.out.println(Arrays.toString(testArray));

                // 计时器
                long startTime1 = System.nanoTime();
                SelectSort.sort(testArray);
                long endTime1 = System.nanoTime();
                System.out.println(
                        "选择排序，1000个数据，执行时间为：" +
                                (endTime1 - startTime1) / 1000000000.0 + " s");

                long startTime2 = System.nanoTime();
                insertSort.sort(testArray);
                long endTime2 = System.nanoTime();
                System.out.println(
                        "插入排序，1000个数据，执行时间为：" +
                                (endTime2 - startTime2) / 1000000000.0 + " s");

                // 计时器
                long startTime3 = System.nanoTime();
                ShellSort.sort(testArray);
                long endTime3 = System.nanoTime();
                System.out.println(
                        "希尔排序，1000个数据，执行时间为：" +
                                (endTime3 - startTime3) / 1000000000.0 + " s");





                // System.out.println(Arrays.toString(testArray));

                // 关闭流
                br.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("no this file");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("io exception");
                e.printStackTrace();
            }
        }
    }
}
