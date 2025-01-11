# Hello World Spring Boot Project
<details>
<summary><h3 style="display: inline-block">Task 1 - View Details</h3></summary>

# 1. Spring

_Spring,_ Java ile kurumsal uygulamalar(Enterprise) yapmayı kolaylaştıran bir frameworktur. Temel anlamda Inversion of Control (IoC) and Dependency Injection (DI) özellikleri sağlar.

> _“Framework”,_ bir yazılımın veya sistemin belirli bir işlevselliği veya yapıyı desteklemek, organize etmek ve geliştirmek için kullanılan temel bir yapı veya çerçeve anlamına gelir.

> _Inversion of control,_ bir yazılım tasarım prensibidir. Ioc ile Uygulama içerisindeki obje instance’larının yönetimi sağlanarak, bağımlılıklarını en aza indirgemek amaçlanmaktadır. Projeniz deki bağımlılıkların oluşturulmasını ve yönetilmesini geliştiricinin yerine, framework’ün yapması olarak da açıklanabilir.

> _Bağımlılık Enjeksiyonu (DI),_ IoC’yi uygulamak için kullanılan bir tasarım modelidir. Dependency Injection uygulayarak; bir sınıfının bağımlı olduğu nesneden bağımsız hareket edebilmesini sağlayabilir ve kod üzerinde olası geliştirmelere karşın değişiklik yapma ihtiyacını ortadan kaldırabilirsiniz.

**Spring Modülleri:**
![Spring Modül](screenshots/task1/springModül.png)

### Data Access/Integration
1. **JDBC:**  Java DataBase Connectivity(JDBC),sorguyu veritabanına bağlamak ve sorguyu çalıştırmak için kullanılan Java API’sidir. Veritabanına kullanıcı tarafından oluşturulmuş istekler gönderilmesinde yardımcı rol oynar.
2. **ORM:**   Object-Relational Mapping(ORM), nesne yönelimli bir paradigma kullanarak bir veritabanındaki verileri sorgulamanıza ve değiştirmenize izin veren bir programla tekniğidir. Yani kodda entity oluşturup onu veritabanına aktarmayı sağlar.
   ![orm](screenshots/task1/orm.png)
   
### Core Container
Spring Framework’ün temelini oluşturan Inversion Of Control(IoC) ve Dependency Injection(DI) özellikleri bu modül içerisinde implemente edilmiştir.

1. **Spring Bean:** Spring’deki bir bean, Spring Container tarafından yönetilen ve Spring uygulaması içinde kullanılan herhangi bir nesneyi ifade eder. Bu bahsettiğimiz nesneler Spring tarafından oluşturulur ve yönetilir. Spring’deki bir bean tanımlamak için **@Component** anotasyonu kullanılır. _Java Bean veri saklamak, veri işlemek veya manipüle etmek için kullanılırken, Spring BeanSpring uygulamasını yapılandırmak, esneklik katmak, bileşenler ve logic için kullanılır._
2. **Core:** Spring çerçevesinin temelini oluşturur. Yani Spring framework temelini oluşturmakla kalmaz diğer katmanların da temelini oluşturmaktadır. IoC (Inversion of Control) da sağlamaktadır
![core](screenshots/task1/core.png)

# 2. REST API

**Rest (Representational State Transfer),** Server (Sunucu) ve Client (İstemci) arasında veri alışverişini sağlayan bir mimari modeldir. Rest API de Rest mimarisinin kullanımıyla web hizmetleri arasında veri alışverişini sağlayan uygulama ara birimidir.

**URL (Uniform Resource Locator),** aslında internet üzerinde yayınlanan verilerin kaynağının bulunduğu konumu tanımlamaya yarayan adreslerdir. URL adreslerini bir internet sitesinde bulunan içerik, veri, dosya gibi bileşenlere ulaşılmasını sağlayan dosya yolu olarak da tanımlayabiliriz.

**HTTP (HyperText Transfer Protocol),** Sunucu (Server) ve İstemci (Client) arasında internet adresi üzerinden bağlantı oluşturmak ve verilerin aktarılması için kullanılan ve internet sitelerinin bağlantıları için uzun zamandır kullanılan bir TCP/IP protokolüdür.

**API(Application Programming Interface)** yani Uygulama Programlama Arayüzü. Bir uygulamaya ait işlevlerin başka bir uygulamada da kullanılabilmesi için oluşturulmuş bir arayüzdür. İki yazılımın veya veritabanının birbiri ile sorunsuz çalışabilmesini ve en sağlıklı bir şekilde birbiri ile iletişime geçmesini sağlar. API, yazılım bileşeniyle olan etkileşimlerin bir özelliğidir.

**SOAP:**(en: Simple Access Protocol ,tr: Basit Nesne Erişim Protokolü) en temel anlamda, internet üzerinden küçük miktarda bilgileri yada mesajları aktarma protokolüdür. RPC (Remote Procedure Call) modelini kullanan SOAP, keskin kurallar kullanarak iletişim gerçekleştirir.

**RPC(Remote Procedure Call),** bilgisayar ağları veya iletişim protokolleri üzerinden uzak sunucularda bulunan işlevleri çağırmak için kullanılan bir iletişim modelidir. RPC’nin temel amacı, bir bilgisayar veya cihazın yerel işlevlerini çağırmak gibi uzaktaki bir sunucudaki işlevleri çağırabilmenizi sağlamaktır.

### REST API Nasıl Çalışır?

_Rest,_ HTTP protokolünü kullanarak, URL adresleri üzerinden veri ve dosya alışverişi sağlayan bir yapıdır. Rest API ise Rest işlemini yapabilmek için kurgulanmış modüle verilen isimdir. Bu API (Modül) yardımıyla Rest işlemleri ve veri alışverişi yapılıyor.
![RestApi](screenshots/task1/RestApi.png)
# 3. POSTMAN

_Postman,_ API testleri yapma, API belgelerini oluşturma ve paylaşma, otomasyon ve işbirliği için kullanılan bir geliştirici aracıdır. Hem masaüstü uygulaması hem de web sürümü bulunur ve API geliştirme süreçlerini hızlandırır.

>_API(Application Programming Interface),_ farklı uygulama yazılımlarının birbirleri ile etkileşim sağlamasına olanak sağlar. Client(Android) ve Backend(java) yazılımlarının Restfull Api ile iletişim kurması buna örnek verilebilir

**Postman Temel Kavramlar:**
+ **Workspace (Çalışma Alanı):** Projelerinizi ve koleksiyonlarınızı organize etmek için kullanabileceğiniz bir alan.
+ **Collection (Koleksiyon):** API testlerini ve isteklerini gruplandırmak için kullanılır.
+ **Request (İstek):** Bir API servisine gönderilecek isteği temsil eder.
+ **Environment (Çevre):** Ortam değişkenleri, farklı ortamlar arasında geçiş yapmanıza ve değişkenleri kullanmanıza olanak tanır.

# 4. SWAGGER

_Swagger,_ yazılım geliştiricilerin Restful api’lerini tasarlamasına, oluşturmasına, belgelemesine ve rahat bir şekilde kullanmasını sağlayan doküman oluşturma tool’u dur. Swagger, otomatik dokümantasyon ve test senaryosu ile birlikte yaygın bir şekilde kullanılmaktadır.

Swagger, yazmış olduğumuz Rest API’lerin incelenmesi, anlaşılması ve test edilmesini sağlayan bir arayüz sağlamaktadır.

# 5. Project Images

### Hello World Application Screenshot
![Hello World Screenshot](screenshots/task1/helloWorld.png)

### GET Request Screenshot
![GET Request Screenshot](screenshots/task1/get.png)

### POST Request Screenshots
#### POST Request with Input
![POST Request with Input](screenshots/task1/post2.png)

#### POST Request Error
![POST Request Error](screenshots/task1/post1.png)

### Swagger UI Screenshots
#### Swagger UI Overview
![Swagger UI Overview](screenshots/task1/swagger1.png)

#### Swagger UI GET Method
![Swagger UI GET Method](screenshots/task1/swagger2.png)

#### Swagger UI POST Method
![Swagger UI POST Method](screenshots/task1/swagger3.png)

## Task 1 - Resources Used
1. [API / SWAGGER NEDİR ?](https://bsseylcin.medium.com/api-swagger-nedi%CC%87r-5766c5c8c2d0)
2. [Rest API Nedir, Nasıl Çalışır?](https://www.hosting.com.tr/bilgi-bankasi/rest-api/)
3. [Swagger Nedir? Ne İşe Yarar?](https://medium.com/android-t%C3%BCrkiye/swagger-nedir-ne-i%CC%87%C5%9Fe-yarar-e8c12a9e9e7f)
4. [Postman Nedir ve Nasıl Kullanılır?](https://medium.com/@ilaydakosar/postman-nedir-ve-nas%C4%B1l-kullan%C4%B1l%C4%B1r-6d5096b2a284)
5. [Postman Nedir?](https://medium.com/huawei-developers-tr/postman-nedir-83eeaa5ed6ac)
6. [RPC Nedir ve Protokolleri Nelerdir?](https://medium.com/turkiye-rust-community/rpc-nedir-ve-protokolleri-nelerdir-7db03994d3d0)
7. [Java Bean Nedir ? Spring Bean Nedir ?](https://tr.linkedin.com/pulse/java-bean-nedir-spring-emrullah-tanima-qnruf)
8. [Bean Kavramı](https://medium.com/@ismaildedec/bean-kavram%C4%B1-6c6b983a3083)
9. [Dependency Injection Nedir ? Nasıl Uygulanır ? ](https://gokhana.medium.com/dependency-injection-nedir-nas%C4%B1l-uygulan%C4%B1r-kod-%C3%B6rne%C4%9Fiyle-44f4b0d576e4)
10. [Inversion of Control ( IoC ) Nedir ve Avantajları Nelerdir?](https://gokhana.medium.com/inversion-of-control-ioc-nedir-ve-avantajlar%C4%B1-nelerdir-cf05e42c16e4)
11. [Java Dünyasının Vazgeçilmezi: Spring Nedir?](https://medium.com/@SametAkgul/java-d%C3%BCnyas%C4%B1n%C4%B1n-vazge%C3%A7ilmezi-spring-nedir-b2b5f7d658c1)

</details>

<details>
<summary><h3 style="display: inline-block">Task 2 - View Details</h3></summary>

# 1. Spring Security

_Spring Security,_ Java tabanlı uygulamalarda güvenlik işlevselliğini sağlayan kapsamlı bir çözümdür. Kullanıcı kimlik doğrulaması, yetkilendirme ve diğer güvenlikle ilgili konuları ele alır.

#### Spring Security Elementleri
1. **Authentication (Kimlik Doğrulama):** 
   + **JWT (JSON Web Token):** Bu, token tabanlı kimlik doğrulama için kullanılır. Kullanıcının yetkilendirilmesi için kullanılır ve veri alışverişi için JSON formatında bir token kullanır.
   + **Basic Auth**: Kullanıcı adı ve şifre kombinasyonunu kullanarak temel bir kimlik doğrulama mekanizmasıdır. Genellikle HTTP istemcisi ve sunucusu arasında şifreli veri göndermek için kullanılır.
2. **Authorization (Yetkilendirme):** Kullanıcıların erişebileceği kaynakların belirlenmesi ve bu kaynaklara erişim izinlerinin kontrol edilmesi.
3. **API Keys:** API anahtarları, kimlik doğrulama için kullanılan özel anahtarlar veya tokenlerdir. Uygulamalar arası iletişimde kullanılır ve belirli servislere erişim sağlar.

# 2. Temel Kimlik Doğrulama
Temel Kimlik Doğrulama, istemcinin her istekte bir kullanıcı adı ve parola gönderdiği basit ve yaygın olarak kullanılan bir kimlik doğrulama mekanizmasıdır. Kimlik bilgileri genellikle HTTP başlığında base64 kodlu bir dize olarak gönderilir.

#### Temel Kimlik Doğrulamanın Temel Bileşenleri:
1. **Kullanıcı Kimlik Bilgileri:** Kullanıcı adı ve şifreden oluşur.
2. **Base64 Kodlaması:** Kimlik bilgileri HTTP başlığında gönderilmeden önce Base64 kullanılarak kodlanır.

**Spring Security'de Temel Kimlik Doğrulamayı Uygulama:**
1. Spring Güvenlik Bağımlılığını Ekleyin.
2. SecurityConfig yapılandırma sınıfını oluşturun. [Security Config File](https://github.com/zscengiz/Hello-World-Spring-Boot/blob/main/src/main/java/com/example/hello_world/config/SecurityConfig.java)

# 3. Spring Security Mimarisi
![SpringSecurity](screenshots/task2/SpringSecurity.png)
Gelen isteği ilk olarak authentication filter karşılamaktadır.
+ Spring security mimarisinde filter aslında standart bir http filterdır.
+ Filter oluşturmak için javax.servlet paketinde bulunan filter arayüzünü implemente etmemiz gerekir.
+  Bunun sonucunda gelen trafiği doFilter() methodu karşılar.Bu method 3 parametre almaktadır bunlar ServletRequest, ServletResponse, FilterChain sınıflarıdır.
+ * **ServletRequest :** Gelen http isteğini temsil eder. Http isteğinin detaylarına bu nesne üzerinden erişebiliriz.
+ + **ServletResponse :** Cevabı istemciye göndermeden veya filter chaine devretmeden önce değiştirmek için kullanırız. Yani cevap döneceğimiz sınıftır.
+ + **FilterChain:** Uygulama geliştirirken birçok filter kullanmamız gerekebilir.Bu durumda bu filtreleri toplayan sınıftır.


## 4. Project Images

### Login Page
![Login Page](screenshots/task2/userName_Password.png)

### Successful Login
![Successful Login](screenshots/task2/message.png)

### Failed Login
![Failed Login](screenshots/task2/invalidPassword.png)

#### Get Request 
![Get Request](screenshots/task2/postmanGet.png)

#### Get Base64
![Get Base64](screenshots/task2/postmanGetBase64.png)

#### Post Request
![Post Request](screenshots/task2/postmanPost.png)

#### Post Base64
![Post Base64](screenshots/task2/postmanPostBase64.png)

## Task 2 - Resources Used
1. [Spring Security Implementation](https://medium.com/@aamir.zaidi5/spring-security-implementation-805520a297d5)
2. [Spring Security Basic Auth](https://thelogiclooms.medium.com/spring-security-basic-auth-d777138b4256)
3. [Spring Boot Uygulamalarında Security Basic Authentication Kullanım Örneği](https://blog.burakkutbay.com/spring-boot-uygulamalarinda-security-basic-authentication-kullanim-ornegi.html/)
4. [Securing API with Basic Authentication in Spring Boot](https://medium.com/javarevisited/spring-boot-securing-api-with-basic-authentication-bdd3ad2266f5)
5. [Spring Security Nedir?](https://medium.com/@ahmettemelkundupoglu/spring-security-nedir-%C3%B6rnekleriyle-anlat%C4%B1m-2bc9810f3f7b)
6. [Spring Security İşleyişi ve Basic Authentication Örneği](https://sinan-karakaya.medium.com/spring-security-i%CC%87%C5%9Fleyi%C5%9Fi-ve-basic-authentication-%C3%B6rne%C4%9Fi-28f17ef10834)
7. [Spring Security Authentication ve Authorization sistemini anlamak](https://medium.com/@hkara419/spring-security-authentication-ve-authorization-sistemini-anlamak-3996a0c02ed8)

</details>

<details>
<summary><h3 style="display: inline-block">Task 3 - View Details</h3></summary>

# 1. Authentication Filter
![AuthFilter](screenshots/task3/AuthFilter.png)
+ Kullanıcıdan gelen istek uygulamamıza erişmede AuthenticationFilter istekten kullanıcı adını ve parolayı alır ve bir nesne oluşturulmaktadır. Gelen isteğimizi authentication filter yakalıyor ve authentication managera aktarıyor.
+ Oluşturulan Authentication Nesnesinin kullanılması, filtrenin sonrasında Authentication Manager‘a gelir.
+ Authentication Manager bir interfacedir ve kimlik doğrulama metodu çalıştırılmaktadır. Authentication Manager bir interface olup, Authentication Provider‘a gönderir.
+ Kimlik doğrulama işlemlerinde hangi tipte bir doğrulama işleminin yapılacağını Authentication Provider‘a bildirir.
+ Authentication Provider, User Details Service‘i çağırır ve kullanıcı bilgilerini karşılık gelen kullanıcıyı bulur getirir. hizmetini kullanarak, kullanıcı adına karşılık gelen Kullanıcı Nesnesini getirir.
+ User Details Service içerisinde loadUserByUsername metodu içerisinde (hesap kiliti mi veya etkin mi, kimlik bilgileri süresi dolup dolmadığı)  gibi bilgilere bakarak karşılık gelen in-memory ya da veritabanı ya da hangi kaynaklardan erişmesi gerekiyorsa erişir ve gelen kullanıcı bilgilerini bulduğu bilgilerini getirir ve eğer doğru kullanıcı bulunduysa ve bulunan kullanıcının nesnesini döndürmektedir. Bu servis içerisinde kullanıcı parolasını doğrulayan Password Encoder bulunmaktadır. Password Encoder kullanıcı parolasının kodlanması ve şifresinin çözülmesi gerektiğini söyleyen arabirimdir.

# 2. JWT
![jwt2](screenshots/task3/jwt2.png)
Uygulamamızı yetkisiz kişilerden korumak ve yalnızca yetkili kullanıcıların erişimi için çeşitli yöntemler kullanırız. Bu çözümlerden birisi de token kullanmaktır. JWT ile Authorization işlemi yapabiliriz.Burada Authentication ile karıştırılmamalıyız. 
>Authentication, kimlik doğrulamadır. 

>Authorization ise sisteme giriş için yetki kontrolüdür.

Authentication birkez yapıldıktan sonra, atılan her istekte bir authorization işlemi yapılır. Tabi bu durum geliştirdiğiniz uygulamaya göre değişebilir.

### JWT(JSON Web Tokens) Yapısı

JWT ile üretilen token Base64 ile kodlanmış 3 ana kısımdan oluşmaktadır. Bunlar Header(Başlık), Payload(Veri), Signature(İmza) kısımlarıdır.

**Örnek JWT Token:** `eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdGF0dXMiOiJ0ZWJyaWtsZXIhIDopIn0.sTLXY5iAs1IzJJ-8GVP_pMR65qqgCUpbMl-aSPcrQHc`

**Header(Başlık):**
JWT’de kullanılacak bu kısım JSON formatında yazılmakta ve 2 alandan oluşmaktadır. Bunlar token tipi ve imzalama için kullanılacak algoritmanın adı. Örnek olarak:

`{
  "alg": "HS256",
  "typ": "JWT"
}`

Algoritma kısmında HS256, HMAC SHA256 ya da RSA gibi birçok farklı algoritma kullanılabilir. Type kısmında ise JWT yazmakta. Bu kısım Base64 ile encode edilir ve oluşturulacak tokenın ilk parçasını oluşturur.
**Payload**: Payload bölümünde claim listesi şeklindeki JSON objesi yer alır. İsteğe göre özelleştirilerek ekstra bilgiler (kullanıcı gibi) tutulabilmektedir. Bu bölümdeki veriler okunabildiğinden hassas veriler burada taşınmamalıdır.

Üç çeşit claim türü vardır. Bunlar; registered, public ve private claim’lerdir.
+ **Registered claims:** JWT’de önceden rezerve edilmiş claim türleri bulunmaktadır. Bu claimlerin kullanımı zorunlu değildir ancak kullanıldığında yararlı olabilecek claim türleridir.
+ **Public claims:** Registered claimler gibi ancak daha kapsamlı olan önceden kaydedilmiş claimlerdir.
+ **Private claims:** Mevcut claimler dışında uygulamanıza özel bilgileri de kullanabilirsiniz.. Örneğin adı ve email adresi gibi claim bilgileri standart kayıtlı claimler iken; kullanıcı id, yaşı, departman adı gibi daha detaylı veri içeren bilgiler private claimlerdir.

**Signature**: Signature bölümünde header, payload ve security key kullanılarak oluşturulan imza yer almaktadır. Bu bölüm üzerinden doğrulama yapılarak veri bütünlüğü garanti altına alınmaktadır.

### JSON Web Token (JWT) nasıl çalışır?
![JWT](screenshots/task3/jwt.png)
1. Uygulamaya giriş için kullanıcı adı ve şifre gerektiğinden; ilk adımda client bu bilgileri browser üzerinden HTTP Post ile sunucuya gönderiyor.
2. Gönderilen kullanıcı adı ve şifre bilgileri doğrulanıyor. Bilgilerin doğru olması durumunda bir JWT üretim işlemi yapılıyor.
3. Üretilen JWT bilgisi, isteği yapan client’a iletiliyor. Bu noktadan sonra tekrar kullanıcı adı ve şifre ile doğrulama yapılmasına gerek kalmayacaktır. Token geçerli olduğu sürece yetkilendirme işlemleri için bu token üzerinden gerçekleşecektir.
4. Bir sonraki istek, HTTP üzerinden, JWT’yi Authorization Header bilgisine eklenerek yapılıyor.
5. Sunucu, JWT imzasının geçerli olup olmadığını kontrol ederek JWT’nin doğrulamasını yapar.
6. Geçerli bir JWT gönderilmişse, Authorization işlemi onaylanarak talep edilen bilgiler client’a gönderilir.

# 3. Refresh Token ve Access Token

**Access token,** bir kullanıcının kimliğini doğruladıktan sonra verilen kısa ömürlü bir belirteçtir. Bu token, kullanıcının belirli bir süre boyunca uygulama üzerinde yetkili işlemler gerçekleştirebilmesini sağlar.

>Access tokenler, bir uygulamanın bir API’ye erişim sağlamak için kullanılır. Bir kullanıcının başarılı bir şekilde kimliğini doğruladıktan ve erişime izin verdiğinde, uygulama bir access token alır ve ardından hedef API’yi çağırırken bu access token’ı kimlik bilgisi olarak geçirir. Geçilen token, API’ye token taşıyan kişinin API’ye erişim ve yetkilendirme sırasında verilen belirli eylemleri gerçekleştirme yetkisi verildiğini bildirir. Süresi dolan token için Express server 403(forbidden) kodu ile işlemin yapılamayacağı bilgisini döndürmektedir. Hem web hem de mobil uygulamalar, bir API’ye erişim sağlamak için kullanıcıların kimliğini doğrulamak ve yetkilendirmek adına access tokenlerini kullanır.

**Refresh token,** access token süresi dolduğunda yeni bir access token almak için kullanılan uzun ömürlü bir belirteçtir. Kullanıcının kimliğini tekrar doğrulamak zorunda kalmadan, yeni access token'lar alabilmesini sağlar.

**Refresh tokenlerin kullanımı genellikle aşağıdaki adımları içerir:**

1. İlk olarak, bir kullanıcı başarılı bir şekilde kimlik doğrulaması yaptığında, sunucu hem bir access token hem de bir refresh token oluşturur ve bu token’ları kullanıcıya döndürür.
2. Kullanıcı daha sonra bu token’ları kullanarak API’ye erişebilir. Access token, API’ye erişim yetkisi verirken, refresh token, yeni bir access token almak için kullanılır.
3. Access token’ın süresi dolduğunda, kullanıcı refresh token’ı kullanarak yeni bir access token talep eder. Sunucu, refresh token’ın geçerli olduğunu kontrol eder ve geçerliyse, yeni bir access token ve yeni bir refresh token oluşturur ve bu token’ları kullanıcıya döndürür.
4. Kullanıcı, yeni alınan token’ları kullanarak API’ye erişmeye devam eder. Bu işlem, access token’ın süresi dolana kadar devam eder.



## Task 3 - Resources Used
1. [Spring Security İşleyişi ve Basic Authentication](https://medium.com/@hkara419/spring-security-authentication-ve-authorization-sistemini-anlamak-3996a0c02ed8)
2. [JWT(JSON Web Tokens) Nedir? Nasıl Çalışır?](https://tugrulbayrak.medium.com/jwt-json-web-tokens-nedir-nasil-calisir-5ca6ebc1584a)
3. [Jwt json web token nedir?Nerede Kullanılır?](https://medium.com/@latestsoftwaredevelopers/jwt-json-web-token-nedir-nerede-kullan%C4%B1l%C4%B1r-67bface90c35)
4. [JSON Web Token (JWT) Nedir? Nasıl Kullanılır?](https://erhankocabuga.com/json-web-token-jwt-nedir)
5. [Access Token-Refresh Token Nedir?](https://betulkaraman.medium.com/access-token-refresh-token-nedir-1b10449b2921#:~:text=Refresh%20tokenler%2C%20bir%20kullan%C4%B1c%C4%B1n%C4%B1n%20hassas,%C4%B1%20Identity%20Server'a%20g%C3%B6nderir.)
6. [Refresh Token ve Access Token Nedir?](https://appictohub.com/blog/21/refresh-token-ve-access-token-nedir)
7. [Spring OAuth 2.0 Refresh Token](https://medium.com/@aykanferhat/spring-oauth-2-0-refresh-token-27362b97a5b9)

</details>