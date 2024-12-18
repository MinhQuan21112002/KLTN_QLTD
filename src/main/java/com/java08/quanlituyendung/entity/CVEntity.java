package com.java08.quanlituyendung.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cv")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CVEntity extends BaseEntity {
    @Column(name = "url")
    private String url;
    @Column(name = "dateApply")
    private String dateApply;

    @Enumerated(EnumType.STRING)
    private State state;

    public enum State {
        INPROGRESS,
        APPROVED
    }
    // vai tro la ung vien nop cv
    @ManyToOne
    @JoinColumn(name = "user_account_id")
    @JsonIgnore
    private UserAccountEntity userAccountEntity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "job_posting_id")
    private JobPostingEntity jobPostingEntity;


}
