package app.com.eiduca.core.service.concrect

import app.com.eiduca.core.common.ServiceConcrect
import app.com.eiduca.core.exception.NotFoundException
import app.com.eiduca.core.model.concrect.Permission
import app.com.eiduca.core.repository.concrect.PermissionRepository
import org.springframework.stereotype.Service

@Service
class PermissionService(
    val permissionRepository: PermissionRepository
): ServiceConcrect<Permission>(permissionRepository) {

    fun findByName(name: String): Permission = permissionRepository.findByName(name).orElseThrow { NotFoundException("Not found permission by name [$name]") }

}