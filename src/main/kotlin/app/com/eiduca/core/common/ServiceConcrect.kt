package app.com.eiduca.core.common

import app.com.eiduca.core.exception.NotFoundException
import app.com.eiduca.core.interfaces.IUniqueAttributeModifier
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.time.LocalDateTime

abstract class ServiceCommon<T: ModelCommon>(
    private val repositoryCommon: RepositoryCommon<T>
){

    open  fun findAll(pageable: Pageable): Page<T> = repositoryCommon.findAll(pageable)

    open fun findById(id: String): T = repositoryCommon.findById(id).orElseThrow {NotFoundException("Not found ${javaClass.simpleName} by id")}

    open fun save(obj: T): T = repositoryCommon.save(obj)

    open fun update(obj: T): T{
        findById(obj.id)
        return repositoryCommon.save(obj)
    }

    open fun update(obj: T, id: String): T{
        obj.id = findById(id).id
        return repositoryCommon.save(obj)
    }

    open fun delete(obj: T){
        repositoryCommon.delete(obj)
    }

    open fun deleteById(id: String){
        repositoryCommon.deleteById(id)
    }

}

abstract class ServiceConcrect<T: ModelConcrect> (
    private val repositoryConcrect: RepositoryConcrect<T>
): ServiceCommon<T>(repositoryConcrect){

    override fun findAll(pageable: Pageable): Page<T> = repositoryConcrect.findAll(pageable)

    override fun findById(id: String): T = repositoryConcrect.findById(id).orElseThrow {NotFoundException("Not found ${javaClass.simpleName} by id")}

    override fun delete(obj: T) {
        findById(obj.id)
        deleteById(obj.id)
    }

    override fun deleteById(id: String) {
        val entity = findById(id)
        if(entity is IUniqueAttributeModifier) entity.updateUniqueAttributes()
        entity.deletedAt = LocalDateTime.now()
        repositoryConcrect.save(entity)
    }

}