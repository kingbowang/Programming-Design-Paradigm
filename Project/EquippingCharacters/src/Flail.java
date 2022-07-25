import java.util.Random;

public class Flail extends Weapon{
    // save hold character
    private Character character;

    public Flail(String gearsName, String gearsAdjective)
        throws IllegalArgumentException {
        super(gearsName, gearsAdjective, 8, 12);
    }

    @Override
    public boolean satisfyAbility(Character character) {
        if(character.getWeapons().size() == 0){
            this.character = character;
            return true;
        }
        return false;
    }

    @Override
    public int getAttack(){
        Ability ability = character.currentAbility();
        Random random = new Random();
        int ratio = ability.getDexterity() < 14 ? 2 : 1;
        return (minAttach + random.nextInt(maxAttach - minAttach + 1)) / ratio;
    }
}
