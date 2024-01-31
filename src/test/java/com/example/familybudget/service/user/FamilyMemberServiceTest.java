package com.example.familybudget.service.user;

import com.example.familybudget.dto.user.FamilyMemberDto;
import com.example.familybudget.exception.DataValidException;
import com.example.familybudget.mapper.user.FamilyMemberMapper;
import com.example.familybudget.model.user.FamilyMember;
import com.example.familybudget.repository.user.FamilyMemberRepository;
import com.example.familybudget.service.user.FamilyMemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FamilyMemberServiceTest {
    @Mock
    private FamilyMemberMapper familyMemberMapper;

    @Mock
    private FamilyMemberRepository familyMemberRepository;

    @InjectMocks
    private FamilyMemberService familyMemberService;

    @Test
    public void createMember_correctTest() {
        FamilyMemberDto familyMemberDto = createMemberDto();
        FamilyMember familyMember = createMember();

        when(familyMemberRepository.save(any())).thenReturn(familyMember);
        when(familyMemberMapper.toDto(any())).thenReturn(familyMemberDto);
        when(familyMemberMapper.toEntity(any())).thenReturn(familyMember);

        FamilyMemberDto familyMemberDto1 = familyMemberService.create(familyMemberDto);

        assertEquals(familyMemberDto.getId(), familyMemberDto1.getId());
    }

    @Test
    public void createMember_exceptionTest() {
        FamilyMemberDto familyMemberDto = createMemberDto();

        when(familyMemberRepository.existsById(anyLong())).thenReturn(true);

        DataValidException dataValidException = assertThrows(DataValidException.class, () -> {
            familyMemberService.create(familyMemberDto);
        });

        assertEquals("Family member already exists", dataValidException.getMessage());
    }

    private FamilyMemberDto createMemberDto() {
        return FamilyMemberDto.builder().id(1L).firstName("Ivan").lastName("Ivanov").build();
    }

    private FamilyMember createMember() {
        return FamilyMember.builder().id(1L).firstName("Ivan").lastName("Ivanov").build();
    }
}