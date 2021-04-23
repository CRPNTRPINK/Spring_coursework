package com.example.courseWork.api;

import com.example.courseWork.models.Phone;
import com.example.courseWork.repo.PhoneRepository;
import com.example.courseWork.service.CategoryService;
import com.example.courseWork.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/phone", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PhoneRestController {

    @Autowired
    PhoneService phoneService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    PhoneRepository phoneRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<Phone>> getAllPhones(){
        List<Phone> allPhones = phoneService.getAllPhones();
        if (allPhones == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(allPhones, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Phone>> getPhone(@PathVariable Long id){
        if (id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Phone> phone = phoneService.getPhone(id);
        return new ResponseEntity<Optional<Phone>>(phone, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> setPhone(@RequestBody @Valid Phone phone){
        if (phone.getId() != 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!categoryService.existsCategory(phone.getCategory().getId())){
            return new ResponseEntity<>("Id is not found or phone doesn't exists", HttpStatus.BAD_REQUEST);
        }
        phone.setId(-1);
        phoneService.addPhone(phone);
        return new ResponseEntity<>(phone, HttpStatus.CREATED);
    }

    @PutMapping(value = "")
    public ResponseEntity<?> updatePhone(@RequestBody @Valid Phone phone){
        if (phone == null || !categoryService.existsCategory(phone.getCategory().getId())){
            return new ResponseEntity<>("Id is not found or phone doesn't exists", HttpStatus.BAD_REQUEST);
        }
        phoneService.addPhone(phone);
        return new ResponseEntity<>(phone, HttpStatus.UPGRADE_REQUIRED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> removePhone(@PathVariable Long id){
        if (id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        phoneService.removePhone(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
