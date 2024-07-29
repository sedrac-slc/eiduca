package app.com.eiduca.core.exception

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    private fun <T: Exception> exception  (exception: T, httpStatusCode: HttpStatus, detail: String? = null): ResponseEntity<ProblemDetail> {
        val problemDetail = ProblemDetail.forStatusAndDetail(httpStatusCode, detail)
        problemDetail.title = exception.message
        return ResponseEntity.status(httpStatusCode).body(problemDetail)
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handlerDataIntegrityViolationException(exception: DataIntegrityViolationException): ResponseEntity<ProblemDetail> {
        val httpStatusCode = HttpStatus.CONFLICT
        val problemDetail = ProblemDetail.forStatus(httpStatusCode)
        problemDetail.title = exception.message?.substringBefore("]")+"]"
        return ResponseEntity.status(httpStatusCode).body(problemDetail)
    }

    @ExceptionHandler(JpaObjectRetrievalFailureException::class)
    fun handlerJpaObjectRetrievalFailureException(exception: JpaObjectRetrievalFailureException): ResponseEntity<ProblemDetail> = exception(exception, HttpStatus.INTERNAL_SERVER_ERROR)

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handlerHttpMessageNotReadableException(exception: HttpMessageNotReadableException): ResponseEntity<ProblemDetail> = exception(exception, HttpStatus.BAD_REQUEST)

    @ExceptionHandler(NotFoundException::class)
    fun handlerNotFoundException(exception: NotFoundException): ResponseEntity<ProblemDetail> = exception(exception, HttpStatus.NOT_FOUND)
}