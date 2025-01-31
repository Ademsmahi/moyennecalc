package moy2.moy2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import moy2.moy2.Service.GradeService;

@Controller
public class GradeController {
    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/")
    public String displayGrades(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        model.addAttribute("totalAverage", gradeService.calculateTotalAverage());
        return "index";
    }

    @PostMapping("/updateGrade")
    public String updateGrade(@RequestParam int index,
            @RequestParam double note_td,
            @RequestParam double note_cntrl) {
        gradeService.updateGrade(index, note_td, note_cntrl);
        return "redirect:/"; // Refreshes the page to show updated values
    }

    @PostMapping("/resetGrades")
    public String resetAllGrades() {
        gradeService.resetAllGrades();
        return "redirect:/"; // Redirects after resetting all grades
    }

}