package app.com.eiduca.core.service.concrect

import app.com.eiduca.core.common.ServiceConcrect
import app.com.eiduca.core.exception.NotFoundException
import app.com.eiduca.core.model.concrect.Role
import app.com.eiduca.core.repository.concrect.RoleRepository
import org.springframework.stereotype.Service

@Service
class RoleService(
    val roleRepository: RoleRepository
): ServiceConcrect<Role>(roleRepository) {

    fun findByName(name: String): Role = roleRepository.findByName(name).orElseThrow { NotFoundException("Not found role by name [$name]") }

}