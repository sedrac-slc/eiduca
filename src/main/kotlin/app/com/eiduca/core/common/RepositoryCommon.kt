package app.com.eiduca.core.common

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import java.time.LocalDateTime
import java.util.Optional

@NoRepositoryBean
interface  RepositoryCommon <T: ModelCommon> : JpaRepository<T, String>

@NoRepositoryBean
interface  RepositoryConcrect <T: ModelConcrect> : RepositoryCommon<T>{

    @Query(name = "ModelConcrect.findAll", countName = "ModelConcrect.findAllCount")
    override fun findAll(pageable: Pageable): Page<T>

    @Query(name = "ModelConcrect.findById")
    override fun findById(id: String): Optional<T>

}