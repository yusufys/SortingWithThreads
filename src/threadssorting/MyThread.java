/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadssorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Twolists{
        static List sub1 = new LinkedList();
        static List sub2 = new LinkedList();
}
 class MyThread {
    public void divideListByTwo(List list){
        int sizeOfList = list.size();
        Twolists.sub1 = new LinkedList();
        Twolists.sub2 = new LinkedList();
        for (int i = 0; i < (sizeOfList/2); i++) {
            Twolists.sub1.add(list.get(i));
        }
        for (int i = (sizeOfList/2); i <= sizeOfList-1; i++) {
            Twolists.sub2.add(list.get(i));
        }      
        System.out.println("the list is Divided By Two List...");
       
            System.out.println("\nOriginal List");
              list.forEach((Item) -> {
            System.out.print("["+ Item.toString() + "]");
        }); 
            System.out.println("\nSub1 List");
              Twolists.sub1.forEach((Item) -> {
            System.out.print("["+ Item.toString() + "]");
        }); 
                 System.out.println("\nSub2 List");
              Twolists.sub2.forEach((Item) -> {
            System.out.print("["+ Item.toString() + "]");
        });               
    }   
    public  List sortList(List list){
                Collections.reverse(list);
                Collections.sort(list);
                return list;
    }    
    public  List mergeLists(){
        List merged =  (List) Stream.concat(Twolists.sub1.stream(), Twolists.sub2.stream()).collect(Collectors.toList());
        return sortList(merged);
    }
    public  List ReversedOrder(List list){
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }   
        public MyThread(List the_list){
            divideListByTwo(the_list);
        }
}
class SubList1Thread implements Runnable{
 public  List sortList(List list){
                Collections.reverse(list);
                Collections.sort(list);
                return list;
    }
    @Override
    public void run() {
        sortList(Twolists.sub1);
        System.out.println("\nSorted Sub1 List");
        sortList(Twolists.sub1).forEach((Item) -> {
        System.out.print("["+ Item.toString() + "]");
        }); 
    }
    
}
class SubList2Thread implements Runnable{
 public  List sortList(List list){
                Collections.reverse(list);
                Collections.sort(list);
                return list;
    }
    @Override
    public void run() {
        sortList(Twolists.sub2);
        System.out.println("\nSorted Sub2 List");
        sortList(Twolists.sub2).forEach((Item) -> {
        System.out.print("["+ Item.toString() + "]");
        }); 
    }
    
}
class MergeSubLists implements Runnable{
     public  List sortList(List list){
                Collections.reverse(list);
                Collections.sort(list);
                return list;
    }
  public  List mergeLists(){
        List merged =  (List) Stream.concat(Twolists.sub1.stream(), Twolists.sub2.stream()).collect(Collectors.toList());
        return sortList(merged);
    }
    public  List ReversedOrder(List list){
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }
    @Override
    public void run() {
            mergeLists();
                System.out.println("\nMerged & Sorted (sub1,sub2) List");
                  mergeLists().forEach((Item) -> {
            System.out.print("["+ Item.toString() + "]");
        }); 
                System.out.println("\n Ascending order :Merged & Sorted (sub1,sub2) List");
                  ReversedOrder(mergeLists()).forEach((Item) -> {
            System.out.print("["+ Item.toString() + "]");
        }); 
    }
    
}
