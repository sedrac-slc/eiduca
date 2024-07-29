package app.com.eiduca.core.builder.concrect

import app.com.eiduca.core.common.ConcrectBuilder
import app.com.eiduca.core.enums.RoleType
import app.com.eiduca.core.model.concrect.Role

class RoleBuilder: ConcrectBuilder<Role>(){
    private var name: String = ""
    private var description: String = ""
    private var roleType: RoleType = RoleType.APPLICATION

    fun name(name: String) = apply{ this.name = name }

    fun description(description: String) = apply{ this.description = description }

    fun roleType(roleType: RoleType) = apply{ this.roleType = roleType }

    override fun build(): Role {
        val permission = Role(name, description, roleType)
        return withDefaultValues(permission)
    }
}