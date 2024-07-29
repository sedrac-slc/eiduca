package app.com.eiduca.core.common

import com.github.f4b6a3.uuid.UuidCreator
import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.io.Serializable
import java.time.LocalDateTime

@MappedSuperclass
abstract class ModelCommon(
    @Id var id: String = "",
    var createdAt: LocalDateTime? = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = LocalDateTime.now(),
    var createdBy: String? = "",
    var updatedBy: String? = "",
    @JvmField @Column(columnDefinition="TEXT", unique= true) var concatFields: String = ""
): Serializable {

    @Transient
    protected val SEPARATOR = ";"

    @PrePersist
    protected fun prePersist() {
        id = UuidCreator.getTimeOrderedEpoch().toString()
        concatValuesFields()
    }

    @PreUpdate
    protected fun preUpdate(){ concatValuesFields() }

    fun concatValuesFields(){
        concatFields = toString()
    }

    override fun toString(): String = "ModelCommon(id='$id', createdAt=$createdAt, updatedAt=$updatedAt, createdBy=$createdBy, updatedBy=$updatedBy, concatFields='$concatFields')"
}

@MappedSuperclass
abstract class ModelConcrect(
    var deletedAt: LocalDateTime? = null,
    var deletedBy: String? = null,
): ModelCommon(){

    override fun toString(): String {
        return "ModelConcrect(id='$id', createdAt=$createdAt, updatedAt=$updatedAt, createdBy=$createdBy, updatedBy=$updatedBy, deletedAt=$deletedAt, deletedBy=$deletedBy, concatFields='$concatFields')"
    }

    protected fun setToString(fields: String)= "id='$id', $fields, createdAt=$createdAt, updatedAt=$updatedAt, createdBy=$createdBy, updatedBy=$updatedBy, deletedAt=$deletedAt, deletedBy=$deletedBy, concatFields='$concatFields'"

}

@MappedSuperclass
abstract class ModelPivot() : ModelCommon()