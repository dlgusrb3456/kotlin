package game

import data.Car
import util.ConsoleOutputUtil
import java.util.*

class RacingGame(val cars: List<Car>, val moveCount: Int) {

    fun start(rule: MoveRule) {
        ConsoleOutputUtil.printMessage("실행 결과")
        for (i in 0..<moveCount) {
            moveCars(rule)
            printCarsPosition()
        }
    }

    private fun moveCars(rule: MoveRule) {
        for (car in cars) {
            if (rule.getMovable().get()) {
                car.run()
            }
        }
    }

    private fun printCarsPosition() {
        val positionBuilder = StringBuilder()
        for (car in cars) {
            positionBuilder.append(car)
            positionBuilder.append("\n")
        }
        ConsoleOutputUtil.printMessage(positionBuilder.toString())
    }

    fun getResult(): String {
        val maxPosition: Int = Collections.max(cars).position
        return cars.filter { car -> car.position >= maxPosition }
            .joinToString(separator = ", ") { car -> car.name }
    }
}