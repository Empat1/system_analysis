open class Matrix(val row:Int, val column:Int) {
    var array = Array(row){IntArray(column)}

    //матрица смежности
    fun isAdjacency() : Boolean{
        if(column != row) return false

        for(i in 0 until row)
            for (j in 0 until column)
                if(array[i][j] != array[j][i]) return false

        return true
    }

    fun createMatrix(arr: Array<IntArray>){
        array = arr
    }

    //Украл с https://translated.turbopages.org/proxy_u/en-ru.ru.b1be244b-637c0d9c-661ddec3-74722d776562/https/www.geeksforgeeks.org/how-to-represent-graph-using-incidence-matrix-in-java/
    open fun adjacencyMatToIncidenceMat(adj: Array<IntArray>): Array<IntArray>? {
        val vertices = adj.size
        var edges = 0

        // count number of edges in the graph
        for (i in adj.indices) {
            for (j in i + 1 until adj[i].size) {
                if (adj[i][j] > 0) edges++
            }
        }

        // construct incidence matrix
        val incidenceMat = Array(adj.size) { IntArray(edges) }
        for (i in adj.indices) {
            for (j in i + 1 until adj[i].size) {
                val edgeNumber = adj[i][j]
                if (edgeNumber > 0) {
                    incidenceMat[i][edgeNumber - 1] = 1
                    incidenceMat[j][edgeNumber - 1] = 1
                }
            }
        }
        return incidenceMat
    }


    fun print(){
        array.forEach {
            it.forEach { print("$it ") }
            println()
        }
    }
}