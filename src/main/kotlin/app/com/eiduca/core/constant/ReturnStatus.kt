package app.com.eiduca.core.constant

import org.springframework.http.HttpStatus

class ReturnStatus {
    companion object {
        val OK = HttpStatus.OK
        val CREATED = HttpStatus.CREATED
        val UPDATED = HttpStatus.ACCEPTED
        val DELETED = HttpStatus.NO_CONTENT
    }
}