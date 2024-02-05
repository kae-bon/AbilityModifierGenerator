import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbilityModifierTests {

    @Test
    public void score_20_returns_correctly() throws Exception {
        AbilityModifier highAbility = new AbilityModifier("strength", 20);
        int expected = 5;

        int actual = highAbility.calculateAbilityModifier();

        Assert.assertEquals("Score of 20 should return a 5", expected, actual);
    }

    @Test
    public void score_1_returns_correctly() throws Exception {
        AbilityModifier highAbility = new AbilityModifier("strength", 1);
        int expected = -5;

        int actual = highAbility.calculateAbilityModifier();

        Assert.assertEquals("Score of 1 should return a -5", expected, actual);
    }

    @Test
    public void score_10_returns_correctly() throws Exception {
        AbilityModifier highAbility = new AbilityModifier("strength", 10);
        int expected = 0;

        int actual = highAbility.calculateAbilityModifier();

        Assert.assertEquals("Score of 10 should return a 0", expected, actual);
    }

    @Test
    public void can_raise_ability_score() throws IsNotValidAbilityScoreException {
        AbilityModifier ability = new AbilityModifier("str", 18);
        int amountToRaise = 2;
        int expected = 20;
        ability.raiseAbilityScore(2);

        int actual = ability.getScore();

        Assert.assertEquals("Ability score should now be 20.", expected, actual);
    }

    @Test
    public void validate_high_score_returns_false() {
        AbilityModifier ability = new AbilityModifier("str", 20);
        boolean expected = false;

        boolean actual = ability.validateScore(22);
        Assert.assertEquals("Score over 20 should return false.", expected, actual);
    }

}
