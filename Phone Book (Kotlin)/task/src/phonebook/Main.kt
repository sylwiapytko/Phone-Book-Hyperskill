package phonebook

import java.io.File
import kotlin.time.Duration.Companion.milliseconds

fun main() {

    val fileName = "directory.txt"
    val directoryLines = readFile(fileName)
    val findFileName = "find.txt"
    val findLines = readFile(findFileName)

    val directorySize = directoryLines.size
    val findSize = findLines.size

    var countFound = 0

    val startTime = System.currentTimeMillis()
    println("Start searching...")
    for (findLine in findLines) {
        for (directoryLine in directoryLines) {
            if (findLine.filter { it.isLetter() } == directoryLine.filter { it.isLetter() }) countFound++
        }
    }
    val findTime = (System.currentTimeMillis() - startTime)
    val minutes = findTime.milliseconds.inWholeMinutes
    val seconds = findTime.milliseconds.inWholeSeconds % 60
    val miliseconds = findTime % 1000
    println("Found $countFound / $findSize. Time taken: $minutes min.  $seconds sec. $miliseconds ms.")
}

private fun readFile(fileName: String): List<String> {
    val directoryName = "C:\\Users\\sayo\\Downloads\\"
    val fullFileName = directoryName + fileName
    val lines = File(fullFileName).readLines()
    return lines
}
