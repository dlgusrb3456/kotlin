package console

import java.io.UncheckedIOException

interface InputModule {

    fun receiveStringArrayValue(regex: String) : List<String> {
        return this.receiveStringValue().split(regex)
    }

    fun receiveStringValue() : String

    fun receiveIntValue() : Int

    @Throws(UncheckedIOException::class)
    fun close()
}