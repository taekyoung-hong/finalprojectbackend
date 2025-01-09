package com.ict.finalspringboot.domain.notice.controller;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ict.finalspringboot.common.util.FileUploadController;
import com.ict.finalspringboot.domain.auth.vo.DataVO;
import com.ict.finalspringboot.domain.notice.service.NoticeService;
import com.ict.finalspringboot.domain.notice.vo.NoticeVO;

@RestController
@RequestMapping("/api/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/list")
    public DataVO noticeList() {
        DataVO dataVO = new DataVO();
        try {
            List<NoticeVO> list = noticeService.noticeList();

            // 리스트가 null일 경우 빈 리스트로 초기화
            if (list == null) {
                list = new ArrayList<>(); // 빈 리스트로 초기화
            }
            dataVO.setSuccess(true);
            dataVO.setMessage("약국 조회 성공");
            dataVO.setData(list);

        } catch (Exception e) {
            dataVO.setSuccess(false);
            dataVO.setMessage("약국 조회 실패");
            e.getStackTrace();
        }

        return dataVO;
    }

    @PostMapping("/write")
    public DataVO writeNotice(@RequestParam("file") MultipartFile file, @ModelAttribute NoticeVO nvo) {
        DataVO dvo = new DataVO();
        try {
            // 파일 업로드를 했을 때
            if (file != null && file.getSize() > 0) {
                FileUploadController fileUploadController = new FileUploadController(file, "notice");
                DataVO uploadResult = fileUploadController.FileUpload();

                if (uploadResult.isSuccess()) {
                    nvo.setNotice_file_name(uploadResult.getData().toString());
                    nvo.setNotice_file("http://localhost:8080/api/notice/" + uploadResult.getData().toString());
                } else {
                    return uploadResult; // 업로드 실패 시 결과 반환
                }
            }

            if (noticeService.getNoticeWrite(nvo) > 0) {
                dvo.setSuccess(true);
                dvo.setMessage("작성 완료");
            } else {
                dvo.setSuccess(false);
                dvo.setMessage("작성 실패");
                dvo.setData(nvo);
            }
        } catch (Exception e) {
            dvo.setSuccess(false);
            dvo.setMessage("서버 오류: " + e.getMessage());
            // 로그에 예외 스택 트레이스를 남깁니다.
            e.printStackTrace();
        }

        return dvo;
    }
    // upload 기본 경로


    @Value("${file.upload-dir}")
    private String uploadDir;

    // uploadpath는 업로드된 경로(notice, user, qna, comment 등등)
    @GetMapping("/{uploadpath}/{filename}")
    public ResponseEntity<FileSystemResource> downloadFile(@PathVariable String uploadpath,
            @PathVariable String filename) {
        // 경로 설정
        File file = new File((uploadDir + "/" + uploadpath), filename);

        // 파일이 존재하는지 확인
        if (!file.exists()) {
            // 없으면 404 오류 리턴
            return ResponseEntity.notFound().build();
        }

        FileSystemResource resource = new FileSystemResource(file);

        // HTTP 헤더에 들어가기 때문에 utf-8 인코딩이 필요
        String encodedFilename;

        try {
            encodedFilename = URLEncoder.encode(filename, StandardCharsets.UTF_8.toString());
        } catch (Exception e) {
            // 인코딩 실패 시 기본 파일 이름 사용
            encodedFilename = filename;
        }

        // http 응답을 생성하는 responseentity 빌더를 사용해 http 상태를 200으로 설정한다.
        // header에 content-disposition을 설정하며 attachment; filename="filename" 을 사용하여
        // 브라우저가 파일을 다운로드 하도록 지시한다.
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + encodedFilename + "\"")
                .body(resource);
    }
}
