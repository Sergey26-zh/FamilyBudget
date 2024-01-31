package com.example.familybudget.controller.user;

import com.example.familybudget.dto.user.FamilyMemberDto;
import com.example.familybudget.dto.user.UpdateMemberDto;
import com.example.familybudget.exception.DataValidException;
import com.example.familybudget.service.FamilyMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/family-members")
@RequiredArgsConstructor
public class FamilyMemberController {

    private final FamilyMemberService familyMemberService;

    @PostMapping
    public FamilyMemberDto createFamilyMember(@RequestBody FamilyMemberDto familyMemberDto) {
        return familyMemberService.create(familyMemberDto);
    }

    @PutMapping("/{id}")
    public FamilyMemberDto updateFamilyMember(@RequestBody UpdateMemberDto updateMemberDto) {
        return familyMemberService.update(updateMemberDto);
    }

    @DeleteMapping("/{id}")
    public void deleteFamilyMember(@PathVariable long id) {
        familyMemberService.delete(id);
    }
}