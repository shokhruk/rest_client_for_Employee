package org.example;

import org.example.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/api/employees";

    public List<Employees> showAllEmployees() {

        ResponseEntity<List<Employees>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Employees>>() {
                        });
        List<Employees> allEmployees = responseEntity.getBody();

        return allEmployees;
    }

    public Employees getEmployeeById(int id) {
        String URL = "http://localhost:8080/api/employees/" + id;
        Employees employee = restTemplate.getForObject(URL, Employees.class);
        return employee;
    }

    public void saveEmployee(Employees employee) {
        int id = employee.getId();
        if (id == 0) {
            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(URL, employee, String.class);
        } else {
            restTemplate.put(URL, employee);
        }
    }

    public void deleteEmployeeById(int id) {
        String URL = "http://localhost:8080/api/employees/" + id;
        restTemplate.delete(URL);
    }
}
