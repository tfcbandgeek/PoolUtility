package jgappsandgames.me.poolutilitykotlin

interface PoolObjectCreator<T: PoolObjectInterface> {
    fun generatePoolObject(): T
}