package console

import java.util.*

class ScannerInputModule : InputModule {

    private val scanner : Scanner = Scanner(System.`in`)

    override fun receiveStringValue(): String {
        return scanner.nextLine()
    }

    override fun receiveIntValue(): Int {
        return try {
            scanner.nextInt()
        } finally {
            scanner.nextLine()
        }
    }

    override fun close() {
        scanner.close()
    }
}