package app.com.eiduca.core.request.body

import app.com.eiduca.core.builder.concrect.RoleBuilder
import app.com.eiduca.core.enums.RoleType
import app.com.eiduca.core.model.concrect.Role
import io.swagger.v3.oas.annotations.media.Schema

class RoleRequest(
    @Schema(description = "Role's name or codename", example = "ROLE_TEACHER")
    var name: String,
    @Schema(description = "Role's description", example = "Represent teachers")
    var description: String,
    @Schema(description = "Type of permission", example = "[APPLICATION,USER]")
    var roleType: RoleType = RoleType.APPLICATION, var entity: String
) {

    fun toRole() : Role = RoleBuilder().name(name).description(description).roleType(roleType).build()
}