package GoogleMap.controller;

import GoogleMap.entity.GoogleMap;
import GoogleMap.service.GoogleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class GoogleController {
    @Autowired
    GoogleService googleService;

    @GetMapping("/{id}")  // id - переменная пути
    public String googleMap(Model model, @PathVariable Long id) {
        GoogleMap googleMap = googleService.getMapById(id); // выгрузили точки из базы и положили
        model.addAttribute("googleMap", googleMap);
        // в модель, связанную с index.html
        return "index";
    }

}
