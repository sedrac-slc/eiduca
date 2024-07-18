package app.com.eiduca.core.common

import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime

@MappedSuperclass
abstract class ModelCommon(
    @Id @UuidGenerator var id: String = "",
    var createdAt: LocalDateTime? = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = LocalDateTime.now(),
    var createdBy: String? = "",
    var updatedBy: String? = "",
    @JvmField @Column(columnDefinition="TEXT", unique= true) var concatFields: String = ""
) {
}

@MappedSuperclass
abstract class ModelConcrect(
    var deletedAt: LocalDateTime? = null,
    var deletedBy: String? = null,
): ModelCommon()

@MappedSuperclass
abstract class ModelPivot() : ModelCommon()