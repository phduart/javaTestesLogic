package br.com.projectSpringForTest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EmployeesDTO {

    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private List<EmployeeDTO> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<EmployeeDTO> getData() {
        return data;
    }

    public void setData(List<EmployeeDTO> data) {
        this.data = data;
    }
}
