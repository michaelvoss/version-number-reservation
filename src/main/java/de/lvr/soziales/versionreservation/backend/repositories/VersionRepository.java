package de.lvr.soziales.versionreservation.backend.repositories;

import de.lvr.soziales.versionreservation.backend.entities.ApplicationEntity;
import de.lvr.soziales.versionreservation.backend.entities.VersionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VersionRepository extends CrudRepository<VersionEntity, Long> {
	public List<VersionEntity> findAll();
	public List<VersionEntity> findByApplicationId(Long applicationId);
}
