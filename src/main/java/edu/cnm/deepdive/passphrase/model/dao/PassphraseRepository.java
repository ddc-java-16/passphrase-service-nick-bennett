package edu.cnm.deepdive.passphrase.model.dao;

import edu.cnm.deepdive.passphrase.model.entity.Passphrase;
import edu.cnm.deepdive.passphrase.model.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PassphraseRepository extends JpaRepository<Passphrase, Long> {

  Optional<Passphrase> findByKey(UUID key);

  Optional<Passphrase> findByUserAndKey(User user, UUID key);

  List<Passphrase> findAllByUserAndNameContainsIgnoreCaseOrderByNameAsc(User user, String nameFragment);

}
