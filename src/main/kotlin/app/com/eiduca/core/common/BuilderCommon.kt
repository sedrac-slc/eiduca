package app.com.eiduca.core.common

import java.time.LocalDateTime

abstract class CommonBuilder<T>{

    protected var id: String = ""
    protected var createdAt: LocalDateTime? = LocalDateTime.now()
    protected var updatedAt: LocalDateTime? = LocalDateTime.now()
    protected var createdBy: String? = ""
    protected var updatedBy: String? = ""
    protected var concatFields: String = ""

    fun id(id: String) = apply{ this.id = id }

    fun createdAt(createdAt: LocalDateTime = LocalDateTime.now()) = apply { this.createdAt = createdAt }

    fun updatedAt(updatedAt: LocalDateTime = LocalDateTime.now()) = apply { this.updatedAt = updatedAt }

    fun createdBy(createdBy: String? = null) = apply { this.createdBy = createdBy }

    fun updatedBy(updatedBy: String? = null) = apply { this.updatedBy = updatedBy }

    fun concatFields(concatFields: String = "") = apply { this.concatFields = concatFields }

    abstract fun build(): T;
}

abstract class ConcrectBuilder<T>: CommonBuilder<T>(){

    protected var deletedBy: String? = null
    protected var deletedAt: LocalDateTime? = null

    fun deletedAt(deletedAt: LocalDateTime? = null) = apply { this.deletedAt = deletedAt }

    fun deletedBy(deletedBy: String? = null) = apply { this.deletedBy = deletedBy }

    protected fun <T: ModelConcrect> withDefaultValues(obj: T): T{
        obj.createdAt = createdAt
        obj.createdBy = createdBy
        obj.updatedAt = updatedAt
        obj.updatedBy = updatedBy
        obj.deletedAt = deletedAt
        obj.deletedBy = deletedBy
        obj.id = id
        return obj
    }

}