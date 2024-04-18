package com.example.board.service.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.board.dto.request.user.PatchNicknameRequestDto;
import com.example.board.dto.response.ResponseDto;
import com.example.board.dto.response.user.GetUserResponseDto;
import com.example.board.entity.UserEntity;
import com.example.board.repository.UserRepository;
import com.example.board.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(String email) {
        
        try {
            // 1. User 테이블에서 email에 해당하는 유저 조회
            // SELECT * FROM user WHERE email = :email
            // findByEmail(email)
            // (email -> (조회 결과 인스턴스))
            UserEntity userEntity = userRepository.findByEmail(email);

            // 2. 조회 결과에 따라 반환 결정
            // 1) false 이면 존재하지 않는 유저 응답처리 x
            // 2) null 이면 존재하지 않는 유저 응답처리
            if (userEntity == null) return ResponseDto.notExistUser();        
                //? 지금처럼 안에 넣는 방법 말고 다른 방법은 `UserEntity userEntity = null`로 try{} 밖으로 뺴는 것이다

            // 3. 조회 결과 데이터를 성공 응답
            // String nickname = userEntity.getNickname();
            // String profileImage = userEntity.getProfile_image_url();
            // return GetUserResponseDto.success(email, nickname, profileImage);
            return GetUserResponseDto.success(userEntity);

        } catch (Exception exception) {
            // 1-1. 조회 처리 중 데이터베이스 관련 예외가 발생하면 데이터베이스 에러 응답처리
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

    }


    @Override
    public ResponseEntity<ResponseDto> patchNickname(PatchNicknameRequestDto dto) {
        
        try {

            String nickname = dto.getNickname();
            boolean isExistNickname = userRepository.existsByNickname(nickname);
            if (isExistNickname) return ResponseDto.duplicateNickname();
            
            String email = dto.getEmail();
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return ResponseDto.notExistUser();

            userEntity.setNickname(nickname);
            userRepository.save(userEntity);

            return ResponseDto.success();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

    }

}
