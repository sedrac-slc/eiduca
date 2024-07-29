package app.com.eiduca.core.model.concrect

import app.com.eiduca.core.common.ModelConcrect
import app.com.eiduca.core.interfaces.IUniqueAttributeModifier
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tb_permissions")
class Permission(
    @Column(unique = true) var name: String,
    var description: String,
    var entity: String,
): ModelConcrect(), IUniqueAttributeModifier {

    override fun updateUniqueAttributes() {
        name += nanoId()
    }

    override fun toString(): String = "Permission(${setToString("name='$name', description='$description', entity='$entity'")})"
}