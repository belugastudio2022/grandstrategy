# Grand Strategy — Step 1 (Minecraft Forge 1.16.5)

This starter project contains the main mod entry point, client-side `M` key binding, a first-pass realm overview screen, and English/Russian translations.

## Target versions

- Minecraft 1.16.5
- Forge 1.16.5-36.2.39
- Java 8 source/target compatibility
- MCP snapshot mappings: `20210309-1.16.5`

The MCP snapshot mappings are intentional: the sources use `TranslationTextComponent`, `KeyBinding`, `InputMappings`, `MatrixStack`, `Minecraft#displayGuiScreen`, and other 1.16.5 names from that mapping set.

## Build setup

The source project is supplied without the Gradle wrapper JAR/scripts. For the most reliable setup, extract the official Forge 1.16.5-36.2.39 MDK and use its `gradlew` / `gradlew.bat` and `gradle/` wrapper directory with this project's source and Gradle configuration. Alternatively, open it with a Gradle 6.x installation compatible with ForgeGradle 4.1.

Run a client from the project root:

```text
./gradlew genIntellijRuns
./gradlew runClient
```

On Windows, use `gradlew.bat` instead of `./gradlew`. The `genIntellijRuns` step is optional for IDEs that configure Forge runs another way.

Build the mod JAR:

```text
./gradlew build
```

The built JAR will be in `build/libs/`.

## Test in Minecraft

1. Start a client using the Forge run configuration.
2. Enter a world.
3. Press **M**. The Realm Overview screen should open.
4. Open **Options → Controls → Key Binds** and change the binding under **Grand Strategy**.
5. Change the Minecraft language to English (US) or Русский to inspect localization.

## File map

```text
src/main/java/com/example/grandstrategy/
├── GrandStrategyMod.java
└── client/
    ├── ClientModEvents.java
    ├── ClientTickHandler.java
    └── gui/
        └── RealmOverviewScreen.java

src/main/resources/
├── META-INF/mods.toml
├── pack.mcmeta
└── assets/grandstrategy/lang/
    ├── en_us.json
    └── ru_ru.json
```

The screen's tab labels are visual placeholders in Step 1, not interactive tabs yet. The `isPauseScreen()` override keeps the game world running while the screen is open.
