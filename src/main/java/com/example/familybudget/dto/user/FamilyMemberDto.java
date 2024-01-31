package com.example.familybudget.dto.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FamilyMemberDto {
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
