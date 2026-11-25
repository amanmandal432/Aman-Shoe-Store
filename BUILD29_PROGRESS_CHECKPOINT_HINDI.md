# Aman Shoe Store — Build29 Progress Checkpoint (2026-11-25)

## Safety
- Stable Build21 and Recovery APK/branch remain untouched.
- Build28 source branch remains untouched.
- New isolated working branch: `build29-reviews-fullscreen-categories-2026-11-25`
- Base: `build28-welcome-splash-2026-11-24`

## Implemented in Build29 branch
1. Android immersive header: MainActivity sets `FLAG_FULLSCREEN` to hide Android status bar (time, notifications, network and battery icons). Android navigation controls are not intentionally hidden.
2. Categories: image-card grid with square thumbnails. Existing product photos are used when a category has products; friendly icon placeholders are shown for empty categories. Category labels include Kids, Slippers, Sports Sandal, High Top Sneakers, Sports Shoes, Walking Shoe, Casual Shoes, plus existing categories.
3. Admin Reviews: Admin Panel has Customer Feedback & Reviews section. It reads reviews from each product's `products/{productId}/reviews` subcollection, displays customer, product, star rating and text, shows latest 5 with View More / Show Less, and allows admin deletion after confirmation.
4. Review form now includes 1–5 star rating; review documents store numeric `rating`. Existing reviews without rating display as 5 stars for backward compatibility.
5. Android app version bumped to 1.9-build29 / versionCode 11.

## Important verification still pending
- Android APK build workflow has been triggered automatically and is currently IN PROGRESS (run #140).
- APK is not yet verified or ready to install; wait for the workflow to finish, then test on phone before calling Build29 ready.
- Test customer review submit/display, admin review list/delete, category image cards and taps, status bar hidden, plus login/cart/COD/orders/product upload.
- Firestore rules currently published by user; review delete requires admin delete permission on the nested review documents. If deletion fails, inspect rules and update safely.

## Existing known constraints
- Customer review data is stored under each product's nested `reviews` subcollection.
- Build21 is the protected stable version; do not overwrite it.
