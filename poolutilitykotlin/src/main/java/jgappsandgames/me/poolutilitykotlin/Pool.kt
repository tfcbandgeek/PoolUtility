package jgappsandgames.me.poolutilitykotlin

class Pool<T: PoolObjectInterface>(private var minSize: Int = 10, private var maxSize: Int = Int.MAX_VALUE,
                                   private var increment: Int = minSize, private var decrement: Int = (increment / 2),
                                   private val generator: PoolObjectCreator<T>) {
    private val pool: ArrayList<T> = ArrayList(minSize)

    // Initializer ---------------------------------------------------------------------------------
    init {
        for (i in 0 until minSize) pool.add(generator.generatePoolObject())
    }

    // Management Methods --------------------------------------------------------------------------
    fun changeMin(min: Int) {
        minSize = min
    }

    fun changeMax(max: Int) {
        maxSize = max
    }

    fun changeIncrement(increment: Int) {
        this.increment = increment
    }

    fun changeDecrement(decrement: Int) {
        this.decrement = decrement
    }

    fun lowMemory() {
        if (pool.size > minSize) {
            for (i in 0 until decrement) {
                pool.removeAt(0)
                if (pool.size <= minSize) break
            }
        }

        for (i in 0 until pool.size) {
            pool[i].deconstruct()
        }
    }

    // Pool Handlers -------------------------------------------------------------------------------
    fun enlargePool(amount: Int = increment) {
        for (i in 0 until amount) pool.add(generator.generatePoolObject())
    }

    fun getPoolObject(): T {
        if (pool.size == 0) enlargePool()

        return pool.removeAt(0)
    }

    fun returnPoolObject(poolObject: T, deconstruct: Boolean = true) {
        if (deconstruct) poolObject.deconstruct()
        pool.add(poolObject)
    }
}