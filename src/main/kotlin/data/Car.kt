package data

data class Car(val name: String, var position: Int = 0) : Comparable<Car> {

    public fun run() {
        position++
    }

    override fun toString(): String {
        val builder: StringBuilder = StringBuilder(String.format("%s : ", name))
        for (i in 0..<position) {
            builder.append("-")
        }

        return builder.toString();
    }

    override fun compareTo(other: Car): Int {
        return position.compareTo(other.position)
    }
}