package com.conti.stage2;

import com.conti.stage2.events.ChangedEventListener;
import com.conti.stage2.events.EventManager;
import com.conti.stage2.events.EventType;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class SomeList<E> {

    private static final Object[] EMPTY_DATA = {};
    private static final int DEFAULT_CAPACITY_EMPTY_DATA = 0;
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data;
    private int size;
    private EventManager events;
    private ChangedEventListener listener;

    public SomeList() {
        size = DEFAULT_CAPACITY_EMPTY_DATA;
        this.data = EMPTY_DATA;
        events = new EventManager(EventType.CHANGED);
    }

    /**
     * method adds an object to the end of the sheet
     * @param element added element
     * @return results of adding
     */
    public boolean add(E element) {
        add(size, element);
        events.notify(EventType.CHANGED, element);
        return true;
    }

    /**
     * method getting object by index
     * @param index index of element in list
     * @return object
     */
    public Object get(int index) {
        return data[index];
    }

    /**
     *
     * @return current non-null values
     */
    public int size() {
        return size;
    }

    /**
     *
     * @return current array size
     */
    public int capacity() {
        return data.length;
    }

    public void addChangedListener() {
        if (listener == null) {
            listener = new ChangedEventListener(this);
            events.subscribe(EventType.CHANGED, listener);
        } else {
            // do nothing
        }
    }

    public void removeChangedListener() {
        if (listener != null) {
            events.unsubscribe(EventType.CHANGED, listener);
        } else {
            // do nothing
        }
    }

    // private methods
    private Object[] grow() {
        return Arrays.copyOf(data, newCapacity());
    }

    private boolean add(int index, E element) {
        if (index == data.length)
            data = grow();
        data[index] = element;
        size = index + 1;
        return true;
    }

    private int newCapacity() {
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (data == EMPTY_DATA) {
            return DEFAULT_CAPACITY;
        } else {
        }
        return newCapacity;
    }


    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ");
        Stream<Object> stream = Arrays.stream(data);
        stream.filter(Objects::nonNull).forEach(e -> sj.add(e.toString()));
        return "[SomeList {" + sj.toString() +"}]";
    }

}
