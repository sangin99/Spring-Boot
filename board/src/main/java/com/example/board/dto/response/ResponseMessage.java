package com.example.board.dto.response;

public interface ResponseMessage {
    // 200 (OK)
    String SUCCESS = "Success.";
    
    // 400 (Bad Request)
    String VALIDATION_FAILED = "Validation failed.";
    // 400 (Bad Request)
    String DUPLICATE_EMAIL = "Duplicate email.";
    // 400 (Bad Request)
    String DUPLICATE_NICKNAME = "Duplicate nickname.";
    // 400 (Bad Request)
    String DUPLICATE_TELEPHONE_NUMBER = "Duplicate telephone number.";
    // 400 (Bad Request)
    String NOT_EXIST_USER = "This user does not exist.";
    // 400 (Bad Request)
    String NOT_EXIST_BOARD = "This board does not exist.";
    
    // 401 (Unauthorized)
    String SIGN_IN_FAIL = "Login information mismatch.";
    // 401 (Unauthorized)
    String AUTHORIZATION_FAILED = "Authorization Failed.";
    // 403 (Forbidden)
    String NO_PERMISSION = "Do not have permission.";
    
    // 500 (Internal Server Error)
    String DATABASE_ERROR = "Database error.";   
}
