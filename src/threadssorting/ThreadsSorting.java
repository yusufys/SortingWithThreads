package threadssorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Twolists {

    static List sub1 = new LinkedList();
    static List sub2 = new LinkedList();
}

class MyThread {

    public void divideListByTwo(List list) {
        int sizeOfList = list.size();
        Twolists.sub1 = new LinkedList();
        Twolists.sub2 = new LinkedList();
        for (int i = 0; i < (sizeOfList / 2); i++) {
            Twolists.sub1.add(list.get(i));
        }
        for (int i = (sizeOfList / 2); i <= sizeOfList - 1; i++) {
            Twolists.sub2.add(list.get(i));
        }
        System.out.println("\nThe list is Divided By Two List...\n");

        System.out.println("\n\n*-*-Original List*-*-\n");
        list.forEach((Item) -> {
            System.out.print("[" + Item.toString() + "]");
        });
        System.out.println("\n\n*-*-Sub1 List*-*-\n");
        Twolists.sub1.forEach((Item) -> {
            System.out.print("[" + Item.toString() + "]");
        });
        System.out.println("\n\n*-*-Sub2 List*-*-\n");
        Twolists.sub2.forEach((Item) -> {
            System.out.print("[" + Item.toString() + "]");
        });
    }

    public MyThread(List list) {
        divideListByTwo(list);
    }
}

class SubList1Thread implements Runnable {

    public List sortList(List list) {
        Collections.reverse(list);
        Collections.sort(list);
        return list;
    }

    @Override
    public void run() {
        sortList(Twolists.sub1);
        System.out.println("\n\n*-*-Sorted Sub1 List*-*-\n");
        sortList(Twolists.sub1).forEach((Item) -> {
            System.out.print("[" + Item.toString() + "]");
        });
    }

}

class SubList2Thread implements Runnable {

    public List sortList(List list) {
        Collections.reverse(list);
        Collections.sort(list);
        return list;
    }

    @Override
    public void run() {
        sortList(Twolists.sub2);
        System.out.println("\n\n*-*-Sorted Sub2 List*-*-\n");
        sortList(Twolists.sub2).forEach((Item) -> {
            System.out.print("[" + Item.toString() + "]");
        });
    }

}

class MergeSubLists implements Runnable {

    public List sortList(List list) {
        Collections.reverse(list);
        Collections.sort(list);
        return list;
    }

    public List mergeLists() {
        List merged = (List) Stream.concat(Twolists.sub1.stream(), 
                Twolists.sub2.stream()).collect(Collectors.toList());
        return sortList(merged);
    }

    public List ReversedOrder(List list) {
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    @Override
    public void run() {
        mergeLists();
        System.out.println("\n\n*-*-Merged & Sorted (sub1,sub2) List*-*-\n");
        mergeLists().forEach((Item) -> {
            System.out.print("[" + Item.toString() + "]");
        });
        System.out.println("\n\n*-*-Ascending order :Merged & Sorted (sub1,sub2) List*-*-\n");
        ReversedOrder(mergeLists()).forEach((Item) -> {
            System.out.print("[" + Item.toString() + "]");
        });
    }

}

public class ThreadsSorting {

    public static void main(String[] args) {
        System.out.println("\n\n___________________");
        System.out.print("|++ INTEGERS ++|\n");
        System.out.print("___________________\n");

        LinkedList integersList = new LinkedList(Arrays.asList(7,12,19,3,18,4,2,6,15,8));
        MyThread t1 = new MyThread(integersList);
        SubList1Thread sublist1 = new SubList1Thread();
        sublist1.run();
        SubList2Thread sublist2 = new SubList2Thread();
        sublist2.run();
        MergeSubLists MergeSublists = new MergeSubLists();
        MergeSublists.run();
        //------------------
        System.out.println("\n\n___________________");
        System.out.println("\n|++ DECIMALS ++|");
        System.out.print("___________________\n");        
        LinkedList decimalsList = new LinkedList(Arrays.asList(0.7,0.12,0.19,0.3,0.18,0.4,0.2,0.6,0.15,0.8));
        MyThread t2 = new MyThread(decimalsList);
        SubList1Thread sublist1_2 = new SubList1Thread();
        sublist1_2.run();
        SubList2Thread sublist2_2 = new SubList2Thread();
        sublist2_2.run();
        MergeSubLists MergeSublists_2 = new MergeSubLists();
        MergeSublists_2.run();
        //------------------A-E-H-O-R-S-Ü
        System.out.println("\n\n___________________");
        System.out.println("\n|++ LETTER |++");
        System.out.print("___________________\n");        
        
        LinkedList letters_List = new LinkedList(Arrays.asList("a","b","c","d","e","f","g","h","a"));
        MyThread t3 = new MyThread(letters_List);
        SubList1Thread sublist1_3 = new SubList1Thread();
        sublist1_3.run();
        SubList2Thread sublist2_3 = new SubList2Thread();
        sublist2_3.run();
        MergeSubLists MergeSublists_3 = new MergeSubLists();
        MergeSublists_3.run();

    }

}
