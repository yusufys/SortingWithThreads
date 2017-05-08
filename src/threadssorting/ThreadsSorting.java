package threadssorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class ThreadsSorting {
    /*
    public  static void divideListByTwo(List list){
        int sizeOfList = list.size();
        Twolists.sub1 = new LinkedList();
        Twolists.sub2 = new LinkedList();
        for (int i = 0; i < (sizeOfList/2); i++) {
            Twolists.sub1.add(list.get(i));
        }
        for (int i = (sizeOfList/2); i <= sizeOfList-1; i++) {
                        Twolists.sub2.add(list.get(i));
        }
    }
    
    public static List sortList(List list){
                Collections.reverse(list);
                Collections.sort(list);
                return list;
    }
    
    public static List mergeLists(){
        List merged =  (List) Stream.concat(Twolists.sub1.stream(), Twolists.sub2.stream()).collect(Collectors.toList());
        return sortList(merged);
    }
    public static List ReversedOrder(List list){
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }
 */
    
    public static void main(String[] args) {
  
        /*
             LinkedList TheList = new LinkedList(Arrays.asList(7,12,19,3,18,4,2,6,15,8));

            divideListByTwo(TheList);
            System.out.println("\nSub1 List");
              Twolists.sub1.forEach((Item) -> {
            System.out.print("["+ Item.toString() + "]");
        }); 
                 System.out.println("\nSub2 List");
              Twolists.sub2.forEach((Item) -> {
            System.out.print("["+ Item.toString() + "]");
        }); 
              System.out.println("\nSorted Sub1 List");
                  sortList(Twolists.sub1).forEach((Item) -> {
            System.out.print("["+ Item.toString() + "]");
        }); 
                    System.out.println("\nSorted Sub2 List");
                  sortList(Twolists.sub2).forEach((Item) -> {
            System.out.print("["+ Item.toString() + "]");
        }); 
                    System.out.println("\nMerged & Sorted (sub1,sub2) List");
                  mergeLists().forEach((Item) -> {
            System.out.print("["+ Item.toString() + "]");
        }); 
                   System.out.println("\n Ascending order :Merged & Sorted (sub1,sub2) List");
                  ReversedOrder(mergeLists()).forEach((Item) -> {
            System.out.print("["+ Item.toString() + "]");
        }); 
    */
        LinkedList TheList = new LinkedList(Arrays.asList(7,12,19,3,18,4,2,6,15,8));
        MyThread t1 = new MyThread(TheList);
        SubList1Thread sublist1 = new SubList1Thread();
        sublist1.run();
        SubList2Thread sublist2 = new SubList2Thread();
        sublist2.run();
        MergeSubLists MergeSublists = new MergeSubLists();
        MergeSublists.run();
        
    }
    
}
