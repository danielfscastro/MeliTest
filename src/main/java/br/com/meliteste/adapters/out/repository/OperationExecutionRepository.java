package br.com.meliteste.adapters.out.repository;

import br.com.meliteste.adapters.in.entity.OperationEntity;
import br.com.meliteste.application.core.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationExecutionRepository extends JpaRepository<OperationEntity, Long> {
    Optional<OperationEntity> findByExternalId(String externalId);
}