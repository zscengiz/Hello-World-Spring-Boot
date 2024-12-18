# **Spring Security Nedir?**

## 2.1. **Spring Security Nedir?**

Spring Security, Spring uygulamaları için kapsamlı bir güvenlik çerçevesidir. Kullanıcıların kimlik doğrulama işlemleri (authentication) ve yetkilendirme işlemleri (authorization) için kullanılabilir. Uygulamanın güvenliğini sağlar.

### Temel Özellikler:
- **Kimlik Doğrulama (Authentication)**: Kullanıcının kimliğini doğrulamak için kullanılır.
- **Yetkilendirme (Authorization)**: Kullanıcının belirli kaynaklara erişim izni olup olmadığını kontrol eder.

## 2.2. **Basic Authentication Yapılandırması**

Spring Security'yi yapılandırarak uygulamanızda Basic Authentication'ı etkinleştirebilirsiniz. Bu yöntem, kullanıcı adı ve şifrenin her istekte HTTP başlıklarında gönderilmesini sağlar.

Örneğin:

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("testKullanici")
            .password(passwordEncoder().encode("testSifre"))
            .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/**").authenticated()
            .anyRequest().permitAll()
            .and()
            .formLogin()
            .failureHandler(authenticationFailureHandler)
            .and()
            .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

### Açıklamalar:
- **httpBasic()**: HTTP başlıklarında kullanıcı adı ve şifrenin gönderileceği Basic Authentication'ı etkinleştirir.
- **passwordEncoder()**: Şifrelerin güvenli bir şekilde saklanması için kullanılan bir bean'dir. `BCryptPasswordEncoder`, şifreyi hash'ler.

## 2.3. **CustomAuthenticationFailureHandler Kullanımı**

Bu sınıf, kullanıcı adı ya da şifre hatalı olduğunda özel bir hata mesajı döndürmek için kullanılır.

```java
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Yanlis kullanici adi veya sifre");
    }
}
```

Bu sınıf, kimlik doğrulama işlemi başarısız olduğunda, HTTP yanıtını `401 Unauthorized` yaparak, hata mesajını kullanıcıya iletir.

## 2.4. **Oturum Yönetimi ve CSRF**

- **CSRF** (Cross-Site Request Forgery): Kötü niyetli bir kullanıcının başka bir kullanıcı adına istek göndermesini sağlar. API'lerde genellikle bu tür saldırılar geçerli değildir, bu yüzden CSRF koruması devre dışı bırakılır.

```java
http.csrf().disable();
```

- **Oturum Yönetimi**: `Basic Authentication` kullandığınızda, her istekte kimlik doğrulaması yapılır. Yani, kullanıcı her yeni istek gönderdiğinde kimlik bilgilerini tekrar göndermelidir. Bu yöntem, oturum süresi yönetimi gerektirmez.

---
