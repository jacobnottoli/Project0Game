package Model;

public class Player {
    String name;
    String clas;
    int hp;
    int maxhp;
    int ac;
    int dmg;
    int addtodmg;
    int addtohit;
    int heal;
    String atkname;
    int lvl;
    int xp;
    int coin;

    public Player(String name, String clas, int hp, int maxhp, int ac, int dmg, int addtodmg, int addtohit, int heal, String atkname, int lvl, int xp, int coin) {
        this.name = name;
        this.clas = clas;
        this.hp = hp;
        this.maxhp = maxhp;
        this.ac = ac;
        this.dmg = dmg;
        this.addtodmg = addtodmg;
        this.addtohit = addtohit;
        this.heal = heal;
        this.atkname = atkname;
        this.lvl = lvl;
        this.xp = xp;
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
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

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public String getAtkname() {
        return atkname;
    }

    public void setAtkname(String atkname) {
        this.atkname = atkname;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
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
