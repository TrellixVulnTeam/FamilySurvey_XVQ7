package com.netlink.Controller;

import com.netlink.Model.OwnerInfo;
import com.netlink.Service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    FormService service;

    /**
     * This method will save the save from Survey component
     * @return ResponseEntity
     */
    @PostMapping("/save")
    public ResponseEntity<Boolean> save(@RequestBody OwnerInfo survey){
        Boolean resp = service.saveSurvey(survey);
        return new ResponseEntity<>(resp, HttpStatus.CREATED);
    }

    /**
     * This method will update the data from survey compnent
     * @return ResponseEntity
     */
    @PutMapping("/update")
    public ResponseEntity<Boolean> update(@RequestBody OwnerInfo survey){
        Boolean resp = service.saveSurvey(survey);
        return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
    }

    /**
     * This method will show the data in list component
     * @return ResponseEntity
     */
    @GetMapping("/showData")
    public  ResponseEntity<List<OwnerInfo>> showData(){
        List<OwnerInfo> list = service.showData();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    /**
     * This method will delete the member from survey component
     * @return ResponseEntity
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.DELETE)
    @DeleteMapping("/deleteMember/{id}")
    public ResponseEntity<Boolean> deleteMember(@PathVariable("id") Long id){
        Boolean resp = service.removeMember(id);
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }
}
