package br.com.absolomb.PCIForm.controller;

import br.com.absolomb.PCIForm.model.LineModel;
import br.com.absolomb.PCIForm.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lines")
public class LineController {

    @Autowired
    private LineService lineService;

    // Create a new LINE for a specific HEADER
    @PostMapping("/header/{headerId}")
    public ResponseEntity<LineModel> createLine(@PathVariable Long headerId, @RequestBody LineModel line) {
        LineModel createdLine = lineService.createLine(headerId, line);
        return new ResponseEntity<>(createdLine, HttpStatus.CREATED);
    }

    // Find all LINES from a specific HEADER
    @GetMapping("/header/{headerId}")
    public ResponseEntity<List<LineModel>> getLinesByHeader(@PathVariable Long headerId) {
        List<LineModel> lines = lineService.getLinesByHeader(headerId);
        return new ResponseEntity<>(lines, HttpStatus.OK);
    }

    // Delete a specific line
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLine(@PathVariable Long id) {
        lineService.deleteLine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

