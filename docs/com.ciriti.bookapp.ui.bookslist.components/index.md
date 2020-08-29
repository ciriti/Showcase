//[project](../index.md)/[com.ciriti.bookapp.ui.bookslist.components](index.md)



# Package com.ciriti.bookapp.ui.bookslist.components  


## Types  
  
|  Name|  Summary| 
|---|---|
| [BaseState](-base-state/index.md)| [androidJvm]  <br>Content  <br>sealed class [BaseState](-base-state/index.md)  <br><br><br>
| [Book4View](-book4-view/index.md)| [androidJvm]  <br>Brief description  <br>In this case the fields of the view model are the of the service model  <br>Content  <br>data class [Book4View](-book4-view/index.md)(**rank**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),**weeksOnList**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),**primaryIsbn10**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**title**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**author**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))  <br><br><br>
| [BookItemView](-book-item-view/index.md)| [androidJvm]  <br>Content  <br>class [BookItemView](-book-item-view/index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()constructor(**context**: [Context](https://developer.android.com/reference/android/content/Context.html),**attrs**: [AttributeSet](https://developer.android.com/reference/android/util/AttributeSet.html)?,**defStyleAttr**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [ConstraintLayout]()  <br><br><br>
| [BooksAdapter](-books-adapter/index.md)| [androidJvm]  <br>Content  <br>class [BooksAdapter](-books-adapter/index.md) : [RecyclerView.Adapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.Adapter.html)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [bind](bind.md)| [androidJvm]  <br>Content  <br>fun [BookItemView](-book-item-view/index.md).[bind](bind.md)(book: [Book4View](-book4-view/index.md), pos: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))  <br><br><br>
| [failIfEmpty](fail-if-empty.md)| [androidJvm]  <br>Content  <br>fun [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).[failIfEmpty](fail-if-empty.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [failIfNotValid](fail-if-not-valid.md)| [androidJvm]  <br>Content  <br>fun [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html).[failIfNotValid](fail-if-not-valid.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [getErrorMessage](get-error-message.md)| [androidJvm]  <br>Content  <br>fun [getErrorMessage](get-error-message.md)(throwable: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| [toBook4View](to-book4-view.md)| [androidJvm]  <br>Content  <br>fun [Book](../com.ciriti.datalayer.network/-book/index.md).[toBook4View](to-book4-view.md)(): [Book4View](-book4-view/index.md)  <br><br><br>

