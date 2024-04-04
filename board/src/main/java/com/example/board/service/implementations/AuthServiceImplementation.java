package com.example.board.service.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.board.dto.request.auth.SignUpRequestDto;
import com.example.board.dto.response.ResponseDto;
import com.example.board.entity.UserEntity;
import com.example.board.repository.UserRepository;
import com.example.board.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor  //userRepository에 관해 의존성 주입
public class AuthServiceImplementation implements AuthService {

    private final UserRepository userRepository; // 유저조희를 위해 UserRepository 를 받아온다

    @Override
    public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) {
        
        try {
            
            // 1. 입력받은 이메일이 유저 테이블에 존재하는지 조회
            // email -> (true , false)
            String email = dto.getEmail();
            boolean isExistEmail = userRepository.existsByEmail(email);
            // 1-1. 1에 대한 조회 결과가 true : 중복된 이메일 응답 처리
            if (isExistEmail) ResponseDto.duplicateEmail();

            // 2. 입력받은 닉네임이 유저 테이블에 존재하는지 조회
            // nickName -> (true , false)
            String nickName = dto.getNickname();
            boolean isExistNickname = userRepository.existsByNickname(nickName);
            // 2-1. 2에 대한 조회 결과가 true : 중복된 닉네임 응답 처리
            if (isExistNickname) ResponseDto.duplicateNickname();

            // 3. 입력받은 휴대전화번호가 유저 테이블에 존재하는지 조회
            // telNumber -> (true , false)
            String telePhoneNumber = dto.getTelNumber();
            boolean isExistTelePhoneNumber = userRepository.existsByTelNumber(telePhoneNumber);
            // 3-1. 3에 대한 조회 결과가 true : 중복된 휴대전화번호 응답 처리
            if (isExistTelePhoneNumber) ResponseDto.duplicateTelephoneNumber();

            // 4. 유저 레코드 삽입
            // 4-1. 유저 엔터티의 인스턴스 생성
            // (dto) -> userEntity 인스턴스
            UserEntity userEntity = new UserEntity(dto);
            // 4-2. 유저 엔터티 인스턴스 저장(Save)
            userRepository.save(userEntity);
            
            // 5. 성공 응답 처리
            return ResponseDto.success();

            
        } catch (Exception exception) {
        // 데이터베이스 작업 중에 발생하는 예외 데이터베이스 예외 처리
        exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
    
}
