import console.ScannerInputModule
import data.RacingDataManager
import game.MoveRule
import game.RacingGame
import util.ConsoleOutputUtil
import util.RetryUtil

fun main() {

    try {
        RacingDataManager(ScannerInputModule()).use { racingDataManager ->
            val cars = RetryUtil.retry {
                racingDataManager.getRacingCarList(
                    "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
                )
            }
            val moveCount = RetryUtil.retry {
                racingDataManager.getRacingMoveCount("시도할 회수는 몇회인가요?")
            }

            val game = RacingGame(cars, moveCount)
            game.start(MoveRule.RANDOM)
            println(game.getResult())
            ConsoleOutputUtil.printMessage(String.format("최종 우승자 : %s", game.getResult()))
        }
    } catch (e: Exception) {
        ConsoleOutputUtil.printError("알 수 없는 오류가 발생하였습니다. 다시 실행해주세요.")
    }
}

