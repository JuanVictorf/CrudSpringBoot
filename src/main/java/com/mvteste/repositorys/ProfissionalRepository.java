package com.mvteste.repositorys;

import com.mvteste.models.Profissional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends MongoRepository<Profissional, String>{

}
