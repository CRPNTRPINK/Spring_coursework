package com.example.courseWork.api;

import com.example.courseWork.exception_handling.NoSuchException;
import com.example.courseWork.models.Manufacturer;
import com.example.courseWork.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/manufacturer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ManufacturerRestController {
    @Autowired
    ManufacturerService manufacturerService;

    @GetMapping(value = "")
    public ResponseEntity<?> getAllManufacturer(){
        List<Manufacturer> allManufacturer = manufacturerService.getAllManufacturer();
        return new ResponseEntity<>(allManufacturer, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getManufacturer(@PathVariable long id){
        Optional<Manufacturer> manufacturer = manufacturerService.getManufacturer(id);
        if (manufacturer.isEmpty()){
            throw new NoSuchException("There is no category with ID = " + id + " in database");
        }
        return new ResponseEntity<>(manufacturer, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> setManufacturer(@RequestBody @Valid Manufacturer manufacturer){
        if (manufacturer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        manufacturerService.addManufacturer(manufacturer);
        return new ResponseEntity<>(manufacturer, HttpStatus.CREATED);
    }

    @PutMapping(value = "")
    public ResponseEntity<Manufacturer> updateManufacturer(@RequestBody @Valid Manufacturer manufacturer){
        if (manufacturer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        manufacturerService.addManufacturer(manufacturer);
        return new ResponseEntity<>(manufacturer, HttpStatus.UPGRADE_REQUIRED);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Manufacturer> removeManufacturer(@PathVariable Long id){
        if (id == null) {
            throw new NoSuchException("No id");
        }
        if (!manufacturerService.existsManufacturer(id)){
            throw new NoSuchException("There is no category with ID = " + id + " in database");
        }
        manufacturerService.removeManufacturer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
