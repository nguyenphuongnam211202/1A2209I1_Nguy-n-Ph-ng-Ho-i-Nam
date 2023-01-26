package arrayListAndLinkedList;


import java.util.Arrays;
import java.util.InputMismatchException;

public class MyArrayList<E> {
    private int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;

    public MyArrayList() {
        System.out.println("khởi tạo thành công arrayLisst có kích thước 10");
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            System.out.println("khởi tạo thành công mảng có kích thước: " + capacity);
            elements = new Object[capacity];
        } else {
            System.out.println("lỗi tham số truyền vào");
            throw new InputMismatchException("tham số truyền vào không được bé hơn 0");
        }
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
            System.out.println("khởi tạo thành công mảng mới có kích thước là : " + elements.length);
        } else {
            System.out.println("lỗi tham số truyền vào");
            throw new InputMismatchException("tham số truyền vào không được bé hơn 0");
        }

    }

    public int size() {
        return size;
    }

    public int length() {
        return elements.length;
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity(1);
        }
        elements[size] = e;
        size++;
        return true;
    }

    public void add(E e, int index) {
        if (index > elements.length) {
            throw new InputMismatchException("lỗi index :" + index);
        }
        if (elements[index] == null) {
            size++;
            elements[index] = e;
        } else {
            if (size == elements.length) {
                ensureCapacity(1);
            }
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = e;
            size++;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= elements.length) {
            throw new InputMismatchException("lỗi tham số truyền vào");
        }

        E element = (E) elements[index];
        for (int i = index; i <= size - 2; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;

        return element;
    }

    public E clone() {
        MyArrayList<E> v = new MyArrayList<>();
        v.elements = Arrays.copyOf(elements, size);
        v.size = size;
        return (E) v;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public int indexOf(E e) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(e)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean contains(E e) {
        if(indexOf(e) == -1){
            return false;
        }else {
            return true;
        }
    }

}
