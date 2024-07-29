package app.com.eiduca.core.repository.concrect

import app.com.eiduca.core.common.RepositoryConcrect
import app.com.eiduca.core.model.concrect.Permission
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PermissionRepository: RepositoryConcrect<Permission>{
    @Query(name = "SELECT p FROM Permission p WHERE name = :name AND deletedBy IS NULL AND deletedAt is NULL")
    fun findByName(name: String): Optional<Permission>
}