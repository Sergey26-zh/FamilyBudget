package com.example.familybudget.service.user;

import com.example.familybudget.dto.user.FamilyMemberDto;
import com.example.familybudget.dto.user.UpdateMemberDto;
import com.example.familybudget.exception.DataValidException;
import com.example.familybudget.mapper.user.FamilyMemberMapper;
import com.example.familybudget.model.user.FamilyMember;
import com.example.familybudget.repository.user.FamilyMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FamilyMemberService {
    private final FamilyMemberRepository familyMemberRepository;
    private final FamilyMemberMapper familyMemberMapper;

    @Transactional
    public FamilyMemberDto create(FamilyMemberDto familyMemberDto) {
        if (familyMemberDto.getId() == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        FamilyMember familyMember = familyMemberRepository.save(familyMemberMapper.toEntity(familyMemberDto));
        return familyMemberMapper.toDto(familyMember);
    }

    @Transactional
    public FamilyMemberDto update(UpdateMemberDto updateMemberDto) {
        FamilyMember familyMember = validMember(updateMemberDto.getId());

        familyMember.setFirstName(updateMemberDto.getFirstName());
        familyMember.setLastName(updateMemberDto.getLastName());

        return familyMemberMapper.toDto(familyMemberRepository.save(familyMember));
    }

    @Transactional
    public boolean delete(long memberId) {
        FamilyMember familyMember = validMember(memberId);
        familyMemberRepository.deleteById(familyMember.getId());
        return true;
    }

    private FamilyMember validMember(long id) {
        return familyMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Family member not found"));
    }
}
