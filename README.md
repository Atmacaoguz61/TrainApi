# TrainApi


Bu proje, tren rezervasyon sisteminde doluluk oranlarına göre koltuk rezervasyonu yapılabilirliğini hesaplayan bir **RESTful API** uygulamasıdır.  
Kullanıcıdan gelen rezervasyon taleplerini değerlendirir, %70 doluluk kuralına göre uygun vagonlara yerleşim önerisi sunar.




## Özellikler

- Bir tren içinde birden fazla vagon tanımlanabilir.  
- Her vagonun farklı kapasitesi ve dolu koltuk sayısı bulunur.  
- Online rezervasyonlarda bir vagonun doluluk oranı %70'i geçemez.  
- Rezervasyon isteğinde birden fazla kişi olabilir.  
- İsteğe göre yolcuların aynı vagonda veya farklı vagonlara yerleştirilebilmesi desteklenir.  
- Rezervasyon yapılabiliyorsa, sistem hangi vagona kaç kişinin yerleşeceğini döner.  
- Rezervasyon yapılamıyorsa, API `RezervasyonYapilabilir: false` ve boş bir liste döner.  
- API, Swagger UI üzerinden test edilebilir.




## Kullanılan Teknolojiler

- **Java 17** – Proje dili.  
- **Spring Boot 3.5.7** – Uygulama çatısı (REST API geliştirme için).  
- **Maven** – Bağımlılık yönetimi ve proje yapısı.  
- **Swagger UI** – API dokümantasyonu ve test arayüzü.  
- **Spring Web** – HTTP isteği/cevabı yapısı ve controller katmanı için.





## Proje Yapısı

Proje katmanlı mimari (Controller - Service - DTO - Entity) yapısına göre düzenlenmiştir. Veritabanı bağlantısı yapılmamıştır.






## API Kullanımı

### Endpoint

### İstek (Request) Örneği

POST /api/reservations


{
  "Tren": {
    "Ad": "Başkent Ekspres",
    "Vagonlar": [
      {"Ad": "Vagon 1", "Kapasite": 100, "DoluKoltukAdet": 68},
      {"Ad": "Vagon 2", "Kapasite": 90, "DoluKoltukAdet": 50},
      {"Ad": "Vagon 3", "Kapasite": 80, "DoluKoltukAdet": 80}
    ]
  },
  "RezervasyonYapilacakKisiSayisi": 3,
  "KisilerFarkliVagonlaraYerlestirilebilir": true
}



    Eğer rezervasyon yapılabiliyorsa:
    RezervasyonYapilabilir = true
    ve hangi vagonlara kaç kişi yerleştiği bilgisi döner.

    Eğer rezervasyon yapılamıyorsa:
    RezervasyonYapilabilir = false
    ve YerlesimAyrinti boş liste olarak döner.






## Projeyi Çalıştırma ve Swagger Kullanımı

1-Proje dizininde terminali açın:
cd TrainApi

2-Maven kullanarak projeyi çalıştırın:
mvn spring-boot:run

3-Uygulama varsayılan olarak aşağıdaki adreste başlar:
http://localhost:8080

4-Swagger arayüzüne erişmek için tarayıcıdan şu adresi açın:
http://localhost:8080/swagger-ui/index.html

5-Swagger ekranında POST /api/reservations endpoint’ini seçip
örnek JSON isteğini göndererek rezervasyon işlemini test edebilirsiniz.



