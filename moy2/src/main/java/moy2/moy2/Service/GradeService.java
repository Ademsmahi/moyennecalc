package moy2.moy2.Service;

import org.springframework.stereotype.Service;
import moy2.moy2.Model.Grade;
import java.util.List;
import java.util.ArrayList;

@Service
public class GradeService {
    private final List<Grade> grades;

    public GradeService() {
        grades = new ArrayList<>();
        grades.add(new Grade("DAW", 1));
        grades.add(new Grade("GPL", 2));
        grades.add(new Grade("TQL", 2));
        grades.add(new Grade("TABD", 2));
        grades.add(new Grade("GL", 4));
        grades.add(new Grade("DAC", 2));
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public double calculateTotalAverage() {
        double totalNotes = 0;
        for (Grade g : grades) {
            totalNotes += g.getGrade_avg() * g.getCoeff();
        }
        return totalNotes / 13;
    }

    public void updateGrade(int index, double note_td, double note_cntrl) {
        if (index >= 0 && index < grades.size()) {
            Grade grade = grades.get(index);
            grade.setNote_td(note_td);
            grade.setNote_cntrl(note_cntrl);
            System.out.println("Updated grade: " + grade.getSubject() +
                    " TD: " + note_td +
                    " Controle: " + note_cntrl +
                    " Average: " + grade.getGrade_avg());
        }
    }

    public void resetAllGrades() {
        for (Grade g : grades) {
            g.setNote_td(0);
            g.setNote_cntrl(0);
        }
    }

}