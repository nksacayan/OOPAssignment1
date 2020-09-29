import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Question {
    protected String prompt;
    protected HashMap<String, Boolean> answerMap;
    // True if correct, false if incorrect

    public Question(String prompt) {
        answerMap = new HashMap<>(4);
        this.prompt = prompt;
    }

    public abstract void addAnswer(String answer, Boolean isCorrect);
    public abstract boolean isValidQuestion();
    public abstract boolean isValidAnswer(boolean[] attemptedAnswer);

    public boolean checkAnswer(boolean[] attemptedAnswer) {
        Boolean[] correctAnswer = answerMap.values().toArray(new Boolean[4]);
        for (int i = 0; i < attemptedAnswer.length; i++) {
            if (correctAnswer[i] != attemptedAnswer[i]) {
                return false;
            }
        }
        return true;
    }

    protected boolean hasCorrectAnswer() {
        for (boolean value : answerMap.values()) {
            if(value)
                return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder questionStringBuilder = new StringBuilder();
        char label = 'A';
        Set<String> keys = answerMap.keySet();
        questionStringBuilder.append(prompt);
        for (String key : keys) {
            questionStringBuilder.append("\n" + label + ": " + key);
            label += 1;
        }
        return questionStringBuilder.toString();
    }

    public void printCorrectAnswer() {
        System.out.println("Correct answer(s): \n");
        for ( Map.Entry<String, Boolean> entry : answerMap.entrySet()) {
            if (entry.getValue() == true) {
                System.out.println(entry.getKey());
            }
        }
    }

    protected int numberOfTrues(boolean[] submission) {
        int numberOfTrues = 0;
        for (boolean answer : submission) {
            if (answer == true) {
                numberOfTrues++;
            }
        }
        return numberOfTrues;
    }
    
}
