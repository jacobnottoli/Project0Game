package Model;

public class Monster {
    String name;
    int hp;
    int ac;
    int numroll;
    int dmg;
    int addtodmg;
    int addtohit;
    int xp;
    int coin;

    public Monster(String name, int hp, int ac, int numroll, int dmg, int addtodmg, int addtohit, int xp, int coin) {
        this.name = name;
        this.hp = hp;
        this.ac = ac;
        this.numroll = numroll;
        this.dmg = dmg;
        this.addtodmg = addtodmg;
        this.addtohit = addtohit;
        this.xp = xp;
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getNumroll() {
        return numroll;
    }

    public void setNumroll(int numroll) {
        this.numroll = numroll;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getAddtodmg() {
        return addtodmg;
    }

    public void setAddtodmg(int addtodmg) {
        this.addtodmg = addtodmg;
    }

    public int getAddtohit() {
        return addtohit;
    }

    public void setAddtohit(int addtohit) {
        this.addtohit = addtohit;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}
