import java.util.*;

/**
 * AURA — Behavioral Stress Analyzer
 * A Java console application that uses typing biometrics to estimate stress levels.
 *
 * Author : DILRAG MADHURESH V
 * Course : MCA (AI/ML)
 * ID     : 25MCAR0266
 *
 * How it works:
 *  - The user types a pre-defined sentence.
 *  - The program measures time taken, typing speed (WPM), and error count.
 *  - A stress score is calculated from these biometrics.
 *  - The user is categorized into one of four states: ZEN, BALANCED, AGITATED, or BURNOUT.
 *
 * Compile:  javac Aura.java
 * Run:      java Aura
 */
public class Aura {

    /** The sentence the user must type. */
    private static final String TARGET_TEXT =
            "Peace begins with a relaxed mind and a steady breath.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   AURA — Behavioral Stress Analyzer      ║");
        System.out.println("║   Biometric Typing Analysis Engine        ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();
        System.out.println("INSTRUCTIONS:");
        System.out.println("  Type the sentence below exactly as shown.");
        System.out.println("  We analyze your typing biometrics to estimate your stress level.");
        System.out.println();
        System.out.println("TARGET: \"" + TARGET_TEXT + "\"");
        System.out.println();
        System.out.println("Press ENTER when you are ready to start typing...");
        scanner.nextLine();   // wait for user

        // --- Measurement ---
        long startTime = System.currentTimeMillis();
        System.out.print("START TYPING: ");
        String userInput = scanner.nextLine();
        long endTime   = System.currentTimeMillis();

        // 1. Time taken in seconds
        double timeSeconds = (endTime - startTime) / 1000.0;

        // 2. Error count (character-level comparison)
        int errors = calculateErrors(TARGET_TEXT, userInput);

        // 3. Accuracy percentage
        double accuracy = Math.max(0.0,
                ((double)(TARGET_TEXT.length() - errors) / TARGET_TEXT.length()) * 100);

        // 4. Words per minute
        int wordCount = userInput.trim().isEmpty() ? 0
                      : userInput.trim().split("\\s+").length;
        double wpm = (timeSeconds > 0) ? (wordCount / (timeSeconds / 60.0)) : 0;

        // 5. Stress score
        double stressScore = (errors * 10) + (wpm / 2.0);

        displayResults(timeSeconds, accuracy, wpm, stressScore);

        scanner.close();
    }

    /**
     * Calculates the number of character-level errors between target and input.
     * Counts both substitutions (char-by-char mismatch) and length differences.
     *
     * @param target  The expected sentence.
     * @param input   The user's typed input.
     * @return        Total error count.
     */
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

    /**
     * Prints the biometric analysis results to the console.
     *
     * @param time      Time taken in seconds.
     * @param accuracy  Typing accuracy as a percentage.
     * @param wpm       Words per minute.
     * @param stress    Calculated stress score.
     */
    private static void displayResults(double time, double accuracy, double wpm, double stress) {
        System.out.println();
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║        BIOMETRIC ANALYSIS COMPLETE       ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.printf("  Time Taken  : %.2f seconds%n", time);
        System.out.printf("  Accuracy    : %.1f%%%n", accuracy);
        System.out.printf("  Speed (WPM) : %.1f%n", wpm);
        System.out.printf("  Stress Score: %.1f%n", stress);
        System.out.println();
        System.out.print("  ESTIMATED STATE: ");

        if (stress < 15 && accuracy > 90) {
            System.out.println("ZEN (Calm & Focused)");
            System.out.println("  → Optimal cognitive performance. Keep up the great work!");
        } else if (stress < 30) {
            System.out.println("BALANCED (Normal Alertness)");
            System.out.println("  → Healthy alertness. Take a short break if needed.");
        } else if (stress < 50) {
            System.out.println("AGITATED (Signs of Stress/Anxiety)");
            System.out.println("  → Try box breathing: Inhale 4s, Hold 4s, Exhale 4s, Hold 4s.");
        } else {
            System.out.println("HIGH BURNOUT (Critical Cognitive Overload)");
            System.out.println("  → Step away from the screen. Walk for 2 minutes.");
            System.out.println("  → Splash cold water on your face. You need a reset.");
        }

        System.out.println("════════════════════════════════════════════");
    }
}
