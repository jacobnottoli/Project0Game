package Model;

import java.util.concurrent.ThreadLocalRandom;

public class Roll {

    public static int doHeal (int heal) {
        return ThreadLocalRandom.current().nextInt(1,heal+1);
    }
    public static int doDamage (int numroll, int dmg, int addtodmg) {
        int totaldamage = 0;
        for (int i = 0; i < numroll; i++) {
            totaldamage = totaldamage + ThreadLocalRandom.current().nextInt(1,dmg+1);
        }
        totaldamage = totaldamage + addtodmg;
        return totaldamage;
    }
    public static int attackRoll(int addtoroll) {
        int attackroll = ThreadLocalRandom.current().nextInt(1,21) + addtoroll;
        return attackroll;
    }
}
