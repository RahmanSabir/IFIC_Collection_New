package com.unisoft.collection.settings.atm;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtmRepository extends JpaRepository<AtmEntity, Long> {

    List<AtmEntity> findByEnabled(boolean enabled);

}
