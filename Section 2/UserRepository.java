package hello;
import org.hibernate.mapping.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository<User> extends MongoRepository { 
    @Query("{ fullName: ?0 }")
    List findByTheUsersFullName(String fullName);

    List findByFullNameLike(String fullName, Sort sort);
}