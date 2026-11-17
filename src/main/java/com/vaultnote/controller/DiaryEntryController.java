package com.vaultnote.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaultnote.entity.DiaryEntry;
import com.vaultnote.service.DiaryEntryService;

@RestController 
@RequestMapping("/api/diary") 
public class DiaryEntryController {

    private DiaryEntryService diaryEntryService;

    public DiaryEntryController(DiaryEntryService diaryEntryService){
        this.diaryEntryService = diaryEntryService;
    }

    //1. Create mapping

    @PostMapping
    public ResponseEntity<DiaryEntry> createEntry(@RequestBody DiaryEntry diaryEntry){
        DiaryEntry savedEntry = diaryEntryService.createEntry(diaryEntry);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntry);
    }

    //2. Read All mapping
    @GetMapping
    public ResponseEntity<List<DiaryEntry>> getAllEntries(){

        List<DiaryEntry> entries = diaryEntryService.getAllEntries();

        return ResponseEntity.ok(entries);
    }

    //3. Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<DiaryEntry> getEntryById(@PathVariable Long id){
        
        DiaryEntry entry = diaryEntryService.getEntryById(id);

        return ResponseEntity.ok(entry);
    }

    //4. Update Mapping
    @PutMapping("/{id}")
    public ResponseEntity<DiaryEntry> updateEntry(@PathVariable Long id, @RequestBody DiaryEntry diaryEntry){

        DiaryEntry updatedEntry = diaryEntryService.updateEntry(id, diaryEntry);

        return ResponseEntity.ok(updatedEntry);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id){
        
        diaryEntryService.deleteEntry(id);

        return ResponseEntity.noContent().build();

    }




}
