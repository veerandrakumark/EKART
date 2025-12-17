package com.ecommerce.respository;
import org.spingframework.data.jpa.respository.JpaRepository;
import com.ecommerce.entity.User;
public class UserRespository extends JpaRepository<User, Long> { //JpaRepository is a JPA specific extension of Repository. It contains the full API of CrudRepository and PagingAndSortingRepository.
                                                              //It provides JPA related methods such as flushing the persistence context and delete records in a batch.
                                                              // User Long means the entity type is User and the primary key type is Long.
    Optional<User> findByUsername(String username); //If no user ,it will return null ...It will handles the nullPointer exception since 
    Optional<User> findByEmail(String email);//In user u1; there is a null...it doesn't throw error...instead it return null...
    boolean existsByUsername(String username); //If give User alone it may throw error...this function replaces the query..
    boolean existsByeEmail(String email);

    @Query("SELECT u FROM User u WHERE u.username = :username OR u.email = :email") //JPQL query to find user by username or email
    Optional<User> findByUsernameOrEmail(@Param("username")String username,@Param("email")String email); //It will search for user by username or email

}
