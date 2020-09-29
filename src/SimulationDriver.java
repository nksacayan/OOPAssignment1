import java.util.Random;

public class SimulationDriver {

    public static void main(String[] args) {

        // Sample questions, answers, and names for the generators to pull from
        String[] badQuestionArray = {"How many licks does it take to get to the center of a tootsie pop?",
                                    "How many times do we have to teach you this lesson old man?",
                                    "Is this loss?", "Does this dress make me look fat?"};
        String[] badAnswerArray = {"1", "2", "3", "4", "Yes", "No", "Maybe"};
        String[] sampleNameArray = {"Wayde", "John", "Bruce", "Jerry", "Tommy", "Nick", "Leeroy", "Big Chungus", "Jane",
                                    "Wackacka", "Tony", "Yeet", "Red Sus", "Tinky Winky", "Dipsy", "Lala", "Po",
                                    "Yo Mama", "Ergonomic", "Ben Dover", "Nicki", "Neemo", "Marlin", "Dory" };

        BadQuestionGenerator badQuestionGenerator =
                new BadQuestionGenerator(badQuestionArray, badAnswerArray, new Random());
        StudentGenerator studentGenerator = new StudentGenerator(sampleNameArray, new Random());

        // Generates some number of students between 10 - 30
        Random random = new Random();
        Student[] students = new Student[random.nextInt(20) + 11];
        for (int i = 0; i < students.length; i++) {
            students[i] = studentGenerator.generateStudent();
        }

        System.out.println();

        // Generates a single complete question
        Question question = badQuestionGenerator.generateBadQuestion();
        System.out.println(question);

        // Binds question to VotingService
        VotingService votingService = new VotingService(question);

        // Randomizes each students' answer
        for (Student student : students) {

            // If answer is not accepted submit a new one
            while (true) {

                // Creates a random answer
                boolean[] randomSubmission = new boolean[4];
                for (int i = 0; i < randomSubmission.length; i++) {
                    randomSubmission[i] = random.nextBoolean();
                }
                boolean successfulSubmit = votingService.addSubmission(student.getStudentID(), randomSubmission);
                if (successfulSubmit)
                    break;
            }
            // Submits answer
        }

        System.out.println();
        // Prints count of all answers
        votingService.printSubmissionStats();

        System.out.println();
        // Prints number correct
        votingService.printNumberRightWrong();
    }
}
