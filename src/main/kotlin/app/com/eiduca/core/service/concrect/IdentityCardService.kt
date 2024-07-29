package app.com.eiduca.core.service.concrect

import app.com.eiduca.core.common.ServiceConcrect
import app.com.eiduca.core.exception.NotFoundException
import app.com.eiduca.core.model.concrect.IdentityCard
import app.com.eiduca.core.model.concrect.Person
import app.com.eiduca.core.repository.concrect.IdentityCardRepository
import org.springframework.stereotype.Service

@Service
class IdentityCardService(
    val identityCardRepository: IdentityCardRepository
): ServiceConcrect<IdentityCard>(identityCardRepository)  {

    fun findByPerson(person: Person): IdentityCard = identityCardRepository.findByPerson(person).orElseThrow { NotFoundException("Not found IdentityCard by id [${person.id}]") }
}