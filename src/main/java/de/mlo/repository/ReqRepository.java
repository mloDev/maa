package de.mlo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Req;

public interface ReqRepository extends JpaRepository<Req, Long> {

}
