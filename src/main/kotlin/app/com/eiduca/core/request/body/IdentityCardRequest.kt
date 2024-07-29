package app.com.eiduca.core.request.body

import app.com.eiduca.core.builder.concrect.IdentityCardBuilder
import app.com.eiduca.core.builder.concrect.PersonBuilder
import app.com.eiduca.core.enums.MaritalStatus
import app.com.eiduca.core.model.concrect.IdentityCard
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

class IdentityCardRequest(
    @Schema(description = "Identity card person id")
    var person: String,
    @Schema(description = "Person's marital status [MARRIED, SINGLE, DIVORCED, WIDOWER]")
    var maritalStatus: MaritalStatus = MaritalStatus.SINGLE,
    @Schema(description = "Place of residence, where you live", example = "Blue school")
    var residential: String,
    @Schema(description = "Country or place where you were born", example = "Angolan")
    var naturalFrom: String,
    @Schema(description = "When the identity card was issued", example = "Luanda")
    var emittedIn: String,
    var emittedAt: LocalDate,
    var validAt: LocalDate,
) {

    fun toIdentityCard() : IdentityCard = IdentityCardBuilder()
        .maritalStatus(maritalStatus)
        .residential(residential)
        .naturalFrom(naturalFrom)
        .emittedIn(emittedIn)
        .emittedAt(emittedAt)
        .validAt(validAt)
        .person(PersonBuilder().id(person).build())
        .build()
}