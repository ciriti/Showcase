//[project](../index.md)/[com.ciriti.datalayer.network](index.md)



# Package com.ciriti.datalayer.network  


## Types  
  
|  Name|  Summary| 
|---|---|
| [Api](-api/index.md)| [androidJvm]  <br>Content  <br>interface [Api](-api/index.md)  <br><br><br>
| [ApiKeyInterceptor](-api-key-interceptor/index.md)| [androidJvm]  <br>Content  <br>class [ApiKeyInterceptor](-api-key-interceptor/index.md)(**apiKey**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Interceptor]()  <br><br><br>
| [Book](-book/index.md)| [androidJvm]  <br>Content  <br>class [Book](-book/index.md)(**rank**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),**weeksOnList**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),**primaryIsbn10**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**title**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**author**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))  <br><br><br>
| [BookNullable](-book-nullable/index.md)| [androidJvm]  <br>Content  <br>class [BookNullable](-book-nullable/index.md)(**rank**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?,**weeksOnList**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?,**primaryIsbn10**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?,**title**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?,**author**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)  <br><br><br>
| [BookRemoteDatasource](-book-remote-datasource/index.md)| [androidJvm]  <br>Content  <br>interface [BookRemoteDatasource](-book-remote-datasource/index.md)  <br><br><br>
| [BooksList](-books-list/index.md)| [androidJvm]  <br>Brief description  <br>Not Nullable model  <br>Content  <br>class [BooksList](-books-list/index.md)(**status**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),**results**: [Results](-results/index.md))  <br><br><br>
| [BooksListNullable](-books-list-nullable/index.md)| [androidJvm]  <br>Brief description  <br>Nullable model  <br>Content  <br>class [BooksListNullable](-books-list-nullable/index.md)(**status**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?,**results**: [ResultsNullable](-results-nullable/index.md)?)  <br><br><br>
| [ClientErrorException](-client-error-exception/index.md)| [androidJvm]  <br>Content  <br>class [ClientErrorException](-client-error-exception/index.md)(**message**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [RuntimeException](https://developer.android.com/reference/java/lang/RuntimeException.html)  <br><br><br>
| [ErrorMessage](-error-message/index.md)| [androidJvm]  <br>Content  <br>object [ErrorMessage](-error-message/index.md)  <br><br><br>
| [GenericException](-generic-exception/index.md)| [androidJvm]  <br>Content  <br>class [GenericException](-generic-exception/index.md)(**message**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [RuntimeException](https://developer.android.com/reference/java/lang/RuntimeException.html)  <br><br><br>
| [RedirectException](-redirect-exception/index.md)| [androidJvm]  <br>Content  <br>class [RedirectException](-redirect-exception/index.md)(**message**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [RuntimeException](https://developer.android.com/reference/java/lang/RuntimeException.html)  <br><br><br>
| [Results](-results/index.md)| [androidJvm]  <br>Content  <br>class [Results](-results/index.md)(**books**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Either]()<[Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html), [Book](-book/index.md)>>)  <br><br><br>
| [ResultsNullable](-results-nullable/index.md)| [androidJvm]  <br>Content  <br>class [ResultsNullable](-results-nullable/index.md)(**books**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[BookNullable](-book-nullable/index.md)>?)  <br><br><br>
| [ServerException](-server-exception/index.md)| [androidJvm]  <br>Content  <br>class [ServerException](-server-exception/index.md)(**message**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [RuntimeException](https://developer.android.com/reference/java/lang/RuntimeException.html)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [create](create.md)| [androidJvm]  <br>Content  <br>fun [BookRemoteDatasource.Companion](-book-remote-datasource/-companion/index.md).[create](create.md)(api: [Api](-api/index.md), logger: [Logger](../com.ciriti.datalayer.util/-logger/index.md), errorMapping: ([Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) -> [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)): [BookRemoteDatasource](-book-remote-datasource/index.md)  <br><br><br>
| [errorMapLocation](error-map-location.md)| [androidJvm]  <br>Content  <br>fun [errorMapLocation](error-map-location.md)(errorCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)  <br><br><br>
| [toBook](to-book.md)| [androidJvm]  <br>Brief description  <br>Model's extensions  <br>Content  <br>fun [BookNullable](-book-nullable/index.md).[toBook](to-book.md)(): [Book](-book/index.md)  <br><br><br>
| [toBooksList](to-books-list.md)| [androidJvm]  <br>Content  <br>suspend fun [BooksListNullable](-books-list-nullable/index.md).[toBooksList](to-books-list.md)(): [BooksList](-books-list/index.md)  <br><br><br>
| [toResults](to-results.md)| [androidJvm]  <br>Content  <br>suspend fun [ResultsNullable](-results-nullable/index.md).[toResults](to-results.md)(): [Results](-results/index.md)  <br><br><br>

