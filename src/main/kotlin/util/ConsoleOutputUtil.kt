package util

class ConsoleOutputUtil {

    companion object {
        fun printMessage(message: String?) {
            println(message)
        }

        fun printError(message: String?) {
            println(String.format("[ERROR] %s", message))
        }
    }
}