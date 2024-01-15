package util

import java.util.function.Supplier

class RetryUtil {

    companion object {
        fun <T> retry(logic: Supplier<T>) : T {
            while (true) {
                try {
                    return logic.get()
                } catch (e: IllegalArgumentException) {
                    ConsoleOutputUtil.printError(e.message)
                }
            }
        }
    }
}