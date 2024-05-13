package com.example.spring_boot_project_02.repository;

import com.example.spring_boot_project_02.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
