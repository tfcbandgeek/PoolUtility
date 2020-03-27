package jgappsandgames.me.poolutilitykotlin

class SimplePool<T>(private val factory: PoolFactory<T>, private val maxSize: Int = 100) {
    // Data
    private val freeObjects = ArrayList<T>()

    // Pool Methods
    fun getPoolObject(): T {
        if (freeObjects.size < 1) return factory.createPoolObject()
        return freeObjects.removeAt(0)
    }

    fun returnPoolObject(poolObject: T) {
        if (freeObjects.size < maxSize) freeObjects.add(poolObject)
    }

    // Internal Interfaces
    interface PoolFactory<U> {
        fun createPoolObject(): U
    }
}