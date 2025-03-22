package br.com.absolomb.PCIForm.controller;

import br.com.absolomb.PCIForm.model.HeaderModel;
import br.com.absolomb.PCIForm.service.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/headers")
public class HeaderController {

    @Autowired
    private HeaderService headerService;

    // Create a new header
    @PostMapping
    public ResponseEntity<HeaderModel> createHeader(@RequestBody HeaderModel header) {
        HeaderModel savedHeader = headerService.createHeader(header);
        return new ResponseEntity<>(savedHeader, HttpStatus.CREATED);
    }

    // Get all headers
    @GetMapping
    public ResponseEntity<List<HeaderModel>> getAllHeaders() {
        List<HeaderModel> headers = headerService.getAllHeaders();
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    // Get a header by ID
    @GetMapping("/{id}")
    public ResponseEntity<HeaderModel> getHeaderById(@PathVariable Long id) {
        HeaderModel header = headerService.getHeaderById(id);
        return new ResponseEntity<>(header, HttpStatus.OK);
    }

    // Updates a header
    @PutMapping("/{id}")
    public ResponseEntity<HeaderModel> updateHeader(@PathVariable Long id, @RequestBody HeaderModel header) {
        HeaderModel updatedHeader = headerService.updateHeader(id, header);
        return new ResponseEntity<>(updatedHeader, HttpStatus.OK);
    }

    // Delete a header by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHeader(@PathVariable Long id) {
        headerService.deleteHeader(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

