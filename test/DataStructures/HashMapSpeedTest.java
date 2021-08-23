package DataStructures;

import DataStructures.Maps.HashMap2;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class HashMapSpeedTest {

    @Test
    public void speedTestForMyMapInitializing(){
        final long startTime = System.currentTimeMillis();
        HashMap2 map = new HashMap2();

        String[] st = "abcdefghiklmnopqrstuvwxyz".split("");
        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            map.add(st[rand.nextInt(st.length)], i);
        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Found map: " + (endTime - startTime));
    }

    @Test
    public void speedTestForFoundMapInitializing(){
        final long startTime = System.currentTimeMillis();
        HashMap2 map = new HashMap2();

        String[] st = "abcdefghiklmnopqrstuvwxyz".split("");
        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            map.add(st[rand.nextInt(st.length)], i);
        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Found map: " + (endTime - startTime));
    }
}
