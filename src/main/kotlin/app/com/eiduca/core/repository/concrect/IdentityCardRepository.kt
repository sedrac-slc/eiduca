package app.com.eiduca.core.repository.concrect

import app.com.eiduca.core.common.RepositoryConcrect
import app.com.eiduca.core.model.concrect.IdentityCard
import app.com.eiduca.core.model.concrect.Person
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.history.RevisionRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface IdentityCardRepository: RepositoryConcrect<IdentityCard>, RevisionRepository<IdentityCard, String, Long> {

    @Query(name = "SELECT i FROM IdentityCard i WHERE person = :person AND deletedBy IS NULL AND deletedAt is NULL")
    fun findByPerson(person: Person): Optional<IdentityCard>

}