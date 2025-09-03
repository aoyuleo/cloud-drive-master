package com.cloudrive.common.exception;

import com.cloudrive.common.enums.ErrorCode;
import lombok.Getter;

/**
 * 业务异常类
 */
@Getter
public class BusinessException extends RuntimeException {

    private final Integer code; //业务错误码

    // 构造函数1：仅消息
    public BusinessException(String message) {
        this(40000, message);
    }

    // 构造函数2：码 + 消息
    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    // 构造函数3：错误码枚举
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode(); // 使用枚举中的HttpStatus作为错误码
    }

    /**
     * 支持异常链（推荐用于包装底层异常）
     */
    public BusinessException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.code = errorCode.getCode();
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
} 