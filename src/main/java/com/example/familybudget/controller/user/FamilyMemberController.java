package com.example.familybudget.controller.user;

import com.example.familybudget.dto.user.FamilyMemberDto;
import com.example.familybudget.dto.user.UpdateMemberDto;
import com.example.familybudget.service.user.FamilyMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/family-members")
@RequiredArgsConstructor
public class FamilyMemberController {

    private final FamilyMemberService familyMemberService;

    @PostMapping
    public FamilyMemberDto createFamilyMember(FamilyMemberDto familyMemberDto) {
        return familyMemberService.create(familyMemberDto);
    }

    @PutMapping("/{id}")
    public FamilyMemberDto updateFamilyMember(@RequestBody UpdateMemberDto updateMemberDto) {
        return familyMemberService.update(updateMemberDto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteFamilyMember(@PathVariable long id) {
        return familyMemberService.delete(id);
    }
}