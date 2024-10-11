import kotlin.test.Test
import kotlin.test.assertEquals

class ContainerWithMostWater {

    var solution = SolutionContainerWithMostWater()

    @Test
    fun baseCase() {
        assertEquals(solution.maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)), 49)
        assertEquals(solution.maxArea(intArrayOf(1,1)), 1)
    }

    @Test
    fun extraCase(){
        assertEquals(solution.maxArea(intArrayOf(2,3,4,5,18,17,6)), 17)
        assertEquals(solution.maxArea(intArrayOf(0,14,6,2,10,9,4,1,10,3)), 70)
    }

    @Test
    fun outOfIndex(){
        assertEquals(solution.maxArea(intArrayOf(4,3,2,1,4)), 16)
        assertEquals(solution.maxArea(intArrayOf(0,2)), 0)
    }

}