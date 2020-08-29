//[project](../../index.md)/[com.ciriti.bookapp.ui.bookslist.components](../index.md)/[BaseState](index.md)



# BaseState  
 [androidJvm] sealed class [BaseState](index.md)   


## Types  
  
|  Name|  Summary| 
|---|---|
| [StateError](-state-error/index.md)| [androidJvm]  <br>Content  <br>data class [StateError](-state-error/index.md)(**errorMessage**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [BaseState](index.md)  <br><br><br>
| [StateLoading](-state-loading/index.md)| [androidJvm]  <br>Content  <br>data class [StateLoading](-state-loading/index.md)(**loading**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) : [BaseState](index.md)  <br><br><br>
| [StateSuccess](-state-success/index.md)| [androidJvm]  <br>Content  <br>data class [StateSuccess](-state-success/index.md)(**data**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Book4View](../-book4-view/index.md)>) : [BaseState](index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [androidJvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [androidJvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [androidJvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| [BaseState](-state-loading/index.md)
| [BaseState](-state-success/index.md)
| [BaseState](-state-error/index.md)

