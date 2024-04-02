package com.example.board.dto.response;
// Response 에 나오는 Code 를 미리 정리하기 위한 파일

import org.hibernate.Internal;

public interface ResponseCode {
    // 200 (OK)
    String SUCCESS = "SU";

    // 400 (Bad Request)
    String VALIDATION_FAILED = "VF";
     // 400 (Bad Request)
    String DUPLICATE_EMAIL = "DE";
    // 400 (Bad Request)
    String DUPLICATE_NICKNAME = "DN";
    // 400 (Bad Request)
    String DUPLICATE_TELEPHONE_NUMBER = "DT";
    // 400 (Bad Request)
    String NOT_EXIST_USER = "NU";
    // 400 (Bad Request)
    String NOT_EXIST_BOARD = "NB";
    
    // 401 (Unauthorized)
    String SIGN_IN_FAIL = "SF";
    // 401 (Unauthorized)
    String AUTHORIZATION_FAILED = "AF";
    
    // 403 (Forbidden)
    String NO_PERMISSION = "NP";
    
    // 500 (Internal Server Error)
    String DATABASE_ERROR = "DBE";
}
