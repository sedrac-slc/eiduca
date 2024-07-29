package app.com.eiduca.core.builder.concrect

import app.com.eiduca.core.common.ConcrectBuilder
import app.com.eiduca.core.model.concrect.Permission

class PermissionBuilder: ConcrectBuilder<Permission>(){
    private var name: String = ""
    private var description: String = ""
    private var entity: String = ""

    fun name(name: String) = apply{ this.name = name }

    fun description(description: String) = apply{ this.description = description }

    fun entity(entity: String) = apply{ this.entity = entity }

    override fun build(): Permission {
        val permission = Permission(name, description, entity)
        return withDefaultValues(permission)
    }

}