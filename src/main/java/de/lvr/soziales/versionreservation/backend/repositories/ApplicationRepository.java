package de.lvr.soziales.versionreservation.backend.repositories;

import de.lvr.soziales.versionreservation.backend.entities.ApplicationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<ApplicationEntity, Long> {
	public List<ApplicationEntity> findAll();
}
