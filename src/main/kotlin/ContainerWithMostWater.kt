import kotlin.math.max
import kotlin.math.min

// Container with most water

class SolutionContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var ptrLeft = 0
        var ptrRight = 1
        var currentBest = getCurrent(height, ptrLeft, ptrRight)
        var current = true
        var updated = false
        var currentLeft = ptrLeft
        var currentRight = ptrRight

        while (true) {
            if(currentLeft >= currentRight || currentRight >= height.size) break
            val flag = !updated && (height[currentLeft] != 0) && (height[currentRight] != 0)
            if (current) {
                currentRight++
            }
            else {
                currentLeft++
                if(currentLeft < currentRight && height[currentLeft] >= height[ptrLeft]) {
                    ptrLeft = currentLeft
                    currentRight = currentLeft + 1
                    current = true
                    updated = true
                }

            }

            if(currentLeft >= currentRight) {
                current = true
                if(flag) break
                updated = false
                currentRight = currentLeft + 1
                continue
            } else if (currentRight >= height.size) {
                current = false
                if(flag) break
                updated = false
                currentLeft = ptrLeft
                currentRight = ptrRight
                continue
            }

            val best = getCurrent(height, currentLeft, currentRight)
            if(best > currentBest) {
                updated = true
                currentBest = best
                if (current) {
                    ptrRight = currentRight
                }
                else {
                    ptrLeft = currentLeft
                }
            }
        }
        return currentBest
    }

    fun bruteForce(height: IntArray): Int {
        var best = getCurrent(height, 0, 1)
        for (i in 0..height.size - 2) {
            for (j in i + 1..<height.size) {
                val current = getCurrent(height, i, j)
                if (current >= best) {
                    best = current
                }
            }
        }
        return best
    }

    fun getCurrent(height: IntArray, ptrLeft: Int, ptrRight: Int): Int {
        return min(height[ptrLeft], height[ptrRight]) * (ptrRight - ptrLeft)
    }
}

fun main() {
    var solution = SolutionContainerWithMostWater()
//    49
//    println(solution.maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
//    println(solution.maxArea(intArrayOf(2,3,4,5,18,17,6)))
//    println(solution.bruteForce(intArrayOf(2,3,4,5,18,17,6)))
//    println(solution.bruteForce(intArrayOf(4,3,2,1,4)))
//    println(solution.maxArea(intArrayOf(4,3,2,1,4)))
    println(solution.maxArea(intArrayOf(0,14,6,2,10,9,4,1,10,3)))

}