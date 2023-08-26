package com.fullstackapp.springbootrestapi.controller;

import com.fullstackapp.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

//    // http://localhost:8080/student
//    @GetMapping("student")
//    public Student getStudent(){
//        Student student = new Student(
//            1,
//            "Amy",
//            "Thomas"
//        );
//        return student;  // returned to the response body
//    }

    // using the ResponseEntity class(Generic class)
    // Webを支える技術p.78
    @GetMapping
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
            1,
            "Amy",
            "Thomas"
        );
//        return new ResponseEntity<>(student, HttpStatus.OK);
//        return ResponseEntity.ok(student);
        return ResponseEntity.ok()
                .header("custom-header", "remesh")
                .body(student);
    }


    // http://localhost:8080/students
//    @GetMapping("students")
//    public List<Student> getStudents(){
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(1, "Jun", "Kato"));
//        students.add(new Student(2, "Ran", "Shiba"));
//        students.add(new Student(3, "Moe", "Ando"));
//
//        return students;
//    }

    // // http://localhost:8080/student/students
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Jun", "Kato"));
        students.add(new Student(2, "Ran", "Shiba"));
        students.add(new Student(3, "Moe", "Ando"));

//        return new ResponseEntity<>(students, HttpStatus.OK);
        return ResponseEntity.ok(students);
    }


    // Spring boot REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/student/1
    @GetMapping("{id}")
    public Student studentPathVariable(@PathVariable int id){
        return new Student(id, "John", "Davis");
    }

//    public Student studentPathVariable(@PathVariable("id") int studentId){
//        return new Student(studentId, "John", "Davis");
//    }

    // http://localhost:8080/student/10/ken/yamazaki
//    @GetMapping("student/{id}/{first-name}/{last-name}")
//    public Student studentPathVariable(@PathVariable int id,
//                                       @PathVariable("first-name") String firstName,
//                                       @PathVariable("last-name") String lastName){
//        return new Student(id, firstName, lastName);
//    }

    @GetMapping("{id}/{first-name}/{last-name}")
    public  ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                                        @PathVariable("first-name") String firstName,
                                                        @PathVariable("last-name") String lastName){
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API with Request Param
    // http:/localhost:8080/student/query?id=1
//    @GetMapping("student/query")
//    public Student studentRequestVariable(@RequestParam int id){
//        return new Student(id, "Harry", "Rice");
//    }

    // http://localhost:8080/student/query?id=1&firstName=John&lastName=Styles
//    @GetMapping("student/query")
//    public Student studentRequestVariable(@RequestParam int id,
//                                          @RequestParam String firstName,
//                                          @RequestParam String lastName){
//        return new Student(id, firstName, lastName);
//    }

    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                                         @RequestParam String firstName,
                                                         @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }


    // Spring boot REST API that handles HTTP POST request - updating new resource
    // @PostMapping and @RequestBody
//    @PostMapping("students/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Student createStudent(@RequestBody Student student){
//        System.out.println(student.getId());
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());
//        return student;
//    }

    @PostMapping("create")
    public ResponseEntity<Student> crateStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

//    // Spring boot REST API that handles HTTP PUT request - updating existing resource
//    @PutMapping("students/{id}/update")
//    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
//        System.out.println(studentId);
//        System.out.println(student.getId());
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());
//        return student;
//    }

    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(studentId);
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
return ResponseEntity.ok(student);
    }


    // Spring boot REST API that handles HTTP DELETE request - deleting existing resource
//    @DeleteMapping("students/{id}/delete")
//    public String deleteStudent(@PathVariable("id") int studentId){
//        System.out.println(studentId);
//        return "Student deleted successfully";
//    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        System.out.println(id);
        return ResponseEntity.ok("Successfully deleted");
    }
}
