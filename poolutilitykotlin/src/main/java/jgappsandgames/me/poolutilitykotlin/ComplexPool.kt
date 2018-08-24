package jgappsandgames.me.poolutilitykotlin

import java.nio.file.Files.size



open class ComplexPool<T: ComplexPool.PoolObject>(private val factory: PoolFactory<T>,
                                                  start: Int, private val minSize: Int, private val maxSize: Int,
                                                  private val increment: Int, private val decrement: Int) {
    private val freeObjects = ArrayList<T>()
    private var currentSize = 0;
    private var nextID = 0L

    // Initializer
    init {

    }

    // Pool Methods
    fun increment() {
        currentSize += increment

        if (currentSize > maxSize) currentSize = maxSize

        for (i in 0 until increment) {
            freeObjects.add(factory.createObject(nextID++))
        }
    }

    fun decrement() {
        currentSize -= decrement

        if (currentSize < minSize) currentSize = minSize

        while (freeObjects.size > currentSize) {
            freeObjects.removeAt(0)
        }
    }

    private fun increment(amount: Int) {
        currentSize += amount

        if (currentSize > maxSize) currentSize = maxSize

        for (i in 0 until amount) {
            freeObjects.add(factory.createObject(nextID++))
        }
    }

    private fun decrement(amount: Int) {
        currentSize -= amount

        if (currentSize < minSize) currentSize = minSize

        while (freeObjects.size > currentSize) {
            freeObjects.removeAt(0)
        }
    }

    // Internal Interfaces
    interface PoolFactory<U> {
        fun createObject(id: Long): U
    }

    interface PoolObject {
        fun getID(): Long
        fun destroy()
    }
}