package jgappsandgames.me.poolutility;

import android.graphics.Color;
import java.util.Calendar;

import jgappsandgames.me.poolutilityjava.PoolObjectInterface;

public class JavaListObject implements PoolObjectInterface {
    public Calendar date;
    public int id;
    public String word;
    public int color;

    public JavaListObject() {
        if (MainActivity.pos > 25) MainActivity.pos = 0;
        date = Calendar.getInstance();
        id = MainActivity.getNextId();
        word = MainActivity.words.get(MainActivity.pos++);
        color = Color.BLUE;
    }

    public JavaListObject load() {
        if (MainActivity.pos > 25) MainActivity.pos = 0;
        date = Calendar.getInstance();
        id = MainActivity.getNextId();
        word = MainActivity.words.get(MainActivity.pos++);
        color = Color.BLUE;

        return this;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void deconstruct() {
        date = null;
        id = 0;
        word = null;
        color = 0;
    }
}
