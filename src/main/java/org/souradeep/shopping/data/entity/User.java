package org.souradeep.shopping.data.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Frozen;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.util.Pair;

import com.datastax.oss.driver.api.core.data.TupleValue;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Table
@Data
@AllArgsConstructor
public class User {
	@Id
	@Column(value = "id")
	private UUID id;
	@Column(value = "first_name")
	private String firstName;
	@Column(value = "last_name")
	private String lastName;
	@Column(value = "email")
	private String email;
	@Column(value = "cart")
	@CassandraType(type = Name.TUPLE, typeArguments = { Name.UUID, Name.INT })
	@Frozen
	@Getter(value = AccessLevel.NONE)
	private List<TupleValue> cart;

	public List<Pair<UUID, Integer>> getCart() {
		List<Pair<UUID, Integer>> cart = new ArrayList<>();
		for (TupleValue tuple : this.cart) {
			cart.add(Pair.of(tuple.getUuid(0), tuple.getInt(1)));
		}
		return cart;

	}
}
