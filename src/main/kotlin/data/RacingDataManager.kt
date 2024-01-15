package data

import console.InputModule
import util.ConsoleOutputUtil
import java.util.*

class RacingDataManager(private val inputModule: InputModule) : AutoCloseable {

    public fun getRacingCarList(message: String): List<Car> {
        ConsoleOutputUtil.printMessage(message)
        val carNames: List<String> = inputModule.receiveStringArrayValue(",")
        validCarNames(carNames)
        return carNames.map { car -> Car(car) }
    }

    public fun getRacingMoveCount(message: String): Int {
        try {
            ConsoleOutputUtil.printMessage(message)
            val moveCount = inputModule.receiveIntValue();
            validMoveCount(moveCount)
            return moveCount
        } catch (e: InputMismatchException) {
            throw IllegalArgumentException("시도 횟수는 숫자여야 한다.")
        }
    }


    private fun validCarNames(carNames: List<String>) {
        if (carNames.size < 2) {
            throw IllegalArgumentException("자동차는 2대 이상이어야 한다.")
        }

        for (carName in carNames) {
            if (carName.isBlank()) {
                throw IllegalArgumentException("자동차의 이름은 공백일 수 없다.");
            }
            if (carName.length > 5 || carName.isEmpty()) {
                throw IllegalArgumentException("자동차의 이름은 1자 이상 5자 이하만 가능하다.");
            }
        }
    }

    private fun validMoveCount(count: Int) {
        if (count <= 0) {
            throw IllegalArgumentException("시도 횟수는 양수여야 한다.")
        }
    }

    override fun close() {
        this.inputModule.close()
    }
}