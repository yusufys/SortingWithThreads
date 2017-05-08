/**********************************
***********************************
*** AD SOYAD: YUSUF YURTSEVER
*** OGR NO. 02130001070
*** DERS ADI : ISLETIM SISTERMLERI
*** 1. ODEV
*** 
*** 
************************************/
package threadssorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
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
        while (true) {

            LinkedList User_Input_List = new LinkedList();
            Scanner readInp = new Scanner(System.in);
            System.out.println("\nPress [i] for Integers\npress [d] for Decimals\npress [c] For Characters\n press [q] to END");
            String elementsNumInput = readInp.nextLine();
            if ("i".equals(elementsNumInput)) {
                System.out.println("Please enter the number of elements you want to add:\n REMEMBER! YOUR LIST SHOULD HAVE EN EVEN NUMBER OF ELEMENTS!");

                int usersInput = readInp.nextInt();
                if (usersInput % 2 == 0) {
                    System.out.println("Please enter the integers you wanna add to the list by leaving [SPACE] between each number..");
                    for (int i = 0; i < usersInput; i++) {
                        User_Input_List.add(readInp.nextInt());
                    }
                    System.out.println("Your List:\n" + User_Input_List);
                    MyThread t1 = new MyThread(User_Input_List);
                    t1.divideListByTwo(User_Input_List);
                    SubList1Thread sublist1 = new SubList1Thread();
                    sublist1.run();
                    SubList2Thread sublist2 = new SubList2Thread();
                    sublist2.run();
                    MergeSubLists MergeSublists = new MergeSubLists();
                    MergeSublists.run();

                } else {
                    System.out.println("YOUR LIST ELEMENTS NUMBER IS'NT EVEN!");
                }

            } else if ("d".equals(elementsNumInput)) {
                System.out.println("Please enter the number of elements you want to add:\n REMEMBER! YOUR LIST SHOULD HAVE EN EVEN NUMBER OF ELEMENTS!");
                int usersInput = readInp.nextInt();
                if (usersInput % 2 == 0) {
                    System.out.println("Please enter the DECIMALS you wanna add to the list by leaving [SPACE] between each number..");
                    for (int i = 0; i < usersInput; i++) {
                        User_Input_List.add(readInp.nextDouble());
                    }
                    System.out.println("Your List:\n" + User_Input_List);
                    MyThread t2 = new MyThread(User_Input_List);
                    t2.divideListByTwo(User_Input_List);
                    SubList1Thread sublist1_2 = new SubList1Thread();
                    sublist1_2.run();
                    SubList2Thread sublist2_2 = new SubList2Thread();
                    sublist2_2.run();
                    MergeSubLists MergeSublists_2 = new MergeSubLists();
                    MergeSublists_2.run();

                } else {
                    System.out.println("YOUR LIST ELEMENTS NUMBER IS'NT EVEN!");
                    System.out.println();
                }

            } else if ("c".equals(elementsNumInput)) {//harfler için
                System.out.println("Please enter the number of elements you want to add:\n REMEMBER! YOUR LIST SHOULD HAVE EN EVEN NUMBER OF ELEMENTS!");
                int usersInput = readInp.nextInt();
                if (usersInput % 2 == 0) {
                    System.out.println("Please enter the  you wanna add to the list by leaving [SPACE] between each number..");
                    for (int i = 0; i < usersInput; i++) {
                        User_Input_List.add(readInp.next().charAt(0));
                    }
                    System.out.println("Your List:\n" + User_Input_List);
                    MyThread t2 = new MyThread(User_Input_List);
                    t2.divideListByTwo(User_Input_List);
                    SubList1Thread sublist1_2 = new SubList1Thread();
                    sublist1_2.run();
                    SubList2Thread sublist2_2 = new SubList2Thread();
                    sublist2_2.run();
                    MergeSubLists MergeSublists_2 = new MergeSubLists();
                    MergeSublists_2.run();

                } else {
                    System.out.println("YOUR LIST ELEMENTS NUMBER IS'NT EVEN!");
                    System.out.println();
                }
            }
            else if("q".equals(elementsNumInput)){
                System.out.println("BYE!");
                break;
            }
            else {
                System.out.println("ERROR, TRY AGAIN. ");
                System.out.println();
            }

        }

    }

}
