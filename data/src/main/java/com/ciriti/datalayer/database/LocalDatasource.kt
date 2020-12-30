package com.ciriti.datalayer.database

import com.ciriti.datalayer.network.BooksList
import com.ciriti.datalayer.util.Logger
/**
 * Design of a local datasource
 */
interface LocalDatasource {
    suspend fun getBooks(date: String, name: String): BooksList

    companion object
}

fun LocalDatasource.Companion.create(logger: Logger/*, database : Database*/): LocalDatasource =
    LocalDatasourceImpl(logger)

private class LocalDatasourceImpl(logger: Logger) : LocalDatasource {
    override suspend fun getBooks(date: String, name: String): BooksList {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}
