package jgappsandgames.me.poolutility;

import jgappsandgames.me.poolutilityjava.PoolObjectCreator;

public class JavaListObjectCreator implements PoolObjectCreator<JavaListObject> {
    @Override
    public JavaListObject generatePoolObject() {
        return new JavaListObject();
    }
}
