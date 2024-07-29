package app.com.eiduca.core.model.concrect

import app.com.eiduca.core.common.ModelConcrect
import app.com.eiduca.core.enums.Gender
import app.com.eiduca.core.interfaces.IUniqueAttributeModifier
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import org.hibernate.envers.Audited
import org.hibernate.envers.RelationTargetAuditMode
import java.time.LocalDate

@Entity
@Audited
@Table(name ="tb_persons")
class Person(
    var fullname: String,
    @Column(nullable = true) var fullnameFather: String? = null,
    @Column(nullable = true) var fullnameMother: String? = null,
    @JvmField @Column(unique = true) var username: String,
    @Column(unique = true) var email: String,
    @Column(unique = true) var identityCardNumber: String,
    @JvmField @Column(nullable = false) var password: String,
    @Column(nullable = false) var birthday: LocalDate,
    @Enumerated(EnumType.STRING) var gender: Gender = Gender.MALE,
    @JvmField var isAccountNonExpired: Boolean? = true,
    @JvmField var isAccountNonLocked: Boolean? = true,
    @JvmField var isCredentialsNonExpired: Boolean? = true,
    @JvmField var isEnabled: Boolean? = true,
) : ModelConcrect(), IUniqueAttributeModifier{

    constructor(): this("",null,null,"","","","",LocalDate.now(),Gender.MALE)

    override fun updateUniqueAttributes() {
        val concat = nanoId()
        identityCardNumber += concat
        username += concat
        email += concat
    }

    override fun toString(): String {
        return "Person(${setToString("fullname='$fullname', fullnameFather='$fullnameFather', fullnameMother='$fullnameMother', username='$username', email='$email', identityCardNumber='$identityCardNumber', password='$password', birthday=$birthday, gender=$gender, isAccountNonExpired=$isAccountNonExpired, isAccountNonLocked=$isAccountNonLocked, isCredentialsNonExpired=$isCredentialsNonExpired, isEnabled=$isEnabled")})"
    }
}