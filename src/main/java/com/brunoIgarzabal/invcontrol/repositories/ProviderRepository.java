package com.brunoIgarzabal.invcontrol.repositories;

import com.brunoIgarzabal.invcontrol.domain.providers.Provider;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface ProviderRepository extends BaseRepository<Provider>{
}
