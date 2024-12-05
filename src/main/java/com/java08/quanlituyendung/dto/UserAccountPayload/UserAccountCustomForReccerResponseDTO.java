package com.java08.quanlituyendung.dto.UserAccountPayload;


import com.java08.quanlituyendung.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccountCustomForReccerResponseDTO {
    private Long id;
    private String email;
    private String avatar;
    private String fullName;
    private String username;
    private Long reccerID;
    private Status status;
}
