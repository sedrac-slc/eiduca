package app.com.eiduca.core.model

import app.com.eiduca.core.common.ModelConcrect
import app.com.eiduca.core.enums.Gender
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name ="tb_persons")
class Person(
    @Column(nullable = false) var fullname: String,
    @JvmField @Column(unique = true) var username: String,
    @Column(unique = true) var email: String,
    @JvmField @Column(nullable = false) var password: String,
    @Column(nullable = false) var birthday: LocalDate,
    @Enumerated(EnumType.STRING) var gender: Gender = Gender.MALE,
    @JvmField var isAccountNonExpired: Boolean = true,
    @JvmField var isAccountNonLocked: Boolean = true,
    @JvmField var isCredentialsNonExpired: Boolean = true,
    @JvmField var isEnabled: Boolean = true
) : ModelConcrect(){

}