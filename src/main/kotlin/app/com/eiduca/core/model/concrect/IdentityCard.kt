package app.com.eiduca.core.model.concrect

import app.com.eiduca.core.common.ModelConcrect
import app.com.eiduca.core.enums.Gender
import app.com.eiduca.core.enums.MaritalStatus
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.envers.Audited
import java.time.LocalDate

@Entity
@Audited
@Table(name="tb_identity_card")
class IdentityCard(
    @ManyToOne  var person: Person,
    @Enumerated(EnumType.STRING) var maritalStatus: MaritalStatus = MaritalStatus.SINGLE,
    var residential: String,
    var naturalFrom: String,
    var emittedIn: String,
    var emittedAt: LocalDate,
    var validAt: LocalDate,
):ModelConcrect() {

    constructor(): this(Person(),MaritalStatus.SINGLE,"","","",LocalDate.now(),LocalDate.now())

    override fun toString(): String {
        return "IdentityCard(${setToString("person=$person, maritalStatus=$maritalStatus, residential='$residential', naturalFrom='$naturalFrom', emittedIn='$emittedIn', emittedAt=$emittedAt, validAt=$validAt")})"
    }
}