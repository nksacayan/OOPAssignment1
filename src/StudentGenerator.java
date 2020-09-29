import java.util.Random;

public class StudentGenerator {
    private String[] sampleIDArray;
    private Random random;

    public StudentGenerator(String[] sampleIDArray, Random random) {
        this.sampleIDArray = sampleIDArray;
        this.random = random;
    }

    public Student generateStudent() {
        return new Student(sampleIDArray[random.nextInt(sampleIDArray.length)]);
    }
}
