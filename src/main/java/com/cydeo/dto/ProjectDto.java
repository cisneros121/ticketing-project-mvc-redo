package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectDto {

    private String projectName;
    private String projectCode;
    private UserDto manager;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate endDate;
    private String projectDetail;
    private Status projectStatus;

    private int completeTaskCounts;
    private int unfinishedTaskCounts;

    public ProjectDto(String projectName, String projectCode, UserDto manager, LocalDate startDate, LocalDate endDate, String projectDetail, Status projectStatus) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.manager = manager;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectDetail = projectDetail;
        this.projectStatus = projectStatus;
    }
}
