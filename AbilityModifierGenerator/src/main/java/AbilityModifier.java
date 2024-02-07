import java.util.Locale;

public class AbilityModifier {

    private int score;
    public enum Ability {
        STRENGTH, CONSTITUTION, DEXTERITY, WISDOM, INTELLIGENCE, CHARISMA
    }
    private Ability ability;
    // try creating an enum Ability to hold the ability names as constants

    public AbilityModifier() {}

    public AbilityModifier(String ability, int score) {
        if (isValidAbility(ability)) {
            setAbility(ability);
        }
        if (validateScore(score)) {
            this.score = score;
        } else {
            System.out.println("Character scores cannot be below 0 or above 20.");
        }
    }

    public void setAbility(String ability) {
        if (ability.equalsIgnoreCase("strength")) {
            this.ability = Ability.STRENGTH;
        } else if (ability.equalsIgnoreCase("constitution")) {
            this.ability = Ability.CONSTITUTION;
        } else if (ability.equalsIgnoreCase("dexterity")) {
            this.ability = Ability.DEXTERITY;
        } else if (ability.equalsIgnoreCase("wisdom")) {
            this.ability = Ability.WISDOM;
        } else if (ability.equalsIgnoreCase("intelligence")) {
            this.ability = Ability.INTELLIGENCE;
        } else if (ability.toString().equalsIgnoreCase("charisma")) {
            this.ability = Ability.CHARISMA;
        } else {
            System.out.println("That is not a valid ability. Please try again.");
        }
    }

    public String getAbility() {
        return ability.toString().toLowerCase();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (validateScore(score)) {
            this.score = score;
        }
    }

    public boolean validateScore(int score) {
        return score <= 20 && score >= 0;
    }

    public boolean isValidAbility(String ability) {
        for (Ability a : Ability.values()) {
            if (ability.equalsIgnoreCase(a.toString())) {
                return true;
            }
        }
        return false;
    }

    public void raiseAbilityScore(int amountToRaiseBy) {
        if (validateScore(amountToRaiseBy) && validateScore(amountToRaiseBy + score)) {
            this.score = score + amountToRaiseBy;
        } else if (!validateScore(amountToRaiseBy)) {
            System.out.println("You cannot raise by a negative number.");
        } else if (!validateScore(score + amountToRaiseBy)) {
            System.out.println("You cannot raise a character's score above 20.");
        }
    }

    public int calculateAbilityModifier() {
        int modifier;
        if (score == 20) {
            modifier = 5;
        } else if (score >= 18) {
            modifier = 4;
        } else if (score >= 16) {
            modifier = 3;
        } else if (score >= 14) {
            modifier = 2;
        } else if (score >= 12) {
            modifier = 1;
        } else if (score >= 10) {
            modifier = 0;
        }else if (score >= 8) {
            modifier = -1;
        } else if (score >= 6) {
            modifier = -2;
        } else if (score >= 4) {
            modifier = -3;
        } else if (score >= 2) {
            modifier = -4;
        } else {
            modifier = -5;
        }
        return modifier;
    }

    public String toString() {
        if (score >= 10) {
            return "Your character's " + this.getAbility() + " modifier is +" + this.calculateAbilityModifier();
        } else {
            return "Your character's " + this.getAbility() + " modifier is -" + this.calculateAbilityModifier();
        }
    }

}
