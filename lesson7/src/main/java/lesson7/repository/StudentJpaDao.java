package lesson7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lesson7.domain.Student;

public interface StudentJpaDao extends JpaRepository<Student, Integer> {
}
