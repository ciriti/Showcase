package com.ciriti.bookapp.di

import com.ciriti.bookapp.BuildConfig
import com.ciriti.bookapp.ui.bookslist.BooksListUseCase
import com.ciriti.bookapp.ui.bookslist.BooksListViewModel
import com.ciriti.bookapp.ui.bookslist.create
import com.ciriti.datalayer.network.Api
import com.ciriti.datalayer.network.BookRemoteDatasource
import com.ciriti.datalayer.network.create
import com.ciriti.datalayer.network.errorMapLocation
import com.ciriti.datalayer.service.BooksService
import com.ciriti.datalayer.service.create
import com.ciriti.datalayer.util.Logger
import com.ciriti.datalayer.util.create
import com.ciriti.datalayer.util.createAdapter
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

object ModuleKey {
    const val KEY_LOGGER = "logger"
    const val KEY_ERROR_MAPPING = "error_mapping"
    const val KEY_API = "api"
    const val KEY_BOOKS_REMOTE_DS = "books_remote_datasource"
    const val KEY_BOOKS_LOCAL_DS = "books_local_datasource"
    const val KEY_BOOKS_SERVICE = "key_books_service"
    const val KEY_BOOKS_USE_CASE = "key_books_use_case"
    const val KEY_BOOKS_VIEW_MODEL = "key_books_view_model"
}

val bookListModule = module {

    // UseCase
    viewModel(qualifier = named(ModuleKey.KEY_BOOKS_VIEW_MODEL)) {
        BooksListViewModel(useCase = get(qualifier = named(ModuleKey.KEY_BOOKS_USE_CASE)))
    }

    // UseCase
    factory(qualifier = named(ModuleKey.KEY_BOOKS_USE_CASE)) {
        BooksListUseCase.create(
            booksService = get(qualifier = named(ModuleKey.KEY_BOOKS_SERVICE))
        )
    }

    // Book Service
    single(qualifier = named(ModuleKey.KEY_BOOKS_SERVICE)) {
        BooksService.create(
            netDatasource = get(qualifier = named(ModuleKey.KEY_BOOKS_REMOTE_DS)),
            logger = get(qualifier = named(ModuleKey.KEY_LOGGER))
        )
    }

    // Remote Datasource
    single(qualifier = named(ModuleKey.KEY_BOOKS_REMOTE_DS)) {
        /** production object */
        BookRemoteDatasource.create(
            api = get(qualifier = named(ModuleKey.KEY_API)),
            logger = get(qualifier = named(ModuleKey.KEY_LOGGER)),
            errorMapping = get(qualifier = named(ModuleKey.KEY_ERROR_MAPPING))
        )
    }

    single<(Int) -> Throwable>(qualifier = named(ModuleKey.KEY_ERROR_MAPPING)) {
        { e: Int -> errorMapLocation(e) }
    }

    // Retrofit adapter
    single(qualifier = named(ModuleKey.KEY_API)) {
        Retrofit.Builder().createAdapter<Api>(BuildConfig.URL)
    }

    // Logger
    single(qualifier = named(ModuleKey.KEY_LOGGER)) { Logger.create() }
}
