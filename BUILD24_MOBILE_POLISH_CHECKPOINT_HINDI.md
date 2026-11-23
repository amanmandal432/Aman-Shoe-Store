# Build24 mobile polish checkpoint — 2026-11-23

User tested the Build24 APK on an Android phone and confirmed the Home screen banner carousel is visible. The screenshot also confirms the banner contains promotional shoe artwork, the Home screen has category shortcuts (Shoes, Slippers, Offers, All Categories), and the header has a hamburger menu plus cart.

New user-approved improvements:
1. Tapping a promotional banner should open an offer/details page, similar to marketplace banner behavior. Admin should be able to enter offer details when uploading a banner.
2. Android Back should return directly to Home from nested app screens; from Home, a second Back should ask for exit rather than requiring repeated Back presses through every activity.
3. Home category shortcuts should be configurable by the store admin (names/categories/order), rather than hard-coded.
4. Remove duplicate navigation and controls: keep More in one place; keep Dark Mode, Wishlist, Language in the hamburger More/settings area; show Sort & Filter only once on Home.
5. Admin Products and Orders View All / Show Less controls should be placed above their lists, not at the bottom.
6. Assistant may make additional sensible customer-friendly improvements, preserving all existing app flows.

Work safety:
- Build21 stable and Recovery APK/branches remain untouched.
- This work is isolated on `build24-mobile-polish-2026-11-23`, based on Build24.
- Previous Build24 test APK had passed CI; user is now reporting a successful visual Home/Banner check. This is not a full functional test.
- On this branch, the Home duplicate preference/filter toolbar and duplicate bottom More navigation item have been removed in commit `9700231ac593d5c6d6695bcd2f7dcd6cb5ff238d`.
- The banner details flow, configurable category editor, Android Back handling, and top-positioned Admin toggles remain to be implemented and tested. Do not claim these are done.
- Rebuild and validate APK after implementation. Preserve Email/Password auth, Forgot Password, My Orders, COD, Admin order status, product upload, and zero-cost Firebase approach.
