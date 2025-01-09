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
</details>

<details>
<summary><h3 style="display: inline-block">Task 2 - View Details</h3></summary>

## Task 2 - Resources Used
1. [Spring Security Implementation](https://medium.com/@aamir.zaidi5/spring-security-implementation-805520a297d5)
2. [Spring Security Basic Auth](https://thelogiclooms.medium.com/spring-security-basic-auth-d777138b4256)
3. [Spring Boot Uygulamalarında Security Basic Authentication Kullanım Örneği](https://blog.burakkutbay.com/spring-boot-uygulamalarinda-security-basic-authentication-kullanim-ornegi.html/)
4. [Securing API with Basic Authentication in Spring Boot](https://medium.com/javarevisited/spring-boot-securing-api-with-basic-authentication-bdd3ad2266f5)
## Screenshots

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

</details>

<details>
<summary><h3 style="display: inline-block">Task 3 - View Details</h3></summary>
</details>