package com.vaultnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaultnote.entity.DiaryEntry;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, Long> {

}
