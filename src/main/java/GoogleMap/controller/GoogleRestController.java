package GoogleMap.controller;

import GoogleMap.entity.GoogleMap;
import GoogleMap.entity.GooglePoint;
import GoogleMap.service.GoogleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/map")
@Slf4j
public class GoogleRestController {
    @Autowired
    private GoogleService googleService;

    @PutMapping("/")
    public ResponseEntity<String> saveMap(@RequestBody GoogleMap googleMap) {
        googleService.saveMap(googleMap);
        return ResponseEntity.ok("ok");
    }
}
