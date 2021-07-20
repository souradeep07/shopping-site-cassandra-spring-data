package org.souradeep.shopping.data.entity;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table
@Data
@AllArgsConstructor
public class Product {
	@Id
	@Column(value = "id")
	private UUID id;
	@Column(value = "name")
	private String name;
	@Column(value = "category")
	private String category;
	@Column(value = "description")
	private String description;
	@Column(value = "price")
	private Integer price;
	@Column(value = "date_added")
	private Timestamp dateAdded;
	@Column(value = "date_modified")
	private Timestamp dateModified;
	@Column(value = "items_left")
	private Integer itemsLeft;
}
