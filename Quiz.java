package emk;
import java.util.Scanner;

public class Quiz {
    protected Question[] questions;
    protected boolean fiftyFiftyUsed;
    protected boolean askAudienceUsed;
    protected boolean phoneFriendUsed;
    protected int score;
    protected int currentQuestionIndex;
    protected int[] money = {1000, 2000, 3000, 5000, 10000, 20000, 40000, 80000, 160000, 320000, 640000, 1250000, 2500000, 5000000, 10000000};

    public Quiz(Question[] questions) {
        this.questions = questions;
        this.fiftyFiftyUsed = false;
        this.askAudienceUsed = false;
        this.phoneFriendUsed = false;
        this.score = 0;
        this.currentQuestionIndex = 0;
    }

    public void runQuiz() {
        Scanner scanner = new Scanner(System.in);

        while (currentQuestionIndex < questions.length) {
            Question question = questions[currentQuestionIndex];
            System.out.println("Question " + (currentQuestionIndex + 1) + " for " + money[currentQuestionIndex] + " rupees:");
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            char optionLabel = 'A';
            for (String option : options) {
                System.out.println(optionLabel + ": " + option);
                optionLabel++;
            }

            while (true) {
                System.out.println("Enter your answer (A/B/C/D) or type 'lifeline' to use a lifeline: ");
                String userAnswer = scanner.nextLine().trim().toUpperCase();

                if (userAnswer.equals("LIFELINE")) {
                    if (fiftyFiftyUsed && askAudienceUsed && phoneFriendUsed) {
                        System.out.println("All lifelines have been used.");
                    } else {
                        useLifeline(question, scanner);
                        continue;
                    }
                }

                int index = userAnswer.charAt(0) - 'A';
                try {
                    if (index >= 0 && index < options.length && question.isCorrect(options[index])) {
                        System.out.println("Correct!");
                        score = money[currentQuestionIndex];
                        currentQuestionIndex++;
                        break;
                    } else {
                        System.out.println("Incorrect. The correct answer was: " + question.getCorrectAnswer());
                        System.out.println("Sorry..! You are eliminated.");
                        currentQuestionIndex = questions.length;  // End the quiz
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                }
            }

            if (currentQuestionIndex == questions.length) {
                break;
            }
        }

        if (currentQuestionIndex == questions.length && score != 0) {
            if (score == money[money.length - 1]) {
                System.out.println("Congratulations! You have successfully completed the GAME SHOW and won " + score + " rupees.");
            } else {
                System.out.println("Congratulations! You won " + score + " rupees.");
            }
        }
        scanner.close();
    }

    protected void useLifeline(Question question, Scanner scanner) {
        System.out.println("Available lifelines: ");
        if (!fiftyFiftyUsed) System.out.println("1. 50-50");
        if (!askAudienceUsed) System.out.println("2. Ask the Audience");
        if (!phoneFriendUsed) System.out.println("3. Phone a Friend");

        System.out.println("Enter the number of the lifeline you want to use: ");
        int lifelineChoice = scanner.nextInt();
        scanner.nextLine();  // consume the newline

        switch (lifelineChoice) {
            case 1:
                if (!fiftyFiftyUsed) {
                    fiftyFiftyUsed = true;
                    String[] twoOptions = question.getTwoIncorrectOptions();
                    System.out.println("50-50 Lifeline used. The remaining options are:");
                    System.out.println("	" + question.getCorrectAnswer());
                    System.out.println("	" + twoOptions[0]);
                } else {
                    System.out.println("50-50 Lifeline already used.");
                }
                break;
            case 2:
                if (!askAudienceUsed) {
                    askAudienceUsed = true;
                    System.out.println("Audience suggests: " + question.getCorrectAnswer());
                } else {
                    System.out.println("Ask the Audience Lifeline already used.");
                }
                break;
            case 3:
                if (!phoneFriendUsed) {
                    phoneFriendUsed = true;
                    System.out.println("Friend suggests: " + question.getCorrectAnswer());
                } else {
                    System.out.println("Phone a Friend Lifeline already used.");
                }
                break;
            default:
                System.out.println("Invalid lifeline choice.");
        }
    }
}
