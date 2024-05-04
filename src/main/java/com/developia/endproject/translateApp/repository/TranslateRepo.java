package com.developia.endproject.translateApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developia.endproject.translateApp.entity.Translate;

public interface TranslateRepo extends JpaRepository<Translate, Integer> {

}
