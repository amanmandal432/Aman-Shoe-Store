# Build21 Recovery Notes

Recovery branch: `build21-recovery-2026-11-21`

Source of truth: user-attached `aman_build21_nav.apk`.

## Restored
- `app/src/main/assets/index.html`: extracted from APK `assets/index.html`; recovered file is 65,999 UTF-8 characters. It contains Build21 features including `buyNow`, delivery settings, `productNewCollection`, `pullIndicator`, and `toggleCustomerPassword`.
- `app/src/main/assets/aman-gold-logo.svg`: restored from APK `assets/aman-gold-logo.svg` (the extracted APK asset's SHA-256 was recorded as 53f327cf3b7ee341581a6afca9e51c203b703d77312e7f3266bcef5d0a7e8cf2).

## APK identity observed
- Package/application ID in attached APK: `com.amanshoestore.app.otpfix`.
- Version name in attached APK: `1.3-otpfix`.
- Current branch Gradle file still says version name `1.4-build22`; it has not been changed yet.
- Existing `MainActivity.java` loads `file:///android_asset/index.html` and includes WebView file chooser support.

## Not yet restored / not yet built
- Android launcher icon: APK `res/drawable/ic_aman_logo.xml` is compiled binary XML, not plain source vector XML. The existing repository vector XML has NOT been overwritten or claimed to be Build21-exact.
- Full Android Studio/Gradle project cannot be recovered from the APK alone.
- No APK has been built or tested from this recovery branch.
- No Firebase live backend or end-to-end runtime tests were run from this branch.

Keep the installed Build21 APK as the stable version. Do not merge this branch into `main` or install a new APK until Gradle versioning, launcher icon, signing compatibility, and end-to-end tests are verified.
