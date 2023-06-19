package com.geekster.musicstreamingmct.repo;



import com.geekster.musicstreamingmct.model.AuthenticationToken;
import com.geekster.musicstreamingmct.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepo extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findFirstByToken(String token);


    boolean findByUser(User user);
}
