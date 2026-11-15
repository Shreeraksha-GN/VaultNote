package com.vaultnote.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vaultnote.entity.DiaryEntry;
import com.vaultnote.repository.DiaryEntryRepository;

@Service 
public class DiaryEntryService {

    public DiaryEntryRepository diaryEntryRepository;
    
    public DiaryEntryService(DiaryEntryRepository diaryEntryRepository){
        this.diaryEntryRepository = diaryEntryRepository;
    }

    // 1. Create
    public DiaryEntry createEntry(DiaryEntry diaryEntry){
        return diaryEntryRepository.save(diaryEntry);
    }

    //2. Read All
    public List<DiaryEntry> getAllEntries(){
        return diaryEntryRepository.findAll();
    }

    //3. Read by Id
    public DiaryEntry getEntryById(Long Id){
        return diaryEntryRepository.findById(Id)
            .orElseThrow(()-> new RuntimeException("Diary Entry not found with id:"+Id));
    }


    //4. Update
    public DiaryEntry updateEntry(Long id, DiaryEntry updatedEntry){
        
        DiaryEntry existingEntry = new DiaryEntry();

        existingEntry.setTitle(updatedEntry.getTitle());
        existingEntry.setContent(updatedEntry.getContent());

        return diaryEntryRepository.save(existingEntry);
    }

    //5. Delete
    public void deleteEntry(Long id){

        DiaryEntry existingEntry = getEntryById(id);

        diaryEntryRepository.delete(existingEntry);
    }
}
