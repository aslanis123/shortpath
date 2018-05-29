import java.util.Scanner

internal class Point2DKotlin(var x: Int, var y: Int) {

    override fun toString(): String {
        return this.x.toString() + "," + this.y
    }
}

object MainKotlin {


    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        println("Please Enter the M size of the chessboard: ")
        val xDimension = scanner.nextInt()
        println("Please Enter the N height size of the chessboard: ")
        val yDimension = scanner.nextInt()
        println("Please Enter the Starting point: (X,Y)")
        val startingPointArray = scanner.next().split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        println(startingPointArray.size)
        val startingPoint = Point2DKotlin(Integer.valueOf(startingPointArray[0]), Integer.valueOf(startingPointArray[1]))
        println("Please Enter the end point: (X,Y)")
        val endPointArray = scanner.next().split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val endPoint = Point2DKotlin(Integer.valueOf(endPointArray[0]), Integer.valueOf(endPointArray[1]))
        println(solve(xDimension, yDimension, startingPoint, endPoint))
    }

    private fun solve(xDimantion: Int, yDimantion: Int, startingPoint: Point2DKotlin, endPoint: Point2DKotlin): String {

        val totalSteps = calculateSteps(startingPoint.x, endPoint.x) + calculateSteps(startingPoint.y, endPoint.y)

        return "It requires $totalSteps to reach the end point"
    }

    private fun calculateSteps(starting: Int, ending: Int): Int {
        var starting = starting
        var steps = 0

        if (starting - ending > 0) {
            while (starting != ending) {
                starting--
                steps++
            }
            return steps
        } else if (starting - ending < 0) {
            while (starting != ending) {
                starting++
                steps++
            }
            return steps
        } else {
            return steps
        }
    }
}
