package com.geekster.musicstreamingmct.repo;



import com.geekster.musicstreamingmct.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
    User findFirstByEmail(String email);
}
