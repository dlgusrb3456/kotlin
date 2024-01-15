class Practice {
    fun printHello() {
        // how to create function and print
        println("Hello!")
    }

    fun learnVariableType() {
        // there are two types of variables
        // read-only variables with val
        // mutable variables with var
        val name = "lee hyun gyu" //만약 해당 변수에 다른 값을 넣어주면 오류가 뜸
        var age = 14 // 다른 값을 넣어줘도 오류가 뜨지는 않지만, val 타입으로 바꿔도 괜찮다고 알려줌

        println(name)
        println(age)
    }

    fun stringTemplates() {
        val name = "lhg"
        println("my name is $name")
        println("my name is ${"$name jwj"}")
        var age = 14
        println("my age is $age")
        println("my age in 2024 is ${age + 1}")
    }

    fun basicTypes() {
        //integer, unsigned-integer, floating-point numbers, booleans, characters, strings
        // integer : Byte, Short, Int, Long
        // U-integer : UByte, UShort, UInt, ULong
        // floating-number : Float, Double
        // Booleans: Boolean
        // Characters : Char
        // Strings : String

        //또한 코틀린에서는 변수를 선언만 해두고 초기화는 나중에 해도 됨 (단, 쓰이기 전까지.)

        val age: Int
        age = 14
        val name: String = "lhg"
    }

    fun collections() {
        //1. Lists: Ordered Collections of items
        //2. Sets: Unique unordered collections of items
        //3. Maps: Sets of key-value pairs where keys are unique and map to only one value
        // each collections can be mutable or read-only

        //listOf. by read-only.
        val readOnlyList = listOf("lhg", "jwj", 13)
        println(readOnlyList)

        //만약 타입을 명시해야 한다면 아래와 같이
        val readOnlyListWithType: List<String> = listOf("lhg", "jwj", "jjj")
        println(readOnlyListWithType)

        //mutableListOf. mutable list
        val mutableList = mutableListOf("lhg", "jwj", 13)
        mutableList.add(true)
        println(mutableList)
        mutableList.removeIf { name -> name == "lhg" }
        println(mutableList)
        val mutableList2 = mutableListOf(13)
        mutableList.removeAll(mutableList2)
        println(mutableList)

        //또한 만약 mutable한 값을 사용 후 추가적인 값 수정을 원치 않는다면 아래와 같이 mutable한 collection을 mutable하지 않게 casting함
        val shapes: MutableList<String> = mutableListOf("triangle", "square", "circle")
        val shapesLocked: List<String> = shapes

        //set,map도 마찬가지 맥락으로 setOf(), mutableSetOf()로 나뉨

    }
//    collections()

    fun control_flow() {
        // 조건문으로 if, when이 존재하는데 when을 추천함.
        // 둘의 사용법은 기타 문법과 크게 다르지 않음
        // when이 java의 switch와 비슷한 느낌 아래임. 와 같이 사용함
        // 조건문을 사용하는 경우
        val age = 13
        val state = when {
            age < 0 -> "baby"
            age < 20 -> "child"
            else -> "adult"
        }
        // 특정 값 매칭으로 따지는 경우
        println(state)
        val sex = "man"
        val state2 = when (sex) {
            "man" -> "boy"
            "woman" -> "girl"
            else -> "what the fuck!"
        }
        println(state2)


        // 반복문으로는 for, while, do-while이 사용됨
        // 이것도 크게 다르지 않음.
    }
//    control_flow()

    fun function() {
        //기본적으로 생성하는 방법
        fun sum(x: Int, y: Int): Int {
            return x + y
        }
        println(sum(3, 4))
        // it can be more shorten
        fun sumWithShort(x: Int, y: Int) = x + y
        println(sumWithShort(4, 5))

        //name parameter
        fun log(subject: String, body: String): String {
            return "[$subject]: $body"
        }
        println(log(body = "my name is lackm", subject = "name"))

        //default parameter
        fun log_with_default(subject: String, body: String, date: String = "0000-00-00"): String {
            return "[$subject]: $body when: $date"
        }
        println(log_with_default(body = "my name is lackm", subject = "name"))
        println(log_with_default(body = "my name is lackm", date = "2023-09-12", subject = "name"))

        //lamda expression
        println({ str: String -> str.uppercase() }("hello"))
        //사실 println() 람다임. 단, 파라미터가 없을 뿐임. 그래서 ->이 필요 없음

        //이렇게 filter도 가능
        val names = listOf("lhg", "jwj", "fff")
        val name = names.filter { name -> name == "lhg" }
        println(name)

        //혹은 map으로 collection 내부의 값을 바꿀수도 있음
        val numbers: List<Int> = listOf(1, 2, 3)
        val doubles = numbers.map { x -> x * 2 }
        val doublesOnlyUnder3 = numbers.filter { x -> x < 3 }.map { x -> x * 2 }
        println(doubles)
        println(doublesOnlyUnder3)

        //람다 표현을 함수의 return으로 지정할 수 있음. 만약 아래와 같은 경우 람다 함수에서 각각 파라미터로 오는 값(value)을 아래와 같은 수식으로 사용한다. 라는 뜻.
        fun toSeconds(time: String): (Int) -> Int = when (time) {
            "hour" -> { value -> value * 60 * 60 }
            "minute" -> { value -> value * 60 }
            "second" -> { value -> value }
            else -> { value -> value }
        }

        val timesInMinutes = listOf(2, 10, 15, 1)
        val min2sec = toSeconds("minute")
        val totalTimeInSeconds = timesInMinutes.map(min2sec).sum()
        println("Total time is $totalTimeInSeconds secs")
    }
    //function()

    fun classTest() {
        data class testClass(val name: String, var age: Int)

        val personA = testClass("lhg",13)
        val personB = personA.copy()
        println(personA.hashCode())
        println(personB.hashCode())

        personB.age=14
        println(personA.hashCode())
        println(personB.hashCode())
        println(personA)
        println(personB)
        personB.age=13
        println(personA.hashCode())
        println(personB.hashCode())

        //kotlin : 갖고 있는 값이 동일한지 검사 : ==
        //kotlin : 메모리상 같은 객체인지 검사 : ===
    }

    fun nullTest() {
        val nonNullString: String = "i'm not a null"
        val nullableString: String? = null

        println(nullableString)

        //return값도 null일수 있음을 표현
        fun lengthString(maybeString: String?): Int? = maybeString?.length

        var nullString: String? = null
        println(lengthString(nullString))

        //혹은 아래와 같이 기본 값을 넣어줌
        var nullString2: String? = null
        println(nullString2?.length ?: 0)
    }
}