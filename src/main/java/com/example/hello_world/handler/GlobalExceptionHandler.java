package com.example.hello_world.handler;

import com.example.hello_world.exception.ApiError;
import com.example.hello_world.exception.BaseException;
import com.example.hello_world.exception.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

  /*@ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
  */
  //---------------------------------------------------------------------------------------------

  @ExceptionHandler(value = {BaseException.class})
  public ResponseEntity<ApiError<?>>handleBaseException(BaseException ex, WebRequest request) { // ne döneceği belli değil ? işareti koyuyoruz
     return ResponseEntity.badRequest().body(createApiError(ex.getMessage(),request));
  }

  @ExceptionHandler(value={MethodArgumentNotValidException.class})
  public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {

      Map<String, List<String>> map = new HashMap<>();
      for (ObjectError objError : ex.getBindingResult().getAllErrors()) { // bütün hataların üzerinde dönüyor herbirini yakalıyor
          String fieldName = ((FieldError)objError).getField();

          if (map.containsKey(fieldName)) { // eski mesajları kaybetmemek için
              map.put(fieldName, addValue(map.get(fieldName), objError.getDefaultMessage()));
          }else {
              map.put(fieldName,addValue(new ArrayList<>(), objError.getDefaultMessage()));
          }
      }
      return ResponseEntity.badRequest().body(createApiError(map, request));
  }

  private List<String> addValue(List<String > list, String newValue) {
      list.add(newValue);
      return list;
  }

  private String getHostName(){
      try {
         return Inet4Address.getLocalHost().getHostName();
      } catch (UnknownHostException e) {
          e.printStackTrace();
      }
      return "";
  }

  public <E>ApiError<E> createApiError(E message, WebRequest request) {
      ApiError<E> apiError = new ApiError<>();
      apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

      Exception<E> exception = new Exception<>();
      exception.setPath(request.getDescription(false).substring(4));
      // uri="/example -> ilk 4 karakteri almamak için
      exception.setTimeStamp(new Date());
      exception.setMessage(message);
      exception.setHostname(getHostName());

      apiError.setException(exception);
      return apiError;
  }
}
