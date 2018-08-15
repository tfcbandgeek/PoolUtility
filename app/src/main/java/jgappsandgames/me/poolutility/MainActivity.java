package jgappsandgames.me.poolutility;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import jgappsandgames.me.poolutilityjava.Pool;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView j;
    private ListView k;
    private FloatingActionButton jf;
    private FloatingActionButton kf;

    public static final ArrayList<String> words = new ArrayList<>();
    public static int pos = 0;
    private static int nid = 0;

    public static int getNextId() {
        return nid++;
    }

    private Pool<JavaListObject> javaPool;
    private jgappsandgames.me.poolutilitykotlin.Pool<KotlinListObject> kotlinPool;

    private ArrayList<JavaListObject> javaList = new ArrayList<>();
    private ArrayList<KotlinListObject> kotlinList = new ArrayList<>();

    public MainActivity() {
        words.add("Alphabet");
        words.add("Beta");
        words.add("Charles");
        words.add("Dog");
        words.add("Exit");
        words.add("Fox");
        words.add("Galaxy");
        words.add("Hello");
        words.add("Indigo");
        words.add("Joshua");
        words.add("Know");
        words.add("Loser");
        words.add("Monster");
        words.add("Nobody");
        words.add("Octopus");
        words.add("Personal");
        words.add("Quest");
        words.add("Rooster");
        words.add("Soccer");
        words.add("Taco");
        words.add("Underwear");
        words.add("Valiant");
        words.add("World");
        words.add("Xylophone");
        words.add("Yellow");
        words.add("Zap");

        javaPool = new Pool<>(5, 25, 5, 5, new JavaListObjectCreator());
        kotlinPool = new jgappsandgames.me.poolutilitykotlin.Pool<>(5, 25, 5, 5, new KotlinListObjectGenerator());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        j = findViewById(R.id.java_list);
        k = findViewById(R.id.kotlin_list);
        jf = findViewById(R.id.java_fab);
        kf = findViewById(R.id.kotlin_fab);

        jf.setOnClickListener(this);
        kf.setOnClickListener(this);

        j.setAdapter(new JavaAdapter(javaList, this));
        k.setAdapter(new KotlinAdapter(kotlinList, this));
    }

    @Override
    public void onClick(View view) {
        if (view.equals(jf)) {
            javaList.add(javaPool.getPoolObject().load());
            j.setAdapter(new JavaAdapter(javaList, this));
        } else if (view.equals(kf)) {
            kotlinList.add(kotlinPool.getPoolObject().load());
            k.setAdapter(new KotlinAdapter(kotlinList, this));
        }
    }
}
