package GoogleMap.repository;

import GoogleMap.entity.GoogleMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoogleMapRepository extends JpaRepository<GoogleMap, Long> {
}
