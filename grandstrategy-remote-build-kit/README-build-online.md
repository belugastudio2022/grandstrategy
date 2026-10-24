# Get the compiled Forge 1.16.5 JAR without installing a development environment

This is a browser-based build route using GitHub Actions. It does not require installing Java, Gradle, or an IDE on your PC, but it does require a GitHub account and an internet connection. No JAR is included here because the isolated build environment used to prepare this package could not download Gradle/Forge dependencies.

## One-time setup

1. Create an empty repository on GitHub (a private repository is fine).
2. Upload `grandstrategy-step1.zip` to the repository root. Keep that exact filename.
3. In the repository, choose **Add file → Create new file**.
4. Name the file `.github/workflows/build.yml`.
5. Open the included `build.yml` from this kit, copy all its contents into the GitHub editor, and commit the file to the default branch (`main` or `master`).
6. GitHub Actions should start automatically after the commit. Alternatively, open the **Actions** tab, select **Build Grand Strategy Forge 1.16.5**, then choose **Run workflow**.
7. Open the completed workflow run and download the artifact named `grandstrategy-forge-1.16.5` from the **Artifacts** section.
8. Extract the downloaded artifact ZIP. Put the contained `grandstrategy-1.0.0.jar` in `.minecraft/mods`. Make sure Minecraft is launched with Forge 1.16.5 (preferably Forge 36.2.39).

## If the build fails

Open the failed workflow run, expand the **Build mod JAR** step, and inspect the first Gradle error. A failed remote build means no usable mod JAR was produced; do not put the source ZIP or a renamed file into `mods`.
