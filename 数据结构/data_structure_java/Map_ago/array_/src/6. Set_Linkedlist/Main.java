package Set_Linkedlist;

import Set_BST.BST_set;
import Set_BST.FileOperation;

import java.util.ArrayList;

public class Main {

    private static double testSet(Set<String> set, String filename){

        long starTime = System.nanoTime();

        System.out.println(filename);

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();

        return (endTime - starTime) / 100000.0;
    }

    public static void main(String[] args){

        String filename = "pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + "s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linked List Set: " + time2 + "s");
    }
}
