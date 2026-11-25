# Aman Shoe Store — Build30 Category Image Grid Checkpoint (2026-11-25)

## User test feedback on Build29
- APK installed successfully.
- Full-screen home page works correctly.
- Customer reviews and star ratings work.
- Admin can see and delete reviews and ratings.
- User reported requested category image-grid redesign did not appear in Build29.

## Build30 changes in isolated branch
- Branch: `build30-category-image-grid-2026-11-25`
- Base: `build29-reviews-fullscreen-categories-2026-11-25`
- Android app asset `app/src/main/assets/index.html` updated.
- Home Shop by Category now uses a two-column image card grid with square images, category title and product count (instead of small emoji-only shortcut chips).
- Categories screen uses the same large image cards.
- Product images are sourced from existing product image data; icon placeholders remain only when a category has no matching product photo.
- Default category tiles: Kids, Slippers, Sports Sandal, High Top Sneakers, Sports Shoes, Walking Shoe, Casual Shoes.
- Existing custom admin categories are preserved and appended.
- Category product matching checks product category and product name keywords; tapping a category filters the matching products.
- Version bumped to 1.10-build30 / versionCode 12.
- APK workflow configured for Build30 branch.

## Pending
- Wait for Build30 APK workflow to complete.
- Install and test on phone. Confirm categories show image cards, tap filters correctly, and previous Build29 features remain working.
- Build21 stable and Recovery APK remain untouched.
