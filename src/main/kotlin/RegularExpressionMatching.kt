
// 10. Regular Expression Matching
class SolutionRegularExpressionMatching {
    fun isMatch(s: String, p: String): Boolean {
//        val strs = ArrayList(s.toCharArray().toList())
//        val chars = ArrayList(p.toCharArray().toList())
//        println("start: ${s}; ${p}")
        val ptr_str = 0
        val ptr_char = 0
        return task(s, p, ptr_str, ptr_char)
    }
    fun task(s: String, p: String, ptr_str: Int, ptr_char: Int): Boolean {
//        println("${s.substring(ptr_str)}; ${p.substring(ptr_char)}")
        try {
            if(s.length == ptr_str && p.length > ptr_char + 2) {
                if (p[ptr_char + 1] == '*')
                    return task(s, p, ptr_str, ptr_char + 2)
            }

            val result = s[ptr_str] == p[ptr_char] || p[ptr_char] == '.'
            val last_str = s.length == ptr_str + 1
            val last_reg = p.length == ptr_char + 1
            if(last_str && last_reg) return result
            val peek = p[ptr_char + 1]
            if(peek == '*') {
                if(last_str && p.length == ptr_char + 2) return result
//                println(result)
//                else if(last_str) return false
//                spawn more jobs
                if (result) {
                    if(p.length <= ptr_char + 2 && s.length <= ptr_str + 1 &&
                        (s[ptr_str + 1] == p[ptr_char + 2] || p[ptr_char + 2] == '.'))
                        return task(s, p, ptr_str + 1, ptr_char + 2)
//                    if(p.length <= ptr_char + 2 &&
//                        (s[ptr_str + 1] == p[ptr_char + 2] || p[ptr_char + 2] == '.'))
//                        return task(s, p, ptr_str + 1, ptr_char + 2)
                    if (s.length >= ptr_str + 2 && (s[ptr_str + 1] == p[ptr_char] || p[ptr_char] == '.') &&
                        p.length > ptr_char + 3 && p[ptr_char + 2] == p[ptr_char] && p[ptr_char + 3] == '*') {
//                        println("case str")
//                        return task(s, p, ptr_str + 1, ptr_char)
                        return task(s, p, ptr_str + 1, ptr_char + 2)
                    }

                }
//                return task(s, p, ptr_str, ptr_char + 2)
//                        || (result && !last_str && task(s, p, ptr_str + 1, ptr_char))
                return task(s, p, ptr_str, ptr_char + 2)
                        || (result && task(s, p, ptr_str + 1, ptr_char))
            }
            if(result) {
                return task(s, p, ptr_str + 1, ptr_char + 1)
            }
            return false
        } catch (e: Exception) {
//            println("catch ")
//            e.printStackTrace()
            try{
                if(s.length <= ptr_str + 1 && p[ptr_char + 1] == '*' && p.length == ptr_char + 2) return true
            } catch (_:Exception) {

            }
            return false
        }
    }
}

fun main(args: Array<String>) {
//    println("a" == "a")
    val sol = SolutionRegularExpressionMatching()
//    val value = sol.isMatch("ab", "a.")
//    println(value)
//    assert(value)
//    val val2 = sol.isMatch("ab", ".*")
//    val val_1 = sol.isMatch("ab", ".*")
//    println("result")
//    println(val_1)
//    println(sol.isMatch("abbfjhekjrlwer", ".*"))
//    println(sol.isMatch("aa", "a*") == true)
//    println(sol.isMatch("a", "a*a")  == true)
//    println(sol.isMatch("ba", "a*a") == false)
//    println(sol.isMatch("a", "aa") == false)
//    println(sol.isMatch("aa", "a") == false)
//    println(sol.isMatch("a", "ab*") == true)
//    println(sol.isMatch("ab", ".*c") == false)
//    println(sol.isMatch("abbaa", "a.*") == true)
//    println(sol.isMatch("abbaaee", "a.*aa") == false)
//    println(sol.isMatch("abbaaee", "ab*aaee") == true)
//    println(sol.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*c"))
//    println(sol.isMatch("acaacacaaacaa", "a*c*a*c*a*c*a*c*a*c*"))
//    println(sol.isMatch("aca", "a*c*a*c*"))
//    println(sol.isMatch("", "a*c*"))
//    println(sol.isMatch("a", "ab*"))
//    println((sol.isMatch("abbfjhekjrlwer", ".*")))
//    println(sol.isMatch("aaaaaaaaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*"))
//    println(sol.isMatch("ab", ".*.."))
//    println(sol.isMatch("ab", ".*b"))
//    println(sol.isMatch("bbab", "b*a*"))
//    println(sol.isMatch("ab", "a*"))
    println(sol.isMatch("abaabababbcbcabbcbc", "b*ab.*.*.*.b..*"))
}