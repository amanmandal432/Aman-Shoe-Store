# Build21 Recovery Notes

Recovery branch: `build21-recovery-2026-11-21`

Source of truth: user-attached `aman_build21_nav.apk`.

## Restored
- `app/src/main/assets/index.html`: recovered from APK `assets/index.html`.
- `app/src/main/assets/aman-gold-logo.svg`: recovered from APK `assets/aman-gold-logo.svg`.

## Verified in recovered HTML
The recovered branch file contains the Build21-specific symbols:
- `buyNow`
- `currentDeliveryFee`
- `loadDeliverySettings` / `saveDeliverySettings`
- delivery settings UI identifiers
- `productNewCollection`
- `pullIndicator`
- `toggleCustomerPassword`

## Not yet restored / not yet built
- The APK's `res/drawable/ic_aman_logo.xml` is Android compiled binary XML, not editable plain-text vector XML. It was deliberately not copied over the source project file.
- The APK does not include the full Android Studio / Gradle project.
- Gradle application ID and version configuration have not been changed.
- No APK has been built or tested from this recovery branch yet.

Keep the installed Build21 APK as the stable version. Do not merge this branch into `main` or install a new APK until package identity, build configuration, and end-to-end tests are verified.
