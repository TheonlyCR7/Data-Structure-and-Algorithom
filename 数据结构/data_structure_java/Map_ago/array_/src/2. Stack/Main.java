package Stack;

public class Main{

    public static void main(String[] args){

        //创建ArrayStack的对象
        ArrayStack<Integer> stack = new ArrayStack<Integer>();

        for (int i = 0; i < 5; i++){
            //调用stack对象方法push，入栈
            stack.push(i);
            //打印栈
            System.out.println(stack);
        }

        //出栈
        stack.pop();
        System.out.println(stack);
    }
}
