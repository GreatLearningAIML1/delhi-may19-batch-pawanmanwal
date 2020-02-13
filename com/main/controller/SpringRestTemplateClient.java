package com.main.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.main.model.Employee;

public class SpringRestTemplateClient
{
    public static final String REST_BASE_URI = "http://localhost:9090/SpringRestHibernate";
   
    static RestTemplate restTemplate = new RestTemplate();
    
    /**POST**/
    public static void createStudent()
    {
        Employee student = new Employee();
//        student.setId(5);
        student.setJobTitle("JIP");
        student.setFirstName("fname");
        student.setLastName("lname");
        student.setStartDate(new Date(2019,1,1));
        student.setEndDate(new Date(2021,1,1));
//        student.setStartDate(new Date(2019,01,01));
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        
        HttpEntity<Employee> entity = new HttpEntity<>(student,headers);
        String resp = restTemplate.postForObject(REST_BASE_URI+"/create", entity,String.class);
        System.out.println(resp);
    }
    
    /**GET**/
    private static void getStudent(int id)
    {
        Employee student = restTemplate.getForObject(REST_BASE_URI+"/employee/"+id+"/2019-03-17/2019-03-17", Employee.class);
        System.out.println("**** Student with id : "+id+"****");
        System.out.println(student.toString());
    }
    public static void getAllStudents()
    {

        List<Map<String, Object>> studentList = restTemplate.getForObject(REST_BASE_URI + "/students", List.class);
        if (studentList != null)
        {
            System.out.println("**** All Students ****");
            for (Map<String, Object> map : studentList)
            {
                System.out.println("Id : id=" + map.get("id") + "   Name=" + map.get("name") + "   Age="
                        + map.get("age"));
            }
        } else
        {
            System.out.println("No Students exist!!");
        }
    }
    
    /**PUT**/
//    public static void updateStudent()
//    {
//        Employee student = new Employee();
//        student.setId(5);
//        student.setName("JIP55");
//        student.setAge(55);
//        
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        
//        HttpEntity<Employee> entity = new HttpEntity<>(student,headers);
//        
//        restTemplate.put(REST_BASE_URI + "/update", entity,Employee.class);
//    }
    
    /**DELETE**/
    public static void deleteStudent(int id)
    {
        restTemplate.delete(REST_BASE_URI + "/delete/"+id);
    }
    public static void main(String args[])
    {
        createStudent();
        
        //getAllStudents();
        //getStudent(2);
        
       // updateStudent();
        
       // deleteStudent(5);
    }
}
