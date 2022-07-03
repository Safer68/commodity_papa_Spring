package by.nenartovich;


import by.nenartovich.dto.HorseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HorseController {

    private final HorseService horseService;

    public HorseController(HorseService horseService) {
        this.horseService = horseService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("horses", horseService.findAll());
        return "horse-list";
    }

    @GetMapping("/horse-create")
    public String newPerson(@ModelAttribute("horse") HorseDto horseDto) {
        return "horse-create";
    }

    @PostMapping()
    public String create(@ModelAttribute("horse") @Valid HorseDto horseDto,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "horse-create";
        horseService.save(horseDto);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        HorseDto horseDto = horseService.findById(id);
        model.addAttribute("horse", horseDto);
        return "horse-update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("horse") @Valid HorseDto horseDto,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "horse-update";
        horseService.save(horseDto);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        horseService.deleteById(id);
        return "redirect:/";
    }
}