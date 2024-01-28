package assn03;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList<Integer>();
        list.add(10);
        list.add(20);
        list.add(60);
        list.add(30);
        System.out.println("list = " + list.toString());
        System.out.println("size of list = " + list.size());
        System.out.println("list contains 10?: " + list.contains(10));
        System.out.println("list contains 50?: " + list.contains(50));
        System.out.println("set element at index 2 to be 10");
        list.set(2, 10);
        System.out.println("get element at index 2 = " + list.get(2));
        System.out.println("list = " + list.toString());
        System.out.println("Last Index of element 10 in list = " + list.lastIndexOf(10));

        list.remove(20);
        System.out.println("list after removing 20 = " + list.toString());

        System.out.println("index of '30' = " + list.indexOf(30));

        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(4);
        list2.add(2);
        System.out.println("list2 = " + list2.toString());


        list2.removeAtIndex(1);
        System.out.println("Task 1: list after removing element at index 1 = " + list2.toString());


        LinkedList<Integer> list3 = new LinkedList<>();
        list3.add(10);
        list3.add(20);
        list3.add(60);
        list3.add(30);
        LinkedList<Integer> list4 = new LinkedList<>();
        list4.add(10);
        list4.add(20);
        list4.add(60);
        list4.add(30);


        System.out.println("list3 = " + list3.toString());
        System.out.println("list4 = " + list4.toString());
        System.out.println("Task 2: list3 == list4 ?: " + list3.isEqual(list4));



        System.out.println("list before removing repeats = " + list2.toString());
        list2.removeRepeats();
        System.out.println("Task 3: list after removing repeats = " + list2.toString());


        LinkedList<Integer> myList = new LinkedList<>();
        LinkedList<Integer> myList2 = new LinkedList<>();


        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        myList2.add(5);
        myList2.add(6);

        System.out.println("Original List: " + myList);

        myList.merge(myList2);

        System.out.println("Merged List: " + myList);
    }
}
