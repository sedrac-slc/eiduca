package app.com.eiduca.core.request.put

import app.com.eiduca.core.builder.concrect.PersonBuilder
import app.com.eiduca.core.enums.Gender
import app.com.eiduca.core.model.concrect.Person
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class PersonRequestPut(
    var id: String,
    @Schema(description = "This is the Person`s fullname must meet this regex ^\\w+(\\s\\w+)+", example = "John Guy Silver")
    var fullname: String,
    @Schema(description = "Person father's full name", example = "John Guy Silver")
    var fullnameFather: String?,
    @Schema(description = "Person's mother's full name", example = "John Guy Silver")
    var fullnameMother: String?,
    @Schema(description = "This is Person`s username")
    var username: String,
    @Email @Schema(description = "This is Person`s email")
    var email: String,
    var identityCardNumber: String,
    @Schema(description = "This is Person`s gender [MALE, FEMALE]")
    var gender: Gender,
    @NotNull @Schema(description = "This is the person's birthday and the date format is yyyy-mm-dd")
    var birthday: LocalDate,
) {

    fun toPerson() : Person {
        return PersonBuilder()
            .fullname(fullname)
            .fullnameFather(fullnameFather)
            .fullnameMother(fullnameMother)
            .username(username)
            .email(email)
            .identityCardNumber(identityCardNumber)
            .gender(gender)
            .birthday(birthday)
            .id(id)
            .build()
    }

}