public class Ability implements Comparable<Ability>{
    // ability argument, which can be positive or negative
    private int strength;
    private int constitution;
    private int dexterity;
    private int charisma;

    /**
     * construct for ability
     * @param strength
     * @param constitution
     * @param dexterity
     * @param charisma
     */
    public Ability(int strength, int constitution, int dexterity, int charisma) {
        this.strength = strength;
        this.constitution = constitution;
        this.dexterity = dexterity;
        this.charisma = charisma;
    }

    /**
     * add more ability
     * @param ability
     */
    public void addAbility(Ability ability){
        this.strength += ability.getStrength();
        this.constitution += ability.getConstitution();
        this.dexterity += ability.getDexterity();
        this.charisma += ability.getCharisma();
    }

    /**
     * get all health
     * @return
     */
    public int getHealth(){
        return strength + constitution + dexterity + charisma;
    }

    /**
     * get strength
     * @return strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * get constitution
     * @return constitution
     */
    public int getConstitution() {
        return constitution;
    }

    /**
     * get dexterity
     * @return dexterity
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * get charisma
     * @return charisma
     */
    public int getCharisma() {
        return charisma;
    }

    /**
     * compare ability exceed charism
     * @param ability
     * @return compare result
     */
    @Override
    public int compareTo(Ability ability) {
        return Integer.compare(getStrength() + getDexterity() + getConstitution(),
            ability.getDexterity() + ability.getConstitution() + ability.getStrength());
    }
}
