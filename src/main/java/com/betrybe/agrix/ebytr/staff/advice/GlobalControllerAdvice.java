package com.betrybe.agrix.ebytr.staff.advice;


import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import java.nio.file.AccessDeniedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Global controller advice.
 */
@ControllerAdvice
public class GlobalControllerAdvice {

  /**
   * Handle farm not found exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler
  public ResponseEntity<String> handleFarmNotFoundException(FarmNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }

  /**
   * Handle crop not found exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler
  public ResponseEntity<String> handleCropNotFoundException(CropNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }

  /**
   * Handle fertilizer not found exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler
  public ResponseEntity<String> handleFertilizerNotFoundException(
      FertilizerNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }

  /**
   * Handle bad credentials exception response entity.
   *
   * @param exception the ex
   * @return the response entity
   */
  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity<String> handleBadCredentialsException(BadCredentialsException exception) {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid username or password");
  }

  /**
   * Handle access denied exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException exception) {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
  }

}
