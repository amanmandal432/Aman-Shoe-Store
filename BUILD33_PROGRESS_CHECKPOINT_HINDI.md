# Aman Shoe Store — Build33 Category Carousel Checkpoint (2026-11-25)

## User confirmation on Build32
- Build32 installed and opened correctly; Welcome screen/startup issue resolved.
- Remaining feedback: large square image category cards made the home page look cluttered; user prefers small circular category images in a horizontal swipe/slide row.
- Tapping categories did not appear to open matching products.

## Build33 changes
- Isolated branch: `build33-category-carousel-fix-2026-11-25`
- Base branch: `build32-splash-startup-hotfix-2026-11-25`
- Home category strip changed to horizontal swipe carousel with compact circular product/category images, labels, snap scrolling and hidden scrollbar.
- Categories page keeps its larger image cards.
- Category tap now clears search/category dropdown conflicts, opens Shop, renders filtered products, and smoothly scrolls to the product list.
- Category matching also checks brand text in addition to category and product title.
- App version bumped to 1.13-build33 / versionCode 15.
- Build21 stable and Recovery APK untouched.

## Pending
- Wait for Build33 APK workflow.
- Install and verify circular category carousel look, category tap navigation and matching products.
- Retest startup, reviews, rating, image display, cart, COD orders, admin and full-screen mode.
