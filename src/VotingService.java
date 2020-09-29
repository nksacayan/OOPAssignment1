import java.util.HashMap;
import java.util.Map;

public class VotingService {
    private Question question;
    private HashMap<String, boolean[]> submissions;

    public VotingService(Question question) {
        this.question = question;
        submissions = new HashMap<>();
    }

    // Student inputs True on the indices corresponding to possible answers
    public boolean addSubmission(String studentID, boolean[] submission) {
        if (!question.isValidAnswer(submission)) {
            // System.out.println("Answer not valid for this type of question");
            return false;
        }
        if (submissions.containsKey(studentID)) {
            submissions.replace(studentID, submission);
        } else {
            submissions.put(studentID, submission);
        }
        return true;
    }

    public void printSubmissionStats() {
        int a = 0, b = 0, c = 0, d = 0;
        for (boolean[] submission : submissions.values()) {
            if (submission[0] == true) {
                a++;
            }
            if (submission[1] == true) {
                b++;
            }
            if (submission[2] == true) {
                c++;
            }
            if (submission[3] == true) {
                d++;
            }
        }
        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("C: " + c);
        System.out.println("D: " + d);
    }

    public void printNumberRightWrong() {
        int right = 0, wrong = 0;
        for (boolean[] submission : submissions.values()) {
            if (question.checkAnswer(submission)) {
                right++;
            }
            else {
                wrong++;
            }
        }
        System.out.println("Right: " + right + "\nWrong: " + wrong);
    }

    public void printQuestion() {
        System.out.println(question);
    }

    public void printSubmissions() {
        for (Map.Entry<String, boolean[]> entry : submissions.entrySet()) {
            System.out.println(entry.getKey() + "answered: ");
            StringBuilder answer = new StringBuilder();
            if (entry.getValue()[0]) {
                answer.append("A ");
            }
            if (entry.getValue()[1]) {
                answer.append("B ");
            }
            if (entry.getValue()[2]) {
                answer.append("C ");
            }
            if (entry.getValue()[3]) {
                answer.append("D ");
            }
            System.out.println(answer.toString());
        }
    }

}
