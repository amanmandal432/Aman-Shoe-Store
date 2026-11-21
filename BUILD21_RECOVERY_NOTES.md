# Build21 Recovery Notes

Recovery branch: `build21-recovery-2026-11-21`

Source of truth: user-attached `aman_build21_nav.apk`.

## Restored
- `app/src/main/assets/index.html`: extracted from APK `assets/index.html`; recovered file is 65,999 UTF-8 characters. It contains Build21 features including `buyNow`, delivery settings, `productNewCollection`, `pullIndicator`, and `toggleCustomerPassword`.
- `app/src/main/assets/aman-gold-logo.svg`: restored from APK `assets/aman-gold-logo.svg`; extracted APK SHA-256: `53f327cf3b7ee341581a6afca9e51c203b703d77312e7f3266bcef5d0a7e8cf2`.

## Build configuration
- Attached Build21 APK package/application ID: `com.amanshoestore.app.otpfix`.
- Attached Build21 APK version name: `1.3-otpfix`.
- Recovery test Gradle config deliberately uses a separate package ID `com.amanshoestore.app.recoverytest`, versionCode `1`, and versionName `1.4-build21-recovery-test` so any test APK can be installed beside stable Build21.
- Existing `MainActivity.java` loads `file:///android_asset/index.html` and includes WebView file chooser support.
- `.github/workflows/build-apk.yml` is configured to build on pushes to this recovery branch and label the artifact `Aman-Shoe-Store-Build21-Recovery-Test`.

## Not yet verified / remaining
- User manually triggered GitHub Actions run #99 (run ID 44918373183) on 2026-11-21. Java setup, repository checks, and Gradle setup passed; APK compilation is currently in progress. Validation and artifact upload are still pending. No recovery APK is available yet.
- Android launcher icon: APK `res/drawable/ic_aman_logo.xml` is compiled binary XML, not plain source vector XML. The existing repository vector XML has NOT been overwritten or claimed to be Build21-exact.
- Full Android Studio/Gradle project cannot be recovered from the APK alone.
- No Firebase live backend or end-to-end runtime tests were run from this branch.

Keep installed Build21 as the stable version. Do not merge this branch into `main` or install a new APK until the recovery build and runtime tests are verified.
