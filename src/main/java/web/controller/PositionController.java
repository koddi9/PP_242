package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.Position;
import web.service.PositionService;

import java.util.List;

@RestController
public class PositionController {
    @Autowired
    PositionService service;

    @GetMapping("/positions")
    public List<Position> getPositions() {
        return service.getPositions();
    }

    @PostMapping("/positions")
    public List<Position> addPosition(@RequestBody Position position) {
        service.add(position);
        return service.getPositions();
    }

    @GetMapping(value = "/position/{id}")
    public Position getPosition(@PathVariable("id") long id) {
        return service.getPosition(id);
    }

    @PatchMapping(value = "/positions")
    public List<Position> editPosition(@RequestBody Position position) {
        service.update(position);
        return service.getPositions();
    }
}
