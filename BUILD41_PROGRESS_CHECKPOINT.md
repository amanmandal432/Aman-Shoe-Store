# Build41 Checkpoint — 26 Nov 2026

Branch: build41-order-permissions-direct-buy-links-2026-11-26
Base: Build40. Build21 stable and Recovery APK remain untouched.

## User-reported issues and code changes
1. Checkout screenshot showed Firestore "Missing or insufficient permissions" while confirming order.
   - Added stable orderId and stockChanges map to pending order payload.
   - Product stock decrement now writes lastOrderId and lastOrderQty alongside stock.
   - Added BUILD41_FIRESTORE_STOCK_RULES_HINDI.txt with a narrow Firestore allow-update clause. This rule addition MUST be published manually in Firebase Console inside existing match /products/{productId}; do not replace the full ruleset. Existing order-create rule must still allow a customer to create their own order.
2. Size chart changed from vertical table to horizontal size cards in one row/wrapping row.
3. Share text now includes a deep link: https://aman-shoe-store.web.app/?product=<productId>
   - Hosted public/index.html uses same app code and opens product detail from ?product= ID.
   - Firebase Hosting config and public logo added.
   - Hosting workflow deploys on Build41 branch pushes.
4. Buy Now no longer calls addDetailToCart or mutates cart.
   - It sets a checkout-only override with selected product/size/color/quantity.
   - Existing cart contents remain untouched.
   - Review and final confirmation remain in checkout flow.

## Version
- versionCode 20
- versionName 1.18-build41

## Validation / build
- Both inline JavaScript blocks pass syntax checks.
- Build41 APK workflow succeeded for source commit 1eaff8611e9906a9dae8ded04dc94170cd368409; artifact Aman-Shoe-Store-Build41 downloaded and APK extracted.
- Later commit synced public/index.html to the corrected app code; latest APK rebuild and Hosting redeploy triggered for commit 999ab777a4a2674f6ebb2e879fb48b55c460160f. Confirm those final workflow runs before claiming final deploy complete.
- Manual Firestore rule publish remains required; this is not deployable through this repository workflow.
