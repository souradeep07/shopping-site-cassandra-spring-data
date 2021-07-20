package org.souradeep.shopping.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

	@Override
	protected String getKeyspaceName() {
		// TODO Auto-generated method stub
		return "shopping_site";
	}

	@Override
	protected String getContactPoints() {
		// TODO Auto-generated method stub
		return "10.113.144.205";
	}

	@Override
	protected int getPort() {
		return 9042;
	}

}
