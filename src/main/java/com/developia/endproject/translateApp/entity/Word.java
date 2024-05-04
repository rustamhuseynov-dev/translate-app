package com.developia.endproject.translateApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "words")
@Data
public class Word {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String word;
	private String language;
	private String translateWord;
	private String whoAddedTheWord;
	private String userComment;
}
