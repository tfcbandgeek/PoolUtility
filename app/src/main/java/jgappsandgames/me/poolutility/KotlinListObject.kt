package jgappsandgames.me.poolutility

import android.graphics.Color
import jgappsandgames.me.poolutilitykotlin.PoolObjectCreator
import jgappsandgames.me.poolutilitykotlin.PoolObjectInterface
import java.util.*

class KotlinListObject: PoolObjectInterface {
    var date: Calendar? = Calendar.getInstance()
    var id = MainActivity.getNextId();
    var word: String? = MainActivity.words[MainActivity.pos++]
    var color = Color.BLUE

    init {
        if (MainActivity.pos > 25) MainActivity.pos = 0
    }

    fun load(): KotlinListObject {
        if (MainActivity.pos > 25) MainActivity.pos = 0
        date = Calendar.getInstance()
        id = MainActivity.getNextId();
        word = MainActivity.words[MainActivity.pos++]
        color = Color.BLUE

        return this
    }

    override fun getID(): Int {
        return id
    }

    override fun deconstruct() {
        date = null
        id = 0
        word = null
        color = 0
    }
}

class KotlinListObjectGenerator: PoolObjectCreator<KotlinListObject> {
    override fun generatePoolObject(): KotlinListObject {
        return KotlinListObject()
    }
}