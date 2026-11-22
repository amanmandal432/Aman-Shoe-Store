# Aman Shoe Store — Build23 Work Plan

Checkpoint date: 2026-11-22

## User-approved changes

The user supplied three reference screenshots and approved these Build23 improvements:

1. **Home product listing**
   - Two-column mobile product grid.
   - Product image, brand, product name, selling price, MRP, discount and rating.
   - Tapping a product card/image opens its full product detail page.
   - Keep existing search, category, brand, size and colour filters.

2. **Product details**
   - Large product image with swipeable gallery.
   - Colour selection and size selection.
   - Size chart.
   - Brand, product name, description, selling price, MRP/discount, stock and delivery information.
   - Add to Cart and Buy Now actions.
   - Preserve current cart/checkout/order logic and Firebase customer/admin flows.

3. **Home banner carousel**
   - Multiple shoe/slipper promotional banners.
   - Swipe to move between banners and automatic sliding.
   - Admin can add, edit and remove banners.
   - Use a Firebase-compatible zero-cost approach; do not introduce Firebase Storage/Blaze billing dependency. Evaluate compressed image data URLs in Firestore with conservative size limits, or another free-compatible option already used by the app.

## Safety and release rules

- Do not modify Build21 or its backup branches.
- Do not modify the tested Recovery APK or its recovery branch.
- Do not publish Build23 as stable until code review, successful GitHub Actions build, APK validation, installation and user testing are complete.
- Preserve Firebase Email/Password login, Forgot Password, My Orders, COD checkout, Admin Orders and order-status changes.
- Keep the existing Firebase Firestore product/order data compatible.
- Do not add Firebase Storage dependency or paid billing requirement.

## GitHub work branch

Repository: `amanmandal432/Aman-Shoe-Store`

New isolated branch: `build23-shopping-ui-2026-11-22`

Branch base commit: `dcc97605e3b268ad2dce563ca2e1adba9f60d935`
Commit message at base: `Label verified APK artifact as Build22`

The current app source inspected on this branch is:
- `app/src/main/assets/index.html`
- Existing product records already support `brand`, `price`, `mrp`, `sizes`, `colors`, `images`, `image`, `description` and `stock`.
- Existing product cards already use a two-column grid and include photo, price, discount and rating, but currently also show inline size/colour selectors and need a more polished card layout with a clearer brand line and card-wide detail navigation.
- Existing product details already support a multi-image gallery with swipe, size/colour selectors, description, stock and Add to Cart. Size chart, Buy Now, delivery estimate and stronger layout still need implementation.
- Existing admin product upload compresses images into Firestore-compatible data URLs without requiring Firebase Storage.
- No banner carousel or admin banner management was found in the inspected HTML source.

Android app Gradle config currently reports versionCode 5 and versionName 1.4-build22. Update the version for Build23 only after implementation is ready.

## Current status

- User has approved the design scope.
- Isolated Build23 branch has been created from the verified Build22 source.
- No production/default branch, Build21 backup, or Recovery branch has been modified.
- UI implementation and Build23 APK build have not yet been completed.
- Next work: implement the product card/detail improvements and Firestore-backed admin banner carousel on this branch, then increment Android version and run GitHub Actions verification.
