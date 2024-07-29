package app.com.eiduca.core.request.post

import app.com.eiduca.core.builder.concrect.PersonBuilder
import app.com.eiduca.core.enums.Gender
import app.com.eiduca.core.model.concrect.Person
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class PersonRequestPost(
    @Schema(description = "Person's full name", example = "John Guy Silver")
    var fullname: String,
    @Schema(description = "Person father's full name", example = "John Guy Silver")
    var fullnameFather: String?,
    @Schema(description = "Person's mother's full name", example = "John Guy Silver")
    var fullnameMother: String?,
    @Schema(description = "Person's username")
    var username: String,
    @Email
    @Schema(description = "Person's email")
    var email: String,
    var identityCardNumber: String,
    @Schema(description = "Person`s gender [MALE, FEMALE]")
    var gender: Gender,
    @NotNull
    @Schema(description = "Person`s password")
    var password: String,
    @NotNull
    @Schema(description = "This is the person's birthday and the date format is yyyy-mm-dd")
    var birthday: LocalDate
) {

    fun toPerson() : Person = PersonBuilder()
        .fullname(fullname)
        .fullnameFather(fullnameFather)
        .fullnameMother(fullnameMother)
        .username(username)
        .email(email)
        .identityCardNumber(identityCardNumber)
        .gender(gender)
        .password(password)
        .birthday(birthday)
        .build()

}