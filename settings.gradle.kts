import java.util.Locale

if (!file(".git").exists()) {
    val errorText = """
        
        =====================[ ERROR ]=====================
         The Purpur project directory is not a properly cloned Git repository.
         
         In order to build Purpur from source you must clone
         the Purpur repository using Git, not download a code
         zip from GitHub.
         
         Built Purpur jars are available for download at
         https://purpurmc.org/downloads
         
         See https://github.com/PurpurMC/Purpur/blob/HEAD/CONTRIBUTING.md
         for further information on building and modifying Purpur.
        ===================================================
    """.trimIndent()
    error(errorText)
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

rootProject.name = "lightyear"

for (name in listOf("Lightyear-API", "Lightyear-Server")) {
    val projName = name.toLowerCase(Locale.ENGLISH)
    include(projName)
    findProject(":$projName")!!.projectDir = file(name)
}
