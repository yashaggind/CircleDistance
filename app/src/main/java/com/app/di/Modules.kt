package com.app.di

import com.app.repository.UserRepository
import com.app.ui.users.viewmodel.UserViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
            listOf(viewModelModule,
                   repositoryModule)
    )
}

val viewModelModule = module {
    viewModel { UserViewModel(userRepository = get()) }
}

val repositoryModule = module {
    single { UserRepository(androidApplication()) }
}

/*val uiHelperModule = module {
    single { UiHelper(androidContext()) }
}*/

/*val jsonReaderModule = module {
    single { JsonReaderHelper(androidApplication()) }
}*/


