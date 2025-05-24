public class Milestone {
    private float milestone1;
    private float milestone2;
    private float terminalAssessment;

    public void setMilestone1(float m1) throws IllegalArgumentException {
        if (m1 < 0 || m1 > 25) {
            throw new IllegalArgumentException("Milestone 1 must be between 0 and 25");
        }
        this.milestone1 = m1;
    }

    public void setMilestone2(float m2) throws IllegalArgumentException {
        if (m2 < 0 || m2 > 40) {
            throw new IllegalArgumentException("Milestone 2 must be between 0 and 40");
        }
        this.milestone2 = m2;
    }

    public void setTerminalAssessment(float ta) throws IllegalArgumentException {
        if (ta < 0 || ta > 35) {
            throw new IllegalArgumentException("Terminal Assessment must be between 0 and 35");
        }
        this.terminalAssessment = ta;
    }

    public float calculateTotal() {
        return milestone1 + milestone2 + terminalAssessment;
    }
}
