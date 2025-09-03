package com.cloudrive.common.enums;

import lombok.Getter;

/**
 * 错误码枚举
 * code: 业务错误码（前端可识别、可做 switch 判断）
 * httpStatus: HTTP 状态码（用于响应状态头）
 * message: 用户提示消息（可国际化）
 */
@Getter
public enum ErrorCode {
    // ---------- 文件相关 ----------
    FILE_NOT_FOUND(10404, 404, "文件不存在"),
    SHARE_NOT_FOUND(10404, 404, "分享链接不存在"),
    USER_NOT_FOUND(10404, 404, "用户不存在"),

    // ---------- 分享过期 ----------
    SHARE_EXPIRED(10410, 403, "分享链接已过期"), // 改为 403

    // ---------- 认证 ----------
    INVALID_TOKEN(10401, 401, "无效的访问令牌"),
    INVALID_PASSWORD(10401, 401, "密码错误"),
    USER_NOT_LOGGED_IN(10401, 401, "用户未登录"),
    MISSING_PASSWORD(10401, 401, "请提供访问密码"),

    // ---------- 邮件 ----------
    EMAIL_EXISTS(141004, 400, "邮箱已被注册"), // 统一命名
    VERIFICATION_CODE_ERROR(141005, 400, "验证码错误或已过期"),
    EMAIL_SEND_ERROR(141006, 400, "邮件发送失败"),

    // ---------- 权限 ----------
    NO_PERMISSION(10403, 403, "无权访问此文件"),
    NO_SHARE_PERMISSION(10403, 403, "无权分享此文件"),
    NO_CANCEL_PERMISSION(10403, 403, "无权取消此分享"),

    // ---------- 业务规则 ----------
    FOLDER_NOT_EMPTY(10400, 400, "文件夹不为空，无法删除"),
    CANNOT_DOWNLOAD_FOLDER(10400, 400, "不能下载文件夹"),
    INVALID_FILENAME(10400, 400, "新文件名不能为空"),
    USERNAME_EXISTS(10400, 400, "用户名已存在"),
    ACCOUNT_DISABLED(10400, 400, "账号已被禁用"),
    FILE_TOO_LARGE(10413, 413, "文件过大，超出上传限制"),

    // ---------- 系统/OSS ----------
    OSS_DISABLED(1503, 503, "OSS存储服务未启用"),
    OSS_UPLOAD_FAILED(1500, 500, "文件上传到OSS失败"),
    OSS_DOWNLOAD_FAILED(1500, 500, "从OSS下载文件失败"),
    OSS_DELETE_FAILED(1500, 500, "从OSS删除文件失败"),
    FILE_DELETE_FAILED(1500, 500, "文件删除失败"),
    FILE_UPLOAD_FAILED(1500, 500, "文件上传失败"),
    FILE_DOWNLOAD_FAILED(1500, 500, "文件下载失败"),
    SYSTEM_ERROR(1500, 500, "系统错误");

    private final Integer code;
    private final Integer httpStatus;
    private final String message;

    ErrorCode(Integer code, Integer httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    /**
     * 根据业务错误码查找枚举
     */
    public static ErrorCode getByCode(Integer code) {
        for (ErrorCode ec : values()) {
            if (ec.getCode().equals(code)) {
                return ec;
            }
        }
        return SYSTEM_ERROR;
    }
}