public class Knight extends MOB {
    private Fortune activeFortune;
    protected final int id;
    protected int xp;

    public Knight(int id, String name, int hp, int armor, int hitModifier, DiceType damageDie, int xp) {
        super(name, hp, armor, hitModifier, damageDie);
        this.id = id;
        this.xp = xp;

    }

    public int getArmor() {
        if(getActiveFortune() == null) {
               return armor;
        }
        return getActiveFortune().getArmor() + super.getArmor();
    }

    public int getMaxHP() {
        if(getActiveFortune() == null) {
            return maxHP;
        }
        return getActiveFortune().getMaxHP() + super.getMaxHP();
    }

    public DiceType getDamageDie() {
        if(getActiveFortune() == null) {
            return damageDie;
        }
            return getActiveFortune().getDamageDie();
    }

    public int getHitModifier() {
       if (getActiveFortune() == null ) {
           return hitModifier;
        }
        return getActiveFortune().getHitModifier() + super.getHitModifier();
    }

    public int getXP() {
        return xp;
    }

    public Fortune getActiveFortune() {
        return activeFortune;
    }

    public void setActiveFortune(Fortune activeFortune) {
        this.activeFortune = activeFortune;
    }

    public void addXP(int xp) {
        this.xp += xp;
    }

    public Integer getID() {
        return this.id;
    }



    public String toCSV() {
        return getName() + "," + getMaxHP() + "," + getArmor() + "," + getHitModifier() + "," + getDamage() + "," + getXP();
    }

    public static void main(String[] args) {
        Knight knight = new Knight(9, "Merlin The Random", 59, 6, 9, DiceType.D12, 2);
        Fortune fortune = new Fortune("Test Fortune 2", 0, 1, 2, DiceType.D4);
        knight.setActiveFortune(fortune);

        System.out.println(knight.toCSV());
        System.out.println("Building a random fortune");
        System.out.println(fortune.toString());
        System.out.println("Building a random knight");
        System.out.println(knight.toString());
    }
}




