import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit
import kotlin.test.Test
import kotlin.test.assertEquals

// 10. Regular Expression Matching
class RegularExpressionMatching {
    val sol = SolutionRegularExpressionMatching()

    @Test
    fun baseCases() {
        assertEquals(sol.isMatch("abbfjhekjrlwer", ".*"), true)
        assertEquals(sol.isMatch("aa", "a*"), true)
        assertEquals(sol.isMatch("a", "a*a") , true)
        assertEquals(sol.isMatch("ba", "a*a"), false)
        assertEquals(sol.isMatch("a", "aa"), false)
        assertEquals(sol.isMatch("aa", "a"), false)
        assertEquals(sol.isMatch("a", "ab*"), true)
        assertEquals(sol.isMatch("ab", ".*c"), false)
        assertEquals(sol.isMatch("abbaa", "a.*"), true)
        assertEquals(sol.isMatch("abbaaee", "a.*aa"), false)
        assertEquals(sol.isMatch("abbaaee", "ab*aaee"), true)
    }

    @Test
    @Timeout(value=5, unit=TimeUnit.SECONDS)
    fun computation() {
        assertEquals(sol.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*c"), false)
    }

    @Test
    @Timeout(value=5, unit=TimeUnit.SECONDS)
    fun computation2() {
        assertEquals(sol.isMatch("aaaaaaaaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*"), false)
    }

    @Test
    fun test() {
        assertEquals(sol.isMatch("acaacacaaacaa", "a*c*a*c*a*c*a*c*a*c*"), true)
    }

    @Test
    fun additionalTest() {
        assertEquals(sol.isMatch("bbab", "b*a*"), false)
        assertEquals(sol.isMatch("ab", "a*"), false)
    }

    @Test
    fun backTrack() {
        assertEquals(sol.isMatch("ab", ".*.."), true)
    }

    @Test
    fun backTrackDot() {
        assertEquals(sol.isMatch("b", ".*b"), true)
        assertEquals(sol.isMatch("ab", ".*b"), true)
        assertEquals(sol.isMatch("aaaaaab", ".*b"), true)
    }
    @Test
    fun backTrackDot2() {
        assertEquals(sol.isMatch("abaabababbcbcabbcbc", "b*ab.*.*.*.b..*"), true)
    }


}