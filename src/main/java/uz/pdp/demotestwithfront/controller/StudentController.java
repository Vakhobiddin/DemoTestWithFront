package uz.pdp.demotestwithfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.demotestwithfront.entity.ApiResponse;
import uz.pdp.demotestwithfront.entity.Student;
import uz.pdp.demotestwithfront.service.StudentService;

@RestController

public class StudentController {
    @Autowired
    StudentService studentService;


    @GetMapping("/api")
    public String test(){
        return studentService.test();
    }

    @GetMapping("/getAll")
    public HttpEntity<?>  getAll(){
        ApiResponse list = studentService.getAllList();
       return ResponseEntity.status(list.isSuccess()?200:404).body(list);
    }

    @GetMapping("/getOne/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id){
        ApiResponse oneById = studentService.getOneById(id);
        return ResponseEntity.status(oneById.isSuccess()?200:404).body(oneById);
    }

    @PostMapping("/secondPage/addStudent") /// add method bu
    public HttpEntity<?> addStudent(@RequestBody Student student){
        ApiResponse apiResponse = studentService.AddStudent(student);

        return ResponseEntity.status(apiResponse.isSuccess() ? 200:404).body(apiResponse);
    }

    @PutMapping("/editStudent/{id}")
    public HttpEntity<?> editStudent(@PathVariable Integer id, @RequestBody Student student){
        ApiResponse apiResponse = studentService.editStudent(id, student);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200: 404).body(apiResponse);
    }



}
