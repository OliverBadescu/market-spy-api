package app.MarketSpy.app.users.repository;


import app.MarketSpy.app.users.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @EntityGraph(attributePaths = {"products"}, type = EntityGraph.EntityGraphType.FETCH)
    Optional<User> findById(long id);

    @EntityGraph(attributePaths = {"products"}, type = EntityGraph.EntityGraphType.FETCH)
    Optional<User> findByEmail(String email);

}
