# Aman Shoe Store — Build32 Startup Hotfix Checkpoint (2026-11-25)

## User issue
Build31 installed but app remained stuck on Welcome screen and would not open Home.

## Diagnosis
- Inspected the exact Build31 Android asset JavaScript.
- Build30 introduced a malformed duplicate fragment after the `showCategoryProducts` function:
  `}(name){...}`
- This caused a JavaScript SyntaxError ("Unexpected token '{'") during parsing, preventing the app's main script from running; the splash timeout was inside that main script, so it never dismissed.
- Confirmed Build29 script syntax passes; Build30 and Build31 scripts fail.

## Build32 hotfix
- Branch: `build32-splash-startup-hotfix-2026-11-25`
- Removed the malformed duplicate fragment.
- Added an independent splash fallback timer before the app's main script, so a future main-script error cannot leave the Welcome screen permanently stuck.
- Version: 1.12-build32, versionCode 14.
- Verified both inline scripts parse successfully using JavaScript syntax validation.
- Build21 stable and Recovery APK untouched.

## Pending
- Wait for GitHub Actions Build32 APK workflow.
- Install Build32 and confirm it exits Welcome screen to Home.
- Re-test Build30 category photo cards and Build31 product card/rating/nav changes, then retest review, cart, order and admin flows.
