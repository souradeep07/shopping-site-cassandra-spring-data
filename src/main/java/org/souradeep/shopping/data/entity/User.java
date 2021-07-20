package org.souradeep.shopping.data.entity;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.oss.driver.api.core.data.TupleValue;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table
@Data
@AllArgsConstructor
public class User {
	@Id
	@Column(value = "id")
	private UUID id;
	@Column(value = "first_name")
	private String firstName;
	@Column(value = "first_name")
	private String lastName;
	@Column(value = "email")
	private String email;
	@Column(value = "cart")
	private List<TupleValue> cart;
}
