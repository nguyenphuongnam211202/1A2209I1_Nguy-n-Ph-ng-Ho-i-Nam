package arrayListAndLinkedList;

import java.util.Arrays;

public class MyArrayListTest {
    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyArrayList<Person> myArrayList = new MyArrayList<>(4);
        myArrayList.add(new Person("Nam", 20), 0);
        myArrayList.add(new Person("Nhi", 20), 1);
        myArrayList.add(new Person("Nhung", 20), 3);
        for (int i = 0; i < myArrayList.length(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }
}
