package com.example.product.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Builder
@Data
@AllArgsConstructor
@Document
@Getter
@Setter
public class Product {




	//@Id
	//@GeneratedValue(strategy= GenerationStrategy.UNIQUE)
	//String id;

	@Id
	@Field
	String id;

	@NonNull
	@Field
	String sellerId;

	@NonNull
	@Field
	String title;

	@NonNull
	@Field
	String manufacturer;

	@NonNull
	@Field
	String isLowQuantity;

	@NonNull
	@Field
	String isSoldOut;

	@NonNull
	@Field
	String isBackorder;

	@NonNull
	@Field
	String requiresShipping;

	@NonNull
	@Field
	String isVisible;

	private Price price;

	/*
	@NonNull
	@Field
	String publishedAt;

	@NonNull
	@Field
	String createdAt;

	@NonNull
	@Field
	String updatedAt;

	@NonNull
	@Field
	String workflow;
*/
}