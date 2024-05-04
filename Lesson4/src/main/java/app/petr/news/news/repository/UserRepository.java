package app.petr.news.news.repository;

import app.petr.news.news.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}