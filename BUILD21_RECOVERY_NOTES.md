# Build21 Recovery Notes

Recovery branch: `build21-recovery-2026-11-21`

Source of truth: user-attached `aman_build21_nav.apk`.

## Restored and verified
- `app/src/main/assets/index.html`: exact APK asset; SHA-256 `a41c5ab7edb0879748bc417c94c947cc8662d643a9cd13e9a0603a5945b0da29`.
- `app/src/main/assets/aman-gold-logo.svg`: exact APK asset; SHA-256 `53f327cf3b7ee341581a6afca9e51c203b703d77312e7f3266bcef5d0a7e8cf2`.
- Recovery APK #99 contains the exact same `index.html` and logo hashes as attached Build21.
- Verified feature markers in recovered HTML include `buyNow`, delivery settings, `productNewCollection`, `pullIndicator`, and `toggleCustomerPassword`.

## Recovery test APK
- GitHub Actions run #99, ID `44918373183`, completed successfully on 2026-11-21.
- Artifact: `Aman-Shoe-Store-Build21-Recovery-Test`, artifact ID `14712871164`.
- Downloaded APK archive passed ZIP integrity check; APK contains `classes.dex`, `assets/index.html`, logo, AndroidManifest, resources and signing metadata.
- APK size: 36,596 bytes.
- This is a debug recovery-test APK, not a production release.
- Gradle config uses a separate package ID `com.amanshoestore.app.recoverytest` and version name `1.4-build21-recovery-test`, intended to coexist with installed Build21.
- Runtime/Firebase/end-to-end testing on a real phone has NOT been done yet.

## Known difference / remaining
- Launcher icon XML in recovery APK is not byte-identical to Build21 APK's compiled vector resource. Build21 original icon asset was not restored into editable source; do not claim icon exact.
- The APK does not contain the full Android Studio/Gradle project.
- Do not merge this branch into `main` or replace installed Build21. Test recovery APK separately first.
