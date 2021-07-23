package dev.fabula.android.splash

import android.content.Context
import androidx.work.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.joinAll
import retrofit2.Retrofit
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RefreshDataWork(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    @Inject
    lateinit var retrofit: Retrofit

    init {
        SplashComponent.create(context)
            .inject(this)
    }

    override suspend fun doWork(): Result {
        return coroutineScope {
            try {
                joinAll(

                )
                Timber.w("Refresh data Success!")
                Result.success()
            } catch (error: Throwable) {
                Timber.e(error, "Refresh data Failed!")
                Result.failure()
            }
        }
    }

    companion object {

        fun start(context: Context): UUID {
            // Create the Constraints
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            // Define the input
            val imageData = workDataOf()

            // Bring it all together by creating the WorkRequest; this also sets the back off criteria
            val uploadWorkRequest = OneTimeWorkRequestBuilder<RefreshDataWork>()
                .setInputData(imageData)
                .setConstraints(constraints)
                .setBackoffCriteria(
                    BackoffPolicy.LINEAR,
                    OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                    TimeUnit.MILLISECONDS
                )
                .build()

            // Enqueue work request
            WorkManager.getInstance(context).enqueue(uploadWorkRequest)
            return uploadWorkRequest.id

        }
    }

}