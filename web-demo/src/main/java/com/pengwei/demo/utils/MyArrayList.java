package com.pengwei.demo.utils;

import java.util.Iterator;

/**
 * @author pengwei
 * @date 2020/4/23
 */
public class MyArrayList<AnyType> implements Iterable<AnyType> {

    private static final int DEFAULT_CAPACITY=16;
    private int theSize;
    private AnyType [] theItems;

    public void clear(){
        theSize=0;
        ensureCatacity(DEFAULT_CAPACITY);
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size()==0;
    }
    public void trimToSize(){
        ensureCatacity(size());
    }


    private void ensureCatacity(int defaultCapacity) {
        if (theSize>defaultCapacity){
            return;
        }
        AnyType[] old = theItems;
        theItems=(AnyType []) new Object[defaultCapacity];
        for (int i=0;i<defaultCapacity;i++){
            theItems[i]=old[i];
        }

    }


    @Override
    public Iterator<AnyType> iterator() {
        return null;
    }
}
