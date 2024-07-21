package emk;
public class Question {
    private String questionText;
    private String[] options;
    private String correctAnswer;

    public Question(String questionText, String correctAnswer, String... options) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect(String answer) {
        return correctAnswer.equals(answer);
    }

    public String[] getTwoIncorrectOptions() {
        String[] incorrectOptions = new String[2];
        int index = 0;
        for (String option : options) {
            if (!option.equals(correctAnswer)) {
                incorrectOptions[index++] = option;
                if (index == 2) break;
            }
        }
        return incorrectOptions;
    }
}
