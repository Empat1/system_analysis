import java.io.File

class Main {

//    val path = "E:\\home\\учеба\\Английский\\Прочие\\субтитры\\shrek.txt"
//    val path = "E:\\home\\учеба\\Английский\\Прочие\\субтитры\\finding_nemo.txt"
    val path = "E:\\home\\учеба\\Английский\\Прочие\\субтитры\\walle.txt"


    fun main() {
        val file = File(path)
        var text = HashMap<String , Int>();
        var word = HashMap<String , Int>();
        val arr = ArrayList<String>()

        file.forEachLine {
            it.toLowerCase().split(' ' , ',' , '!' , '?' , '-' , '.' , '\'', '\"' , '<' , '>',
                '/' , '(' , ')')
                .forEach {
                if(text.get(it) == null){
                    text[it] =  1
                }else{
                    text[it] = text[it]!! + 1
                }
        }}


        for(a in text){
            try {
                var v= a.key.toCharArray();
                (v.get(0) + "" + v.get(1)).toInt()


            }catch (e :java.lang.NumberFormatException){
                word[a.key] = a.value
            }catch (e : ArrayIndexOutOfBoundsException){

            }

        }


        word.entries.sortedBy { it.value }
            .forEach{ println("${it.key} + ${it.value}")}
        println("Всего слов ${word.size}")
    }



}

//data class word(var count:Int , var word: String , var translate: String)