object Solution {
    def convert(s: String, numRows: Int): String = {
        if (numRows == 1)
        	return s
        // var result : String
        var str : Array[Char] = s.toCharArray()
        var distance : Int = 0
        var distance2 :Int = 0
        var size :Int = s.length()
        for( i <- 0 to numRows-1) {
        	distance = 2 * (numRows - 1)
        	if( i != 0)
        		distance2 =  distance - 2*i
        	else
        		distance2 = 0
        	for( j <- i to size ; j+=distance) {
        		
        	}
        		
        }
        println(s{1})
        str(1) = 'c'
        var result : String  = String.copyValueOf(str)
        println(result)
        return s
    }
    def main(args: Array[String]) {
    	convert("ded",2)
    }
}