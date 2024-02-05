public class AbilityModifier {

    private int score;
    private String ability;

    public AbilityModifier() {}

    public AbilityModifier(String ability, int score) {
        this.ability = ability;
        if (validateScore(score)) {
            this.score = score;
        } else {
            System.out.println("Character scores cannot be below 0 or above 20.");
        }
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean validateScore(int score) {
        return score <= 20 && score >= 0;
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
            return "Your character's ability modifier is +" + this.calculateAbilityModifier();
        } else {
            return "Your character's ability modifier is -" + this.calculateAbilityModifier();
        }
    }

}
