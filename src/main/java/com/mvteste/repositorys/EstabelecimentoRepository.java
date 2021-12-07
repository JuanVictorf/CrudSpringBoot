package com.mvteste.repositorys;

import com.mvteste.models.Estabelecimento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends MongoRepository<Estabelecimento, String> {

}
