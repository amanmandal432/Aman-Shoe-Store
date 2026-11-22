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


## Update — 2026-11-22 implementation pass

Implemented on the isolated Build23 branch:
- Product cards now use a cleaner two-column marketplace layout with product photo, brand, name, selling price, MRP, discount, rating placeholder/available rating, stock and delivery text. Tapping the card opens product details.
- Product detail view now has gallery thumbnails and swipe navigation, selectable colour and size chips, an approximate size guide, product/brand/stock details, Add to Cart and Buy Now.
- Product admin form now includes a description field; save and edit preserve it.
- Added a home banner carousel with swipe, dots and 4.5-second auto-advance.
- Added admin banner upload and delete UI. Banner photos are compressed client-side and saved in a Firestore `banners` collection, without Firebase Storage.
- Android version set to versionCode 6 and versionName `1.5-build23`.
- JavaScript inline script syntax compilation passed.

GitHub:
- Draft PR opened: https://github.com/amanmandal432/Aman-Shoe-Store/pull/2
- PR #2 is open and not merged.
- Latest branch commit at this checkpoint: `8f65c35c6fa2eef581aa39ef4326721c1b860393`.
- A workflow run has not yet been observed for the PR commit. The APK has NOT yet been built or validated.
- The workflow file on this branch now includes a pull_request trigger, but because that workflow change itself is part of this PR and the base branch may not yet contain the trigger, do not assume a PR check will start automatically. A manual workflow_dispatch on the Build23 branch may be needed.

Important remaining checks:
1. Confirm Firestore security rules permit public read and admin-only create/delete for `banners`. No rules file was found in this repository, so do not assume banner writes will work until checked in Firebase Console.
2. Check Android GitHub Actions build and APK artifact; fix any Gradle/build errors.
3. Install Build23 APK on user's phone and test all flows: product cards, details/gallery, sizes/colours, Add to Cart, Buy Now, checkout, customer login, Forgot Password, My Orders, admin products, admin banner upload/delete, banner swipe/auto-slide, admin orders/status.
4. Do not merge PR #2 or replace Build21/Recovery until the user has tested and approved the APK.


## Latest automation update
- APK workflow push trigger now includes `build23-shopping-ui-2026-11-22`.
- APK artifact name changed to `Aman-Shoe-Store-Build23-Verified`.
- Workflow source updated in the Build23 branch. Waiting for a GitHub Actions run; no APK artifact is confirmed yet.


## APK build result — 2026-11-22
- GitHub Actions run #107, run ID `45039546820`, completed with conclusion `success`.
- All 8 relevant workflow steps passed, including Android project verification, Gradle APK build, APK validation (ZIP integrity and required app assets/classes), and artifact upload.
- Verified artifact: `Aman-Shoe-Store-Build23-Verified`, artifact ID `14761152123`, size 33,322 bytes (artifact ZIP), expires 2027-02-20.
- Run page: https://github.com/amanmandal432/Aman-Shoe-Store/actions/runs/45039546820
- Artifact download API: https://api.github.com/repos/amanmandal432/Aman-Shoe-Store/actions/artifacts/14761152123/zip
- APK build is successful and artifact is available. It has NOT yet been installed and tested on the user's phone. Do not merge the draft PR or call Build23 stable until device testing and Firebase banner-rule verification are complete.


## Step-by-step continuation checkpoint — 2026-11-22 (evening)
- User approved continuing the screenshot-based professional e-commerce plan and requested that progress be saved after each step.
- Repository audit completed: default branch is `main`; Build23 work remains isolated on `build23-shopping-ui-2026-11-22`.
- Build23 branch is 8 commits ahead of `main`; comparison confirms `main` is the unchanged base at `dcc97605e3b268ad2dce563ca2e1adba9f60d935`.
- Build21 stable and `build21-recovery-2026-11-21` remain separate and untouched.
- Draft PR #2 remains open, not merged: https://github.com/amanmandal432/Aman-Shoe-Store/pull/2
- Build23 Android config: versionCode 6, versionName `1.5-build23`.
- Latest successful GitHub Actions run #109, ID `45039712740`, on commit `6fea62a77d570f9aa40c558ddf5ac4ea3a70f5e6`. All build, Android-project verification, APK validation and artifact-upload steps passed.
- Latest verified artifact: `Aman-Shoe-Store-Build23-Verified`, artifact ID `14760544923`, artifact ZIP size 33,322 bytes, not expired; expires 2027-02-20.
- Important: successful CI build does not equal device testing. Build23 APK has not yet been installed/tested by the user and is NOT stable.
- Code review confirms Build23 adds marketplace-style product cards, gallery/details, size/colour selection, size chart, Add to Cart/Buy Now, product descriptions, and a Firestore-backed banner carousel/admin upload-delete using compressed images (no Firebase Storage dependency).
- Remaining mandatory checks: (1) inspect/verify Firestore rules for `banners` read and admin-only writes in Firebase Console; no rules file exists in this repo, so access cannot be assumed; (2) user installs and tests the Build23 APK end-to-end; (3) only after user approval consider merging PR #2. Do not change Build21, Recovery, or main before then.
- Preserve Firebase Email/Password login, Forgot Password, My Orders, COD checkout, admin orders/status, existing product/order data, and zero-cost Firebase approach.


## Latest verified artifact checkpoint — 2026-11-22
- Latest observed Build23 GitHub Actions run: #109, run ID `45039712740`, event `pull_request`, conclusion `success`.
- All build job steps completed successfully: Android project verification, Gradle APK build, APK validation and artifact upload.
- Artifact for this exact run: `Aman-Shoe-Store-Build23-Verified`, artifact ID `14760544923`.
- Artifact ZIP was downloaded and extracted; it contains `app-debug.apk` (37,317 bytes).
- APK ZIP integrity test passed and it contains `assets/index.html`, `classes.dex`, and `AndroidManifest.xml`.
- This confirms the APK package was built and structurally validated. It has NOT yet been installed or functionally tested on the user's phone.
- Outstanding before release: install and test Build23 on-device; verify Firestore rules for the new `banners` collection (public read, admin-only writes). Keep PR #2 unmerged and Build21/Recovery untouched until user approval.


## On-device Build23 test checkpoint — 2026-11-22 (user-reported)
- User reports Build23 was downloaded and opened/installed after resolving the package conflict (treat as user-reported device test; do not claim independent device verification).
- Home screen is still very similar to the previous design, with only a small visible change; it does not yet meet the intended professional home-page redesign.
- Banner: user added/set a banner in Banner Settings, but it does not appear on the customer Home screen. This is a confirmed user-reported defect to investigate first. Possible areas to inspect: Firestore `banners` collection rules/read access, saved document shape/active status, and home carousel query/render logic. Do not assume the cause until inspected.
- Buy Now button is still blue; desired design in the plan is yellow. Visual styling issue.
- Admin Panel: all uploaded products and all orders are displayed at once; there is no Hide/Collapse or View More control. Desired improvement: compact summaries with View More / Show All or collapse controls, separately for product uploads and orders.
- Current Build23 is TEST ONLY, not stable/release approved. Do not merge PR #2 or modify main/Build21/Recovery.
- Next work priority: inspect branch code for banner save/query/render mismatch and Firestore rules guidance; then fix banner display and test. Also correct Buy Now button color and add compact admin sections with View More/Show All. Preserve all existing login, orders, COD, and admin status functionality. Rebuild a new test APK and repeat user testing.
- User explicitly requested this progress be saved step by step; this entry records the exact observed issues and next priorities.

## Build24 autonomous improvement checkpoint — 2026-11-22
- User explicitly authorized the assistant to make sensible improvements independently, step by step, with the goal of a polished professional shoe-shopping app inspired by large marketplaces (not a copy of another brand), and asked that progress be saved.
- Created isolated branch: `build24-professional-store-fixes-2026-11-22`, based on the Build23 development branch. Main, Build21 and Recovery remain untouched.
- Build24 source improvements committed in `app/src/main/assets/index.html`:
  1. Reworked home hero area with a premium blue promotional header, clear shopping message and benefit chips.
  2. Added quick category shortcuts for Shoes, Slippers, Offers and All Categories.
  3. Improved home banner fallback: the banner region no longer disappears when no banner records are returned; it displays a designed fallback instead.
  4. Banner listener now restarts after Firebase auth state changes and clears its failed subscription on permission/error; a visible diagnostic message points to Firestore banner read permission if access is denied.
  5. Corrected Buy Now button specificity so yellow styling wins over generic card button CSS.
  6. Admin Products and Orders now show the latest five by default, with View All / Show Less controls when more than five exist; existing edit/delete and order-status update handlers remain in use.
- Android app version bumped to `versionCode 7`, `versionName 1.6-build24`.
- Important limitation: Firestore security rules are not stored in this repository and the live rules were not accessible for inspection. Banner upload by admin does not prove public customer reads are allowed. If the app shows the new permission diagnostic, Firebase Console Firestore Rules must allow public read on `/banners/{bannerId}` while restricting create/update/delete to the configured admin UID. Do not overwrite the user's existing rules; merge this match into the existing ruleset only after inspecting it.
- Build24 is development/test only. It has not yet passed GitHub Actions, APK installation or end-to-end device testing. Do not merge or call it final/stable.
- Next steps: open a draft PR for Build24 to main so CI runs; inspect CI/APK validation; then ask user to install/test the new APK. Preserve email/password login, forgot password, customer order history, COD checkout, admin order status, Firestore products/orders, and zero-cost Firebase design.
## Build24 CI and PR checkpoint — 2026-11-22
- Draft PR #3 opened: https://github.com/amanmandal432/Aman-Shoe-Store/pull/3 (base main, not merged).
- Updated APK workflow to include Build24 branch push builds and use artifact name `Aman-Shoe-Store-Build24-Verified`.
- GitHub Actions run #117, ID `45044034245`, is running for the latest Build24 branch commit `532604380b7d593cb7d0b9d1e4305d0ad5d54822` (push event). Initial verification and Gradle setup steps have passed; Gradle APK build was in progress at checkpoint time. No Build24 APK artifact is confirmed yet.
- Earlier PR event run #116, ID `45044014638`, was also in progress against the earlier branch head. Prefer run #117 for the latest source state.
- No APK link should be offered until the latest run completes successfully and its artifact is downloaded and validated.