# Project-RSA
Mô tả chi tiết từng file:
- Package Demo1:
  + Package Code: chứa code xử lý
    . Decryption.java --> Đọc file privateKey.txt để chuyển lại thành khóa private để giải mã dữ liệu nhập vào
    . Encrpytion.java --> Đọc file publicKey.txt để chuyển lại thành khóa public để mã hóa dữ liệu nhập vào
    . SecurityKeyPairGenerator.java --> Tạo cặp khóa privateKey và publicKey rồi mã hóa dạng byte lưu vào file text 
  + Package UI: chứa code giao diện
- Package RSA: chứa 2 file text là privateKey.txt và publicKey.txt
