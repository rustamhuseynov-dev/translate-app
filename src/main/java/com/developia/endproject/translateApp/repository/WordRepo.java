package com.developia.endproject.translateApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.developia.endproject.translateApp.entity.Word;

public interface WordRepo extends JpaRepository<Word, Integer> {

	@Query(value = "select * from words limit ?1,?2", nativeQuery = true)
	List<Word> findAllWordPagination(Integer b, Integer l);

	Optional<Word> findByWord(String word);

	Optional<Word> findByTranslateWord(String translateWord);

}
