import java.util.Random;

public abstract class Weapon implements Gear{
    protected String name;
    protected String desc;
    protected int minAttach;
    protected int maxAttach;


    public  Weapon(String gearsName, String gearsAdjective, int minAttach, int maxAttach)throws IllegalArgumentException {
        if (gearsName == null | gearsAdjective == null){
            throw new IllegalArgumentException("Null values aren't allowed");
        }
        if (gearsName.trim().isEmpty() | gearsAdjective.trim().isEmpty()) {
            throw new IllegalArgumentException("Didn't put in a gear name and gear adjective");
        }
        if (minAttach < 0 || maxAttach < 0 || minAttach > maxAttach) {
            throw new IllegalArgumentException("Must have a positive attack.");
        }
        this.name = gearsName;
        this.desc = gearsAdjective;
        this.minAttach = minAttach;
        this.maxAttach = maxAttach;
    }

    /**
     * judge whether player can equip this weapon
     * @param character
     * @return
     */
    public abstract boolean satisfyAbility(Character character);

    /**
     * get weapon points of damage
     * @return
     */
    public int getAttack(){
        Random random = new Random();
        return minAttach + random.nextInt(maxAttach - minAttach + 1);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAdjective() {
        return desc;
    }

    @Override
    public int compareTo(Gear gear) {
        if(gear instanceof Weapon) {
            return name.compareTo(gear.getName());
        }
        return 1;
    }

    /**
     * Returns the toString.
     *
     * @return toString
     */
    @Override
    public String toString() {
        return String.format("%s of %s",getName(),getAdjective());
    }
}
