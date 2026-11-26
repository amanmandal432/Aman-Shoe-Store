# Build38 Progress Checkpoint — 26 November 2026

Branch: `build38-stock-login-polish-2026-11-26`
Base: Build37 order review + delivery landmark branch. Build21 stable and Recovery APK remain untouched.

## Fixes included
1. **Atomic stock deduction on final order confirmation**
   - Final confirmation reads each product's current Firestore stock inside a transaction.
   - Rejects the whole order if any product is missing or requested quantity exceeds available stock.
   - Deducts quantities and creates the order in the same transaction, preventing overselling and partial updates.
   - Duplicate cart lines for the same product are aggregated before checking stock.
2. **Visible stock status**
   - Product cards show In Stock quantity, low-stock warning, or Out of Stock.
3. **Customer login redesign**
   - Flipkart/Amazon-inspired clean account card, Login / Create Account tabs, clearer email/password fields, secure-account hint and prominent yellow sign-in action.
   - Restored password show/hide eye control.
   - Forgot Password remains available.
4. Updated Android app version to versionCode 17 / versionName 1.15-build38.
5. Android WebView app asset updated at `app/src/main/assets/index.html`; root `index.html` updated too.

## Validation
- Inline JavaScript in the Android app asset passes JavaScript syntax compilation.
- Build21 stable and Recovery APK were not changed.
- APK build artifact has not yet been produced/verified. GitHub Actions run list currently shows no Build38 run; do not call this an installable APK until a successful workflow artifact exists.

## Important test cases
- Stock 5, order quantity 5: order succeeds, stock becomes 0, product shows Out of Stock.
- Stock 5, order quantity 6: order is rejected; stock remains 5 and no order document is created.
- Two customers ordering concurrently: transaction must prevent stock from going negative.
- Login eye toggles password visibility; Create Account tab asks for name; Forgot Password still works.
