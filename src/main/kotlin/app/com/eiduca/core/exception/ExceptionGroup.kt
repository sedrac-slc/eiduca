package app.com.eiduca.core.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class PermissionDeniedException(message: String = "Permission denied"): Exception(message)

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRequestDataException(message: String = "Bad Request"): Exception(message)

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(message: String = "The record was not found"): Exception(message)