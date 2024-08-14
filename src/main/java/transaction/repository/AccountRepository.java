package transaction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import transaction.entity.AccountEntity;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
}
