import java.util.Arrays;
public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
    }

    public void add(int index, String element) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (size == elements.length) {
            this.ensureCapacity(size + 1);
        }
        if (elements[index] != null) {
            for (int i = size - 1; i >= index; i--) {
                elements[i + 1] = elements[i];
            }
        }
        elements[index] = element;
        size++;
    }

    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(1);
        }
        elements[size] = element;
        size++;
        return true;
    }

    public E remove(int index) {
        checkIndex(index);
        E e = (E) elements[index];
        // Shift data to the left
        for (int j = index; j < size - 1; j++) {
            elements[j] = elements[j + 1];
        }
        elements[size - 1] = null; // This element is now null
        // Decrement size
        size--;
        return e;
    }

    @Override
    public MyList<E> clone() {
        MyList<E> newMyList = new MyList<>();
        newMyList.elements = Arrays.copyOf(this.elements, this.size);
        newMyList.size = this.size;
        return newMyList;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);

        }
    }

    public E get(int index) {
        this.checkIndex(index);
        return (E) elements[index];
    }

    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return index;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }

}
