package moy2.moy2.Model;

public class Grade {
    private String subject;
    private double coeff;
    private double note_td;
    private double note_cntrl;
    private double grade_avg;

    public Grade(String subject, double coeff) {
        this.subject = subject;
        this.coeff = coeff;
        this.note_td = 0; // Default value
        this.note_cntrl = 0;
        this.grade_avg = 0;
    }

    public String getSubject() {
        return subject;
    }

    public double getCoeff() {
        return coeff;
    }

    public double getNote_td() {
        return note_td;
    }

    public void setNote_td(double note_td) {
        this.note_td = note_td;
        updateGradeAverage();
    }

    public double getNote_cntrl() {
        return note_cntrl;
    }

    public void setNote_cntrl(double note_cntrl) {
        this.note_cntrl = note_cntrl;
        updateGradeAverage();
    }

    public double getGrade_avg() {
        return grade_avg;
    }

    public void resetGrade() {
        this.note_td = 0;
        this.note_cntrl = 0;
        updateGradeAverage();
    }

    private void updateGradeAverage() {
        this.grade_avg = (this.note_td * 0.4) + (this.note_cntrl * 0.6);
    }
}