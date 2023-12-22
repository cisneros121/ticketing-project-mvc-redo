package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {
    private Long id; // needed a unique ID so created this for primary key for db
    private ProjectDto project;
    private UserDto employee;
    private String taskSubject;
    private String taskDetail;
    private Status taskStatus;
    private LocalDate assignedDate;


    public TaskDto(ProjectDto project, UserDto employee, String taskSubject, String taskDetail, Status taskStatus, LocalDate assignedDate) { // postgress is doing id
        this.project = project;
        this.employee = employee;
        this.taskSubject = taskSubject;
        this.taskDetail = taskDetail;
        this.taskStatus = taskStatus;
        this.assignedDate = assignedDate;
        this.id= UUID.randomUUID().getLeastSignificantBits(); // randomly assigned
    }
}
