package com.java08.quanlituyendung.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalendarAddRequestDTO {
    private String summary;
    private String description;
    private String startTime;
    private String endTime;
    private List<String> attendees;
    private String token;
}
