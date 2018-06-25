package jgappsandgames.me.poolutilityjava;

public interface PoolObjectCreator<T extends PoolObjectInterface> {
    T generatePoolObject();
}