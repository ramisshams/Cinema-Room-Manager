fun main() {
    var purchase = 0
    var percentage: Double = 0.0
    var income = 0
    var totalIncome = 0
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    if (rows * seats <= 60) {
        totalIncome = rows * seats * 10
    } else {
        totalIncome = (rows / 2) * seats * 10 + (rows - rows / 2) * seats * 8
    }
    println("""
1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit""")
    var choice = readln().toInt()
    val theatre = MutableList(rows + 1) { mutableListOf<String>() }
    for (i in 1..seats) {
        theatre[0].add("$i")
    }
    theatre[0].add(0, " ")
    for (a in 1..rows) {
        repeat(seats) {
            theatre[a].add("S")
        }
        theatre[a].add(0, "$a")
    }
    while (choice in 1..3) {
        if (choice == 1) {
            println("Cinema:")
            for (u in 0..theatre.size - 1) {
                println(theatre[u].joinToString(" "))
            }
            println("""
1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit""")
            choice = readln().toInt()
        } else if (choice == 2){
            println("Enter a row number:")
            val row = readln().toInt()
            println("Enter a seat number in that row:")
            val seat = readln().toInt()
            if (row !in 1..rows || seat !in 1..seats) {
                println()
                println("Wrong input!")
                println()
                choice = 2
            } else if (theatre[row][seat] == "B") {
                println()
                println("That ticket has already been purchased!")
                println()
                choice = 2
            } else {
                if (rows * seats <= 60 || row * 2 < rows) {
                    println("Ticket price: \$10")
                    income += 10
                    theatre[row][seat] = "B"
                    purchase += 1
                    percentage += (1f / (rows.toDouble() * seats.toDouble())) * 100
                } else {
                    println("Ticket price: \$8")
                    income += 8
                    theatre[row][seat] = "B"
                    purchase += 1
                    percentage += (1f / (rows.toDouble() * seats.toDouble())) * 100
                }
                println(
                    """
1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit"""
                )
                choice = readln().toInt()
            }
        } else {
            val formatPercentage = "%.2f".format(percentage)
            println("""
Number of purchased tickets: $purchase
Percentage: $formatPercentage
Current income: ${'$'}$income
Total income: ${'$'}$totalIncome""")
            println("""
1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit""")
            choice = readln().toInt()
        }
    }
}