public class Katana extends Weapon{

    public Katana(String gearsName, String gearsAdjective) throws IllegalArgumentException {
        super(gearsName, gearsAdjective, 4, 6);
    }

    @Override
    public boolean satisfyAbility(Character character) {
        if(character.getWeapons().size() == 0 || (
            character.getWeapons().size() == 1 && character.getWeapons().get(0) instanceof Katana
        )){
            return true;
        }
        return false;
    }
}
