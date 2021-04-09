package GoogleMap.repository;

import GoogleMap.entity.GooglePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GooglePointRepository extends JpaRepository<GooglePoint, Long> {
}
