package app.com.eiduca.core.request.body

import app.com.eiduca.core.builder.concrect.PermissionBuilder
import app.com.eiduca.core.model.concrect.Permission
import io.swagger.v3.oas.annotations.media.Schema

class PermissionRequest(
    @Schema(description = "Permission's name or codename", example = "PERSON_CREATE")
    var name: String,
    @Schema(description = "Permission's description", example = "Permit create person")
    var description: String,
    @Schema(description = "Model represent permission", example = "Person")
    var entity: String
) {

    fun toPermission() : Permission {
        return PermissionBuilder().name(name).description(description).entity(entity).build()
    }
}