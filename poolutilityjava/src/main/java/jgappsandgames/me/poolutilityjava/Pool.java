package jgappsandgames.me.poolutilityjava;

import java.util.ArrayList;

public class Pool<T extends PoolObjectInterface> {
    private ArrayList<T> pool;

    private int minSize;
    private int maxSize;
    private int increment;
    private int decrement;

    private PoolObjectCreator<T> generator;

    // Initializer ---------------------------------------------------------------------------------
    public Pool(Integer minSize, Integer maxSize, Integer increment, Integer decrement, PoolObjectCreator<T> generator) {
        if (minSize == null) this.minSize = 10;
        else this.minSize = minSize;

        if (maxSize == null) this.maxSize = Integer.MAX_VALUE;
        else this.maxSize = maxSize;

        if (increment == null) this.increment = this.minSize;
        else this.increment = increment;

        if (decrement == null) this.decrement = this.increment / 2;
        else this.decrement = decrement;

        this.generator = generator;

        pool = new ArrayList<>(this.minSize);
        for (int i = 0; i < this.minSize; i++) {
            pool.add(generator.generatePoolObject());
        }
    }

    // Management ----------------------------------------------------------------------------------
    public void changeMin(int min) {
        minSize = min;
    }

    public void changeMax(int max) {
        maxSize = max;
    }

    public void changeIncrement(int increment) {
        this.increment = increment;
    }

    public void changeDecrement(int decrement) {
        this.decrement = decrement;
    }

    public void lowMemory() {
        if (pool.size() > minSize) {
            for (int i = 0; i < decrement; i++) {
                pool.remove(0);
                if (pool.size() <= minSize) break;
            }
        }

        for (int i = 0; i < pool.size(); i++) {
            pool.get(i).deconstruct();
        }
    }

    // Pool Handlers -------------------------------------------------------------------------------
    public void enlargePool() {
        for (int i = 0; i < increment; i++) pool.add(generator.generatePoolObject());
    }

    public void enlargePool(int amount) {
        for (int i = 0; i < amount; i++) pool.add(generator.generatePoolObject());
    }

    public T getPoolObject() {
        if (pool.size() == 0) enlargePool();

        return pool.remove(0);
    }

    public void returnPoolObject(T poolObject) {
        returnPoolObject(poolObject, true);
    }

    public void returnPoolObject(T poolObject, boolean deconstruct) {
        if (deconstruct) poolObject.deconstruct();
        pool.add(poolObject);
    }
}
