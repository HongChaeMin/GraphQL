package com.example.graphql;

import com.example.graphql.graphql.MemberMutation;
import com.example.graphql.graphql.MemberQuery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MemberMutation.class, MemberQuery.class})
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

}
