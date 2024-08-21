public class Fortune extends Object implements Attributes {
    private final String name;
    private final int hpBonus;
    private final DiceType dType;
    private final int hitModifier;
    private final int armor;

    public Fortune(String name, int hpBonus, int armor, int hitModifier) {
        this(name, hpBonus, armor, hitModifier, null);
    }

    public Fortune(String name, int hpBonus, int armor, int hitModifier, DiceType type) {
        this.armor = armor;
        this.name = name;
        this.hpBonus = hpBonus;
        this.hitModifier = hitModifier;
        this.dType = type;
    }

    @Override
    public int getArmor() {return armor;}
    @Override
    public int getMaxHP() {
        return hpBonus;
    }
    @Override
    public DiceType getDamageDie() {
        return dType;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    public String getName() {return name;}

    public String toString() {
        String nameSpacing = String.format("%-22s", getName());
        String hpSpacing = String.format("%12s", "+" + getMaxHP());
        String acSpacing = String.format("%12s", "+" + getArmor());
        String hitSpacing = String.format("%11s", "+" + getHitModifier());
        String damageSpacing = String.format("%10s", getDamageDie() != null ? "" + getDamageDie() : "-");

        StringBuilder sb = new StringBuilder();
        sb.append("+======================+\n");
        sb.append("|" + nameSpacing + "|\n");
        sb.append("|HP Bonus: " + hpSpacing + "|\n");
        sb.append("|AC Bonus: " + acSpacing + "|\n");
        sb.append("|Hit Bonus: " + hitSpacing + "|\n");
        sb.append("|Damage Adj: " + damageSpacing + "|\n");
        sb.append("+======================+");
        return sb.toString();
    }


    public static void main(String[] args) {
        Fortune ftn = new Fortune("Merlin Luck", 10, 5, 2, DiceType.D12);
        System.out.println("TESTING Armor in fortune \n" + ftn.toString());
    }

}
