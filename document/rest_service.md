# Rest Service Oluşturma

Bu doküman, bir Spring Boot uygulamasında RESTful servisler oluşturmak için kullanılan temel adımları açıklamaktadır. REST (Representational State Transfer), HTTP protokolünü kullanarak veri paylaşımını sağlayan bir mimaridir.

## 1.1. **Spring Boot ve REST Controller**

Spring Boot ile bir RESTful servis oluşturmak için öncelikle Spring Web modülünü kullanmamız gerekir.

### 1.2. **`@RestController` Kullanımı**

`@RestController` anotasyonu, bir sınıfın REST API'leri sağladığını belirtir. Bu sınıf, HTTP isteklerini işler ve her bir metot bir HTTP cevabı döner.

Örneğin:

```java
@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/message")
    public String getGreeting() {
        return "Merhaba Dünya!";
    }

    @PostMapping("/message")
    public String postGreeting(@RequestBody(required = false) String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new BadRequestException("Lütfen bir isim yazınız.");
        }
        return "Merhaba " + name + "!";
    }
}
```
- **@GetMapping:** HTTP GET isteği için bir endpoint tanımlar. /api/message adresine gelen GET isteklerine getGreeting() metoduyla yanıt verilir.
- **@PostMapping:** HTTP POST isteği için bir endpoint tanımlar. /api/message adresine gelen POST isteklerine postGreeting() metoduyla yanıt verilir.

### 1.3. **`BadRequestException` Tanımlaması**
Eğer kullanıcıdan gelen isim boşsa, bir BadRequestException fırlatılır. Bu, kullanıcıya hatalı istek hakkında bilgi vermek için kullanılır.
```java
public class BadRequestException extends RuntimeException {
public BadRequestException(String message) {
super(message);
}}
```
### 1.4. **`Global Exception Handling`**
Spring'de global exception handling için @ControllerAdvice anotasyonu kullanılır. Bu sınıf, belirli türdeki hataları yönetir ve uygun HTTP cevabını döner.
```java
@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(BadRequestException.class)
public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
}
}
```
### 1.5. **Swagger ile API Belgeleri**
Swagger, API'nizi dokümante etmek ve kullanıcıların API'yi test etmelerini sağlamak için kullanılan bir araçtır. Spring Boot ile Swagger entegrasyonu, RESTful API'lerinizi kolayca belgeleyebilmenize olanak tanır.

Swagger yapılandırması:
```java
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Hello World API")
                .version("1.0.0")
                .description("İlk Görev.")
            );
    }
}
```

