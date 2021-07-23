package dev.fabula.android.report.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.fabula.android.app.di.ViewModelKey
import dev.fabula.android.app.di.ViewModelModule
import dev.fabula.android.report.ui.ReportViewModel

@Module(includes = [ViewModelModule::class])
abstract class ReportModule {

    @Binds
    @IntoMap
    @ViewModelKey(ReportViewModel::class)
    abstract fun bind(viewModel: ReportViewModel): ViewModel
}
