package com.example.spring_boot_project_02.repository;

import com.example.spring_boot_project_02.entity.Memo;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class MemoRepositoryTest {
    @Autowired
    private MemoRepository memoRepository;

    @Test
    public void testClass() {
        log.info(memoRepository.getClass().getName());
    }

    @Test
    public void testSelect() {
        // 데이터베이스에 존재하는 mno
        Long mno = 100L;

        Optional<Memo> optionalMemo = memoRepository.findById(mno);
        log.info("======");
        if (optionalMemo.isPresent()) {
            Memo memo = optionalMemo.get();
            log.info(memo);
        }
    }

    @Test
    @Transactional
    public void testSelect2() {
        // 데이터베이스에 존재하는 mno
        Long mno = 100L;

        Memo memo = memoRepository.getOne(mno);
        log.info("=======");
        log.info(memo);
    }

    @Test
    public void testPageDefault() {
        // 1페이지 10개
        Pageable pageable = (Pageable) PageRequest.of(0, 10);
        Page<Memo> memoPage = memoRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        log.info(memoPage);
        log.info("---------");
        log.info("Total Pages : " + memoPage.getTotalPages()); // 총 몇개 페이지
        log.info("Total Count : " + memoPage.getTotalElements()); // 전체 개수
        log.info("Page Number : " + memoPage.getNumber()); // 현재 페이지 번호. 0부터 시작
        log.info("Page Size : " + memoPage.getSize()); // 페이지당 데이터 수
        log.info("has Next page? : " + memoPage.hasNext()); // 다음 페이지
        log.info("first page? : " + memoPage.isFirst()); // 시작 페이지(0) 여부

        log.info("------------------");
        for (Memo memo : memoPage.getContent()) {
            log.info(memo);
        }
    }

}






































