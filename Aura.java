import java.util.*;

public class Aura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String targetText = "Peace begins with a relaxed mind and a steady breath.";
        
        System.out.println("=== AURA: Behavioral Stress Analyzer ===");
        System.out.println("\nINSTRUCTIONS: Type the sentence below exactly as shown.");
        System.out.println("We will analyze your typing biometrics to estimate stress levels.");
        System.out.println("\nTARGET: \"" + targetText + "\"");
        System.out.println("\nPress ENTER when you are ready to start typing...");
        scanner.nextLine();

        long startTime = System.currentTimeMillis();
        System.out.print("START TYPING: ");
        String userInput = scanner.nextLine();
        long endTime = System.currentTimeMillis();

        // 1. Calculate Time Taken
        double timeSeconds = (endTime - startTime) / 1000.0;

        // 2. Calculate Accuracy (Levenshtein-ish distance)
        int errors = calculateErrors(targetText, userInput);
        double accuracy = ((double)(targetText.length() - errors) / targetText.length()) * 100;

        // 3. Stress Index Logic
        // High stress is often characterized by fast but "messy" typing
        double wordsPerMinute = (userInput.split(" ").length / (timeSeconds / 60));
        double stressScore = (errors * 10) + (wordsPerMinute / 2);

        displayResults(timeSeconds, accuracy, stressScore);
    }

    private static int calculateErrors(String target, String input) {
        int errors = Math.abs(target.length() - input.length());
        int minLength = Math.min(target.length(), input.length());
        for (int i = 0; i < minLength; i++) {
            if (target.charAt(i) != input.charAt(i)) {
                errors++;
            }
        }
        return errors;
    }

    private static void displayResults(double time, double acc, double stress) {
        System.out.println("\n--- BIOMETRIC ANALYSIS COMPLETE ---");
        System.out.printf("Time Taken: %.2f seconds\n", time);
        System.out.printf("Accuracy: %.1f%%\n", acc);
        
        System.out.print("ESTIMATED STATE: ");
        if (stress < 15 && acc > 90) {
            System.out.println("ZEN (Calm & Focused) [Output: Light Blue]");
        } else if (stress < 30) {
            System.out.println("BALANCED (Normal Alertness) [Output: Green]");
        } else if (stress < 50) {
            System.out.println("AGITATED (Signs of Stress/Anxiety) [Output: Orange]");
        } else {
            System.out.println("HIGH BURNOUT (High Cognitive Load) [Output: Red]");
            System.out.println("Recommendation: Close your eyes for 2 minutes and focus on your breath.");
        }
        System.out.println("------------------------------------");
    }
}