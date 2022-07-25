public class Axes extends Weapon{

    public Axes(String gearsName, String gearsAdjective)
        throws IllegalArgumentException {
        super(gearsName, gearsAdjective, 6, 10);
    }

    @Override
    public boolean satisfyAbility(Character character) {
        if(character.getWeapons().size() == 0){
            return true;
        }
        return false;
    }
}
