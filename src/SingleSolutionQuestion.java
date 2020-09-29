import java.util.Collection;
import java.util.Map;

public class SingleSolutionQuestion extends Question {

    public SingleSolutionQuestion(String prompt) {
        super(prompt);
    }

    @Override
    public void addAnswer(String answer, Boolean isCorrect) {
        if (answerMap.size() == 4) {
            // System.out.println("Entry will not be added. Already has 4 answers");
            return;
        }
        if (isCorrect && hasCorrectAnswer()) {
            // System.out.println("Entry will not be added. Already has a correct answer");
            return;
        }
        if (answerMap.size() == 3 && !hasCorrectAnswer()) {
            // System.out.println("Entry will not be added. Must enter a correct answer");
            return;
        }
        answerMap.put(answer, isCorrect);
    }

    @Override
    public boolean isValidQuestion() {
        if(answerMap.size() != 4) {
            // System.out.println("Question must have four possible answers");
            return false;
        }
        int numCorrectAnswers = 0;
        for (boolean isCorrect : answerMap.values()) {
            if (isCorrect)
                numCorrectAnswers++;
        }
        if (numCorrectAnswers != 1) {
            // System.out.println("Must have one and only one correct answer");
            return false;
        }
        return true;
    }

    @Override
    public boolean isValidAnswer(boolean[] attemptedAnswer) {
        if (attemptedAnswer.length != 4 || numberOfTrues(attemptedAnswer) != 1) {
            // System.out.println("Answer must be one of four choices");
            return false;
        }
        return true;
    }


}
