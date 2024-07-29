package app.com.eiduca.core.repository.concrect

import app.com.eiduca.core.common.RepositoryConcrect
import app.com.eiduca.core.model.concrect.Person
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.history.RevisionRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PersonRepository: RepositoryConcrect<Person>, RevisionRepository<Person, String, Long>{
    @Query(name = "SELECT p FROM Person p WHERE username = :username WHERE deletedBy IS NULL AND deletedAt IS NULL")
    fun findByUsername(username: String): Optional<Person>
}