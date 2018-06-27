package hello;

import javax.persistence.GeneratedValue;

import org.hibernate.mapping.List;
import org.springframework.data.annotation.Id;

//@NodeEntity
public class Movie {

    @Id @GeneratedValue private Long id;
	private String title;
	private int released;
	private String tagline;
//	@Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
//	private List<Role> roles;
}
