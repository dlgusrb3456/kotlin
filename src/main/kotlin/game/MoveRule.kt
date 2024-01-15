package game

import java.util.concurrent.ThreadLocalRandom
import java.util.function.Supplier

enum class MoveRule(private var movable: Supplier<Boolean>) {

    MUST_MOVE(Supplier { true }),
    RANDOM(Supplier { ThreadLocalRandom.current().nextInt(10) >= 4 });

    public fun getMovable(): Supplier<Boolean> {
        return movable
    }
}

