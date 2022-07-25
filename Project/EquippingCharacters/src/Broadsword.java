public class Broadsword extends Weapon{

    public Broadsword(String gearsName, String gearsAdjective)
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
