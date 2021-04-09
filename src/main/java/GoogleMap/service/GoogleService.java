package GoogleMap.service;

import GoogleMap.entity.GoogleMap;
import GoogleMap.entity.GooglePoint;
import GoogleMap.repository.GoogleMapRepository;
import GoogleMap.repository.GooglePointRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoogleService {

    @Autowired
    GooglePointRepository googlePointRepository;

    @Autowired
    GoogleMapRepository googleMapRepository;

    @Transactional(readOnly = true)
    public List<GooglePoint> getAll() {
        return googlePointRepository.findAll();
    }

    @Transactional(readOnly = true)
    public GoogleMap getMapById(Long id) {
        return (GoogleMap) Hibernate.unproxy(googleMapRepository.getOne(id));
    }

    @Transactional
    public void saveMap(GoogleMap googleMap) {
        googleMapRepository.save(googleMap);  // исполняет INSERT в базу данных
    }
}
