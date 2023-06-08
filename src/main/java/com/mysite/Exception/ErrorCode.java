package com.mysite.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND(404, "COMMON-ERR-404", "페이지가 작동하지 않습니다."),
    BAD_REQUEST(400, "COMMON-ERR-400", "잘못된 경로입니다."),
    INTER_SERVER_ERROR(500, "COMMON-ERR-500", "해당 ID가 존재하지 않습니다.");

    private int status;
    private String errorCode;
    private String message;
}
