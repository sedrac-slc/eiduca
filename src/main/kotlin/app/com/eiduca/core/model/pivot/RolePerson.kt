package app.com.eiduca.core.model.pivot

import app.com.eiduca.core.common.ModelPivot
import app.com.eiduca.core.model.concrect.Person
import app.com.eiduca.core.model.concrect.Role
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tb_role_person")
class RolePerson(
    @ManyToOne var role: Role,
    @ManyToOne var person: Person,
): ModelPivot(){

}