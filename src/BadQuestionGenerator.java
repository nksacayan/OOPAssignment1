import java.util.Random;

public class BadQuestionGenerator {
    private String[] badQuestionArray;
    private String[] badAnswerArray;
    private Random random;

    public BadQuestionGenerator(String[] badQuestionArray, String[] badAnswerArray, Random random) {
        this.badQuestionArray = badQuestionArray;
        this.badAnswerArray = badAnswerArray;
        this.random = random;
    }

    public Question generateBadQuestion() {
        Question generatedQuestion;
        String randomlySelectedQuestion = badQuestionArray[random.nextInt(badQuestionArray.length)];

        if (random.nextBoolean()) {
            generatedQuestion = new SingleSolutionQuestion(randomlySelectedQuestion);
        } else {
            generatedQuestion = new MultipleSolutionQuestion(randomlySelectedQuestion);
        }

        while (!generatedQuestion.isValidQuestion()) {
            String randomlySelectedAnswer = badAnswerArray[random.nextInt(badAnswerArray.length)];
            boolean isRandomlyCorrect = random.nextBoolean();
            generatedQuestion.addAnswer(randomlySelectedAnswer, isRandomlyCorrect);
        }
        return generatedQuestion;
    }
}
