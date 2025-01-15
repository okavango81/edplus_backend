package com.okavango.edplus_backend.config;

import com.okavango.edplus_backend.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@AllArgsConstructor
public class ShowIdReadOnly implements RepositoryRestConfigurer
    {
        //Obtém todas as entidades mapeadas no contexto JPA através do EntityManager
        private EntityManager entityManager;

        @Override
        public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors)
            {
                // expor os IDs das entidades (default não expõe)
                config.exposeIdsFor(
                        entityManager.getMetamodel()
                                .getEntities()
                                .stream()
                                .map(EntityType::getJavaType)
                                .toArray(Class[]::new)
                );

                // desabilitar métodos de edição para as entidades
                HttpMethod[] unsupportedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
                Class<?>[] domainTypes = {Actor.class, Director.class, Genre.class, Movie.class, Persona.class};

                for (Class<?> domainType : domainTypes) {
                    config.getExposureConfiguration()
                            .forDomainType(domainType)
                            .withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions))
                            .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions));
                }
            }

    }
