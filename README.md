# 🏛️ Ege Müze Rehberi 

**Ege Müze Rehberi**, Ege Bölgesi'nde yer alan tarihi ve kültürel zenginlikleri, antik kentleri ve müzeleri kullanıcıların keşfetmesini sağlayan **Android (Java)** tabanlı bir mobil uygulamadır.

---

## ✨ Öne Çıkan Özellikler

* 🔐 **Kullanıcı Yönetimi:** Güvenli Giriş (`MainActivity`) ve Kayıt Olma (`RegisterActivity`) ekranları.
* 📜 **Dinamik Müze Listesi:** `RecyclerView` yapısı kullanılarak performanslı bir şekilde sıralanan Ege müzeleri (`HomeActivity`).
* 🔍 **Anlık Arama & Filtreleme:** `SearchView` bileşeni ve `onQueryTextChange` dinleyicisi ile müzeler arasında anlık arama yapabilme.
* ℹ️ **Detaylı Bilgi Sayfası:** Her müze için özel açıklamalar, yüksek kaliteli görseller ve değerlendirme sistemi (`DetailActivity`).
* 🌐 **Uygulama İçi Web Tarayıcısı:** `WebView` mimarisi sayesinde uygulamadan çıkmadan resmi müze sitelerine (`muze.gov.tr`) erişim (`WebActivity`).
* 🗺️ **Harita & Yol Tarifi Entegrasyonu:** Android `Geo Intent` yapısı kullanılarak cihazın orijinal Google Haritalar uygulamasını tetikleme ve konuma yönlendirme.
* 🖱️ **Context Menu Desteği:** Liste elemanlarına uzun basıldığında açılan dinamik etkileşim menüsü.

---

## 🛠️ Kullanılan Teknolojiler ve Yapılar

* **Dil:** Java
* **UI/UX:** XML, CardView, RecyclerView, SearchView, RatingBar, WebView
* **Mimari / Desenler:** Adapter Pattern (`MuseumAdapter`), Intent Data Passing, Event Listeners
* **Geliştirme Ortamı:** Android Studio

---

## 📁 Proje Klasör Yapısı

```text
com.zehranur.egemuzerehberi
 ├── MainActivity.java      # Giriş (Login) Ekranı
 ├── RegisterActivity.java  # Kayıt Olma Ekranı
 ├── HomeActivity.java      # Ana Sayfa ve Arama/Filtreleme Listesi
 ├── DetailActivity.java    # Müze Detay, Harita ve Web Butonları
 ├── WebActivity.java       # WebView Şablon Sayfası
 ├── Museum.java            # Müze Veri Modeli (Model)
 └── MuseumAdapter.java     # RecyclerView Bağlayıcısı (Adapter)
