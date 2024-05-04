package com.developia.endproject.translateApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "translation")
@Data
public class Translate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
}
