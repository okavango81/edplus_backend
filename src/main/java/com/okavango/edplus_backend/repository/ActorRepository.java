package com.okavango.edplus_backend.repository;

import com.okavango.edplus_backend.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource( path = "actors", collectionResourceRel = "actorList", itemResourceRel = "actor")
public interface ActorRepository extends JpaRepository<Actor, Long>
    {
    }