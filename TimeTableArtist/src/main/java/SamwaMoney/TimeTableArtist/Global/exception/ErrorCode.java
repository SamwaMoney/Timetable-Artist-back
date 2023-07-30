package SamwaMoney.TimeTableArtist.Global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    CONVERT_MULTIPARTFILE_ERROR(HttpStatus.BAD_REQUEST, "MultipartFile을 File로 전환하는 것에 실패했습니다.");

    private final HttpStatus status;
    private final String message;
}
