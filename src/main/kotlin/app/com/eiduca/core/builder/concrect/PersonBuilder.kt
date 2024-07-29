package app.com.eiduca.core.builder.concrect

import app.com.eiduca.core.common.ConcrectBuilder
import app.com.eiduca.core.enums.Gender
import app.com.eiduca.core.model.concrect.Person
import jakarta.persistence.Column
import java.time.LocalDate

class PersonBuilder: ConcrectBuilder<Person>(){

    private var fullname: String = ""
    private var fullnameFather: String? = null
    private var fullnameMother: String? = null
    private var username: String = ""
    private var email: String = ""
    private var identityCardNumber: String = ""
    private var password: String = ""
    private var birthday: LocalDate = LocalDate.now()
    private var gender: Gender = Gender.MALE

    fun fullname(fullname: String) = apply{ this.fullname = fullname }

    fun fullnameFather(fullnameFather: String?) = apply{ this.fullnameFather = fullnameFather }

    fun fullnameMother(fullnameMother: String?) = apply{ this.fullnameMother = fullnameMother }

    fun username(username: String) = apply{ this.username = username }

    fun email(email: String) = apply{ this.email = email }

    fun identityCardNumber(identityCardNumber: String) = apply{ this.identityCardNumber = identityCardNumber }

    fun password(password: String) = apply{ this.password = password }

    fun gender(gender: Gender) = apply{ this.gender = gender }

    fun birthday(birthday: LocalDate) = apply{ this.birthday = birthday }

    override fun build(): Person {
        val person = Person(fullname,fullnameFather,fullnameMother,username,email,identityCardNumber,password,birthday,gender,true,true,true,true)
        return withDefaultValues(person)
    }

}