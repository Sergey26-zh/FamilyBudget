package com.example.familybudget.mapper.user;

import com.example.familybudget.dto.user.FamilyMemberDto;
import com.example.familybudget.model.user.FamilyMember;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FamilyMemberMapper {
    FamilyMember toEntity(FamilyMemberDto familyMemberDto);
    FamilyMemberDto toDto(FamilyMember familyMember);
}
