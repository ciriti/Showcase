//[project](../../index.md)/[com.ciriti.bookapp.ui.bookslist](../index.md)/[BooksListViewModel](index.md)



# BooksListViewModel  
 [androidJvm] class [BooksListViewModel](index.md)(**useCase**: [BooksListUseCase](../-books-list-use-case/index.md),**mainDispatcher**: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html),**workerDispatcher**: [CoroutineContext](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/-coroutine-context/index.html)) : [BaseViewModel](../../com.ciriti.bookapp.core/-base-view-model/index.md)   


## Functions  
  
|  Name|  Summary| 
|---|---|
| [clear](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#clear--)| [androidJvm]  <br>Content  <br>@[MainThread](https://developer.android.com/reference/kotlin/androidx/annotation/MainThread.html)()  <br>  <br>override fun [clear](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#clear--)()  <br><br><br>
| [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)| [androidJvm]  <br>Content  <br>open operator override fun [equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [getTag](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#getTag-kotlin.String-)| [androidJvm]  <br>Content  <br>open override fun <[T]() : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [getTag](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#getTag-kotlin.String-)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T]()  <br><br><br>
| [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)| [androidJvm]  <br>Content  <br>open override fun [hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [loadBooks](load-books.md)| [androidJvm]  <br>Content  <br>fun [loadBooks](load-books.md)(date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))  <br><br><br>
| [setTagIfAbsent](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#setTagIfAbsent-kotlin.String-TypeParam(bounds=[kotlin.Any])-)| [androidJvm]  <br>Content  <br>open override fun <[T]() : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [setTagIfAbsent](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#setTagIfAbsent-kotlin.String-TypeParam(bounds=[kotlin.Any])-)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), p1: [T]()): [T]()  <br><br><br>
| [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)| [androidJvm]  <br>Content  <br>open override fun [toString](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/to-string.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [job](index.md#com.ciriti.bookapp.ui.bookslist/BooksListViewModel/job/#/PointingToDeclaration/)|  [androidJvm] override var [job](index.md#com.ciriti.bookapp.ui.bookslist/BooksListViewModel/job/#/PointingToDeclaration/): [CompletableJob]()   <br>
| [liveData](index.md#com.ciriti.bookapp.ui.bookslist/BooksListViewModel/liveData/#/PointingToDeclaration/)|  [androidJvm] val [liveData](index.md#com.ciriti.bookapp.ui.bookslist/BooksListViewModel/liveData/#/PointingToDeclaration/): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)<[BaseState](../../com.ciriti.bookapp.ui.bookslist.components/-base-state/index.md)>   <br>
| [mBagOfTags](index.md#com.ciriti.bookapp.ui.bookslist/BooksListViewModel/mBagOfTags/#/PointingToDeclaration/)|  [androidJvm] @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)()  <br>  <br>override val [mBagOfTags](index.md#com.ciriti.bookapp.ui.bookslist/BooksListViewModel/mBagOfTags/#/PointingToDeclaration/): [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>?   <br>
| [mCleared](index.md#com.ciriti.bookapp.ui.bookslist/BooksListViewModel/mCleared/#/PointingToDeclaration/)|  [androidJvm] override val [mCleared](index.md#com.ciriti.bookapp.ui.bookslist/BooksListViewModel/mCleared/#/PointingToDeclaration/): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| [scope](index.md#com.ciriti.bookapp.ui.bookslist/BooksListViewModel/scope/#/PointingToDeclaration/)|  [androidJvm] override val [scope](index.md#com.ciriti.bookapp.ui.bookslist/BooksListViewModel/scope/#/PointingToDeclaration/): [CoroutineScope]()   <br>

