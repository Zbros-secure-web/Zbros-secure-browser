# 🛡️ Zbros-secure-web

**Zbros-secure-web** adalah browser Android berbasis WebView yang dirancang dengan fokus utama pada keamanan tingkat tinggi, privasi data, dan kebebasan kustomisasi melalui sistem plugin internal.

## 🚀 Fitur Utama
* **Secure Plugin Injection**: Menggunakan sistem injeksi JavaScript yang tersimpan di penyimpanan internal privat (`/data/user/0/...`), sehingga tidak bisa diakses atau dimodifikasi oleh aplikasi lain.
* **Hybrid Developer Tools**: Dilengkapi dengan fitur *Inspect Element* bawaan menggunakan Eruda untuk memudahkan analisis web langsung dari HP.
* **Privacy Hardened**: Blokir otomatis terhadap cookie pihak ketiga, pelacakan, dan memaksa penggunaan protokol HTTPS.
* **Single-Handed UI**: Desain antarmuka dengan bar navigasi di bagian bawah (Kiwi Style).

## 📂 Struktur Proyek
Proyek ini menggunakan struktur monorepo:
* `app/src/main/java/com/zbros/secure/`: Logika inti browser dan sistem keamanan.
* `app/src/main/assets/default_plugins/`: Koleksi plugin standar (bawaan).
* `app/src/main/res/layout/`: Desain antarmuka pengguna (UI).

## 🛠️ Cara Membangun (Build)
1. Clone repositori ini.
2. Buka proyek menggunakan **Android Studio**.
3. Klik 'Build APK' atau jalankan langsung ke perangkat Android kamu.

## 👥 Kontributor
* **Nasa (Komandan)** - Lead Developer / System Architect
* **Pilot (Asisten)** - AI Support & Logic Implementation

---
**Catatan Keamanan:** Zbros sangat melarang penggunaan penyimpanan eksternal (SDCard) untuk file sensitif guna menghindari celah keamanan *Shared Storage Vulnerabilities*.