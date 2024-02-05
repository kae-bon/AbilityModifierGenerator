public class Generator {

    public static void main(String[] args) {

        UserInterface ui = new UserInterface();
        AbilityModifier newAbility = new AbilityModifier();

        System.out.println("########## Welcome to the D&D ##########");
        System.out.println("###### Ability Modifier Generator ######");
        System.out.println();

        ui.speak("What ability are you trying to calculate? (str, dex, con, wis, int, char)");
        String ability = ui.getUserInput();
        newAbility.setAbility(ability);
        System.out.println();
        ui.speak("The ability you are calculating is " + newAbility.getAbility());
        System.out.println();

        boolean isValidScore = false;

        while (!isValidScore) {
            ui.speak("What is your character's " + newAbility.getAbility() + "'s score?");
            int score = Integer.parseInt(ui.getUserInput());
            if (newAbility.validateScore(score)) {
                isValidScore = true;
                newAbility.setScore(score);
                System.out.println();
                ui.speak("Your character's " + newAbility.getAbility() + " score is " + newAbility.getScore());
                System.out.println();
            } else {
                System.out.println();
                ui.speak("That is not a valid ability score. Scores must be above 0 and below 20. Please try again.");
                System.out.println();
            }
        }

        ui.speak("Your character's " + newAbility.getAbility() + " score is " + newAbility.getScore() + ".");
        System.out.println(newAbility);

        System.out.println();
        System.out.println("####### Thank you for using the #######");
        System.out.println("##### ability modifier generator! #####");
        System.out.println();
    }

}
