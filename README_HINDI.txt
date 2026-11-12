AMAN SHOE STORE ANDROID PROJECT

Is package mein Android WebView wrapper + website assets hain.
App ID: com.amanshoestore.app
App name: Aman Shoe Store

APK build karne ke liye:
1. Android Studio (latest stable) computer par install karein.
2. Is ZIP ko extract karein.
3. Android Studio > Open > AmanShoeStore folder select karein.
4. Gradle sync complete hone dein.
5. Build > Build Bundle(s) / APK(s) > Build APK(s).
6. APK app/build/outputs/apk/debug/app-debug.apk par milega.

NOTE:
- Yeh Android source project hai, compiled APK abhi nahi.
- Firebase Firestore Rules/Admin Authentication separately secure/configure karna zaroori hai.
- WebView app mein website network/Firebase access ke liye internet permission included hai.

UPDATE 10-11-2026: APK asset index.html replaced with FINAL Firebase Auth version. Admin login uses Firebase email/password + verified Admin UID (not demo 1234). Firestore Rules must permit the admin UID to list/update orders.


BUILD 13 – PRODUCT MANAGEMENT UPDATE
Admin Panel me Product Management add hua hai: shoes/slippers, photo upload, size, colour, selling price, MRP, stock, edit aur delete. Customer shop Firestore products collection se live update hoti hai. Android WebView me gallery/photo picker support bhi add kiya gaya hai.

Firebase Storage ko project aman-shoe-store me enable karke FIREBASE_RULES_SETUP_HINDI.txt ke product rules add/publish karna zaroori hai. Existing orders rules ko delete/replace na karein.
