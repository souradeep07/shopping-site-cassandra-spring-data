package org.souradeep.shopping.data.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.util.Pair;

import com.datastax.oss.driver.api.core.data.TupleValue;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.core.type.TupleType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
	@Getter(value = AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)
	private List<TupleValue> cart;

	public List<Pair<UUID, Integer>> getCart() {
		List<Pair<UUID, Integer>> cartPair = new ArrayList<>();
		for (TupleValue tuple : this.cart) {
			cartPair.add(Pair.of(tuple.getUuid(0), tuple.getInt(1)));
		}
		return cartPair;
	}

	public void setCart(List<Pair<UUID, Integer>> cart) {
		TupleType dt = DataTypes.tupleOf(DataTypes.UUID, DataTypes.INT);
		this.cart = new ArrayList<>();
		for (Pair<UUID, Integer> pair : cart) {
			TupleValue tuple = dt.newValue();
			tuple.setUuid(0, pair.getFirst());
			tuple.setInt(1, pair.getSecond());
			this.cart.add(tuple);
		}
	}

	public void addToCart(Pair<UUID, Integer> pair) {
		for (TupleValue t : this.cart) {
			if (t.getUuid(0).equals(pair.getFirst())) {
				t.setInt(1, t.getInt(1) + pair.getSecond());
				return;
			}
		}
		TupleType dt = DataTypes.tupleOf(DataTypes.UUID, DataTypes.INT);
		TupleValue tuple = dt.newValue();
		tuple.setUuid(0, pair.getFirst());
		tuple.setInt(1, pair.getSecond());
		this.cart.add(tuple);
	}

	public void addToCart(UUID id, Integer count) {
		for (TupleValue t : this.cart) {
			if (t.getUuid(0).equals(id)) {
				t.setInt(1, t.getInt(1) + count);
				return;
			}
		}
		TupleType dt = DataTypes.tupleOf(DataTypes.UUID, DataTypes.INT);
		TupleValue tuple = dt.newValue();
		tuple.setUuid(0, id);
		tuple.setInt(1, count);
		this.cart.add(tuple);
	}

}
