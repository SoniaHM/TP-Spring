package fr.sorbonne.paris.nord.university.api.factory;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;

public interface EntityFactory<E,D>{

    E toEntity(D dto);
    D toDto(E entity);
    }
