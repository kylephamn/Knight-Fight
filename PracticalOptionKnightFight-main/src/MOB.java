public class MOB extends Object implements Attributes {


protected int armor;
protected int damage;
protected DiceType damageDie;
protected int hitModifier;
protected int maxHP;
private final String name;


    public MOB(String name, int hp, int armor, int hitModifier, DiceType damageDie) {
        this.name = name;
        this.maxHP = hp;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.damageDie = damageDie;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }
    @Override
    public int getArmor() {
        return armor;
    }
    @Override
    public int getMaxHP() {
        return maxHP;
    }
    public int getDamage() {
        return damage;
    }
    public String getName() {
        return name;
    }
    public void addDamage(int damage) {
        this.damage += damage;
    }
    public int getHP() {
        return maxHP - damage;
    }
    public void resetDamage() {
        this.damage = 0;
    }
    @Override
    public DiceType getDamageDie() {
        return damageDie;
    }

    @Override
    public String toString() {
        // Calculate spacing for name, health, power, and armor fields
        String nameSpacing = String.format("%-27s", getName());
        String healthSpacing = String.format("%-10d", getMaxHP());
        String powerSpacing = String.format("%-6s", getDamageDie().toString());
        String armorSpacing = String.format("%-4d", getArmor());

        // Build the formatted String
        StringBuilder sb = new StringBuilder();
        sb.append("+============================+\n");
        sb.append(String.format("| %s|%n", nameSpacing));
        sb.append("|                            |\n");
        sb.append(String.format("|         Health: %s |%n", healthSpacing));
        sb.append(String.format("|  Power: %s  Armor: %s|%n", powerSpacing, armorSpacing));
        sb.append("|                            |\n");
        sb.append("+============================+");
        return sb.toString();
    }

    public MOB copy() {
        return new MOB(getName(), getMaxHP(), getArmor(), getHitModifier(), getDamageDie());
    }

    public static void main(String[] args) {
        MOB steve = new MOB("steve", 30, 10, 2, DiceType.D8);
        System.out.println(steve.toString());
    }
}
