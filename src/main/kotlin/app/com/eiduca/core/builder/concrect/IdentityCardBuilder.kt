package app.com.eiduca.core.builder.concrect

import app.com.eiduca.core.common.ConcrectBuilder
import app.com.eiduca.core.enums.MaritalStatus
import app.com.eiduca.core.model.concrect.IdentityCard
import app.com.eiduca.core.model.concrect.Person
import java.time.LocalDate

class IdentityCardBuilder: ConcrectBuilder<IdentityCard>(){

    private var person: Person = Person()
    private var maritalStatus: MaritalStatus = MaritalStatus.SINGLE
    private var residential: String = ""
    private var naturalFrom: String = ""
    private var emittedIn: String = ""
    private var emittedAt: LocalDate =  LocalDate.now()
    private var validAt: LocalDate =  LocalDate.now()

    fun person(person: Person) = apply{ this.person = person }

    fun maritalStatus(maritalStatus: MaritalStatus) = apply{ this.maritalStatus = maritalStatus }

    fun residential(residential: String) = apply{ this.residential = residential }

    fun naturalFrom(naturalFrom: String) = apply{ this.naturalFrom = naturalFrom }

    fun emittedIn(emittedIn: String) = apply{ this.emittedIn = emittedIn }

    fun emittedAt(emittedAt: LocalDate) = apply{ this.emittedAt = emittedAt }

    fun validAt(validAt: LocalDate) = apply{ this.validAt = validAt }

    override fun build(): IdentityCard {
        val identityCard = IdentityCard(person, maritalStatus, residential, naturalFrom, emittedIn, emittedAt, validAt)
        return withDefaultValues(identityCard)
    }

}