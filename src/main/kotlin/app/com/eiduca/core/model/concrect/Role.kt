package app.com.eiduca.core.model.concrect

import app.com.eiduca.core.common.ModelConcrect
import app.com.eiduca.core.enums.RoleType
import app.com.eiduca.core.interfaces.IUniqueAttributeModifier
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table

@Entity
@Table(name = "tb_roles")
class Role (
    @Column(unique = true) var name: String,
    var description: String,
    @Enumerated(EnumType.STRING) var roleType: RoleType = RoleType.APPLICATION,
): ModelConcrect(), IUniqueAttributeModifier {

    override fun updateUniqueAttributes() {
        name += nanoId()
    }

    override fun toString(): String = "Role(${setToString("name='$name', description='$description', roleType=$roleType")})"
}