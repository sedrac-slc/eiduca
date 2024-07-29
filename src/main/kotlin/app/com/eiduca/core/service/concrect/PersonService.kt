package app.com.eiduca.core.service.concrect

import app.com.eiduca.core.common.ServiceConcrect
import app.com.eiduca.core.exception.NotFoundException
import app.com.eiduca.core.model.concrect.Person
import app.com.eiduca.core.repository.concrect.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
    val personRepository: PersonRepository
): ServiceConcrect<Person>(personRepository) {

    fun findByUsername(username: String): Person = personRepository.findByUsername(username).orElseThrow { NotFoundException("Not found person by username [$username]") }

}