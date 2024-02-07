import java.util.Locale;

public class Generator {

    public static void main(String[] args) {

        UserInterface ui = new UserInterface();
        AbilityModifier newAbility = new AbilityModifier();

        System.out.println("\n########## Welcome to the D&D ##########");
        System.out.println("###### Ability Modifier Generator ######\n");

        boolean isValidAbility = false;

        while (!isValidAbility) {
            ui.speak("What ability are you trying to calculate? (strength, dexterity, constitution, wisdom, intelligence, charisma)");
            String ability = ui.getUserInput();
            if (newAbility.isValidAbility(ability)) {
                newAbility.setAbility(ability);
                ui.speak("\nThe ability you are calculating is " + newAbility.getAbility().toLowerCase() + "!\n");
                isValidAbility = true;
            } else {
                ui.speak("\nThat is not a valid ability. Please try again.\n");
            }
        }

        boolean isValidScore = false;

        while (!isValidScore) {
            ui.speak("What is your character's " + newAbility.getAbility() + "'s score?");
            int score = Integer.parseInt(ui.getUserInput());
            if (newAbility.validateScore(score)) {
                isValidScore = true;
                newAbility.setScore(score);
                ui.speak("\nYour character's " + newAbility.getAbility() + " score is " + newAbility.getScore() + "\n");
            } else {
                ui.speak("\nThat is not a valid ability score. Scores must be above 0 and below 20. Please try again.\n");
            }
        }
        System.out.println(newAbility);

        System.out.println("\n####### Thank you for using the #######");
        System.out.println("##### ability modifier generator! #####");
    }

}
