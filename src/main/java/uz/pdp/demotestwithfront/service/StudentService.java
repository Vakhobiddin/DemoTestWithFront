package uz.pdp.demotestwithfront.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.demotestwithfront.entity.ApiResponse;
import uz.pdp.demotestwithfront.entity.Student;
import uz.pdp.demotestwithfront.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public ApiResponse getAllList(){
        List<Student> all = studentRepository.findAll();
        return new ApiResponse("All student list",true,all);

    }

    public ApiResponse getOneById(Integer id){
        Optional<Student> byId = studentRepository.findById(id);
        if (!byId.isPresent()){
            return new ApiResponse("This id not fount",false);
        }

        Student student = byId.get();
        return new ApiResponse("Fount",true,student);
    }

    public ApiResponse AddStudent(Student studentDto){
        Student student = new Student();

        student.setName(studentDto.getName());
        student.setLastName(studentDto.getLastName());
        student.setAge(studentDto.getAge());

        studentRepository.save(student);

        return new ApiResponse("Success",true);
    }

    public ApiResponse editStudent(Integer id,Student student){
        Optional<Student> byId = studentRepository.findById(id);
        if (!byId.isPresent()){
            return new ApiResponse("error occured",false);
        }
        Student editingStudent = byId.get();

        editingStudent.setName(student.getName());
        editingStudent.setLastName(student.getLastName());
        editingStudent.setAge(student.getAge());

        studentRepository.save(editingStudent);
        return new ApiResponse("SUCCESS",true);

    }

    public String test(){
        return "this is test for only";
    }
}
