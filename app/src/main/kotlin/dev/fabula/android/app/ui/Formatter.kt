package dev.fabula.android.app.ui

import android.util.Log.w
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class Formatter {

    val DateFormat.ddMMyyyyUTC: SimpleDateFormat by lazy {
        SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).apply {
            this.timeZone = TimeZone.getTimeZone("UTC")
        }
    }

    val Calendar.timeInMillisUTC: Long
        get() {
            return timeInMillis + timeZone.getOffset(timeInMillis)
        }

    val Calendar.timeUTC: Date
        get() {
            return Date(timeInMillisUTC)
        }

    val Calendar.w: Long
        get() {
            return timeInMillis + timeZone.getOffset(timeInMillis)
        }


}